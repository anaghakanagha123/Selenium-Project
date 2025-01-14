package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenshotCapture {
	TakesScreenshot takesScreenshot;
	
	public void takeScreenshot(WebDriver driver, String imageName) {
		try {
			String timeStamp=new  SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			takesScreenshot=(TakesScreenshot) driver;
			String path=Constants.SCREENSHOT_FILE_PATH+imageName+"-"+timeStamp+".png";
			File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);// capture screenshot code
			File destination=new File(path);// move the screenshot to this path
			FileHandler.copy(screenShot, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
