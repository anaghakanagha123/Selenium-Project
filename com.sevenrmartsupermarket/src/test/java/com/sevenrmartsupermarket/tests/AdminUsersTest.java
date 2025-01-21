package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminUsersPage;

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void createNewAdminUser() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminUsersPage = homepage.clickAdminUsersOption();
		homepage.clickManageUsersOption();
		adminUsersPage.clickNewButton().enterUserName("sevenmartuser").enterPassword("sevenmart")
				.selectUserType("Staff").clickSaveButton();
		Assert.assertTrue(adminUsersPage.getAlertStatus());
	}
}
