package com.vtiger.productTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import com.vtiger.elementrepository.CreateNewProductPage;
import com.vtiger.elementrepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatProductTest extends Baseclass {
	@Test(groups="regression")
	public void creatProductTest()
	{
		String productname=ExcelCentre.getDataFromExcel("product", 4, 2)+randomnumber;
		ProductPage product=new ProductPage(driver);
		CreateNewProductPage createproduct=new CreateNewProductPage(driver);
		homepage.clickProduct();
		product.clickCreateProduct();
		createproduct.createNewProduct(productname);
	}
}
		
		
		
