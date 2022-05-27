package com.vtiger.practice;

import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.vtiger.elementrepository.CampaignPage;
import com.vtiger.elementrepository.CreateNewCampaignPage;

public class CampaignTest {
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
}
