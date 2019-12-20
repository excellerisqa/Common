package lars.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class LARS_CodeMappingPage extends LoadableComponent<LARS_CodeMappingPage> {

	/* Test Code */

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	@FindBy(xpath = "//div[contains(text(),'Code Mapping')]")
	public WebElement headerText;

	@FindBy(xpath = "//a[@href='#/testCode' and text()='Test Code']")
	public WebElement testCodeTab;

	@FindBy(xpath = "//a[@href='#/resultCode' and text()='Result Code']")
	public WebElement resultCodeTab;

	@FindBy(xpath = "//div[@class='searchLabel' and text()='Test Code:']")
	public WebElement testCodeLabel;

	@FindBy(xpath = "//div[@class='searchLabel' and text()='Result Code:']")
	public WebElement resultCodeLabel;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Search']")
	public WebElement testCodeSearchButton;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Add']")
	public WebElement testCodeAddButton;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Update']")
	public WebElement testCodeUpdateButton;

	@FindBy(xpath = "//button[@class='btn btn-default' and text()='Show Operations']")
	public WebElement testMnemonicShowOperationsButton;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Add Test Code Alias']")
	public WebElement addTestCodeAliasButton;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Update']")
	public WebElement updateTestCodeAliasButton;

	@FindBy(xpath = "//input[@data-ng-model='testCodeSearch']")
	public WebElement testCodeInputTextbox;

	@FindBy(xpath = "//input[@id='aliasSearch']")
	public WebElement testMnemonicInputTextbox;

	@FindBy(xpath = "//td/div[@class='ng-binding ng-scope']")
	public WebElement testMnemonicRow;

	@FindBy(xpath = "//input[@id='aliasEdit']")
	public WebElement testMnemonicEditInputTextbox;

	@FindBy(xpath = "//*[@id='updateAliasForm']/button[@class='btn btn-primary' and text()='Update']")
	public WebElement testMnemonicUpdateButton;

	/* result code */

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Add Result Code and Mapping']")
	public WebElement resultCodeAndMappingAddButton;

	@FindBy(xpath = "//input[@ng-model='resultCodeSearch']")
	public WebElement resultCodeInputTextbox;

	@FindBy(xpath = "//button[@name='isBillable']")
	public WebElement billableCheckBox;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Update Result Code']")
	public WebElement resultCodeUpdateButton;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Add Fee Code Mapping']")
	public WebElement feeCodeMappingAddButton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Select Fee Code Mapping']")
	public WebElement feeCodeMappingSelectButton;

	@FindBy(xpath = "//input[@id='feeCodeSearch']")
	public WebElement feeCodeSearchInputTextbox;

	@FindBy(xpath = "//div[@class='btn-lg glyphicon glyphicon-trash']")
	public WebElement feeCodeDeleteButton;

	WebDriver driver = null;
	
	public String testCode;
	
	public int resultCode;

	public LARS_CodeMappingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	@Override
	protected void isLoaded() throws Error {}

	@Override
	protected void load() {}

	public boolean clickTestCodeTab(LARS_CodeMappingPage codeMappingPage) {

		try {

			CommonFunctions.waitandClick(this.testCodeTab, 30);

			return CommonFunctions.waitForVisiblity(codeMappingPage.testCodeLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean clickResultCodeTab(LARS_CodeMappingPage codeMappingPage) {

		try {

			CommonFunctions.waitandClick(this.resultCodeTab, 30);

			return CommonFunctions.waitForVisiblity(codeMappingPage.resultCodeLabel, 30);
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
	 * DESCRIPTION: Enter test code and click search, RETURNS: list if result:
	 */

	public int searchTestCode(String aTestCode) {

		int aTestCodeResult = 0;
		try {

			spinnersChecking();
			CommonFunctions.waitandClear(testCodeInputTextbox, 30);
			testCodeInputTextbox.sendKeys(aTestCode);

			CommonFunctions.waitandClick(testCodeSearchButton, 30);
			
			spinnersChecking();
			aTestCodeResult = ObjectHelper.driver.findElements(By.xpath("//td/div[contains(text(),'PHGF')]")).size();

			System.out.println("Number of test code for this table found: " + aTestCodeResult);

			return (aTestCodeResult);

		} catch (Exception e) {
			return aTestCodeResult;
		}

	}

	/**
	 * DESCRIPTION: Add test code mnemonic and click search after add, RETURNS: list
	 * if result:
	 */

	public int addTestCode(String aTestCodeMnemonic) {

		int aTestCodeResult = 0;
		String aTestCode = "";
		try {

			spinnersChecking();
			while (!testCodeAddButton.isEnabled()) {
				CommonFunctions.waitandClear(testCodeInputTextbox, 30);
				aTestCode = utils.CommonFunctions.getSaltString(5);
				testCodeInputTextbox.sendKeys(aTestCode);
			}
			/* add new test code */
			// testCodeAddButton.click();
			// Thread.sleep(1000);
			Thread.sleep(2000);
			CommonFunctions.waitandClick(testCodeAddButton, 30);
			/* reset the test code page */
			resultCodeTab.click();
			testCodeTab.click();

			CommonFunctions.waitandClear(testCodeInputTextbox, 30);
			Thread.sleep(2000);

			testCodeInputTextbox.sendKeys(aTestCode);
			Thread.sleep(2000);
			CommonFunctions.waitandClick(testCodeSearchButton, 30);
			// testCodeSearchButton.click();
			/* Add a new test Mnemonic under section */

			CommonFunctions.waitandClick(testMnemonicShowOperationsButton, 30);
			testMnemonicInputTextbox.sendKeys(aTestCodeMnemonic);
			CommonFunctions.waitandClick(addTestCodeAliasButton, 30);

			aTestCodeResult = ObjectHelper.driver.findElements(By.xpath("//td/div[contains(text(),'" + aTestCodeMnemonic + "')]")).size();
			System.out.println("Number of test code mnemoinc for this table found: " + aTestCodeResult);
			if (aTestCodeResult > 0) {
				setTestCode(aTestCode);
			}
			
			return (aTestCodeResult);
		} catch (Exception e) {
			return aTestCodeResult;
		}

	}

	/**
	 * DESCRIPTION: Add result code and add fee code and click search after add,
	 * RETURNS: list if result:
	 */

	public int addResultCode(String aFeeCodeAndDesc, String aFeeCode, boolean isAddOnly) {

		int aResultCodeResult = 0;
		int aFinalResult = 0;
		int aResultCode = 0;
		try {

			spinnersChecking();
			while (!resultCodeAndMappingAddButton.isEnabled()) {
				CommonFunctions.waitandClear(resultCodeInputTextbox, 30);
				aResultCode = utils.CommonFunctions.randInt(10000, 99999);
				// aTestCode = "PLWD5";
				resultCodeInputTextbox.sendKeys(Integer.toString(aResultCode));
				billableCheckBox.click();
			}
			spinnersChecking();
			Thread.sleep(2000);
			resultCodeAndMappingAddButton.click();

			/* search the created result code */
			// Thread.sleep(5000);
			
			testCodeTab.click();
			resultCodeTab.click();
			spinnersChecking();

			CommonFunctions.waitandClear(resultCodeInputTextbox, 30);
			Thread.sleep(2000);
			resultCodeInputTextbox.sendKeys(Integer.toString(aResultCode));
			resultCodeInputTextbox.sendKeys(Keys.ENTER);
			spinnersChecking();

			/* Add a fee code under fee code section */
			/* click the upper add fee code mapping button */

			// CommonFunctions.waitandClick(feeCodeMappingAddButton, 30);
			
			CommonFunctions.waitandClick(feeCodeMappingSelectButton, 30);
			spinnersChecking();

			feeCodeSearchInputTextbox.sendKeys(aFeeCodeAndDesc);
			feeCodeSearchInputTextbox.sendKeys(Keys.ENTER);
			spinnersChecking();

		//	resultCodeUpdateButton.click();

			/* search the newly added result code and fee code */

			CommonFunctions.waitandClear(resultCodeInputTextbox, 30);
			resultCodeInputTextbox.sendKeys(Integer.toString(aResultCode));
			resultCodeInputTextbox.sendKeys(Keys.ENTER);
			
			spinnersChecking();

			aResultCodeResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aFeeCode + "')]")).size();

			if (aResultCodeResult > 0) {
				if (!isAddOnly) {
					aFinalResult = aResultCode;
				} else {
					aFinalResult = aResultCodeResult;
					System.out.println("Number of fee code for this table found: " + aResultCodeResult);
				}
				setResultCode(aResultCode);
			}
			return (aFinalResult);
		} catch (Exception e) {
			return aFinalResult;
		}

	}

	/**
	 * DESCRIPTION: Update result code and add fee code and click search after add,
	 * RETURNS: list if result:
	 */

	public int updateResultCode(String aOldFeeCodeAndDesc, String aOldFeeCode, String aNewFeeCodeAndDesc, String aNewFeeCode, String aResultCode) {

		int newAddResultCode = 0;
		int updateResultCodeResult = 0;
		
		// String resultCode;

		try {
			//newAddResultCode = addResultCode(aOldFeeCodeAndDesc, aOldFeeCode, false);

			// Thread.sleep(5000);
			//testCodeTab.click();
			//resultCodeTab.click();
			spinnersChecking();

			CommonFunctions.waitandClear(resultCodeInputTextbox, 30);
		//	resultCodeInputTextbox.sendKeys(Integer.toString(newAddResultCode));

			Thread.sleep(2000);
			resultCodeInputTextbox.sendKeys(aResultCode);
			// resultCodeInputTextbox.sendKeys(Keys.ENTER);
			spinnersChecking();
			Thread.sleep(4000);
			/* Add a fee code under fee code section */
			/* click the upper add fee code mapping button */

			// CommonFunctions.waitandClick(feeCodeMappingAddButton, 30);

			/* Delete old fee code */
			CommonFunctions.waitandClick(feeCodeDeleteButton, 30);
			spinnersChecking();

	//		utils.CommonFunctions.clickUsingJavaExecutor(feeCodeMappingAddButton);
			utils.CommonFunctions.clickUsingJavaExecutor(feeCodeMappingSelectButton);
			
			feeCodeSearchInputTextbox.sendKeys(aNewFeeCodeAndDesc);
			feeCodeSearchInputTextbox.sendKeys(Keys.ENTER);
			spinnersChecking();

			///resultCodeUpdateButton.click();
			// Thread.sleep(5000);

			testCodeTab.click();
			resultCodeTab.click();
			spinnersChecking();
			/* search the newly added result code and fee code */

			CommonFunctions.waitandClear(resultCodeInputTextbox, 30);
		//	resultCodeInputTextbox.sendKeys(Integer.toString(newAddResultCode));
			resultCodeInputTextbox.sendKeys(aResultCode);
			resultCodeInputTextbox.sendKeys(Keys.ENTER);

			spinnersChecking();
			
			updateResultCodeResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aNewFeeCode + "')]")).size();

			
			System.out.println("Number of fee code for this table found: " + updateResultCodeResult);

			return updateResultCodeResult;

		} catch (Exception e) {
			return updateResultCodeResult;
		}

	}

	/**
	 * DESCRIPTION: update a testcode and click search after update, RETURNS: list
	 * if result:
	 */

	public int updateTestCode(String aTestCode) {

		int aTestCodeResult = 0;
		String aSearchKey = utils.CommonFunctions.getSaltString(3);
		try {
			
			spinnersChecking();
			CommonFunctions.waitandClear(testCodeInputTextbox, 30);
			testCodeInputTextbox.sendKeys(aTestCode);
			
			spinnersChecking();
			Thread.sleep(2000);

			CommonFunctions.waitandClick(testCodeSearchButton, 30);

			/* update a new test Mnemonic under section */
			
			Thread.sleep(3000);
			
			testMnemonicRow.click();
			testMnemonicEditInputTextbox.sendKeys(aSearchKey);
			
			spinnersChecking();
			Thread.sleep(2000);

			CommonFunctions.waitandClick(testMnemonicUpdateButton, 30);
			spinnersChecking();

			aTestCodeResult = ObjectHelper.driver.findElements(By.xpath("//td/div[contains(text(),'" + aSearchKey + "')]")).size();

			System.out.println("Number of test code for this table found: " + aTestCodeResult);

			return (aTestCodeResult);

		} catch (Exception e) {
			return aTestCodeResult;
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
	
	public void setTestCode(String testCode ) {
		this.testCode = testCode;
	}	
	
	public String getTestCode() {
		
		return testCode;
	}

	
	public void setResultCode(int resultCode ) {
		this.resultCode = resultCode;
	}	
	
	public int getResultCode() {
		
		return resultCode;
	}
	
}