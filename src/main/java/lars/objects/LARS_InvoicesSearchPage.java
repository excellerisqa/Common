package lars.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_InvoicesSearchPage extends LoadableComponent<LARS_InvoicesSearchPage> {

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	@FindBy(xpath = "//input[@id='invoiceInput']")
	public WebElement invoiceIdTextbox;

	@FindBy(xpath = "//div[contains(text(),'Invoices')]")
	public WebElement headerText;

	@FindBy(xpath = "//span[@class='ng-binding' and text()='Date of Birth']")
	public WebElement dobTab;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='Patient Names']")
	public WebElement patientNamesTab;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='Payers']")
	public WebElement payersTab;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='Bill Status']")
	public WebElement billStatusTab;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='Find']")
	public WebElement findTab;
	
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Patient last, first name:']")
	public WebElement patientNameLabel;
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Invoice Id:']")
	public WebElement invoiceIdLabel;
	
	@FindBy(xpath = "//button[@id='invoiceGo']")
	public WebElement invoiceSearchButton;
	
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='Find2']")
	public WebElement find2Tab;
	
	@FindBy(xpath = "//input[@id='patientNameInput']")
	public WebElement patientNameInputTextbox;
	
	@FindBy(xpath = "//button[@id='patientNameGo']")
	public WebElement patientNameSearchButton;


	@FindBy(xpath = "//div[@class='searchLabel ng-binding' and text()='Date of Birth (YYYY-MM-DD):']")
	public WebElement dobLabel;


	@FindBy(xpath = "//input[@id='dobInput']")
	public WebElement dobInputTextbox;
	
	@FindBy(xpath = "//button[@id='dobGo']")
	public WebElement dobSearchButton;
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Bill Status:']")
	public WebElement billStatusLabel;
	
	@FindBy(xpath = "//input[@data-ng-model='bsSearch.bsStatus']")
	public WebElement billStatusInputTextBox;
	
	@FindBy(xpath = "//input[@name='bsDate']")
	public WebElement dateInputTextBox;
	
	@FindBy(xpath = "//button[@id='bsGo']")
	public WebElement billStatusSearchButton;
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Payer:']")
	public WebElement payerLabel;
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Fee Code:']")
	public WebElement feeCodeLabel;
	
	@FindBy(xpath = "//input[@id='payerInput']")
	public WebElement payerInputTextbox;
	
	@FindBy(xpath = "//button[@id='payerGo']")
	public WebElement payerSearchButton;
	
	@FindBy(xpath = "//input[@id='feeInput']")
	public WebElement feeCodeInputTextbox;
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Prefix:']")
	public WebElement prefixLabel;
	
	@FindBy(xpath = "//input[@id='prefixInput']")
	public WebElement prefixInputTextBox;
	
	@FindBy(xpath = "//input[@id='accessionInput']")
	public WebElement accessionInputTextBox;
	
	@FindBy(xpath = "//button[@id='accessionGo']")
	public WebElement accessionSearchButton;
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='PHN']")
	public WebElement phnTab;
	
	
	
	@FindBy(xpath = "//div[@class='searchLabel ng-binding' and text()='PHN:']")
	public WebElement phnLabel;
	
	@FindBy(xpath = "//input[@id='phnInput']")
	public WebElement phnInputTextbox;
	
	@FindBy(xpath = "//button[@id='phnGo']")
	public WebElement phnSearchButton;

	@FindBy(xpath = "//th[@class='col-md-2' and text()='Payer']")
	public WebElement payerColumn;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	public WebElement exceptionMessage;
	
	@FindBy(xpath = "//a[contains(@href, '#/invoiced')]")
	public List<WebElement> idLink;
	
	@FindBy(xpath = "//a[@href='#/payerSummary']")
	public WebElement topMenuPayer;
	
	
/*
	
	@FindBy(id = "invoiceIdGo")
	public WebElement searchButton;


	@FindBy(id = "requestInput")
	public WebElement requestNumberTextbox;


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

	public LARS_InvoicesSearchPage(WebDriver driver) {
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

	

	public boolean clickPHNTab(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			Thread.sleep(4000);
			CommonFunctions.waitandClick(this.phnTab, 30);
			Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.phnLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}	
	public boolean clickDOBTab(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			Thread.sleep(4000);
			CommonFunctions.waitandClick(this.dobTab, 30);
			Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.dobLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickPatientNamesTab(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			Thread.sleep(4000);
			CommonFunctions.waitandClick(this.patientNamesTab, 30);
			Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.patientNameLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickPayersTab(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			Thread.sleep(4000);
			CommonFunctions.waitandClick(this.payersTab, 30);
			Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.payerLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickBillStatusTab(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			//Thread.sleep(1000);
			CommonFunctions.waitandClick(this.billStatusTab, 30);
			//Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.billStatusLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickTopMenuPayer(LARS_PayerSummaryPage payerSummaryPage) {

		try {
			//Thread.sleep(1000);
			spinnersChecking();
			//Thread.sleep(1000);
			topMenuPayer.click();
			return CommonFunctions.waitForVisiblity(payerSummaryPage.headerText, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean clickFindTab(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			//Thread.sleep(1000);
			CommonFunctions.waitandClick(this.findTab, 30);
			//Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.invoiceIdLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	
	/**
	 * DESCRIPTION: Enter patient and click search,
	 * RETURNS: list if result:
	 */

	public int searchPatientName(String aPatientName) {

		int aPatientNameResult = 0;
		int attempt = 10;
		
		
		try {
			
				spinnersChecking();
				CommonFunctions.waitandClick(patientNameInputTextbox, 30);
				CommonFunctions.waitandClear(patientNameInputTextbox, 30);
				patientNameInputTextbox.sendKeys(aPatientName);
				spinnersChecking();
				
				CommonFunctions.waitandClick(patientNameSearchButton, 30);
				
				//Thread.sleep(2000);
				
				spinnersChecking();
				
				
				while (aPatientNameResult == 0 && attempt != 0) {
				
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
						
						aPatientNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();
					}	
					
					if (aPatientNameResult == 0) {
						CommonFunctions.waitandClick(patientNameInputTextbox, 30);
						CommonFunctions.waitandClear(patientNameInputTextbox, 30);
						patientNameInputTextbox.sendKeys(aPatientName);
						CommonFunctions.waitandClick(patientNameSearchButton, 30);
						spinnersChecking();
						System.out.println("Number of attempt: " + attempt + " " + patientNameInputTextbox.getAttribute("value"));
						attempt--;
					}	
					
					aPatientNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();	
				}	

				
								
				System.out.println("Number of patient Name for this table found: " + aPatientNameResult);

				return (aPatientNameResult);

		} catch (Exception e) {
			return aPatientNameResult;
		}

	}
	
	
	/**
	 * DESCRIPTION: Enter patient and click search,
	 * RETURNS: list if result:
	 */

	public boolean searchPatientNamePerformance(String aPatientName, long maxDuration) {

		int aPatientNameResult = 0;
		int attempt = 10;
		boolean result = false;
		
		
		try {
			
				long timeSpentLoadingPatientPage = spinnersCheckingPerformance("Loading Patient Page");
				CommonFunctions.waitandClick(patientNameInputTextbox, 30);
				CommonFunctions.waitandClear(patientNameInputTextbox, 30);
				patientNameInputTextbox.sendKeys(aPatientName);
				long timeSpentEnteringPatientPage = spinnersCheckingPerformance("Entering Patient Name in the Page");
				
				CommonFunctions.waitandClick(patientNameSearchButton, 30);
				
				//Thread.sleep(2000);
				
				long timeSpentSearchingPatientPage = spinnersCheckingPerformance("Searching Patient Name in the Page");
				
				
				while (aPatientNameResult == 0 && attempt != 0) {
				
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
						
						aPatientNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();
					}	
					
					if (aPatientNameResult == 0) {
						CommonFunctions.waitandClick(patientNameInputTextbox, 30);
						CommonFunctions.waitandClear(patientNameInputTextbox, 30);
						patientNameInputTextbox.sendKeys(aPatientName);
						timeSpentEnteringPatientPage = spinnersCheckingPerformance("Entering Patient Name in the Page");
						CommonFunctions.waitandClick(patientNameSearchButton, 30);
						timeSpentSearchingPatientPage = spinnersCheckingPerformance("Searching Patient Name in the Page");
						System.out.println("Number of attempt: " + attempt + " " + patientNameInputTextbox.getAttribute("value"));
						attempt--;
					}	
					
					aPatientNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();
				}	

				if (aPatientNameResult > 0 && timeSpentSearchingPatientPage <= maxDuration && timeSpentLoadingPatientPage <=maxDuration && timeSpentEnteringPatientPage <=maxDuration) {
					result =  true;
				}
								
				System.out.println("Number of patient Name for this table found: " + aPatientNameResult);

				return (result);

		} catch (Exception e) {
			return result;
		}

	}
	
	/**
	 * DESCRIPTION: Enter patient and click search,
	 * RETURNS: list if result:
	 */

	public boolean searchPatientNamePerformanceDropDownMatches(String aPatientNamePrefix, ArrayList<String> aDBList, long maxDuration) {

		boolean result = false;
		ArrayList<String> aPatientDisplayNameList = new ArrayList<>();
		long timeSpentEnteringPatientPage = 0;
		
		try {
			
				spinnersChecking();
				CommonFunctions.waitandClick(patientNameInputTextbox, 5);
				CommonFunctions.waitandClear(patientNameInputTextbox, 5);
				for (int i=0; i<aPatientNamePrefix.length();i++) {
					patientNameInputTextbox.sendKeys(String.valueOf(aPatientNamePrefix.charAt(i)));
					timeSpentEnteringPatientPage = timeSpentEnteringPatientPage + spinnersCheckingPerformance("Entering Patient Name in the Page");
				}
				
				List<WebElement> elementList= driver.findElements(By.xpath("//li[contains(@id, 'option-')]/a[@class='ng-scope ng-binding']"));
				for(WebElement we:elementList){
					aPatientDisplayNameList.add(we.getText());
				}
				
				if(aPatientDisplayNameList.equals(aDBList)) {
					result = true;
					System.out.println("drop down matches the DB list and take total " + timeSpentEnteringPatientPage + " second(s) to load");
				}
		
				return (result && timeSpentEnteringPatientPage <=maxDuration);
		} catch (Exception e) {
			return result;
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

	/**
	 * DESCRIPTION: Enter phn numnber and click search,
	 * prefix RETURNS: list if result:
	 */
	
	public int searchPhn(String aPhnnumber) {
	
		int aPhnnumberResult = 0;
		int attempt = 10;
		try {
			// if not logged in then login
			// if on login page
				
				spinnersChecking();
				CommonFunctions.waitandClick(phnInputTextbox, 30);
				CommonFunctions.waitandClear(phnInputTextbox, 30);
				phnInputTextbox.sendKeys(aPhnnumber);
				phnInputTextbox.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
	
				CommonFunctions.waitandClick(phnSearchButton, 30);
				
				spinnersChecking();
				//Thread.sleep(5000);
				
				while (aPhnnumberResult == 0 && attempt != 0) {
				
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
						
						aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();			
		
					}	
					
					if (aPhnnumberResult == 0) {
						// CommonFunctions.waitandClick(phnInputTextbox, 30);
						CommonFunctions.waitandClear(phnInputTextbox, 30);
						phnInputTextbox.sendKeys(aPhnnumber+String.valueOf(attempt));
						phnInputTextbox.sendKeys(Keys.ENTER);
						CommonFunctions.waitandClick(phnSearchButton, 30);
						spinnersChecking();
						System.out.println("Number of attempt: " + attempt + " " + phnInputTextbox.getAttribute("value"));
						attempt--;
					}
					
					aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();			
				}	
					
				System.out.println("Number of PhnNumber for this table found: " + aPhnnumberResult);
	
				return (aPhnnumberResult);
		//return CommonFunctions.waitForVisiblity(mainMenuPage.historicalAccessionsIcon, 20);
	
		} catch (Exception e) {
			return aPhnnumberResult;
		}
	
	}

	
	/**
	 * DESCRIPTION: Enter phn numnber and click search,
	 * prefix RETURNS: list if result:
	 */
	
	public boolean searchPhnPerformance(String aPhnnumber, long maxDuration) {
	
		int aPhnnumberResult = 0;
		int attempt = 10;
		boolean result = false;
		try {
				long timeSpentLoadingPHNPage = spinnersCheckingPerformance("Loading PHN Page");
				CommonFunctions.waitandClick(phnInputTextbox, 30);
				CommonFunctions.waitandClear(phnInputTextbox, 30);
				phnInputTextbox.sendKeys(aPhnnumber);
				long timeSpentEnteringPHNPage = spinnersCheckingPerformance("Entering PHN in the Page");
			//	phnInputTextbox.sendKeys(Keys.ENTER);
			
	
				CommonFunctions.waitandClick(phnSearchButton, 30);
				
				long timeSpentSearchingPHNPage = spinnersCheckingPerformance("Searching PHN in the Page");
		
				
				
				while (aPhnnumberResult == 0 && attempt != 0) {
				
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
						
						aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();			
		
					}	
					
					if (aPhnnumberResult == 0) {
						// CommonFunctions.waitandClick(phnInputTextbox, 30);
						CommonFunctions.waitandClear(phnInputTextbox, 30);
						phnInputTextbox.sendKeys(aPhnnumber+String.valueOf(attempt));
						timeSpentEnteringPHNPage = spinnersCheckingPerformance("Entering PHN in the Page");
						phnInputTextbox.sendKeys(Keys.ENTER);
						CommonFunctions.waitandClick(phnSearchButton, 30);
						timeSpentSearchingPHNPage = spinnersCheckingPerformance("Searching PHN in the Page");
						System.out.println("Number of attempt: " + attempt + " " + phnInputTextbox.getAttribute("value"));
						attempt--;
					}
					
					aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();			
					
				}	
				
				
				if (aPhnnumberResult > 0 && timeSpentSearchingPHNPage <= maxDuration && timeSpentLoadingPHNPage <=maxDuration && timeSpentEnteringPHNPage <=maxDuration) {
					result =  true;
				}
								
				System.out.println("Number of PhnNumber for this table found: " + aPhnnumberResult);
				
				return result;

				
		} catch (Exception e) {
			return result;
		}
	
	}
	
	
	
	
	/**
	 * DESCRIPTION: Enter dob and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchDOB(String aDOB) {
	
		int aDOBResult = 0;
		int attempt = 10;
	//	int dobDigit = 9;
		try {
			
				spinnersChecking();
				CommonFunctions.waitandClick(dobInputTextbox, 30);
				CommonFunctions.waitandClear(dobInputTextbox, 30);
				dobInputTextbox.sendKeys(aDOB);
				dobInputTextbox.sendKeys(Keys.ENTER);
	
				CommonFunctions.waitandClick(dobSearchButton, 30);
				
				//Thread.sleep(5000);
				spinnersChecking();
				
				while (aDOBResult == 0 && attempt !=0) {
					
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
						
						aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();
						
					}
					
					if (aDOBResult == 0) {
						CommonFunctions.waitandClear(dobInputTextbox, 30);
						dobInputTextbox.sendKeys(aDOB+String.valueOf(attempt));
						dobInputTextbox.sendKeys(Keys.ENTER);
						CommonFunctions.waitandClick(dobSearchButton, 30);
						spinnersChecking();
						System.out.println("Number of attempt: " + attempt + " " + dobInputTextbox.getAttribute("value"));
						attempt--;
						
					}
					aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();
					
				}	
				//aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + dobInputTextbox.getText() + "')]")).size();
	
				System.out.println("Number of DOB for this table found: " + aDOBResult);
	
				return (aDOBResult);
	
		} catch (Exception e) {
			return aDOBResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter dob and click search,
	 * RETURNS: list if result:
	 */
	
	public boolean searchDOBPerformance(String aDOB, long maxDuration) {
	
		int aDOBResult = 0;
		int attempt = 10;
		boolean result = false;
	//	int dobDigit = 9;
		try {
			
				long timeSpentLoadingDOBPage = spinnersCheckingPerformance("Loading DOB Page");
				CommonFunctions.waitandClick(dobInputTextbox, 30);
				CommonFunctions.waitandClear(dobInputTextbox, 30);
				dobInputTextbox.sendKeys(aDOB);
				long timeSpentEnteringDOBPage = spinnersCheckingPerformance("Entering DOB in the Page");
				dobInputTextbox.sendKeys(Keys.ENTER);
	
				CommonFunctions.waitandClick(dobSearchButton, 30);
				
				long timeSpentSearchingDOBPage = spinnersCheckingPerformance("Searching DOB in the Page");
				
				while (aDOBResult == 0 && attempt !=0) {
					
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
						
						aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();
						
					}
					
					if (aDOBResult == 0) {
						CommonFunctions.waitandClear(dobInputTextbox, 30);
						dobInputTextbox.sendKeys(aDOB+String.valueOf(attempt));
						timeSpentEnteringDOBPage = spinnersCheckingPerformance("Entering DOB in the Page");
						dobInputTextbox.sendKeys(Keys.ENTER);
						CommonFunctions.waitandClick(dobSearchButton, 30);
						timeSpentSearchingDOBPage = spinnersCheckingPerformance("Searching DOB in the Page");
						System.out.println("Number of attempt: " + attempt + " " + dobInputTextbox.getAttribute("value"));
						attempt--;
						
					}
					
					aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();

				}	
	
				if (aDOBResult > 0 && timeSpentSearchingDOBPage <= maxDuration && timeSpentLoadingDOBPage <=maxDuration && timeSpentEnteringDOBPage <=maxDuration) {
					result =  true;
				}
				
				
				
				
				System.out.println("Number of DOB for this table found: " + aDOBResult);
	
				return (result);
	
		} catch (Exception e) {
			return result;
		}
	
	}
	
	/**
	 * DESCRIPTION: Enter patient and click search,
	 * RETURNS: list if result:
	 */

	public boolean searchDOBPerformanceDropDownMatches(String aDOBPrefix, ArrayList<String> aDBList, long maxDuration) {

		boolean result = false;
		ArrayList<String> aDOBList = new ArrayList<>();
		long timeSpentEnteringDOBPage = 0;
		
		try {
			
				spinnersChecking();
				CommonFunctions.waitandClick(dobInputTextbox, 30);
				CommonFunctions.waitandClear(dobInputTextbox, 30);
				for (int i=0; i<aDOBPrefix.length();i++) {
					dobInputTextbox.sendKeys(String.valueOf(aDOBPrefix.charAt(i)));
					timeSpentEnteringDOBPage = timeSpentEnteringDOBPage + spinnersCheckingPerformance("Entering DOB in the Page");
				}
				
				List<WebElement> elementList= driver.findElements(By.xpath("//li[contains(@id, 'option-')]/a[@class='ng-scope ng-binding']"));
				for(WebElement we:elementList){
					aDOBList.add(we.getText());
				}
				
				if(aDOBList.equals(aDBList)) {
					result = true;
					System.out.println("drop down matches the DB list and take total " + timeSpentEnteringDOBPage + " second(s) to load");
				}
	
				return (result && timeSpentEnteringDOBPage <=maxDuration);
		} catch (Exception e) {
			return result;
		}

	}
	
	
	/**
	 * DESCRIPTION: Enter patient and click search,
	 * RETURNS: list if result:
	 */

	public boolean searchPhnPerformanceDropDownMatches(String aPhnPrefix, ArrayList<String> aDBList, long maxDuration) {

		boolean result = false;
		ArrayList<String> aPhnList = new ArrayList<>();
		long timeSpentEnteringPHNPage = 0;
		
		try {
			
				spinnersChecking();
				CommonFunctions.waitandClick(phnInputTextbox, 30);
				CommonFunctions.waitandClear(phnInputTextbox, 30);
				for (int i=0; i<aPhnPrefix.length();i++) {
					phnInputTextbox.sendKeys(String.valueOf(aPhnPrefix.charAt(i)));
					timeSpentEnteringPHNPage = timeSpentEnteringPHNPage + spinnersCheckingPerformance("Entering PHN in the Page");
				}
				
				List<WebElement> elementList= driver.findElements(By.xpath("//li[contains(@id, 'option-')]/a[@class='ng-scope ng-binding']"));
				for(WebElement we:elementList){
					aPhnList.add(we.getText());
				}
				
				if(aPhnList.equals(aDBList)) {
					result = true;
					System.out.println("drop down matches the DB list and take total " + timeSpentEnteringPHNPage + " second(s) to load");
				}
	
				return (result && timeSpentEnteringPHNPage <=maxDuration);
		} catch (Exception e) {
			return result;
		}

	}
	
	
	
	/**
	 * DESCRIPTION: Enter bill status and type  and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchBillStatus(String aDate, String aBillStatus ) {
	
		int aBillStatusResult = 0;
		try {

				spinnersChecking();
				CommonFunctions.waitandClear(dateInputTextBox, 30);
				dateInputTextBox.sendKeys(aDate);
				
				CommonFunctions.waitandClear(billStatusInputTextBox, 30);
				billStatusInputTextBox.sendKeys(aBillStatus);
				
	
				CommonFunctions.waitandClick(billStatusSearchButton, 30);
				
				//Thread.sleep(5000);
				spinnersChecking();
				aBillStatusResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aDate + "')]")).size();	
	
				System.out.println("Number of bill Status for this table found: " + aBillStatusResult);
	
				return (aBillStatusResult);

		} catch (Exception e) {
			return aBillStatusResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter payerName and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchPayerName(String aPayerName, String aPayer) {
	
		int aPayerNameResult = 0;
		
		
		try {

				spinnersChecking();
				CommonFunctions.waitandClear(payerInputTextbox, 30);
				payerInputTextbox.sendKeys(aPayerName);
	
				CommonFunctions.waitandClick(payerSearchButton, 30);
				
				//Thread.sleep(5000);
				spinnersChecking();
				aPayerNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aPayer + "')]")).size();	
	
								
				System.out.println("Number of payer Name for this table found: " + aPayerNameResult);
	
				return (aPayerNameResult);
	
		} catch (Exception e) {
			return aPayerNameResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter fee code and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchFeeCode(String aFeeCode, String aBillStatus) {
	
		int aFeeCodeResult = 0;
		int attempt = 10;
		
		
		try {

				spinnersChecking();
				CommonFunctions.waitandClear(feeCodeInputTextbox, 30);
				feeCodeInputTextbox.sendKeys(aFeeCode);
	
				CommonFunctions.waitandClick(payerSearchButton, 30);
				spinnersChecking();
				
				while (aFeeCodeResult == 0 && attempt !=0) {
					
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
					
						aFeeCodeResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aBillStatus + "')]")).size();		
		
					}
					
					if (aFeeCodeResult == 0) {
						CommonFunctions.waitandClick(payerSearchButton, 30);
						spinnersChecking();
						attempt--;
						System.out.println("Number of attempt: " + attempt);
						
					}	
				}
				
				
								
				System.out.println("Number of addess for fee code for this table found: " + aFeeCodeResult);
	
				return (aFeeCodeResult);
	
		} catch (Exception e) {
			return aFeeCodeResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter fee code and payer name and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchPayerFeeCode(String aPayerName, String aFeeCode, String aPayer) {
	
		int aPayerFeeCodeResult = 0;
		int attempt = 10;
		
		
		try {

				spinnersChecking();
				CommonFunctions.waitandClear(payerInputTextbox, 30);
				payerInputTextbox.sendKeys(aPayerName);
				CommonFunctions.waitandClear(feeCodeInputTextbox, 30);
				feeCodeInputTextbox.sendKeys(aFeeCode);
	
				CommonFunctions.waitandClick(payerSearchButton, 30);
				spinnersChecking();
				
				
				while (aPayerFeeCodeResult == 0 && attempt !=0) {
					
					if (CommonFunctions.waitForVisiblity(payerColumn, 60)) {
					
						aPayerFeeCodeResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aPayer + "')]")).size();		
		
					}
					
					if (aPayerFeeCodeResult == 0) {
						CommonFunctions.waitandClick(payerSearchButton, 30);
						attempt--;
						System.out.println("Number of attempt: " + attempt);
						
					}	
				}
				
				
				System.out.println("Number of addess for payer and fee code for this table found: " + aPayerFeeCodeResult);
	
				return (aPayerFeeCodeResult);
	
		} catch (Exception e) {
			return aPayerFeeCodeResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter accession number and prefix and type  and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchAccession(String aPrefix, String aAccessionNumber, String aPayer ) {
	
		int aAccessionResult = 0;
		try {
	
				
				spinnersChecking();
				CommonFunctions.waitandClear(prefixInputTextBox, 30);
				prefixInputTextBox.sendKeys(aPrefix);
				
				CommonFunctions.waitandClear(accessionInputTextBox, 30);
				accessionInputTextBox.sendKeys(aAccessionNumber);
				
				CommonFunctions.waitandClick(accessionSearchButton, 30);
				
				spinnersChecking();
				//Thread.sleep(5000);
				aAccessionResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aPayer + "')]")).size();	
				
				System.out.println("Number of accession number of the payer for this table found: " + aAccessionResult);
	
				return (aAccessionResult);

	
		} catch (Exception e) {
			return aAccessionResult;
		}
	
	}

	public boolean clickFind2Tab(LARS_InvoicesSearchPage invoicesSearchPage) {
	
		try {
			//Thread.sleep(1000);
			CommonFunctions.waitandClick(this.find2Tab, 30);
			//Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.prefixLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * DESCRIPTION: Enter invoice and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchInvoice(String aInvoice) {
	
		int aInvoiceResult = 0;
		try {

				spinnersChecking();
				CommonFunctions.waitandClear(invoiceIdTextbox, 30);
				invoiceIdTextbox.sendKeys(aInvoice);
	
				CommonFunctions.waitandClick(invoiceSearchButton, 30);
				
				//Thread.sleep(5000);
				spinnersChecking();
				aInvoiceResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();	
				
				
				System.out.println("Number of invoice for this table found: " + aInvoiceResult);
	
				return (aInvoiceResult);
	
		} catch (Exception e) {
			return aInvoiceResult;
		}
	
	}
	
	public boolean clickTopMenuPayer(LARS_InvoicesSearchPage invoicesSearchPage) {

		try {
			Thread.sleep(4000);
			CommonFunctions.waitandClick(this.topMenuPayer, 30);
			Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(invoicesSearchPage.payerLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public long spinnersCheckingPerformance(String aFunction) {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		long result = 0;
		
		try {
			
			
				long start =  System.currentTimeMillis();
				startTime2 = 400;
				elapsedTime2 = startTime2 - 10;
				spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				
				while (spinnersExist == false && elapsedTime2 > 10) {
					elapsedTime2 = elapsedTime2 -10;
					spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				}
				long end = System.currentTimeMillis();
				long diff = end - start;
				System.out.println(aFunction + " takes " + diff/1000 + " seconds to complete" );
				result = diff/1000;
				// System.out.println("Spinners is not here or timeout: " + spinnersExist);
				return result;
		} catch (Exception e) {
			System.out.println("Spinners is still here or timeout: " + spinnersExist);
			return result;
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

	public void dobTextBoxClear(){
		
		try {
			
			spinnersChecking();
			CommonFunctions.waitandClear(dobInputTextbox, 5);;
	} catch (Exception e) {
	}
	}

	public void patientNameTextBoxClear(){
		
		try {
			
			spinnersChecking();
			CommonFunctions.waitandClear(patientNameInputTextbox, 5);
	} catch (Exception e) {
	}
	}

	public void phnTextBoxClear(){
		
		try {
			
			spinnersChecking();
			CommonFunctions.waitandClear(phnInputTextbox, 5);;
	} catch (Exception e) {
	}
	}	

}