
package com.vtiger.organizationTest;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.sdet32l1.genericcentre.FileCentre;
import com.sdet32l1.genericcentre.IConstantCentre;
import com.sdet32l1.genericcentre.JavaCentre;
import com.sdet32l1.genericcentre.WebDriverCentre;
import com.vtiger.elementrepository.CreateOrgInformationPage;
import com.vtiger.elementrepository.CreateOrganization;
import com.vtiger.elementrepository.HomePage;
import com.vtiger.elementrepository.LoginPage;
import com.vtiger.elementrepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends Baseclass {
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
}
