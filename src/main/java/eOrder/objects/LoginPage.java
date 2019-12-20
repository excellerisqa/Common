package eOrder.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	public WebDriver driver;

	@FindBy(id = "ctl00_mainContent_UserIDTextBox")
	WebElement userID;

	@FindBy(id = "ctl00_mainContent_PasswordTextBox")
	WebElement password;

	@FindBy(id = "ctl00_mainContent_OKButton")
	WebElement okButton;

	@FindBy(id = "ctl00_mainContent_ClearButton")
	WebElement clearButton;

	@FindBy(id = "ctl00_mainContent_ForgotPasswordLabel")
	WebElement forgotPswdORacctLckd;

	public boolean backToLoginPage() {
		return userID.isDisplayed();
	}

	public void Login(String username, String pass) {
		userID.sendKeys(username);
		password.sendKeys(pass);
		okButton.click();
	}

	public void click(String element) {
		switch (element) {
		case "ok":
			okButton.click();
			break;
		case "clear":
			clearButton.click();
			break;
		case "forgotpassword":
			forgotPswdORacctLckd.click();
			break;
		case "accountlocked":
			forgotPswdORacctLckd.click();
			break;
		}
	}

	@FindBy(id = "OrganizationsDropDownList")
	WebElement ddOrganization;

	public void selectOrg(String orgType) {
		Select OrgType = new Select(ddOrganization);
		OrgType.selectByVisibleText(orgType);
	}

	@FindBy(id = "RolesDropDownList")
	WebElement ddRoles;

	public void selectRole(String roleType) {
		Select RolesType = new Select(ddRoles);
		RolesType.selectByVisibleText(roleType);
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
