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

public class LARS_OrderingDoctorPage extends LoadableComponent<LARS_OrderingDoctorPage> {

	@FindBy(id = "doctorWildcardLastNameInput")
	public WebElement lastnameTextbox;

	@FindBy(id = "doctorWildcardFirstNameInput")
	public WebElement firstnameTextbox;

	@FindBy(id = "doctorWildcardGo")
	public WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(),'Provider')]/following::div[1]")
	public WebElement providerId;

	@FindBy(xpath = "//div[@class='doctorDetailTitle col-sm-5 col-md-5 col-lg-5 ng-binding']")
	public List<WebElement> addresses;

	@FindBy(xpath = "//span[text()='Doctor Names']")
	public WebElement doctorNamesTab;

	@FindBy(id = "doctorNameInput")
	public WebElement doctorNameTextbox;

	@FindBy(id = "doctorNameGo")
	public WebElement doctorNameSearchButton;

	@FindBy(xpath = "//span[text()='Provider Number']")
	public WebElement providerNumberTab;

	@FindBy(id = "doctorProviderInput")
	public WebElement providerTextbox;

	@FindBy(id = "doctorProviderGo")
	public WebElement providerSearchButton;

	@FindBy(xpath = "//div[contains(text(),'Doctors')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//th[contains(text(),'Last Name')]")
	public WebElement lastNameColumnTitle;
	
	@FindBy(xpath = "//a[text()='About']")
	public WebElement aboutTitle;
	
	@FindBy(xpath = "//a[@href='#/']")
	public WebElement larsLogo;
	
	
	
	

	WebDriver driver = null;

	public LARS_OrderingDoctorPage(WebDriver driver) {
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

	public boolean searchByLastnameAndVerify(String last) {

		try {
			CommonFunctions.waitandClear(lastnameTextbox, 10);
			lastnameTextbox.sendKeys(last);
			searchButton.click();
			spinnersChecking();
			boolean isFound = CommonFunctions.waitForVisiblity(
					By.xpath("//div[contains(text(),'Payer')]/following::div[contains(text(),'" + last + "')]"), 10);
			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
				larsLogo.click();
			}
			
			//More than 1 record return and stay back to same page
			else if (CommonFunctions.waitForVisiblity(lastNameColumnTitle, 5)) {
					
					int result = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + last + "')]")).size();
					if (result > 0) {
						isFound = true;
						System.out.println("reord found: " + result);
						larsLogo.click();
					}
			}	
			

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByFirstnameAndVerify(String first) {

		try {
			CommonFunctions.waitandClear(firstnameTextbox, 10);
			firstnameTextbox.sendKeys(first);
			searchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(
					By.xpath("//div[contains(text(),'Payer')]/following::div[contains(text(),'" + first + "')]"), 10);

			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
				larsLogo.click();
			}
			
			//More than 1 record return and stay back to same page
			else if (CommonFunctions.waitForVisiblity(lastNameColumnTitle, 5)) {
					
					int result = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + first + "')]")).size();
					if (result > 0) {
						isFound = true;
						System.out.println("reord found: " + result);
						larsLogo.click();
					}
			}	
			
			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByLastAndFirstnameAndVerify(String last, String first) {

		try {
			CommonFunctions.waitandClear(firstnameTextbox, 10);
			lastnameTextbox.sendKeys(last);
			firstnameTextbox.sendKeys(first);
			searchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath(
					"//div[contains(text(),'Payer')]/following::div[contains(text(),'" + last + ", " + first + "')]"),
					10);

			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
				larsLogo.click();
			}
			
			
				

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByLastAndFirstnameAndVerifyProviderNo(String last, String first, String aProviderNo) {

		try {
			CommonFunctions.waitandClear(firstnameTextbox, 10);
			lastnameTextbox.sendKeys(last);
			firstnameTextbox.sendKeys(first);
			searchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath(
					"//div[contains(text(),'Payer')]/following::div[contains(text(),'" + last + ", " + first + "')]"),
					10) && CommonFunctions.waitForVisiblity(By.xpath(
							"//div[contains(text(),'Provider')]/following::div[contains(text(),'" + aProviderNo + "')]"),
							10);
					
					

			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
			}

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean goToDoctorNamesTab() {

		try {
			Thread.sleep(5000);
			doctorNamesTab.click();
			return CommonFunctions.waitForVisiblity(doctorNameSearchButton, 10);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByDoctorNameAndVerify(String doctorName) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(doctorNameTextbox, 10);
			doctorNameTextbox.sendKeys(doctorName);
			doctorNameSearchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(
					By.xpath("//div[contains(text(),'Payer')]/following::div[contains(text(),'" + doctorName + "')]"),
					10);

			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
			}

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToProviderNumberTab() {

		try {
			Thread.sleep(5000);
			spinnersChecking();
			providerNumberTab.click();
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(providerSearchButton, 10);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByProviderNumberAndVerify(String providerNumber) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(providerTextbox, 10);
			providerTextbox.sendKeys(providerNumber);
			providerSearchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath(
					"//div[contains(text(),'Provider')]/following::div[contains(text(),'" + providerNumber + "')]"),
					10);

			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
			}

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean searchByProviderNumberAndDoctorNameVerify(String providerNumber, String doctorName) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(providerTextbox, 10);
			providerTextbox.sendKeys(providerNumber);
			providerSearchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath(
					"//div[contains(text(),'Provider')]/following::div[contains(text(),'" + providerNumber + "')]"),
					10) && CommonFunctions.waitForVisiblity(By.xpath(
							"//div[contains(text(),'Payer')]/following::div[contains(text(),'" + doctorName + "')]"),
							10); 
					

			if (isFound) {
				System.out.println("Provider #: " + providerId.getText());
				System.out.println("Addresses found: " + addresses.size());
			}

			return isFound;

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