package com.vtiger.practice;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.ExcelCentre;
import com.sdet32l1.genericcentre.IConstantCentre;

public class PracticeDataproviderTest {
	
@Test(dataProvider="logindata")
public void practice1Test(String username,String password)
{
	Reporter.log(username+"  ----->  "+password,true);
}
@DataProvider
public Object[][] logindata()
{
Object[][] data=new Object[8][2];

data[0][0]="username";
data[0][1]="passsword";

data[1][0]="username1";
data[1][1]="passsword1";

data[2][0]="username2";
data[2][1]="passsword2";

data[3][0]="username3";
data[3][1]="passsword3";

data[4][0]="username4";
data[4][1]="passsword4";

data[5][0]="username5";
data[5][1]="passsword5";

data[6][0]="username6";
data[6][1]="passsword6";

data[7][0]="username7";
data[7][1]="passsword7";
return data;
}
@DataProvider
public Object[][] fetchMultipledata() throws IOException
{
	ExcelCentre.openExcel(IConstantCentre.EXCELFILEPATH);
	Object[][] arr=ExcelCentre.getMultipleDataFromExcel("Multiple");
	return arr;
}
}
