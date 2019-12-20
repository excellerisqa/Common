package lars.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_FeeSchedulesPage extends LoadableComponent<LARS_FeeSchedulesPage> {

	@FindBy(id = "searchInput")
	public WebElement searchTextbox;

	@FindBy(id = "searchGo")
	public WebElement searchButton;

	@FindBy(xpath = "//a[contains(text(),'Patient Accessions')]")
	public WebElement patientAccessionsTab;
	@FindBy(xpath = "//a[contains(text(),'Patient Invoices')]")
	public WebElement patientInvoicesTab;
	@FindBy(xpath = "//a[contains(text(),'Fees')]")
	public WebElement feesTab;
	@FindBy(xpath = "//a[contains(text(),'Fee Schedules')]")
	public WebElement feeSchedulesTab;
	@FindBy(xpath = "//a[contains(text(),'Payer')]")
	public WebElement payerTab;
	@FindBy(xpath = "//a[contains(text(),'Tax Rate')]")
	public WebElement taxRateTab;

	@FindBy(xpath = "//div[contains(text(),'Search Fees')]")
	public WebElement headerText;

	WebDriver driver = null;

	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	public LARS_FeeSchedulesPage(WebDriver driver) {
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

	public boolean searchFeeSchedule(String accountNumber) {
		try {
			spinnersChecking();
			CommonFunctions.waitandClear(searchTextbox, 10);
			searchTextbox.sendKeys(accountNumber);
			searchButton.click();
			spinnersChecking();

			int feeCodes = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + accountNumber + "')]"))
					.size();

			System.out.println("Number of fee codes for this account found: " + feeCodes);

			return (feeCodes > 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToTab(String tabText) {
		try {

			CommonFunctions.waitForVisiblity(payerTab, 30);
			Thread.sleep(3000);
			switch (tabText) {
			case "Patient Accessions":
				patientAccessionsTab.click();
				break;
			case "Patient Invoices":
				patientInvoicesTab.click();
				break;
			case "Fees":
				feesTab.click();
				break;
			case "Fee Schedules":
				feeSchedulesTab.click();
				break;
			case "Payer":
				payerTab.click();
				break;
			case "Tax Rate":
				taxRateTab.click();
				break;

			default:
				System.out.println("Tab does not exist.");
				return false;
			}
			ObjectHelper.driver.navigate().refresh();
			Thread.sleep(5000);
			return true;
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