package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_RegistrationPage {

	//step1
	public static By step1StartRegistrationButton = By.id("ctl00_ContentPlaceHolder1_RegistrationStartButton");
	public static By step1CancelButton = By.id("ctl00_ContentPlaceHolder1_RegistrationCancelButton");
	
	//step2
	public static By step2VisitedLabRadioBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_VisitedLabRadioButton");
	public static By step2HaveLabVisitNumberRadioBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_LabVisitNumberRadioButton");
	public static By step2DontHaveLabVisitNumberRadioBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_AddressRadioButton");
	public static By step2ReceivedLetterRadioBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_RecievedLetterRadioButton");
	public static By step2WelcomeLetterRadioBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_WelcomeLetterRadioButton");
	public static By step2renewalLetterRadioBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_AccountRenewalLetterRadioButton");
	public static By step2NextBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationNextButton");
	public static By step2CancelBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationCancelButton");
	
	//step3
	public static By step3EmailField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Username");
	public static By step3RetypeEmailField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Username2");
	public static By step3PasswordField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Password");
	public static By step3RetypePasswordField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_ConfirmPassword");
	public static By step3Question1Btn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Question1Dropdown_Button");
	public static By step3Question1List = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Question1Dropdown_OptionList");
	public static By step3Answer1Field = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Answer");
	public static By step3Question2Btn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Question2Dropdown_Button");
	public static By step3Question2List = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Question2Dropdown_OptionList");
	public static By step3Answer2Field = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Answer2");
	public static By step3Question3Btn = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Question3Dropdown_Button");
	public static By step3Question3List = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Question3Dropdown_OptionList");
	public static By step3Answer3Field = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_Answer3");
	public static By step3CancelBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationCancelButton");
	public static By step3PreviousBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationPrevButton");
	public static By step3NextBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationNextButton");
	
	//step4
	public static By step4SecurityPhraseField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_SecurityPhraseTextBox");
	public static By step4NextBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationNextButton");
	
	//step5
	public static By step5FirstNameField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_FirstNameTextBox");
	public static By step5LastNameField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_LastNameTextBox");
	public static By step5LabVistNumField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_AccessCodeTextBox");
	public static By step5BCcareCardNumField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_PHNTextbox");
	public static By step5DateOfVistField = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_VisitDateTextBox");
	public static By step5BirthYear = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_BirthYear");
	public static By step5BirthMonth = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_BirthMonth");
	public static By step5BirthDay = By.id("ctl00_ctl00_ContentPlaceHolder1_MainContent_BirthDay");
	public static By step5NextBtn = By.id("ctl00_ctl00_ContentPlaceHolder1_CreateUserRegistrationNextButton");
	
	public static boolean registerAccount(String email, String password, String firstName, String lastName, String labVisitNum, String healthCardNum, String birthMon, String birthDay, String birthYear) {
		Boolean stat = true;
		try {
			ObjectHelper.driver.findElement(MEH_LoginPage.registerButton).click();
			CommonFunctions.waitandClick(step1StartRegistrationButton, 5);
			
			CommonFunctions.waitandClick(step2VisitedLabRadioBtn, 5);
			CommonFunctions.waitandClick(step2HaveLabVisitNumberRadioBtn,5);
			ObjectHelper.driver.findElement(step2NextBtn).click();
			
			CommonFunctions.waitForVisiblity(step3EmailField, 5);
			ObjectHelper.driver.findElement(step3EmailField).sendKeys(email);
			ObjectHelper.driver.findElement(step3RetypeEmailField).sendKeys(email);
			ObjectHelper.driver.findElement(step3PasswordField).sendKeys(password);
			ObjectHelper.driver.findElement(step3RetypePasswordField).sendKeys(password);
			ObjectHelper.driver.findElement(step3Question1Btn).click();
			/*
			//CommonFunctions.waitandClick(By.xpath("//ul[@id='ctl00_ctl00_ContentPlaceHolder1_MainContent_Question1Dropdown_OptionList']//li[contains(text(),'car')]"), 2);
			CommonFunctions.clickUsingJavaExecutor("//ul[@id='ctl00_ctl00_ContentPlaceHolder1_MainContent_Question1Dropdown_OptionList']//li[contains(text(),'car')]");
			//ObjectHelper.driver.findElement(By.xpath("//ul[@id='ctl00_ctl00_ContentPlaceHolder1_MainContent_Question1Dropdown_OptionList']//li[contains(text(),'car')]")).click();
			
			Thread.sleep(1000);
			ObjectHelper.driver.findElement(step3Answer1Field).sendKeys("blue");
			ObjectHelper.driver.findElement(step3Question2Btn).click();
			ObjectHelper.driver.findElement(By.xpath("//ul[@id='ctl00_ctl00_ContentPlaceHolder1_MainContent_Question2Dropdown_OptionList'][2]//li[contains(text(),'watch')]")).click();
			ObjectHelper.driver.findElement(By.xpath("//body")).sendKeys(Keys.RETURN);
			//Thread.sleep(1000);
			ObjectHelper.driver.findElement(step3Answer2Field).sendKeys("left");
			ObjectHelper.driver.findElement(step3Question3Btn).click();
			Actions builder = new Actions(ObjectHelper.driver);
		    builder.moveToElement(ObjectHelper.driver.findElement(By.xpath("//ul[@id='ctl00_ctl00_ContentPlaceHolder1_MainContent_Question3Dropdown_OptionList'][3]//li[contains(text(),'animal')]"))).perform();
		      // mouseOverAdmin.perform();
			ObjectHelper.driver.findElement(By.xpath("//ul[@id='ctl00_ctl00_ContentPlaceHolder1_MainContent_Question3Dropdown_OptionList'][3]//li[contains(text(),'animal')]")).click();
			Thread.sleep(1000);
			ObjectHelper.driver.findElement(step3Answer3Field).sendKeys("dog");
			ObjectHelper.driver.findElement(step3NextBtn).click();
			
			CommonFunctions.waitForVisiblity(step4SecurityPhraseField, 5);
			ObjectHelper.driver.findElement(step3EmailField).sendKeys("I love chocolate.");
			ObjectHelper.driver.findElement(step4NextBtn).click();
			
			CommonFunctions.waitForVisiblity(step5FirstNameField, 5);
			ObjectHelper.driver.findElement(step5FirstNameField).sendKeys(firstName);
			ObjectHelper.driver.findElement(step5LastNameField).sendKeys(lastName);
			ObjectHelper.driver.findElement(step5LabVistNumField).sendKeys(labVisitNum);
			ObjectHelper.driver.findElement(step5BCcareCardNumField).sendKeys(healthCardNum);
			ObjectHelper.driver.findElement(step5DateOfVistField).sendKeys(CommonFunctions.getToday("MMM dd, YYYY"));
			Select bMonth = new Select(ObjectHelper.driver.findElement(step5BirthMonth));
			bMonth.selectByVisibleText(birthMon);
			Select bDay = new Select(ObjectHelper.driver.findElement(step5BirthDay));
			bDay.selectByVisibleText(birthMon);
			Select bYear = new Select(ObjectHelper.driver.findElement(step5BirthYear));
			bYear.selectByVisibleText(birthMon);
					*/
			
		} catch (Exception e) {
			e.printStackTrace();
			stat = false;
		}
		return stat;
	}

}
