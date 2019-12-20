package lldotcom.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class LL_BookAnAppointment extends LoadableComponent<LL_BookAnAppointment> {

	@FindBy(xpath = "//div[text()='Register']")
	public WebElement registerButton;

	WebDriver driver = null;

	public LL_BookAnAppointment(WebDriver driver) {
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

	public boolean register() {
		try {
			CommonFunctions.waitandClick(registerButton, 20);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

}