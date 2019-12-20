package lifelabs.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class LLBookAnAppointmentPage {

	WebDriver driver;
	
	@FindBy(id = "ctl00_MainContent_Booking1_rcbProvince_Arrow")
	public static WebElement provinceDropdownButton;

	@FindBy(xpath = "//div[@id='ctl00_MainContent_Booking1_rcbProvince_DropDown']//ul")
	public static WebElement provinceDropdownList;

	@FindBy(id = "ctl00_MainContent_Booking1_rcbRegion_Arrow")
	public static WebElement regionDropdownButton;

	@FindBy(xpath = "//div[@id='ctl00_MainContent_Booking1_rcbRegion_DropDown']//ul")
	public static WebElement regionDropdownList;

	@FindBy(id = "ctl00_MainContent_Booking1_rcbCity_Arrow")
	public static WebElement cityDropdownButton;

	@FindBy(xpath = "//div[@id='ctl00_MainContent_Booking1_rcbCity_DropDown']//ul")
	public static WebElement cityDropdownList;

	@FindBy(id = "ctl00_MainContent_Booking1_rcbLocation_Arrow")
	public static WebElement PSCcentreDropdownButton;

	@FindBy(xpath = "//div[@id='ctl00_MainContent_Booking1_rcbLocation_DropDown']//ul")
	public static WebElement PSCcentreDropdownList;

	@FindBy(id = "ctl00_MainContent_Booking_AvailableAppoinemnts1_rcbName_Arrow")
	public static WebElement bookingForDropdownButton;

	@FindBy(xpath = "//div[@id= 'ctl00_MainContent_Booking_AvailableAppoinemnts1_rcbName_DropDown']//ul")
	public static WebElement bookingForDropdownList;

	@FindBy(id = "ctl00_MainContent_Booking1_FindAppointments")
	public static WebElement findAvailableTimesButton;

	@FindBy(id = "ctl00_MainContent_Booking_AvailableAppoinemnts1_RadGridTimeSlot1_GridData")
	public static WebElement availableAppointmentsTable;

	@FindBy(id = "ctl00_MainContent_Booking_PendingAppoinemnts1_ConfirmApptButton")
	public static WebElement confirmAppointmentButton;

	public LLBookAnAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean bookAppointment(String name) {
		Boolean stat = true;
		try {
			CommonFunctions.waitForVisiblity(findAvailableTimesButton, 10);
			provinceDropdownButton.click();
			Thread.sleep(1000);
			provinceDropdownList.findElement(By.xpath("//li[contains(.,'British')]")).click();
			Thread.sleep(1500);
			regionDropdownButton.click();
			Thread.sleep(1000);
			regionDropdownList.findElement(By.xpath("//li[contains(.,'Lower Mainland')]")).click();
			CommonFunctions.waitForVisiblity(cityDropdownButton, 5);
			cityDropdownButton.click();
			Thread.sleep(1000);
			cityDropdownList.findElement(By.xpath("//li[text()='Vancouver']")).click();
			CommonFunctions.waitForVisiblity(cityDropdownButton, 5);
			// PSCcentreDropdownButton.click();
			// PSCcentreDropdownList.findElement(By.xpath(".//li[2]")).click();
			CommonFunctions.waitForVisiblity(cityDropdownButton, 5);
			findAvailableTimesButton.click();
			CommonFunctions.waitandClick(bookingForDropdownButton, 10);
			CommonFunctions.waitandClick(bookingForDropdownList.findElement(By.xpath(".//li[contains(text(),'" + name + "')]")), 10);
			CommonFunctions.waitandClick(availableAppointmentsTable.findElement(By.xpath(".//tbody//tr/td/input")), 10);
			CommonFunctions.waitandClick(confirmAppointmentButton, 10);
			CommonFunctions.waitForVisiblity(LLHomePage.confirmedAppointmentsTable, 5);
			if (!LLHomePage.confirmedAppointmentsTable.findElement(By.xpath(".//tbody//tr//td[3]")).getText().contains(name))
				stat = false;
			Thread.sleep(1500);
		} catch (Exception e) {
			stat = false;
			e.printStackTrace();
		}
		return stat;
	}

}
