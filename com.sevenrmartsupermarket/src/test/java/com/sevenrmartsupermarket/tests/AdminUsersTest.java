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

	@Test(groups = "regressionTest")
	public void createNewAdminUser() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.login();
		homepage.clickAdminUsersOption();
		homepage.clickManageUsersOption();
		adminUsersPage.clickNewButton();
		adminUsersPage.enterUserName("sevenmartuser");
		adminUsersPage.enterPassword("sevenmart");
		adminUsersPage.selectUserType("Staff");
		adminUsersPage.clickSaveButton();
		Assert.assertTrue(adminUsersPage.getAlertStatus());
	}
}
