package bclis.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class BCLIS_StandingOrdersPage extends LoadableComponent<BCLIS_StandingOrdersPage> {

	@FindBy(xpath = "//a[@ng-click='viewModel.goToOrder(1)']")
	public WebElement Order;

	WebDriver driver = null;

	public BCLIS_StandingOrdersPage(WebDriver driver) {
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

	/**
	 * DESCRIPTION: clicks on A of the first standing order PARAMETERS: none
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */

	public boolean goToFirstOrder(BCLIS_NewAccessionPage newAccessionPage) throws Exception {
		try {
			CommonFunctions.waitandClick(Order, 20);
			// wait and check for New Accession page
			return CommonFunctions.waitForVisiblity(newAccessionPage.enterTestButton, 20);
		} catch (Exception e) {
			return false;
		}

		// new Actions(driver).moveToElement(Order).build().perform();
		//
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.attributeContains(Order, "class",
		// "k-state-hover"));
		// Order.click();

	}
}