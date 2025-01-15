package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups = {"smokeTest","regressionTest"})
	public void verifyUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.getProfileName();
		String randomUsername=GeneralUtility.getRandomName();
		System.out.println(randomUsername);
		Assert.assertEquals(homepage.getProfileName(), "Admin");
		
	}
}
