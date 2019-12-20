package lars.objects;

import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class Report_BillingBC_BAInvoiceIFHPPage extends LoadableComponent<Report_BillingBC_BAInvoiceIFHPPage> {

	@FindBy(xpath = "//span[text()='Invoice Number']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement invoiceNumberInput;
	
	
	@FindBy(xpath = "//input[@value='rbTrue']")
	public WebElement overdueTrueCheckbox;
	
	@FindBy(xpath = "//input[@value='rbFalse']")
	public WebElement overdueFalseCheckbox;
	
		
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement viewReportBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Loading')]")
	public WebElement spinners;
	
	
	WebDriver driver = null;
	
	String dateOfService = "Date Of Service";

	public Report_BillingBC_BAInvoiceIFHPPage(WebDriver driver) {
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

	
	
	public int verifySearchResultInvoices(String aInvoices) {
		
		

		try {
			int aInvoicesResult = 0;
			try {

					spinnersChecking();
					
					CommonFunctions.waitandClear(invoiceNumberInput, 30);
					//prefixInput.clear();
					invoiceNumberInput.sendKeys(aInvoices);
					
					overdueTrueCheckbox.click();
					
					
		
					CommonFunctions.waitandClick(viewReportBtn, 30);
					
					//Thread.sleep(5000);
					spinnersChecking();
					aInvoicesResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aInvoices + "')]")).size();	
		
					System.out.println("Number of bill Status for this table found: " + aInvoicesResult);
		
					return aInvoicesResult;

			} catch (Exception e) {
				return aInvoicesResult;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
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



	/**
	 * DESCRIPTION: Verify if fee code column exist,
	 * RETURNS: list if result:
	 */
	
	public boolean searchDateOfServiceColumn(String aDateOfServiceColumn, String aInvoice) {
	
		int aDateOfServiceColumnResult = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
				
				CommonFunctions.waitandClear(invoiceNumberInput, 30);
				//prefixInput.clear();
				invoiceNumberInput.sendKeys(aInvoice);
				
				//overdueTrueCheckbox.click();
				
				
	
				//CommonFunctions.waitandClick(viewReportBtn, 30);
				viewReportBtn.click();
				
				spinnersChecking();
				aDateOfServiceColumnResult = ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'" + aDateOfServiceColumn + "')]")).size();	
	
		
				
				System.out.println("Number of Date of Service Column for this table found: " + aDateOfServiceColumnResult);
	
				if (aDateOfServiceColumnResult == 1) {
					checkFlag = true;
				}
				return (checkFlag);
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
	
	/**
	 * DESCRIPTION: Verify if fee code column exist,
	 * RETURNS: list if result:
	 */
	
	public boolean searchOrderingDoctor(String aOrderingDoctor, String aInvoice) {
	
		int aOrderingDoctorResult = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
				
				CommonFunctions.waitandClear(invoiceNumberInput, 30);
				//prefixInput.clear();
				invoiceNumberInput.sendKeys(aInvoice);
				
				//overdueTrueCheckbox.click();
				
				
	
				//CommonFunctions.waitandClick(viewReportBtn, 30);
				viewReportBtn.click();
				
				spinnersChecking();
				aOrderingDoctorResult = ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'" + aOrderingDoctor + "')]")).size();	
	
		
				
				System.out.println("Number of Ordering Doctor for this table found: " + aOrderingDoctorResult);
	
				if (aOrderingDoctorResult == 1) {
					checkFlag = true;
				}
				return (checkFlag);
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
}








	


	
