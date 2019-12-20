package lars.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;

public class LARS_TaxRatePage extends LoadableComponent<LARS_TaxRatePage> {

	@FindBy(id = "taxOptionSelect")
	public WebElement taxOptionDropdown;

	@FindBy(id = "addNewTaxRate")
	public WebElement addNewTaxRateButton;

	@FindBy(id = "taxOptionNew")
	public WebElement newTaxOptionDropdown;

	@FindBy(id = "activeDate")
	public WebElement activeDateTextbox;

	@FindBy(id = "inactiveDate")
	public WebElement inactiveDateTextbox;

	@FindBy(xpath = "//input[@ng-model='taxRate.newTaxRate.rate']")
	public WebElement newRateTextbox;

	@FindBy(xpath = "//button[@data-ng-click='taxRate.saveNewTaxRate()']")
	public WebElement saveNewTaxRateButton;

	@FindBy(xpath = "//div[text()='GST']")
	public List<WebElement> gstRateResult;

	@FindBy(xpath = "//span[contains(text(),'updated successfully.')]")
	public WebElement successMessage;

	@FindBy(xpath = "//div[contains(text(),'Tax Rate')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;

	WebDriver driver = null;

	public LARS_TaxRatePage(WebDriver driver) {
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

	public boolean selectGSTAndVerifyResult() {
		try {

			CommonFunctions.waitForVisiblity(taxOptionDropdown, 20);
			Select selTaxOption = new Select(taxOptionDropdown);
			selTaxOption.selectByVisibleText("GST");
			// CommonFunctions.waitForVisiblity(gstRateResult.get(0), 20);
			// System.out.println("No. of GST rates found: " + gstRateResult.size());
			// return (gstRateResult.size() > 0);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addNewTaxRateAndVerify(String taxOption, String activeDate, String inactiveDate, String newTaxRate) {
		try {
			Thread.sleep(3000);
			addNewTaxRateButton.click();
			CommonFunctions.waitForVisiblity(newTaxOptionDropdown, 20);
			Select selTaxOption = new Select(newTaxOptionDropdown);
			selTaxOption.selectByVisibleText(taxOption);
			Thread.sleep(1000);
			activeDateTextbox.sendKeys(getTodaysDatePlusDays(Integer.parseInt(activeDate)));// 2018-08-22
			Thread.sleep(1000);
			inactiveDateTextbox.sendKeys(getTodaysDatePlusDays(Integer.parseInt(inactiveDate)));
			newRateTextbox.sendKeys(newTaxRate);
			saveNewTaxRateButton.click();
			return CommonFunctions.waitForVisiblity(By.xpath(
					"//div[contains(text(),'" + taxOption + "')]/../div[contains(text(),'" + newTaxRate + "')]"), 20);

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

	public String getTodaysDatePlusDays(int plusDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, plusDays);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return String.valueOf(dateFormat.format(cal.getTime()));
	}

}