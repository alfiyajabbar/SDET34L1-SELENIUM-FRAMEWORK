package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet32l1.genericcentre.WebDriverCentre;

public class CreateOrganization {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement createOrganizationTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerTxt;
	
	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewOrganization(String orgname, long longTimeout, WebDriver driver)
	{
		createOrganizationTxt.sendKeys(orgname);
		saveBtn.click();
		WebDriverCentre.explicitlyWait(driver, longTimeout, headerTxt);
		
	}
	
	public void createOrgWithIndustry(String organame)
	{
		createOrganizationTxt.sendKeys(organame);
		WebDriverCentre.initializeSelect(industry);
		WebDriverCentre.dropdownByValue("Education");
		WebDriverCentre.initializeSelect(type);
		WebDriverCentre.dropdownByValue("Press");
	saveBtn.click();
	}
}
