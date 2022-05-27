package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PractiseTestng1Test 
{
@BeforeSuite(groups="baseclass")
public void methodBSTest()
{
	Reporter.log("beforesuite running"+Thread.currentThread().getId(),true);
}
@AfterSuite(groups="baseclass")
public void methodASTest()
{
	Reporter.log("aftersuite  running"+Thread.currentThread().getId(),true);
}
@BeforeTest(groups="baseclass")
public void methodBTTest()
{
	Reporter.log("beforetest running"+Thread.currentThread().getId(),true);
}
@AfterTest(groups="baseclass")
	public void methodATTest()
	{
	Reporter.log("aftertest running"+Thread.currentThread().getId(),true);
}
@BeforeClass(groups="baseclass")
public void methodBCTest()
{
	Reporter.log("beforeclass running"+Thread.currentThread().getId(),true);
}
@AfterClass(groups="baseclass")
public void methodACTest()
{
	Reporter.log("Afterclass running"+Thread.currentThread().getId(),true);
}
@BeforeMethod(groups="baselass")
public void methodBMTest()
{
	Reporter.log("beforemethod running"+Thread.currentThread().getId(),true);
}
@AfterMethod(groups="baseclass")
public void methodAMTest()
{
	Reporter.log("aftermethod running"+Thread.currentThread().getId(),true);
}


}


