package lars.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_PayerSummaryPage extends LoadableComponent<LARS_PayerSummaryPage> {

	@FindBy(id = "payerSelect")
	public WebElement payerTypeDropdown;

	@FindBy(id = "searchInput")
	public WebElement payerTextbox;

	@FindBy(id = "searchGo")
	public WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(),'Search Payer By Payer Code')]")
	public WebElement headerText;

	@FindBy(xpath = "//div[contains(text(),'Payer - Payer Code')]")
	public WebElement payerDetail;

	@FindBy(xpath = "//input[@data-ng-model='payer.getPayer.payer_Name']")
	public WebElement payerNameTextbox;

	@FindBy(xpath = "//select[@data-ng-model='payer.getPayer.payer_Class']")
	public WebElement payerClassDropdown;

	@FindBy(xpath = "//input[@type='radio' and @value='A']")
	public WebElement activeRadiobutton;

	@FindBy(xpath = "//input[@type='radio' and @value='I']")
	public WebElement inactiveRadioButton;

	@FindBy(xpath = "//button[@data-ng-click='payer.payerUpdate()']")
	public WebElement updatePayerButton;

	@FindBy(xpath = "//span[contains(text(),'updated successfully.')]")
	public WebElement successMessage;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	WebDriver driver = null;

	public LARS_PayerSummaryPage(WebDriver driver) {
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

	public boolean searchBy(String payerType, String payer) {
		try {
			CommonFunctions.waitForVisiblity(payerTextbox, 10);

			if (!(payerType.contains("Payer Code"))) {
				Select selType = new Select(payerTypeDropdown);
				selType.selectByVisibleText(payerType);
			}
			Thread.sleep(1000);

			payerTextbox.sendKeys(payer);

			Thread.sleep(1000);

			CommonFunctions.waitandClick(searchButton, 10);
			// searchButton.click();
			spinnersChecking();

			if ((payerType.contains("Payer Code") || payerType.contains("Payer Name")))
				return CommonFunctions.waitForVisiblity(payerDetail, 30);
			else
				return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyPayer(String payer) {
		try {
			// CommonFunctions.waitForVisiblity(payerDetail, 10);
			Thread.sleep(3000);
			String title = payerDetail.getText();
			return payerDetail.getText().contains(payer);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean searchBy(String payerType, String payer, LARS_PayerPage payerPage ) {
		try {
			CommonFunctions.waitForVisiblity(payerTextbox, 10);

			if (!(payerType.contains("Payer Code"))) {
				Select selType = new Select(payerTypeDropdown);
				selType.selectByVisibleText(payerType);
			}
			Thread.sleep(1000);

			payerTextbox.sendKeys(payer);

			Thread.sleep(1000);

			CommonFunctions.waitandClick(searchButton, 10);
			
			spinnersChecking();
			
			return CommonFunctions.waitForVisiblity(payerPage.headerText, 30);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	

	// Does not get text from textbox
	// public boolean verifyPayerName(String payerName) {
	// try {
	// // CommonFunctions.waitForVisiblity(payerNameTextbox, 10);
	// String name = payerNameTextbox.getText();
	// return payerNameTextbox.getText().contains(payerName);
	//
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// return false;
	// }
	// }

	public boolean verifyPayerClassName(String payerClassName) {
		try {
			Thread.sleep(3000);
			return CommonFunctions.waitForVisiblity(By.xpath("//td[text()='BC TRANSPLANT SOCIETY']"), 10)
					&& CommonFunctions.waitForVisiblity(By.xpath("//td[text()='SUNLIFE OF CANADA']"), 10);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyPayerStatusOrClassCode(String payerStatusOrClassCode) {
		try {
			Thread.sleep(3000);
			int total = ObjectHelper.driver.findElements(By.xpath("//td[text()='" + payerStatusOrClassCode + "']"))
					.size();

			int payerSearchResult = ObjectHelper.driver.findElements(By.xpath("//a[contains(@href,'#/payer/')]"))
					.size();

			System.out.println("Number of payer codes for this status/classcode found: " + payerSearchResult);
			boolean a = payerSearchResult > 0;
			boolean b = (total == payerSearchResult);
			return (payerSearchResult > 0) && (total == payerSearchResult);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updatePayer() {
		try {
			if (!(activeRadiobutton.isSelected()))
				activeRadiobutton.click();

			else // if (!(inactiveRadioButton.isSelected()))
				inactiveRadioButton.click();

			updatePayerButton.click();

			return CommonFunctions.waitForVisiblity(successMessage, 10);

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

}