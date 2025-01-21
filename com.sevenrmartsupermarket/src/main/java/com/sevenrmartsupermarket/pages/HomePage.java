package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	PageUtility pageUtility;

	@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//div/a[@class='d-block']")
	WebElement profileName;
	@FindBy(xpath = "//a[@class='nav-link']//p[contains(text(),'Admin Users')]")
	WebElement adminUsersOption;
	@FindBy(xpath = "//p[normalize-space()='Manage Users']")
	WebElement manageUsersOption;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public void clickOnTile(String name) {
		pageUtility = new PageUtility(driver);
		WebElement tile = driver
				.findElement(By.xpath("//div[@class='inner']//p[contains(text(),'" + name + "')]//following::a[1]"));
		pageUtility.scrollAndClick(tile);
	}
	public AdminUsersPage clickAdminUsersOption() {
		adminUsersOption.click();
		return new AdminUsersPage(driver);
	}
	public void clickManageUsersOption() {
		manageUsersOption.click();
	}
}
