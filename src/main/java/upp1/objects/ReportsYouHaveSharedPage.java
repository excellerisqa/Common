package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsYouHaveSharedPage {
	WebDriver driver;

	public static String sharingmyreportstitlepath = "//h3[text()='Sharing My Reports with: ']";
	public static String sharingmyreportstablerowpath = "//tr[@ng-repeat='pat in SharedReports.data']";

	@FindBy(xpath = "//h3[text()='Sharing My Reports with: ']")
	public static WebElement sharingmyreportstitle;

	@FindBy(xpath = "//tr[@ng-repeat='pat in SharedReports.data']")
	public static WebElement sharingmyreportstablerow;

	public ReportsYouHaveSharedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
