package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet32l1.genericcentre.WebDriverCentre;

public class CreateNewCampaignPage {
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement createCampaignnameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchProductName;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement addProductName;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement selectedProductLink;
	
	

	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createCampaign(String campaignname)
	{
		createCampaignnameTxt.sendKeys(campaignname);
		saveBtn.click();
		
	}
	public void createCampaignWithProduct(String productname,String campaignname, WebDriver driver)
	{
	
		createCampaignnameTxt.sendKeys(campaignname);
		addProductName.click();
		WebDriverCentre.switchToWindowBasedOnTitle(driver, "Products");
		searchProductName.sendKeys(productname);
		searchBtn.click();
		selectedProductLink.click();
		WebDriverCentre.switchToWindowBasedOnTitle(driver, "Campaigns");
		saveBtn.click();
		
		
		
	}
}
