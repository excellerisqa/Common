package bclis.objects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class BCLIS_LarsCheckoutPage extends LoadableComponent<BCLIS_LarsCheckoutPage> {

	@FindBy(xpath = "//button[contains(text(),'Check Out')]")
	public WebElement checkoutButton;

	@FindBy(xpath = "//span[@class = 'ng-binding ng-scope']")
	public WebElement checkoutMessage;

	@FindBy(xpath = "//a[@class='btn btn-secondary checkoutBtn ng-binding']")
	public WebElement printInvoiceButton;

	@FindBy(xpath = "//div[@class='col-sm-1 col-md-1 col-lg-1']/following-sibling::div")
	public List<WebElement> userDetails;

	WebDriver driver = null;

	public BCLIS_LarsCheckoutPage(WebDriver driver) {
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
	 * DESCRIPTION: clicks checkout button on the LARS page PARAMETERS: none prefix
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean checkout() throws Exception {

		try {
			CommonFunctions.waitandClick(checkoutButton, 20);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean printInvoice() throws Exception {

		try {
			CommonFunctions.waitandClick(printInvoiceButton, 20);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String getCheckoutMessage() throws Exception {
		try {
			if (CommonFunctions.waitForVisiblity(checkoutMessage, 20))
				return checkoutMessage.getText();
			else
				return "no message";

		} catch (Exception e) {
			return "no message";
		}

	}

	public boolean verifyUserDetails(String name) {
		// TO DO

		try {
			if (userDetails.get(3).getText().equals(name)) {
				if (userDetails.get(4).getText().contains("$") && userDetails.get(4).getText().length() > 1) {
					System.out.println("User name found and fee displayed: " + userDetails.get(4).getText());
					return true;
				} else
					return false;
			} else
				return false;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

}
