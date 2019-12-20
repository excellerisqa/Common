package lars.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import bclis.objects.BCLIS_MainMenuPage;
import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_AccessionAccessionNumberDetailPage extends LoadableComponent<LARS_AccessionAccessionNumberDetailPage> {

	

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//div[contains(text(),'Accession')]")
	public WebElement accessionNumberDetailPageTitle;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//span[contains(text(),'edit patient info')]")
	public WebElement editPatientInfoTab;
	
	@FindBy(xpath = "//input[@id = 'editDoctor']")
	public WebElement doctorDropDown;
	
	
	@FindBy(xpath = "//*[contains(@id, 'option-0')]/a/text()")
	public WebElement doctorDropDownItem;
	
	
//	@FindBy(xpath = "//a[@class='k-icon k-plus']")
//	public WebElement triangleIcon;
	

	/*
	@FindBy(id = "requestInput")
	public WebElement requestNumberTextbox;

	@FindBy(id = "invoiceIdInput")
	public WebElement invoiceIdTextbox;

	@FindBy(xpath = "//div[contains(@class,'accessionTitle')]")
	public List<WebElement> accessionTitle;

	@FindBy(id = "paymentPsc")
	public WebElement pscTextbox;

	@FindBy(id = "paymentAmount")
	public WebElement paymentAmountTextbox;

	@FindBy(xpath = "//form[@id='paymentForm']//select")
	public WebElement paymentTypeDropdown;

	@FindBy(id = "paymentGo")
	public WebElement addButton;

	@FindBy(xpath = "//div/b[text()='Balance:']/../following-sibling::div")
	public WebElement balanceAmount;

	@FindBy(xpath = "//button[contains(text(),'Check Out')]")
	public WebElement checkoutButton;

	@FindBy(xpath = "//span[@class = 'ng-binding ng-scope']")
	public List<WebElement> checkoutMessage;
	
	
	
	*/
	
	WebDriver driver = null;

	public LARS_AccessionAccessionNumberDetailPage(WebDriver driver) {
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
			spinnersChecking();
			Thread.sleep(1000);
			lifelabsLogo.click();
			return menuPage.verifyOptionsAvailableOnMenuPage();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyAccessionNumberDetailPageTitle() {

		try {
	//		if (accessionNumberDetailPageTitle.isDisplayed()) {
			spinnersChecking();
			if (CommonFunctions.waitForVisiblity(accessionNumberDetailPageTitle, 60)) {	
				return true;
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
	
	
	public boolean verifyAccessionNumberDetailPageDoctorDropDown() {

		try {
	//		if (accessionNumberDetailPageTitle.isDisplayed()) {
			spinnersChecking();
			editPatientInfoTab.click();
			
			if (doctorDropDown.isEnabled()) {	
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean searchByDoctorDropDownList(String aNumber, String aDoctor) {

		int aDoctorResult = 0;
		String option = "";
		try {
	//		if (accessionNumberDetailPageTitle.isDisplayed()) {
			doctorDropDown.clear();
			
			
			doctorDropDown.sendKeys(aNumber);
			//doctorDropDown.sendKeys(Keys.ENTER);
			
			int i = 0;
			option = "option-"+i;
			
			//aDoctorResult = ObjectHelper.driver.findElements(By.xpath("//*[contains(@id, 'option-0')]/a[contains(text(),'"+ aDoctor +"')]")).size();	
			
			//aDoctorResult = ObjectHelper.driver.findElements(By.xpath("//*[contains(@id, 'option-0')]/a[contains(text(),'IM IN CONTROL')]")).size();	
			
			aDoctorResult = ObjectHelper.driver.findElements(By.xpath("//*[contains(@id, '"+option+"')]/a[contains(text(),'"+ aDoctor +"')]")).size();	
			
			while (aDoctorResult == 0 && i <=19) {
				i++;
				option = "";
				option = "option-"+i;
				aDoctorResult = ObjectHelper.driver.findElements(By.xpath("//*[contains(@id, '"+option+"')]/a[contains(text(),'"+ aDoctor +"')]")).size();	
			}
			
			
			if(aDoctorResult == 1){
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	

	/**
	 * DESCRIPTION: Verify if fee code column exist,
	 * RETURNS: list if result:
	 */
	
	public boolean searchFeeCodeColumn(String aFeeCodeColumn) {
	
		int aFeeCodeColumnResult = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
			
				
				aFeeCodeColumnResult = ObjectHelper.driver.findElements(By.xpath("//tr[@class='selfPayHeader']//th[contains(text(),'" + aFeeCodeColumn + "')]")).size();	
	
		
				
				System.out.println("Number of fee Code Column for this table found: " + aFeeCodeColumnResult);
	
				if (aFeeCodeColumnResult == 1) {
					checkFlag = true;
				}
				return (checkFlag);
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
	/**
	 * DESCRIPTION: Verify if id column exist,
	 * RETURNS: list if result:
	 */
	
	public boolean searchIdColumn(String aIdColumn) {
	
		int aIdColumnResult = 0;
		boolean checkFlag = false;
		
		try {
			
				spinnersChecking();
			
				
				// aIdColumnResult = ObjectHelper.driver.findElements(By.xpath("//tr[@class='selfPayHeader']//th[contains(text(),'" + aIdColumn + "')]")).size();	
	
				aIdColumnResult = ObjectHelper.driver.findElements(By.xpath("//tr[@class='selfPayHeader']//th[text()='Type']/..//following-sibling::th[contains(text(),'" + aIdColumn + "')]")).size();
				
				
				
				
			
				System.out.println("Number of Id column for this table found: " + aIdColumnResult);
	
				if (aIdColumnResult == 0) {
					checkFlag = true;
				}
				return (checkFlag);
			
		
	
		} catch (Exception e) {
			return checkFlag;
		}
	
	}
	
	public boolean searchDoctorNameAndInvoice(String aDoctorName, String aInvoice) {

		int aDoctorNameResult = 0;
		int aInvoiceResult = 0;
	//	String option = "";
		try {
			
			aDoctorNameResult = ObjectHelper.driver.findElements(By.xpath("//a[contains(text(), '"+aDoctorName+"')]")).size();	
			
			aInvoiceResult = ObjectHelper.driver.findElements(By.xpath("//a[contains(text(), '"+aInvoice+"')]")).size();
			
			if(aDoctorNameResult == 1 && aInvoiceResult == 1){
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean verifyInvoiceInfo(String aInvoice) {

		int aInvoiceInfoResult = 0;
	//	String option = "";
		try {
			
			spinnersChecking();
			while (!CommonFunctions.waitForVisiblity(accessionNumberDetailPageTitle, 2)) {	
				ObjectHelper.driver.navigate().refresh();
				spinnersChecking();
			}	
			aInvoiceInfoResult = ObjectHelper.driver.findElements(By.xpath("//a[contains(text(), '"+aInvoice+"')]")).size();	
			
			if(aInvoiceInfoResult == 1){
				return true;
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean verifyMSPStatus() {

		boolean result = false;
	//	String option = "";
		try {
			
			spinnersChecking();
	//		triangleIcon.click();
	//		ObjectHelper.driver.findElement(By.xpath("//a[@class='k-icon k-plus']")).click();
			
		//	Thread.sleep(2000);
		//	if (ObjectHelper.driver.findElement(By.xpath("//*[@id=\"feetracks\"]/div[2]/table/tbody/tr[1]/td[9]")).getText().equals("5")) {
			if (ObjectHelper.driver.findElements(By.xpath("//*[@id='grid']//td[6]")).get(0).getText().equals("5") && 
				ObjectHelper.driver.findElements(By.xpath("//*[@id='grid']//td[6]")).get(0).getAttribute("style").contains("red") &&
				ObjectHelper.driver.findElements(By.xpath("//*[@id='grid']//td[5]//a")).get(0).getAttribute("style").contains("red")
				) 
			{
				result = true;
			} else
				result = false;
			
	//		String test = ObjectHelper.driver.findElements(By.xpath("//*[@id='grid']//td[6]")).get(0).getAttribute("style");

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return result;
		}
	}
	
}