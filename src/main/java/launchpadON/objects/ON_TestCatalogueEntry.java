package launchpadON.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.ObjectHelper;

public class ON_TestCatalogueEntry {

	public static By testGroupBtn = By.id("ctl00_ContentPlaceHolder1_TestGroup");
	public static By testCodesBtn = By.id("ctl00_ContentPlaceHolder1_TestCode");
	public static By resultCodesBtn = By.id("ctl00_ContentPlaceHolder1_ResultCode");
	public static By resultCodesList = By.id("ctl00_ContentPlaceHolder1_ResultCodeListView_ctrl0_Tr2");
	public static By saveBtn = By.id("AcceptButton");
	public static By editBtn = By.id("ctl00_ContentPlaceHolder1_EditButton");
	public static By loincID = By.id("LoincTextBox");
	public static By testSecListGeneral = By.xpath("//table[@id='TestSectionListTable']//tbody//tr[2]");
	public static By testSecListCHEM = By.xpath("//table[@id='TestSectionListTable']//tbody//tr[5]");
	public static By testGrpListGeneral = By.id("ctl00_ContentPlaceHolder1_TestGroupListView_ctrl0_Tr2");
	public static By testCodesListGCM = By.xpath("//tr[@id='Tr2'][1]");
	public static By testCodesList = By.xpath("//table[@id='TestCodeListTable']//tr");

	public static By orgDropDown = By.id("OrganizationListDropDown");

	public static void selOrganization(String visibleText) {
		Select selOrg = new Select(ObjectHelper.driver.findElement(orgDropDown));
		selOrg.selectByVisibleText(visibleText);

	}

}
