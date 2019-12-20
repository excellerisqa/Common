package bclis.objects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BCLIS_LoginPage extends LoadableComponent<BCLIS_LoginPage> {

	@FindBy(id = "username")
	public WebElement usernameTextbox;

	@FindBy(id = "password")
	public WebElement passwordTextbox;

	@FindBy(id = "psc_mls")
	public WebElement pscMlsPrefiDropdown;

	@FindBy(id = "submitButton")
	public WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert')]")
	public WebElement alertMessage;

	@FindBy(xpath = "//span[@class='k-icon k-i-arrow-s']")
	public WebElement prefixArrow;

	WebDriver driver = null;

	public BCLIS_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getTitle().equalsIgnoreCase("LifeLabs"));
		assertTrue(driver.getCurrentUrl().contains("/ID/identity/login?signin="));
	}

	@Override
	protected void load() {
	}

	/**
	 * DESCRIPTION: logs in to the BCLIS website PARAMETERS: username, password,
	 * prefix RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */

	public boolean login(String uname, String pwd, String prefix, BCLIS_MainMenuPage mainMenuPage) {

		try {
			// if not logged in then login
			// if on login page
			if (ObjectHelper.driver.getCurrentUrl().contains("login")) {
				CommonFunctions.waitandClear(usernameTextbox, 30);
				usernameTextbox.sendKeys(uname);

				passwordTextbox.clear();
				passwordTextbox.sendKeys(pwd);

				CommonFunctions.waitandClick(prefixArrow, 20);

				Thread.sleep(2000);

				CommonFunctions.waitandClick(driver.findElement(
						By.xpath("//ul[@id='psc_mls_listbox']/li[contains(text(),'" + prefix + "')]")), 20);

				Thread.sleep(2000);
				CommonFunctions.waitandClick(loginButton, 30);
			}

			return CommonFunctions.waitForVisiblity(mainMenuPage.historicalAccessionsIcon, 20);

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: returns alert message from login page PARAMETERS: RETURNS: alert
	 * message from login page AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public String getAlertMessage() throws Exception {
		try {
			CommonFunctions.waitForVisiblity(alertMessage, 30);
			return alertMessage.getText();
		} catch (Exception e) {
			return "no message";
		}
	}

}
