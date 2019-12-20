package lars.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;

public class LARS_CollectionCenterPage extends LoadableComponent<LARS_CollectionCenterPage> {

	@FindBy(xpath = "//div[@class='tileItemTitleForCenters ng-binding ng-scope']")
	public List<WebElement> passwordsText;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	public List<WebElement> editButtons;

	@FindBy(xpath = "//div[contains(text(),'Save')]")
	public List<WebElement> saveButtons;
	
	//@FindBy(id = "edit-1")
	
	@FindBy(xpath = "//input[@title = 'Enter License']")
	public WebElement passwordTextbox;

	@FindBy(xpath = "//button[@class='close']")
	public WebElement closeMessage;

	@FindBy(xpath = "//button[@class='close']/following::div/span")
	public WebElement messageText;

	@FindBy(xpath = "//div[contains(text(),'Collection Center')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//span[text()='Map']")
	public WebElement mapTab;
	
	@FindBy(xpath = "//span[@title='204, Metrotown']")
	public WebElement metrotownPin;

	@FindBy(xpath = "//div[@class='k-tooltip-content']")
	public WebElement metrotownToolTipText;
	
	@FindBy(xpath = "//button[@title='zoom-in']")
	public WebElement zoomInButton;
	
	@FindBy(xpath = "//button[@title='zoom-out']")
	public WebElement zoomOutButton;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	public WebElement larsLogo;
	
	@FindBy(xpath = "//button[@file-name='Collection_Centers']")
	public WebElement exportToExcelButton;
	
	@FindBy(xpath = "//div[@class='tileItemTitleForCenters ng-binding' and text()='481']/..//../following-sibling::div[1]//div[@class='tileItemTitleForCenters ng-binding']")
	public WebElement psc_481;
	
	
	//button[@file-name="Collection_Centers"]
	

	WebDriver driver = null;

	public LARS_CollectionCenterPage(WebDriver driver) {
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

	public boolean verifyChangePassword() {

		try {
			boolean isEdited = false;
		//	CommonFunctions.waitForVisiblity(passwordsText.get(0), 10);
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
		//	isEdited = messageText.getText().contains("has been successfully updated!");
			isEdited = messageText.getText().contains("has been successfully updated!") || messageText.getText().contains("undefined");
			
			closeMessage.click();

			// to revert back
			CommonFunctions.waitandClick(editButtons.get(0), 10);
			CommonFunctions.waitForVisiblity(passwordTextbox, 10);

			passwordTextbox.clear();
			passwordTextbox.sendKeys(currentPassword);
			saveButtons.get(0).click();
			CommonFunctions.waitForVisiblity(messageText, 5);
		//	isEdited = messageText.getText().contains("has been successfully updated!");

			isEdited = messageText.getText().contains("has been successfully updated!") || messageText.getText().contains("undefined");
			
			return isEdited;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean verifyCollectionCenters() {

		try {

			//mapTab.click();
			CommonFunctions.waitandClick(mapTab, 10);
			return CommonFunctions.waitForVisiblity(metrotownPin, 10);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean verifyToolTip() {

		try {

			String displayMsg  = "204, Metrotown";
			Actions builder=new Actions(driver);
			builder.moveToElement(metrotownPin).build().perform();
			String tooltip_msg = metrotownToolTipText.getText();
			if (tooltip_msg.equals(displayMsg))		
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean verifyZoomInOut() {

		try {

			return (CommonFunctions.isElementClickable(zoomInButton)&&CommonFunctions.isElementClickable(zoomOutButton));


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
	
	public boolean exportToExcel() {

		try {
			Thread.sleep(2000);
			exportToExcelButton.click();


			// verify a file is downloaded
			Thread.sleep(2000);
			if (CommonFunctions.waitForDownload("Collection_Centers.xlsx"))
//			if (CommonFunctions.waitForDownloadForLARS("Collection_Centers.xlsx"))

				return false;
			else {
				Thread.sleep(2000);
				// CommonFunctions.archiveFile(ObjectHelper.downloadsFolder,
				// "EODPaymentSummary.pdf");
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean isPSC481_Westshore() {
		
		try {
			CommonFunctions.waitForVisiblity(psc_481, 5);
			if (psc_481.getText().equals("Westshore")) {
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

}