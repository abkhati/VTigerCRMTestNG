package POM;

import commonUtils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtils;

public class HomePage {
	public WebDriver driver;
	

	public WebElement getCreateORGbtn() 
	{
		return createORGbtn;
	}

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationbtn;
	
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private WebElement createORGbtn;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactbtn;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactbtn;

	public WebElement getContactbtn() {
		return contactbtn;
	}

	public WebElement getCreateContactbtn() {
		return createContactbtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationbtn() {
		return organizationbtn;
	}

	public WebElement getCreateORG() {
		return createORGbtn;
	}
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public OrganizationPage createORG() {
		organizationbtn.click();
		createORGbtn.click();
		return new OrganizationPage(driver);
	}
	
	public ContactPage createContact() {
		contactbtn.click();
		createContactbtn.click();
		return new ContactPage(driver);
	}

	

}