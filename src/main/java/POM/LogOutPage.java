package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LogOutPage {
	public WebDriver driver;
	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbtn;
	
	public LogOutPage(WebDriver cDriver) {
		PageFactory.initElements(cDriver, this);
	}
	
	public LoginPage logOut() {
		
		logoutbtn.click();
		return new LoginPage(driver);
	}
	/*
	public WebElement getLogOut()
	{
		return logoutbtn;
	}
*/

}
