package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement exp_lastname;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement expOrgname;
	


public CreateContactInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public String getLastName()
{
	return exp_lastname.getText();
}
public String getOrgname()
{
	return expOrgname.getText();
}
}
