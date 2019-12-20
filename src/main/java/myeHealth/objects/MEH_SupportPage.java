package myeHealth.objects;

import org.openqa.selenium.By;

public class MEH_SupportPage {
	public static By supportPageHeader = By.id("ctl00_ContentPlaceHolder1_SupportHeading0");
	public static By fullNameField = By.id("ctl00_ContentPlaceHolder1_FullNameTextBox");
	public static By emailField = By.id("ctl00_ContentPlaceHolder1_EmailAddressTextBox");
	public static By phoneNumField = By.id("ctl00_ContentPlaceHolder1_TelephoneTextBox");
	public static By subjectField = By.id("ctl00_ContentPlaceHolder1_SubjectDropDown_TextBox");
	public static By messageField = By.id("ctl00_ContentPlaceHolder1_YourMessageTextBox");
	public static By submitBtn = By.id("ctl00_ContentPlaceHolder1_SupportSubmitButton");
	public static By cancelBtn = By.id("ctl00_ContentPlaceHolder1_SupportResetButton");
}
