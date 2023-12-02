package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {
	//final WebDriver driver = null;
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimixe(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void implicitlyWait(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void handleDropDown(WebElement dropDown, String data)
	{
		Select s = new Select(dropDown);
		s.selectByVisibleText(data);
		
	}

	public void handleDropDown(WebElement dropDown, int indexValue)
	{
		Select s = new Select(dropDown);
	    s.selectByIndex(indexValue);
	}
	
	public void  click(WebDriver driver,  WebElement eleName)
	{
		Actions a = new Actions(driver);
		a.click(eleName);
		a.perform();
	}
	
	public void  mouseHover(WebDriver driver,  WebElement eleName)
	{
		Actions a = new Actions(driver);
		a.moveToElement(eleName);
		a.perform();
	}

	public void scrolling(WebDriver driver, int x, int y)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public String screenshot(WebDriver driver,String screenShotName) throws IOException
	{
        TakesScreenshot ts = (TakesScreenshot) driver;
		
		File fs = ts.getScreenshotAs(OutputType.FILE);
		
		LocalDateTime ldt = LocalDateTime.now();
		String datet = ldt.toString().replace(':', ';');
		
		File sFile = new  File("./VTigerPage/"+"vTiger"+screenShotName+datet+".jpg");
		
		FileUtils.copyFile(fs, sFile);
		
		return sFile.getAbsolutePath();
	}
	
	public void switchToWindow(WebDriver driver, String childurl) throws InterruptedException
	{
		Set<String> orgname = driver.getWindowHandles();
		System.out.println(orgname);
		
		for (String orgWindow : orgname) 
		{
			String allurl = driver.switchTo().window(orgWindow).getCurrentUrl();
			Thread.sleep(2000);
			System.out.println(allurl);
			
			if(allurl.contains(childurl))
			{
				break;
			}
		}
	}
	
	
	
	
	

}
