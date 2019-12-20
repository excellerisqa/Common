package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MEH_LoginPage {

	public static By usernameField = By.id("ctl00_ContentPlaceHolder1_LoginControl1_Login_Username");
	public static By passwordField = By.id("ctl00_ContentPlaceHolder1_LoginControl1_Login_Password");
	public static By loginButton = By.id("ctl00_ContentPlaceHolder1_LoginControl1_LoginButton");
	public static By securityQuesAnswerField = By.id("ctl00_ContentPlaceHolder1_LoginControl1_Login_SecurityAnswer");
	public static By securityQues = By.id("ctl00_ContentPlaceHolder1_LoginControl1_Login_SecurityQuestionLabelInfo");
	public static By securityQuesVerifyButton = By.id("ctl00_ContentPlaceHolder1_LoginControl1_VerifyButton");
	// public static By donotasksecurityquesCheckboxLink =
	// By.xpath("//div[@id='ctl00_ContentPlaceHolder1_LoginControl1_RememberMeContainer']//label");
	public static By donotasksecurityquesCheckboxLink = By.id("ctl00_ContentPlaceHolder1_LoginControl1_RememberMeCheckBox");
	public static By registerButton = By.id("ctl00_ContentPlaceHolder1_LoginControl1_ctl01_RegistrationButton");
	String user;
	String pwd;
	XLHandler data;

	/*
	 * Description : read username and password from test data file Parameters : @1
	 * XLHandler object initiated for test data file Returns : void Author : Sindhu
	 * Rajaguru Modified By:
	 */
	public void readLoginData(XLHandler objXLHandler) throws Exception {
		user = objXLHandler.getDatabyCell(0, 0, 1);
		pwd = objXLHandler.getDatabyCell(0, 1, 1);
	}

	/*
	 * Description : read corresponding security answers from test data file
	 * Parameters : @1 XLHandler object initiated for test data file Returns :
	 * String - answer for the question on screen Author : Sindhu Rajaguru Modified
	 * By:
	 */
	public String answerSecurityQuestion(XLHandler objXLHandler) {
		String ques = ObjectHelper.driver.findElement(securityQues).getText();
		String ans = "abc";
		int n = objXLHandler.getNumberOfRows("Security Ques");
		for (int i = 0; i < n; i++) {
			String quesData = objXLHandler.getDatabyCell("Security Ques", i, 0);
			if (ques.contains(quesData)) {
				ans = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", quesData);
				break;
			}
		}
		/*
		 * if (ques.contains("Question A")) ans =
		 * objXLHandler.readCorrespondingValueFromTestDataName("Security Ques"
		 * ,"Question A"); else if (ques.contains("Question B")) ans =
		 * objXLHandler.readCorrespondingValueFromTestDataName("Security Ques"
		 * ,"Question B"); else if (ques.contains("Question C")) ans =
		 * objXLHandler.readCorrespondingValueFromTestDataName("Security Ques"
		 * ,"Question C");
		 */
		return ans;
	}

	/*
	 * Description : enter login credentials, answer security questions and login
	 * Parameters : @1 XLHandler object initiated for test data file Returns : void
	 * Author : Sindhu Rajaguru Modified By:
	 */
	public void login(XLHandler objXLHandler) throws Exception {
		CommonFunctions.waitForVisiblity(usernameField, 50);
		readLoginData(objXLHandler);
		ObjectHelper.driver.findElement(usernameField).sendKeys(user);
		ObjectHelper.driver.findElement(passwordField).sendKeys(pwd);
		ObjectHelper.driver.findElement(loginButton).click();
		Thread.sleep(3000);
		try {
			if (ObjectHelper.driver.findElement(securityQuesAnswerField).isDisplayed()) {
				ObjectHelper.driver.findElement(securityQuesAnswerField).sendKeys(answerSecurityQuestion(objXLHandler));
				ObjectHelper.driver.findElement(donotasksecurityquesCheckboxLink).click();
				CommonFunctions.waitForVisiblity(securityQuesVerifyButton, 20);
				ObjectHelper.driver.findElement(securityQuesVerifyButton).click();
				Thread.sleep(4000);
			}
		} catch (Exception e) {
			System.out.println("Exception on login screen");
		}

		CommonFunctions.waitForVisiblity(MEH_MainPage.homeLink, 30);

	}

}
