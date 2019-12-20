package lldotcom.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LL_Register extends LoadableComponent<LL_Register> {

	@FindBy(xpath = "//input[@value='AGREE']")
	public WebElement agreeButton;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_txtFirstName")
	public WebElement firstNameTextbox;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_txtLastName")
	public WebElement lastNameTextbox;

	@FindBy(id = "ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ComboProvince")
	public WebElement provinceDropdown;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_txtPhoneHome")
	public WebElement phoneTextbox;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_UserName")
	public WebElement emailTextbox;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_ConfirmEmail")
	public WebElement confirmEmailTextbox;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_Password")
	public WebElement passwordTextbox;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_ConfirmPassword")
	public WebElement confirmPasswordTextbox;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_chkEmailConfirmations")
	public WebElement emailConfirmationCheckbox;

	@FindBy(id = "ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$Question")
	public WebElement securityQuestionDropdown;

	@FindBy(id = "ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_Answer")
	public WebElement securityAnswerTextbox;

	@FindBy(xpath = "//input[@value='REGISTER']")
	public WebElement registerButton;

	WebDriver driver = null;

	public LL_Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	@Override
	protected void isLoaded() throws Error {

	}

	@Override
	protected void load() {

	}

	public boolean agreeToTerms() {
		try {
			CommonFunctions.waitandClick(agreeButton, 20);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean fillRegistationDetailsAndRegister(String first, String last, String prov, String phone, String email,
			String confirmEmail, String password, String confirmPassword, String question, String answer) {
		try {
			CommonFunctions.waitandClear(firstNameTextbox, 20);
			firstNameTextbox.sendKeys(first);
			lastNameTextbox.sendKeys(last);
			provinceDropdown.click();

			ObjectHelper.driver.findElement(By.xpath("//li[text()='" + prov + "']")).click();

			phoneTextbox.sendKeys(phone);
			emailTextbox.sendKeys(email);
			confirmEmailTextbox.sendKeys(confirmEmail);
			passwordTextbox.sendKeys(password);
			confirmPasswordTextbox.sendKeys(confirmPassword);

			emailConfirmationCheckbox.click();

			securityQuestionDropdown.click();
			ObjectHelper.driver.findElement(By.xpath("//li[text()='" + question + "']")).click();

			securityAnswerTextbox.sendKeys(answer);

			// registerButton.click();

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}