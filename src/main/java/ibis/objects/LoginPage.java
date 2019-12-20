package ibis.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//a[@href='#']/img")
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

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}