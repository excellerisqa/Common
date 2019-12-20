package lars.objects;

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

public class LARS_EndOfDayPage extends LoadableComponent<LARS_EndOfDayPage> {

	@FindBy(id = "pscGo")
	public WebElement searchButton;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;

	@FindBy(id = "selectedPsc")
	public WebElement selectPscDropdown;

	@FindBy(id = "eodComment")
	public WebElement eodCommentTextbox;

	@FindBy(id = "printReport")
	public WebElement printReportButton;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-print app-icon']/parent::a")
	public WebElement printTodayEODReportLink;

	@FindBy(id = "paymentAmount")
	public List<WebElement> printAmountTextboxes;

	@FindBy(xpath = "//button[contains(@ng-click,'eodReport.paymentDetailOpen')]")
	public List<WebElement> viewPaymentsButtons;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and contains(text(), 'An End Of Day has already been completed for today')]")
	public WebElement messageDialogEODDone;

	WebDriver driver = null;
	
	public boolean EODDone = false;

	public LARS_EndOfDayPage(WebDriver driver) {
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

	public boolean searchPscEODReport_bk(String pscToSelect) {

		try {
			spinnersChecking();
			Select psc = new Select(selectPscDropdown);
			psc.selectByVisibleText(pscToSelect);
			//Thread.sleep(2000);
			searchButton.click();
			spinnersChecking();
			// TODO: verification of the data in EOD page after search
			// System.out.println("Cash Amount: " + printAmountTextboxes.get(0).getText());
			// return Integer.parseInt(printAmountTextboxes.get(0).getText()) > 0;
			return CommonFunctions.waitForVisiblity(viewPaymentsButtons.get(0), 10);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean searchPscEODReport(String pscToSelect) {

		try {
			spinnersChecking();
			Select psc = new Select(selectPscDropdown);
			psc.selectByVisibleText(pscToSelect);
			//Thread.sleep(2000);
			searchButton.click();
			spinnersChecking();
			
			int eodMessageCount = driver.findElements(By.xpath("//span[@class='ng-binding ng-scope' and contains(text(), 'An End Of Day has already been completed for today')]")).size();
			
			/* check if EOD has already been done */
			if (eodMessageCount>0) {
				
				setEODDone(true);
	//			return true;
			}
	//		else {
			return CommonFunctions.waitForVisiblity(viewPaymentsButtons.get(0), 10);
//			}
			// TODO: verification of the data in EOD page after search
			// System.out.println("Cash Amount: " + printAmountTextboxes.get(0).getText());
			// return Integer.parseInt(printAmountTextboxes.get(0).getText()) > 0;
			
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean printEODSummary(String comment) {

		try {
			// Select psc = new Select(selectPscDropdown);
			// psc.selectByVisibleText(pscToSelect);
			Thread.sleep(2000);
			// searchButton.click();
			if (viewPaymentsButtons.get(0).isDisplayed()) {
				eodCommentTextbox.sendKeys(comment);
				printReportButton.click(); // CAUTION: this can be done only once a day for a particular PSC

				// verify a file is downloaded
				Thread.sleep(2000);
				if (CommonFunctions.waitForDownload("EODPaymentSummary.pdf"))
					return false;
				else {
					Thread.sleep(2000);
					CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "EODPaymentSummary.pdf");
					return true;
				}
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchPscEODReportAndReprintTodaysPscEODReport(String pscToSelect) {

		try {
			Thread.sleep(2000);
			Select psc = new Select(selectPscDropdown);
			psc.selectByVisibleText(pscToSelect);
			Thread.sleep(2000);
			searchButton.click();

			// An End Of Day has already been completed for today. Click to re-print today's
			// End Of Day report

			CommonFunctions.waitandClick(printTodayEODReportLink, 20);

			// verify a file is downloaded
			Thread.sleep(2000);
			if (CommonFunctions.waitForDownload("EODPaymentSummary.pdf"))
				return false;
			else {
				Thread.sleep(2000);
				// CommonFunctions.archiveFile(ObjectHelper.downloadsFolder,
				// "EODPaymentSummary.pdf");
				return true;
			}

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
	
	public boolean isEODDone(){return this.EODDone;}	

	public void setEODDone(boolean EODDone){this.EODDone = EODDone;}

}