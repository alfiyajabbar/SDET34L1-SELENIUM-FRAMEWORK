package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngAssertTest extends PractiseTestng1Test{
@Test
public void practice1Test()
{
	Reporter.log("a-practice1",true);
	Reporter.log("b-practice1",true);
	Reporter.log("c-practice1",true);
	Assert.fail();
	Reporter.log("d-practice1",true);
	Reporter.log("e-practice1",true);
	Reporter.log("f-practice1",true);
	}
@Test
public void practice2Test()
{
	Reporter.log("e-practice2",true);
	Reporter.log("d-practice2",true);
	Reporter.log("c-practice2",true);
	Assert.fail();
	Reporter.log("b-practice2",true);
	Reporter.log("a-practice2",true);
}
@Test
public void practice3Test()
{
	Reporter.log("a-practice3",true);
	Reporter.log("b-practice3",true);
	Reporter.log("c-practice3",true);
	Assert.fail();
	Reporter.log("d-practice3",true);
	Reporter.log("e-practice3",true);
}
@Test
public void practice4Test()
{
	Reporter.log("a-practice4",true);
	Reporter.log("b-practice4",true);
	Reporter.log("c-practice4",true);
	Assert.fail();
	Reporter.log("d-practice4",true);
	Reporter.log("e-practice4",true);
}





}
