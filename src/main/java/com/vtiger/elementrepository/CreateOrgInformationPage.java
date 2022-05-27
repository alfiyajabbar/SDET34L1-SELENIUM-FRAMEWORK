package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement exporganizationTxt;
	
	public CreateOrgInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getOrgname()
	{
		return exporganizationTxt.getText();
		
	}
}
