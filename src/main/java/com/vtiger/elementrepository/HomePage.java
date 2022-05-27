package com.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet32l1.genericcentre.WebDriverCentre;

public class HomePage {
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropDown;

	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorDropDown;
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signoutLink;
	
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactTab;
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentTab;
	
	public void clickContact()
	{
		contactTab.click();
	}
	
	@FindBy(linkText="Products")
	private WebElement productTab;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationTab;
	
	public void clickOrganization()
	{
		organizationTab.click();
	}
	
	public void clickDocument()
	{
		documentTab.click();
	}
	 public void clickProduct()
	 {
		 productTab.click();
	 }
	 
	 
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to click on campaign module
	 */
	public void clickCampaign(WebDriver driver,WebDriverCentre webDriverCentre)
	{
		webDriverCentre.mouseHoverOntheElement(moreDropDown);
		campaignTab.click();
	}
	/**
	 * This method is used to logout from appplication
	 * @param driver
	 */
	public void signOutAction(WebDriver driver,WebDriverCentre webDriverCentre)
	{
		webDriverCentre.mouseHoverOntheElement(administratorDropDown);
		signoutLink.click();
	}
	

	
}
