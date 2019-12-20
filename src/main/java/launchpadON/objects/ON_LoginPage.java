package launchpadON.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class ON_LoginPage {

	public static By username = By.id("ctl00_mainContent_UserIDTextBox");
	public static By password = By.id("ctl00_mainContent_PasswordTextBox");
	public static By okbtn = By.id("ctl00_mainContent_OKButton");
	public static By ddOrganization = By.id("OrganizationsDropDownList");
	public static By ddRoles = By.id("RolesDropDownList");
	public static By organization = By.id("OrganizationsDropDownList");

	public static void loginpage(String id, String pwd) throws Exception {

		ObjectHelper.driver.findElement(username).clear();
		ObjectHelper.driver.findElement(username).sendKeys(id);
		ObjectHelper.driver.findElement(password).clear();
		ObjectHelper.driver.findElement(password).sendKeys(pwd);
		ObjectHelper.driver.findElement(okbtn).sendKeys(Keys.ENTER);

		if (CommonFunctions.waitForVisiblity(organization, 10)) {
			ObjectHelper.driver.findElement(okbtn).sendKeys(Keys.ENTER);
		}

	}

	public static void selectOrg(String orgType) {
		Select OrgType = new Select(ObjectHelper.driver.findElement(ddOrganization));
		OrgType.selectByVisibleText(orgType);
	}

	public static void selectRole(String roleType) {
		Select RolesType = new Select(ObjectHelper.driver.findElement(ddRoles));
		RolesType.selectByVisibleText(roleType);
		ObjectHelper.driver.findElement(okbtn).sendKeys(Keys.ENTER);
	}

}
