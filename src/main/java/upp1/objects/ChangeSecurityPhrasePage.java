package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class ChangeSecurityPhrasePage {
	WebDriver driver;

	public static String secruityphrasetitlepath = "//h3[contains(.,'Change Security Phrase')]";

	public static String securityphrasetaxtboxpath = "//input[@name='securityPhrase']";
	public static String savebuttonpath = "//form[@name='changeSecurityPhraseForm']//button[@type='submit' and text()='SAVE']";
	public static String cancelbuttonpath = "//form[@name='changeSecurityPhraseForm']//a[text()='CANCEL']";

	public static String popupokbuttonpath = "//button[text()='OK']";
	public static String securitysuccespath = "//p[text()='Your security phrase has been changed successfully.']";

	@FindBy(xpath = "//h3[text()='Change Security Phrase ']")
	public static WebElement secruityphrasetitle;

	@FindBy(xpath = "//input[@name='securityPhrase']")
	public static WebElement securityphrasetaxtbox;

	@FindBy(xpath = "//form[@name='changeSecurityPhraseForm']//button[@type='submit' and text()='SAVE']")
	public static WebElement savebutton;

	@FindBy(xpath = "//form[@name='changeSecurityPhraseForm']//a[contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement popupokbutton;

	public ChangeSecurityPhrasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void entersecurityphrase(String securityphrase) throws Exception {
		Thread.sleep(2000);

		securityphrasetaxtbox.clear();
		securityphrasetaxtbox.sendKeys(securityphrase);

		CommonFunctions.clickUsingJavaExecutor(savebutton);

		CommonFunctions.clickonmodalpopup(popupokbutton);
	}
}
