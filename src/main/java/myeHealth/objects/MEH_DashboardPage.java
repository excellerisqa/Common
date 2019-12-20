package myeHealth.objects;

import org.openqa.selenium.By;

public class MEH_DashboardPage {
	public static By welcomeName = By.tagName("h2");
	public static By patientNameLink = By.xpath("//div[@ng-controller='PatientSelectController']/div[1]/div[3]/div[1]");
	public static By recentActivityReportLink = By.xpath("//div[@id='wallmessages']/div[1]/div/div[2]/a");

}
