package lldotcom.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class LL_HomePage extends LoadableComponent<LL_HomePage> {

	@FindBy(xpath = "//a[@class='button button-blue button-md']")
	public List<WebElement> TopBlueButtons;

	WebDriver driver = null;

	public LL_HomePage(WebDriver driver) {
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

	public boolean bookAnAppointment() {
		try {
			CommonFunctions.waitandClick(TopBlueButtons.get(1), 20);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

}