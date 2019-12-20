package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[contains(@id, 'USERNAME')]")
	WebElement userName;

	@FindBy(className = "password")
	WebElement password;

	@FindBy(linkText = "Login")
	WebElement login;

	public boolean backToLoginPage() {
		return userName.isDisplayed();
	}

	public void Login(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
	}

	public void click(String element) throws InterruptedException {
		switch (element) {
		case "login":
			login.click();
			break;
		}
	}
	
	public void clear(String element) throws InterruptedException {
		switch (element) {
		case "login":
			userName.clear();
			break;
		}
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}