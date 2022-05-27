package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement createDocumentImg;
	
	public  DocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickCreateDocument()
	{
		createDocumentImg.click();
	}
	

}
