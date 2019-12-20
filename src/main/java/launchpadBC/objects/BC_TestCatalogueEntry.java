package launchpadBC.objects;

import org.openqa.selenium.By;

public class BC_TestCatalogueEntry {

	public static By testGroupBtn = By.id("ctl00_ContentPlaceHolder1_TestGroup");
	public static By testCodesBtn = By.id("ctl00_ContentPlaceHolder1_TestCode");
	public static By resultCodesBtn = By.id("ctl00_ContentPlaceHolder1_ResultCode");
	public static By resultCodesList = By.id("ctl00_ContentPlaceHolder1_ResultCodeListView_ctrl0_Tr2");
	public static By saveBtn = By.id("AcceptButton");
	public static By editBtn = By.id("ctl00_ContentPlaceHolder1_EditButton");
	public static By loincID = By.id("LoincTextBox");
	public static By testSecListGeneral = By.xpath("//table[@id='TestSectionListTable']//tbody//tr[2]");
	public static By testGrpListGeneral = By.id("ctl00_ContentPlaceHolder1_TestGroupListView_ctrl0_Tr2");
	public static By testCodesListGCM = By.xpath("//tr[@id='Tr2'][1]");

}
