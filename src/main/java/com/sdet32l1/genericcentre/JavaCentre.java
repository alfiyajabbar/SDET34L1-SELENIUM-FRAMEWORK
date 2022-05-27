package com.sdet32l1.genericcentre;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author Mypc
 *
 */
public class JavaCentre {
/**
 * This method is used to convert string value to long datatype
 * @param value
 * return
 */
	public long stringToLong(String value)
	{
		return Long.parseLong(value);
	}
	
	/**
	 * This method is used to get the random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit)
	{
		Random ran=new Random();
		return ran.nextInt(limit);
	}
	/**
	 * This method is used to print the statements
	 */
	
	public void printStatement(String message)
	{
		System.out.println(message);
	}
	
	/**
	 * This method is used to get the date
	 */
	public String getDateTimeInFormat()
	{
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
	}
	/**
	 * This method is used to compare with if else
	 * 
	 */
	public void assertionThroughIfCondition(String actualresult,String expectedresult,String testcasename)
	{
	if(actualresult.equalsIgnoreCase(expectedresult))
	{
		System.out.println(testcasename+"created successfully");
		System.out.println("TC pass");	
	}
	}
	
	/**
	 * This method is used to wait particular element with polling time
	 * @throws  
	 */
	public void customWait(WebElement element,long pollingTime,int duration)
	{
	int count=0;
	while(count<duration) {
		try {
			element.click();
			break;
		} 
			 catch (Exception e) {
				// TODO Auto-generated catch block
				try {
					Thread.sleep(pollingTime);
					count++;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		}
	}
	/*
	 * This method is used to compare using equals
	 */
	public void assertionThroughEquals(String actualresult,String expectedresult)
	{
		if(actualresult.equals(expectedresult))
		{
			System.out.println("successfully created");
		}
		else
		{
			System.out.println("failed");
		}
	}

}


