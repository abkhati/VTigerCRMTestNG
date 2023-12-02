package contactModule;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.BaseClass2;
import commonUtils.ExcelUtils;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtils;
import commonUtils.WebDriverUtils;


@Listeners(ListenerImplimentation.class)
public class CreateContact extends BaseClass2 {

	@Test
	public void contact() throws IOException, InterruptedException {
		//TODO Auto-generated method stub
		
		PropertyFileUtils fu= new PropertyFileUtils();
		ExcelUtils excel = new ExcelUtils();
		WebDriverUtils wd = new WebDriverUtils();
		
		// used to fail the test Script
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(actualTitle, expectedTitle);
//        Thread.sleep(3000);
        String first = excel.getDataFromExcelFile("Sheet1", 1, 3);
        String last = excel.getDataFromExcelFile("Sheet1", 1, 4);
        String Drop = excel.getDataFromExcelFile("Sheet1", 1, 1);
               
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(first);
		driver.findElement(By.name("lastname")).sendKeys(last);
        driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		
		WebElement drop = driver.findElement(By.name("assigned_group_id"));
		
		wd.handleDropDown(drop, Drop);
		
		WebElement drop2 = driver.findElement(By.name("salutationtype"));
		
		wd.handleDropDown(drop2, 1);
		WebElement Save = driver.findElement(By.xpath("(//input[@value=\"  Save  \"])[1]"));
		wd.click(driver, Save);
		
		Thread.sleep(3000);
       
	}

}