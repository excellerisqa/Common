package lars.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class LARS_DatacenterPage extends LoadableComponent<LARS_DatacenterPage> {

	@FindBy(xpath = "//div[@class='tileItemTitleForCenters ng-binding ng-scope']")
	public List<WebElement> passwordsText;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	public List<WebElement> editButtons;

	@FindBy(xpath = "//div[contains(text(),'Save')]")
	public List<WebElement> saveButtons;

	//@FindBy(id = "edit-1")
	
	@FindBy(xpath = "//input[@title = 'Enter Password']")
	public WebElement passwordTextbox;
	
		@FindBy(xpath = "//button[@class='close']")
	public WebElement closeMessage;

	@FindBy(xpath = "//button[@class='close']/following::div/span")
	public WebElement messageText;

	@FindBy(xpath = "//div[contains(text(),'Data center - Teleplan password management')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	public WebElement larsLogo;
	
	//a[@class='navbar-brand']

	WebDriver driver = null;

	public LARS_DatacenterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	@Override
	protected void isLoaded() throws Error {
	}

	@Override
	protected void load() {
	}

	public boolean editPasswordForFirstDatacenter() {

		try {
			boolean isEdited = false;
			CommonFunctions.waitForVisiblity(passwordsText.get(0), 10);
			String currentPassword = passwordsText.get(0).getText();

			editButtons.get(0).click();
			CommonFunctions.waitForVisiblity(passwordTextbox, 10);

			// String newPassword = "lab" + Integer.parseInt(currentPassword.split("b")[1])
			// + 1;
			String newPassword = "lab1216";

			passwordTextbox.clear();
			passwordTextbox.sendKeys(newPassword);
			saveButtons.get(0).click();
			CommonFunctions.waitForVisiblity(messageText, 5);
			isEdited = messageText.getText().contains("has been successfully updated!");
			closeMessage.click();

			// to revert back
			CommonFunctions.waitandClick(editButtons.get(0), 10);
			CommonFunctions.waitForVisiblity(passwordTextbox, 10);

			passwordTextbox.clear();
			passwordTextbox.sendKeys(currentPassword);
			saveButtons.get(0).click();
			CommonFunctions.waitForVisiblity(messageText, 5);
			isEdited = messageText.getText().contains("has been successfully updated!");

			return isEdited;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToMenuPage(LARS_MenuPage menuPage) {

		try {
			// CommonFunctions.waitandClick(lifelabsLogo, 20);
			Thread.sleep(5000);
			lifelabsLogo.click();
			return menuPage.verifyOptionsAvailableOnMenuPage();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean isSort() {
	
		try {
			//boolean result = false;
			ArrayList<String> obtainedList = new ArrayList<>(); 
			List<WebElement> elementList= driver.findElements(By.xpath("//div[@class='numberCircleForCenters ng-binding ng-scope']/..//../following-sibling::div[1]//div[@class='tileItemTitleForCenters ng-binding']"));
			for(WebElement we:elementList){
			   obtainedList.add(we.getText());
			}
			ArrayList<String> sortedList = new ArrayList<>();   
			for(String s:obtainedList){
			sortedList.add(s);
			}
			Collections.sort(sortedList);
			if(sortedList.equals(obtainedList)) {
				return true;
			}
			else
				return false;
		//	Assert.assertTrue(sortedList.equals(obtainedList));
		}catch (Exception e) {

			System.out.println(e.getMessage());
			return false;	
			
			
	
		}	
	}
	
	public boolean goToAdminOpPage(LARS_AdministrationOperationsPage administrationOperationsPage) {

		try {
			// CommonFunctions.waitandClick(lifelabsLogo, 20);
			Thread.sleep(5000);
			larsLogo.click();
			return administrationOperationsPage.verifyOptionsAvailableOnAdministrationOperationsPage();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
}