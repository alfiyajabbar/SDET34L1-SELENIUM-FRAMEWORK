package com.vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.sdet32l1.genericcentre.ListenerImplementation.class)
public class PracticeTestngTest extends PractiseTestng1Test {
	@Test
	public void method1Test()
	{
		System.out.println("method1 running");
		Assert.fail();
		Assert.assertEquals("ck", "bk");
	}
	@Test(groups="regression")
	public void method2Test()
	
	{
		System.out.println("method2 running");
	}
	@Test(groups={"sanity","regression"})
	public void method3Test()
	{
		System.out.println("method3 running");
		
	}

}
