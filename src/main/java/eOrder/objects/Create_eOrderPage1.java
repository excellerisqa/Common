package eOrder.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_eOrderPage1 {
	public WebDriver driver;

	// Create eOrder form Page 1 elements
	@FindBy(xpath = "//app-input[@placeholder='Health Number']//input")
	WebElement HealthNumber;

	@FindBy(xpath = "//app-input[@placeholder='Last Name']//input")
	public static WebElement LastName;

	@FindBy(xpath = "//app-input[@placeholder='First name']//input")
	WebElement FirstName;

	@FindBy(xpath = "//app-input[@placeholder='Middle name']//input")
	WebElement MiddleName;

	@FindBy(xpath = "//app-input[@placeholder='Primary phone']//input")
	WebElement PhoneNumber;

	@FindBy(xpath = "//app-date[@placeholder='Date of birth']//input")
	WebElement DOB;

	@FindBy(xpath = "//app-input[@placeholder='Address Line 1']//input")
	WebElement AddressLine1;

	@FindBy(xpath = "//app-input[@placeholder='Address Line 2']//input")
	WebElement AddressLine2;

	@FindBy(xpath = "//app-input[@formcontrolname='postalCode']//input")
	WebElement postalCode;

	@FindBy(xpath = "//app-input[@placeholder='City']//input")
	WebElement City;

	@FindBy(xpath = "//app-input[@placeholder='Primary phone']//input")
	WebElement primaryPhone;

	@FindBy(xpath = "//app-dropdown[@formcontrolname='province']//i")
	WebElement province1;

	@FindBy(xpath = "//app-dropdown[@formcontrolname='country']//i")
	WebElement Country;

	@FindBy(xpath = "(//button[@class='select-button'])[3]")
	WebElement CountryValue;

	@FindBy(xpath = "(//button[@class='select-button'])[4]")
	WebElement ProvinceValue;

	@FindBy(xpath = "//app-dropdown[@formcontrolname='addressProvince']//i")
	WebElement province2;

	@FindBy(xpath = "//app-dropdown[@placeholder='Gender']//i")
	WebElement Gender;

	// other options in the page
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement CancelBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement NextBtn;

	// common error message for invalid value
	@FindBy(xpath = "//div[@class='error error-spacing']//strong")
	WebElement ErrorMessage;

	public String getText(String element) {
		element.toLowerCase();
		switch (element) {
		case "healthnumber":
			return HealthNumber.getAttribute("value");
		case "lastname":
			return LastName.getAttribute("value");
		case "firstname":
			return FirstName.getAttribute("value");
		case "middlename":
			return MiddleName.getAttribute("value");
		case "phonenumber":
			return PhoneNumber.getAttribute("value");
		case "dob":
			return DOB.getAttribute("value");
		case "addressline1":
			return AddressLine1.getAttribute("value");
		case "postalcode":
			return postalCode.getAttribute("value");
		case "country":
			return CountryValue.getAttribute("title");
		case "city":
			return City.getAttribute("value");
		case "province":
			return ProvinceValue.getAttribute("title");
		case "errormessage":
			return ErrorMessage.getText().replace("\\s+", " ");
		}
		return null;
	}

	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "healthnumber":
			HealthNumber.sendKeys(text);
			break;
		case "lastname":
			LastName.sendKeys(text);
			break;
		case "firstname":
			FirstName.sendKeys(text);
			break;
		case "middlename":
			MiddleName.sendKeys(text);
			break;
		case "phonenumber":
			PhoneNumber.sendKeys(text);
			break;
		case "dob":
			DOB.sendKeys(text);
			break;
		case "postalcode":
			postalCode.sendKeys(text);
			break;
		case "addressline1":
			AddressLine1.sendKeys(text);
			break;
		case "addressline2":
			AddressLine2.sendKeys(text);
			break;
		case "primaryphone":
			primaryPhone.sendKeys(text);
			break;
		case "city":
			City.sendKeys(text);
			break;
		}
	}

	public void enterKey(String element, Keys key) {
		element.toLowerCase();
		switch (element) {
		case "lastname":
			LastName.sendKeys(key);
			break;
		case "firstname":
			FirstName.sendKeys(key);
			break;
		}
	}

	public void click(String element) {
		element.toLowerCase();
		switch (element) {
		case "healthnumber":
			HealthNumber.click();
			break;
		case "lastname":
			LastName.click();
			break;
		case "firstname":
			FirstName.click();
			break;
		case "middlename":
			MiddleName.click();
			break;
		case "phonenumber":
			PhoneNumber.click();
			break;
		case "addressline2":
			AddressLine2.click();
			break;
		case "province1":
			province1.click();
			break;
		case "province2":
			province1.click();
			break;
		case "gender":
			Gender.click();
			break;
		case "country":
			Country.click();
			break;
		case "cancel":
			CancelBtn.click();
			break;
		case "next":
			NextBtn.click();
			break;
		}
	}

	public void clear(String element) {
		element.toLowerCase();
		switch (element) {
		case "addressline2":
			AddressLine2.clear();
			break;
		case "postalcode":
			postalCode.clear();
			break;
		}
	}

	public void selectProvince1(String provinceName1) {
		province1.click();
		List<WebElement> provinces = driver.findElements(By.xpath("//app-dropdown[@formcontrolname='province']//a"));
		for (WebElement province : provinces) {
			if ((province.getText()).equalsIgnoreCase(provinceName1)) {
				province.click();
			}
		}
	}

	public void selectProvince2(String provinceName2) {
		province2.click();
		List<WebElement> provinces2 = driver.findElements(By.xpath("//app-dropdown[@formcontrolname='addressProvince']//a"));
		for (WebElement province2 : provinces2) {
			if ((province2.getText()).equalsIgnoreCase(provinceName2)) {
				province2.click();
			}
		}
	}

	public void selectGender(String genderType) {
		Gender.click();
		List<WebElement> genders = driver.findElements(By.xpath("//app-dropdown[@placeholder='Gender']//a"));
		for (WebElement gender : genders) {
			if ((gender.getText()).equalsIgnoreCase(genderType)) {
				gender.click();
			}
		}
	}

	public void selectCountry(String countryName) {
		Country.click();
		List<WebElement> countries = driver.findElements(By.xpath("//app-dropdown[@formcontrolname='country']//a"));
		for (WebElement country : countries) {
			if ((country.getText()).equalsIgnoreCase(countryName)) {
				country.click();
			}
		}
	}

	public Create_eOrderPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
