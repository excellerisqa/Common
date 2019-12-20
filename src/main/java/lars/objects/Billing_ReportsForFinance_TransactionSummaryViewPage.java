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

public class Billing_ReportsForFinance_TransactionSummaryViewPage extends LoadableComponent<Billing_ReportsForFinance_TransactionSummaryViewPage> {

	@FindBy(xpath = "//span[text()='Start Date']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement startDateInput;
	
	@FindBy(xpath = "//span[text()='End Date']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement endDateInput;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement viewReportBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Loading')]")
	public WebElement spinners;
	
	
	WebDriver driver = null;
	
	String dateOfService = "Date Of Service";

	public Billing_ReportsForFinance_TransactionSummaryViewPage(WebDriver driver) {
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
	
	public boolean verifyReportNameAndTimeBucketsAndColumn(String[] aChecks) {
	
		int columnsResults = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
				
				
		//		CommonFunctions.waitandClear(selectSummaryDateInput, 30);
				//prefixInput.clear();
		//		selectSummaryDateInput.sendKeys(aSelectSummaryDate);
				
				//overdueTrueCheckbox.click();
				
				
	
				//CommonFunctions.waitandClick(viewReportBtn, 30);
		//		viewReportBtn.click();
				
		//		spinnersChecking();
	//			columnsResults = ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'" + aDateOfServiceColumn + "')]")).size();	
	
				//Check period bucket and Column
				for(int i=2; i<=9; i++) {
					columnsResults = columnsResults + ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aChecks[i] + "')]")).size();	
				}
				
				//check page title if there is
				columnsResults = columnsResults + ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aChecks[11] + "')]")).size();
				
				System.out.println("Number of Columns for this table found: " + columnsResults);
	
				if (columnsResults == 9) {
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
	
	public boolean verifyInterestValue(String aStartDate, String aInterestValue) {
	
		int interestValueResults = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
				
				
				CommonFunctions.waitandClear(startDateInput, 30);
				startDateInput.sendKeys(aStartDate);
				
				CommonFunctions.waitandClear(endDateInput, 30);
				endDateInput.sendKeys(aStartDate);
				
	
				viewReportBtn.click();
				
				spinnersChecking();
				aInterestValue = "($"+aInterestValue.substring(0, aInterestValue.length()-2)+")";
//				interestValueResults = ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'" + aInterestValue + "')]")).size();	
				interestValueResults = ObjectHelper.driver.findElements(By.xpath("//div[text()='" + aInterestValue + "']")).size();	
				System.out.println("Number of Columns for this table found: " + interestValueResults + " " +aStartDate + " " +aInterestValue);	
	
				if (interestValueResults == 2) {
					checkFlag = true;
				}
				return (checkFlag);
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
	
}








	


	
