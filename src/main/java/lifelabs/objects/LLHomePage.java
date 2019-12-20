package lifelabs.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class LLHomePage {
	WebDriver driver;

	@FindBy(id = "ctl00_MainContent_DefaultBookAppointmentLink")
	public static WebElement clickHereBookAppointmentLink;

	@FindBy(xpath = "//div[@class='radmenubar']//a[contains(text(),'Book an Appointment')]")
	public static WebElement bookAnAppointmentLink;

	@FindBy(id = "ctl00_MainContent_Dependent1_RadGrid1_ctl00_ctl02_ctl00_LinkButton2")
	public static WebElement addMemberLink;

	@FindBy(id = "ctl00_MainContent_Dependent1_RadGrid1_ctl00_ctl02_ctl02_RadTextBoxFirstName")
	public static WebElement insertMemberFirstName;

	@FindBy(id = "ctl00_MainContent_Dependent1_RadGrid1_ctl00_ctl02_ctl02_RadTextBoxLastName")
	public static WebElement insertMemberLastName;

	@FindBy(id = "ctl00_MainContent_Dependent1_RadGrid1_ctl00_ctl02_ctl02_Button1")
	public static WebElement insertButton;

	@FindBy(id = "ctl00_MainContent_Dependent1_RadGrid1_ctl00_ctl02_ctl02_btnCancel")
	public static WebElement cancelButton;

	@FindBy(id = "ctl00_MainContent_Dependent1_RadGrid1_ctl00")
	public static WebElement membersTable;

	@FindBy(id = "ctl00_MainContent_apptPending1_rgApptHistory_ctl00")
	public static WebElement confirmedAppointmentsTable;

	@FindBy(xpath = "//a[contains(.,'Logout')]")
	public static WebElement logoutButton;

	public LLHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean addMember(String firstName, String lastName) {
		Boolean stat = true;
		try {
			addMemberLink.click();
			CommonFunctions.waitForVisiblity(insertMemberFirstName, 10);
			insertMemberFirstName.sendKeys(firstName);
			insertMemberLastName.sendKeys(lastName);
			insertButton.click();
			Thread.sleep(1000);
			CommonFunctions.waitForVisiblity(membersTable.findElement(By.xpath(".//tbody//tr")), 10);
			if (!membersTable.findElement(By.xpath(".//tbody//tr//td[2]")).getText().contains(firstName))
				stat = false;

		} catch (Exception e) {
			stat = false;
			e.printStackTrace();
		}
		return stat;
	}
}
