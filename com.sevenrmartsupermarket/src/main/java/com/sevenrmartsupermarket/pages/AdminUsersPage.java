package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageUtility;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDrowpdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUsersPage clickNewButton() {
		newButton.click();
		return this;
	 }
	 public AdminUsersPage enterUserName(String username) {
		 userNameField.sendKeys(username);
		 return this;
	 }
	 public AdminUsersPage enterPassword(String password) {
		 passwordField.sendKeys(password);
		 return this;
	}
	 public AdminUsersPage selectUserType(String value) {
		 Select select=new Select(userTypeDrowpdown);
		 select.selectByVisibleText(value);
		 return this;
	}
	 public AdminUsersPage clickSaveButton() {
		 WaitUtility waitutility=new WaitUtility(driver);
		 waitutility.waitForElementToBeClickable(saveButton, 10);
		 saveButton.click();
		 return this;
	}	
	 public boolean getAlertStatus() {
		 boolean alertStatus=successAlert.isDisplayed();
		 return alertStatus;
	}	
}

