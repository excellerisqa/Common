package ccofit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class OrderQueue {

	WebDriver driver;

	public static String userInfo = "//div[@class='navUserInfo']//div";
	@FindBy(xpath = "//div[@class='navUserInfo']//div")
	public static WebElement userInformation;

	public static String nextReqBtn = "btnNextRequisition";
	@FindBy(id = "btnNextRequisition")
	public static WebElement nextRequisition;

	public static String ordCodeFormPage = "modal-title";
	@FindBy(className = "modal-title")
	public static WebElement ordCdFormPage;

	public static String saveBtn = "btnSave";
	@FindBy(id = "btnSave")
	public static WebElement saveOrderBtn;

	public static boolean verifyNextReqDisplayed() {
		boolean nextReqDisplayed = false;
		int numRows = ObjectHelper.driver.findElements(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr"))
				.size();
		System.out.println("Value of numRows = " + numRows);
		int rowNumber = 1;

		for (int i = 1; i < (numRows + 1); i++) {
			if (verifyOrderLocked(i) == false) {
				rowNumber = i;
				break;
			}
		}
		String ordCode = getOrderCode(rowNumber);
		System.out.println("First unlock order = " + ordCode);
		nextRequisition.click();
		CommonFunctions.waitForVisiblity(ordCdFormPage, 20);
		String ordCode1 = ordCdFormPage.getText();
		System.out.println("Order code found after clicking next requisition = " + ordCode1);
		if ((ordCode.replaceAll(" ", "")).equalsIgnoreCase(ordCode1.replaceAll(" ", ""))) {
			nextReqDisplayed = true;
		}
		CommonFunctions.waitForVisiblity(saveOrderBtn, 20);
		saveOrderBtn.click();
		return nextReqDisplayed;
	}

	public static String openUnlockedOrder() {
		int numRows = ObjectHelper.driver.findElements(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr"))
				.size();
		int rowNumber = 1;
		for (int i = 1; i < (numRows + 1); i++) {
			System.out.println("Verifying if row number = " + i + "  is locked");
			boolean orderLocked = OrderQueue.verifyOrderLocked(i);
			System.out.println("OrderLocked = " + orderLocked);
			if (orderLocked == false) {
				rowNumber = i;
				break;
			}
		}
		String ordCode = getOrderCode(rowNumber);
		String ordStatus = getOrderStatus(rowNumber);
		System.out.println("Unlocked order found = " + ordCode + " and Order Status is " + ordStatus);
		nextRequisition.click();
		CommonFunctions.waitForVisiblity(ordCdFormPage, 20);
		String ordCode1 = ordCdFormPage.getText();
		System.out.println("Order code after clicking next Requisition = " + ordCode1);
		return ordCode1;
	}

	public static String openOrderCode(String orderCode) {
		int numRows = ObjectHelper.driver.findElements(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr"))
				.size();
		String ordCodeOpened = null;
		for (int i = 1; i < (numRows + 1); i++) {
			if (getOrderCode(i).equalsIgnoreCase(orderCode)) {
				if (verifyOrderLocked(i) == true) {
					ordCodeOpened = "False";
					System.out.println("Order is currently locked");
					break;
				} else {
					ObjectHelper.driver
							.findElement(By
									.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr[" + i + "]//td[5]//a"))
							.click();
					System.out.println("Order has been opened");
					ordCodeOpened = "True";
					break;
				}
			}
		}
		return ordCodeOpened;
	}

	public static String getOrderCode(int rowNumber) {
		String orderCode = ObjectHelper.driver
				.findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr[" + rowNumber + "]//td[3]"))
				.getText();
		System.out.println("OrderCode found in rowNumber " + rowNumber + " = " + orderCode);
		return orderCode;
	}

	public static String getOrderStatus(int rowNumber) {
		String orderStatus = ObjectHelper.driver
				.findElement(
						By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr[" + rowNumber + "]//td[5]//a"))
				.getText();
		return orderStatus;
	}

	public static void clickOrderNumber(int rowNumber) {
		ObjectHelper.driver
				.findElement(
						By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr[" + rowNumber + "]//td[5]//a"))
				.click();
	}

	public static boolean verifyOrderLocked(int rowNumber) {
		int ordLock = ObjectHelper.driver
				.findElements(
						By.xpath("//div[@class='k-grid-content k-auto-scrollable']//tr[" + rowNumber + "]//td[6]//i"))
				.size();
		if (ordLock > 0) {
			return true;
		} else {
			return false;
		}
	}

	public OrderQueue(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
