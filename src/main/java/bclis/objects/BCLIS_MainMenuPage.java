package bclis.objects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BCLIS_MainMenuPage extends LoadableComponent<BCLIS_MainMenuPage> {

	@FindBy(xpath = "//span[@class='k-icon k-i-arrow-s']")
	public WebElement labelPrinterArrow;

	@FindBy(xpath = "//label[text()='All Labels']")
	public WebElement allLabelsRadioButton;

	@FindBy(xpath = "//label[text()='No Collection Labels']")
	public WebElement noCollectionsLabelsRadioButton;

	@FindBy(xpath = "//label[text()='No Labels']")
	public WebElement noLabelsRadioButton;

	@FindBy(xpath = "//i[@class='icon-add-user']")
	public WebElement patientEntryIcon;

	@FindBy(xpath = "//i[@class='icon-edit']")
	public WebElement historicalAccessionsIcon;

	@FindBy(xpath = "//i[@class='icon-contract']")
	public WebElement contractServicesEntryIcon;

	@FindBy(xpath = "//i[@class='icon-selfpay']")
	public WebElement selfPayPaymentsIcon;

	@FindBy(xpath = "//i[@class='icon-quotation']")
	public WebElement larsQuotationIcon;

	@FindBy(xpath = "//i[@class='icon-lars']")
	public WebElement larsEndOfDayIcon;

	@FindBy(xpath = "//span[@class='logged-in ng-binding' and @ng-click='logout()']")
	public WebElement logoutLink;

	@FindBy(xpath = "//a[text()='Client Search']")
	public WebElement clientSearchLink;

	@FindBy(xpath = "//button[@ng-click='resetSearchForm()']")
	public WebElement clientSearchCancelButton;

	@FindBy(xpath = "//a[text()='Test Look Up']")
	public WebElement testLookupLink;

	WebDriver driver = null;

	public BCLIS_MainMenuPage(WebDriver driver) {
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

	/**
	 * DESCRIPTION: select label and print option PARAMETERS: label printer and
	 * print option RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean selectLabelPrinterAndPrintOption(String labelPrinter, String print) throws Exception {

		try {
			CommonFunctions.waitandClick(labelPrinterArrow, 20);

			Thread.sleep(2000);

			CommonFunctions.waitandClick(
					driver.findElement(
							By.xpath("//ul[@id='label_printer_listbox']/li[contains(text(),'" + labelPrinter + "')]")),
					20);

			Thread.sleep(2000);

			if (print.equalsIgnoreCase("all labels") && !allLabelsRadioButton.isSelected())
				allLabelsRadioButton.click();
			if (print.equalsIgnoreCase("no collection labels") && !noCollectionsLabelsRadioButton.isSelected())
				noCollectionsLabelsRadioButton.click();
			if (print.equalsIgnoreCase("no labels") && !noLabelsRadioButton.isSelected())
				noLabelsRadioButton.click();

			Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: All the following functions take to different pages using the
	 * Icons on Main menu page PARAMETERS: none RETURNS: void AUTHOR: Bhavna
	 * Karanjekar MODIFIED BY:
	 */
	public boolean goToPatientEntry(BCLIS_PatientSearchPage patientSearchPage) throws Exception {
		try {
			CommonFunctions.waitandClick(patientEntryIcon, 20);
			// wait and check for visibility of Search button on Patient Search page
			return CommonFunctions.waitForVisiblity(patientSearchPage.provinceDropdown, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean goToHistoricalAccession(BCLIS_HistoricalAccessionsPage historicalAccessionsPage) {
		try {
			CommonFunctions.waitandClick(historicalAccessionsIcon, 20);
			return CommonFunctions.waitForVisiblity(historicalAccessionsPage.searchButton, 20);

		} catch (Exception e) {
			return false;
		}

	}

	public boolean goToContractServicesEntry(BCLIS_ContractServicesEntryPage contractServicesEntryPage)
			throws Exception {

		try {
			CommonFunctions.waitandClick(contractServicesEntryIcon, 20);
			return CommonFunctions.waitForVisiblity(contractServicesEntryPage.cseAccountIdTextbox, 20);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean goToSelfPayPayments() throws Exception {
		try {
			CommonFunctions.waitandClick(selfPayPaymentsIcon, 20);

			if (CommonFunctions.waitForNewTabToOpen(2, 20)) {
				ArrayList<String> tabs = new ArrayList<String>();
				// Switch to new tab -LARS
				tabs = new ArrayList<String>(driver.getWindowHandles());
				Thread.sleep(5000);
				driver.switchTo().window(tabs.get(1));

				System.out.println("Redirected to: " + driver.getCurrentUrl());

				if (driver.getCurrentUrl().contains("lars") && driver.getCurrentUrl().contains("selfpay")) {
					Thread.sleep(5000);

					Thread.sleep(2000);
					ObjectHelper.driver.close();
					ObjectHelper.driver.switchTo().window(tabs.get(0));
					return true;
				} else
					return false;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToLARSQuotation() throws Exception {
		try {
			CommonFunctions.waitandClick(larsQuotationIcon, 20);
			if (CommonFunctions.waitForNewTabToOpen(2, 20)) {
				ArrayList<String> tabs = new ArrayList<String>();
				// Switch to new tab -LARS
				tabs = new ArrayList<String>(driver.getWindowHandles());
				Thread.sleep(5000);
				driver.switchTo().window(tabs.get(1));

				System.out.println("Redirected to: " + driver.getCurrentUrl());

				if (driver.getCurrentUrl().contains("lars") && driver.getCurrentUrl().contains("quote")) {

					Thread.sleep(2000);
					ObjectHelper.driver.close();
					ObjectHelper.driver.switchTo().window(tabs.get(0));
					return true;
				} else
					return false;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToLARSEndOfDay() throws Exception {
		try {
			CommonFunctions.waitandClick(larsEndOfDayIcon, 20);
			if (CommonFunctions.waitForNewTabToOpen(2, 20)) {
				ArrayList<String> tabs = new ArrayList<String>();
				// Switch to new tab -LARS
				tabs = new ArrayList<String>(driver.getWindowHandles());
				Thread.sleep(5000);
				driver.switchTo().window(tabs.get(1));

				System.out.println("Redirected to: " + driver.getCurrentUrl());

				if (driver.getCurrentUrl().contains("lars") && driver.getCurrentUrl().contains("eod")) {

					Thread.sleep(2000);
					ObjectHelper.driver.close();
					ObjectHelper.driver.switchTo().window(tabs.get(0));
					return true;
				} else
					return false;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToClientSearch(BCLIS_NewAccessionPage newAccessionPage) {
		try {
			CommonFunctions.waitandClick(clientSearchLink, 20);
			if (CommonFunctions.waitForVisiblity(newAccessionPage.billingNumberTextbox, 20))
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean cancelOnClientSearch(BCLIS_MainMenuPage mainMenuPage) {
		try {
			CommonFunctions.waitandClick(clientSearchCancelButton, 20);
			if (CommonFunctions.waitForVisiblity(mainMenuPage.patientEntryIcon, 20))
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToTestLookup(BCLIS_MainMenuPage mainMenuPage) {
		try {
			CommonFunctions.waitandClick(testLookupLink, 20);

			if (CommonFunctions.waitForNewTabToOpen(2, 20)) {
				ArrayList<String> tabs = new ArrayList<String>();
				// Switch to new tab
				tabs = new ArrayList<String>(driver.getWindowHandles());
				Thread.sleep(5000);
				driver.switchTo().window(tabs.get(1));

				System.out.println("Redirected to: " + driver.getCurrentUrl());

				if (driver.getCurrentUrl().contains("Laboratory_Test_Information")) {
					Thread.sleep(5000);
					System.out.println("REDIRECTED TO Laboratory Test Information page.");
					Thread.sleep(2000);
					ObjectHelper.driver.close();
					Thread.sleep(2000);
					ObjectHelper.driver.switchTo().window(tabs.get(0));
					if (CommonFunctions.waitForVisiblity(mainMenuPage.patientEntryIcon, 20))
						return true;
					else
						return false;

				} else
					return false;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean logout() {
		try {
			CommonFunctions.waitandClick(logoutLink, 60);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}