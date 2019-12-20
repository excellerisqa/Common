package lars.objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_MenuPage extends LoadableComponent<LARS_MenuPage> {

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle ng-binding') or contains(@class,'numberCircleSelected ng-binding')]")
	public List<WebElement> optionsList;
	
	
	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='1']")
	public WebElement selfPayOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='2']")
	public WebElement quotationOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='3']")
	public WebElement retrieveInvoiceByAccessionOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='4']")
	public WebElement retrieveInvoiceByInvoiceIdOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='5']")
	public WebElement endOfDaySummaryOption;

	//@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='10']")
	//public WebElement feeScheduleOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='10']")
	public WebElement feeScheduleOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='11']")
	public WebElement bankDepositOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='12']")
	public WebElement notificationOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='13']")
	public WebElement administrationOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='14']")
	public WebElement reportsOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='7']")
	public WebElement accessionOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='8']")
	public WebElement invoiceOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='6']")
	public WebElement mappingOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='9']")
	public WebElement feeCodeOption;
	
	@FindBy(name = "selfPayDate")
	public WebElement dateTextbox;

	@FindBy(id = "selfPayAccessionInput")
	public WebElement accessionNumberTextbox;

	@FindBy(id = "accessionGo")
	public WebElement searchButton;

	@FindBy(id = "podaccessionInput")
	public WebElement searchInvoiceByAccessionTextbox;

	@FindBy(id = "podaccessionGo")
	public WebElement searchInvoiceByAccessionButton;

	@FindBy(id = "podInvoiceInput")
	public WebElement searchInvoiceByInvoiceIdTextbox;

	@FindBy(id = "podInvoiceGo")
	public WebElement searchInvoiceByInvoiceIdButton;

	@FindBy(xpath = "//footer//span[@class='glyphicon glyphicon-barcode app-icon']/parent::div")
	public WebElement barcodeNumber;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-phone-alt app-icon']/parent::div")
	public WebElement phoneNumber;

	@FindBy(xpath = "//a[text()='Need Help? Contact Information Service ']")
	public WebElement helpLink;

	WebDriver driver = null;
	int numberOfOption = 14;

	public LARS_MenuPage(WebDriver driver) {
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

	public boolean verifyOptionsAvailableOnMenuPage_bk() {

		
		
		try {
			// Thread.sleep(5000);
			// if (!(endOfDaySummaryOption.isDisplayed()))
			CommonFunctions.waitForVisiblity(endOfDaySummaryOption, 30);
			Thread.sleep(6000);
			// if (CommonFunctions.waitForVisiblity(selfPayOption, 10)) {
			return (selfPayOption.isDisplayed() && quotationOption.isDisplayed()
					&& retrieveInvoiceByAccessionOption.isDisplayed() && retrieveInvoiceByInvoiceIdOption.isDisplayed()
					&& endOfDaySummaryOption.isDisplayed());
			// } else
			// System.out.println(e.getMessage());return false;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	
	@SuppressWarnings("null")
	public boolean verifyOptionsAvailableOnMenuPage() {

		boolean aOptionsAvailableOnMenuPageResult = false;
	//	List <WebElement> menuPageWebElementList = new ArrayList<WebElement>();
		
		int attempt = 3;
		
		
		try {
			
		//	menuPageWebElementList = loadWebElement(menuPageWebElementList);
			
			while (aOptionsAvailableOnMenuPageResult == false && attempt !=0) {
			
				spinnersChecking();
				//CommonFunctions.waitForVisiblity(reportsOption, 30);
				//Thread.sleep(6000);
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
		        //This will scroll the web page till end.		
		        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        //barcodeNumber.click();
				
	//			aOptionsAvailableOnMenuPageResult = CommonFunctions.waitForVisiblityList(menuPageWebElementList, 30); 
				
				aOptionsAvailableOnMenuPageResult = CommonFunctions.waitForVisiblityList(optionsList, 60, numberOfOption);
				
				if (aOptionsAvailableOnMenuPageResult == false) {
					
					CommonFunctions.waitandClick(lifelabsLogo, 30);
					Thread.sleep(2000);
					attempt--;
					System.out.println("Number of attempt: " + attempt);
					System.out.println("Option display result: " + aOptionsAvailableOnMenuPageResult);
				}
			}
			
			return aOptionsAvailableOnMenuPageResult;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}	
		
	
	
	
		
	public boolean goToSelfPayOption1(LARS_SelfPayPage selfPayPage) {

		try {
			CommonFunctions.waitandClick(selfPayOption, 20);
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(selfPayPage.searchButton, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToQuotationOption2(LARS_QuotationPage quotationPage) {

		try {
			CommonFunctions.waitandClick(quotationOption, 20);
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(quotationPage.searchButton, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToRetrieveInvoiceByAccessionOption3(LARS_InvoicePage invoicePage) {

		try {
			CommonFunctions.waitandClick(retrieveInvoiceByAccessionOption, 20);
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(invoicePage.searchButton, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToRetrieveInvoiceByInvoiceIdOption4(LARS_InvoicePage invoicePage) {

		try {
			CommonFunctions.waitandClick(retrieveInvoiceByInvoiceIdOption, 20);
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(invoicePage.searchButton, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToEndOfDaySummaryOption5(LARS_EndOfDayPage endOfDayPage) {

		try {
			CommonFunctions.waitandClick(endOfDaySummaryOption, 20);
			spinnersChecking();

			return CommonFunctions.waitForVisiblity(endOfDayPage.selectPscDropdown, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean goToFeeCodeOption9(LARS_FeesPage feesPage) {

		try {
			// Thread.sleep(3000);
			CommonFunctions.waitandClick(feeCodeOption, 30);
			return CommonFunctions.waitForVisiblity(feesPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToFeeScheduleOption10(LARS_FeeSchedulesPage feeSchedulesPage) {

		try {
			// Thread.sleep(3000);
			CommonFunctions.waitandClick(feeScheduleOption, 30);
			return CommonFunctions.waitForVisiblity(feeSchedulesPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToBankDepositOption11(LARS_BankDepositPage bankDepositPage) {

		try {
			// Thread.sleep(3000);
			CommonFunctions.waitandClick(bankDepositOption, 30);
			return CommonFunctions.waitForVisiblity(bankDepositPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean goToAdministrationOption12(LARS_NotificationPage notificationPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			Thread.sleep(5000);
			CommonFunctions.waitandClick(notificationOption, 30);
			return CommonFunctions.waitForVisiblity(notificationPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToAdministrationOption13(LARS_AdministrationOperationsPage administrationOperationsPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			Thread.sleep(5000);
			CommonFunctions.waitandClick(administrationOption, 30);
			return CommonFunctions.waitForVisiblity(administrationOperationsPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean goToReportsOption14(LARS_ReportsPage larsReportPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			Thread.sleep(5000);
			CommonFunctions.waitandClick(reportsOption, 30);
			return CommonFunctions.waitForVisiblity(larsReportPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
/*	
	public boolean goToAccessionOption7(LARS_AccessionPage accessionPage) {

		try {
			CommonFunctions.waitandClick(accessionOption, 20);
			return CommonFunctions.waitForVisiblity(accessionPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
*/	
	public boolean goToAccessionOption7(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			CommonFunctions.waitandClick(accessionOption, 20);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToInvoiceOption8(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			
			CommonFunctions.waitandClick(invoiceOption, 20);
			Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean goToMappingOption6(LARS_CodeMappingPage codeMappingPage) {

		try {
			
			CommonFunctions.waitandClick(mappingOption, 20);
			Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(codeMappingPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean searchSelfPayFromMenuPageByDateAndAccessionNumber(String dateToSearch, String accessionNumber,
			LARS_SelfPayPage selfPayPage) {

		try {
			if (dateToSearch.equalsIgnoreCase("today")) {// format required: Jul 13, 2018
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
				LocalDate localDate = LocalDate.now();
				dateToSearch = dtf.format(localDate);
				System.out.println(dateToSearch);
			}

			dateTextbox.clear();
			dateTextbox.sendKeys(dateToSearch);
			accessionNumberTextbox.sendKeys(accessionNumber);
			searchButton.click();

			return selfPayPage.verifySearchResultAccessionNumberAndAmount(accessionNumber);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchSelfPayFromMenuPageByAccessionNumber(String accessionNumber, LARS_SelfPayPage selfPayPage) {

		try {
			// TODO
			dateTextbox.clear();
			accessionNumberTextbox.sendKeys(accessionNumber);
			searchButton.click();

			return selfPayPage.verifySearchResultAccessionNumberAndAmount(accessionNumber);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchInvoiceByAccessionFromMenuPage(String accessionNumber, LARS_InvoicePage invoicePage) {

		try {
			searchInvoiceByAccessionTextbox.clear();
			searchInvoiceByAccessionTextbox.sendKeys(accessionNumber);
			searchInvoiceByAccessionButton.click();

			return invoicePage.verifySearchResultAccessionNumberAndAmount(accessionNumber);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchInvoiceByInvoiceIdFromMenuPage(String accessionNumber, String invoiceId,
			LARS_InvoicePage invoicePage) {

		try {
			searchInvoiceByInvoiceIdTextbox.clear();
			searchInvoiceByInvoiceIdTextbox.sendKeys(invoiceId);
			searchInvoiceByInvoiceIdButton.click();

			return invoicePage.verifySearchResultAccessionNumberAndAmount(accessionNumber);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyBarcode(String barcode) {

		try {
			Thread.sleep(2000);
			if (barcodeNumber.isDisplayed()) {
				return barcodeNumber.getText().contains(barcode);
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyPhoneNumber(String phone) {

		try {
			if (phoneNumber.isDisplayed()) {
				return phoneNumber.getText().equals(phone);
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyHelp(String mailto) {

		try {
			if (helpLink.isDisplayed()) {
				return helpLink.getAttribute("href").equals(mailto);
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<WebElement> loadWebElement(List<WebElement> aWebElementList) {

		/* check if the list has been loaded */
	//	if (aWebElementList.isEmpty()) {
				//aWebElementList.clear();
				aWebElementList.add(selfPayOption);
				aWebElementList.add(quotationOption);
				aWebElementList.add(retrieveInvoiceByAccessionOption);
				aWebElementList.add(retrieveInvoiceByInvoiceIdOption);
				aWebElementList.add(endOfDaySummaryOption);
				aWebElementList.add(mappingOption);
				aWebElementList.add(accessionOption);
				aWebElementList.add(invoiceOption);
				aWebElementList.add(feeCodeOption);
				aWebElementList.add(feeScheduleOption);
				aWebElementList.add(bankDepositOption);
				aWebElementList.add(notificationOption);
				aWebElementList.add(administrationOption);
				aWebElementList.add(reportsOption);
//		}
		
		return aWebElementList;
	}	
	
	public void spinnersChecking() {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		
		try {
			
			
				startTime2 = 4000;
				elapsedTime2 = startTime2 - 10;
				spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				
				while (spinnersExist == false && elapsedTime2 > 10) {
					elapsedTime2 = elapsedTime2 -10;
					spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				}
				// System.out.println("Spinners is not here or timeout: " + spinnersExist);
				
		} catch (Exception e) {
			System.out.println("Spinners is still here or timeout: " + spinnersExist);
		}
	}
		
}