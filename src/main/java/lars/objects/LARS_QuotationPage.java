package lars.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;

public class LARS_QuotationPage extends LoadableComponent<LARS_QuotationPage> {

	@FindBy(id = "testAliasGo")
	public WebElement searchButton;
	
	
	@FindBy(id = "testAliasAdd")
	public WebElement addButton;
	
	@FindBy(id = "quotePayer")
	public WebElement selectQuotePayer;


	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//input[@id='testAliasInput']")
	public WebElement inputText;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//span[@class = 'ng-binding ng-scope' and contains(text(), '94936')]")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//a[@href='#/']")
	public WebElement LARSLogo;
	
	
	
	

	WebDriver driver = null;

	public LARS_QuotationPage(WebDriver driver) {
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

	public boolean searchQuotation() {

		try {
			// TODO
			CommonFunctions.waitandClick(searchButton, 20);
			return true;
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
	
	public boolean verifyBizTalkServer() {

		try {
			// CommonFunctions.waitandClick(lifelabsLogo, 20);
			//Thread.sleep(5000);
			spinnersChecking();
			int startTime2 = 400;
			int elapseTime2 = startTime2 - 10;
			int errorMessageCouunt = 1;
			boolean listIsEmpty =  true;
			while ((errorMessageCouunt == 1) && (elapseTime2 > 10)) {
				elapseTime2 = elapseTime2-10;
				errorMessageCouunt = driver.findElements(By.xpath("//span[@class = 'ng-binding ng-scope' and contains(text(), 'Cannot read property')]")).size();
				if (errorMessageCouunt > 0) {
					LARSLogo.click();
				}
			}	
			String amount = "$47.00";
			Select oSelect = new Select(selectQuotePayer);
			while ((listIsEmpty) && (elapseTime2 > 10)) {
				elapseTime2 = elapseTime2-10;
				listIsEmpty = oSelect.getOptions().isEmpty();
				if (listIsEmpty) {
					LARSLogo.click();
				}
			}
			
			
			
			
			oSelect.selectByVisibleText("SELF - PRIVATE PAY");
			inputText.sendKeys("LDL");
			addButton.click();
			inputText.sendKeys("CHOL");
			addButton.click();
			searchButton.click();
			
			spinnersChecking();
			
			return CommonFunctions.waitForVisiblity(By.xpath(
					"//h4[contains(text(),'" + amount + "')]"), 20);


			
			

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