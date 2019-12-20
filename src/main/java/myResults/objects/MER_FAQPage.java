package myResults.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MER_FAQPage {
	public static By faqHeading = By.xpath("//h1[text()='FAQ & TUTORIALS']");

	public static By expandFAQ = By.xpath("//a[contains(@data-target, '#collapse')]");

	public static By loginTab = By.xpath("//a[text()='Login']");
	public static By privacyTab = By.xpath("//a[text()='Privacy']");
	public static By reportTab = By.xpath("//a[text()='Report']");
	public static By accountCreationTab = By.xpath("//a[text()='Account Creation']");
	public static By securityTab = By.xpath("//a[text()='Security']");
	public static By tutorialsTab = By.xpath("//a[text()='Tutorials']");

	public static boolean verifyGeneralFAQs() throws Exception {
		try {
			Thread.sleep(3000);
			String pageSource = ObjectHelper.driver.getPageSource();

			if (pageSource.contains("Which browsers are supported?")
					&& pageSource.contains("Which browsers are supported?")
					&& pageSource.contains("How do I deactivate my account?")
					&& pageSource.contains(
							"I have more than one person added under my account, but I don't know where to find their results.")
					&& pageSource.contains("How do I print my report?")
					&& pageSource.contains("Will results for all tests be available?")
					&& pageSource.contains("The problem I encountered is not listed here."))
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyLoginFAQs() throws Exception {
		try {
			CommonFunctions.waitandClick(loginTab, 20);

			String pageSource = ObjectHelper.driver.getPageSource();

			if (pageSource
					.contains("When I answer a security question, I receive the error message 'Answer is incorrect'"))
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyPrivacyFAQs() throws Exception {
		try {
			CommonFunctions.waitandClick(privacyTab, 20);

			String pageSource = ObjectHelper.driver.getPageSource();

			if (pageSource.contains("Why do you collect my personal information when I create an account")
					&& pageSource.contains("Do you share my personal information with other organizations?")
					&& pageSource.contains("How long do you keep my personal information?")
					&& pageSource.contains("How do you protect my personal information?")
					&& pageSource.contains("Where is my personal information stored?")
					&& pageSource.contains("How is your staff trained about privacy?"))
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyReportFAQs() throws Exception {
		try {
			CommonFunctions.waitandClick(reportTab, 20);

			String pageSource = ObjectHelper.driver.getPageSource();

			if (pageSource.contains("Can I access my historical reports?")
					&& pageSource
							.contains("Why is my lab result still pending? It's been several days since my lab test")
					&& pageSource.contains(
							"I got an email telling me that my lab report has been updated, but I can't see what has changed.")
					&& pageSource.contains(
							"Why is one of my reports missing? I visited one of your supported labs but there is no record of the visit in my account")
					&& pageSource.contains("I need some help understanding my report")
					&& pageSource.contains("How do I deactivate my account?"))
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyAccountCreationFAQs() throws Exception {
		try {
			CommonFunctions.waitandClick(accountCreationTab, 20);

			String pageSource = ObjectHelper.driver.getPageSource();

			boolean Ques1 = pageSource.contains("When can I create an account?");
			boolean Ques2 = pageSource.contains("How do I create an account?");
			boolean Ques3 = pageSource.contains(
					"When I try to create an account, I get an error saying that the information that I have entered cannot be validated.");
			boolean Ques4 = pageSource.contains("How do I add another person to my account?");
			boolean Ques5 = pageSource.contains("When I try to create my account, I receive an error.");

			boolean Ques6 = pageSource.contains(
					"I have successfully created my account and viewed my reports for the first time. Why am I unable to log back into my account?");
			boolean Ques7 = pageSource.contains("Can I create an account on behalf of my child who is under 18?");
			boolean Ques8 = pageSource
					.contains("Why can't I create an account if my lab visit was more than 30 days ago?");
			boolean Ques9 = pageSource.contains("Can I use my iPhone, Android, or Blackberry to create an account?");

			if (Ques1 && Ques2 && Ques3 && Ques4 && Ques5 && Ques6 && Ques7 && Ques8 && Ques9)
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifySecurityCreationFAQs() throws Exception {
		try {
			CommonFunctions.waitandClick(securityTab, 20);

			String pageSource = ObjectHelper.driver.getPageSource();

			if (pageSource.contains("What are my responsibilities regarding security?")
					&& pageSource.contains("Will I be required to change my password?")
					&& pageSource.contains("How do I know that the site is secure?")
					&& pageSource.contains("How do I add another person to my account?")
					&& pageSource.contains("How do I know that my personal information is safe and secure?")

			)
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyTutorialsFAQs() throws Exception {
		try {
			CommonFunctions.waitandClick(tutorialsTab, 20);

			String pageSource = ObjectHelper.driver.getPageSource();

			if (pageSource.contains("What is my results?") && pageSource.contains("How to create a new account?")
					&& pageSource.contains("How to view results?") && pageSource.contains("How to view result trends?")
					&& pageSource.contains("How to add or remove a person?")

			)
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyExpandingAllFAQs() {
		try {
			List<WebElement> allExpandIcons = ObjectHelper.driver.findElements(expandFAQ);

			for (WebElement expand : allExpandIcons) {
				if (expand.isDisplayed()) {
					expand.click();
					Thread.sleep(1000);
				}
			}
			return true;

		} catch (Exception e) {
			return false;
		}

	}

}
