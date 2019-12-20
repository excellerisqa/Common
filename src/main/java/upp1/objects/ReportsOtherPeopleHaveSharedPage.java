package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsOtherPeopleHaveSharedPage {
	WebDriver driver;

	public static String peoplesharingtheirreportswithmepath = "//h3[text()='People sharing their reports with me: ']";

	@FindBy(xpath = "//h3[text()='People sharing their reports with me: ']")
	public static WebElement peoplesharingtheirreportswithme;

	public ReportsOtherPeopleHaveSharedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
