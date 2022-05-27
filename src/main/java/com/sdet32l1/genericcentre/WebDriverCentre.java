package com.sdet32l1.genericcentre;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This method is used to maintain all web Driver common actions
 * @author Mypc
 *
 */
public class WebDriverCentre {
static	WebDriverWait wait;
public Actions act;
static Select select;
static JavascriptExecutor js;
static TakesScreenshot ts;
static JavaCentre javacentre=new JavaCentre();
	
/**
 * This method is used to navigate to the application
 */
	public static void navigateApp(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	/**
	 * This method is used to maximize the browser
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	
	/**
	 * This method is used to maximize he browser and implicit wait
	 */
	public static void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut,driver);
	}
	
	/**
	 * This method is used to implicitly wait till page Load
	 * @param longTimeOut
	 */
	public static void waitTillPageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to initialise Actions class method
	 * 
	 */
	public void initializeActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouse hover on the element
	 * @param morelink
	 * @param driver 
	 */
	public void mouseHoverOntheElement(WebElement morelink)
	{
		
		act.moveToElement(morelink).perform();
	}
	
	/**
	 * This method is used to quit the browser
	 */
	public static void quitBrowser(WebDriver driver)
	{
	driver.quit();
	}
	
	
	/**
	 * This method is used to double click the webelement
	 */
	public void doubleclickElement(WebElement morelink)
	{
		act.doubleClick(morelink).perform();
	}
	
	
	/**
	 * This method is used to doubleclick webpage
	 */
	public void doubleclickpage()
	{
		act.doubleClick();
	}
	
	/**This method is used to wait the control till the particular element is clickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 * 
	 */
	public static void waitUntilElementClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to initialise Select class method
	 * 
	 */
	public static void initializeSelect(WebElement element)
	{
		select=new Select(element);
	}
	
	
	
	/**
	 * This method is used to perform dropdown by value
	 */
	public static void dropdownByValue(String value )
	{
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to perform dropdown by index
	 */
	public static void dropdownByIndex(int index)
	{
		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to perform dropdown by visibleText
	 */
	public static void dropdownByVisibleText(String visibleText)
	{
		select.deselectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to perform switch in frame by using index
	 */
	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to perform switch in frame using name or id
	 */
	public static void switchToFrameBynameorid(WebDriver driver,String nameorid)
	{
	driver.switchTo().frame(nameorid);
	}
	
	/**
	 * This method is used to perform switch in frame using webelement
	 */
	public static void switchToFrameByElement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to perform switch in frame using defaultcontent
	 */
	public static void switchToFrameByDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to perform switch in frame using parent
	 */
	public static void switchToFrameByParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to initialize javascript
	 */
	public static void initializeJs(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	/**
	 * This method is used to enter data through javascript
	 */
	public static void enterDataThroughJs(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	/**
	 * This method is used to navigate application through javascript
	 */
	public static void navigateApplicationThroughJs(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * This method is used to  perform click action through java script
	 */
	public static void clickThroughJs(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * This method is used to scroo specific height
	 */
	public static void scrollToSpecificHeight(String Height)
	{
		js.executeScript("window.scrollBy(0,"+Height+")");
	}
	/**
	 * This method is used to scroll bottom
	 */
	public static void scrollToBottom(String Height)
	{
		js.executeScript("Window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This method is used to scroll upto particular element
	 */
	public static void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoVie", element);
	}
	/**
	 * This method is used to take screen shot
	 * @throws IOException 
	 */
	public static String takeScreeShot(String fileName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+fileName+"_"+javacentre.getDateTimeInFormat()+".png");
		System.out.println(dst.getAbsolutePath());
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	

	/**
	 * This method is used to wait the control till the particular element is visible
	 * @@param driver
	 * @param timeOut
	 */
	public static void explicitlyWait(WebDriver driver,long timeOut,WebElement element)
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to switch the window based ontitle
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText)
	{
		Set<String> SessionIDs=driver.getWindowHandles();
		for(String id:SessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
}

