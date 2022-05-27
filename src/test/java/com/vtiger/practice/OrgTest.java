package com.vtiger.practice;

import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.vtiger.elementrepository.CreateOrgInformationPage;
import com.vtiger.elementrepository.CreateOrganization;
import com.vtiger.elementrepository.OrganizationPage;

public class OrgTest extends Baseclass{
	
	
	
		@Test(groups="regression")
		public void createorganizationTest()
		{
		String orgname=ExcelCentre.getDataFromExcel("organization", 2, 1)+randomnumber;
		homepage.clickOrganization();
		OrganizationPage organizationpage=new OrganizationPage(driver);
		organizationpage.clickCreateOrganization();
		CreateOrganization createorg=new CreateOrganization(driver);
		createorg.createNewOrganization(orgname, longTimeout, driver);
		CreateOrgInformationPage createinfopage=new CreateOrgInformationPage(driver);
		String expname=createinfopage.getOrgname();
		
		if(orgname.equals(expname))
			System.out.println("Organization created successfully");
		else
			System.out.println("Organization creation failed");
		
		}
	
	 
		@Test(groups="regression")
		public void createorganizationwithIndustry()
		{
			String orgname=ExcelCentre.getDataFromExcel("organization", 2, 1)+randomnumber;
			CreateOrganization createorg=new CreateOrganization(driver);
			OrganizationPage orgpage=new OrganizationPage(driver);
			CreateOrgInformationPage createorgInfo=new CreateOrgInformationPage(driver);
			homepage.clickOrganization();
			orgpage.clickCreateOrganization();
			createorg.createOrgWithIndustry(orgname);
			String exporg=createorgInfo.getOrgname();
			javacentre.assertionThroughEquals(orgname, exporg);
		}
	}


