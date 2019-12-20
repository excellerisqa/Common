package launchpadON.objects;

import org.openqa.selenium.By;

import utils.ObjectHelper;

public class ON_LocationEntry {
	public static boolean acceptAlert = true;
	public static String location_scr;

	public static By organizationid = By.id("sOrganizationId");
	public static By organizationsearchresultsid = By.xpath("(//div[@id='OrganizationSearchResultsTD']//tr)[2]");
	public static By searchbtn = By.id("btnSearch");
	public static By manLocations = By.id("btnLocationsView");
	public static By manIdentifiers = By.id("btnIdentifiersView");
	public static By saveButton = By.id("btnSave");

	public static void selectSearchResult() {
		ObjectHelper.driver.findElement(organizationsearchresultsid).click();
	}

	public static boolean findLinks() {
		boolean found;
		boolean linkLoc = ObjectHelper.driver.findElement(manLocations).isEnabled();
		boolean linkIden = ObjectHelper.driver.findElement(manIdentifiers).isEnabled();
		if (linkLoc && linkIden == true) {
			found = true;
		} else {
			found = false;
		}
		return found;
	}

}
