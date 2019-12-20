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

public class LARS_AccessionSearchPage extends LoadableComponent<LARS_AccessionSearchPage> {


	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//span[@class='ng-binding' and text()='PHN']")
	public WebElement phnTab;
	
	@FindBy(xpath = "//div[contains(text(),'Accessions')]")
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
	
	/* PHN */
	
	@FindBy(xpath = "//div[@class='searchLabel ng-binding' and text()='PHN:']")
	public WebElement phnLabel;
	
	@FindBy(xpath = "//input[@id='phnInput']")
	public WebElement phnInputTextbox;
	
	@FindBy(xpath = "//button[@id='phnGo']")
	public WebElement phnSearchButton;
	
	/* Payers */
	
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
	
	/* Patient name */
	
	
	@FindBy(xpath = "//input[@id='patientNameInput']")
	public WebElement patientNameInputTextbox;
	
	@FindBy(xpath = "//button[@id='patientNameGo']")
	public WebElement patientNameSearchButton;

	//@FindBy(xpath = "//div[@class='searchLabel' and text()='Patient last, first name:']")
	@FindBy(xpath = "//div[@class='searchLabel' and contains(text(),'Patient last, first name:')]")
	public WebElement patientNameLabel;
	
	
	
	/* dob */
	@FindBy(xpath = "//div[@class='searchLabel ng-binding' and text()='Date of Birth (YYYY-MM-DD):']")
	public WebElement dobLabel;
	
	@FindBy(xpath = "//input[@id='dobInput']")
	public WebElement dobInputTextbox;
	
	@FindBy(xpath = "//button[@id='dobGo']")
	public WebElement dobSearchButton;
	
	/* bill status */
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Bill Status:']")
	public WebElement billStatusLabel;
	
	@FindBy(xpath = "//input[@data-ng-model='bsSearch.bsStatus']")
	public WebElement billStatusInputTextBox;
	
	@FindBy(xpath = "//select[@id='billStatusDateOptions']")
	public WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@name='bsDate']")
	public WebElement dateInputTextBox;
	
	@FindBy(xpath = "//button[@id='bsGo']")
	public WebElement billStatusSearchButton;
	
	/* accession number */
	@FindBy(xpath = "//input[@id='prefixInput']")
	public WebElement prefixInputTextBox;
	
	//@FindBy(xpath = "//input[@id='accessionInput']")
	@FindBy(id = "accessionInput")
	public WebElement accessionInputTextBox;
	
	@FindBy(xpath = "//button[@id='accessionGo']")
	public WebElement accessionSearchButton;
	
	@FindBy(xpath = "//div[@class='searchLabel' and text()='Prefix:']")
	public WebElement prefixLabel;
	
	@FindBy(xpath = "//th[@class='col-md-1' and text()='PHN']")
	public WebElement phnColumnTitle;
	
	@FindBy(xpath = "//*[@id='overlay-content']")
	public WebElement loadingDialog;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	public WebElement exceptionMessage;
	
	
	@FindBy(xpath = "//span[contains(text(),'Patient Info')]")
	public WebElement patientInfo;
	
	
	@FindBy(xpath = "//a[contains(@href, '#/invoiced')]")
	public List<WebElement> idLink;
	
	
	@FindBy(xpath = "//a[@href='#/accessionsSummary']")
	public WebElement patientAccessionsTab;
	
	
	
	
	
	WebDriver driver = null;

	public LARS_AccessionSearchPage(WebDriver driver) {
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

	

	public boolean clickPHNTab(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			//Thread.sleep(4000);
			
			CommonFunctions.waitandClick(this.phnTab, 30);
			
			
			
			//Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.phnLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickDOBTab(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			//Thread.sleep(4000);
			CommonFunctions.waitandClick(this.dobTab, 30);
			//Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.dobLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickPatientNamesTab(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			//Thread.sleep(4000);
			CommonFunctions.waitandClick(this.patientNamesTab, 30);
			//Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.patientNameLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickPayersTab(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			//Thread.sleep(4000);
			CommonFunctions.waitandClick(this.payersTab, 30);
			//Thread.sleep(7000);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.payerLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickBillStatusTab(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			//Thread.sleep(1000);
			CommonFunctions.waitandClick(this.billStatusTab, 30);
			//Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.billStatusLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickFindTab(LARS_AccessionSearchPage accessionSearchPage) {

		try {
			//Thread.sleep(1000);
			CommonFunctions.waitandClick(this.findTab, 30);
			//Thread.sleep(1000);
			return CommonFunctions.waitForVisiblity(accessionSearchPage.prefixLabel, 30);
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

	/**
	 * DESCRIPTION: Enter fee code and click search,
	 * prefix RETURNS: list if result:
	 */
	
	public int searchFeeCode(String aFeeCode, String aAddress) {
	
		int aFeeCodeResult = 0;
		int attempt = 20;
		
		try {
			
				spinnersChecking();
				CommonFunctions.waitandClear(feeCodeInputTextbox, 30);
				feeCodeInputTextbox.sendKeys(aFeeCode);
	
				CommonFunctions.waitandClick(payerSearchButton, 30);
	
	//			if (!loadingDialog.isDisplayed()){
	//				while (driver.findElements(By.xpath("//span[@class='ng-binding ng-scope']")).size() != 0 && attempt !=0 ){
	//					CommonFunctions.waitandClick(payerSearchButton, 30);
	//					attempt--;
	//				}
	//			}
				
				spinnersChecking();
	
				while (aFeeCodeResult == 0 && attempt !=0) {
				
					if (CommonFunctions.waitForVisiblity(phnColumnTitle, 60)) {
					
						aFeeCodeResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aAddress + "')]")).size();	
		
					}
					
					if (aFeeCodeResult == 0) {
						CommonFunctions.waitandClick(payerSearchButton, 30);
						attempt--;
						System.out.println("Number of attempt: " + attempt);
					}	
				}
				System.out.println("Number of addess for fee code for this table found: " + aFeeCodeResult);
	
				return (aFeeCodeResult);
		//return CommonFunctions.waitForVisiblity(mainMenuPage.historicalAccessionsIcon, 20);
	
		} catch (Exception e) {
			return aFeeCodeResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter fee code and payer name and click search,
	 * prefix RETURNS: list if result:
	 */
	
	public int searchPayerFeeCode(String aPayerName, String aFeeCode, String aAddress) {
	
		int aPayerFeeCodeResult = 0;
		int attempt = 2;
		
		
		try {
			// if not logged in then login
			// if on login page
				spinnersChecking();
				CommonFunctions.waitandClear(payerInputTextbox, 30);
				payerInputTextbox.sendKeys(aPayerName);
				CommonFunctions.waitandClear(feeCodeInputTextbox, 30);
				feeCodeInputTextbox.sendKeys(aFeeCode);
	
				CommonFunctions.waitandClick(payerSearchButton, 30);
				
				//Thread.sleep(5000);
				spinnersChecking();
				
				while (aPayerFeeCodeResult == 0 && attempt !=0) {
					
					if (CommonFunctions.waitForVisiblity(phnColumnTitle, 60)) {
					
						aPayerFeeCodeResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aAddress + "')]")).size();		
		
					}
					
					if (aPayerFeeCodeResult == 0) {
						CommonFunctions.waitandClick(payerSearchButton, 30);
						attempt--;
						System.out.println("Number of attempt: " + attempt);
						
					}	
				}
				
						
				System.out.println("Number of addess for apyer and fee code for this table found: " + aPayerFeeCodeResult);
	
				return (aPayerFeeCodeResult);
		//return CommonFunctions.waitForVisiblity(mainMenuPage.historicalAccessionsIcon, 20);
	
		} catch (Exception e) {
			return aPayerFeeCodeResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter payerName and click search,
	 * prefix RETURNS: list if result:
	 */
	
	public int searchPayerName(String aPayerName, String aGender) {
	
		int aPayerNameResult = 0;
		
		
		try {
			// if not logged in then login
			// if on login page
				
				spinnersChecking();
				CommonFunctions.waitandClear(payerInputTextbox, 30);
				payerInputTextbox.sendKeys(aPayerName);
	
				CommonFunctions.waitandClick(payerSearchButton, 30);
				
				spinnersChecking();
				
				if (CommonFunctions.waitForVisiblity(phnColumnTitle, 60)) {
				
					
					aPayerNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aGender + "')]")).size();	
	
				}				
				System.out.println("Number of payer Name for this table found: " + aPayerNameResult);
	
				return (aPayerNameResult);
	
		} catch (Exception e) {
			return aPayerNameResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter dob and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchDOB(String aDOB) {
	
		int aDOBResult = 0;
		try {
			
				spinnersChecking();
			
			
				CommonFunctions.waitandClick(dobInputTextbox, 30);
				CommonFunctions.waitandClear(dobInputTextbox, 30);
				dobInputTextbox.sendKeys(aDOB);
	
				CommonFunctions.waitandClick(dobSearchButton, 30);
				
				spinnersChecking();
				
				aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aDOB + "')]")).size();	
	
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
		boolean result = false;
		
		try {
			
				long timeSpentLoadingDOBPage = spinnersCheckingPerformance("Loading Patient Page");
			
			
				CommonFunctions.waitandClick(dobInputTextbox, 30);
				CommonFunctions.waitandClear(dobInputTextbox, 30);
				dobInputTextbox.sendKeys(aDOB);
				
				long timeSpentEnteringDOBPage = spinnersCheckingPerformance("Entering DOB in the Page");
	
				CommonFunctions.waitandClick(dobSearchButton, 30);
				
				long timeSpentSearchingDOBPage = spinnersCheckingPerformance("Searching DOB in the Page");
				
				aDOBResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aDOB + "')]")).size();	
	
	
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
	 * DESCRIPTION: Enter accession number  and click search,
	 * RETURNS: Move to accession detail page
	 */
	
	public boolean searchAccessionDetail(String aPrefix, String aAccessionNumber, LARS_AccessionAccessionNumberDetailPage accessionAccessionNumberDetailPage ) {
	
		try {
			
				CommonFunctions.waitandClear(prefixInputTextBox, 30);
				prefixInputTextBox.sendKeys(aPrefix);
				
				CommonFunctions.waitandClear(accessionInputTextBox, 30);
				accessionInputTextBox.sendKeys(aAccessionNumber);
				
				CommonFunctions.waitandClick(accessionSearchButton, 30);
				
			
				return accessionAccessionNumberDetailPage.verifyAccessionNumberDetailPageTitle();
						
	
		} catch (Exception e) {
			return false;
		}
	
	}



	/**
	 * DESCRIPTION: Enter phn numnber and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchPhn_BK(String aPhnnumber) {
	
		int aPhnnumberResult = 0;
		int attempt = 10;
	
		try {
			
			
				spinnersChecking();
			
				//CommonFunctions.waitandClick(phnInputTextbox, 30);
				CommonFunctions.waitandClear(phnInputTextbox, 30);
				phnInputTextbox.sendKeys(aPhnnumber);
				Thread.sleep(1000);
				phnInputTextbox.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				CommonFunctions.waitandClick(phnSearchButton, 30);
				
				spinnersChecking();
				
				
				while (aPhnnumberResult == 0 && attempt != 0) {
					
					if (CommonFunctions.waitForVisiblity(phnColumnTitle, 60)) {
						
						aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
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
				}	
				
				
				
		//		aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();	
				
		//		aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
				System.out.println("Number of PhnNumber for this table found: " + aPhnnumberResult);
				
				System.out.println("Number of PhnNumber for this table found: " + phnInputTextbox.getAttribute("value"));
	
				return (aPhnnumberResult);
		
	
		} catch (Exception e) {
			return aPhnnumberResult;
		}
	
	}

	public int searchPhn(String aPhnnumber) {
		
		int aPhnnumberResult = 0;
		int attempt = 10;
	
		try {
			
			
				spinnersChecking();
			
				//CommonFunctions.waitandClick(phnInputTextbox, 30);
				CommonFunctions.waitandClear(phnInputTextbox, 30);
				phnInputTextbox.sendKeys(aPhnnumber);
				Thread.sleep(1000);
				phnInputTextbox.sendKeys(Keys.ENTER);
				Thread.sleep(6000);
				CommonFunctions.waitandClick(phnSearchButton, 30);
				
				spinnersChecking();
				
				
				while (aPhnnumberResult == 0 && attempt != 0) {
					
					if (CommonFunctions.waitForVisiblity(phnColumnTitle, 20)) {
						
						aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
					}
					
					//To see if it goes to accession detail page directly if only 1 record is found.
					
					else if (CommonFunctions.waitForVisiblity(patientInfo, 20)) {
						aPhnnumberResult = 1;
					}
					
					if (aPhnnumberResult == 0) {
						// CommonFunctions.waitandClick(phnInputTextbox, 30);
						CommonFunctions.waitandClear(phnInputTextbox, 30);
						phnInputTextbox.sendKeys('9'+String.valueOf(attempt));
						phnInputTextbox.sendKeys(Keys.ENTER);
						CommonFunctions.waitandClick(phnSearchButton, 30);
						spinnersChecking();
						System.out.println("Number of attempt: " + attempt + " " + phnInputTextbox.getAttribute("value"));
						attempt--;
					}
					aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
					
				}	
				
				
				
		//		aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M') or contains(text(),'F')]")).size();	
				
		//		aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
				System.out.println("Number of PhnNumber for this table found: " + aPhnnumberResult);
				
				System.out.println("Number of PhnNumber for this table found: " + phnInputTextbox.getAttribute("value"));
	
				return (aPhnnumberResult);
		
	
		} catch (Exception e) {
			return aPhnnumberResult;
		}
	
	}

	
	public boolean searchPhnPerformance(String aPhnnumber, long maxDuration) {
		
		int aPhnnumberResult = 0;
		int attempt = 10;
		boolean result = false;
	
		try {
			
			
				long timeSpentLoadingPHNPage = spinnersCheckingPerformance("Loading PHN Page");
			
				//CommonFunctions.waitandClick(phnInputTextbox, 30);
				CommonFunctions.waitandClear(phnInputTextbox, 30);
				phnInputTextbox.sendKeys(aPhnnumber);
				long timeSpentEnteringPHNPage = spinnersCheckingPerformance("Entering Patient PHN in the Page");
				phnInputTextbox.sendKeys(Keys.ENTER);
				
				CommonFunctions.waitandClick(phnSearchButton, 30);
				
				long timeSpentSearchingPHNPage = spinnersCheckingPerformance("Searching Patient PHN in the Page");
				
				
				while (aPhnnumberResult == 0 && attempt != 0) {
					
					if (CommonFunctions.waitForVisiblity(phnColumnTitle, 20)) {
						
						aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
					}
					
					//To see if it goes to accession detail page directly if only 1 record is found.
					
					else if (CommonFunctions.waitForVisiblity(patientInfo, 20)) {
						aPhnnumberResult = 1;
					}
					
					if (aPhnnumberResult == 0) {
						// CommonFunctions.waitandClick(phnInputTextbox, 30);
						CommonFunctions.waitandClear(phnInputTextbox, 30);
						phnInputTextbox.sendKeys('9'+String.valueOf(attempt));
						phnInputTextbox.sendKeys(Keys.ENTER);
						timeSpentEnteringPHNPage = spinnersCheckingPerformance("Entering Patient PHN in the Page");
						CommonFunctions.waitandClick(phnSearchButton, 30);
						timeSpentSearchingPHNPage = spinnersCheckingPerformance("Searching Patient PHN in the Page");
						System.out.println("Number of attempt: " + attempt + " " + phnInputTextbox.getAttribute("value"));
						attempt--;
					}
					aPhnnumberResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + phnInputTextbox.getAttribute("value") + "')]")).size();
				}	
				
				if (aPhnnumberResult > 0 && timeSpentSearchingPHNPage <= maxDuration && timeSpentLoadingPHNPage <=maxDuration && timeSpentEnteringPHNPage <=maxDuration) {
					result =  true;
				}
				
	
				System.out.println("Number of Number for this table found: " + aPhnnumberResult);
				
				System.out.println("Number of PhnNumber for this table found: " + phnInputTextbox.getAttribute("value"));
	
				return (result);
		
	
		} catch (Exception e) {
			return result;
		}
	
	}
	
	/**
	 * DESCRIPTION: Enter patient name and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchPatientName(String aPatientName, String aFirstName, String aLastName) {
	
		int aPatientNameResult = 0;
		int aPatientLastNameResult = 0;
		int aPatientFirstNameResult = 0;
		
		try {
			
				spinnersChecking();
			
				CommonFunctions.waitandClick(patientNameInputTextbox, 30);
				CommonFunctions.waitandClear(patientNameInputTextbox, 30);
				patientNameInputTextbox.sendKeys(aPatientName);
	
				CommonFunctions.waitandClick(patientNameSearchButton, 30);
				
				spinnersChecking();
				
				if (CommonFunctions.waitForVisiblity(phnColumnTitle, 20)) {
					
					aPatientFirstNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aFirstName + "')]")).size();	
				}
				
				//To see if it goes to accession detail page directly if only 1 record is found.
				
				else if (CommonFunctions.waitForVisiblity(patientInfo, 20)) {
					aPatientFirstNameResult = 1;
				}
				
				
				System.out.println("Number of patient Name for this table found: " + aPatientFirstNameResult);
	
				return (aPatientFirstNameResult);
		
	
		} catch (Exception e) {
			return aPatientNameResult;
		}
	
	}

	
	
	/**
	 * DESCRIPTION: Enter patient name and click search,
	 * RETURNS: list if result:
	 */
	
	public boolean searchPatientNamePerformance(String aPatientName, String aFirstName, String aLastName, long maxDuration) {
	
		int aPatientNameResult = 0;
		int aPatientLastNameResult = 0;
		int aPatientFirstNameResult = 0;
		boolean result = false;
		
		try {
			
				long timeSpentLoadingPatientPage = spinnersCheckingPerformance("Loading Patient Page");
			
				CommonFunctions.waitandClick(patientNameInputTextbox, 30);
				CommonFunctions.waitandClear(patientNameInputTextbox, 30);
				patientNameInputTextbox.sendKeys(aPatientName);
				long timeSpentEnteringPatientPage = spinnersCheckingPerformance("Entering Patient Name in the Page");
	
				CommonFunctions.waitandClick(patientNameSearchButton, 30);
				
				long timeSpentSearchingPatientPage = spinnersCheckingPerformance("Searching Patient Name in the Page");
				
				
				if (CommonFunctions.waitForVisiblity(phnColumnTitle, 20)) {
					
					aPatientFirstNameResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aFirstName + "')]")).size();	
				}
				
				//To see if it goes to accession detail page directly if only 1 record is found.
				
				else if (CommonFunctions.waitForVisiblity(patientInfo, 20)) {
					aPatientFirstNameResult = 1;
				}
				
				
				if (aPatientFirstNameResult > 0 && timeSpentSearchingPatientPage <= maxDuration && timeSpentLoadingPatientPage <=maxDuration && timeSpentEnteringPatientPage <=maxDuration) {
					result =  true;
				}
				
				
				System.out.println("Number of patient Name for this table found: " + aPatientFirstNameResult);
	
				return (result);
		
	
		} catch (Exception e) {
			return result;
		}
	
	}


	/**
	 * DESCRIPTION: Enter bill status and type  and click search,
	 * RETURNS: list if result:
	 */
	
	public int searchBillStatus(String aType, String aDate, String aBillStatus ) {
	
		int aBillStatusResult = 0;
		try {
				spinnersChecking();
				CommonFunctions.waitandClear(typeDropDown, 30);
				typeDropDown.sendKeys(aType);
				
				CommonFunctions.waitandClear(dateInputTextBox, 30);
				dateInputTextBox.sendKeys(aDate);
				
				CommonFunctions.waitandClear(billStatusInputTextBox, 30);
				billStatusInputTextBox.sendKeys(aBillStatus);
				
	
				CommonFunctions.waitandClick(billStatusSearchButton, 30);
				
				
				spinnersChecking();
				aBillStatusResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aDate + "')]")).size();	
	
				System.out.println("Number of bill with date for this table found: " + aBillStatusResult);
	
				return (aBillStatusResult);
		
	
		} catch (Exception e) {
			return aBillStatusResult;
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
	
	
	public void dobTextBoxClear(){
		
		try {
			
			spinnersChecking();
			CommonFunctions.waitandClear(dobInputTextbox, 5);;
	} catch (Exception e) {
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
	
	public void resetParameter() {
		String dbLNExtract = "";
		String query = "";
		ArrayList<String> requestKey = new ArrayList<>();
		int startTime2 = 4000;
		int elapseTime2 = startTime2 - 10;
	}
	
	public void patientAccessionTabClick() {
		patientAccessionsTab.click();
		spinnersChecking();
	}

	
}