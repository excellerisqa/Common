package kronos.objects;

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

	@FindBy(className = "kicon-caret-right")
	WebElement okButton;

	public boolean backToLoginPage() {
		return userName.isDisplayed();
	}

	public void Login(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		okButton.click();
	}

	public void click(String element) throws InterruptedException {
		switch (element) {
		case "ok":
			okButton.click();
			Thread.sleep(100000);
			break;
		}
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}