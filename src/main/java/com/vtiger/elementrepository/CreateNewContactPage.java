package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet32l1.genericcentre.WebDriverCentre;

public class CreateNewContactPage {
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	
	@FindBy(xpath="(//img[@style='cursor:hand;cursor:pointer'])[1]")
	private WebElement addOrgName;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchOrgTxt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchOrgBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement selectedOrgName;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement expOrg;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createContact(String lastname)
	{
		lastnameTxt.sendKeys(lastname);
		 saveBtn.click();
	}
	
	
	public String createContactWithOrg(String orgname, String lastname,WebDriver driver)
	{
		createContactImg.click();
		lastnameTxt.sendKeys(lastname);
		 addOrgName.click();
		 WebDriverCentre.switchToWindowBasedOnTitle(driver,"Organizations");
		 searchOrgTxt.sendKeys(orgname);
		 searchOrgBtn.click();
		 selectedOrgName.click();
		 WebDriverCentre.switchToWindowBasedOnTitle(driver,"Contacts");
		 saveBtn.click();
		return expOrg.getText();
	}

	
}
