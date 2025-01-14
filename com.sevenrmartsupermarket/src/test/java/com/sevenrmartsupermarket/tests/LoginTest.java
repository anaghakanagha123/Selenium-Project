package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verifyUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.getProfileName();
		Assert.assertEquals(homepage.getProfileName(), "Adminrr");
	}
}
