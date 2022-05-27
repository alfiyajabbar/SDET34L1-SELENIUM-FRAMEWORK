package com.vtiger.campaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProductTest extends Baseclass{
	@Test(groups="sanity")
	public void fetchDataFromPropertiesMoreCampaign()
	{
		
		String campaignname=ExcelCentre.getDataFromExcel("product", 4, 1)+randomnumber;
		String productname=ExcelCentre.getDataFromExcel("product", 4, 2)+randomnumber;
		
		ProductPage productpage=new ProductPage(driver);
	   CampaignPage campaignpage=new CampaignPage(driver);
		CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
		CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
		//loginpage.loginAction(FileCentre.getDataFromPropertyFile("username"),FileCentre.getDataFromPropertyFile("password"));
		homepage.clickProduct();
		productpage.clickCreateProduct();
		createnewproductpage.createNewProduct(productname);
		homepage.clickCampaign(driver, webDriverCentre);
		CampaignPage campaign=new CampaignPage(driver);
		campaign.clickCreateCampaign();
		createnewcampaignpage.createCampaignWithProduct(productname, campaignname, driver);
		
		
		 
	}
}
