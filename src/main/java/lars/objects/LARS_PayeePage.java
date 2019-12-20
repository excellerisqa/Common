package lars.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_PayeePage extends LoadableComponent<LARS_PayeePage> {

	
	
	@FindBy(xpath = "//div[contains(text(),'Payment center - Teleplan Payee management')]")
	public WebElement headerText;


	
	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//span[text()='Invoice Manual Settings']")
	public WebElement invoiceManualSettingsTab;
	
	@FindBy(xpath = "//span[text()='Payment Centers']")
	public WebElement paymentCentersTab;
	
	
	@FindBy(xpath = "//a[text()='Day']")
	public WebElement dayTab;
	
	@FindBy(xpath = "//a[text()='Work Week']")
	public WebElement workWeekTab;
	
	@FindBy(xpath = "//a[text()='Week']")
	public WebElement weekTab;
	
	@FindBy(xpath = "//a[text()='Month']")
	public WebElement monthTab;
	
	@FindBy(xpath = "//a[text()='Agenda']")
	public WebElement agendaTab;

	@FindBy(xpath = "//a[text()='Timeline']")
	public WebElement timelineTab;
	
	@FindBy(xpath = "//a[text()='Show business hours']")
	public WebElement showBusinessHoursButton;
	
	@FindBy(xpath = "//*[@id='1']//button")
	public WebElement showMappingsButton;
	
	@FindBy(xpath = "//span[text()='Performing Centers']")
	public WebElement performingCentersTab;
	
	@FindBy(xpath = "//span[text()='Practitioners']")
	public WebElement practitionersTab;
	
	@FindBy(xpath = "//*[@id='1']//div[@class='tab-pane ng-scope active']//th[text()='License']")
	public WebElement licenseHeader;
	
	@FindBy(xpath = "//*[@id='1']//div[@class='tab-pane ng-scope active']//th[text()='LIS Code']")
	public WebElement lisCodeHeader;
	
	@FindBy(xpath = "//*[@id='1']//div[@class='tab-pane ng-scope active']//th[contains(text(),'Name')]")
	public WebElement nameHeader;
	
	@FindBy(xpath = "//*[@id='1']//div[@class='tab-pane ng-scope active']//th[text()='Practitioner Number']")
	public WebElement practitionerNumberHeader;
	
	@FindBy(xpath = "//table[@class='table table-condensed']")
	public WebElement table;
	
	@FindBy(xpath = "//a[@href='#/']")
	public WebElement lifelabsTopLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	
	WebDriver driver = null;

	public LARS_PayeePage(WebDriver driver) {
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
	
	
	public boolean verifyTabsAndButtonsAvailableOnPayeePage() {
		
		boolean tabExist = false;
		try {
			
			spinnersChecking();
			invoiceManualSettingsTab.click();
			spinnersChecking();
			
			if(verifyTabsAvailableOnPayeePage()) {
			
				tabExist = CommonFunctions.waitForVisiblity(dayTab, 30) 
						&& CommonFunctions.waitForVisiblity(weekTab, 30)
						&& CommonFunctions.waitForVisiblity(timelineTab, 30)
						&& CommonFunctions.waitForVisiblity(monthTab, 30)
						&& CommonFunctions.waitForVisiblity(showBusinessHoursButton, 30)
						&& CommonFunctions.waitForVisiblity(agendaTab, 30);
						
				dayTab.click();		
				tabExist = tabExist && CommonFunctions.waitForVisiblity(workWeekTab, 30);
			}
			
			return tabExist;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return tabExist;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean verifyPerformingCentersInformation() {
		
		boolean tabExist = false;
		try {
			showMappingsButton.click();
			spinnersChecking();
			
			tabExist = CommonFunctions.waitForVisiblity(performingCentersTab, 30) 
					&& CommonFunctions.waitForVisiblity(licenseHeader, 30)
					&& CommonFunctions.waitForVisiblity(lisCodeHeader, 30)
					&& CommonFunctions.waitForVisiblity(nameHeader, 30);
		
					
	//		dayTab.click();		
	//		tabExist = tabExist && CommonFunctions.waitForVisiblity(workWeekTab, 30);
			return tabExist;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return tabExist;
		}
	}
	
	
	public boolean verifyPractitionersInformation() {
		
		boolean tabExist = false;
		try {
			
			practitionersTab.click();
			spinnersChecking();
			
			tabExist = CommonFunctions.waitForVisiblity(practitionersTab, 30) 
					&& CommonFunctions.waitForVisiblity(licenseHeader, 30)
					&& CommonFunctions.waitForVisiblity(practitionerNumberHeader, 30)
					&& CommonFunctions.waitForVisiblity(nameHeader, 30);
		
					
	//		dayTab.click();		
	//		tabExist = tabExist && CommonFunctions.waitForVisiblity(workWeekTab, 30);
			return tabExist;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return tabExist;
		}
	}
	
	public boolean verifyShowMappingsClose() {
		
		boolean tableNotExist = false;
		try {
			
			 // showMappingsButton.click();
			 CommonFunctions.waitandClick(showMappingsButton, 30);
	/*		
			 if(driver.findElements(By.xpath("//table[@class='table table-condensed']")).size()>0) {
				 tableNotExist = false;	
			 }
	*/		 
			 if(table.isDisplayed()) {
				 tableNotExist = false;	
			 }
			 else
				 tableNotExist = true;
			 
	//		dayTab.click();		
	//		tabExist = tabExist && CommonFunctions.waitForVisiblity(workWeekTab, 30);
			return tableNotExist;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return tableNotExist;
		}
	}
	
	public boolean verifyTabsAvailableOnPayeePage() {

		int aTabsAvailableOnPayeePageResult = 0;
	//	List <WebElement> menuPageWebElementList = new ArrayList<WebElement>();
		
		int attempt = 6;
		
		
		try {
			
		//	menuPageWebElementList = loadWebElement(menuPageWebElementList);
			
			while (aTabsAvailableOnPayeePageResult == 0 && attempt !=0) {
			
				spinnersChecking();
				//CommonFunctions.waitForVisiblity(reportsOption, 30);
				//Thread.sleep(6000);
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
		        //This will scroll the web page till end.		
		        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        //barcodeNumber.click();
				
	//			aOptionsAvailableOnMenuPageResult = CommonFunctions.waitForVisiblityList(menuPageWebElementList, 30); 
				
	//			aTabsAvailableOnPayeePageResult = CommonFunctions.waitForVisiblity(dayTab, 10);
				aTabsAvailableOnPayeePageResult = driver.findElements(By.xpath("//a[text()='Day']")).size();

				
				
			//	if (aTabsAvailableOnPayeePageResult == 0) {
				if (aTabsAvailableOnPayeePageResult == 0) {
					
					ObjectHelper.driver.navigate().refresh();
					spinnersChecking();
					invoiceManualSettingsTab.click();
					
					attempt--;
					System.out.println("Number of attempt: " + attempt);
					System.out.println("tabs display result: " + aTabsAvailableOnPayeePageResult);
				}
			}
			
			if (aTabsAvailableOnPayeePageResult > 0) {
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean verifyButtonsClickableOnPayeePage() {

		boolean buttonsClickable = false;
		try {
			
			buttonsClickable = CommonFunctions.isElementClickable(workWeekTab)
					&& CommonFunctions.isElementClickable(weekTab)
					&& CommonFunctions.isElementClickable(timelineTab)
					&& CommonFunctions.isElementClickable(monthTab)
					&& CommonFunctions.isElementClickable(showBusinessHoursButton)
					&& CommonFunctions.isElementClickable(agendaTab);
					
			workWeekTab.click();		
			buttonsClickable = buttonsClickable && CommonFunctions.isElementClickable(dayTab);
			return buttonsClickable;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return buttonsClickable;
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