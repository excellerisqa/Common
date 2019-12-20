package launchpadON.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ObjectHelper;

public class MyehealthMapping {

	public static By loginID = By.id("LoginTextBox");
	public static By clientListBtn = By.id("ClientListhButton");
	public static By searchBtn = By.xpath("//input[@id='SearchButton']");
	public static By lastName = By.xpath("//table[@class='full autoFlow text']//td[3]");
	public static By firstName = By.xpath("//table[@class='full autoFlow text']//td[4]");

	public static void selectclient(String client) {
		WebElement clientListdd = ObjectHelper.driver.findElement(By.id("ClientListDropDown"));
		Select clientListDropDown = new Select(clientListdd);
		clientListDropDown.selectByVisibleText(client);
	}

}
