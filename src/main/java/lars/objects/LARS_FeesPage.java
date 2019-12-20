package lars.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_FeesPage extends LoadableComponent<LARS_FeesPage> {

	@FindBy(id = "activeFeeCodeSelect")
	public WebElement statusDropdown;

	@FindBy(id = "searchInput")
	public WebElement searchTextbox;

	@FindBy(id = "searchGo")
	public WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(),'Fees')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	WebDriver driver = null;

	public LARS_FeesPage(WebDriver driver) {
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

	public boolean searchFeeAndVerify(String query) {
		try {
			spinnersChecking();
			CommonFunctions.waitandClear(searchTextbox, 10);
			searchTextbox.sendKeys(query);
			searchButton.click();
			spinnersChecking();
			Thread.sleep(2000);
			int fees = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + query + "')]")).size();

			System.out.println("Number of fees found: " + fees);

			return (fees > 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchFeeDescriptionAndVerify(String query) {
		try {
			spinnersChecking();
			CommonFunctions.waitandClear(searchTextbox, 10);
			searchTextbox.sendKeys(query);
			searchButton.click();
			spinnersChecking();
			Thread.sleep(2000);
			int fees = ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'" + query + "')]")).size();

			System.out.println("Number of fees found: " + fees);

			return (fees > 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchFeeCodeAndVerify(String query) {
		try {
			spinnersChecking();
			CommonFunctions.waitandClear(searchTextbox, 10);
			searchTextbox.sendKeys(query);
			searchButton.click();
			spinnersChecking();

			int fees = ObjectHelper.driver.findElements(By.xpath("//div[contains(text(),'SODIUM')]")).size();

			System.out.println("Number of fees found: " + fees);

			return (fees > 0);
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