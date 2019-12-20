package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveSecurityCookiePage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='removesecurityquestioncookie']//button[contains(text(),'Security')]")
	public static WebElement removebutton;

	@FindBy(xpath = "//div[@id='removesecurityquestioncookie']//a[contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;	
	
	
	public RemoveSecurityCookiePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
