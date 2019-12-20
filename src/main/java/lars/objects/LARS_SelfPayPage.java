package lars.objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_SelfPayPage extends LoadableComponent<LARS_SelfPayPage> {

	public static void main(String[] args) {
		// to test the class functions
		LARS_SelfPayPage page = new LARS_SelfPayPage(ObjectHelper.driver);
		System.out.println(page.searchByEnteringDate("today", ""));

	}

	@FindBy(id = "accessionGo")
	public WebElement searchButton;

	@FindBy(id = "accessionInput")
	public WebElement accessionNumberTextbox;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;

	@FindBy(id = "selfPayDate")
	public WebElement dateTextbox;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-calendar']")
	public WebElement calenderIcon;

	@FindBy(xpath = "//div[contains(@class,'accessionTitle')]")
	public List<WebElement> accessionTitle;

	@FindBy(xpath = "//button[contains(text(),'Check Out')]")
	public WebElement checkoutButton;

	@FindBy(xpath = "//span[@class = 'ng-binding ng-scope']")
	public WebElement checkoutMessage;

	@FindBy(xpath = "//a[@class='btn btn-secondary checkoutBtn ng-binding']")
	public WebElement printInvoiceButton;

	@FindBy(xpath = "//div[@class='col-sm-1 col-md-1 col-lg-1']/following-sibling::div")
	public List<WebElement> userDetails;

	@FindBy(xpath = "//div/b[text()='Balance:']/../following::div[contains(text(),'$')]")
	public WebElement balanceAmount;

	@FindBy(id = "paymentAmount")
	public WebElement paymentAmountTextbox;

	@FindBy(id = "paymentGo")
	public WebElement addButton;

	@FindBy(xpath = "//select[@data-ng-model='payment.paymentTypeSelected']")
	public WebElement paymentTypeDropdown;

	@FindBy(xpath = "//span[contains(text(),'Please checkout to complete this invoice')]")
	public WebElement messageToCheckout;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	WebDriver driver = null;

	public LARS_SelfPayPage(WebDriver driver) {
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

	public boolean searchBySelectingDate(String accessionNumber) {

		try {
			// TO DO calender selection
			return verifySearchResultAccessionNumberAndAmount(accessionNumber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByEnteringDate(String dateToSearch, String accessionNumber) {

		try {
			if (dateToSearch.equalsIgnoreCase("today")) {// format required: Jul 13, 2018
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
				LocalDate localDate = LocalDate.now();
				dateToSearch = dtf.format(localDate);
				System.out.println(dateToSearch);
			}
			CommonFunctions.waitandClear(dateTextbox, 10);
			dateTextbox.sendKeys(dateToSearch);
			searchButton.click();

			return verifySearchResultAccessionNumberAndAmount(accessionNumber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByAccessionNumber(String accessionNumber) {

		try {
			// CommonFunctions.waitandClear(accessionNumberTextbox, 10);

			Thread.sleep(2000);
			spinnersChecking();
			accessionNumberTextbox.clear();
			accessionNumberTextbox.sendKeys(accessionNumber);
			Thread.sleep(2000);
			searchButton.click();
			spinnersChecking();

			return verifySearchResultAccessionNumberAndAmount(accessionNumber);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByAccessionNumberWithNoPP(String accessionNumber) {

		try {
			// CommonFunctions.waitandClear(accessionNumberTextbox, 10);
			// dateTextbox.clear();
			spinnersChecking();
			Thread.sleep(3000);
			accessionNumberTextbox.clear();
			accessionNumberTextbox.sendKeys(accessionNumber);
			Thread.sleep(3000);
			searchButton.click();

			return CommonFunctions.waitForVisiblity(
					By.xpath("//span[text()='Accession " + accessionNumber + " does not contain any self pay tests']"),
					20);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByDateAndAccessionNumber(String dateToSearch, String accessionNumber) {

		try {
			Thread.sleep(2000);
			spinnersChecking();
			if (dateToSearch.equalsIgnoreCase("today")) {// format required: Jul 13, 2018
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
				LocalDate localDate = LocalDate.now();
				dateToSearch = dtf.format(localDate);
				System.out.println(dateToSearch);
			}

			dateTextbox.clear();
			dateTextbox.sendKeys(dateToSearch);
			accessionNumberTextbox.sendKeys(accessionNumber);
			Thread.sleep(2000);
			searchButton.click();
			spinnersChecking();
			return verifySearchResultAccessionNumberAndAmount(accessionNumber);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifySearchResultAccessionNumberAndAmount(String accessionNumber) {

		try {
			spinnersChecking();
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

	// public boolean verifySearchResultAmount() {
	//
	// try {
	// String amount = accessionTitle.get(3).getText();
	// System.out.println("Amount of the tests displayed: " + amount);
	// return amount.contains("$") && Float.parseFloat(amount.substring(1)) > 0;
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// return false;
	// }
	// }

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

	public boolean checkout() throws Exception {

		try {
			Thread.sleep(5000);
			// String balance = balanceAmount.getText();
			// paymentAmountTextbox.sendKeys(balance);
			// Select paymentType = new Select(paymentTypeDropdown);
			// paymentType.selectByValue("0"); // cash
			// addButton.click();
			// CommonFunctions.waitForVisiblity(messageToCheckout, 10);
			// Thread.sleep(3000);
			checkoutButton.click();
			spinnersChecking();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean printInvoice() throws Exception {

		try {
			CommonFunctions.waitandClick(printInvoiceButton, 20);
			spinnersChecking();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String getCheckoutMessage() throws Exception {
		try {
			if (CommonFunctions.waitForVisiblity(checkoutMessage, 20))
				return checkoutMessage.getText();
			else
				return "no message";

		} catch (Exception e) {
			return "no message";
		}

	}

	public boolean verifyUserDetails(String name) {
		// TO DO

		try {
			if (userDetails.get(3).getText().equals(name)) {
				if (userDetails.get(4).getText().contains("$") && userDetails.get(4).getText().length() > 1) {
					System.out.println("User name found and fee displayed: " + userDetails.get(4).getText());
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

}