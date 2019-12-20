package launchpadON.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ObjectHelper;

public class ON_PhysicianEntry {
	WebDriver driver;
	public static By newphys = By.xpath("//*[@id='MainProviderAdmin']/td/a");
	public static By providerid = By.id("sProviderId");
	public static By searchbtn = By.id("btnSearch");
	public static By newbtn = By.xpath("//*[@id='btnNew']");
	public static By selectprovider_results = By.xpath("//div[@id='ProviderSearchResultsTD']//tr[2]");
	public static By iframeMainMenu = By.xpath("//iframe[@id='ifPatientSearch']");
	public static By iframepysicianmaintaince = By.xpath("//iframe[@id='ifSPAdmin']");
	public static By manAttributes = By.id("btnAttributesView");
	public static By manPhoneNumbers = By.id("btnPhoneNumbersView");
	public static By manIdentifiers = By.id("btnIdentifiersView");
	public static By saveButton = By.id("btnSave");

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
	public static By addBtn = By.xpath("//*[@id='btnIdAdd']");

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

}
