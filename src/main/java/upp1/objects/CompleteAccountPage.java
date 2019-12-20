package upp1.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class CompleteAccountPage {
	WebDriver driver;

	public static String step1Titlepath = "//span[contains(text(),'Complete Account Profile')]";
	public static String step1LanguageComboBoxPath = "//div[@id='accountprofile']/div/form/div[1]/div/div[1]/div/div/div/div[1]";
	public static String step1LanguageComboListPath = "//select[@name='language']//option"; // List
	public static String step1StreetAddressTextBoxPath = "//input[@name='address1']";
	public static String step1CityTextBoxPath = "//input[@name='city']";
	public static String step1PostalCodeTextBoxPath = "//input[@name='zipOrPostalCode']";
	public static String step1ProvinceComboBoxPath = "//select[@id='provSelect']";
	public static String step1ProvinceComboListPath = "//select[@id='provSelect']//option"; // List
	public static String step1PhoneNumberTextBoxPath = "//input[@name='phoneNumber']";
	public static String step1YearCombobBoxPath = "//button[@title='Year']";
	public static String step1YearSelectionPath = "//span[text()='2017']"; // change year
	public static String step1MonthComboBoxPath = "//button[@title='Month']";
	public static String step1MonthSelectionPath = "//span[text()='March']"; // change month
	public static String step1DayComboBoxPath = "//button[@title='Day']";
	public static String step1DaySelectionPath = "//span[text()='28']";// change date
	public static String step1NextButtonPath = "//div[@id='accountprofile']//button[contains(text(),'NEXT')]";
	public static String step1CancelButtonPath = "//div[@id='accountprofile']//a[contains(text(),'CANCEL')]";
	public static String step1SideLabelPath = "//a[@title='Account Profile']";
	public static String step1AccountIdLabelPath = "//b[text()='Account ID']//following-sibling::span";
	public static String step1ProfileNameLabelPath = "//b[text()='Complete Profile']//following-sibling::span";
	public static String step1WarningmessageCountListPath = "//div[text()='This is a required field']";

	public static String step3YesRadioButtonPath = "//strong[contains(.,'lab or health care visit now ')]//preceding-sibling::div//span";
	public static String step3NoRadioButtonPath = "//strong[contains(.,'register another time')]//preceding-sibling::div//span";
	public static String step3YesLabRadioButtonPath = "//strong[text()='Yes, I have a Lab Visit Number.']";
	public static String step3NoLabRadioButtonPath = "//strong[contains(.,'No, I do not have a Lab Visit Number.')]";
	public static String popupOkButtonPath = "//button[text()='OK']";
	public static String step3NextButtonPath = "//div[@id='labvisit']//button[contains(.,'NEXT')]";
	public static String step3SideLabelPath = "//a[@title='Register Lab Visit']";

	public static String popupOKActionButtonPath = "//button[@class='btn btn-primary btnPHover ng-scope'  and @ng-click='ok()']"; // need to check
	public static String popupCancelButtonPath = "//button[@class='btn btn-default mleft-10 pad-lr-15 btnSmall-xs ng-scope'  and @ng-click='cancel()']";

	@FindBy(xpath = "//span[contains(text(),'Complete Account Profile')]")
	public static WebElement step1Title;

	@FindBy(xpath = "//div[@id='accountprofile']/div/form/div[1]/div/div[1]/div/div/div/div[1]")
	public static WebElement step1LanguageComboListBox;

	@FindBy(xpath = "//select[@name='language']//option")
	public static List<WebElement> step1LanguageComboList;

	@FindBy(xpath = "//input[@name='address1']")
	public static WebElement step1StreetAddressTextBox;

	@FindBy(xpath = "//input[@name='city']")
	public static WebElement step1CityTextBox;

	@FindBy(xpath = "//input[@name='zipOrPostalCode']")
	public static WebElement step1PostalCodeTextBox;

	@FindBy(xpath = "//select[@id='provSelect']")
	public static WebElement step1ProvinceComboBox;

	@FindBy(xpath = "//select[@id='provSelect']//option")
	public static List<WebElement> step1ProvinceComboList;

	@FindBy(xpath = "//input[@name='phoneNumber']")
	public static WebElement step1PhoneNumberTextBox;

	@FindBy(xpath = "//button[@title='Year']")
	public static WebElement step1YearCombobBox;

	@FindBy(xpath = "//button[@title='Month']")
	public static WebElement step1MonthComboBox;

	@FindBy(xpath = "//button[@title='Day']")
	public static WebElement step1DayComboBox;

	@FindBy(xpath = "//div[@id='accountprofile']//button[contains(.,'NEXT')]")
	public static WebElement step1NextButton;

	@FindBy(xpath = "//div[@id='accountprofile']//a[contains(.,'CANCEL')]")
	public static WebElement step1CancelButton;

	@FindBy(xpath = "//a[@title='Account Profile']")
	public static WebElement step1SideLabel;

	@FindBy(xpath = "//strong[contains(.,'lab or health care visit now ')]//preceding-sibling::div//span")
	public static WebElement step3YesRadioButton;

	@FindBy(xpath = "//strong[contains(.,'register another time')]//preceding-sibling::div//span")
	public static WebElement step3NoRadioButton;

	@FindBy(xpath = "//div[@id='labvisit']//button[contains(.,'NEXT')]")
	public static WebElement step3NextButton;

	@FindBy(xpath = "//a[@title='Register Lab Visit']")
	public static WebElement step3SideLabel;

	@FindBy(xpath = "//strong[text()='Yes, I have a Lab Visit Number.']")
	public static WebElement step3YesLabRadioButton;

	@FindBy(xpath = "//strong[contains(.,'No, I do not have a Lab Visit Number.')]")
	public static WebElement step3NoLabRadioButton;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement popupOkButton;

	@FindBy(xpath = "//b[text()='Account ID']//following-sibling::span")
	public static WebElement step1AccountIdLabel;

	@FindBy(xpath = "//b[text()='Complete Profile']//following-sibling::span")
	public static WebElement step1ProfileNameLabel;

	@FindBy(xpath = "//div[text()='This is a required field']")
	public static List<WebElement> step1WarningmessageCountList;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope'  and @ng-click='ok()']")
	public static WebElement popupOKButton;

	@FindBy(xpath = "//button[@class='btn btn-default mleft-10 pad-lr-15 btnSmall-xs ng-scope'  and @ng-click='cancel()']")
	public static WebElement popupCancelButton;

	public CompleteAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean step1fill(String language, String street, String city, String postalcode, String province, String phonenumber, String year, String month, String day) throws Exception {
		boolean response = false;
		step1StreetAddressTextBox.clear();
		step1CityTextBox.clear();
		step1PostalCodeTextBox.clear();
		step1PhoneNumberTextBox.clear();

		CommonFunctions.clickUsingJavaExecutor(step1LanguageComboListBox);
		if (step1LanguageComboList != null && step1LanguageComboList.size() > 0) {
			loop: for (int i = 0; i < step1LanguageComboList.size(); i++) {
				if (step1LanguageComboList.get(i).getText().contains(language)) {
					CommonFunctions.clickUsingJavaExecutor(step1LanguageComboList.get(i));
					break loop;
				}
			}
		}

		step1StreetAddressTextBox.sendKeys(street);
		step1CityTextBox.sendKeys(city);
		step1PostalCodeTextBox.sendKeys(postalcode);
		step1PhoneNumberTextBox.sendKeys(phonenumber);

		Select prov = new Select(step1ProvinceComboBox);
		prov.selectByVisibleText(province);

		CommonFunctions.clickUsingJavaExecutor(step1YearCombobBox);
		CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[text()='" + year + "']")));

		CommonFunctions.clickUsingJavaExecutor(step1MonthComboBox);
		CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[text()='" + month + "']")));

		CommonFunctions.clickUsingJavaExecutor(step1DayComboBox);
		CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[text()='" + day + "']")));

		response = true;

		return response;
	}
}
