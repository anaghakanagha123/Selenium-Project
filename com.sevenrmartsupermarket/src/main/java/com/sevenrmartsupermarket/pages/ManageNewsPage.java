package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement inputTextArea;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveButton;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void inputTextInNewsTextarea(String news) {
		inputTextArea.sendKeys(news);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

}
