package myResults.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MER_Registration {
	// public static By analyticsPageUserName =
	// By.xpath("//div[@id='analyticSummary']//div[contains(@class,'patient-name-select')]//h2");

	public static By labVisitNumberYesRadiobutton = By.xpath("//label[@for='discretionAcceptedY']");
	public static By labVisitNumberNoRadiobutton = By.xpath("//label[@for='discretionAcceptedN']");

	public static By emailTextbox = By.id("email");
	public static By confirmEmailTextbox = By.name("confirmEmail");
	public static By passwordTextbox = By.id("password");
	public static By confirmPasswordTextbox = By.name("confirmPassword");

	public static By firstNameTextbox = By.name("givenName");
	public static By lastNameTextbox = By.name("surName");
	public static By streetTextbox = By.name("address1");
	public static By cityTextbox = By.name("city");
	public static By postalCodeTextbox = By.name("zipOrPostalCode");

	public static By yearDropdown = By.name("birthYear");
	public static By monthDropdown = By.name("birthMonth");
	public static By dayDropdown = By.name("birthDay");

	public static By nextButton = By
			.xpath("//button[@class = 'btn btn-primary btnPHover ng-binding' and @type='submit']");

	public static By accountProfileHeading = By.xpath("//h1[text()='Step 1: Account Profile']");
	public static By securitySettingsHeading = By.xpath("//h1[text()='Step 2: Security Settings']");
	public static By checkTermsOfUseHeading = By.xpath("//h1[text()='Step 3: Check Terms of Use']");

	public static By questionsDropdowns = By.name("cannedQuestion");
	public static By answersTextboxes = By.name("answer");
	public static By phraseTextbox = By.name("secretConfirmationPhrase");

	public static By customQuestionCheckboxes = By
			.xpath("//label[text()='I would like to enter a custom question...']");
	public static By customQuestionsTextboxes = By.name("customQuestion");

	public static By acceptTermsCheckbox = By.xpath("//label[@for='acceptTerms']");
	public static By createAccountButton = By.id("btn_create_account");

	public static By verifyAccountMessage = By
			.xpath("//span[text(),'We have sent you an account verification email to']");

	// <span translate="VERIFYACCOUNT_RESULT2" class="ng-scope">We have sent you an
	// account verification email to </span>
	public static boolean fillAccountProfile(String email, String confirmemail, String password, String confirmPassword,
			String firstname, String lastname, String street, String city, String postalcode, String dobyear,
			String dobMonth, String dobday) {

		try {
			CommonFunctions.waitForVisiblity(labVisitNumberYesRadiobutton, 20);
			if (!(ObjectHelper.driver.findElement(labVisitNumberYesRadiobutton).isSelected()))
				ObjectHelper.driver.findElement(labVisitNumberYesRadiobutton).click();

			ObjectHelper.driver.findElement(emailTextbox).sendKeys(email);
			ObjectHelper.driver.findElement(confirmEmailTextbox).sendKeys(confirmemail);
			ObjectHelper.driver.findElement(passwordTextbox).sendKeys(password);
			ObjectHelper.driver.findElement(confirmPasswordTextbox).sendKeys(confirmPassword);
			ObjectHelper.driver.findElement(firstNameTextbox).sendKeys(firstname);
			ObjectHelper.driver.findElement(lastNameTextbox).sendKeys(lastname);
			ObjectHelper.driver.findElement(streetTextbox).sendKeys(street);
			ObjectHelper.driver.findElement(cityTextbox).sendKeys(city);
			ObjectHelper.driver.findElement(postalCodeTextbox).sendKeys(postalcode);

			Select year = new Select(ObjectHelper.driver.findElement(yearDropdown));
			year.selectByVisibleText(dobyear);

			Select month = new Select(ObjectHelper.driver.findElement(monthDropdown));
			month.selectByVisibleText(dobMonth);

			Select day = new Select(ObjectHelper.driver.findElement(dayDropdown));
			day.selectByVisibleText(dobday);

			// CommonFunctions.waitForVisiblity(nextButton, 20);
			Thread.sleep(2000);
			List<WebElement> nextButtons = ObjectHelper.driver.findElements(nextButton);

			for (WebElement next : nextButtons) {
				if (next.isDisplayed()) {
					next.click();
					if (CommonFunctions.waitForVisiblity(securitySettingsHeading, 20))
						break;
				}
			}
			// verify visibility of an element on security settings page
			if (ObjectHelper.driver.findElement(securitySettingsHeading).isDisplayed())
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean fillSecuritySettings(String questionsData, String answersData, String phrase,
			boolean enterCustomQuestions, String customQuestions) {

		try {
			CommonFunctions.waitForVisiblity(questionsDropdowns, 20);
			List<WebElement> questions = ObjectHelper.driver.findElements(questionsDropdowns);
			List<WebElement> answers = ObjectHelper.driver.findElements(answersTextboxes);
			List<WebElement> customQuestionSelect = ObjectHelper.driver.findElements(customQuestionCheckboxes);

			String[] customQuestionToEnter = customQuestions.split(",");
			String[] questionToSelect = questionsData.split(",");
			String[] answerToType = answersData.split(",");

			for (int index = 0; index < 3; index++) {
				if (enterCustomQuestions) {
					customQuestionSelect.get(index).click();
					List<WebElement> customQuestionTextbox = ObjectHelper.driver.findElements(customQuestionsTextboxes);
					CommonFunctions.waitForVisiblity(customQuestionTextbox.get(index), 20);
					customQuestionTextbox.get(index).sendKeys(customQuestionToEnter[index]);
					answers.get(index).sendKeys(answerToType[index]);

				} else {

					Select selectQuestion = new Select(questions.get(index));
					selectQuestion.selectByVisibleText(questionToSelect[index]);
					answers.get(index).sendKeys(answerToType[index]);

				}
			}

			ObjectHelper.driver.findElement(phraseTextbox).sendKeys(phrase);

			List<WebElement> nextButtons = ObjectHelper.driver.findElements(nextButton);

			for (WebElement next : nextButtons) {
				if (next.isDisplayed()) {
					next.click();
					if (CommonFunctions.waitForVisiblity(checkTermsOfUseHeading, 20))
						break;
				}
			}
			// verify visibility of an element on Check Terms of Use page
			if (ObjectHelper.driver.findElement(checkTermsOfUseHeading).isDisplayed())
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean acceptTermsOfUseAndCreate() {

		try {
			CommonFunctions.waitForVisiblity(acceptTermsCheckbox, 20);
			ObjectHelper.driver.findElement(acceptTermsCheckbox).click();
			System.out.println("Captcha cannot be bypassed as it is a big task for developers");
			return CommonFunctions.waitForVisiblity(createAccountButton, 20);// once captcha is bypassed comment this
																				// out
			// capcha should be bypassed

			// ObjectHelper.driver.findElement(createAccountButton).click(); //UNCOMMENT
			// once the captcha is disabled

			// return CommonFunctions.waitForVisiblity(verifyAccountMessage, 20);//if
			// captcha is bypassed
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
