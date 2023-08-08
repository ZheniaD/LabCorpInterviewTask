package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage extends BaseClass {

	public CustomerPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@for='done']")
	public WebElement bnt_done;

	@FindBy(xpath = "//input[@placeholder='FirstName']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='LastName']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement email;

	@FindBy(xpath = "//textarea[@placeholder='Enter your address']")
	public WebElement textArea;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	public WebElement phone;

	@FindBy(xpath = "//input[@name='submit']" )
	public WebElement btn_submit;

	@FindBy(xpath = "//label[@id='message9']")
	public WebElement msgInvalidEmail;

	@FindBy(xpath = "//label[@id='message7']")
	public WebElement msgInvalidNumber;

}