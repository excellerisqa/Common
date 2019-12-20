package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class MenuPage {
	WebDriver driver;

	public static String supportmenuitempath = "//a[@href='/#/Support' and text()='Support']";
	public static String dashboardmenupath = "//div[@class='header-tab']//span[@class='ng-scope' and text()='Dashboard']";
	public static String poweroffbuttonpath = "//i[@class='icon icon-exc-logout']";
	public static String okpopupbuttonpath = "//button[@class='btn btn-primary btnPHover ng-scope']";
	public static String cancelpopupbuttonpath = "//button[@class='btn btn-default mleft-10 pad-lr-15 btnSmall-xs ng-scope']";
	public static String supportpath = "//div[@class='collapse navbar-collapse']//span[text()='Support']";
	public static String myaccountlinkpath = "//span[@class='ng-binding' and text()='My Account']";
	public static String accountsettingslinkpath = "//*[@id=\"navbar-collapse-1\"]/ul/li[1]/ul/li[3]/ul/li[1]/a";
	public static String logoutpath = "//i[@class='icon icon-exc-logout']";
	public static String FAQpath = "//a[@class='ng-binding' and text()='FAQ']";
	public static String failedtoloadhistorypopuppath = "//p[text()='Failed to load activity history.']";
	public static String okbuttonopopuppath = "//button[@ng-if='ok']";
	public static String reportmenupath = "//span[text()='Reports']";
	public static String analyticsmenupath = "//span[text()='Analytics']";
	public static String appointmentmenuitempath = "//div[@class='header-tab']//span[@class='ng-scope' and text()='Appointments']";
	public static String popupdiscarchangesLabelPath = "//span[text()='Discard Changes']";
	public static String findLocationFinderPath = "//i[@class='icon icon-exc-location-marker-o']";

	public static String FAQBeforeLoginPath = "//a[@class='ng-binding' and text()='FAQ']";

	@FindBy(xpath = "//a[@href='/#/Support' and text()='Support']")
	public static WebElement supportmenuitem;

	@FindBy(xpath = "//div[@class='header-tab']//span[@class='ng-scope' and text()='Dashboard']")
	public static WebElement dashboardmenu;

	@FindBy(xpath = "//i[@class='icon icon-exc-logout']")
	public static WebElement poweroffbutton;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope']")
	public static WebElement okpopupbutton;

	@FindBy(xpath = "//button[@class='btn btn-default mleft-10 pad-lr-15 btnSmall-xs ng-scope']")
	public static WebElement cancelpopupbutton;

	@FindBy(xpath = "//div[@class='collapse navbar-collapse']//span[text()='Support']")
	public static WebElement supportlink;

	@FindBy(xpath = "//span[@class='ng-binding' and text()='My Account']")
	public static WebElement myaccountlink;

	@FindBy(xpath = "//*[@id='navbar-collapse-1']/ul/li[1]/ul/li[3]/ul/li[1]/a")
	public static WebElement accountsettingslink;

	@FindBy(xpath = "//i[@class='icon icon-exc-logout']")
	public static WebElement logoutbutton;

	@FindBy(xpath = "//a[@class='ng-binding' and text()='FAQ']")
	public static WebElement FAQ;

	@FindBy(xpath = "//p[text()='Failed to load activity history.']")
	public static WebElement failedtoloadhistorypopup;

	@FindBy(xpath = "//button[@ng-if='ok']")
	public static WebElement okbuttonopopup;

	@FindBy(xpath = "//span[text()='Reports']")
	public static WebElement reportmenu;

	@FindBy(xpath = "//span[text()='Analytics']")
	public static WebElement analyticsmenu;

	// @FindBy(xpath = "//div[@class='header-tab']//span[@class='ng-scope' and
	// text()='Appointments']")
	// public static WebElement appointmentmenuitem;

	@FindBy(xpath = "//span[text()='Appointments']")
	public static WebElement appointmentmenuitem;

	@FindBy(xpath = "//a[@class='ng-binding' and text()='FAQ']")
	public static WebElement FAQBeforeLogin;

	@FindBy(xpath = "//div[@class='collapse navbar-collapse']//a[text()='Support']")
	public static WebElement supportlinkBeforeLogin;

	@FindBy(xpath = "//span[text()='Discard Changes']")
	public static WebElement popupdiscarchangesLabel;

	@FindBy(xpath = "//i[@class='icon icon-exc-location-marker-o']")
	public static WebElement findLocationFinder;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void logout() {
		try {
			MenuPage.dashboardmenu.click();
			if (CommonFunctions.waitForVisiblity(AppointmentsPage.discardAppointmentSessionPopupOK, 1))
				CommonFunctions.clickonmodalpopup(AppointmentsPage.discardAppointmentSessionPopupOK);
			CommonFunctions.waitForVisiblity(DashBoardPage.viewmyreportdata, 10);
			CommonFunctions.clickUsingJavaExecutor(poweroffbutton);
			CommonFunctions.clickonmodalpopup(okpopupbutton);
			if (!CommonFunctions.waitForVisiblity(LoginPage.usernametext, 5) && !CommonFunctions.waitForVisiblity(okpopupbutton, 2)) {
				CommonFunctions.clickUsingJavaExecutor(poweroffbutton);
				okpopupbutton.click();
			} else if (!CommonFunctions.waitForVisiblity(LoginPage.usernametext, 5) && CommonFunctions.waitForVisiblity(okpopupbutton, 2)) {
				okpopupbutton.click();
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
}
