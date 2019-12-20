package upp1.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class DashBoardPage {
	WebDriver driver;

	public static String firstsettingsiconpath = "//*[@id=\"body\"]/div/div/div[1]/div[1]/div[3]/div[3]/a/i";
	public static String successmodalpath = "//a[text()='Success Modal']";
	public static String errormodalpath = "//a[text()='Error Modal']";
	public static String infomodalpath = "//a[text()='Info Modal']";
	public static String questionmodalpath = "//a[text()='Question Modal']";

	public static String nonmodallocationpath = "//div[@modal-render='true']";

	public static String successpopuppath = "//span[@class='text-bold ng-scope' and text()='Success']";
	public static String errorpopuppath = "//span[@class='text-bold ng-scope' and text()='Error']";
	public static String infopopuppath = "//span[@class='text-bold ng-scope' and text()='Info']";
	public static String cancelininfopath = "//button[@class='btn btn-secondary no-min-width ng-binding' and text()='Cancel']";
	public static String questionpopuppath = "//span[@class='text-bold ng-scope' and text()='Question']";

	public static String closebuttonpath = "//i[@class='icon icon-exc-close']";
	public static String failedactivityokbuttonpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='OK']";

	public static String recentactivityHeadingPath = "//h4[contains(.,'Recent activity')]";
	public static String recentactivitydatepath = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[1]";
	public static String recentactivitynamepath = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[2]";
	public static String recentactivitymessagerow1path = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]";
	public static String recentactivityforwardiconrow1path = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]//i";
	public static String recentactivitymessagerow2path = "//tbody[2][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]";
	public static String recentactivityforwardiconrow2path = "//tbody[2][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]//i";

	public static String viewmyreportstitlepath = "//h4[text()=' View my reports:']";
	public static String viewmyreportdatapath = "//div[@class='box-reports middle']//h5";

	public static String myfamilyaccountspath = "//h4[contains(text()[3],'My family accounts')]";
	public static String myfamilyaccountsdatapath = "//div[1][@ng-repeat='patient in patientData.leftColumnPatients']";

	public static String peoplesharingtheirreportswithmetitlepath = "//h4[text()=' People sharing their reports with me: ']";
	public static String peoplesharingtheirreportswithmedatapath = "//*[@id='accordion3']/div/div[1]";

	public static String sharingmyreportswithtitlepath = "//*[@id='body']/div/div/div[1]/div[3]/div/div[1]/h4";
	public static String sharingmyreportswithdatapath = "//*[@id='accordion4']/div/div[1]";

	public static String registermyaccountbuttonpath = "//a[contains(.,'Register to view reports')]";

	public static String accountownericonclassname = "icon icon-exc-my-account- text-light-blue";
	public static String familyaccounticonclassnameADULT = "icon icon-exc-family-account- text-light-blue";
	public static String familyaccounticonclassnameMINOR = "icon icon-exc-minor-account- text-light-blue";

	public static String accountownericonslistpath = "//h4[contains(text()[1],'View my reports')]//parent::div//following-sibling::div//i";
	public static String familyaccounticonslistpath = "//h4[contains(text()[3],'My family accounts')]//parent::div//following-sibling::div[2]//div//i";

	public static String familyownernameslistpath = "//h4[contains(text()[1],'View my reports')]//parent::div//following-sibling::div//i//parent::div//following-sibling::h5";
	public static String familyaccountnamelistpath = "//h4[contains(text()[3],'My family accounts')]//parent::div//following-sibling::div[2]//div//h5";

	public static String sessiontimeoutpopresumebuttonpath = "//a[text()='Resume Your Session']";
	public static String sessiontimeoutpopuplogoffbuttonpath = "//a[text()='Log Off']";
	public static String sessiontimeoutpopupsecondspath = "//p[@class='timeout-centre']//b";
	public static String sessiontimeoutpopuptitlepath = "//span[text()='Inactivity Timeout Warning']";

	public static String popupimportappointmentscloseiconpath = "//div[@id='import-appointments']//i[@class='icon icon-exc-close']";

	public static String upcomingAppointmentTitlePath = "//h4[contains(.,'Upcoming appointments')]";
	public static String upcomingappointmentsCountLabelPath = "//h4[contains(.,'Upcoming appointments')]";
	public static String upcomingappointmentNameListPath = "//div[@ng-click='populateModalInfo(item.AppointmentID)']//h5";
	public static String upcomingappointmentTimeListPath = "//div[@ng-click='populateModalInfo(item.AppointmentID)']//h6[1]";
	public static String upcomingappointmentStreetListPath = "//div[@ng-click='populateModalInfo(item.AppointmentID)']//h6[2]";
	public static String upcomingappointFindaLocatioButtonPath = "//div[@class='row-reports']//a[@title='Find a Location']";
	public static String upcomingappointBookaAppointmentButtonPath = "//div[@class='row-reports']//a[@title='Book Appointment']";

	public static String toasterAppointmentTitleLabelPath = "//div//div/p[1]//span[contains(.,'LifeLabs Appointment Reminder')]";
	public static String toasterAppointmentCloseIconPath = "//div//div/p[1]//button[@class='close']";
	public static String toasterAppointmentNameLabelListPath = "//div//div/p[1]//div[@class='futureBookingToaster ng-scope']//h4"; // list
	public static String toasterAppointmentDateLabelListPath = "//div//div/p[1]//div[@class='futureBookingToaster ng-scope']//span[1]"; // list
	public static String toasterAppointmentStreetLabelListPath = "//div//div/p[1]//div[@class='futureBookingToaster ng-scope']//span[2]"; // list
	public static String toasterAppointmentDirectionsLinkListPath = "//div//div/p[1]//a[contains(.,'Get Directions')]"; // list

	@FindBy(xpath = "//h4[contains(text()[1],'View my reports')]//parent::div//following-sibling::div//i//parent::div//following-sibling::h5")
	public static List<WebElement> accountownernameslist;

	@FindBy(xpath = "//h4[contains(text()[1],'View my reports')]//parent::div//following-sibling::div//i")
	public static List<WebElement> accountownericonslist;

	@FindBy(xpath = "//h4[contains(text()[3],'My family accounts')]//parent::div//following-sibling::div[2]//div//i")
	public static List<WebElement> familyaccounticonslist;

	@FindBy(xpath = "//h4[contains(text()[3],'My family accounts')]//parent::div//following-sibling::div[2]//div//h5")
	public static List<WebElement> familyaccountnamelist;

	@FindBy(xpath = "//h4[text()=' View my reports:']")
	public static WebElement viewmyreportstitle;

	@FindBy(xpath = "//div[@class='box-reports middle']//h5")
	public static WebElement viewmyreportdata;

	@FindBy(xpath = "//h4[contains(text()[3],'My family accounts')]")
	public static WebElement myfamilyaccountstitle;

	@FindBy(xpath = "//div[1][@ng-repeat='patient in patientData.leftColumnPatients']//h5")
	public static WebElement myfamilyaccountsdata;

	@FindBy(xpath = "//h4[text()=' People sharing their reports with me: ']")
	public static WebElement peoplesharingtheirreportswithmetitle;

	@FindBy(xpath = "//*[@id='accordion3']/div/div[1]")
	public static WebElement peoplesharingtheirreportswithmedata;

	@FindBy(xpath = "//*[@id='body']/div/div/div[1]/div[3]/div/div[1]/h4")
	public static WebElement sharingmyreportswithtitle;

	@FindBy(xpath = "//*[@id='accordion4']/div/div[1]")
	public static WebElement sharingmyreportswithdata;

	// end

	@FindBy(xpath = "//*[@id='body']/div/div/div[1]/div[1]/div[3]/div[3]/a/i")
	public static WebElement firstsettingsicon;

	@FindBy(xpath = "//a[text()='Success Modal']")
	public static WebElement successmodal;

	@FindBy(xpath = "//a[text()='Error Modal']")
	public static WebElement errorsmodal;

	@FindBy(xpath = "//a[text()='Info Modal']")
	public static WebElement infomodal;

	@FindBy(xpath = "//a[text()='Question Modal']")
	public static WebElement questionmodal;

	@FindBy(xpath = "//div[@modal-render='true']")
	public static WebElement nonmodallocation;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='OK']")
	public static WebElement failedactivityokbutton;

	@FindBy(xpath = "//h4[contains(.,'Recent activity')]")
	public static WebElement recentactivityHeading;

	@FindBy(xpath = "//tbody[@ng-repeat='report in activityHistoryData.reports']/tr/td[1]")
	public static List<WebElement> recentactivitydateList;

	@FindBy(xpath = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[1]")
	public static WebElement recentactivitydate;

	@FindBy(xpath = "//tbody[@ng-repeat='report in activityHistoryData.reports']/tr/td[2]/h4")
	public static List<WebElement> recentactivitynameList;

	@FindBy(xpath = "//tbody[@ng-repeat='report in activityHistoryData.reports']/tr/td[2]/i")
	public static List<WebElement> recentactivityiconList;

	@FindBy(xpath = "//tbody[@ng-repeat='report in activityHistoryData.reports']/tr/td[3]/div")
	public static List<WebElement> recentactivityReportNameList;

	@FindBy(xpath = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[2]")
	public static WebElement recentactivityname;

	@FindBy(xpath = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]")
	public static WebElement recentactivitymessagerow1;

	@FindBy(xpath = "//tbody[2][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]")
	public static WebElement recentactivitymessagerow2;

	@FindBy(xpath = "//tbody[1][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]//i")
	public static WebElement recentactivityforwardiconrow1;

	@FindBy(xpath = "//tbody[2][@ng-repeat='report in activityHistoryData.reports']/tr/td[3]//i")
	public static WebElement recentactivityforwardiconrow2;

	@FindBy(xpath = "//a[contains(.,'Register')]")
	public static WebElement registermyaccountbutton;

	@FindBy(xpath = "//a[contains(.,'Resume Your Session')]")
	public static WebElement sessiontimeoutpopresumebutton;

	@FindBy(xpath = "//a[contains(.,'Log Off')]")
	public static WebElement sessiontimeoutpopuplogoffbutton;

	@FindBy(xpath = "//p[@class='timeout-centre']//b")
	public static WebElement sessiontimeoutpopupseconds;

	@FindBy(xpath = "//span[contains(.,'Inactivity Timeout Warning')]")
	public static WebElement sessiontimeoutpopuptitle;

	//// this xpath change is required after sprint 14 deployment
	@FindBy(xpath = "//div[@id='import-appointments']//i[@class='icon icon-exc-close']")
	public static List<WebElement> popupimportappointmentscloseicon;

	@FindBy(xpath = "//h4[contains(.,'Upcoming appointments')]")
	public static WebElement upcomingAppointmentTitle;

	@FindBy(xpath = "//div[@id='futureBookingAccordion']//a[@title='Book Appointment']")
	public static WebElement upcomingSectionBookAppointmentButton;

	@FindBy(xpath = "//div[@id='futureBookingAccordion']//a[@title='Find a Location']")
	public static WebElement upcomingSectionFindLocationButton;

	@FindBy(xpath = "//div[@id='futureBookingAccordion']//p[contains(text(),'Sorry, this feature is not currently available.')]")
	public static WebElement upcomingSectionOutageText;

	@FindBy(xpath = "//div[@id='futureBookingAccordion']//div[@ng-repeat='item in futureAppointmentsDashboard']")
	public static List<WebElement> upcomingAppointmentList;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']//p[2]")
	public static WebElement detailedAppointmentViewPerson;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']//p[4]")
	public static WebElement detailedAppointmentViewDateTime;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']//p[6]")
	public static WebElement detailedAppointmentViewLocation;

	@FindBy(xpath = "//div[@id='modelinfo']//h4")
	public static WebElement detailedAppointmentViewTitle;

	@FindBy(xpath = "//div[@id='modelinfo']//button[@class='close']")
	public static WebElement detailedAppointmentCloseButton;

	@FindBy(xpath = "//h4[contains(.,'Upcoming appointments')]")
	public static WebElement upcomingappointmentsCountLabel;

	@FindBy(xpath = "//div[@ng-click='populateModalInfo(item.AppointmentID)']//h5")
	public static List<WebElement> upcomingappointmentNameList;

	@FindBy(xpath = "//div[@ng-click='populateModalInfo(item.AppointmentID)']//h6[1]")
	public static List<WebElement> upcomingappointmentTimeList;

	@FindBy(xpath = "//div[@ng-click='populateModalInfo(item.AppointmentID)']//h6[2]")
	public static List<WebElement> upcomingappointmentStreetList;

	@FindBy(xpath = "//div[@class='row-reports']//a[@title='Find a Location']")
	public static WebElement upcomingappointFindaLocatioButton;

	@FindBy(xpath = "//div[@class='row-reports']//a[@title='Book Appointment']")
	public static WebElement upcomingappointBookaAppointmentButton;

	@FindBy(xpath = "//div//div/p[1]//span[contains(.,'LifeLabs Appointment Reminder')]")
	public static WebElement toasterAppointmentTitleLabel;

	@FindBy(xpath = "//div//div/p[1]//button[@class='close']")
	public static WebElement toasterAppointmentCloseIcon;

	@FindBy(xpath = "//div//div/p[1]//div[@class='futureBookingToaster ng-scope']//h4")
	public static List<WebElement> toasterAppointmentNameLabelList;

	@FindBy(xpath = "//div//div/p[1]//div[@class='futureBookingToaster ng-scope']//span[1]")
	public static List<WebElement> toasterAppointmentDateLabelList;

	@FindBy(xpath = "//div//div/p[1]//div[@class='futureBookingToaster ng-scope']//span[2]")
	public static List<WebElement> toasterAppointmentStreetLabelList;

	@FindBy(xpath = "//div//div/p[1]//a[contains(.,'Get Directions')]")
	public static List<WebElement> toasterAppointmentDirectionsLinkList;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyandclickonResumeSessionPopup() throws Exception {
		boolean response = false;

		CommonFunctions.clickonmodalpopup(sessiontimeoutpopresumebutton);
		response = true;

		return response;
	}

	public boolean verifyandclickonLogoffPopup() throws Exception {
		boolean response = false;

		CommonFunctions.clickonmodalpopup(sessiontimeoutpopuplogoffbutton);
		response = true;

		return response;
	}

	public static int getUpcomingAppointmentTitleCount() {
		String[] count = new String[2];
		try {
			CommonFunctions.waitForVisiblity(upcomingAppointmentTitle, 20);
			count = upcomingAppointmentTitle.getText().split(": ");
			// System.out.println("dash count:"+count[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Integer.parseInt(count[1]);
	}

	public static int getUpcomingAppointmentBoxCount() {
		int count = 0;
		try {
			CommonFunctions.waitForVisiblity(upcomingAppointmentList.get(0), 20);
			count = upcomingAppointmentList.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
