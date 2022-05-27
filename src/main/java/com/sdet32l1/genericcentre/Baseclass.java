package com.sdet32l1.genericcentre;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.elementrepository.HomePage;
import com.vtiger.elementrepository.LoginPage;

public class Baseclass {
public LoginPage loginpage;
public HomePage homepage;
public WebDriver driver;
public Long longTimeout;
public JavaCentre javacentre;
public int randomnumber;
public WebDriverCentre webDriverCentre;
public static WebDriver staticDriver;
public static String url;
public String browser;
/*
 * This method is used to open property and excel file
 */
	@BeforeSuite(groups="baseclass")
	public void beforesuite() throws IOException
	{
		//open database if required
		FileCentre.openPropertyFile(IConstantCentre.PROPERTYFILEPATH);
		ExcelCentre.openExcel(IConstantCentre.EXCELFILEPATH);
	}
	/*
	 * This method is used to launch browser
	 */
	//@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeclass(/*String browser*/)
	{
		javacentre=new JavaCentre();
		longTimeout=javacentre.stringToLong(FileCentre.getDataFromPropertyFile("timesout"));
	  url=System.getProperty("url");
	  browser=System.getProperty("browser");
		//String browser = FileCentre.getDataFromPropertyFile("browser");
		randomnumber=javacentre.getRandomNumber(1000);
		switch(browser)
		{
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		}
		staticDriver=driver;
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		webDriverCentre=new WebDriverCentre();
		
		WebDriverCentre.navigateApp(driver,url);
		
		WebDriverCentre.browserSetting(longTimeout, driver);
		
		webDriverCentre.initializeActions(driver);
		
	}
	/*
	 * This method is used to perform login
	 */
	@BeforeMethod(groups="baseclass")
	public void beforemethod()
	{
		loginpage.loginAction(FileCentre.getDataFromPropertyFile("username"),FileCentre.getDataFromPropertyFile("password"));
	}
	/*
	 * This method is used to signout
	 */
	@AfterMethod(groups="baseclass")
	public void aftermethod()
	{
		homepage.signOutAction(driver,webDriverCentre);
	}
	/*
	 * This method is used to close the browser
	 */
	@AfterClass(groups="baseclass")
	public void afterclass() throws IOException
	{
		ExcelCentre.writeDatatoExcel(IConstantCentre.EXCELFILEPATH);
		WebDriverCentre.quitBrowser(driver);
		
	}
	
	/*
	 * This method is used to close the excel
	 */
	@AfterSuite(groups="baseclass")
	public void aftersuite() throws IOException
	{
		ExcelCentre.closeExcel();
		
	}
	
}