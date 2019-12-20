package launchpadON.objects;

import org.openqa.selenium.By;

import utils.ObjectHelper;

public class ON_AccountSettings {

	public static By pdfPrinting = By.id("PrintingModeOptions_0");

	public static By optionsBtn = By.id("btnTasks");

	// elements for options
	public static By accountsettings = By.xpath("//div[@id='preferences']//div");
	public static By userProfile = By.xpath("//span[@id='UserPreferencesLabel']");
	public static By changePassword = By.xpath("//span[@id='Label2']");
	public static By inboxSetting = By.xpath("//span[@id='InBox']");
	public static By reportPrintPreferences = By.xpath("//span[@id='Print']");
	public static By backtomain = By.id("BackToMain");

	// elements for user profile
	public static By firstName = By.id("FirstName");
	public static By lastName = By.id("LastName");
	public static By street1 = By.id("Street1");
	public static By street2 = By.id("Street2");
	public static By city = By.id("City");
	public static By province = By.id("Province");
	public static By postalCode = By.id("PostalCode");
	public static By userPhone = By.id("UserPhone");
	public static By userPrefSavebtn = By.id("UserPrefSave");

	// *[@id="UserPrefSave"]

	// elements for Change password
	public static By oldPassword = By.id("OldPassword");
	public static By newPassword = By.id("NewPassword");
	public static By confirmPassword = By.id("ConfirmPassword");
	public static By savebtnPassword = By.id("save");
	public static By closebtnPassword = By.xpath("//*[@id='close']");

	public static By successfulInfo = By.xpath("//*[@id=\"password\"]/tbody/tr/td/span[1]");

	// email
	public static By emailtxt = By.id("UserEmail");
	public static By emailMeNowbtn = By.id("btnEmailMeNow");

	// public static By validationCodetxt = By.id("HashToValidate");

	public static By validationCodetxt = By.xpath("//input[@id='HashToValidate']");
	public static By validatedbtn = By.id("btnValidateUserEmail");

	public static By updateEmaillink = By.id("ChangeUserEmail");

	// *[@id="HashToValidate"]

	public static By emailConfirmInfo = By.xpath("//*[@id=\"UpdatePanel1\"]/div[2]/span/i");

	// elements for Inbox Setting
	public static By inboxPrintOrder0 = By.id("InBoxPrintOrderOptions_0");
	public static By inboxPrintOrder1 = By.id("InBoxPrintOrderOptions_1");
	public static By inboxPrintOrder2 = By.id("InBoxPrintOrderOptions_2");
	public static By inboxSavebtn = By.id("InboxSave");
	public static By inboxCancelbtn = By.id("InboxCancel");

	// public static By pdfPrinting = By.id("PDFPrinting");
	public static By savebtn = By.id("PrintSave");

	// enter password
	public static String enterPassword(String oPassword) throws Exception {

		ObjectHelper.driver.findElement(oldPassword).clear();
		ObjectHelper.driver.findElement(oldPassword).sendKeys(oPassword);

		String nPassword = oPassword.substring(0, 5) + (Integer.parseInt(oPassword.split("y")[1]) + 1);
		System.out.println(oPassword.substring(0, 5));
		System.out.println(Integer.parseInt(oPassword.split("y")[1]) + 1);

		ObjectHelper.driver.findElement(newPassword).clear();
		ObjectHelper.driver.findElement(newPassword).sendKeys(nPassword);

		ObjectHelper.driver.findElement(confirmPassword).clear();
		ObjectHelper.driver.findElement(confirmPassword).sendKeys(nPassword);

		return nPassword;

	}

	// modify profile
	public static void modifyProfile(String[] profile) throws Exception {

		ObjectHelper.driver.findElement(firstName).clear();
		ObjectHelper.driver.findElement(firstName).sendKeys(profile[1]);

		ObjectHelper.driver.findElement(lastName).clear();
		ObjectHelper.driver.findElement(lastName).sendKeys(profile[2]);

		ObjectHelper.driver.findElement(street1).clear();
		ObjectHelper.driver.findElement(street1).sendKeys(profile[3]);

		ObjectHelper.driver.findElement(street2).clear();
		ObjectHelper.driver.findElement(street2).sendKeys(profile[4]);

		ObjectHelper.driver.findElement(city).clear();
		ObjectHelper.driver.findElement(city).sendKeys(profile[5]);

		ObjectHelper.driver.findElement(province).clear();
		ObjectHelper.driver.findElement(province).sendKeys(profile[6]);

		ObjectHelper.driver.findElement(postalCode).clear();
		ObjectHelper.driver.findElement(postalCode).sendKeys(profile[7]);

		ObjectHelper.driver.findElement(userPhone).clear();
		ObjectHelper.driver.findElement(userPhone).sendKeys(profile[8]);
	}

}