package launchpadBC.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BC_LoginPage {
	WebDriver driver;
	public static By username = By.id("ctl00_mainContent_UserIDTextBox");
	public static By password = By.id("ctl00_mainContent_PasswordTextBox");
	public static By okbtn = By.id("ctl00_mainContent_OKButton");

	public static void loginpage(String id, String pwd) throws Exception {
		CommonFunctions.waitForVisiblity(BC_LoginPage.username, 20);
		//ObjectHelper.driver.findElement(username).clear();
		ObjectHelper.driver.findElement(username).sendKeys(new CharSequence[]{id});
		//ObjectHelper.driver.findElement(password).clear();
		ObjectHelper.driver.findElement(password).sendKeys(pwd);
		ObjectHelper.driver.findElement(okbtn).sendKeys(Keys.ENTER);

		if (CommonFunctions.waitForVisiblity(okbtn, 30)) {
			ObjectHelper.driver.findElement(okbtn).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		}
	}

}
