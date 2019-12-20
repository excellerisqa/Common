package bloodMonitoring.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class Delegation {
	public WebDriver driver;

	@FindBy(id = "delegationFromDate")
	public static WebElement delegationFromDate;
	@FindBy(id = "delegationUntilDate")
	public static WebElement delegationUntilDate;
	@FindBy(xpath = "//div[@id='delegation-container']/div/div[2]/input[1]")
	public static WebElement delegationSetUp;
	@FindBy(css = "#Delegator_Id > option")
	public static List<WebElement> physiciansList;
	@FindBy(css = "#activeDelegationsTab > div > table > tbody > tr > td:nth-child(1)")
	public static List<WebElement> delegationsList;
	@FindBy(xpath = "//div[@id='delegation-list-container']/div/div[2]/input[1]")
	public static WebElement addNewDelegation;
	@FindBy(id = "btnBloodMonitor")
	public static WebElement bloodMonitor;
	@FindBy(xpath = "//div[@id=\"activeDelegationsTab\"]/div/table/tbody/tr[2]")
	public static WebElement delegationTab;
	@FindBy(xpath = "//div[@id='delegation-list-container']/div/div[2]/input[2]")
	public static WebElement delegationCloseButton;
	@FindBy(css = "#activeDelegationsTab > div > table > tbody > tr")
	public static List<WebElement> delegationRows;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement notificationstab;
	@FindBy(xpath = "//div[@id='notification-subscription-container']/div/div[1]/button")
	public static WebElement notificationsCloseButton;
	@FindBy(xpath = "//div[@id=\"notification-subscription-container\"]/div/div[2]/div/div[1]/table/tfoot/tr/td/a")
	public static WebElement notificationsSaveAndCloseButton;
	@FindBy(id = "patient_details_tab")
	public static WebElement PatientDetailsLink;

	public final static Logger logger = Logger.getLogger("Delegation");

	public Delegation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Delegation_16803(String Physician, String Physician2) throws Exception {
		CommonFunctions.waitForVisiblity(bloodMonitor, 8);
		// InfusionHistory.iframe(driver);
		ObjectHelper.driver.switchTo().frame("ifInbox");
		// clicking on Blood monitor Tab
		CommonFunctions.waitandClick(By.id("btnBloodMonitor"), 3);
		// clicking on delegation tab
		Thread.sleep(10000);
		CommonFunctions.waitandClick(By.xpath("/html/body/div[1]/div/div/div[5]/button"), 30);
		// clicking on add new delegation button
		CommonFunctions.waitForVisiblity(By.xpath("//div[@id='delegation-list-container']/div/div[2]/input[1]"), 30);
		logger.info("delegationRows.size()" + delegationRows.size());
		if (delegationRows.size() > 1) {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 2; i <= delegationsList.size() + 1; i++) {
				WebElement delegationFromName = ObjectHelper.driver
						.findElement(By.xpath("//div[@id='activeDelegationsTab']/div/table/tbody/tr[" + i + "]/td[1]"));
				list.add(delegationFromName.getText());
			}
			if (list.contains(Physician)) {
				logger.info("Delegation has already been created");
			} else {
				logger.info("creating Delegation");
				creatingDelegation(Physician, Physician2);
			}
		} else {
			logger.info("creating Delegation");
			creatingDelegation(Physician, Physician2);
		}

	}

	public void creatingDelegation(String Physician, String Physician2) throws Exception {
		CommonFunctions.waitForVisiblity(By.xpath("//div[@id='delegation-list-container']/div/div[2]/input[1]"), 30);
		addNewDelegation.click();
		CommonFunctions.waitForVisiblity(By.xpath("//div[@id=\"delegation-container\"]/div/div[1]"), 30);
		DelegationSelection(Physician, Physician2);
		String Date = InfusionHistory.date();
		String Date1 = date1();
		// clicking on from date
		delegationFromDate.click();
		delegationFromDate.clear();
		delegationFromDate.sendKeys(Date);
		delegationUntilDate.click();
		delegationUntilDate.clear();
		delegationUntilDate.sendKeys(Date);
		delegationSetUp.click();
		CommonFunctions.waitForVisiblity(By.id("activeDelegationsTab"), 10);
		for (int i = 2; i <= delegationsList.size() + 1; i++) {
			WebElement delegationFromName = ObjectHelper.driver
					.findElement(By.xpath("//div[@id='activeDelegationsTab']/div/table/tbody/tr[" + i + "]/td[1]"));

			System.out.println("delegationname : " + delegationFromName.getText());
			if (delegationFromName.getText().equals(Physician)) {
				List<String> resultList = Arrays.asList(Physician2, Date1, Date1);
				for (int col = 2; col <= 4; col++) {
					WebElement Name = ObjectHelper.driver.findElement(By
							.xpath("//div[@id='activeDelegationsTab']/div/table/tbody/tr[" + i + "]/td[" + col + "]"));

					logger.info("Name.getText()" + Name.getText());
					logger.info("resultList.get(col - 2)" + resultList.get(col - 2));
					Assert.assertTrue(Name.getText().equals(resultList.get(col - 2)));
				}
				break;
			}
		}

	}

	public void DelegationSelection(String Physician, String Physician2) throws Exception {
		// clicking on delegate alerts for
		CommonFunctions.waitandClick(By.id("Delegator_Id"), 30);
		CommonFunctions.waitForVisiblity(By.xpath("//select[@id='Delegator_Id']/option[2]"), 5);
		int x = physiciansList.size();
		logger.info("x = " + x);
		for (int i = 2; i <= physiciansList.size(); i++) {
			WebElement PhysicianName = ObjectHelper.driver
					.findElement(By.xpath("//select[@id='Delegator_Id']/option[" + i + "]"));
			System.out.println("patientname : " + PhysicianName.getText());
			if (PhysicianName.getText().equals(Physician)) {
				PhysicianName.click();
				break;
			}
		}
		// clicking on delegate alerts to
		CommonFunctions.waitandClick(By.id("Delegatee_Id"), 30);
		CommonFunctions.waitForVisiblity(By.xpath("//select[@id='Delegator_Id']/option[2]"), 5);
		for (int i = 2; i <= physiciansList.size(); i++) {
			WebElement PhysicianName = ObjectHelper.driver
					.findElement(By.xpath("//select[@id='Delegatee_Id']/option[" + i + "]"));
			System.out.println("patientname : " + PhysicianName.getText());
			if (PhysicianName.getText().equals(Physician2)) {
				PhysicianName.click();
				break;
			}
		}
	}

	public void DelegationDisplay_16807() {
		String[] delegations = XLHandler.readexcel("Sheet1", 7, "Test.xlsx");
		List<String> delegation = Arrays.asList(delegations[1], delegations[2], delegations[3], delegations[4]);
		for (int i = 1; i <= 4; i++) {
			WebElement delegationHeaderName = ObjectHelper.driver
					.findElement(By.xpath("//div[@id='activeDelegationsTab']/div/table/tbody/tr[1]/th[" + i + "]"));
			logger.info("Name.getText()" + delegationHeaderName.getText());
			logger.info("delegation.get(i-1))" + delegation.get(i - 1));
			Assert.assertTrue(delegationHeaderName.getText().equals(delegation.get(i - 1)));
		}
		logger.info("delegationTab.getAttribute(\"style\")" + delegationTab.getAttribute("style"));
		Assert.assertTrue(delegationTab.getAttribute("style").contains("background-color: yellow"));
		delegationCloseButton.click();
	}

	public static String date1() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String todaysDate = dateFormat.format(date);
		return todaysDate;
	}

}
