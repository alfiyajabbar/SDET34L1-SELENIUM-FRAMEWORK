package com.vtiger.practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet32l1.genericcentre.WebDriverCentre;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverCentre.initializeJs(driver);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		WebDriverCentre.maximizeBrowser(driver);
		WebDriverCentre.navigateApplicationThroughJs("http://localhost:8888");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		//js.executeScript("window.location='http://localhost:8888");
		//driver.manage().window().maximize();
		WebDriverCentre.enterDataThroughJs(driver.findElement(By.name("user_name")),"admin");
		WebDriverCentre.enterDataThroughJs(driver.findElement(By.name("user_password")),"root");
		WebDriverCentre.clickThroughJs(driver.findElement(By.id("submitButton")));
		//js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.name("user_name")),"admin");
		//js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.name("user_password")),"admin");
		//js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.id("submitButton")));
		WebDriverCentre.scrollTillElement(driver.findElement(By.xpath("//b[contains(text()'Upcoming Activities')]")));
		//js.executeScript("Window.scrollBy(0,document.body.scrollHeight)");
		//js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//b[contains(text()'Upcoming Activities')]")));
		//File src=ts.getScreenshotAs(OutputType.FILE);
		String fileName=new JavaScriptExecutor().getClass().getName();
		WebDriverCentre.takeScreeShot(fileName, driver);
		//String dateTime=new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
		//File dst=new File("./screenshot/"+fileName+"_"+dateTime+".png");
		//System.out.println(dst.getAbsolutePath());
	}

		
	}


