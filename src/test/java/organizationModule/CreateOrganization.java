package organizationModule;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import commonUtils.BaseClass2;
import commonUtils.ExcelUtils;
import commonUtils.PropertyFileUtils;
import commonUtils.WebDriverUtils;

public class CreateOrganization extends BaseClass2 {


	@Test
	public void organization() throws IOException {
		
		
		// TODO Auto-generated method stub
		// to read the data from property file
		PropertyFileUtils fUtils =  new PropertyFileUtils();
		
		ExcelUtils eUtils = new ExcelUtils();
		String orgName = eUtils.getDataFromExcelFile("Sheet1", 1, 0)	;
		String group = eUtils.getDataFromExcelFile("Sheet1", 1, 1);
		String industry =  eUtils.getDataFromExcelFile("Sheet1", 1, 2);
	
		//String ORG= fUtils.getDataFromPropetyFile("org");
	
		WebDriverUtils wUtils = new WebDriverUtils();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
//		WebElement dd = driver.findElement(By.name("assigned_group_id"));
//		wUtils.handleDropDown(dd, industry);
		
//		WebElement  box = driver.findElement(By.name("notify_owner"));
//		wUtils.click(driver, box);
		driver.findElement(By.name("button")).click();
		

	}
	

}
