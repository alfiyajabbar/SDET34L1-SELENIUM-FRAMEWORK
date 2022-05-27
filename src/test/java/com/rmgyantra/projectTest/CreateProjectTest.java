package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;
import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.DatabaseCentre;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.sdet32l1.genericcentre.FileCentre;
import com.sdet32l1.genericcentre.IConstantCentre;
import com.sdet32l1.genericcentre.JavaCentre;
import com.sdet32l1.genericcentre.WebDriverCentre;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest extends Baseclass{
	public static void main(String[] args) throws SQLException, InterruptedException, IOException {
		
	
	//WebDriverManager.chromedriver().setup();
	//WebDriver driver=new ChromeDriver();
	//driver.get("http://localhost:8084");
	//driver.manage().window().maximize();
		JavaCentre jc=new JavaCentre();
		FileCentre.openPropertyFile(IConstantCentre.RMGYANTRAPROPERTYFILEPATH);
		ExcelCentre.openExcel(IConstantCentre.RMGYANTRAEXCELFILEPATH);
		Long longTimeout=jc.stringToLong(FileCentre.getDataFromPropertyFile("timeOut"));
		int num=jc.getRandomNumber(1000);
		String projectname=ExcelCentre.getDataFromExcel("rmgProject",2, 1)+num;
		String createdBy=ExcelCentre.getDataFromExcel("rmgProject", 2, 2);
		ExcelCentre.closeExcel();
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
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//Random r=new Random();
	//int num=r.nextInt(10000);
	//String projectname="xyz"+num;
		WebDriverCentre.navigateApp(driver,url);
		WebDriverCentre.maximizeBrowser(driver);
		WebDriverCentre.browserSetting(longTimeout, driver);
	driver.findElement(By.id("usernmae")).sendKeys(FileCentre.getDataFromPropertyFile("UserName"),Keys.TAB,FileCentre.getDataFromPropertyFile("Password"),Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.className("material-icons")).click();
	driver.findElement(By.cssSelector("[name='projectName']")).sendKeys(projectname);
	driver.findElement(By.name("createdBy")).sendKeys(createdBy);
	
	WebElement projectstatus=driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
	WebDriverCentre.initializeSelect(projectstatus);
	WebDriverCentre.dropdownByVisibleText("Created");
			//Select s=new Select("Created");
			//s.selectByVisibleText("Created");
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			FileCentre.openPropertyFile(IConstantCentre.RMGYANTRAPROPERTYFILEPATH);
			DatabaseCentre.openDBConnection(IConstantCentre.DATABASEURL+FileCentre.getDataFromPropertyFile("dbName"),FileCentre.getDataFromPropertyFile("dbUserName"),FileCentre.getDataFromPropertyFile("dbPassword"));
			DatabaseCentre.getDataFromDataBase("select * from project","project_name");
			boolean status=DatabaseCentre.validateDataInDatabase("select * from project", "project_name", projectname);
			if(status==true)
			{
				System.out.println("TC passed");
			}
			else
			{
				System.out.println("Tc failed");
			}
			DatabaseCentre.closeDBConnection();
			WebDriverCentre.quitBrowser(driver);
			
			
			
//			Connection connection=null;
//			try
//			{
//				Driver driver1=new Driver();
//				DriverManager.registerDriver(driver1);
//				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
//				Statement statement=connection.createStatement();
//				ResultSet result=statement.executeQuery("select * from project;");
//				while(result.next())
//				{
//					if(projectname.equals(result.getString(4)))
//						System.out.println("project created successfully");
//					}
//			}
//			finally
//			{
//				connection.close();
//			}
//			driver.close();
				
				
				
			}
			

}

