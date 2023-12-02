package contactModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.ContactPage;
import POM.HomePage;
import POM.LoginPage;
import commonUtils.BaseClass2;
import commonUtils.ExcelUtils;
import commonUtils.JavaUtils;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtils;
import commonUtils.WebDriverUtils;
@Listeners(ListenerImplimentation.class)
public class POMCreateContact extends BaseClass2 {

	@Test
	public void contact() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		
		// To Access data from Property files
		PropertyFileUtils fUtils = new PropertyFileUtils();
		// To access the Files from Excel File
		ExcelUtils eUtils = new ExcelUtils();
		// to access the Action methods 
		WebDriverUtils wUtils = new WebDriverUtils();
		// Java Utils
		JavaUtils jUtils = new JavaUtils();
		
		// Random Nummber
		jUtils.getRandomNumber();
		// To access the Files from Excel File
		String FirstName = eUtils.getDataFromExcelFile("Sheet1", 1, 4);
        String LastName = eUtils.getDataFromExcelFile("Sheet1", 1, 3);
        String Drop1 = eUtils.getDataFromExcelFile("Sheet1", 1, 1);
        String dg =  eUtils.getDataFromExcelFile("Sheet1", 1, 5);
        String org = eUtils.getDataFromExcelFile("Sheet1", 1, 6);
        String childurl = eUtils.getDataFromExcelFile("Sheet1", 3, 7);
        String parenturl = eUtils.getDataFromExcelFile("Sheet1", 1, 7);
        String ssname = eUtils.getDataFromExcelFile("Sheet1", 3, 0) ;

        String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(actualTitle, expectedTitle);
        
        //Home Page
        HomePage hp = new HomePage(driver);
        hp.getContactbtn().click();
        hp.getCreateContactbtn().click();
        
        //Contact Page
        ContactPage cp =new ContactPage(driver);
        wUtils.handleDropDown(cp.getDesgdd(), dg);
        cp.addContact(FirstName, LastName);
        Thread.sleep(2000);
        
        // to  add Organization in contact
        
        cp.getAddorgbtn().click();
        // parent  to child
        wUtils.switchToWindow(driver, childurl);
        
        cp.getSearchTexttf().sendKeys(org);
        
        cp.getSearchbtn().click();
        
        cp.getNamelt().click();
        //child to parent
        wUtils.switchToWindow(driver, parenturl);
        //dropdown by Visual text
        wUtils.handleDropDown(cp.getDropDown(), Drop1);
        
        wUtils.screenshot(driver, "Contact"+FirstName+LastName);
        Thread.sleep(2000);
        //take screenshot
        //wUtils.screenshot(driver, ssname+FirstName+LastName);
        //save contact
        cp.getSavebtn().click();  
        

	}

}
