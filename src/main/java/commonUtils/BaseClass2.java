package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POM.LoginPage;
import POM.OrganizationPage;

public class BaseClass2 {
	
	public WebDriver driver;
	public static WebDriver sDriver; // only to  take Screen Shot
	
	PropertyFileUtils fUtils= new PropertyFileUtils();
	ExcelUtils eUtils = new ExcelUtils();
	WebDriverUtils wUtils = new WebDriverUtils();
	JavaUtils jUtils  = new JavaUtils();
   
	
	@BeforeSuite
	public void  bSuiteConfig() {
		Reporter.log("- - Connect To DB - -",true);
	}
	
	@BeforeClass
	public void bClassConfig() throws IOException
	{
		Reporter.log("- - Launch The Browser - -",true);
		
		String BROWSER = fUtils.getDataFromPropetyFile("browser");
		String URL = fUtils.getDataFromPropetyFile("url");
		
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		// maximize page
		wUtils.maximize(driver);
		//add implicit wait
		wUtils.implicitlyWait(driver, 20);
		
        driver.get(URL);
		sDriver=driver;
	}
	
	
	@BeforeMethod
	public void bMethodConfig() throws IOException, InterruptedException
	{
		Reporter.log("- - Log In to Application - -",true);
		
		Thread.sleep(3000);
		
		String UN = fUtils.getDataFromPropetyFile("username");
		String PASSWORD = fUtils.getDataFromPropetyFile("password");
		
		LoginPage lp = new LoginPage(driver);
        // insert username and password
        lp.Login(UN, PASSWORD);
		
	}
	
	@AfterMethod
	public void aMethodConfig()
	{
		Reporter.log("- - Log Out Application - -",true);
		OrganizationPage op= new OrganizationPage(driver);
		
		wUtils.mouseHover(driver, op.getImgbtn());
	    //op.logOut();
	    wUtils.click(driver, op.getSignoutbtn());
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).sendKeys("dahhjhahk");
	}
	
	@AfterClass
	public void aClassConfig()
	{
		Reporter.log("- - Close the Browser - -",true);
		driver.quit();
	}
	
	@AfterSuite
	public void aSuiteConfig()
	{
		Reporter.log("- - Dis-Connect DB - -",true);
	}

}
