package lars.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_AdministrationOperationsPage extends LoadableComponent<LARS_AdministrationOperationsPage> {

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='1']")
	public WebElement dataCenterOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='2']")
	public WebElement payeeOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='3']")
	public WebElement collectionCenterOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='4']")
	public WebElement performingCenterOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='5']")
	public WebElement orderingDoctorsOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='6']")
	public WebElement practitionersOption;

	@FindBy(xpath = "//div[@class='numberCircle ng-binding ng-scope' and text()='7']")
	public WebElement adjustmentsOption;

	@FindBy(xpath = "//div[contains(text(),'LARS Administration Operations')]")
	public WebElement headerText;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	@FindBy(xpath = "//div[contains(@class,'numberCircle ng-binding') or contains(@class,'numberCircleSelected ng-binding')]")
	public List<WebElement> optionsList;
	
	@FindBy(xpath = "//a[@href='#/']")
	public WebElement lifelabsTopLogo;
	
	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;

	WebDriver driver = null;
	int numberOfOption = 6;

	public LARS_AdministrationOperationsPage(WebDriver driver) {
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

	public boolean verifyOptionsAvailableOnAdministrationOperationsPage() {

		try {

			CommonFunctions.waitForVisiblity(adjustmentsOption, 10);

			return (dataCenterOption.isDisplayed() && payeeOption.isDisplayed() && collectionCenterOption.isDisplayed()
					&& performingCenterOption.isDisplayed() && orderingDoctorsOption.isDisplayed()
					&& practitionersOption.isDisplayed());

		} catch (Exception e) {
			System.out.println(e.getMessage());

			return false;
		}
	}

	public boolean goToDataCenterOption1(LARS_DatacenterPage datacenterPage) {

		try {
			
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				CommonFunctions.waitandClick(dataCenterOption, 20);
				return CommonFunctions.waitForVisiblity(datacenterPage.headerText, 10);
			}
			else
				return false;
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToPayeeOption2(LARS_PayeePage payeePage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				CommonFunctions.waitandClick(payeeOption, 20);
				return CommonFunctions.waitForVisiblity(payeePage.headerText, 10);
			}
			else
				return false;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToCollectionCenterOption3(LARS_CollectionCenterPage collectionCenterPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				CommonFunctions.waitandClick(collectionCenterOption, 20);
				return CommonFunctions.waitForVisiblity(collectionCenterPage.headerText, 10);
			}
			else
				return false;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToPerformingCenterOption4(LARS_PerformingCenterPage performingCenterPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				CommonFunctions.waitandClick(performingCenterOption, 20);
				return CommonFunctions.waitForVisiblity(performingCenterPage.headerText, 10);
			}
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToOrderingDoctorsOption5(LARS_OrderingDoctorPage orderingDoctorPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				CommonFunctions.waitandClick(orderingDoctorsOption, 20);
				return CommonFunctions.waitForVisiblity(orderingDoctorPage.headerText, 10);
			}	
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToPractionersOption6(LARS_PractitionersPage practitionersPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(3000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				CommonFunctions.waitandClick(practitionersOption, 20);
				return CommonFunctions.waitForVisiblity(practitionersPage.headerText, 10);
			}
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToAdjustmentsOption7(LARS_AdjustmentsPage adjustmentsPage) {

		try {
			ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			if(verifyOptionsAvailableOnAdministrationOpPage()) {
				
				CommonFunctions.waitandClick(adjustmentsOption, 20);
				return CommonFunctions.waitForVisiblity(adjustmentsPage.headerText, 10);
			}
			else
				return false;
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	@SuppressWarnings("null")
	public boolean verifyOptionsAvailableOnAdministrationOpPage() {

		boolean aOptionsAvailableOnAdministrationOpPageResult = false;
	//	List <WebElement> menuPageWebElementList = new ArrayList<WebElement>();
		
		int attempt = 3;
		
		
		try {
			
		//	menuPageWebElementList = loadWebElement(menuPageWebElementList);
			
			while (aOptionsAvailableOnAdministrationOpPageResult == false && attempt !=0) {
			
				spinnersChecking();
				//CommonFunctions.waitForVisiblity(reportsOption, 30);
				//Thread.sleep(6000);
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
		        //This will scroll the web page till end.		
		        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        //barcodeNumber.click();
				
	//			aOptionsAvailableOnMenuPageResult = CommonFunctions.waitForVisiblityList(menuPageWebElementList, 30); 
				
				aOptionsAvailableOnAdministrationOpPageResult = CommonFunctions.waitForVisiblityList(optionsList, 60, numberOfOption);
				
				if (aOptionsAvailableOnAdministrationOpPageResult == false) {
					
					CommonFunctions.waitandClick(lifelabsTopLogo, 30);
					Thread.sleep(2000);
					attempt--;
					System.out.println("Number of attempt: " + attempt);
					System.out.println("Option display result: " + aOptionsAvailableOnAdministrationOpPageResult);
				}
			}
			
			return aOptionsAvailableOnAdministrationOpPageResult;
			
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
}