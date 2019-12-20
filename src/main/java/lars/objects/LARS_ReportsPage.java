package lars.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_ReportsPage extends LoadableComponent<LARS_ReportsPage> {

	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	@FindBy(xpath = "//span[contains(text(),'Loading')]")
	public WebElement spinnersForReportingServer;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle ng-binding ng-scope') or contains(@class,'numberCircleSelected ng-binding ng-scope')]")
	public List<WebElement> optionsListBilling;
	
	@FindBy(xpath = "//div[@class = 'tab-pane ng-scope active']//div[contains(@class,'numberCircle ng-binding') or contains(@class,'numberCircleSelected ng-binding')]")
	public List<WebElement> optionsListFinance;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='1']")
	public WebElement badDebtReportOption;
	
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='2']")
	public WebElement baInvoiceBalanceLessThan5Option;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='3']")
	public WebElement billingInfoOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='4']")
	public WebElement dailyMSPOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='5']")
	public WebElement dailySelfPayPrintListOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='6']")
	public WebElement dataLoadAuditReportOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='7']")
	public WebElement invoicesWithRefundAndBalanceOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='8']")
	public WebElement accessionsWithBillStatusMinus1Option;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='9']")
	public WebElement monthEndBAInvoiceWithLinkOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='10']")
	public WebElement monthlyBAInvoicePrintListOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='11']")
	public WebElement weeklyBAInvoiceWithLInkOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='12']")
	public WebElement mspRejectedClaimsOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='13']")
	public WebElement selfPayInvoiceOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='14']")
	public WebElement mspRejectedFeesWithNoActionOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='15']")
	public WebElement remittanceBoardcastMessagesOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='16']")
	public WebElement accessionsWithFeeAwaitStatusOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='17']")
	public WebElement larsCollectionsReportOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='18']")
	public WebElement wcbOutstandingInvoiceOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='19']")
	public WebElement mspExplanatoryOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='20']")
	public WebElement mspAutoAdjustSummaryOption;
	
	//finanace tab
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='1']")
	public WebElement transactionSummaryOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='2']")
	public WebElement agingreportOption;

	@FindBy(xpath = "//divcontains(@class,'numberCircle') and text()='3']")
	public WebElement monthlyARTrialBalanceReportOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='4']")
	public WebElement depositViewDailyDetailOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='5']")
	public WebElement refundFReportOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='6']")
	public WebElement remittanceSummaryReportOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='7']")
	public WebElement monthlyMSPFeeDiscountingOption;

	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='8']")
	public WebElement volumeRevenueByDateFeeOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='9']")
	public WebElement invoiceVolumeSummaryByPSCOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='10']")
	public WebElement larsCollectionsReportSelfPayOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='11']")
	public WebElement businessAccountSummarybyInvoiceDateOption;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle') and text()='12']")
	public WebElement patientCountByPSCOption;
	
	
	@FindBy(xpath = "//a[contains(@href, 'Billing+Reports')]//div[contains(@class,'numberCircle') and text()='13']")
	public WebElement accountFeeDetailsUnitsForInvoicesOption;
	
	
	@FindBy(xpath = "//div[contains(text(),'LARS Reports')]")
	public WebElement headerText;
	
	@FindBy(xpath = "//span[contains(text(),'Finance')]")
	public WebElement financeTab;
	
	@FindBy(xpath = "//span[contains(text(),'Billing')]")
	public WebElement billingTab;
	

	WebDriver driver = null;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	int numberOfBillingOption = 20;
	int numberOfFinanceOption = 13;

	public LARS_ReportsPage(WebDriver driver) {
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

	public boolean verifyOptionsAvailableOnLARSReportBillingPage_bk() {

		try {

			spinnersChecking();
			CommonFunctions.waitForVisiblity(mspAutoAdjustSummaryOption, 10);

			return (badDebtReportOption.isDisplayed() && baInvoiceBalanceLessThan5Option.isDisplayed() && billingInfoOption.isDisplayed()
					&& dailyMSPOption.isDisplayed() && dailySelfPayPrintListOption.isDisplayed()
					&& dataLoadAuditReportOption.isDisplayed() && invoicesWithRefundAndBalanceOption.isDisplayed() 
					&& accessionsWithBillStatusMinus1Option.isDisplayed() && monthEndBAInvoiceWithLinkOption.isDisplayed()
					&& monthlyBAInvoicePrintListOption.isDisplayed() && weeklyBAInvoiceWithLInkOption.isDisplayed()
					&& mspRejectedClaimsOption.isDisplayed() && selfPayInvoiceOption.isDisplayed()
					&& mspRejectedFeesWithNoActionOption.isDisplayed() && remittanceBoardcastMessagesOption.isDisplayed() 
					&& accessionsWithFeeAwaitStatusOption.isDisplayed() && larsCollectionsReportOption.isDisplayed()
					&& wcbOutstandingInvoiceOption.isDisplayed() && mspExplanatoryOption.isDisplayed() 
					&& mspAutoAdjustSummaryOption.isDisplayed());

		} catch (Exception e) {
			System.out.println(e.getMessage());

			return false;
		}
	}
	
	
	public boolean verifyOptionsAvailableOnLARSReportBillingPage() {

		boolean aOptionsAvailableOnBillingPageResult = false;
	//	List <WebElement> menuPageWebElementList = new ArrayList<WebElement>();
		
		int attempt = 5;
		
		
		try {
			
		//	menuPageWebElementList = loadWebElement(menuPageWebElementList);
			
			while (aOptionsAvailableOnBillingPageResult == false && attempt !=0) {
			
				spinnersChecking();
				//CommonFunctions.waitForVisiblity(reportsOption, 30);
				//Thread.sleep(6000);
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
		        //This will scroll the web page till end.		
		        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        //barcodeNumber.click();
				
	//			aOptionsAvailableOnMenuPageResult = CommonFunctions.waitForVisiblityList(menuPageWebElementList, 30); 
				
				aOptionsAvailableOnBillingPageResult = CommonFunctions.waitForVisiblityList(optionsListBilling, 60, numberOfBillingOption);
				
				if (aOptionsAvailableOnBillingPageResult == false) {
					
					CommonFunctions.waitandClick(financeTab, 30);
					CommonFunctions.waitandClick(billingTab, 30);
					attempt--;
					System.out.println("Number of attempt: " + attempt);
					System.out.println("Option display result: " + aOptionsAvailableOnBillingPageResult);
				}
			}
			
			return aOptionsAvailableOnBillingPageResult;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}	
	
	
	
	public boolean verifyOptionsAvailableOnLARSReportFinancePage_bk() {

		try {

			
			CommonFunctions.waitandClick(financeTab, 10);
			spinnersChecking();
			CommonFunctions.waitForVisiblity(patientCountByPSCOption, 10);

			return (transactionSummaryOption.isDisplayed() && agingreportOption.isDisplayed() && monthlyARTrialBalanceReportOption.isDisplayed()
					&& depositViewDailyDetailOption.isDisplayed() && refundFReportOption.isDisplayed()
					&& remittanceSummaryReportOption.isDisplayed() && monthlyMSPFeeDiscountingOption.isDisplayed() 
					&& volumeRevenueByDateFeeOption.isDisplayed() && invoiceVolumeSummaryByPSCOption.isDisplayed()
					&& larsCollectionsReportSelfPayOption.isDisplayed() && businessAccountSummarybyInvoiceDateOption.isDisplayed()
					&& patientCountByPSCOption.isDisplayed());

		} catch (Exception e) {
			System.out.println(e.getMessage());

			return false;
		}
	}

	
	public boolean verifyOptionsAvailableOnLARSReportFinancePage() {

		boolean aOptionsAvailableOnFinancePageResult = false;
	//	List <WebElement> menuPageWebElementList = new ArrayList<WebElement>();
		
		int attempt = 3;
		
		
		
		try {
			
		//	menuPageWebElementList = loadWebElement(menuPageWebElementList);
			CommonFunctions.waitandClick(financeTab, 10);
			
			while (aOptionsAvailableOnFinancePageResult == false && attempt !=0) {
			
				spinnersChecking();
				//CommonFunctions.waitForVisiblity(reportsOption, 30);
				//Thread.sleep(6000);
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
		        //This will scroll the web page till end.		
		        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        //barcodeNumber.click();
				
	//			aOptionsAvailableOnMenuPageResult = CommonFunctions.waitForVisiblityList(menuPageWebElementList, 30); 
				
				aOptionsAvailableOnFinancePageResult = CommonFunctions.waitForVisiblityList(optionsListFinance, 60, numberOfFinanceOption);
				
				if (aOptionsAvailableOnFinancePageResult == false) {
					
					CommonFunctions.waitandClick(billingTab, 30);
					CommonFunctions.waitandClick(financeTab, 30);
					attempt--;
					System.out.println("Number of attempt: " + attempt);
					System.out.println("Option display result: " + aOptionsAvailableOnFinancePageResult);
				}
			}
			
			return aOptionsAvailableOnFinancePageResult;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}		
	
	
/*
	public boolean goToDataCenterOption1(LARS_DatacenterPage datacenterPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			CommonFunctions.waitandClick(dataCenterOption, 20);
			return CommonFunctions.waitForVisiblity(datacenterPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToPayeeOption2(LARS_PayeePage payeePage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			CommonFunctions.waitandClick(payeeOption, 20);
			return CommonFunctions.waitForVisiblity(payeePage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToCollectionCenterOption3(LARS_CollectionCenterPage collectionCenterPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			CommonFunctions.waitandClick(collectionCenterOption, 20);
			return CommonFunctions.waitForVisiblity(collectionCenterPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToPerformingCenterOption4(LARS_PerformingCenterPage performingCenterPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			CommonFunctions.waitandClick(performingCenterOption, 20);
			return CommonFunctions.waitForVisiblity(performingCenterPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToOrderingDoctorsOption5(LARS_OrderingDoctorPage orderingDoctorPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			CommonFunctions.waitandClick(orderingDoctorsOption, 20);
			return CommonFunctions.waitForVisiblity(orderingDoctorPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToPractionersOption6(LARS_PractitionersPage practitionersPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(3000);
			CommonFunctions.waitandClick(practitionersOption, 20);
			return CommonFunctions.waitForVisiblity(practitionersPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToAdjustmentsOption7(LARS_AdjustmentsPage adjustmentsPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			CommonFunctions.waitandClick(adjustmentsOption, 20);
			return CommonFunctions.waitForVisiblity(adjustmentsPage.headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
*/

	public boolean goToMenuPage(LARS_MenuPage menuPage) {
	
		try {
			// CommonFunctions.waitandClick(lifelabsLogo, 20);
			Thread.sleep(5000);
			lifelabsLogo.click();
			return menuPage.verifyOptionsAvailableOnMenuPage();
	
		} catch (Exception e) {
	
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void spinnersChecking() {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		
		try {
			
			
				startTime2 = 400;
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
	
	public void spinnersCheckingForReportingServer() {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		
		try {
			
			
				startTime2 = 400;
				elapsedTime2 = startTime2 - 10;
				spinnersExist = CommonFunctions.waitForInVisiblity(spinnersForReportingServer, 1);
				
				while (spinnersExist == false && elapsedTime2 > 10) {
					elapsedTime2 = elapsedTime2 -10;
					spinnersExist = CommonFunctions.waitForInVisiblity(spinnersForReportingServer, 1);
				}
				// System.out.println("Spinners is not here or timeout: " + spinnersExist);
				
		} catch (Exception e) {
			System.out.println("Spinners is still here or timeout: " + spinnersExist);
		}
	}
	
	public boolean goToAccountFeeDetailsUnitsForInvoicesOption13(LARS_AccountFeeDetailsUnitsForInvoicePage accountFeeDetailsUnitsForInvoicePage) {

		try {
			
			//ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			//if(verifyOptionsAvailableOnLARSReportFinancePage()) {
				CommonFunctions.waitandClick(accountFeeDetailsUnitsForInvoicesOption, 20);
				spinnersCheckingForReportingServer();
				return CommonFunctions.waitForVisiblity(accountFeeDetailsUnitsForInvoicePage.headerText, 10);
			
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}