package lars.objects;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class Report_BillingBC_BAInvoiceIFHP_DOBPage extends LoadableComponent<Report_BillingBC_BAInvoiceIFHP_DOBPage> {

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
	
	@FindBy(xpath = "//input[@id='ctl32_ctl05_ctl00_Next_ctl00_ctl00']")
	public WebElement nextPageImage;
	
	@FindBy(xpath = "//td[contains(text(),'AdjustmentSelfPayInvoicedMore365Days')]")
	public WebElement pageTitle;
	
	
	WebDriver driver = null;
	
	String dateOfService = "Date Of Service";
	private static SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private static SimpleDateFormat outSDF = new SimpleDateFormat("M/d/yyyy");

	public Report_BillingBC_BAInvoiceIFHP_DOBPage(WebDriver driver) {
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
					
		//			overdueTrueCheckbox.click();
					
					
		
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



	/**
	 * DESCRIPTION: Verify if fee code column exist,
	 * RETURNS: list if result:
	 */
	
	public boolean verifyRowData(String[] aData, int aIndex) {
	
		int columnsResults = 0;
		boolean checkFlag = false;
		boolean nextPage = false;
		int maxRowSizePerPage = 37;
		
		try {
			
			//check if there is next page
			if (aIndex > maxRowSizePerPage-2) {
			//	while (pageTitle.isDisplayed()) {
				while (driver.findElements(By.xpath("//div[contains(text(),'AdjustmentSelfPayInvoicedMore365Days')]")).size()!=0 && nextPageImage.isEnabled()) {	
					nextPageImage.click();
					spinnersChecking();
					Thread.sleep(2000);
				}
			}
			
			
			//locate the table
			WebElement mytable =  ObjectHelper.driver.findElement(By.xpath("*//table[@cols='13']/tbody"));
			//locate rows of table
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			
			// Calculate no of rows in table
			int rows_count = rows_table.size(); //38
			
			
			
			
			// check if it is next page already. Reset the table index to -1 by substracting table size in last page.
			if (aIndex > maxRowSizePerPage-2) {
				aIndex = aIndex - maxRowSizePerPage;
			}
			
			List<WebElement> Columns_row = rows_table.get(aIndex+2).findElements(By.tagName("td"));
			
		//	List<WebElement> Columns_row = rows_table.get(aIndex).findElements(By.xpath("td/div"));
			
			int columns_count = Columns_row.size();
			//	size of data > table size in page 1
			for (int column=0; column<columns_count; column++) {
					String celText = Columns_row.get(column).getText();
					aData[column] = formatData(aData[column], column);
					if (celText.equals(aData[column])){
						columnsResults ++;	
					}
			}	
			System.out.println("Number of Columns for this table found: " + columnsResults +"Invoice: "+aData[0]+ " for table row = "+aIndex);
			if (columnsResults == 13) {
					checkFlag = true;
			}
		} catch (Exception e) {
			return checkFlag;
		}
		return checkFlag;
	}



	public String formatData(String aData, int aColumnIndex) {
		
		try {
			switch(aColumnIndex){
				//invoice date
				case 1:
					aData = formatToReportDate(aData);
					break;
				//adjustment amount
				case 4:
					aData = roundUpTo2Decimal(aData);
					break;
				//DOB
				case 7:
					aData = formatToReportDate(aData);
					break;
				//date of service
				case 10:
					aData = formatToReportDate(aData);
					break;
				//invoice amount
				case 11:
					aData = roundUpTo2Decimal(aData);
					break;
				//invoice due Date
				case 12:
					aData = formatToReportDate(aData);
					break;
				default:
					if (aData.equals("null") || aData.equals("")){
						aData = " ";
					}	
			}	
		}catch (ParseException ex){ 
	    }	
		return aData;	
	}



	public String formatToReportDate(String aDateString) throws ParseException {
		
		    String outDate = "";
			if (aDateString != null) {
		        try {
		            
		  //      	aDateString = aDateString.substring(0, 10).trim();
		        	Date date = inSDF.parse(aDateString);
		            outDate = outSDF.format(date);
		        } catch (ParseException ex){ 
		        }
		    }
		    return outDate;
		
	}



	public String roundUpTo2Decimal(String aAmountString) {
		
		String aAmount = " ";
		if (aAmountString != "" || aAmountString != "null") {
	        try {
	            Double price = Double.valueOf(aAmountString);
	            DecimalFormat format = new DecimalFormat("0.00");
	            aAmount = "$"+format.format(price);        
	        
	        } catch (Exception ex){ 
	        }
	    }
		return aAmount;
	}
	
}








	


	
