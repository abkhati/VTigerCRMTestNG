package organizationModule;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationPage;
import commonUtils.BaseClass2;
import commonUtils.ExcelUtils;
import commonUtils.JavaUtils;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtils;
import commonUtils.WebDriverUtils;
@Listeners(ListenerImplimentation.class)
public class POMCreateOrganization extends BaseClass2 {

	@Test
	public void organization() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		PropertyFileUtils fUtils= new PropertyFileUtils();
		ExcelUtils eUtils = new ExcelUtils();
		WebDriverUtils wUtils = new WebDriverUtils();
		JavaUtils jUtils  = new JavaUtils();
		
		int random = jUtils.getRandomNumber();
		int random2 = jUtils.getRandomNumber();
	
		//TO read data from Properties file	
		
		// To read data from excel
		String ORG = eUtils.getDataFromExcelFile("Sheet1", 1, 6);
        String Drop1 = eUtils.getDataFromExcelFile("Sheet1", 1, 1);
        String childurl = eUtils.getDataFromExcelFile("Sheet1", 7, 7);
        String parenturl = eUtils.getDataFromExcelFile("Sheet1", 5, 7);
		
        // to select sp. browser driver class
        


        //Login page
        LoginPage lp = new LoginPage(driver);
        // insert username and password
        
        //Home Page
        HomePage hp = new HomePage(driver);
        
       
        String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = " Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(actualTitle, expectedTitle);
        
        // click on create orgaization
        hp.createORG();
        OrganizationPage op= new OrganizationPage(driver);
        
        
        //Add Organization
        // insert  org name
        op.addORG(ORG+random+random2);
        
        
        Thread.sleep(3000);
        // transfer the control from parent to child
        op.getMemberofbtn().click();
        wUtils.switchToWindow(driver, childurl);
        
        op.getSearchtf().sendKeys(ORG);
        op.getSearchTextbtn().click();
       // Assert to fail test Script And take Screen Shot 
//        String actualTitle1 = driver.getTitle();
//		System.out.println(actualTitle1);
//		
//		String expectedTitle1 = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
//		Assert.assertEquals(actualTitle1, expectedTitle1);
        op.getNamelt().click();
        
//       
        Thread.sleep(5000);
       
        driver.switchTo().alert().accept(); 
         
       // child to parent
        wUtils.switchToWindow(driver, parenturl);
     
        // take screen shot
        wUtils.screenshot(driver, "Organization"+ORG+random);
        //driver.switchTo().alert().accept(); 
        // 
        wUtils.handleDropDown(op.getDropDown(), Drop1);
        //Save ORG and LogOut 
        op.saveORG();
       	
	}
	
//	@Test
//	public void actitime()
//	{
//		System.out.println("Actitime");
//	}
//	
//	@Test(dependsOnMethods = "organization")
//	public void facebook()
//	{
//		System.out.println("Actitime");
//	}

}