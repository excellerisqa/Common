package myResults.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_RegisterPatientPage {
	public static By anotherIndividualRadiobutton = By.xpath("//label[@for='otheradult']");
	public static By step1NextButton = By.xpath("//button[@id='btn_next_add_person']");

	public static By firstNameTextbox = By.name("givenName");
	public static By lastNameTextbox = By.name("surName");

	public static By birthYearDropdown = By.name("birthYear");
	public static By birthMonthDropdown = By.name("birthMonth");
	public static By birthDayDropdown = By.name("birthDay");

	public static By ontarioPHNTextbox1 = By.name("ont_phn_1");
	public static By ontarioPHNTextbox2 = By.name("ont_phn_2");
	public static By ontarioPHNTextbox3 = By.name("ont_phn_3");

	public static By labVisitTextbox1 = By.name("accessCodePart1");
	public static By labVisitTextbox2 = By.name("accessCodePart2");

	public static By labAttendYearDropdown = By.name("labAttendedYear");
	public static By labAttendMonthDropdown = By.name("labAttendedMonth");
	public static By labAttendDayDropdown = By.name("labAttendedDay");

	public static By saveButton = By.xpath("//button[text()='SAVE']");

	public static By successMessage = By.xpath("//p[@translate='MODAL_USERREGISTRATIONSUCCESS']");
	public static By successOKButton = By.xpath("//button[@ng-if='ok' and text()='OK']");

	public static boolean enterLabVisitDetails(XLHandler objXLHandler) {
		try {
			CommonFunctions.waitandClick(anotherIndividualRadiobutton, 20);
			ObjectHelper.driver.findElement(step1NextButton).click();

			String firstName = objXLHandler.readCorrespondingValueFromTestDataName("Data", "FirstName");
			String lastName = objXLHandler.readCorrespondingValueFromTestDataName("Data", "LastName");
			String birthdate = objXLHandler.readCorrespondingValueFromTestDataName("Data", "Birthdate");
			String healthCardNumber = objXLHandler.readCorrespondingValueFromTestDataName("Data", "HealthCardNumber");
			String labVisitNumber = objXLHandler.readCorrespondingValueFromTestDataName("Data", "LabVisitNumber");
			String dateOfLabVisit = objXLHandler.readCorrespondingValueFromTestDataName("Data", "DateOfLabVisit");

			ObjectHelper.driver.findElement(firstNameTextbox).sendKeys(firstName);
			ObjectHelper.driver.findElement(lastNameTextbox).sendKeys(lastName);

			Select year = new Select(ObjectHelper.driver.findElement(birthYearDropdown));
			Select month = new Select(ObjectHelper.driver.findElement(birthMonthDropdown));
			Select day = new Select(ObjectHelper.driver.findElement(birthDayDropdown));

			year.selectByVisibleText(birthdate.substring(0, 4));
			month.selectByVisibleText(birthdate.substring(4, 12));
			day.selectByVisibleText(birthdate.substring(12, 14));

			ObjectHelper.driver.findElement(ontarioPHNTextbox1).sendKeys(healthCardNumber.substring(0, 4));
			ObjectHelper.driver.findElement(ontarioPHNTextbox2).sendKeys(healthCardNumber.substring(4, 7));
			ObjectHelper.driver.findElement(ontarioPHNTextbox3).sendKeys(healthCardNumber.substring(7, 10));

			ObjectHelper.driver.findElement(labVisitTextbox1).sendKeys(labVisitNumber.split("-")[0]);
			ObjectHelper.driver.findElement(labVisitTextbox2).sendKeys(labVisitNumber.split("-")[1]);

			Select labVisitYear = new Select(ObjectHelper.driver.findElement(labAttendYearDropdown));
			Select labVisitMonth = new Select(ObjectHelper.driver.findElement(labAttendMonthDropdown));
			Select labVisitDay = new Select(ObjectHelper.driver.findElement(labAttendDayDropdown));

			// dateOfLabVisit = getYesterdaysDate();

			String yearLV = dateOfLabVisit.substring(0, 4);
			String dayLV = dateOfLabVisit.substring(dateOfLabVisit.length() - 2, dateOfLabVisit.length());
			String monthLV = dateOfLabVisit.split(yearLV)[1].split(dayLV)[0];

			labVisitYear.selectByVisibleText(yearLV);
			labVisitMonth.selectByVisibleText(monthLV);
			labVisitDay.selectByVisibleText(dayLV);

			ObjectHelper.driver.findElement(saveButton).click();

			if (!(CommonFunctions.waitForVisiblity(successMessage, 20))) {
				System.out.println(
						"Please upload new HL7 message in launchpad with a Lab Visit date within last 30 days (service date), "
								+ "report date, (only date part), update PHN and change the lab visit number, lab visit date, phn in Test data file."
								+ "Use the report in LP inbox for exact details. (HL7 message is in the TestData folder.) LP ON enduser details: http://10.1.1.113/launchpad/default.aspx  (ctest1/Fall1234) ");
				ObjectHelper.driver.findElement(By.xpath("//button[text()='OK']")).click();
				// ObjectHelper.driver.get(ObjectHelper.enviURL + "Dashboard");
				return false;
			} else {
				return (CommonFunctions
						.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
								ObjectHelper.driver.findElement(successOKButton))
						.contains("User Successfully Registered!"));
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static String getYesterdaysDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		// cal.add(Calendar.DATE, 60);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMMMMdd");
		return String.valueOf(dateFormat.format(cal.getTime()));
	}

}
