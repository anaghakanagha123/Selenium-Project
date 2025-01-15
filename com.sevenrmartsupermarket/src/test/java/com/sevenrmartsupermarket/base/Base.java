package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	/** driver declaration */
	public WebDriver driver;

	Properties properties = new Properties();
	ScreenshotCapture screenshotcapture = new ScreenshotCapture();

	/** initialize browser */
	public Base() {
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initialize(String browser, String url) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.manage().deleteAllCookies();
	}
	
	@BeforeMethod(enabled = true,alwaysRun = true)
	public void launchApplication() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialize(browser, url);
	}
	
	@BeforeMethod(enabled = false)
	@Parameters("browser")
	public void launchApplication(String browser) {
		String url = properties.getProperty("url");
		initialize(browser, url);
	}

	@AfterMethod(alwaysRun = true)
	public void terminateSession(ITestResult itestResult) {

		if (itestResult.getStatus() == ITestResult.FAILURE) {

			screenshotcapture.takeScreenshot(driver, itestResult.getName());
		}
	}
}
