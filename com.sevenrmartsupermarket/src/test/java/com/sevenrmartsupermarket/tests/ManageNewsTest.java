package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class ManageNewsTest extends Base {

	ExcelReader excelReader = new ExcelReader();
	ManageNewsPage manageNewsPage;
	HomePage homepage;
	LoginPage loginPage;
	ScreenshotCapture screenshotcapture;

	@Test
	public void verifyNewCreation() {
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		manageNewsPage = new ManageNewsPage(driver);
		loginPage.login();
		homepage.clickOnTile("Manage News");
		manageNewsPage.clickNewButton();
		manageNewsPage.inputTextInNewsTextarea("check my news");
		manageNewsPage.clickSaveButton();
		excelReader.setExcelFile("News data", "NewsDetails");
		String data = excelReader.getCellData(0, 0);
		System.out.println(data);
	}
	
	@Test
	public void screenshot() {
		
	}
}
