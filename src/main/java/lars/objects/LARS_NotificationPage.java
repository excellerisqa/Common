package lars.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_NotificationPage extends LoadableComponent<LARS_NotificationPage> {

	@FindBy(id = "codeInput")
	public WebElement codeTextbox;

	@FindBy(id = "codeGo")
	public WebElement searchButton;
	
	@FindBy(id = "filterGo")
	public WebElement filterSearchButton;

	@FindBy(id = "prefixInput")
	public WebElement prefixTextbox;

	@FindBy(id = "accessionInput")
	public WebElement accessionTextbox;

	@FindBy(id = "accessionGo")
	public WebElement searchAccessionButton;

	@FindBy(xpath = "//a[contains(text(),'Notification ID')]")
	public WebElement notificationIdTab;

	@FindBy(id = "notificationInput")
	public WebElement notificationIdTextbox;

	@FindBy(id = "notificationInputGo")
	public WebElement notificationSearchButton;

	@FindBy(xpath = "//a[contains(text(),'Single Notification')]")
	public WebElement singleNotificationTab;

	@FindBy(xpath = "//div[contains(text(),'Notification')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//a[contains(text(),'All Notifications')]")
	public WebElement allNotificationsTab;
	
	@FindBy(xpath = "//div[contains(text(),'Historical Notifications')]")
	public WebElement historicalNotificationHeaderText;
	
	@FindBy(xpath = "//th[contains(text(),'Explanatory Codes')]")
	public WebElement explanatoryCodesTableColumn;
	
	@FindBy(xpath = "//button[text()='Go']")
	public WebElement goButton;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;
	
	
	@FindBy(xpath = "//button[@class = 'btn btn-primary summaryActionBtn' and text() = 'Accept']")
	public List<WebElement> acceptButton;
	
	

	
	@FindBy(xpath = "//button[@class = 'btn btn-primary summaryActionBtn' and text() = 'Complete']")
	public List<WebElement> completeButton;
	
	@FindBy(xpath = "//button[@class = 'btn btn-primary summaryActionBtn' and text() = 'Reassign']")
	public List<WebElement> reassignButton;
	
	@FindBy(xpath = "//button[@class = 'btn btn-primary summaryActionBtn' and text() = 'Assign']")
	public List<WebElement> assignButton;

	@FindBy(xpath = "//th[contains(text(),'Doctor Code')]")
	public WebElement doctorCodeTableColumn;
	
	@FindBy(xpath = "//th[contains(text(),'Doctor Name')]")
	public WebElement doctorNameTableColumn;
	
	@FindBy(xpath = "//span[@id='orderStatusDateIcon']")
	public WebElement dateSortIcon;
	
	@FindBy(xpath = "//th[contains(text(),'Date')]")
	public WebElement dateColumn;
	
	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	public List<WebElement> acceptButtonList;
	
	@FindBy(xpath = "//button[@class = 'btn btn-secondary summaryActionBtn' and text() = 'Complete']")
	public List<WebElement> completeButtonList;
	
	@FindBy(xpath = "//button[@class = 'btn btn-secondary summaryActionBtn' and text() = 'Re-assign']")
	public List<WebElement> reassignButtonList;
	
	
	WebDriver driver = null;

	public LARS_NotificationPage(WebDriver driver) {
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

	public boolean searchOpenNotification(String code) {

		try {
			//ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			spinnersChecking();
			CommonFunctions.waitandClear(codeTextbox, 20);

			//codeTextbox.sendKeys(code);
			codeTextbox.sendKeys(code.substring(0, 2));
			codeTextbox.sendKeys(Keys.ENTER);
			
			searchButton.click();
			spinnersChecking();

			return CommonFunctions.waitForVisiblity(By.xpath("//td[contains(text(),'" + code.split(",")[1] + "')]"),
					10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean searchAllNotification(String code) {

		try {
			//ObjectHelper.driver.navigate().refresh();
			// Thread.sleep(5000);
			spinnersChecking();
			CommonFunctions.waitandClear(codeTextbox, 20);

			//codeTextbox.sendKeys(code);
			codeTextbox.sendKeys(code.substring(0, 2));
			codeTextbox.sendKeys(Keys.ENTER);
			
			searchButton.click();
			spinnersChecking();

			return CommonFunctions.waitForVisiblity(By.xpath("//td[contains(text(),'" + code.split(",")[1] + "')]"),
					10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	

	public boolean goToSingleNotification() {

		try {
			Thread.sleep(3000);
			singleNotificationTab.click();

			return CommonFunctions.waitForVisiblity(headerText, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchSingleNotificationByAccession(String prefix, String accession) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(prefixTextbox, 20);
			// to scroll up
			Thread.sleep(3000);
			
			prefixTextbox.sendKeys(Keys.UP);
			prefixTextbox.sendKeys(Keys.UP);
			prefixTextbox.sendKeys(Keys.UP);
			prefixTextbox.sendKeys(Keys.UP);

			prefixTextbox.sendKeys(prefix);
			accessionTextbox.clear();
			accessionTextbox.sendKeys(accession);
			Thread.sleep(2000);
			searchAccessionButton.click();
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(By.xpath("//a[contains(text(),'" + accession + "')]"), 10);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchSingleNotificationByNotificationId(String notificationId) {

		try {
			Thread.sleep(3000);
			notificationIdTab.click();

			CommonFunctions.waitForVisiblity(notificationIdTextbox, 20);
			notificationIdTextbox.sendKeys(notificationId);

			notificationSearchButton.click();
			spinnersChecking();
			return CommonFunctions.waitForVisiblity(By.xpath("//u[contains(text(),'" + notificationId + "')]"), 10);

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
	
	public boolean goToAllNotifications() {

		try {
			//Thread.sleep(3000);
			allNotificationsTab.click();
			spinnersChecking();

			return CommonFunctions.waitForVisiblity(historicalNotificationHeaderText, 20);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * DESCRIPTION: verify historical notification review,
	 * prefix RETURNS: list if result:
	 */
	
	public int verifyHistoricalNotificationResult(String aKey) {
	
		int aHistoricalNotificationsResult = 0;
		int attempt = 2;
		
		try {
			
			CommonFunctions.waitandClick(goButton, 30);	
			while (aHistoricalNotificationsResult == 0 && attempt !=0) {
				
					if (CommonFunctions.waitForVisiblity(explanatoryCodesTableColumn, 60)) {
					
						aHistoricalNotificationsResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aKey + "')]")).size();	
		
					}
					
					if (aHistoricalNotificationsResult == 0) {
						CommonFunctions.waitandClick(goButton, 30);
						attempt--;
						System.out.println("Number of attempt: " + attempt);
					}	
				}
				System.out.println("Number of Historical Notifications for this table found: " + aHistoricalNotificationsResult);
	
				return (aHistoricalNotificationsResult);
		//return CommonFunctions.waitForVisiblity(mainMenuPage.historicalAccessionsIcon, 20);
	
		} catch (Exception e) {
			return aHistoricalNotificationsResult;
		}
	
	}
	
	public void spinnersChecking() {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		
		try {
			
			
				startTime2 = 400;
				elapsedTime2 = startTime2 - 10;
				spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				
				while (spinnersExist == false && elapsedTime2 > 10) {
					elapsedTime2 = elapsedTime2 -10;
					spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				}
				// System.out.println("Spinners is not here or timeout: " + spinnersExist);
				
		} catch (Exception e) {
			System.out.println("Spinners is still here or timeout: " + spinnersExist);
		}
	}
	
	public boolean isSortDate() {
		
		try {
			//boolean result = false;
			ArrayList<String> obtainedList = new ArrayList<>(); 
		//	List<WebElement> elementList= driver.findElements(By.xpath("//button[text()='Accept']/..//../following-sibling::tr//td[8]"));
			List<WebElement> elementList= driver.findElements(By.xpath("//td[@class='ng-binding'][2]"));
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
	
	public boolean isSortDescendingDate() {
		
		try {
	
			
			CommonFunctions.waitandClick(dateColumn, 30);
			CommonFunctions.waitandClick(dateColumn, 30);
				
			CommonFunctions.waitandClick(filterSearchButton, 20);
				
			spinnersChecking();
			
			ArrayList<String> obtainedList = new ArrayList<>(); 
			List<WebElement> elementList= driver.findElements(By.xpath("//td[@class='ng-binding'][2]"));
			for (int i=0;i<elementList.size()-100;i++ ) {
				obtainedList.add(elementList.get(i).getText());
				System.out.println(i +" "+elementList.get(i).getText());
			}
		/*	
			for(WebElement we:elementList){
				obtainedList.add(we.getText());
			 //  break;
			}
		*/	
			ArrayList<String> sortedList = new ArrayList<>();   
			for(String s:obtainedList){
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
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
	
	public boolean isSortAccession() {
		
		try {
			//boolean result = false;
			ArrayList<String> obtainedList = new ArrayList<>(); 
		//	List<WebElement> elementList= driver.findElements(By.xpath("//button[text()='Complete']/..//../following-sibling::tr//td[4]//a"));
			List<WebElement> elementList= driver.findElements(By.xpath("//td[4]/a[@class='ng-binding']"));
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
	
	public boolean verifyDefaultButtonsState() {
		
		try {
			//when item is unassgined
			
			return (assignButton.get(0).isEnabled() &&	!completeButton.get(0).isEnabled());
			
		}catch (Exception e) {

			System.out.println(e.getMessage());
			return false;	
		}	
	}
	
	public boolean verifyAssignSelfButtonsState() {
		
		try {
			//assign the item to self
			
			assignButton.get(0).click();
			CommonFunctions.waitForVisiblity(reassignButton.get(0), 20);
			return (reassignButton.get(0).isEnabled() &&	completeButton.get(0).isEnabled());

		}catch (Exception e) {

			System.out.println(e.getMessage());
			return false;	
		}	
	}
	
	public boolean verifyAssignSomeoneButtonsState() {
		
		try {
			//assign the item to someone
			
			assignButton.get(0).click();
			CommonFunctions.waitForVisiblity(reassignButton.get(0), 20);
			return (reassignButton.get(0).isEnabled() &&	completeButton.get(0).isEnabled());

		}catch (Exception e) {

			System.out.println(e.getMessage());
			return false;	
		}	
	}
	
	public boolean verifyCompleteButtonsState() {
		
		try {
			//Click complete button
			
			assignButton.get(0).click();
			CommonFunctions.waitForVisiblity(reassignButton.get(0), 20);
			return (!reassignButton.get(0).isEnabled() &&	!completeButton.get(0).isEnabled());

		}catch (Exception e) {

			System.out.println(e.getMessage());
			return false;	
		}	
	}
	
	public boolean verifyDoctorCodeAndName() {
		
		try {
			//Click complete button
			
			return(CommonFunctions.waitForVisiblity(doctorCodeTableColumn, 20) && CommonFunctions.waitForVisiblity(doctorNameTableColumn, 20));
	
		}catch (Exception e) {

			System.out.println(e.getMessage());
			return false;	
		}	
	}
	
	public boolean verifyCompleteNotificationAcceptedBySomeone_BK() {
		
		boolean result = false;
		try {
			//Click complete button
			List<WebElement> acceptButtonList= driver.findElements(By.xpath("//button[@class = 'btn btn-primary summaryActionBtn' and text() = 'Accept']"));
			for(int i=0; i< acceptButtonList.size(); i++){
			   if (CommonFunctions.waitForVisiblity(acceptButtonList.get(i), 10)) {
				   acceptButtonList.get(i).click();
				   Thread.sleep(1000);
				   if (completeButtonList.get(i).isEnabled()) {
				   		completeButtonList.get(i).click();
				   		if (!completeButtonList.get(i).isEnabled() && !reassignButtonList.get(i).isEnabled()) {	
				   			result = true;
				   			break;
				   		}
				   		else {
				   			result = false;
				   			break;
				   		}
				   }
			   }   
			}
			return result;
		}catch (Exception e) {

			System.out.println(e.getMessage());
			return result;	
		}	
		
	}	

	
	public boolean verifyCompleteNotificationAcceptedBySomeone() {
		
		boolean result = false;
		try {
			//locate the table
			WebElement mytable =  ObjectHelper.driver.findElement(By.xpath("*//table[@class='table table-condensed table-striped']/tbody"));
			//locate rows of table
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			
			// Calculate no of rows in table
			int rows_count = rows_table.size(); //38
			
			for (int i=1; i<=rows_table.size(); i++ ) {

				if (CommonFunctions.waitForVisiblity(By.xpath("//tr["+(i)+"]//button[contains(text(),'Accept')]"), 10)) {
					 driver.findElement(By.xpath("//tr["+(i)+"]//button[contains(text(),'Accept')]")).click();
					 Thread.sleep(1000);
					 if(driver.findElement(By.xpath("//tr["+(i)+"]//button[contains(text(),'Complete')]")).isEnabled()) {
						 driver.findElement(By.xpath("//tr["+(i)+"]//button[contains(text(),'Complete')]")).click();
	//					 if(!driver.findElement(By.xpath("//tr["+(i)+"]//button[contains(text(),'Complete')]")).isEnabled() && !driver.findElement(By.xpath("//tr["+(i)+"]//md-button[contains(text(),'Reassign')]")).isEnabled()){ 
						 if(!driver.findElement(By.xpath("//tr["+(i)+"]//button[contains(text(),'Complete')]")).isEnabled() && driver.findElements(By.xpath("//tr["+(i)+"]//td[contains(text(),'Complete')]")).size()>0){ 
							 result = true;
							 break;
						 }
						 else {
							 result = false;
							 break;
						 }
					 }
				}
			}
			
			return result;
		}catch (Exception e) {

			System.out.println(e.getMessage());
			return result;	
		}	
		
	}	
	
}