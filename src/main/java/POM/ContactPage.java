package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgbtn;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;
	
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	public WebElement getImgbtn() {
		return imgbtn;
	}
	
	@FindBy(name="firstname")
	private WebElement firstnametf;
	
	@FindBy(name="lastname")
	private WebElement lastnametf;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement radiobtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropDown;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement desgdd;
	
	@FindBy(id="search_txt")
	private WebElement searchTexttf;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(xpath="//a[text()='Qspiders']")
	private WebElement namelt;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement addorgbtn;


	public WebElement getDesgdd() {
		return desgdd;
	}

	public WebElement getSearchTexttf() {
		return searchTexttf;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getNamelt() {
		return namelt;
	}

	public WebElement getAddorgbtn() {
		return addorgbtn;
	}

	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement accountbtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutlnk;
	
	public ContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstnametf() {
		return firstnametf;
	}

	public WebElement getLastnametf() {
		return lastnametf;
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
	
	public void addContact(String first,String last) {
		firstnametf.sendKeys(first);
		lastnametf.sendKeys(last);
		radiobtn.click();
	}
	
	public void saveContact(WebDriver driver) throws InterruptedException {
		savebtn.click();
		Thread.sleep(3000);
		
		
		
	}
	
	public LoginPage logOut(WebDriver driver) {	
		imgbtn.click();
		signoutbtn.click();
	    return new LoginPage(driver);
	}
	

}