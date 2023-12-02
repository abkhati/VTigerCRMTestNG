package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement memberofbtn;
	
	@FindBy(name="search_text")
	private WebElement searchtf;
	
	@FindBy(name="search")
	private WebElement searchTextbtn;
	
	@FindBy(xpath="//a[text()='Qspiders']")
	private WebElement namelt;
	
	@FindBy(name="accountname")
	private WebElement accountnametf;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement radiobtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropDown;
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement accountbtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutlnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgbtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMemberofbtn() {
		return memberofbtn;
	}

	public WebElement getSearchtf() {
		return searchtf;
	}

	public WebElement getSearchTextbtn() {
		return searchTextbtn;
	}

	public WebElement getNamelt() {
		return namelt;
	}

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;
	
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	public WebElement getImgbtn() {
		return imgbtn;
	}
	
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addORG(String accName) {
		accountnametf.sendKeys(accName);
		radiobtn.click();
				
	}
	
	public void saveORG() throws InterruptedException {
		savebtn.click();
		Thread.sleep(3000);
		
	}

	public WebElement getAccountnametf() {
		return accountnametf;
	}

	public WebElement getRadiobtn() {
		return radiobtn;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getAccountbtn() {
		return accountbtn;
	}

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}
	
	public LoginPage logOut() {	
		imgbtn.click();
		signoutbtn.click();
	    return new LoginPage(driver);
	}

}