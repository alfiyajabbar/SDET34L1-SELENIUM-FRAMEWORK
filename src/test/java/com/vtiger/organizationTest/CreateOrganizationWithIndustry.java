package com.vtiger.organizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithIndustry extends Baseclass {
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
		
		