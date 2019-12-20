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

public class LARS_PayerPage extends LoadableComponent<LARS_PayerPage> {

	
	
	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	
	@FindBy(xpath = "//a[@href='#/']")
	public WebElement lifelabsTopLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement updatePayerButton;
	
	@FindBy(xpath = "//div[contains(text(),'Payer - Payer Code')]")
	public WebElement headerText;
	
	@FindBy(id = "invoiceType")
	public WebElement invoiceTypeDropdown;
	
	
	
	
	WebDriver driver = null;

	public LARS_PayerPage(WebDriver driver) {
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
	
	
	public boolean verifyInvoiceTypeDropDwonIsNotEmpty() {
		
		boolean isNotEmpty = false;
		try {
			
			Select invoiceType = new Select(invoiceTypeDropdown);
			WebElement option = invoiceType.getFirstSelectedOption();
			String strCurrentValue = option.getText();
			
			
			if (!strCurrentValue.equals("")) {
				isNotEmpty = true;
			}
			return isNotEmpty;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return isNotEmpty;
		}
	}
	
	
	public boolean verifyUpdatePayerButton(String checkType) {
		
		boolean checkResult = false;
		try {
				Select invoiceType = new Select(invoiceTypeDropdown);
				switch (checkType) {
					case "enabled":
						invoiceType.selectByIndex(1);
						checkResult = updatePayerButton.isEnabled();
					break;
					case "disabled":
						invoiceType.selectByIndex(0);
						checkResult = !updatePayerButton.isEnabled();
					break;
					default:
				}		
		return checkResult;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return checkResult;
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