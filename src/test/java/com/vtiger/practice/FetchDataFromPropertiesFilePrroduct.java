package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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

import com.sdet32l1.genericcentre.FileCentre;
import com.sdet32l1.genericcentre.IConstantCentre;
import com.sdet32l1.genericcentre.JavaCentre;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromPropertiesFilePrroduct {
	public static void main(String[] args) throws IOException
	{
		JavaCentre jc=new JavaCentre();
		FileCentre.openPropertyFile(IConstantCentre.PROPERTYFILEPATH);
		Long longTimeout=jc.stringToLong(FileCentre.getDataFromPropertyFile("timesout"));
		FileInputStream fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("product");
		Row row=sh.getRow(2);
		Cell cel=row.getCell(1);
		String productname=cel.getStringCellValue();
		/*Properties pobj=new Properties();
		pobj.load(fis);
		String url=pobj.getProperty("url");
		String uname=pobj.getProperty("username");
		String pwd=pobj.getProperty("password");
		String timeout=pobj.getProperty("timesout");
		String browser=pobj.getProperty("browser");
		*/
		WebDriver driver=null;
		
		switch(FileCentre.getDataFromPropertyFile("browser"))
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		driver.get(FileCentre.getDataFromPropertyFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(FileCentre.getDataFromPropertyFile("username"));
		 driver.findElement(By.name("user_password")).sendKeys(FileCentre.getDataFromPropertyFile("password"));
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.xpath("//a[text()='Products']")).click();
		 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		 driver.findElement(By.name("productname")).sendKeys(productname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(wb).perform();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 driver.close();
		 
		}
}
