package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;

	Properties properties = new Properties();

	@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUsername(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	public void login(String userName, String password) {
		enterUsername(userName);
		enterPassword(password);
		clickOnSignInButton();

	}

	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUsername(userName);
		enterPassword(password);
		clickOnSignInButton();
	}
}
