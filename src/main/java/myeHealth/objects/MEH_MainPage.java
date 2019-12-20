package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_MainPage {
	public static By dashboardHeader = By.xpath("//h1[@id='MainPageHeading1']");
	public static By homeLink = By.xpath("//div[@id='ctl00_menu']//a[contains(text(),'Home')]");
	public static By reportsLink = By.xpath("//div[@id='ctl00_menu']//a[contains(text(),'Reports')]");
	public static By accountLink = By.xpath("//div[@id='ctl00_menu']//a[contains(text(),'Account')]");
	public static By analyticsLink = By.xpath("//div[@id='ctl00_menu']//a[contains(text(),'Analytics')]");
	public static By logoutLink = By.xpath("//div[@id='ctl00_NavCtrl1_logoutlinkcontainer']//a[contains(text(),'Logout')]");	
	public static By dashboardReportsLink=By.id("ReportsListLink");
	public static By dashboardAnalyticsLink=By.id("AnalyticsListLink");
	public static By dashboardAccountLink=By.id("AccountsListLink");
	public static By helpLink=By.id("ctl00_NavCtrl1_Help_Link");
	public static By supportLink=By.id("ctl00_NavCtrl1_SupportLink");

	/*
	 * Description : logout of the application
	 * Parameters : none
	 * Returns : void
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public void logout() {
		ObjectHelper.driver.findElement(logoutLink).click();
		CommonFunctions.waitForVisiblity(MEH_LoginPage.usernameField, 30);
		/*try {
			ObjectHelper.driver.findElement(logoutLink).click();
			CommonFunctions.waitForVisiblity(LoginPage.usernameField, 30);
		} catch (Exception e) {
			System.out.println("logout error\n"+e);
			ObjectHelper.driver.get(ObjectHelper.enviURL);
		}*/
		
	}
}

