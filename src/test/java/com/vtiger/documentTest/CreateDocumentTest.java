package com.vtiger.documentTest;

import org.testng.annotations.Test;

import com.sdet32l1.genericcentre.Baseclass;
import com.sdet32l1.genericcentre.ExcelCentre;
import com.vtiger.elementrepository.CreateNewDocument;
import com.vtiger.elementrepository.DocumentPage;

public class CreateDocumentTest extends Baseclass{
	@Test(groups="regression")
	public void createDocumentTest() throws InterruptedException

	{
			String titlename=ExcelCentre.getDataFromExcel("Documentation", 2, 1)+randomnumber;
			String description=ExcelCentre.getDataFromExcel("Documentation", 2, 3);
			String path=ExcelCentre.getDataFromExcel("Documentation", 2, 2);
			homepage.clickDocument();
			DocumentPage documentpage=new DocumentPage(driver);
			documentpage.clickCreateDocument();
			CreateNewDocument createnewdocument=new CreateNewDocument(driver);
			String exp_title=createnewdocument.createNewDocument(titlename, driver, description, path);;
			//Thread.sleep(3000);
			javacentre.assertionThroughEquals(titlename, exp_title);
				}
	}

