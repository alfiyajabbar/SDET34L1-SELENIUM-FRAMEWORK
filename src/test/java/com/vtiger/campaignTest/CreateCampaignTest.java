package com.vtiger.campaignTest;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.sdet32l1.genericcentre.FileCentre;
import com.sdet32l1.genericcentre.IConstantCentre;
import com.sdet32l1.genericcentre.JavaCentre;
import com.sdet32l1.genericcentre.WebDriverCentre;
import com.vtiger.elementrepository.CampaignPage;
import com.vtiger.elementrepository.CreateNewCampaignPage;
import com.vtiger.elementrepository.CreateNewProductPage;
import com.vtiger.elementrepository.HomePage;
import com.vtiger.elementrepository.LoginPage;
import com.vtiger.elementrepository.ProductPage;

public class CreateCampaignTest extends Baseclass{
	@Test(groups="sanity")
	public void createCampaignTest()
	{
		
		String campaignname=ExcelCentre.getDataFromExcel("campaign", 2, 1)+randomnumber;
		CampaignPage campaignpage=new CampaignPage(driver);
		CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
		homepage.clickCampaign(driver, webDriverCentre);
		campaignpage.clickCreateCampaign();
		createnewcampaignpage.createCampaign(campaignname);
		
		
}

	
	}


