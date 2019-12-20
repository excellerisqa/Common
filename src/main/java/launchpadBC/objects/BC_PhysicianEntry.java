package launchpadBC.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.ObjectHelper;

public class BC_PhysicianEntry {
	WebDriver driver;
	public static By newphys = By.xpath("//*[@id='MainProviderAdmin']/td/a");
	public static By providerid = By.id("sProviderId");
	public static By searchbtn = By.id("btnSearch");
	public static By newbtn = By.xpath("//input[@id='btnNew']");
	public static By selectprovider_results = By.xpath("//div[@id='ProviderSearchResultsTD']//tr[2]");
	public static By iframeMainMenu = By.xpath("//iframe[@id='ifPatientSearch']");
	public static By iframepysicianmaintaince = By.xpath("//iframe[@id='ifSPAdmin']");
	public static By manAttributes = By.id("btnAttributesView");
	public static By manPhoneNumbers = By.id("btnPhoneNumbersView");
	public static By manIdentifiers = By.id("btnIdentifiersView");
	public static By saveButton = By.id("btnSave");
	public static By deleteButton = By.id("btnDelete");
	public static By removeAttribute = By.id("btnAttributeRemove");
	public static By removeIdentifier = By.id("btnIdRemove");

	public static By Title = By.id("Title");
	public static By FirstName = By.id("First_Name");
	public static By Middlname = By.id("Middle_Name");
	public static By LastName = By.id("Last_Name");
	public static By Specialty = By.id("Specialty");
	public static By Address = By.id("Address1");
	public static By City = By.id("City");
	public static By Province = By.id("StateOrProvince");
	public static By Country = By.id("Country");
	public static By PostalCode = By.id("ZipPostalCode");
	public static By AssAuthority = By.id("AssigningAuthority");
	public static By IDType = By.id("IdType");
	public static By DoctorID = By.id("Id");
	public static By identifierAddBtn = By.xpath("//*[@id='btnIdAdd']");
	public static By attributeType = By.id("AttributeType");
	public static By attributeOption = By.id("AttributeOption");
	public static By attributeTextBox = By.id("AttributeOptionValue");
	public static By attributeAddBtn = By.id("btnAttributeAdd");

	public static void PhysicianInfo(String Titl, String FirName, String Midname, String LasName, String Specty,
			String Addr, String Cit, String Prov, String Count, String PC) throws Exception {
		ObjectHelper.driver.findElement(Title).sendKeys(Titl);
		ObjectHelper.driver.findElement(FirstName).sendKeys(FirName);
		ObjectHelper.driver.findElement(Middlname).sendKeys(Midname);
		ObjectHelper.driver.findElement(LastName).sendKeys(LasName);
		ObjectHelper.driver.findElement(Specialty).sendKeys(Specty);
		ObjectHelper.driver.findElement(Address).sendKeys(Addr);
		ObjectHelper.driver.findElement(City).sendKeys(Cit);
		ObjectHelper.driver.findElement(Province).sendKeys(Prov);
		ObjectHelper.driver.findElement(Country).sendKeys(Count);
		ObjectHelper.driver.findElement(PostalCode).sendKeys(PC);
		/*
		 * ObjectHelper.driver.findElement(AssAuthority).sendKeys(Authr);
		 * ObjectHelper.driver.findElement(IDType).sendKeys(IDTyp);
		 * ObjectHelper.driver.findElement(DoctorID).sendKeys(DoctID);
		 */
	}

	/*
	 * the following function can be used while creating a new physician or while
	 * updating an existing physician in Launchpad
	 */
	public static void PhysicianCreation(String[] physicianData) {
		selectPhysicianTitle(physicianData[1]);
		ObjectHelper.driver.findElement(FirstName).clear();
		ObjectHelper.driver.findElement(FirstName).sendKeys(physicianData[2]);
		ObjectHelper.driver.findElement(Middlname).clear();
		ObjectHelper.driver.findElement(Middlname).sendKeys(physicianData[3]);
		ObjectHelper.driver.findElement(LastName).clear();
		ObjectHelper.driver.findElement(LastName).sendKeys(physicianData[4]);
		// ObjectHelper.driver.findElement(Specialty).sendKeys(physicianData[5]);
		selectSpeciality(physicianData[5]);
		ObjectHelper.driver.findElement(Address).clear();
		ObjectHelper.driver.findElement(Address).sendKeys(physicianData[6]);
		ObjectHelper.driver.findElement(City).clear();
		ObjectHelper.driver.findElement(City).sendKeys(physicianData[7]);
		selectProvince(physicianData[8]);
		// ObjectHelper.driver.findElement(Province).sendKeys(physicianData[8]);
		selectCountry(physicianData[9]);
		// ObjectHelper.driver.findElement(Country).sendKeys(physicianData[9]);
		ObjectHelper.driver.findElement(PostalCode).clear();
		ObjectHelper.driver.findElement(PostalCode).sendKeys(physicianData[10]);
	}

	public static void selectSearchResult() {
		ObjectHelper.driver.findElement(selectprovider_results).click();
	}

	public static boolean findLinks() {
		boolean found;
		boolean linkAtt = ObjectHelper.driver.findElement(manAttributes).isEnabled();
		boolean linkPhone = ObjectHelper.driver.findElement(manPhoneNumbers).isEnabled();
		boolean linkIdent = ObjectHelper.driver.findElement(manIdentifiers).isEnabled();
		if (linkAtt && linkPhone && linkIdent == true) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}

	public static void selectPhysicianTitle(String title) {
		Select titleDD = new Select(ObjectHelper.driver.findElement(Title));
		switch (title) {
		case "Dr.":
			titleDD.selectByValue("Dr.");
			break;
		case "Mr.":
			titleDD.selectByValue("Mr.");
			break;
		case "Mrs.":
			titleDD.selectByValue("Mrs.");
			break;
		case "Ms.":
			titleDD.selectByValue("Ms.");
			break;

		}
	}

	public static void selectAssigningAuth(String assAuth) {
		Select AssigningAuthoritydroplist = new Select(ObjectHelper.driver.findElement(BC_PhysicianEntry.AssAuthority));
		AssigningAuthoritydroplist.selectByVisibleText(assAuth);
	}

	public static void selectIdType(String IdType) {
		Select IdTypedroplist = new Select(ObjectHelper.driver.findElement(BC_PhysicianEntry.IDType));
		IdTypedroplist.selectByVisibleText(IdType);
	}

	public static void selectSpeciality(String speciality) {
		Select specialityDD = new Select(ObjectHelper.driver.findElement(Specialty));
		specialityDD.selectByVisibleText(speciality);
	}

	public static void selectProvince(String province) {
		Select specialityDD = new Select(ObjectHelper.driver.findElement(Province));
		specialityDD.selectByVisibleText(province);
	}

	public static void selectCountry(String countryName) {
		Select specialityDD = new Select(ObjectHelper.driver.findElement(Country));
		specialityDD.selectByVisibleText(countryName);
	}

	public static void selectAttributeType(String attType) {
		Select attributeTypeDD = new Select(ObjectHelper.driver.findElement(attributeType));
		attributeTypeDD.selectByVisibleText(attType);
	}

	public static void selectAttributeOption(String attOption) {
		Select attributeOptionDD = new Select(ObjectHelper.driver.findElement(attributeOption));
		attributeOptionDD.selectByVisibleText(attOption);
	}

}
