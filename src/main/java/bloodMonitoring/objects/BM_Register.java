package bloodMonitoring.objects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BM_Register {
	public WebDriver driver;

	@FindBy(id = "ProgramID")
	public static WebElement lemtradaId;
	@FindBy(id = "AgreementSigned")
	public static WebElement AgreementSigned;
	@FindBy(id = "Phone")
	public static WebElement Phonenumber;
	@FindBy(id = "Mobile")
	public static WebElement mobileNumber;
	@FindBy(id = "Email")
	public static WebElement email;
	@FindBy(id = "Address_Address1")
	public static WebElement address1;
	@FindBy(id = "Address_City")
	public static WebElement city;
	@FindBy(id = "Address_StateOrProvinceCode")
	public static WebElement province;
	@FindBy(id = "Address_ZipOrPostalCode")
	public static WebElement postalCode;
	@FindBy(id = "EmergencyContactLastName")
	public static WebElement emergencyLastName;
	@FindBy(id = "EmergencyContactFirstName")
	public static WebElement emergencyFirstName;
	@FindBy(id = "EmergencyContactRelation")
	public static WebElement emergencyContactRelation;
	@FindBy(id = "EmergencyContactPhone")
	public static WebElement emergencyContactPhone;
	@FindBy(id = "EmergencyContactEmail")
	public static WebElement emergencyContactEmail;

	@FindBy(id = "EmergencyContactAddress_Address1")
	public static WebElement emergencyaddress1;
	@FindBy(id = "EmergencyContactAddress_City")
	public static WebElement emergencycity;
	@FindBy(id = "EmergencyContactAddress_StateOrProvinceCode")
	public static WebElement emergencyprovince;
	@FindBy(id = "EmergencyContactAddress_ZipOrPostalCode")
	public static WebElement emergencypostalCode;
	@FindBy(id = "FirstName")
	public static WebElement firstName;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement close;

	@FindBy(xpath = "//*[@id='mainForm']/div[1]/div[3]/div/div[2]/span/input")
	public static WebElement registerButton;

	public final static Logger logger = Logger.getLogger("Delegation");

	public BM_Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void patientregister() throws Exception {
		Thread.sleep(3000);
		ObjectHelper.driver.switchTo().frame("ifSearchResults");
		Thread.sleep(3000);
		ObjectHelper.driver.findElement(BM_HomePage.patientFoundName).click();
		Thread.sleep(3000);
		ObjectHelper.driver.switchTo().defaultContent();
		ObjectHelper.driver.switchTo().frame("ifRecords");
		BM_HomePage.bloodMonitoringProgram.click();
		Thread.sleep(5000);
		CommonFunctions.waitForVisiblity(By.id("ProgramID"), 15);
		BM_Register.lemtradaId.click();
		BM_Register.lemtradaId.sendKeys("LEM");
		BM_Register.AgreementSigned.click();
		BM_Register.Phonenumber.sendKeys("9876543210");
		BM_Register.mobileNumber.sendKeys("9999988888");
		BM_Register.email.sendKeys("bm@hotmail.com");
		BM_Register.address1.sendKeys("123 mississauga rd");
		BM_Register.city.sendKeys("mississauga");
		BM_Register.province.sendKeys("ON");
		BM_Register.postalCode.sendKeys("M3J5V7");

		BM_Register.emergencyLastName.sendKeys("rao2");
		BM_Register.emergencyFirstName.sendKeys("roni");
		BM_Register.emergencyContactRelation.sendKeys("Friend");
		BM_Register.emergencyContactPhone.sendKeys("9876522222");
		BM_Register.emergencyContactEmail.sendKeys("bm@hotmail.com");
		BM_Register.emergencyaddress1.sendKeys("123 mississauga rd");
		BM_Register.emergencycity.sendKeys("mississauga");
		BM_Register.emergencyprovince.sendKeys("ON");
		BM_Register.emergencypostalCode.sendKeys("M3J5V7");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(3000);
		BM_Register.lemtradaId.click();
		Thread.sleep(3000);
		BM_Register.registerButton.click();
		Thread.sleep(5000);
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[1]/div/div/div[3]/button"), 30);
		BM_Register.close.click();
		Thread.sleep(5000);

	}

}
