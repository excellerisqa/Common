package lars.objects;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_InvoicePage extends LoadableComponent<LARS_InvoicePage> {

	@FindBy(id = "invoiceIdGo")
	public WebElement searchButton;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;

	@FindBy(id = "requestInput")
	public WebElement requestNumberTextbox;

	@FindBy(id = "invoiceIdInput")
	public WebElement invoiceIdTextbox;

	@FindBy(xpath = "//div[contains(@class,'accessionTitle')]")
	public List<WebElement> accessionTitle;

	@FindBy(id = "paymentPsc")
	public WebElement pscTextbox;

	@FindBy(id = "paymentAmount")
	public WebElement paymentAmountTextbox;

	@FindBy(xpath = "//form[@id='paymentForm']//select")
	public WebElement paymentTypeDropdown;

	@FindBy(id = "paymentGo")
	public WebElement addButton;

	@FindBy(xpath = "//div/b[text()='Balance:']/../following-sibling::div")
	public WebElement balanceAmount;

	@FindBy(xpath = "//button[contains(text(),'Check Out')]")
	public WebElement checkoutButton;

	@FindBy(xpath = "//span[@class = 'ng-binding ng-scope']")
	public List<WebElement> checkoutMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Invoices')]")
	public WebElement headerText;
	
	@FindBy(xpath = "//div[contains(text(),'Invoice')]")
	public WebElement invoiceTitle;
	
	@FindBy(xpath = "//div/b[text()='Balance:']")
	public WebElement balanceLabel;
	
	@FindBy(xpath = "//div/b[text()='Grand Total:']")
	public WebElement grandTotalLabel;
	
	
	
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	WebDriver driver = null;

	public LARS_InvoicePage(WebDriver driver) {
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

	public boolean searchInvoiceByAccessionNumber(String accessionNumber) {

		try {
			Thread.sleep(5000);
			requestNumberTextbox.clear();
			requestNumberTextbox.sendKeys(accessionNumber);
			Thread.sleep(2000);
			searchButton.click();

			return verifySearchResultAccessionNumberAndAmount(accessionNumber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchInvoiceByInvoiceId(String invoiceId, String accessionNumber) {

		try {
			spinnersChecking();
			invoiceIdTextbox.clear();
			invoiceIdTextbox.sendKeys(invoiceId);
			Thread.sleep(2000);
			searchButton.click();
			spinnersChecking();
			return verifySearchResultAccessionNumberAndAmount(accessionNumber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

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

	public boolean verifySearchResultAccessionNumberAndAmount(String accessionNumber) {

		try {
			CommonFunctions.waitForVisiblity(accessionTitle.get(0), 30);
			String amount = accessionTitle.get(3).getText();
			System.out.println("Amount of the tests displayed: " + amount);
			System.out.println("Accession Number displayed: " + accessionTitle.get(0).getText());
			return accessionTitle.get(0).getText().equals(accessionNumber) && amount.contains("$")
					&& Float.parseFloat(amount.substring(1)) > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean checkoutInvoice(String psc, String amount, String paymentType) {

		try {
			spinnersChecking();
			pscTextbox.clear();
			pscTextbox.sendKeys(psc.split("-")[0].trim());
			paymentAmountTextbox.clear();
			if (amount.equalsIgnoreCase("balance"))
				paymentAmountTextbox.sendKeys(balanceAmount.getText().substring(1));
			else
				paymentAmountTextbox.sendKeys(amount);

			Select payType = new Select(paymentTypeDropdown);
			payType.selectByVisibleText(paymentType);

			Thread.sleep(2000);

			addButton.click();
			spinnersChecking();
			if (CommonFunctions.waitForVisiblity(checkoutMessage.get(0), 10)) {
				Thread.sleep(2000);
				System.out.println(checkoutMessage.get(0).getText());
				if (!(checkoutMessage.get(0).getText().contains("Please checkout to complete this invoice."))) {
					return false;
				} else {
					Thread.sleep(2000);
					checkoutButton.click();
				}
			} else
				return false;

			// if (CommonFunctions.waitForVisiblity(checkoutMessage.get(1), 10)) {
			Thread.sleep(2000);
			System.out.println(checkoutMessage.get(1).getText());
			return (checkoutMessage.get(1).getText().contains("Checkout completed."));
			// } else
			// return false;

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
	

	public boolean verifyInvoiceDetailInfo(String aInvoiceTotal, String aBalance) {

		int aInvoiceTotalResult = 0;
		int aBalanceResult = 0;
		int attempt = 3;
	//	String option = "";
		try {
			
			spinnersChecking();
			String checkBalance = roundUpTo2Decimal(aBalance);
			String checkInvoiceTotal = roundUpTo2Decimal(aInvoiceTotal);
			
			while (!(CommonFunctions.waitForVisiblity(invoiceTitle, 2) && CommonFunctions.waitForVisiblity(balanceLabel, 2)) && attempt != 0) {
				ObjectHelper.driver.navigate().refresh();
				spinnersChecking();
				attempt--;
	//			System.out.print("attempt" + attempt);
			}	
			if (ObjectHelper.driver.findElement(By.xpath("//div/b[text()='Balance:']/../following-sibling::div")).getText().equals(checkBalance)) {	
				aBalanceResult = 1;
			}
			if (ObjectHelper.driver.findElement(By.xpath("//div/b[text()='Grand Total:']/../following-sibling::div[2]")).getText().equals(checkInvoiceTotal)) {	
				aInvoiceTotalResult = 1;
			}
			
			if(aBalanceResult == 1 && aInvoiceTotalResult == 1){
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String roundUpTo2Decimal(String aAmountString) {
		
		String aAmount = " ";
		if (aAmountString != "" || aAmountString != "null") {
	        try {
	            Double price = Double.valueOf(aAmountString);
	            DecimalFormat format = new DecimalFormat("0.00");
	            /* remove -sign */
	            if (price < 0) {
	            	price = Math.abs(price);
	            	aAmount = "("+"$"+format.format(price)+")";
	            }
	            else
	            	aAmount = "$"+format.format(price);        
	        
	        } catch (Exception ex){ 
	        }
	    }
		return aAmount;
	}
	
	public String getInvoice() {

		String invoiceTotal = "";
		int attempt = 3;
	//	String option = "";
		try {
			
			spinnersChecking();
			
			while (!(CommonFunctions.waitForVisiblity(invoiceTitle, 2) && CommonFunctions.waitForVisiblity(balanceLabel, 2)) && attempt != 0) {
				ObjectHelper.driver.navigate().refresh();
				spinnersChecking();
				attempt--;
			}
	
			invoiceTotal =  ObjectHelper.driver.findElement(By.xpath("//div/b[text()='Grand Total:']/../following-sibling::div[2]")).getText();
			return invoiceTotal;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return invoiceTotal;
		}
	}

}