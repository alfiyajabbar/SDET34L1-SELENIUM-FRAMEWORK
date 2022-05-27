package com.vtiger.contactTest;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.sdet32l1.genericcentre.FileCentre;
import com.sdet32l1.genericcentre.IConstantCentre;
import com.sdet32l1.genericcentre.JavaCentre;
import com.sdet32l1.genericcentre.WebDriverCentre;
import com.vtiger.elementrepository.ContactPage;
import com.vtiger.elementrepository.CreateContactInformationPage;
import com.vtiger.elementrepository.CreateNewContactPage;
import com.vtiger.elementrepository.HomePage;
import com.vtiger.elementrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends Baseclass{
	@Test(groups="sanity")
	public void createContactTest()
	{
		String orgname=ExcelCentre.getDataFromExcel("Contact",2,1)+randomnumber;
		String lastname=ExcelCentre.getDataFromExcel("Contact",2,1)+randomnumber;
	     ContactPage contact=new ContactPage(driver);
		 CreateNewContactPage newcontact =new CreateNewContactPage(driver);
		 CreateContactInformationPage createcontactinfo=new CreateContactInformationPage(driver);
		 homepage.clickContact();
		 contact.clickCreateContact();
		 Assert.fail();
		 newcontact.createContact(lastname);
		 String expname=createcontactinfo.getLastName();
		 javacentre.assertionThroughEquals(lastname, expname);
		/* if(lastname.equals(expname))
			 javacentre.printStatement("contact  created successfully");
		 else
			 javacentre.printStatement("contact creation failed");*/
		 }
}

