package rmalabs.objects;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class RMA_HCPRegistrationForm extends LoadableComponent<RMA_HCPRegistrationForm> {


		
//Service Now
	
	@FindBy(xpath = "//input[@name='rf_fname']")
	public WebElement firstName;
	
	
	@FindBy(xpath = "//input[@name='rf_lname']")
	public WebElement lastName;
	
	
	@FindBy(xpath = "//input[@name='rf_email']")
	public WebElement yourEmail;
	
	@FindBy(xpath = "//div[@id='s2id_rf_designation']")
	public WebElement hcpDesignationDropDownField;
	
	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement hcpDesignationSearchField;
	
	@FindBy(xpath = "//select[@id='rf_designation']")
	public WebElement hcpDesignationDropDown;
	
	
	@FindBy(xpath = "//input[@name='rf_license_number']")
	public WebElement licenseNumber;
	
	@FindBy(xpath = "//input[@name='rf_license_date']")
	public WebElement licenseDate;
	
	
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_name']")
	public WebElement clinicName;
	
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_address']")
	public WebElement clinicAddress;
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_city']")
	public WebElement clinicCity;

	@FindBy(xpath = "//input[@name='rf_new_clinic_city']")
	public WebElement clinicProvince;
	
	@FindBy(xpath = "//span[@id='select2-chosen-2']")
	public WebElement clinicProvinceDropDownField;
	
	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement clinicProvinceSearchField;
	
	
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_postal_code']")
	public WebElement clinicPostalCode;
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_phone']")
	public WebElement clinicPhoneNumber;
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_website']")
	public WebElement clinicWebsite;
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_fax']")
	public WebElement clinicFaxNumber;
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_email']")
	public WebElement clinicEmail;
	
	@FindBy(xpath = "//input[@name='rf_new_clinic_hours']")
	public WebElement clinicAfterHoursCallNumber;
	
	
	@FindBy(xpath = "//input[@type='radio' and @value='Invoice']")
	public WebElement invoiceRadio;
	
	@FindBy(xpath = "//label[text()[contains(., 'Invoice')]]")
	public WebElement invoiceLabelRadio;
	
	
	@FindBy(xpath = "//div[@id='nd-fields']//h6[text()[contains(., 'Billing Information (Only complete if different from information above):')]]")
	public WebElement billingInformationSectionLabel;
	
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_name']")
	public WebElement billingName;
	
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_address']")
	public WebElement billingAddress;
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_city']")
	public WebElement billingCity;

	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_new_clinic_city']")
	public WebElement billingProvince;
	
	
	@FindBy(xpath = "//div[@id='nd-fields']//span[@id='select2-chosen-4']")
	public WebElement billingProvinceDropDownField;
	
	@FindBy(xpath = "//input[@id='s2id_autogen4_search']")
	public WebElement billingProvinceSearchField;
	
	
	
	
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_postal_code']")
	public WebElement billingPostalCode;
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_phone']")
	public WebElement billingPhoneNumber;
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_fax']")
	public WebElement billingFaxNumber;
	
	@FindBy(xpath = "//div[@id='nd-fields']//input[@name='rf_billing_email']")
	public WebElement billingEmail;
	
	
	
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_name']")
	public WebElement addClinicName;
	
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_address']")
	public WebElement addClinicAddress;
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_city']")
	public WebElement addClinicCity;

	@FindBy(xpath = "//input[@name='rf_new_clinic_city']")
	public WebElement addClinicProvince;
	
	
	@FindBy(xpath = "//span[@id='select2-chosen-3']")
	public WebElement addClinicProvinceDropDownField;
	
	@FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	public WebElement addClinicProvinceSearchField;
	
	
	
	
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_postal_code']")
	public WebElement addClinicPostalCode;
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_phone']")
	public WebElement addClinicPhoneNumber;
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_website']")
	public WebElement addClinicWebsite;
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_fax']")
	public WebElement addClinicFaxNumber;
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_email']")
	public WebElement addClinicEmail;
	
	@FindBy(xpath = "//input[@name='rf_add_clinic_hours']")
	public WebElement addClinicAfterHoursCallNumber;
	
	
	@FindBy(xpath = "//label[text()[contains(., 'Additional')]]")
	public WebElement additionalClinicLocationLabelRadio;
	
	
	@FindBy(xpath = "//div[contains(text(), 'Thank you for your registration')]")
	public WebElement successRegistration;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//input[@name='rf_agree']")
	public WebElement agreement;
	
	@FindBy(xpath = "//input[@name='rf_terms_sign_date']")
	public WebElement date;
	
	
	@FindBy(xpath = "//button[@class='submit-button custom-button-blue custom-button custom-button-lg button-bubble']")
	public WebElement submit;
	
	
	
	
	
		
	
		
	WebDriver driver = null;

	public RMA_HCPRegistrationForm(WebDriver driver) {
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


public boolean submitHCPRegistrationForm(String[] input) {
	
	try {

		Thread.sleep(1000);
		firstName.sendKeys(input[1]);
		lastName.sendKeys(input[2]);
		yourEmail.sendKeys(input[3]);
		//hcpDesignation.sendKeys(input[4]);
		
		hcpDesignationDropDownField.click();
		
//		Select hcp = new Select(driver.findElement(By.name("rf_designation")));
//		hcp.selectByValue(input[4]);
	
		hcpDesignationSearchField.sendKeys(input[4]);
		hcpDesignationSearchField.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
//		CommonFunctions.waitandClick(driver.findElement(
//				By.xpath("//span[contains(text(), '"+ input[4] +"')]")), 20);
		
		
		licenseNumber.sendKeys(input[5]);
		licenseDate.sendKeys(input[6]);
		clinicName.sendKeys(input[7]);
		clinicAddress.sendKeys(input[8]);
		clinicCity.sendKeys(input[9]);
	//	clinicProvince.sendKeys(input[10]);
		
		clinicProvinceDropDownField.click();
		
		
		clinicProvinceSearchField.sendKeys(input[10]);
		clinicProvinceSearchField.sendKeys(Keys.ENTER);
		
		
		clinicPostalCode.sendKeys(input[11]);
		
		clinicPhoneNumber.sendKeys(input[12]);
		clinicWebsite.sendKeys(input[13]);
		clinicFaxNumber.sendKeys(input[14]);
		clinicEmail.sendKeys(input[15]);
		clinicAfterHoursCallNumber.sendKeys(input[16]);
		
//		invoiceLabelRadio.click();
		
		
		agreement.click();
		
		Thread.sleep(1000);
		date.clear();
		date.sendKeys(input[17]);
	
		
//		Thread.sleep(300000);
		submit.click();
		return(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//div[contains(text(), 'Thank you for your registration')]")), 20));
				
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return false;
	}

}


public boolean submitHCPRegistrationFormWithBillingInformation(String[] input) {
	
	try {

		Thread.sleep(1000);
		firstName.sendKeys(input[1]);
		lastName.sendKeys(input[2]);
		yourEmail.sendKeys(input[3]);
		//hcpDesignation.sendKeys(input[4]);
		
		hcpDesignationDropDownField.click();
		
//		Select hcp = new Select(driver.findElement(By.name("rf_designation")));
//		hcp.selectByValue(input[4]);
	
		hcpDesignationSearchField.sendKeys(input[4]);
		hcpDesignationSearchField.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
//		CommonFunctions.waitandClick(driver.findElement(
//				By.xpath("//span[contains(text(), '"+ input[4] +"')]")), 20);
		
		
		licenseNumber.sendKeys(input[5]);
		licenseDate.sendKeys(input[6]);
		clinicName.sendKeys(input[7]);
		clinicAddress.sendKeys(input[8]);
		clinicCity.sendKeys(input[9]);
	//	clinicProvince.sendKeys(input[10]);
		clinicProvinceDropDownField.click();
		
		
		clinicProvinceSearchField.sendKeys(input[10]);
		clinicProvinceSearchField.sendKeys(Keys.ENTER);
		
		
		
		clinicPostalCode.sendKeys(input[11]);
		
		clinicPhoneNumber.sendKeys(input[12]);
		clinicWebsite.sendKeys(input[13]);
		clinicFaxNumber.sendKeys(input[14]);
		clinicEmail.sendKeys(input[15]);
		clinicAfterHoursCallNumber.sendKeys(input[16]);
		Thread.sleep(1000);
		
//		invoiceLabelRadio.click();
		
//billing information start
		
		
		if (CommonFunctions.waitForVisiblity(billingInformationSectionLabel, 60)) {	
		
			billingName.sendKeys(input[18]);
			billingAddress.sendKeys(input[19]);
			billingCity.sendKeys(input[20]);
		//	clinicProvince.sendKeys(input[21]);
			
			billingProvinceDropDownField.click();
			
		
			billingProvinceSearchField.sendKeys(input[21]);
			billingProvinceSearchField.sendKeys(Keys.ENTER);
			
			
			billingPostalCode.sendKeys(input[22]);
			
			billingPhoneNumber.sendKeys(input[23]);
			billingFaxNumber.sendKeys(input[24]);
			billingEmail.sendKeys(input[25]);
		}	
		
//billing information end	
		
//additional clinic information
		
		
		agreement.click();
		
		Thread.sleep(1000);
		date.clear();
		date.sendKeys(input[17]);
	
		
		Thread.sleep(300000);
		submit.click();
		return(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//div[contains(text(), 'Thank you for your registration')]")), 20));
		
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return false;
	}

}


public boolean submitHCPRegistrationFormWithBillingInformationAndAdditionalClinicInfo(String[] input) {
	
	try {

		Thread.sleep(1000);
		firstName.sendKeys(input[1]);
		lastName.sendKeys(input[2]);
		yourEmail.sendKeys(input[3]);
		//hcpDesignation.sendKeys(input[4]);
		
		hcpDesignationDropDownField.click();
		
//		Select hcp = new Select(driver.findElement(By.name("rf_designation")));
//		hcp.selectByValue(input[4]);
	
		hcpDesignationSearchField.sendKeys(input[4]);
		hcpDesignationSearchField.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
//		CommonFunctions.waitandClick(driver.findElement(
//				By.xpath("//span[contains(text(), '"+ input[4] +"')]")), 20);
		
		
		licenseNumber.sendKeys(input[5]);
		licenseDate.sendKeys(input[6]);
		
//additional clinic location		
		additionalClinicLocationLabelRadio.click();
//additional clinic location		
		
		clinicName.sendKeys(input[7]);
		clinicAddress.sendKeys(input[8]);
		clinicCity.sendKeys(input[9]);
	//	clinicProvince.sendKeys(input[10]);
		clinicProvinceDropDownField.click();
		
		
		clinicProvinceSearchField.sendKeys(input[10]);
		clinicProvinceSearchField.sendKeys(Keys.ENTER);
		
		clinicPostalCode.sendKeys(input[11]);
		
		clinicPhoneNumber.sendKeys(input[12]);
		clinicWebsite.sendKeys(input[13]);
		clinicFaxNumber.sendKeys(input[14]);
		clinicEmail.sendKeys(input[15]);
		clinicAfterHoursCallNumber.sendKeys(input[16]);

//additional clinic information
/*		
		addClinicName.sendKeys(input[26]);
		addClinicAddress.sendKeys(input[27]);
		addClinicCity.sendKeys(input[28]);
	//	addClinicProvince.sendKeys(input[29]);
		
		addClinicProvinceDropDownField.click();
		
		
		addClinicProvinceSearchField.sendKeys(input[29]);
		addClinicProvinceSearchField.sendKeys(Keys.ENTER);
		
		
		
		addClinicPostalCode.sendKeys(input[30]);
		
		addClinicPhoneNumber.sendKeys(input[31]);
		addClinicWebsite.sendKeys(input[32]);
		addClinicFaxNumber.sendKeys(input[33]);
		addClinicEmail.sendKeys(input[34]);
		addClinicAfterHoursCallNumber.sendKeys(input[35]);
*/		
//additonal clinic information end		
		
	//	invoiceLabelRadio.click();
		
//billing information start
		
		billingName.sendKeys(input[18]);
		billingAddress.sendKeys(input[19]);
		billingCity.sendKeys(input[20]);
	//	clinicProvince.sendKeys(input[21]);
		
		billingProvinceDropDownField.click();
		
	
		billingProvinceSearchField.sendKeys(input[21]);
		billingProvinceSearchField.sendKeys(Keys.ENTER);
		
		
		billingPostalCode.sendKeys(input[22]);
		
		billingPhoneNumber.sendKeys(input[23]);
		billingFaxNumber.sendKeys(input[24]);
		billingEmail.sendKeys(input[25]);
		
//billing information end		
		
	
		
		
		
		
		agreement.click();
		
		Thread.sleep(1000);
		date.clear();
		date.sendKeys(input[17]);
	
		
		Thread.sleep(300000);
	//	submit.click();
	//	submit.click();
		return(CommonFunctions.waitForVisiblity(driver.findElement(By.xpath("//div[contains(text(), 'Thank you for your registration')]")), 20));
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return false;
	}

}




}








	


	
