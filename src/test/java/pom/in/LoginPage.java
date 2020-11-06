package pom.in;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.in.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//*[@name='email']")
	private WebElement name;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath ="//*[text()='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath ="//p[text()='Invalid login']")
	private WebElement Invalidlogin; 

	public WebElement getName() {
		return name;
	}

	public WebElement getInvalidlogin() {
		return Invalidlogin;
	}

	public WebElement getPassword() {
		return password;
	}

	public  WebElement getLoginButton() {
		return LoginButton;
	}
	
	
}
