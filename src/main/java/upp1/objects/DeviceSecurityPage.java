package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeviceSecurityPage {

	WebDriver driver;

	public static String devicesecuritytitlepath = "//h3[conatins(.,'Device Security')]";
	public static String devicesecuritytableheaderpath = "//div[@id='device-activity' and @class='tab-pane active']//table//thead[1]//tr[1]";
	public static String devicesecuritytablefirstrowpath = "//div[@id='device-activity' and @class='tab-pane active']//table//tbody[1]//tr[1]//td[@class='first-columnprogram']";

	public static String deviceactivitytabpath = "//span[text()='Activity']";
	public static String securityeventstabpath = "//span[text()='Events']";

	public static String securityeventstableheaderpath = "//div[@id='security-events' and @class='tab-pane active']//table//thead//tr[1]";
	public static String securityeventstablefirstrowpath = "//div[@id='security-events' and @class='tab-pane active']//table//tbody[1]//tr[1]//td[@class='first-columnprogram']";

	@FindBy(xpath = "//h3[conatins(.,'Device Security')]")
	public static WebElement devicesecuritytitle;

	@FindBy(xpath = "//div[@id='device-activity' and @class='tab-pane active']//table//thead[1]//tr[1]")
	public static WebElement devicesecuritytableheader;

	@FindBy(xpath = "//div[@id='device-activity' and @class='tab-pane active']//table//tbody[1]//tr[1]//td[@class='first-columnprogram']")
	public static WebElement devicesecuritytablefirstrow;

	@FindBy(xpath = "//span[text()='Activity']")
	public static WebElement deviceactivitytab;

	@FindBy(xpath = "//span[text()='Events']")
	public static WebElement securityeventstab;

	@FindBy(xpath = "//div[@id='security-events' and @class='tab-pane active']//table//thead//tr[1]")
	public static WebElement securityeventstableheader;

	@FindBy(xpath = "//div[@id='security-events' and @class='tab-pane active']//table//tbody[1]//tr[1]//td[@class='first-columnprogram']")
	public static WebElement securityeventstablefirstrow;

	public DeviceSecurityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
