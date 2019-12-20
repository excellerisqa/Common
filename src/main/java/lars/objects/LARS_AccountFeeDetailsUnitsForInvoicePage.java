package lars.objects;

import java.text.DecimalFormat;
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

public class LARS_AccountFeeDetailsUnitsForInvoicePage extends LoadableComponent<LARS_AccountFeeDetailsUnitsForInvoicePage> {

	@FindBy(xpath = "//span[text()='Invoice Number']/..//../following-sibling::td[1]//input[contains(@id,'txtValue')]")
	public WebElement invoiceNumberInput;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement viewReportBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Loading')]")
	public WebElement spinners;
	
	@FindBy(xpath = "//input[@id='ctl32_ctl05_ctl00_Last_ctl00_ctl00']")
	public WebElement lastPageImage;
	
	@FindBy(xpath = "//select[@name='ctl32$ctl04$ctl03$ddValue']")
	public WebElement accountDropDown;
	
	@FindBy(xpath = "//select[@name='ctl32$ctl04$ctl05$ddValue']")
	public WebElement yearDropDown;
	
	@FindBy(xpath = "//select[@name='ctl32$ctl04$ctl07$ddValue']")
	public WebElement invoiceDropDown;
	
	@FindBy(xpath = "//select[@name='ctl32$ctl04$ctl09$ddValue']")
	public WebElement showTestCodeDropDown;
	
	@FindBy(xpath = "//select[@name='ctl32$ctl04$ctl11$ddValue']")
	public WebElement optionDropDown;
	
	
	@FindBy(xpath = "//a[contains(text(), 'Account Fee Details for Invoice')]")
	public WebElement headerText;
	
	@FindBy(xpath = "//span[contains(@id,'TotalPages')]")
	public WebElement totalPage;
	
	@FindBy(xpath = "//img[@id='ctl32_ctl05_ctl04_ctl00_ButtonImg']")
	public WebElement saveIcon;
	
	@FindBy(xpath = "//a[@title='Excel']")
	public WebElement excelMenuItem;
		
	
	WebDriver driver = null;
	
	String dateOfService = "Date Of Service";

	public LARS_AccountFeeDetailsUnitsForInvoicePage(WebDriver driver) {
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
	 * DESCRIPTION: Verify if CVV exist,
	 * RETURNS: list if result:
	 */
	
	public boolean searchCVV(String aCVV, String aInvoice) {
	
		int aCVVResult = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
				
				CommonFunctions.waitandClear(invoiceNumberInput, 30);
				//prefixInput.clear();
				invoiceNumberInput.sendKeys(aInvoice);
				
				// overdueTrueCheckbox.click();
				
				
	
				//CommonFunctions.waitandClick(viewReportBtn, 30);
				viewReportBtn.click();
				spinnersChecking();
				
				
				//click end button if more than 1 page return
				if (lastPageImage.isEnabled()){
				
					lastPageImage.click();
					Thread.sleep(2000);
					spinnersChecking();
				}
				
				aCVVResult = ObjectHelper.driver.findElements(By.xpath("//span[contains(text(),'" + aCVV + "')]")).size();	
	
				
				
				System.out.println("Number of CVV found: " + aCVVResult);
	
				if (aCVVResult == 1) {
					checkFlag = true;
				}
				return (checkFlag);
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
	
	/**
	 * DESCRIPTION: Verify if DVA address updated,
	 * RETURNS: list if result:
	 */
	
	public boolean searchDVA(String[] aData, String aInvoice) {
	
		int aAddressResult = 0;
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
				
				
				
				for(int i=2; i<aData.length; i++) {
					aAddressResult = aAddressResult + ObjectHelper.driver.findElements(By.xpath("//span[contains(text(),'" + aData[i] + "')]")).size();	
				}	
				
				
				System.out.println("Number of address found: " + aAddressResult);
	
				if (aAddressResult == 7) {
					checkFlag = true;
				}
				return (checkFlag);
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
	public String getInvoiceAmount_bk(String[] aRowData) {

		String invoiceTotalAmount = "";
		try {

	//				spinnersChecking();
					
					Select accountDropdown = new Select(accountDropDown);
					accountDropdown.selectByVisibleText(aRowData[1]);
					spinnersChecking();
					
					Select yearDropdown = new Select(yearDropDown);
					yearDropdown.selectByVisibleText(aRowData[2]);
					spinnersChecking();
					
					Select invoiceDropdown = new Select(invoiceDropDown);
				//	invoiceDropdown.selectByVisibleText(aRowData[3]);
					
					
				//	invoiceDropdown.selectByValue(aRowData[3]);
					
					
					List<WebElement> options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl07$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[6])) {
					        option.click();
					        break;
					    }
					}
					spinnersChecking();
					
					
					Select showTestCodeDropdown = new Select(showTestCodeDropDown);
					showTestCodeDropdown.selectByVisibleText(aRowData[4]);
					spinnersChecking();
					
					Select optionDropdown = new Select(optionDropDown);
					optionDropdown.selectByValue(aRowData[5]);
					spinnersChecking();
					
					
					
				
					
					
					viewReportBtn.click();			
		
					spinnersChecking();
					
					//click end button if total page = 2 ?
					if (totalPage.getText().endsWith("?")){
					
						lastPageImage.click();
						Thread.sleep(2000);
						spinnersChecking();
						
	//					totalPageNumber = Integer.valueOf(Integer.valueOf(totalPage.getText()));
					}
					
					invoiceTotalAmount = ObjectHelper.driver.findElement(By.xpath("//div[contains(text(),'Grand Total:')]/..//../following-sibling::td[2]//div")).getText();	
		
					System.out.println("Invoice Total Amount: " + invoiceTotalAmount);
		
					return invoiceTotalAmount;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return invoiceTotalAmount;
		}
	}
	
	public String getInvoiceAmount(String aInvoiceID, String aYear, String[] aRowData) {

		String invoiceTotalAmount = "";
		try {

					Select accountDropdown = new Select(accountDropDown);
					
					List<WebElement> options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl03$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[1])) {
					        option.click();
					        break;
					    }
					}
					
					options.clear();
					spinnersChecking();
					
					Select yearDropdown = new Select(yearDropDown);
					yearDropdown.selectByVisibleText(aYear);
					spinnersChecking();
					
					Select invoiceDropdown = new Select(invoiceDropDown);
			
					
					options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl07$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aInvoiceID)) {
					        option.click();
					        break;
					    }
					}
					spinnersChecking();
					options.clear();
					
					
					Select showTestCodeDropdown = new Select(showTestCodeDropDown);
					showTestCodeDropdown.selectByVisibleText(aRowData[4]);
					spinnersChecking();
					
					Select optionDropdown = new Select(optionDropDown);
					optionDropdown.selectByValue(aRowData[5]);
					spinnersChecking();
					
					
					viewReportBtn.click();			
		
					spinnersChecking();
					
					//click end button if total page = 2 ?
					if (totalPage.getText().endsWith("?")){
					
						lastPageImage.click();
						Thread.sleep(2000);
						spinnersChecking();
					}
					
					if(ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'Grand Total:')]/..//../following-sibling::td[2]//div")).size()>0) {
						invoiceTotalAmount = ObjectHelper.driver.findElement(By.xpath("//div[contains(text(),'Grand Total:')]/..//../following-sibling::td[2]//div")).getText();	
					}	
	//				System.out.println("Invoice Total Amount: " + formatAmount(invoiceTotalAmount));
		
					return formatAmount(invoiceTotalAmount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return invoiceTotalAmount;
		}
	}

	public String formatAmount(String aStringAmount) {
		
		if(aStringAmount.equals("")) {
			return aStringAmount;
		}
		else {
			aStringAmount = aStringAmount.substring(1);
	//		aStringAmount = "0.00";
			double amount = Double.parseDouble(aStringAmount);
			if(amount>0) {
				DecimalFormat formatter = new DecimalFormat("#,###.00");
				return "$"+formatter.format(amount).toString();
			}
			else
				return "$"+aStringAmount;
		}	
	}
	
	
	public boolean verifyTestCodeColumn(boolean testCodeColumnDisplay, String[] aRowData) {

		boolean result = false;
		try {

					Select accountDropdown = new Select(accountDropDown);
					
					List<WebElement> options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl03$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[1])) {
					        option.click();
					        break;
					    }
					}
					
					options.clear();
					spinnersChecking();
					
					Select yearDropdown = new Select(yearDropDown);
					yearDropdown.selectByVisibleText(aRowData[2]);
					spinnersChecking();
					
					Select invoiceDropdown = new Select(invoiceDropDown);
			
					
					options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl07$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[3])) {
					        option.click();
					        break;
					    }
					}
					spinnersChecking();
					options.clear();
					
					
					Select showTestCodeDropdown = new Select(showTestCodeDropDown);
					showTestCodeDropdown.selectByVisibleText(aRowData[4]);
					spinnersChecking();
					
					Select optionDropdown = new Select(optionDropDown);
					optionDropdown.selectByValue(aRowData[5]);
					spinnersChecking();
					
					
					viewReportBtn.click();			
		
					spinnersChecking();
					
					if(testCodeColumnDisplay == true) {
						if(ObjectHelper.driver.findElements(By.xpath("//td//div[contains(text(),'Test Code')]")).size()>0) 
							result = true;
					}
					else {
						if(ObjectHelper.driver.findElements(By.xpath("//td//div[contains(text(),'Test Code')]")).size()==0) 
							result = true;
					}
	//				System.out.println("Invoice Total Amount: " + formatAmount(invoiceTotalAmount));
		
					return result;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return result;
		}
	}

	public boolean verifyZeroDollarFee(boolean zeroDollarFeeDisplay, String[] aRowData) {

		boolean result = false;
		try {

					Select accountDropdown = new Select(accountDropDown);
					
					List<WebElement> options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl03$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[1])) {
					        option.click();
					        break;
					    }
					}
					
					options.clear();
					spinnersChecking();
					
					Select yearDropdown = new Select(yearDropDown);
					yearDropdown.selectByVisibleText(aRowData[2]);
					spinnersChecking();
					
					Select invoiceDropdown = new Select(invoiceDropDown);
			
					
					options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl07$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[3])) {
					        option.click();
					        break;
					    }
					}
					spinnersChecking();
					options.clear();
					
					
					Select showTestCodeDropdown = new Select(showTestCodeDropDown);
					showTestCodeDropdown.selectByVisibleText(aRowData[4]);
					spinnersChecking();
					
					Select optionDropdown = new Select(optionDropDown);
					optionDropdown.selectByValue(aRowData[5]);
					spinnersChecking();
					
					
					viewReportBtn.click();			
		
					spinnersChecking();
					
					if(zeroDollarFeeDisplay == true) {
						if(ObjectHelper.driver.findElements(By.xpath("//td//div[contains(text(),'$0.00')]")).size()>0) 
							result = true;
					}
					else {
						if(ObjectHelper.driver.findElements(By.xpath("//td//div[contains(text(),'$0.00')]")).size()==0) 
							result = true;
					}
	//				System.out.println("Invoice Total Amount: " + formatAmount(invoiceTotalAmount));
		
					return result;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return result;
		}
	}
	
	
	public boolean exportToExcel(String[] aRowData) {

		boolean result = false;
		try {

					Select accountDropdown = new Select(accountDropDown);
					
					List<WebElement> options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl03$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[1])) {
					        option.click();
					        break;
					    }
					}
					
					options.clear();
					spinnersChecking();
					
					Select yearDropdown = new Select(yearDropDown);
					yearDropdown.selectByVisibleText(aRowData[2]);
					spinnersChecking();
					
					Select invoiceDropdown = new Select(invoiceDropDown);
			
					
					options = driver.findElements(By.xpath("//select[@name='ctl32$ctl04$ctl07$ddValue']/option"));

					for (WebElement option : options) {
					    if (option.getText().contains(aRowData[3])) {
					        option.click();
					        break;
					    }
					}
					spinnersChecking();
					options.clear();
					
					
					Select showTestCodeDropdown = new Select(showTestCodeDropDown);
					showTestCodeDropdown.selectByVisibleText(aRowData[4]);
					spinnersChecking();
					
					Select optionDropdown = new Select(optionDropDown);
					optionDropdown.selectByValue(aRowData[5]);
					spinnersChecking();
					
					
					viewReportBtn.click();			
		
					spinnersChecking();
					
					saveIcon.click();
					Thread.sleep(2000);
					excelMenuItem.click();
					
					// verify a file is downloaded
					//Thread.sleep(2000);
					if (CommonFunctions.waitForDownload("Account Fee Details for Invoice.xlsx"))
						result = true;
					else {
						Thread.sleep(2000);
						if (CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Account Fee Details for Invoice.xlsx"))
							result = true;
					}
	//				System.out.println("Invoice Total Amount: " + formatAmount(invoiceTotalAmount));
		
					return result;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return result;
		}
	}

}








	


	
