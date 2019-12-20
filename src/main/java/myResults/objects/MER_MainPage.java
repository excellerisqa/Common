package myResults.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_MainPage {
	public static By dashboardLink = By.xpath("//span[@class='xn-text ng-scope' and contains(text(),'Dashboard')]");
	public static By reportsLink = By.xpath("//span[@class='xn-text ng-scope' and contains(text(),'Reports')]");
	public static By analyticsLink = By.xpath("//span[@class='xn-text ng-scope' and contains(text(),'Analytics')]");
	public static By powerOffButton = By.xpath("//a[@title='Log-out of your current session.']");
	public static By logoutOKButton = By.xpath("//button[@class='btn btn-primary btnPHover ng-scope']");
	public static By myAccountLink = By.xpath(
			"//ul[@class='hidden-xs hidden-sm hidden-md nav navbar-right nav-pills topnav']//a[@class='ng-binding' and @data-toggle='dropdown']");
	public static By accountSettingsLink = By
			.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[not(contains(@ng-click,'$root.logout()'))]");
	public static By welcomeName = By.tagName("h2");
	public static By patientNameLink = By.xpath("//div[@ng-controller='PatientSelectController']/div[1]/div[3]/div[1]");
	public static By recentActivityReportLink = By.xpath("//div[@id='wallmessages']/div[1]/div/div[2]/a");

	public static By faqLink = By.xpath("//a[text()='FAQ']");
	public static By supportLink = By.xpath("//a[text()='Support']");
	public static By supportHeading = By.xpath("//h1[text()='Contact Support']");

	public void logout() throws Exception {

		ObjectHelper.driver.findElement(powerOffButton).click();
		CommonFunctions.clickonmodalpopup(logoutOKButton);
		CommonFunctions.waitForVisiblity(MER_LoginPage.usernameField, 30);

	}

	public boolean logoutAndVerify() {
		try {
			Thread.sleep(6000);
			ObjectHelper.driver.findElement(powerOffButton).click();

			CommonFunctions.waitandClick(By.xpath("//button[text()='OK']"), 10);

			return CommonFunctions.waitForVisiblity(MER_LoginPage.usernameField, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean goToDashboard() {
		try {
			CommonFunctions.waitandClick(dashboardLink, 20);
			// wait and check for visibility of myaccount link
			return CommonFunctions.waitForVisiblity(myAccountLink, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean goToAccountSettings() {
		try {
			CommonFunctions.waitandClick(myAccountLink, 20);
			ObjectHelper.driver.findElement(accountSettingsLink).click();
			// wait and check for visibility of cancel button on change security questions
			// page
			return CommonFunctions.waitForVisiblity(MER_AccountSettingsPage.changeEmailLink, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean goToAccountSettingsAndVerifyRemoveSecurityQuestionCookieOption() {
		try {
			CommonFunctions.waitandClick(myAccountLink, 20);
			ObjectHelper.driver.findElement(accountSettingsLink).click();
			// wait and check for visibility of the removeSecurityQuestionCookieLink
			return CommonFunctions.waitForVisiblity(MER_AccountSettingsPage.removeSecurityQuestionCookieLink, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean goToFAQ() {
		try {
			// Thread.sleep(3000);
			CommonFunctions.waitandClick(faqLink, 20);
			// ObjectHelper.driver.findElement(faqLink).click();
			return CommonFunctions.waitForVisiblity(MER_FAQPage.faqHeading, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean goToSupport() {
		try {
			// CommonFunctions.waitandClick(supportLink, 20);
			ObjectHelper.driver.findElement(supportLink).click();

			return CommonFunctions.waitForVisiblity(supportHeading, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean verifyPatients(XLHandler objXLHandler) {
		try {
			String patientList = objXLHandler.readCorrespondingValueFromTestDataName("Data", "Patients");

			boolean patientsFound = false;
			String[] patients = patientList.split(",");

			// CommonFunctions.waitForVisiblity(
			// By.xpath("//a[@ng-click='selectUser(patient.Value)' and text()='" +
			// patients[0] + "']"), 5);

			Thread.sleep(3000);
			for (String patient : patients) {

				patientsFound = ObjectHelper.driver
						.findElement(
								By.xpath("//a[@ng-click='selectUser(patient.Value)' and text()='" + patient + "']"))
						.isDisplayed();

				if (patientsFound)
					System.out.println("Patient found: " + patient);
			}
			return patientsFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean verifyWelcomeName(XLHandler objXLHandler) {
		try {
			String header = ObjectHelper.driver.findElement(MER_MainPage.welcomeName).getText();
			String expectedHeader = objXLHandler.readCorrespondingValueFromTestDataName("Data",
					"Expected welcome name");

			System.out.println("Welcome name found: " + expectedHeader);

			return header.contains(expectedHeader);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean selectFirstPatient() {
		try {

			if (CommonFunctions.waitForVisiblity(patientNameLink, 20)) {

				List<WebElement> patientList = ObjectHelper.driver.findElement(patientNameLink)
						.findElements(By.tagName("a"));

				// for (WebElement patient : patientList) {
				String pName = patientList.get(0).getText();
				System.out.println("Name: " + pName);
				patientList.get(0).click();

				if (CommonFunctions.waitForVisiblity(MER_ReportsPage.reportPagePatientName, 20)) {
					System.out.println("Reportname: "
							+ ObjectHelper.driver.findElement(MER_ReportsPage.reportPagePatientName).getText());

					if (!ObjectHelper.driver.findElement(MER_ReportsPage.reportPagePatientName).getText()
							.contains(pName))
						return false;
					boolean result = CommonFunctions.waitForVisiblity(MER_ReportsPage.reportsListTable, 20);
					System.out.println("result is: " + result);
					return result;
				} else
					return false;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
