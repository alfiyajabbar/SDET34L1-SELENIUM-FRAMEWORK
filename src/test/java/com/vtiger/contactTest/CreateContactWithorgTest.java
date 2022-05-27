package com.vtiger.contactTest;

import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.vtiger.elementrepository.ContactPage;
import com.vtiger.elementrepository.CreateContactInformationPage;
import com.vtiger.elementrepository.CreateNewContactPage;
import com.vtiger.elementrepository.CreateOrganization;
import com.vtiger.elementrepository.OrganizationPage;

public class CreateContactWithorgTest extends Baseclass {
	@Test(groups="sanity")
	public void createContactWithorgTest() 
	{
	
		String orgname=ExcelCentre.getDataFromExcel("Contact", 2, 2)+randomnumber;
		String lastname=ExcelCentre.getDataFromExcel("Contact", 2, 1)+randomnumber;
		ContactPage contact=new ContactPage(driver);
		OrganizationPage organizationpage=new OrganizationPage(driver);
		CreateOrganization createorg=new CreateOrganization(driver);
		 CreateNewContactPage newcontact =new CreateNewContactPage(driver);
		 CreateContactInformationPage createcontactinfo=new CreateContactInformationPage(driver);
		homepage.clickOrganization();
		organizationpage.clickCreateOrganization();
		createorg.createNewOrganization(orgname, longTimeout, driver);
		//Thread.sleep(2000);
		homepage.clickContact();
		contact.clickCreateContact();
		newcontact.createContactWithOrg(orgname, lastname, driver);
		String exporg=createcontactinfo.getOrgname();
		javacentre.assertionThroughEquals(orgname, exporg);
		
	}
}
		
		
		
