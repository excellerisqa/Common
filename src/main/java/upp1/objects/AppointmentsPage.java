package upp1.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import upp1.objects.bean.AnnouncementMessageBean;
import upp1.objects.bean.AppointmentsSearchDataBean;
import upp1.objects.bean.AvailableAppointmentsBean;
import upp1.objects.bean.CancelledAppointmentBeans;
import upp1.objects.bean.FutureorHistoryAppointmentsBeans;
import upp1.objects.bean.OperatingHoursBean;
import upp1.objects.bean.SelectedAppointmentBeans;
import upp1.objects.bean.SurroundingLabsBean;
import upp1.objects.bean.WaitTimeBean;
import utils.BugsHandler;
import utils.CheckandFetchEmail;
import utils.CommonFunctions;
import utils.ObjectHelper;

public class AppointmentsPage {
	WebDriver driver;

	public AppointmentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String findlocationbuttonpath = "//a[@title='Find a Location']";
	public static String bookappointmentbuttonpath = "//a[@title='Book Appointment']";
	public static String importappoitmentsbuttonpath = "//span[text()='Import Appointments']";

	public static String futurebookingstabpath = "//a[@data-target='#future-bookings']";
	public static String previousmonthstabpath = "//a[@data-target='#previous-bookings']";
	public static String cancelledtabpath = "//a[@data-target='#cancelled']";

	public static String fbtabledatecolumnpath = "//div[@id='future-bookings']//thead//tr//th[text()='Date']";
	public static String fbtablenamecolumnpath = "//div[@id='future-bookings']//thead//tr//th[text()='Name']";
	public static String fbtableaddresscolumnpath = "//div[@id='future-bookings']//thead//tr//th[text()='Address']";
	public static String fbtableconfirmationcolumnpath = "//div[@id='future-bookings']//thead//tr//th[text()='Confirmation #']";
	public static String fbtableinfocolumnpath = "//div[@id='future-bookings']//thead//tr//th[text()='Info']";
	public static String fbtableactionscolumnpath = "//div[@id='future-bookings']//thead//tr//th[text()='Actions']";

	public static String fbtabledatecolumnDataPath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//tr[@ng-repeat='item in futurebookings'][1]//span[@ng-show='futureAppointmentRowCount > 0']";
	public static String fbtablenamecolumnDatapath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//tr[@ng-repeat='item in futurebookings'][1]//td[@class='text-bold hidden-xs ng-binding']";
	public static String fbtableaddresscolumnDatapath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//tr[@ng-repeat='item in futurebookings'][1]//span[@class='text-bold ng-binding']";
	public static String fbtableconfirmationcolumnDatapath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//tr[@ng-repeat='item in futurebookings'][1]//td[@class='hidden-xs ng-binding'][2]";
	public static String fbtableinfocolumnDatapath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//tr[@ng-repeat='item in futurebookings'][1]//td[@class='hidden-xs text-center']//span[@class='icon icon-exc-info-help-tip']";
	public static String fbtableactionscolumnDatapath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//tr[@ng-repeat='item in futurebookings'][1]//td[@class='hidden-xs text-center']//a[text()='CANCEL']";
	public static String fbtableconsisemessagepath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//text()[contans(.,'There are no future appointments')]"; // need to check

	public static String bookanappoinmenthyperlinkpath = "//div[@class='ng-hide']//following-sibling::div//a[contains(text(),' Book an Appointment ')]";
	public static String clickherehyperlinkpath = "//a[contains(text(),'Click here')]";
	public static String bookanappointmenttitlepath = "//h3[text()='Book an appointment at a LifeLabs location nearest you']";

	public static String pmtabledatecolumnpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Date']";
	public static String pmtablenamecolumnpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Name']";
	public static String pmtableaddresscolumnpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Address']";
	public static String pmtableconfirmationcolumnpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Confirmation #']";

	public static String pmtabledatecolumnDatapath = "//tbody[@ng-init='previousDropdownMenuIconShow(0)']//tr[@ng-repeat='item in previousbookings | orderBy:itemSortOrder'][1]//span[@class='hidden-xs ng-binding']";
	public static String pmtablenamecolumnDatapath = "//tbody[@ng-init='previousDropdownMenuIconShow(0)']//tr[@ng-repeat='item in previousbookings | orderBy:itemSortOrder'][1]//td[@class='text-bold hidden-xs ng-binding']";
	public static String pmtableaddresscolumnDatapath = "//tbody[@ng-init='previousDropdownMenuIconShow(0)']//tr[@ng-repeat='item in previousbookings | orderBy:itemSortOrder'][1]//td[@class='hidden-xs ng-binding'][1]";
	public static String pmtableconfirmationcolumnDatapath = "//tbody[@ng-init='previousDropdownMenuIconShow(0)']//tr[@ng-repeat='item in previousbookings | orderBy:itemSortOrder'][1]//td[@class='hidden-xs ng-binding'][2]";
	public static String pmtableconsisemessagepath = "//tbody[@ng-init='previousDropdownMenuIconShow(0)']//text()[contains(.,'There are no previous bookings')]"; // need to check

	public static String candatecolumnpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Date']";
	public static String cancancelleddatecolumnpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Cancelled Date']";
	public static String cannamecolumnpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Name']";
	public static String canaddresscolumnpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Address']";
	public static String canconfirmationcolumnpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Confirmation #']";

	public static String candatecolumnDatapath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder'][1]//span[@class='hidden-xs ng-binding']";
	public static String cancancelleddatecolumnDatapath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder'][1]//td[@ng-show='cancelAppointmentRowCount > 0'][2]";
	public static String cannamecolumnDatapath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder'][1]//td[@ng-show='cancelAppointmentRowCount > 0'][3]";
	public static String canaddresscolumnDatapath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder'][1]//td[@ng-show='cancelAppointmentRowCount > 0'][4]";
	public static String canconfirmationcolumnDatapath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder'][1]//td[@ng-show='cancelAppointmentRowCount > 0'][5]";
	public static String canconsisemessagePath = "//div[@id='cancelledbookings']//tbody//text()[contains(.,'There are no cancelled appointments')]"; // need to check

	public static String findalocationTitleLabelPath = "//h3[contains(.,'Find the LifeLabs location nearest you')]";
	public static String bookanappointmentTitleLabelPath = "//h3[contains(.,'Book an appointment at a LifeLabs location nearest you')]";
	public static String checkboxeslistpath = "//ul[@class='list-checkboxs']//li//div[@class='checkbox-btn']//span";
	public static String showmorefiltershyperlinkpath = "//a[text()='Show more filters']";
	public static String showLessFiltersHyperLinkPath = "//a[text()='Show less filters']";
	public static String searchtextboxpath = "//input[@type='text' and @ng-change='addressChanged()']";
	public static String usemylocationhyperlinkpath = "//a[text()='Use my location']";
	public static String findsearchbuttonpath = "//span[@class='input-group-btn']//button";

	public static String searchresultstabinactivepath = "//a[@title='Search Results']//parent::li[not(contains(@class,'active'))]";
	public static String locationdetailstabinactivepath = "//a[@title='Location Details']//parent::li[@class='ng-scope']";

	public static String searchresultstabactivepath = "//a[@title='Search Results']//parent::li[@class='active']";
	public static String locationdetailstabactivepath = "//a[@title='Location Details']//parent::li[@class='ng-scope active']";

	public static String directionOnMapPopUpHyperLinkPath = "//div[@id='map-container']//a[text()='Directions']";
	public static String detailsonMapPopUpHyperLinkPath = "//div[@id='map-container']//a[contains(text(),'Details')]";
	public static String streetNameOnMapPopUpHyperLinkPath = "//div[@id='map-container']//h5[1]";
	public static String closeOnMapPopUpIconPath = "//div[@id='googleMap']/div/div/div[1]/div[3]/div/div[4]/div/button";
	public static String currentwaittimeonMapPath = "//div[@id='map-container']//span[@class='pull-left']";

	public static String showfiltershyperlinkpath = "//a[text()='Show Filters']";
	public static String hidefiltershyperlinkpath = "//a[text()='Hide Filters']";

	public static String specialhoursIconPath = "//h5[text()=' Special Hours and Access']//i";
	public static String specialTestLocationIconPath = "//h5[text()=' Special Test Locations']//i";

	public static String directionsindividualHyperlinkPath = "//li[1][@ng-repeat='location in locations']//a[text()='Directions']";
	public static String detailsindividualHyperlinkPath = "//li[1][@ng-repeat='location in locations']//a[text()='Details']";
	public static String mapindividualIconPath = "//div[@id='map-container']//div[1][@class='gmnoprint' and @title]";

	public static String nonselectedfilterIconPath = "//span[@class='text-20 text-dark-blue icon icon-exc-filter-off-o']";
	public static String selectedFilterIconPtah = "//span[@class='text-20 text-dark-blue icon icon-exc-filter-on']";

	public static String backButtonpath = "//a[@title='Back']";
	public static String mapsDestinationInputPath = "//div[@id='directions-searchbox-1']//input[@class='tactile-searchbox-input']";
	public static String mapsTitlePath = "//link[contains(@title,'Google Maps')]";

	public static String searchresultsCountPath = "//span[@ng-show='!showLocationDetails']//span";
	public static String searchdistancePath = "//li[@ng-repeat='location in locations']//a[text()='Directions']//parent::p";
	public static String searchWaitTimePath = "//li[@ng-repeat='location in locations']//h5[@ng-show='location.Availability_Today && location.Show_Wait_Time']";

	public static String locationStreetNamePath = "//div[@id='location-details']//div[@class='box-address']//h5";
	public static String locationCityNamePath = "//div[@id='location-details']//div[@class='box-address']//h5//span";
	public static String locationDistanceNamePath = "//a[text()='Directions']//parent::p//preceding-sibling::p";
	public static String locationdetailsDirectionshyperlinkpath = "//div[@id='location-details']//a[text()='Directions']";
	public static String locationcurrentwaittimePath = "//div[@id='location-details']//h5[@ng-model='activeLocation']";

	public static String locationtodayLabelPath = "//div[@id='location-details']/ul/li/div[3]/div/div[1]/div[1]";
	public static String locationtomorrowLabelpath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[1]";
	public static String locationdayaftertomorroLabelPath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[1]";

	public static String locationtodayTimingpath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[2]//span";
	public static String locationtomorrowTimingpath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[2]//span";
	public static String locationdayaftertomorrowTimingpath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[2]//span";

	public static String locationBookAppointmentButtonPath = "//div[@id='location-details']//a[@title='Book Appointment']";
	public static String locationtodaysuccessIconPath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[2]//i[@class='icon icon-exc-appointment-reminder text-green text-20']";
	public static String locationtomorrowsuccessIconPath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[2]//i[@class='icon icon-exc-appointment-reminder text-green text-20']";
	public static String locationdayaftertomorrowsuccessIconPath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[2]//i[@class='icon icon-exc-appointment-reminder text-green text-20']";

	public static String locationtodayfailIconPath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']";
	public static String locationtomorrowfailIconPath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']";
	public static String locationdayaftertomorrowfailIconPath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']";

	public static String fbCancelPopYesPath = "//a[@title='Yes']";
	public static String fbCancelPopNoPath = "//a[@title='No']";

	public static String fbPopupAppointmentTitleLabelPath = "//h4[text()=' Appointment Information']";
	public static String fbPopupAppointmentCloseIconPath = "//i[@class='icon icon-exc-cancel']";
	public static String fbPopupPersonNameLabelPath = "//p[@class='text-dark-blue text-bold ng-binding'][1]";
	public static String fbPopupWhenlabelPath = "//p[@class='text-dark-blue text-bold ng-binding'][2]";
	public static String fbPopupLocationLabelPath = "//p[@class='text-dark-blue text-bold no-b-mar ng-binding']";
	public static String fbPopupdistanceLabelPath = "//a[@title='Directions']//parent::p";
	public static String fbPopupDirectionsHyperLinkPath = "//a[@title='Directions']";
	public static String fbPopupStreetViewhyperLinkPath = "//a[@title='Street view']";
	public static String fbPopupPhoneNumberLabeListlPath = "//div[@class='text-normal ng-binding']"; // list
	public static String fbPopupFaxNumberLabelPath = "//div[@class='text-bold ng-binding' and contains(.,'Fax:')]//following-sibling::div[@class='text-normal ng-binding']";
	public static String fbPopupMondayLabelPath = "//div[@id='printAppointmentDetails']/div[4]/div[2]/p";
	public static String fbPopupTuesdayLabelPath = "//div[@id='printAppointmentDetails']/div[5]/div[2]/p";
	public static String fbPopupWednesdayLabelPath = "//div[@id='printAppointmentDetails']/div[6]/div[2]/p";
	public static String fbPopupThursdayLabelPath = "//div[@id='printAppointmentDetails']/div[7]/div[2]/p";
	public static String fbPopupFridayLabelPath = "//div[@id='printAppointmentDetails']/div[8]/div[2]/p";
	public static String fbPopupSaturdayLabelPath = "//div[@id='printAppointmentDetails']/div[9]/div[2]/p";
	public static String fbPopupSundayLabelPath = "//div[@id='printAppointmentDetails']/div[10]/div[2]/p";
	public static String fbPopupAddtoCalendarButtonPath = "//a[@title='Add to Calendar']";
	public static String fbPopupSharebyEmailButtonPath = "//a[@title='Share']";
	public static String fbPopupVieworPrintDetailsButtonPath = "//a[@title='View or Print Details']";

	// All Steps titles
	public static String alltitlesListPath = "//ul[@class='list-appointment-steps four-steps']//li"; // list
	public static String activetitlePath = "//ul[@class='list-appointment-steps four-steps']//li[@class='active']";
	public static String inactivetitllistPath = "//ul[@class='list-appointment-steps four-steps']//li[not(contains(@class,'active'))]"; // list

	// Step1
	public static String step1patientinstructionsTitlePath = "//span[text()='Patient Instructions']";
	public static String step1nexttopbuttonpath = "//button[@name='primary' and @class='btn btn-primary btn-next btn-next-top ng-binding']";
	public static String step1nextBottomButtonPath = "//p[@class='mb-20']//button[@name='primary' and @class='btn btn-primary btn-next ng-binding']";
	public static String step1LifeLabsHyperLinkPath = "//a[text()='www.lifelabs.com']";
	public static String step1locationpopupBCMyehealthButtonPath = "//button[contains(.,'Continue with my ehealth')]";
	public static String step1locationpopupBCMyResultsButtonPath = "//button[contains(.,'Switch to my results')]";
	public static String step1locationpopupONMyehealthButtonPath = "//button[contains(.,'Continue with my results')]";
	public static String step1locationpopupONMyResultsButtonPath = "//button[contains(.,'Switch to my ehealth')]";

	// Step2
	public static String step2dateandtimeTitlepath = "//a[@ng-click='selectAppointmentTab(2)']";
	public static String step2changelocationlinkpath = "//a[@class='link-light ng-binding' and text()='change location']";
	public static String step2streetnamePath = "//h4[@class='text-dark-blue mb20 ng-binding']";
	public static String step2InfoIconPath = "//span[@class='icon icon-exc-info-help-tip']";
	public static String step2selectedtimeslotTextPath = "//h4[@class='text-dark-blue ng-binding']";
	public static String step2IncludesurrondingCjeckBoxPath = "//label[contains(.,'Include surrounding labs')]";
	public static String step2calendarbackIconPath = "//i[@class='icon-exc-drop-down-menu-left']";
	public static String step2calendarforwardIconPath = "//i[@class='icon-exc-drop-down-menu-right']";
	public static String step2calendarmonthIconpath = "//div[@class='cal-cell1 cal-cell']//span[text()='13']"; // Change_Date
	public static String step2calendarmonthTitlePath = "//div[@class='calendar-header']//h3";
	public static String step2calendarcloseiconListPath = "//div[@class='cal-cell1 cal-cell']//i[@class='icon icon-exc-close text-red']"; // list
	public static String step2calendarnotavailabledatesListPath = "//i[@class='icon icon-exc-close text-red']//parent::span[@ng-if='cellVisibility21 === false && cellClosed21 === false']"; // list
	public static String step2calendaravailableiconListPath = "//div[@class='cal-cell1 cal-cell']//i[@class='icon icon-exc-success-5 text-green']"; // list
	public static String step2calendarselectedDatePath = "//div[@class='cal-month-day cal-day-inmonth valid active']//span[1]";
	public static String step2UnSelectedTimeSlotButtonsListPath = "//a[@class='btn-time']"; // list
	public static String step2SelectedTimeSlotButtonPath = "//a[@class='btn-time active']";
	public static String step2nextTopButtonPath = "//p[@class='mb-20']//button[@title='Next']";
	public static String step2nextBottomButtonPath = "//div[@class='col-md-6']//button[@title='Next']";
	public static String step2SurroundingLabTableHeaderTimePath = "//th[text()='Time']";
	public static String step2SurroundingLabTableInfoiconlistPath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//button//span[@class='icon icon-exc-info-help-tip']"; // list
	public static String step2SurroundingLabTableTimeListPath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//tr[@ng-repeat='item in surroundingLabsTableCollection']//td[1]"; // list_for_time
	public static String step2SurroundingLabTableAddressListPath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//tr[@ng-repeat='item in surroundingLabsTableCollection']//td[2]"; // list__for_Address
	public static String step2SurroundingLabTableDistanceListPath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//tr[@ng-repeat='item in surroundingLabsTableCollection']//td[3]"; // list_for_Distance

	// step2 popup
	public static String step2infopopupTitlePath = "//text()[contains(.,'Location Information')]";
	public static String step2infopopupDirectionsHyperLinkPath = "//a[@title='Directions' and @class='link-light ng-binding' and text()='Directions']";
	public static String step2infopopupStreetViewHyperLinkPath = "//a[@title='Street view' and @class='link-light ng-binding' and text()='Street view']";
	public static String step2infopopupStreetnameLabelPath = "//div[@class='modal-body']//h5[1]";
	public static String step2infopopupDistanceLabelPath = "//div[@class='modal-body']//p[@class='mt-5 ng-binding'][1]";
	public static String step2infopopupPhoneNumberLabelPath = "//div[contains(.,'Phone')]//a[contains(@href,'tel')]";
	public static String step2infopopupFaxNumberLabelPath = "//div[@class='row-timeing mb-10']//div[@class='text-normal']";
	public static String step2infopopupHoursOpenMontoFriLabelPath = "//p[contains(.,'Mon')]";
	public static String step2infopopupHoursOpenSaturdayLabelPath = "//p[contains(.,'Sat')]";
	public static String step2infopopupHoursOpenSundayLabelPath = "//p[contains(.,'Sun')]";
	public static String step2infopopupCloseIconPath = "//i[@class='icon icon-exc-cancel']";
	public static String step2infopopupAddtoCalendarButtonPath = "//a[@title='Add to Calendar']";
	public static String step2infopopupSharebyEmailButtonPath = "//a[@title='Share']";
	public static String step2infopopupVieworPrintDetailsButtonPath = "//a[@title='View or Print Details']";

	// Step3
	public static String step3AccountTitlepath = "//span[contains(.,'Account')]";
	public static String step3useremailTextBoxPath = "//input[@id='emailInput']";
	public static String step3passwordTextBoxPath = "//input[@id='passwordInput']";
	public static String step3forgotpasswordHyperLinkPath = "//a[text()='Forgot password?']";
	public static String step3forgotpasswordEmailTextBoxPath = "//input[@typeof='email']";
	public static String step3forgotpasswordSendButtonPath = "//button[text()='SEND']";
	public static String step3forgotpasswordCancelButtonPath = "//a[@ng-click='initForgotPasswordFormData()' and text()='CANCEL']";
	public static String step3forgotpasswordContinueButtonPath = "//a[@ng-click='clearFormData()' and contains(.,'CONTINUE')]";
	public static String step3ChangepasswordConfirmLabelPath = "//label[text()='We have received your password change request']";
	public static String step3ChangepasswordContinueButtonPath = "//a[@ng-click='clearFormData()' and contains(.,'CONTINUE')]";
	public static String step3BacktopButtonPath = "//button[text()='BACK']";
	public static String step3nexttopButtonPath = "//div[@class='col-xs-3 col-sm-3 col-md-3 text-right ng-scope']//button[@title='Next']";
	public static String step3loginButtonPath = "//p//button[text()='Login']";
	public static String step3CreateAccountButtonPath = "//button[@title='CREATE ACCOUNT']";
	public static String step3FirstNameTextBoxPath = "//label[text()='First Name*']//following-sibling::input";
	public static String step3LastNameTextBoxPath = "//label[text()='Last Name*']//following-sibling::input";
	public static String step3PhoneNumberTextBoxPath = "//label[text()='Phone Number*']//following-sibling::input";
	public static String step3ProvinceComboBoxPath = "//div[contains(@ng-init, 'provinceList')]";
	public static String step3ProvinceListPath = "//select//option[@ng-repeat='item in provinceList']"; // list
	public static String step3EmailTextBoxPath = "//label[contains(text(),'Email*')]//following-sibling::input";
	public static String step3ReTypeEmailTextBoxPath = "//label[contains(text(),'Retype email to confirm it*')]//following-sibling::input";
	public static String step3PasswordTextBoxPath = "//label[contains(text(),'Password*')]//following-sibling::input";
	public static String step3ReTypePasswordTextBoxPath = "//label[contains(text(),'Retype password to confirm it*')]//following-sibling::input";
	public static String step3ReceieveEmailCheckBoxPath = "//input[@id='confirmation']//parent::div//span";
	public static String step3ReceiveSurveyCheckBoxPath = "//input[@id='confirmationSurvey']//parent::div//span";
	public static String step3AgreeTermsCheckBoxPath = "//input[@id='terms']//parent::div//span";
	public static String step3VerifyEmailButtonPath = "//button[@title='Verify Email']";
	public static String step3LiteAccountSucessmessageLabelPath = "//h5[text()='We have sent an account verification email to']";
	public static String step3LiteAccountActivationURLLabelPath = "//div[@ng-if='emailVerificationLinkInfo']//a[@target='_blank']";
	public static String step3SixDigitTextBoxPath = "//div[@class='list-enter-code']//input";
	public static String step3DidntgetEmailHyperLinkPath = "//a[text()='Didn’t get an email?']";
	public static String step3CreateAccountButton2Path = "//a[@title='CREATE ACCOUNT']";
	public static String step3SendNewCodeButtonPath = "//a[@title='SEND A NEW CODE']";
	public static String step3WhenTimeLabelPath = "//div[@class='box-confirm ng-scope']//p[@class='text-dark-blue  text-bold text-18 ng-binding']";
	public static String step3locationLabelPath = "//div[@class='box-confirm ng-scope']//p[@class='text-dark-blue  text-bold text-18 mb-20 ng-binding']";
	public static String step3MustAgreeWarningLabelPath = "//div[@class='validation-error-messages ng-scope']//div[contains(.,'You must agree to the Terms of use and Privacy Policy to proceed.')]";
	public static String step3TermsofUseHyperLinkPath = "//div[@id='account']//a[contains(.,'Terms of Use')]";
	public static String step3PrivacyPolicyHyperLinkPath = "//div[@id='account']//a[contains(.,'Privacy Policy')]";

	// Step4
	public static String step4ConfirmTitlepath = "//h4[contains(.,'Your appointment has been booked!')]";
	public static String step4TimeRemainingLabelPath = "//div[@class='timer ng-binding']";
	public static String step4UserComboboxPath = "//button[@class='multiselect dropdown-toggle btn btn-default']";
	public static String step4UserComboboxListPath = "//ul[@class='multiselect-container dropdown-menu']//li//label//div";
	public static String step4WhenLabelPath = "//p[@class='text-dark-blue  text-bold text-18 ng-binding']";
	public static String step4LocationLabelPath = "//p[@class='text-dark-blue  text-bold text-18 mb-20']";
	public static String step4ConfirmAppointmentPath = "//div[@id='appointments']/div/div/div[3]/div[1]/div[3]/div[3]//button[@title='Confirm Appointment']";
	public static String step4ConfirmAppointmentTopButtonPath = "//button[@id='btnNavConfirmAppointment' and contains(.,'Confirm Appointment')]";
	public static String step4TopConfirmAppointmentpath = "//button[@class='btn btn-primary btn-next btn-next-top ng-binding']";
	public static String step4TimeRemainingPath = "//div[@class='timer ng-binding']";
	public static String step4PopupExtendTimeButtonPath = "//html//body//div[4]//div//a[@id='extendTimeoutBtn']";
	public static String step4PopupDiscardButtonPath = "//html//body//div[4]//div//a[@id='extendTimeoutBtn']//following-sibling::a";
	public static String step4PopupTimeoutConfirmOKButtonPath = "//a[@title='Okay']";
	public static String step4PopupTimeoutTitlePathLabel = "//p[text()='The confirmation period has timed out. Please check the selected date and time again']";
	public static String step4PhonenumberTextBoxPath = "//input[@ng-model='accountProfileInfo.PhoneNumber']";
	public static String step4PhonenumberWarningLabelpath = "//input[@ng-model='accountProfileInfo.PhoneNumber']//parent::li//div[contains(.,'This is a required field') and @class='ng-binding ng-scope']";
	public static String step4PhonenumberInvalidLabelPath = "//input[@ng-model='accountProfileInfo.PhoneNumber']//parent::li//div[contains(.,'Invalid phone number') and @class='validation-error-messages ng-binding ng-scope']";
	public static String step4AdhocFirstNameTextBoxPath = "//input[@name='newFirstName']";
	public static String step4AdhocLastNameTextBoxPath = "//input[@name='newLastName']";
	public static String step4AdhocFirstnameRequiredLabelPath = "//div[@id='appointmentsbookingsuccess']/ol/li[1]/div/div[2]/div[1]/div[1]/div/div/div/div";
	public static String step4AdhocLastnameRequiredLabelPath = "//div[@id='appointmentsbookingsuccess']/ol/li[1]/div/div[2]/div[1]/div[2]/div/div/div/div";
	public static String step4AdhocUserIconPath = "//i[@class='icon icon-exc-add-member  text-light-blue']";
	public static String step4EmailSentLabelPath = "//p[contains(.,'A verification email has been sent to')]";

	// Appoint confirmation
	public static String step4AppointmentconformLabelPath = "//h4[text()='Your appointment has been booked!']";
	public static String step4DirectionButtonPath = "//div[@class='box-appointmentdetail']//a[@title='Directions']";
	public static String step4AddtoCalendarButtonPath = "//div[@class='box-appointmentdetail']//a[@title='Add to Calendar']";
	public static String step4ShareButtonPath = "//div[@class='box-appointmentdetail']//a[@title='Share']";
	public static String step4VieworPrintDetailsButtonPath = "//div[@class='box-appointmentdetail']//a[@title='View or Print Details']";

	public static String step4PopupCancelButtonPath = "//div[@class='modal-content']//button[text()='Cancel']";
	public static String step4PopupPrintButtonPath = "//div[@class='modal-content']//button[text()='PRINT']";

	public static String popupImportActiveAppointmentsNowLinkPath = "//div[@id='import-appointments']//a[@title='Import Appointments Now']";
	public static String popupImportNotNowButtonPath = "//a[contains(.,'Not Now')]";
	public static String popupLoginandImportButtonPath = "//a[@title='Login & Import']";
	public static String popupImportInvalidEmailMessageLabelPath = "//div[text()='Please enter an email address']";
	public static String popupCancelButtonPath = "//a[text()='Cancel ']";
	public static String popupImportCloseIconPath = "//i[@class='icon icon-exc-close']";
	public static String popupcontinueWithMyeHealthButtonPath = "//button[contains(.,'Continue with')]";
	public static String popupswitchToMyResultsButtonPath = "//button[contains(.,'Switch')]";

	public static String stepBackTopButtonPath = "//button[@title='Back']";
	public static String fbTableRowsListPath = "//div[@id='future-bookings']//tbody//tr[@ng-repeat='item in futurebookings']";

	public static String importAppointmentsButtonPath = "//a[@title='Import Appointment']";
	public static String popupimportAppointmentTitlePath = "//h4[text()=' Import Appointments']";
	public static String popupimportAppointmentEmailTextBoxPath = "//form[@name='loginForm']//input[@type='email']";
	public static String popupimportAppointmentPasswordTextBoxPath = "//form[@name='loginForm']//input[@type='password']";
	public static String popupimportAppointmentForgotPasswordHyperLinkPath = "//form[@name='loginForm']//a[@title='Forgot your LifeLabs password?']";
	public static String popupimportAppointmentLoginButtonPath = "//a[@title='Login & Import']";
	public static String popupimportAppointmentCancelButtonPath = "//a[text()='Cancel ']";
	public static String popupImportAppointmentForgotPasswordEmailTextBoxPath = "//form[@name='forgotPasswordForm']//input[@name='email']";
	public static String popupImportAppointmentEMailResetPasswordInstrButtonPath = "//form[@name='forgotPasswordForm']//button[text()='Email Reset Password Instructions']";
	public static String popupImportAppointmentForgotpasswordCancelButtonPath = "//form[@name='forgotPasswordForm']//a[contains(.,'CANCEL')]";
	public static String popupImportAppointmentForgotpasswordCloseIconPath = "//div[@id='modalImportApt']//button[@data-dismiss='modal']";
	public static String popupImportAppointmentMessageLabelPath = "//p[contains(.,'An error has occurred while importing your appointments. Please contact us if you')]";

	public static String popupMergeCloseButtonPath = "//i[@class='icon icon-exc-cancel']";
	public static String popupMergeDuplicateAccountButtonPath = "//button[text()='Merge Duplicate Account']";
	public static String popupDeactivateduplicateAccountButtonPath = "//button[text()='De-activate Old Account']";

	public static String popupMergeAccountsPasswordTextBoxPath = "//input[@name='password']";
	public static String popupMergeAccountsLoginCloseButtonPath = "//input[@name='password']//parent::div//parent::div//parent::div[@class='modal-body']//preceding-sibling::div//div//i";
	public static String popupLoginandMergeAccountsButtonpath = "//div[@class='modal-footer btn-set']//child::button[@ng-click='mergenow()']";
	public static String popupMergeAccountsLoginCancelButtonPath = "//div[@class='modal-footer btn-set']//child::button[@ng-click='cancelall()']";
	public static String popupMergeAccountsLoginEmailLabelPath = "//input[@name='password']//parent::div//parent::div//preceding-sibling::div//b";

	public static String popupDeactiveOldAccountCloseIconPath = "//h4[text()=' De-activate Old LifeLabs.com Account']//parent::div//following-sibling::div//i[@class='icon icon-exc-cancel']";
	public static String popupDeactiveOldAccountButtonPath = "//h4[text()=' De-activate Old LifeLabs.com Account']//parent::div//following-sibling::div[@class='modal-footer btn-set']//button[contains(.,'De-activate Old Account')]";
	public static String popupDeactiveOldAccountCancelButtonPath = "//h4[text()=' De-activate Old LifeLabs.com Account']//parent::div//following-sibling::div[@class='modal-footer btn-set']//button[text()='Cancel']";

	public static String modalpopupTitlePath = " //span[contains(.,'Reset password Instructions sent')]";
	public static String modalpopupCloseIconPath = "//div[@class='alert alert-info alert-dismissible ng-scope']//i[@class='icon icon-exc-close']";

	public static String wrongpasswordErrorMessagePath = "//div[@id='appointmentstepthreeloginform']//span[contains(.,'The username or password you entered did not match our records. Try again or click')]";
	public static String forgotpasswordErrorHyperLinkPath = "//div[@id='appointmentstepthreeloginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Forgot password?')]";
	public static String needHelpLoginErrorHyperLinkPath = "//div[@id='appointmentstepthreeloginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Need help logging in or account locked?')]";
	public static String accountLockedMessagePath = "//div[@id='appointmentstepthreeloginform']//span[contains(.,'Your account has been locked from too many failed logins. Wait 4 hours before trying to log in again or click')]";
	public static String accountlockedNeedHelpHyperLinkPath = "//div[@id='appointmentstepthreeloginform']//div[@ng-message='locked']//a[contains(.,'Need help logging in or account locked?')]";
	public static String needHelpModalTitlePath = "//span[contains(.,'Help Logging in or Account Locked')]";
	public static String modalClickResetPasswordHyperLinkPath = "//p//a[contains(.,'click here to reset password.')]";
	public static String modalClickUnlockAccountPath = "//p//a[contains(.,'click here to unlock your account.')]";
	public static String modalCloseIconPath = "//button[@class='close']";

	/******** Appointment Booking ********/

	@FindBy(xpath = "//a[@title='Find a Location']")
	public static WebElement findlocationbutton;

	@FindBy(xpath = "//a[@title='Book Appointment']")
	public static WebElement bookappointmentbutton;

	@FindBy(xpath = "//span[text()='Import Appointments']")
	public static WebElement importappoitmentsbutton;

	@FindBy(xpath = "//a[@data-target='#future-bookings']")
	public static WebElement futurebookingstab;

	@FindBy(xpath = "//a[@data-target='#previous-bookings']")
	public static WebElement previousmonthstab;

	@FindBy(xpath = "//a[@data-target='#cancelled']")
	public static WebElement cancelledtab;

	@FindBy(xpath = "//div[@id='future-bookings']//thead//tr//th[text()='Date']")
	public static WebElement fbtabledatecolumn;

	@FindBy(xpath = "//div[@id='future-bookings']//thead//tr//th[text()='Name']")
	public static WebElement fbtablenamecolumn;

	@FindBy(xpath = "//div[@id='future-bookings']//thead//tr//th[text()='Address']")
	public static WebElement fbtableaddresscolumn;

	@FindBy(xpath = "//div[@id='future-bookings']//thead//tr//th[text()='Confirmation #']")
	public static WebElement fbtableconfirmationcolumn;

	@FindBy(xpath = "//div[@id='future-bookings']//thead//tr//th[text()='Info']")
	public static WebElement fbtableinfocolumn;

	@FindBy(xpath = "//div[@id='future-bookings']//thead//tr//th[text()='Actions']")
	public static WebElement fbtableactionscolumn;

	@FindBy(xpath = "//div[@class='row row-appointmenttest']/div[2]/div[not(contains(@class,'ng-hide'))]//a[contains(.,' Book an Appointment ')]") // div[@class='ng-hide']//following-sibling::div//a[contains(.,'
																																					// Book an Appointment ')]")
	public static WebElement bookanappoinmenthyperlink;

	@FindBy(xpath = "//a[contains(text(),'Click here')]")
	public static WebElement clickherehyperlink;

	@FindBy(xpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Date']")
	public static WebElement pmtabledatecolumn;

	@FindBy(xpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Name']")
	public static WebElement pmtablenamecolumn;

	@FindBy(xpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Address']")
	public static WebElement pmtableaddresscolumn;

	@FindBy(xpath = "//div[@id='previous-bookings']//thead//tr//th[text()='Confirmation #']")
	public static WebElement pmtableconfirmationcolumn;

	@FindBy(xpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Date']")
	public static WebElement candatecolumn;

	@FindBy(xpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Cancelled Date']")
	public static WebElement cancancelleddatecolumn;

	@FindBy(xpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Name']")
	public static WebElement cannamecolumn;

	@FindBy(xpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Address']")
	public static WebElement canaddresscolumn;

	@FindBy(xpath = "//div[@id='cancelledbookings']//thead//tr//th[text()='Confirmation #']")
	public static WebElement canconfirmationcolumn;

	@FindBy(xpath = "//h3[contains(.,'Find the LifeLabs location nearest you')]")
	public static WebElement findalocationTitleLabel;

	@FindBy(xpath = "//h3[contains(.,'Book an appointment at a LifeLabs location nearest you')]")
	public static WebElement bookanappointmentTitleLabel;

	@FindBy(xpath = "//ul[@class='list-checkboxs']//li")
	public static WebElement checkboxeslist;

	@FindBy(xpath = "//a[text()='Show more filters']")
	public static WebElement showmorefiltershyperlink;

	@FindBy(xpath = "//a[text()='Show less filters']")
	public static WebElement showLessfiltershyperlink;

	@FindBy(xpath = "//input[@type='text' and @ng-change='addressChanged()']")
	public static WebElement searchtextbox;

	@FindBy(xpath = "//a[text()='Use my location']")
	public static WebElement usemylocationhyperlink;

	@FindBy(xpath = "//span[@class='input-group-btn']//button")
	public static WebElement findsearchbutton;

	@FindBy(xpath = "//a[@title='Search Results']//parent::li[not(contains(@class,'active'))]")
	public static WebElement searchresultstabInActive;

	@FindBy(xpath = "//a[@title='Location Details']//parent::li[@class='ng-scope']")
	public static WebElement locationdetailstabInActive;

	@FindBy(xpath = "//a[@title='Search Results']//parent::li[@class='active']")
	public static WebElement searchresultstabActive;

	@FindBy(xpath = "//a[@title='Location Details']//parent::li[@class='ng-scope active']")
	public static WebElement locationdetailstabActive;

	@FindBy(xpath = "//a[text()='Show Filters']")
	public static WebElement showfiltershyperlink;

	@FindBy(xpath = "//a[text()='Hide Filters']")
	public static WebElement hidefiltershyperlink;

	@FindBy(xpath = "//div[@id='location-details']//a[text()='Directions']")
	public static WebElement locationdetailsDirectionshyperlink;

	@FindBy(xpath = "//div[@id='location-details']//h5[@ng-model='activeLocation']")
	public static WebElement locationcurrentwaittime;

	@FindBy(xpath = "//div[@id='map-container']//a[text()='Directions']")
	public static WebElement directionOnMapHyperLink;

	@FindBy(xpath = "//div[@id='googleMap']/div/div/div[1]/div[3]/div/div[4]/div/button")
	public static WebElement closeOnMapPopUpIcon;

	@FindBy(xpath = "//div[@id='map-container']//span[@class='pull-left']")
	public static WebElement currentwaittimeonMap;

	@FindBy(xpath = "//h5[text()=' Special Hours and Access']//i")
	public static WebElement specialhoursIcon;

	@FindBy(xpath = "//h5[text()=' Special Test Locations']//i")
	public static WebElement specialTestLocationIcon;

	@FindBy(xpath = "//span[@class='text-20 text-dark-blue icon icon-exc-filter-off-o']")
	public static WebElement nonselectedfilterIcon;

	@FindBy(xpath = "//span[@class='text-20 text-dark-blue icon icon-exc-filter-on']")
	public static WebElement selectedFilterIcon;

	@FindBy(xpath = "//a[@title='Back']")
	public static WebElement backButton;

	@FindBy(xpath = "//div[@id='location-details']//p[@class='alert-heading']//span")
	public static WebElement siteDetailAnnouncementMsgTitle;

	@FindBy(xpath = "//div[@id='location-details']//ul//div[contains(@class,'alert alert-info')]//p[2]")
	public static WebElement siteDetailAnnouncementMsgText;

	@FindBy(xpath = "//div[@id='directions-searchbox-1']//input[@class='tactile-searchbox-input']")
	public static WebElement mapsDestinationInput;

	@FindBy(xpath = "//div[@id='map-container']//a[contains(text(),'Details')]")
	public static WebElement detailsonMapPopUpHyperLink;

	@FindBy(xpath = "//div[@id='map-container']//h5[1]")
	public static WebElement streetNameOnMapPopUpHyperLink;

	@FindBy(xpath = "//link[contains(@title,'Google Maps')]")
	public static WebElement mapsTitle;

	@FindBy(xpath = "//div[@id='location-details']//div[@class='box-address']//h5")
	public static WebElement locationStreetName;

	@FindBy(xpath = "//div[@id='location-details']//div[@class='box-address']//a[@title='Directions']")
	public static WebElement locationDirectionsHyperLink;

	@FindBy(xpath = "//span[@ng-show='!showLocationDetails']//span")
	public static WebElement searchresultsCount;

	@FindBy(xpath = "//div[@id='location-details']//div[@class='box-address']//h5//span")
	public static WebElement locationCityName;

	@FindBy(xpath = "//a[text()='Directions']//parent::p//preceding-sibling::p")
	public static WebElement locationDistanceName;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[1]")
	public static WebElement locationtodayLabel;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[1]")
	public static WebElement locationtomorrowLabel;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[1]")
	public static WebElement locationdayaftertomorroLabel;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[2]//span")
	public static WebElement locationtodayTiming;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[2]//span")
	public static WebElement locationtomorrowTiming;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[2]//span")
	public static WebElement locationdayaftertomorrowTiming;

	@FindBy(xpath = "//div[@id='location-details']//a[@title='Book Appointment']")
	public static WebElement locationBookAppointmentButton;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[2]//i[contains(@class,'icon icon-exc-appointment-reminder text-green text-20')]")
	public static WebElement locationtodaysuccessIcon;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[2]//i[contains(@class,'icon icon-exc-appointment-reminder text-green text-20')]")
	public static WebElement locationtomorrowsuccessIcon;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[2]//i[contains(@class,'icon icon-exc-appointment-reminder text-green text-20')]")
	public static WebElement locationdayaftertomorrowsuccessIcon;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[1]/div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']")
	public static WebElement locationtodayfailIcon;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[2]/div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']")
	public static WebElement locationtomorrowfailIcon;

	@FindBy(xpath = "//div[@id='location-details']/ul/li/div[2]/div/div[3]/div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']")
	public static WebElement locationdayaftertomorrowfailIcon;

	@FindBy(xpath = "//button[@ng-click='cancelAppointment(modalAppointmentID)']")
	public static WebElement fbCancelPopYes;

	@FindBy(xpath = "//button[@ng-click='closeModalInfo()' and not (@class='close') ]")
	public static WebElement fbCancelPopNo;

	@FindBy(xpath = "//a[@class='link-light ng-binding' and text()='change location']")
	public static WebElement step2changelocationLink;

	@FindBy(xpath = "//div[@id='import-appointments']//a[@title='Import Appointments Now']")
	public static WebElement popupImportActiveAppointmentsNowLink;

	@FindBy(xpath = "//a[contains(.,'Not Now')]")
	public static WebElement popupImportNotNowButton;

	@FindBy(xpath = "//a[@title='Login & Import']")
	public static WebElement popupLoginandImportButton;

	@FindBy(xpath = "//div[text()='Please enter an email address']")
	public static WebElement popupImportInvalidEmailMessageLabel;

	@FindBy(xpath = "//a[text()='Cancel ']")
	public static WebElement popupCancelButton;

	@FindBy(xpath = "//i[@class='icon icon-exc-close']")
	public static WebElement popupImportCloseIcon;

	@FindBy(xpath = "//p[contains(text(),'Failed to load added patients')]")
	public static WebElement failedToLoadPatientText;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public static WebElement failedToLoadPatientOKButton;

	@FindBy(xpath = "//h4[text()=' Appointment Information']")
	public static WebElement fbPopupAppointmentTitleLabel;

	@FindBy(xpath = "//i[@class='icon icon-exc-cancel']")
	public static WebElement fbPopupAppointmentCloseIcon;

	@FindBy(xpath = "//p[@class='text-dark-blue text-bold ng-binding'][1]")
	public static WebElement fbPopupPersonNameLabel;

	@FindBy(xpath = "//p[@class='text-dark-blue text-bold ng-binding'][2]")
	public static WebElement fbPopupWhenlabel;

	@FindBy(xpath = "//p[@class='text-dark-blue text-bold no-b-mar ng-binding']")
	public static WebElement fbPopupLocationLabel;

	@FindBy(xpath = "//a[@title='Directions']//parent::p")
	public static WebElement fbPopupdistanceLabel;

	@FindBy(xpath = "//a[@title='Directions']")
	public static WebElement fbPopupDirectionsHyperLink;

	@FindBy(xpath = "//a[@title='Street view']")
	public static WebElement fbPopupStreetViewhyperLink;

	// index 0 = phonenumber 1 = fax number
	@FindBy(xpath = "//div[@class='text-normal ng-binding']")
	public static List<WebElement> fbPopupPhoneNumberLabellist;

	@FindBy(xpath = "//div[@class='text-bold ng-binding' and contains(.,'Fax:')]//following-sibling::div[@class='text-normal ng-binding']")
	public static WebElement fbPopupFaxNumberLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[4]/div[2]/p")
	public static WebElement fbPopupMondayLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[5]/div[2]/p")
	public static WebElement fbPopupTuesdayLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[6]/div[2]/p")
	public static WebElement fbPopupWednesdayLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[7]/div[2]/p")
	public static WebElement fbPopupThursdayLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[8]/div[2]/p")
	public static WebElement fbPopupFridayLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[9]/div[2]/p")
	public static WebElement fbPopupSaturdayLabel;

	@FindBy(xpath = "//div[@id='printAppointmentDetails']/div[10]/div[2]/p")
	public static WebElement fbPopupSundayLabel;

	@FindBy(xpath = "//a[@title='Add to Calendar']")
	public static WebElement fbPopupAddtoCalendarButton;

	@FindBy(xpath = "//a[@title='Share']")
	public static WebElement fbPopupSharebyEmailButton;

	@FindBy(xpath = "//button[@ng-click='cancelAppointment(modalAppointmentID)']")
	public static WebElement fbCancelAppointmentConfirmButton;

	@FindBy(xpath = "//a[@title='View or Print Details']")
	public static WebElement fbPopupVieworPrintDetailsButton;

	// All Steps titles
	@FindBy(xpath = "//ul[@class='list-appointment-steps four-steps']//li")
	public static List<WebElement> alltitlesList;

	@FindBy(xpath = "//ul[@class='list-appointment-steps four-steps']//li[@class='active']")
	public static WebElement activetitle;

	@FindBy(xpath = "//ul[@class='list-appointment-steps four-steps']//li[not(contains(@class,'active'))]")
	public static WebElement inactivetitllist;

	@FindBy(xpath = "//button[contains(.,'Continue with')]")
	public static WebElement popupcontinueWithMyeHealthButton;

	@FindBy(xpath = "//button[contains(.,'Switch')]")
	public static WebElement popupswitchToMyResultsButton;

	// Step1
	@FindBy(xpath = "//span[text()='Patient Instructions']")
	public static WebElement step1patientinstructionsTitle;

	@FindBy(xpath = "//button[@name='primary' and @class='btn btn-primary btn-next btn-next-top ng-binding']")
	public static WebElement step1nexttopbutton;

	@FindBy(xpath = "//p[@class='mb-20']//button[@name='primary' and @class='btn btn-primary btn-next ng-binding']")
	public static WebElement step1nextBottomButton;

	@FindBy(xpath = "//a[text()='www.lifelabs.com']")
	public static WebElement step1LifeLabsHyperLink;

	/// changing the xpath to make the script work for both ON and BC
	@FindBy(xpath = "//button[contains(.,'Continue with')]")
	public static WebElement step1locationpopupBCMyehealthButton;

	/// changing the xpath to make the script work for both ON and BC
	@FindBy(xpath = "//button[contains(.,'Switch to')]")
	public static WebElement step1locationpopupBCMyResultsButton;

	@FindBy(xpath = "//button[contains(.,'Continue with my results')]")
	public static WebElement step1locationpopupONMyehealthButton;

	@FindBy(xpath = "//button[contains(.,'Switch to my ehealth')]")
	public static WebElement step1locationpopupONMyResultsButton;

	// Step2
	@FindBy(xpath = "//a[@ng-click='selectAppointmentTab(2)']")
	public static WebElement step2dateandtimeTitle;

	@FindBy(xpath = "//a[@class='link-light ng-binding' and text()='change location']")
	public static WebElement step2changelocationlink;

	@FindBy(xpath = "//h4[@class='text-dark-blue mb20 ng-binding']")
	public static WebElement step2streetname;

	@FindBy(xpath = "//span[@class='icon icon-exc-info-help-tip']")
	public static WebElement step2InfoIcon;

	@FindBy(xpath = "//h4[@class='text-dark-blue ng-binding']")
	public static WebElement step2selectedtimeslotText;

	@FindBy(xpath = "//label[contains(.,'Include surrounding labs')]")
	public static WebElement step2IncludesurrondingCheckBox;

	@FindBy(xpath = "//i[@class='icon-exc-drop-down-menu-left']")
	public static WebElement step2calendarbackIcon;

	@FindBy(xpath = "//i[@class='icon-exc-drop-down-menu-right']")
	public static WebElement step2calendarforwardIcon;

	@FindBy(xpath = "//div[@class='calendar-header']//h3")
	public static WebElement step2calendarmonthTitle;

	@FindBy(xpath = "//i[@class='icon icon-exc-close text-red']//parent::span//parent::div[@class='cal-month-day cal-day-inmonth' or @class='cal-month-day cal-day-inmonth cal-day-weekend' or @class='cal-month-day cal-day-inmonth cal-day-today valid active']//span[2]")
	public static List<WebElement> step2calendarcloseiconList;

	@FindBy(xpath = "//div[@class='cal-cell1 cal-cell']//i[@class='icon icon-exc-success-5 text-green']//parent::span//parent::div[@tabindex='0']")
	public static List<WebElement> step2calendaravailableiconList;

	@FindBy(xpath = "//div[contains(@class,'valid active')]//span[1]")
	public static WebElement step2calendarselectedDate;
	////////
	// @FindBy(xpath = "//div[@tabindex='0']//span[not(@class='text-available
	//////// ng-scope')]")
	@FindBy(xpath = "//i[@class='icon icon-exc-success-5 text-green']//parent::span//parent::div[@class='cal-month-day cal-day-inmonth' or @class='cal-month-day cal-day-inmonth cal-day-weekend cal-day-today valid active' or @class='cal-month-day cal-day-outmonth cal-day-weekend' or @class='cal-month-day cal-day-inmonth cal-day-weekend' or @class='cal-month-day cal-day-inmonth cal-day-today valid active']//span[1]")
	public static List<WebElement> step2CalendarAvailableDateList;

	@FindBy(xpath = "//i[@class='icon icon-exc-close text-red']//parent::span//parent::div[@class='cal-month-day cal-day-inmonth' or @class='cal-month-day cal-day-inmonth cal-day-weekend cal-day-today valid active' or @class='cal-month-day cal-day-outmonth cal-day-weekend' or @class='cal-month-day cal-day-inmonth cal-day-weekend' or @class='cal-month-day cal-day-inmonth cal-day-today valid active']//span[1]")
	public static List<WebElement> step2calendarnotavailabledatesList;

	////////////
	@FindBy(xpath = "//ul[@class='list-timebtns']//li")
	public static List<WebElement> step2TimeSlotAvailableDateList;

	@FindBy(xpath = "//a[@class='btn-time']")
	public static List<WebElement> step2UnSelectedTimeSlotButtonsList;

	@FindBy(xpath = "//a[@class='btn-time active']")
	public static WebElement step2SelectedTimeSlotButton;

	@FindBy(xpath = "//button[@title='Back']")
	public static WebElement step2BackTopButton;

	@FindBy(xpath = "//button[@class= 'btn btn-primary btn-next btn-next-top ng-binding' and @title='NEXT']")
	public static WebElement step2nextTopButton;

	@FindBy(xpath = "//div[@class='col-md-6']//button[@title='Next']")
	public static WebElement step2nextBottomButton;

	@FindBy(xpath = "//th[text()='Time']")
	public static WebElement step2SurroundingLabTableHeaderTime;

	@FindBy(xpath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//button//span[@class='icon icon-exc-info-help-tip']")
	public static List<WebElement> step2SurroundingLabTableInfoiconlist;

	@FindBy(xpath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//tr[@ng-repeat='item in surroundingLabsTableCollection']//td[1]")
	public static List<WebElement> step2SurroundingLabTableTimeList;

	@FindBy(xpath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//tr[@ng-repeat='item in surroundingLabsTableCollection']//td[2]")
	public static List<WebElement> step2SurroundingLabTableAddressList;

	@FindBy(xpath = "//div[@id='appointments']//div[2]//div[2]//table//tbody//tr[@ng-repeat='item in surroundingLabsTableCollection']//td[3]")
	public static List<WebElement> step2SurroundingLabTableDistanceList;

	@FindBy(xpath = "//div[@class='box-time ng-scope']//div[contains(.,'There are no appointment times for the selected date. Select another date or include surrounding labs to see if they have available appointment times for this date.')]")
	public static WebElement step2NoAppointmentMessageLabel;

	@FindBy(xpath = "//text()[contains(.,'Location Information')]")
	public static WebElement step2infopopupTitle;

	@FindBy(xpath = "//a[@title='Directions' and @class='link-light ng-binding' and text()='Directions']")
	public static WebElement step2infopopupDirectionsHyperLink;

	@FindBy(xpath = "//a[@title='Street view' and @class='link-light ng-binding' and text()='Street view']")
	public static WebElement step2infopopupStreetViewHyperLink;

	@FindBy(xpath = "//div[@class='modal-body']//h5[1]")
	public static WebElement step2infopopupStreetnameLabel;

	@FindBy(xpath = "//div[@class='modal-body']//p[@class='mt-5 ng-binding'][1]")
	public static WebElement step2infopopupDistanceLabel;

	@FindBy(xpath = "//div[contains(.,'Phone')]//a[contains(@href,'tel')]")
	public static WebElement step2infopopupPhoneNumberLabel;

	@FindBy(xpath = "//div[@class='row-timeing mb-10']//div[@class='text-normal']")
	public static WebElement step2infopopupFaxNumberLabel;

	@FindBy(xpath = "//p[contains(.,'Mon')]")
	public static WebElement step2infopopupHoursOpenMontoFriLabel;

	@FindBy(xpath = "//p[contains(.,'Sat')]")
	public static WebElement step2infopopupHoursOpenSaturdayLabel;

	@FindBy(xpath = "//p[contains(.,'Sun')]")
	public static WebElement step2infopopupHoursOpenSundayLabel;

	@FindBy(xpath = "//i[@class='icon icon-exc-cancel']")
	public static WebElement step2infopopupCloseIcon;

	@FindBy(xpath = "//a[@title='Add to Calendar']")
	public static WebElement step2infopopupAddtoCalendarButton;

	@FindBy(xpath = "//a[@title='Share']")
	public static WebElement step2infopopupSharebyEmailButton;

	@FindBy(xpath = "//a[@title='View or Print Details']")
	public static WebElement step2infopopupVieworPrintDetailsButton;
	// Step3
	@FindBy(xpath = "//span[contains(.,'Account')]")
	public static WebElement step3AccountTitle;

	@FindBy(xpath = "//input[@id='emailInput']")
	public static WebElement step3useremailTextBox;

	@FindBy(xpath = "//input[@id='passwordInput']")
	public static WebElement step3passwordTextBox;

	@FindBy(xpath = "//a[text()='Forgot password?']")
	public static WebElement step3forgotpasswordHyperLink;

	@FindBy(xpath = "//input[@typeof='email']")
	public static WebElement step3forgotpasswordEmailTextBox;

	@FindBy(xpath = "//button[text()='SEND']")
	public static WebElement step3forgotpasswordSendButton;

	@FindBy(xpath = "//a[@ng-click='clearFormData()' and contains(.,'CONTINUE')]")
	public static WebElement step3forgotpasswordContinueButton;

	@FindBy(xpath = "//a[@ng-click='initForgotPasswordFormData()' and text()='CANCEL']")
	public static WebElement step3forgotpasswordCancelButton;

	@FindBy(xpath = "//label[text()='We have received your password change request']")
	public static WebElement step3ChangepasswordConfirmLabel;

	@FindBy(xpath = "//a[@ng-click='clearFormData()' and contains(.,'CONTINUE')]")
	public static WebElement step3ChangepasswordContinueButton;

	@FindBy(xpath = "//button[text()='BACK']")
	public static WebElement step3BacktopButton;

	@FindBy(xpath = "//div[@class='col-xs-3 col-sm-3 col-md-3 text-right ng-scope']//button[@title='Next']")
	public static WebElement step3nexttopButton;

	@FindBy(xpath = "//p//button[text()='Login']")
	public static WebElement step3loginButton;

	@FindBy(xpath = "//button[@title='CREATE ACCOUNT']")
	public static WebElement step3CreateAccountButton;

	@FindBy(xpath = "//label[text()='First Name*']//following-sibling::input")
	public static WebElement step3FirstNameTextBox;

	@FindBy(xpath = "//label[text()='Last Name*']//following-sibling::input")
	public static WebElement step3LastNameTextBox;

	@FindBy(xpath = "//label[text()='Phone Number*']//following-sibling::input")
	public static WebElement step3PhoneNumberTextBox;

	@FindBy(xpath = "//div[contains(@ng-init, 'provinceList')]")
	public static WebElement step3ProvinceComboBox;

	@FindBy(xpath = "//select//option[@ng-repeat='item in provinceList']")
	public static List<WebElement> step3ProvinceList;

	@FindBy(xpath = "//label[contains(text(),'Email*')]//following-sibling::input")
	public static WebElement step3EmailTextBox;

	@FindBy(xpath = "//label[contains(text(),'Retype email to confirm it*')]//following-sibling::input")
	public static WebElement step3ReTypeEmailTextBox;

	@FindBy(xpath = "//label[contains(text(),'Password*')]//following-sibling::input")
	public static WebElement step3PasswordTextBox;

	@FindBy(xpath = "//label[contains(text(),'Retype password to confirm it*')]//following-sibling::input")
	public static WebElement step3ReTypePasswordTextBox;

	@FindBy(xpath = "//input[@id='confirmation']//parent::div//span")
	public static WebElement step3ReceieveEmailCheckBox;

	@FindBy(xpath = "//input[@id='confirmationSurvey']//parent::div//span")
	public static WebElement step3ReceieveSurveyCheckBox;

	@FindBy(xpath = "//input[@id='terms']//parent::div//span")
	public static WebElement step3AgreeTermsCheckBox;

	@FindBy(xpath = "//button[@title='Verify Email']")
	public static WebElement step3VerifyEmailButton;

	@FindBy(xpath = "//h5[text()='We have sent an account verification email to']")
	public static WebElement step3LiteAccountSucessmessageLabel;

	@FindBy(xpath = "//div[@ng-if='emailVerificationLinkInfo']//a[@target='_blank']")
	public static WebElement step3LiteAccountActivationURLLabel;

	@FindBy(xpath = "//div[@class='list-enter-code']//input")
	public static WebElement step3SixDigitTextBox;

	@FindBy(xpath = "//a[text()='Didn’t get an email?']")
	public static WebElement step3DidntgetEmailHyperLink;

	@FindBy(xpath = "//a[@title='CREATE ACCOUNT']")
	public static WebElement step3CreateAccountButton2;

	@FindBy(xpath = "//a[@title='SEND A NEW CODE']")
	public static WebElement step3SendNewCodeButton;

	@FindBy(xpath = "//div[@class='box-confirm ng-scope']//p[@class='text-dark-blue  text-bold text-18 ng-binding']")
	public static WebElement step3WhenTimeLabel;

	@FindBy(xpath = "//div[@class='box-confirm ng-scope']//p[@class='text-dark-blue  text-bold text-18 mb-20 ng-binding']")
	public static WebElement step3locationLabel;

	@FindBy(xpath = "//div[@class='validation-error-messages ng-scope']//div[contains(.,'You must agree to the Terms of use and Privacy Policy to proceed.')]")
	public static WebElement step3MustAgreeWarningLabel;

	@FindBy(xpath = "//div[@id='account']//a[contains(.,'Terms of Use')]")
	public static WebElement step3TermsofUseHyperLink;

	@FindBy(xpath = "//div[@id='account']//a[contains(.,'Privacy Policy')]")
	public static WebElement step3PrivacyPolicyHyperLink;

	@FindBy(xpath = "//input[@ng-model='forgotPasswordFormData.emailAddress']")
	public static WebElement step3ForgotPasswordEmailTextBox;

	// Step4

	@FindBy(xpath = "//li//span[contains(.,'Confirm')]")
	public static WebElement step4Title;

	@FindBy(xpath = "//h4[contains(.,'Your appointment has been booked!')]")
	public static WebElement step4ConfirmTitle;

	@FindBy(xpath = "//div[@class='timer ng-binding']")
	public static WebElement step4TimeRemainingLabel;

	@FindBy(xpath = "//button[@class='multiselect dropdown-toggle btn btn-default']")
	public static WebElement step4UserCombobox;

	@FindBy(xpath = "//ul[@class='multiselect-container dropdown-menu']//li//label//div")
	public static List<WebElement> step4UserComboboxList;

	@FindBy(xpath = "//ul[@class='multiselect-container dropdown-menu']//li[@class='active']")
	public static WebElement step4SelectedUserCombobox;

	@FindBy(xpath = "//input[@name='newFirstName']")
	public static WebElement step4FirstNameInput;

	@FindBy(xpath = "//input[@name='newLastName']")
	public static WebElement step4LastNameInput;

	@FindBy(xpath = "//p[@class='text-dark-blue  text-bold text-18 ng-binding']")
	public static WebElement step4WhenLabel;

	@FindBy(xpath = "//p[@class='text-dark-blue  text-bold text-18 mb-20']")
	public static WebElement step4LocationLabel;

	@FindBy(xpath = "//div[@id='appointments']/div/div/div[3]/div[1]/div[3]/div[3]//button[@title='Confirm Appointment']")
	public static WebElement step4ConfirmAppointment;

	@FindBy(xpath = "//button[@id='btnNavConfirmAppointment' and contains(.,'Confirm Appointment')]")
	public static WebElement step4ConfirmAppointmentTopButton;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-next btn-next-top ng-binding']")
	public static WebElement step4TopConfirmAppointment;

	@FindBy(xpath = "//h4[text()='Your appointment has been booked!']")
	public static WebElement step4AppointmentconformLabel;

	@FindBy(xpath = "//div[@class='box-appointmentdetail']//a[@title='Directions']")
	public static WebElement step4DirectionButton;

	@FindBy(xpath = "//div[@class='box-appointmentdetail']//a[@title='Add to Calendar']")
	public static WebElement step4AddtoCalendarButton;

	@FindBy(xpath = "//div[@class='box-appointmentdetail']//a[@title='Share']")
	public static WebElement step4ShareButton;

	@FindBy(xpath = "//div[@class='box-appointmentdetail']//a[@title='View or Print Details']")
	public static WebElement step4VieworPrintDetailsButton;

	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	public static WebElement step4PopupCancelButton;

	@FindBy(xpath = "//button[contains(.,'Print')]")
	public static WebElement step4PopupPrintButton;

	@FindBy(xpath = "//div[@class='timer ng-binding']")
	public static WebElement step4TimeRemaining;

	@FindBy(xpath = "//html//body//div[3]//div//a[@id='extendTimeoutBtn']")
	public static WebElement step4PopupExtendTimeButton;

	@FindBy(xpath = "//html/body/div[3]//div//a[@title='Discard Appointment']")
	public static WebElement step4PopupDiscardButton;

	@FindBy(xpath = "//a[@title='Okay']")
	public static List<WebElement> step4PopupTimeoutConfirmOKButtonList;

	@FindBy(xpath = "//p[text()='The confirmation period has timed out. Please check the selected date and time again']")
	public static List<WebElement> step4PopupTimeoutTitleLabelList;

	@FindBy(xpath = "//input[@ng-model='accountProfileInfo.PhoneNumber']")
	public static WebElement step4PhonenumberTextBox;

	@FindBy(xpath = "//input[@ng-model='accountProfileInfo.PhoneNumber']//parent::li//div[contains(.,'This is a required field') and @class='ng-binding ng-scope']")
	public static WebElement step4PhonenumberWarningLabel;

	@FindBy(xpath = "//input[@ng-model='accountProfileInfo.PhoneNumber']//parent::li//div[contains(.,'Invalid phone number') and @class='validation-error-messages ng-binding ng-scope']")
	public static WebElement step4PhonenumberInvalidLabel;

	@FindBy(xpath = "//input[@name='newFirstName']")
	public static WebElement step4AdhocFirstNameTextBox;

	@FindBy(xpath = "//input[@name='newLastName']")
	public static WebElement step4AdhocLastNameTextBox;

	@FindBy(xpath = "//div[@id='appointmentsbookingsuccess']/ol/li[1]/div/div[2]/div[1]/div[1]/div/div/div/div")
	public static WebElement step4AdhocFirstnameRequiredLabel;

	@FindBy(xpath = "//div[@id='appointmentsbookingsuccess']/ol/li[1]/div/div[2]/div[1]/div[2]/div/div/div/div")
	public static WebElement step4AdhocLastnameRequiredLabel;

	@FindBy(xpath = "//i[@class='icon icon-exc-add-member  text-light-blue']")
	public static WebElement step4AdhocUserIcon;

	@FindBy(xpath = "//p[contains(.,'A verification email has been sent to')]")
	public static WebElement step4EmailSentLabel;

	@FindBy(xpath = "//h4[text()=' Import Appointments']")
	public static WebElement popupimportAppointmentTitle;

	@FindBy(xpath = "//form[@name='loginForm']//input[@type='email']")
	public static WebElement popupimportAppointmentEmailTextBox;

	@FindBy(xpath = "//form[@name='loginForm']//input[@type='password']")
	public static WebElement popupimportAppointmentPasswordTextBox;

	@FindBy(xpath = "//form[@name='loginForm']//a[@title='Forgot your LifeLabs password?']")
	public static WebElement popupimportAppointmentForgotPasswordHyperLink;

	@FindBy(xpath = "//a[@title='Login & Import']")
	public static WebElement popupimportAppointmentLoginButton;

	@FindBy(xpath = "//a[text()='Cancel ']")
	public static WebElement popupimportAppointmentCancelButton;

	@FindBy(xpath = "//form[@name='forgotPasswordForm']//input[@name='email']")
	public static WebElement popupImportAppointmentForgotPasswordEmailTextBox;

	@FindBy(xpath = "//form[@name='forgotPasswordForm']//button[text()='Email Reset Password Instructions']")
	public static WebElement popupImportAppointmentEMailResetPasswordInstrButton;

	@FindBy(xpath = "//form[@name='forgotPasswordForm']//a[contains(.,'CANCEL')]")
	public static WebElement popupImportAppointmentForgotpasswordCancelButton;

	@FindBy(xpath = "//div[@id='modalImportApt']//button[@data-dismiss='modal']")
	public static WebElement popupImportAppointmentForgotpasswordCloseIcon;

	@FindBy(xpath = "//p[contains(.,'An error has occurred while importing your appointments. Please contact us if you')]")
	public static WebElement popupImportAppointmentMessageLabel;

	@FindBy(xpath = "//span[contains(.,'Reset password Instructions sent')]")
	public static WebElement modalpopupTitle;

	@FindBy(xpath = "//span[contains(.,'Email address not found.')]")
	public static WebElement modalpopupEmailNotFoundTitle;

	@FindBy(xpath = "//div[@class='alert alert-info alert-dismissible ng-scope']//i[@class='icon icon-exc-close']")
	public static WebElement modalpopupCloseIcon;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']")
	public static List<WebElement> locationsresultlist;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//a[text()='Directions']")
	public static List<WebElement> directionslist;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//a[contains(.,'Book Appointment')]")
	public static List<WebElement> bookappointmentlist;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//a[text()='Details']")
	public static List<WebElement> detailshyperlinklist;

	@FindBy(xpath = "//div[@id='googleMap']/div/div/div[1]/div[3]/div/div[3]/div")
	public static List<WebElement> mapiconslist;

	@FindBy(xpath = "//ul[@class='list-checkboxs']//li//div[@class='checkbox-btn']//span")
	public static List<WebElement> filterscheckboxlist;

	@FindBy(xpath = "//ul[@class='list-checkboxs']//li//div[@class='checkbox-btn']//span//parent::div//input[@ng-checked='true']")
	public static List<WebElement> checkedfilterscheckboxlist;

	@FindBy(xpath = "//ul[@class='list-checkboxs']//li//label")
	public static List<WebElement> filterscheckboxLabelList;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//h5//span")
	public static List<WebElement> citynameList;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//div[@class='box-address']//h5")
	public static List<WebElement> streetnameList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[2]//div[2]//span")
	public static List<WebElement> todaytimeList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[3]//div[2]//span")
	public static List<WebElement> tomorrowtimeList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[4]//div[2]//span")
	public static List<WebElement> dayaftertimeList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[2]//div[2]//i[@class='icon icon-exc-appointment-reminder text-green text-20']")
	public static List<WebElement> todaysuccessIconList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[3]//div[2]//i[@class='icon icon-exc-appointment-reminder text-green text-20']")
	public static List<WebElement> tomorrowsuccessIconList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[4]//div[2]//i[@class='icon icon-exc-appointment-reminder text-green text-20']")
	public static List<WebElement> dayaftertomorrowsuccessIconList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[2]//div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']")
	public static List<WebElement> todayfailIconList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[3]//div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']")
	public static List<WebElement> tomorrowfailIconList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[4]//div[2]//i[@class='icon icon-exc-missed-appointment text-red text-20']")
	public static List<WebElement> dayaftertomorrowfailIconList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[2]//div[1]")
	public static List<WebElement> todayLabelList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[3]//div[1]")
	public static List<WebElement> tomorrowlabelList;

	@FindBy(xpath = "//div[contains(@id,'mCSB')]/ul/li//div//div//div[4]//div[1]")
	public static List<WebElement> dayaftertomorrowLabelList;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//a[text()='Directions']//parent::p")
	public static List<WebElement> searchdistanceList;

	@FindBy(xpath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder']//span[@class='hidden-xs ng-binding']")
	public static List<WebElement> candatecolumnDataList;

	@FindBy(xpath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder']//td[@ng-show='cancelAppointmentRowCount > 0'][1]")
	public static List<WebElement> cancancelleddatecolumnDataList;

	@FindBy(xpath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder']//td[@ng-show='cancelAppointmentRowCount > 0'][2]")
	public static List<WebElement> cannamecolumnDataList;

	@FindBy(xpath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder']//td[@ng-show='cancelAppointmentRowCount > 0'][3]")
	public static List<WebElement> canaddresscolumnDataList;

	@FindBy(xpath = "//div[@id='cancelledbookings']//tbody//tr[@ng-repeat='item in cancelledbookings | orderBy:itemSortOrder']//td[@ng-show='cancelAppointmentRowCount > 0'][4]")
	public static List<WebElement> canconfirmationcolumnDataList;

	@FindBy(xpath = "//li[@ng-repeat='location in locations']//h5[@ng-show='location.Availability_Today && location.Show_Wait_Time']")
	public static List<WebElement> searchWaitTimeList;

	@FindBy(xpath = "//tbody[@ng-init='previousDropdownMenuIconShow(0)']//td[contains(.,'No appointments have been booked in the past 3 months')]")
	public static WebElement pmtableconsisemessage;

	@FindBy(xpath = "//tbody[@ng-init='futureDropdownMenuIconShow(0)']//td[contains(.,'There are no booked appointments')]")
	public static WebElement fbtableconsisemessage;

	@FindBy(xpath = "//div[@id='cancelledbookings']//tbody//h5[contains(.,'There are no cancelled appointments')]")
	public static WebElement canconsisemessage;

	@FindBy(xpath = "//div[@ng-if='displayTopAnnouncementMessage']//button[@class='close']")
	public static WebElement announcementAllLocationClose;

	@FindBy(xpath = "//div[@ng-if='displayTopAnnouncementMessage']//p[@class!='alert-heading']")
	public static WebElement announcementAllLocationText;

	@FindBy(xpath = "//p[text()[contains(.,'This action will discard your appointment booking session. Do you wish to continue?')]]")
	public static WebElement discardAppointmentSessionPopup;

	@FindBy(xpath = "//p[text()[contains(.,'discard your appointment booking session')]]/ancestor::div[@class='modal-content']//button[text()='OK']")
	public static WebElement discardAppointmentSessionPopupOK;

	@FindBy(xpath = "//p[text()[contains(.,'discard your appointment booking session')]]/ancestor::div[@class='modal-content']//button[text()='CANCEL']")
	public static WebElement discardAppointmentSessionPopupCancel;

	@FindBy(xpath = "//button[@title='Back']")
	public static WebElement stepBackTopButton;

	@FindBy(xpath = "//div[@id='future-bookings']//tbody//tr[@ng-repeat='item in futurebookings']")
	public static List<WebElement> fbTableRows;

	@FindBy(xpath = "//button[text()='Merge Duplicate Account']")
	public static WebElement popupMergeDuplicateAccountButton;

	@FindBy(xpath = "//button[text()='De-activate Old Account']")
	public static WebElement popupDeactivateduplicateAccountButton;

	@FindBy(xpath = "//i[@class='icon icon-exc-cancel']")
	public static WebElement popupMergeCloseButton;

	@FindBy(xpath = "//input[@name='password']")
	public static WebElement popupMergeAccountsPasswordTextBox;

	@FindBy(xpath = "//input[@name='password']//parent::div//parent::div//parent::div[@class='modal-body']//preceding-sibling::div//div//i")
	public static WebElement popupMergeAccountsLoginCloseButton;

	@FindBy(xpath = "//div[@class='modal-footer btn-set']//child::button[@ng-click='mergenow()']")
	public static WebElement popupLoginandMergeAccountsButton;

	@FindBy(xpath = "//div[@class='modal-footer btn-set']//child::button[@ng-click='cancelall()']")
	public static WebElement popupMergeAccountsLoginCancelButton;

	@FindBy(xpath = "//h4[text()=' De-activate Old LifeLabs.com Account']//parent::div//following-sibling::div//i[@class='icon icon-exc-cancel']")
	public static WebElement popupDeactiveOldAccountCloseIcon;

	@FindBy(xpath = "//h4[text()=' De-activate Old LifeLabs.com Account']//parent::div//following-sibling::div[@class='modal-footer btn-set']//button[contains(.,'De-activate Old Account')]")
	public static WebElement popupDeactiveOldAccountButton;

	@FindBy(xpath = "//h4[text()=' De-activate Old LifeLabs.com Account']//parent::div//following-sibling::div[@class='modal-footer btn-set']//button[text()='Cancel']")
	public static WebElement popupDeactiveOldAccountCancelButton;

	@FindBy(xpath = "//input[@name='password']//parent::div//parent::div//preceding-sibling::div//b")
	public static WebElement popupMergeAccountsLoginEmailLabel;

	@FindBy(xpath = "//div[@id='appointmentstepthreeloginform']//span[contains(.,'The username or password you entered did not match our records. Try again or click')]")
	public static WebElement wrongpasswordErrorMessage;

	@FindBy(xpath = "//div[@id='appointmentstepthreeloginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Forgot password?')]")
	public static WebElement forgotpasswordErrorHyperLink;

	@FindBy(xpath = "//div[@id='appointmentstepthreeloginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Need help logging in or account locked?')]")
	public static WebElement needHelpLoginErrorHyperLink;

	@FindBy(xpath = "//div[@id='appointmentstepthreeloginform']//span[contains(.,'Your account has been locked from too many failed logins. Wait 4 hours before trying to log in again or click')]")
	public static WebElement accountLockedMessage;

	@FindBy(xpath = "//div[@id='appointmentstepthreeloginform']//div[@ng-message='locked']//a[contains(.,'Need help logging in or account locked?')]")
	public static WebElement accountlockedNeedHelpHyperLink;

	@FindBy(xpath = "//span[contains(.,'Help Logging in or Account Locked')]")
	public static WebElement needHelpModalTitle;

	@FindBy(xpath = "//p//a[contains(.,'click here to reset password.')]")
	public static WebElement modalClickResetPasswordHyperLink;

	@FindBy(xpath = "//p//a[contains(.,'click here to unlock your account.')]")
	public static WebElement modalClickUnlockAccount;

	@FindBy(xpath = "//button[@class='close']")
	public static WebElement modalCloseIcon;

	public static AppointmentsSearchDataBean setDatatoObject(JSONObject dataobject) {
		AppointmentsSearchDataBean apb = new AppointmentsSearchDataBean();
		try {
			JSONObject waittimeobject = new JSONObject();
			waittimeobject = dataobject.getJSONObject("WaitTime");
			WaitTimeBean waittime = new WaitTimeBean(waittimeobject.getInt("SiteID"), waittimeobject.getInt("Wait"));

			JSONObject announcemessageObject = new JSONObject();
			announcemessageObject = dataobject.getJSONObject("AnnouncementMessage");
			AnnouncementMessageBean announcemessage = new AnnouncementMessageBean(announcemessageObject.getString("Title"), announcemessageObject.getString("Message"));

			ArrayList<OperatingHoursBean> operatingHoursList = new ArrayList<OperatingHoursBean>();

			JSONArray jsonarray = dataobject.getJSONArray("OperatingHours");
			for (int k = 0; k < jsonarray.length(); k++) {
				JSONObject object = new JSONObject(jsonarray.get(k).toString());

				operatingHoursList.add(new OperatingHoursBean(object.getInt("SiteID"), object.getInt("DayOfTheWeek"), object.getString("OpenTime"), object.getString("CloseTime"), object.getBoolean("Closed")));
			}

			apb = new AppointmentsSearchDataBean(dataobject.getInt("SiteID"), dataobject.getString("Site_name"), dataobject.getString("Street_Num"), dataobject.getString("Street_Name"), dataobject.getString("Street_Type"), dataobject.getString("Street_Direction"), dataobject.getString("Unit_Type"), dataobject.getString("Unit_Num"), dataobject.getString("Location"), dataobject.getString("Address1"), dataobject.getString("City"), dataobject.getString("State"), dataobject.getString("Zip"), dataobject.getString("Phone"), dataobject.getString("Hours"), dataobject.getString("Map_Address"), operatingHoursList.toArray(new OperatingHoursBean[operatingHoursList.size()]), waittime, dataobject.getDouble("Distance"), dataobject.getDouble("Latitude"), dataobject.getDouble("Longitude"), dataobject.getBoolean("Open_Early"), dataobject.getBoolean("Open_Sundays"), dataobject.getBoolean("Open_Saturdays"), dataobject.getBoolean("Wheelchair_Accessible"), dataobject.getString("Open_Hours_Today"), dataobject.getString("Open_Hours_Tomorrow"), dataobject.getString("Open_Hours_DayAfterTomorrow"), dataobject.getBoolean("Availability_Today"), dataobject.getBoolean("Availability_Tomorrow"), dataobject.getBoolean("Availability_DayAfterTomorrow"), dataobject.getString("Open_Hours_WeekDays"), dataobject.getString("Open_Hours_Saturday"), dataobject.getString("Open_Hours_Sunday"), dataobject.getString("Fax"), dataobject.getString("AdditionalSiteInformation"), announcemessage, dataobject.getBoolean("Show_Wait_Time"), dataobject.getBoolean("GetCheckedOnline"), dataobject.getBoolean("AutismServices"), dataobject.getBoolean("Does24HourHolterMonitoring"), dataobject.getBoolean("DoesAmbulatoryBloodPressureMonitoring"), dataobject.getBoolean("DoesEcg"), dataobject.getBoolean("OntarioHealthStudy"), dataobject.getBoolean("Closed"), dataobject.getBoolean("PermanentlyClosed"), dataobject.getBoolean("IsClosedToday"), dataobject.getBoolean("IsClosedTomorrow"), dataobject.getBoolean("IsClosedDayAfterTomorrow")

			);
		} catch (Exception e) {
			apb = new AppointmentsSearchDataBean(dataobject.getInt("SiteID"), dataobject.getString("Site_name"), dataobject.getString("Street_Num"), dataobject.getString("Street_Name"), dataobject.getString("Street_Type"), dataobject.getString("Street_Direction"), dataobject.getString("Unit_Type"), dataobject.getString("Unit_Num"), dataobject.getString("Location"), dataobject.getString("Address1"), dataobject.getString("City"), dataobject.getString("State"), dataobject.getString("Zip"), dataobject.getString("Phone"), dataobject.getString("Hours"), dataobject.getString("Map_Address"), dataobject.getDouble("Distance"), dataobject.getDouble("Latitude"), dataobject.getDouble("Longitude"), dataobject.getBoolean("Open_Early"), dataobject.getBoolean("Open_Sundays"), dataobject.getBoolean("Wheelchair_Accessible"), dataobject.getString("Open_Hours_Today"), dataobject.getString("Open_Hours_Tomorrow"), dataobject.getString("Open_Hours_DayAfterTomorrow"), dataobject.getBoolean("Availability_Today"), dataobject.getBoolean("Availability_Tomorrow"), dataobject.getBoolean("Availability_DayAfterTomorrow"));
		}

		return apb;
	}

	public static SurroundingLabsBean setSurroundingLabsDatatoObjects(JSONObject dataobject) {
		// JSONArray dateslotarray = new JSONArray();
		// dateslotarray = dataobject.getJSONArray("Slots");
		// DateSlotsBean[] datesdata = new DateSlotsBean[1];
		// datesdata[0].setDate(dateslotarray.getString(0));
		//
		// JSONArray timeslotsarray = new JSONArray();
		// timeslotsarray = dataobject.getJSONArray("TimeSlots");
		// TimeSlotesBean[] timedata = new TimeSlotesBean[1];
		// timedata[0].setTime(timeslotsarray.getString(0));

		SurroundingLabsBean slb = new SurroundingLabsBean(dataobject.getInt("SiteId"), dataobject.getString("LocName"), dataobject.getDouble("Distance"), dataobject.getString("Slots"), dataobject.getString("SlotTime"));

		return slb;
	}

	public static FutureorHistoryAppointmentsBeans setFutureAppointmentsDataObjects(JSONObject dataobject) {
		FutureorHistoryAppointmentsBeans fha = new FutureorHistoryAppointmentsBeans(dataobject.getInt("SiteID"), dataobject.getInt("CustomerID"), dataobject.getString("Date"), dataobject.getString("Time"), dataobject.getInt("AppointmentID"), dataobject.getString("Name"), dataobject.getString("Confirmation"), dataobject.getBoolean("IsDependent"), dataobject.getString("Address1"), dataobject.getString("City"), dataobject.getString("State"));
		return fha;
	}

	public static CancelledAppointmentBeans setCancelledAppointsDataObjects(JSONObject dataobject) {
		CancelledAppointmentBeans cas = new CancelledAppointmentBeans(dataobject.getString("Date"), dataobject.getString("CancelledDate"), dataobject.getString("CustomerName"), dataobject.getString("SiteAddress"), dataobject.getString("ConfirmationNumber"), dataobject.getBoolean("IsDependent"));
		return cas;
	}

	public static SelectedAppointmentBeans setSelectedAppointmentsDataObject(JSONObject dataobject) {

		ArrayList<OperatingHoursBean> operatingHoursList = new ArrayList<OperatingHoursBean>();

		JSONArray jsonarray = dataobject.getJSONArray("OperatingHours");
		for (int k = 0; k < jsonarray.length(); k++) {
			JSONObject object = new JSONObject(jsonarray.get(k).toString());

			operatingHoursList.add(new OperatingHoursBean(object.getInt("SiteID"), object.getInt("DayOfTheWeek"), object.getString("OpenTime"), object.getString("CloseTime"), object.getBoolean("Closed")));
		}

		SelectedAppointmentBeans sab;

		sab = new SelectedAppointmentBeans(dataobject.getInt("SiteID"), dataobject.getInt("CustomerID"), dataobject.getInt("AppointmentID"), dataobject.getString("DateTimeDay"), dataobject.getString("StartTime"), dataobject.getString("EndTime"), dataobject.getString("Name"), dataobject.getString("SiteLocation"), dataobject.getDouble("Latitude"), dataobject.getDouble("Longitude"), dataobject.getDouble("Distance"), dataobject.getString("Phone"), dataobject.getString("Fax"), operatingHoursList.toArray(new OperatingHoursBean[operatingHoursList.size()]), dataobject.getString("AdditionalSiteInfo"));

		return sab;
	}

	public static AvailableAppointmentsBean setAvailableAppointmentsDataObject(JSONObject dataobject) {
		AvailableAppointmentsBean aab = new AvailableAppointmentsBean(dataobject.getString("slotId"), dataobject.getString("selectedDay"), dataobject.getString("slots"));
		return aab;
	}

	public static void fillLiteAccountCreationDetails(String firstname, String lastname, String phonenumber, String province, String email, String password, boolean receiveheckbox, boolean agreeterms,
			boolean agreesurvey) throws Exception {

		step3FirstNameTextBox.clear();
		step3LastNameTextBox.clear();
		step3PhoneNumberTextBox.clear();
		step3EmailTextBox.clear();
		step3ReTypeEmailTextBox.clear();
		step3PasswordTextBox.clear();
		step3ReTypePasswordTextBox.clear();

		step3FirstNameTextBox.sendKeys(firstname);
		step3LastNameTextBox.sendKeys(lastname);
		step3PhoneNumberTextBox.sendKeys(phonenumber);

		Select provinceSelector = new Select(ObjectHelper.driver.findElement(By.xpath("//div[contains(@ng-init, 'provinceList')]//select")));
		provinceSelector.selectByVisibleText(province);

		step3EmailTextBox.sendKeys(email);
		step3ReTypeEmailTextBox.sendKeys(email);
		step3PasswordTextBox.sendKeys(password);
		step3ReTypePasswordTextBox.sendKeys(password);

		if (receiveheckbox) {
			CommonFunctions.clickUsingJavaExecutor(step3ReceieveEmailCheckBox);
		}
		if (agreeterms) {
			CommonFunctions.clickUsingJavaExecutor(step3AgreeTermsCheckBox);
		}
		if (agreesurvey) {
			CommonFunctions.clickUsingJavaExecutor(step3ReceieveSurveyCheckBox);
		}
	}

	public static boolean findAvailableDatesUntilMonths(int months) throws InterruptedException {
		int countmonths = 0;
		Thread.sleep(8000);
		while ((step2calendaravailableiconList == null || step2calendaravailableiconList.size() < 0) && countmonths < months) {
			CommonFunctions.clickUsingJavaExecutor(step2calendarforwardIcon);
			countmonths++;
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}

		if (step2calendaravailableiconList == null || step2calendaravailableiconList.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void gotoNextAvailableDateMonth() throws InterruptedException {
		int dateListSize = AppointmentsPage.step2CalendarAvailableDateList.size();
		int i = 0;
		while (dateListSize == 0 && i < 3) {
			i++;
			CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step2calendarforwardIcon);
			Thread.sleep(5000);
			dateListSize = AppointmentsPage.step2CalendarAvailableDateList.size();
		}
	}

	public static boolean logintoAccountfromAppointment(String username, String password) throws InterruptedException {

		step3useremailTextBox.clear();
		step3passwordTextBox.clear();

		step3useremailTextBox.sendKeys(username);
		step3passwordTextBox.sendKeys(password);

		Thread.sleep(3000);
		step3loginButton.click();

		if (!CommonFunctions.waitForVisiblity(step4UserCombobox, 30)) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean importAppointments(String username, String password) throws Exception {
		Thread.sleep(5000);
		popupimportAppointmentEmailTextBox.clear();
		popupimportAppointmentPasswordTextBox.clear();

		popupimportAppointmentEmailTextBox.sendKeys(username);
		popupimportAppointmentPasswordTextBox.sendKeys(password);

		CommonFunctions.clickUsingJavaExecutor(popupimportAppointmentLoginButton);

		return true;
	}

	public static boolean checkifAppointmentisAvailableforDate(String date) throws Exception {
		boolean result = false;

		if (step2CalendarAvailableDateList != null && step2CalendarAvailableDateList.size() > 0) {
			loop: for (int i = 0; i < step2CalendarAvailableDateList.size(); i++) {
				if (step2CalendarAvailableDateList.get(i).getText().contains(date)) {
					result = true;
					break loop;
				}
			}
		}

		return result;
	}

	public static boolean bookanAppointment(String[] searchdata) throws Exception {
		boolean step1 = true, step2 = true, step3 = true, step4 = true, step5 = true, step6 = true, accountcreated = false;

		CommonFunctions.clickUsingJavaExecutor(MenuPage.appointmentmenuitem);

		if (CommonFunctions.waitForVisiblity(AppointmentsPage.popupImportNotNowButton, 30)) {
			CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.popupImportNotNowButton);
		}
		BugsHandler bh = new BugsHandler();
		bh.addactionstep(14625, 2);
		if (!CommonFunctions.waitForVisiblity(AppointmentsPage.findlocationbutton, 30)) {
			bh.addexpected(14625, 2);
			step1 = false;
		}
		if (step1) {

			// Enter Search data
			for (String searchstring : searchdata) {

				bh.addactionstep(14625, 5);
				CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.findlocationbutton);

				if (!CommonFunctions.waitForVisiblity(AppointmentsPage.searchtextbox, 30)) {
					bh.addexpected(14625, 5);
					step2 = false;
				}
				if (step2) {

					AppointmentsPage.searchtextbox.clear();
					AppointmentsPage.searchtextbox.sendKeys(searchstring);

					CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.findsearchbutton);

					bh.addactionstep(14625, 4);
					if (!CommonFunctions.waitForVisiblity(AppointmentsPage.searchresultstabActive, 30)) {
						bh.addexpected(14625, 4);
						step3 = false;
					}

					if (step3) {
						if (AppointmentsPage.bookappointmentlist != null && AppointmentsPage.bookappointmentlist.size() > 0) {
							// for (int i = 0; i < AppointmentsPage.bookappointmentlist.size(); i++) {
							for (int i = 0; i < 1; i++) {
								CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.bookappointmentlist.get(i));

								if (CommonFunctions.waitForVisiblity(AppointmentsPage.popupcontinueWithMyeHealthButton, 30)) {
									CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.popupcontinueWithMyeHealthButton);
								}

								bh.addactionstep(14625, 30);
								if (!CommonFunctions.waitForVisiblity(AppointmentsPage.step1patientinstructionsTitle, 30)) {
									bh.addexpected(14625, 30);
									step4 = false;
								}

								if (step4) {

									CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step1nextBottomButton);

									bh.addactionstep(14625, 6);
									if (!CommonFunctions.waitForVisiblity(AppointmentsPage.step2dateandtimeTitle, 30)) {
										bh.addexpected(14625, 6);
										step5 = false;
									}

									if (step5) {

										if (AppointmentsPage.findAvailableDatesUntilMonths(1)) {
											Thread.sleep(5000);
											CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step2CalendarAvailableDateList.get(0));
											Thread.sleep(2000);
											AppointmentsPage.step2TimeSlotAvailableDateList.get(0).click();

											Thread.sleep(5000);
											CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step2nextBottomButton);
											Thread.sleep(5000);

											bh.addactionstep(14625, 7);
											if (!CommonFunctions.waitForVisiblity(AppointmentsPage.step4UserCombobox, 30)) {
												bh.addexpected(14625, 7);
												step6 = false;
											}

											if (step6) {
												Thread.sleep(5000);
												CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step4UserCombobox);

												Thread.sleep(3000);
												if (AppointmentsPage.step4UserComboboxList.size() > 0) {
													Thread.sleep(3000);
													CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step4UserComboboxList.get(0));
													Thread.sleep(3000);
													CommonFunctions.clickUsingJavaExecutor(AppointmentsPage.step4ConfirmAppointment);

													bh.addactionstep(14625, 8);
													if (!CommonFunctions.waitForVisiblity(AppointmentsPage.step4ConfirmTitle, 10)) {
														bh.addexpected(14625, 8);
													} else {
														accountcreated = true;
													}
												} else {
													bh.addexpected("Users not found in User Combobox");
												}
											}
										} else {
											bh.addexpected("Appointments Not Available for 1 Month");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return accountcreated;
	}

	public static boolean appointmentEmailReceived(String destinationemail, String destemailPassword, String expectedName) {
		Boolean stat = true;

		String host = "pop.gmail.com";// change accordingly
		String port = "995"; // change accordingly
		String mailStoreType = "pop3"; // change accordingly

		String emailName = CheckandFetchEmail.check(host, port, mailStoreType, destinationemail, destemailPassword, "noreply_appointmentbooking@lifelabs.com", "<td>", "</td><td>").trim();

		System.out.println("Expec:" + expectedName);
		System.out.println("Actual:" + emailName);
		if (!emailName.toLowerCase().contains(expectedName.toLowerCase())) {
			stat = false;
		}
		return stat;
	}
}
