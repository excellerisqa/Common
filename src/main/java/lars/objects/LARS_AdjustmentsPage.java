package lars.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class LARS_AdjustmentsPage extends LoadableComponent<LARS_AdjustmentsPage> {

	@FindBy(xpath = "//div[contains(text(),'Adjustments')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text() = 'MSP Rejected > 120 Days Status 5 and Credit Balance < $1.00']")
	public WebElement mspRejected120DaysTab;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text() = 'MSP Rejected > 120 Days Status 18']")
	public WebElement mspRejected120Status18Tab;

	@FindBy(xpath = "//span[@class='ng-binding' and text() = 'Self Pay Invoiced > 365 Days']")
	public WebElement selfPayInvoicedTab;
	
	@FindBy(xpath = "//button[@id='MspRejected120DaysStatus5Go' and text() = 'Go']")
	public WebElement goButton;
	
	@FindBy(xpath = "//span[contains(text(),'Adjustment for MspRejected120DaysStatus5 has started in SQL Server. You will receive the email when adjustment done.')]")
	public WebElement successMessage;
	
	@FindBy(xpath = "//span[contains(text(),'The Adjustment has been done today')]")
	public WebElement doneMessage;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	WebDriver driver = null;

	public LARS_AdjustmentsPage(WebDriver driver) {
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
	
	public boolean verifyTabOptionsAvailableOnAdjustmentsPage() {

		try {
			
			spinnersChecking();
					
			return (CommonFunctions.waitForVisiblity(this.mspRejected120DaysTab, 30) 
					&& CommonFunctions.waitForVisiblity(this.mspRejected120Status18Tab, 30)
					&& CommonFunctions.waitForVisiblity(this.selfPayInvoicedTab, 30));
		
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifySuccessMessageForClickGo() {

		try {
			spinnersChecking();
			CommonFunctions.waitandClick(this.goButton, 20);	
			spinnersChecking();
		   //driver.findElements(By.xpath("//*[@id='grdRefTable']/tbody/tr")).size();
		   
		  if(driver.findElements(By.xpath("//span[contains(text(),'Adjustment for MspRejected120DaysStatus5 has started in SQL Server. You will receive the email when adjustment done.')]")).size()>0) {
			  
			  return true;
		  } 
		  else if (driver.findElements(By.xpath("//span[contains(text(),'The Adjustment has been done today')]")).size()>0) {
			
			  return true;
		  }
		  else
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