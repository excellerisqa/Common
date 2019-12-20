package ccofit.objects;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class HomePage {

	WebDriver driver;

	public static String userInfo = "//div[@class='navUserInfo']//div";
	@FindBy(xpath = "//div[@class='navUserInfo']//div")
	public static WebElement userInformation;

	public static String orderLink = "//a[@href='/Order']";
	@FindBy(xpath = "//a[@href='/Order']")
	public static WebElement orderQueue;

	public static String reportsLink = "//a[@href='/Report']";
	@FindBy(xpath = "//a[@href='/Report']")
	public static WebElement reports;

	public static String searchLink = "//a[@href='/Search']";
	@FindBy(xpath = "//a[@href='/Search']")
	public static WebElement search;

	public static String problemQueueLink = "//a[@href='/Order/ProblemQueue']";
	@FindBy(xpath = "//a[@href='/Order/ProblemQueue']")
	public static WebElement problemQueue;

	public static String orderCodeTxtbox = "OrderCode";
	@FindBy(id = "OrderCode")
	public static WebElement searchOrderCode;

	public static String patNameTxtbox = "patientName";
	@FindBy(id = "patientName")
	public static WebElement searchPatName;

	public static String patHCNTxtbox = "PatientHCN";
	@FindBy(id = "PatientHCN")
	public static WebElement searchPatHCN;

	public static String ordQTable = "requisition-grid";
	@FindBy(id = "requisition-grid")
	public static WebElement orderQueueTable;

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		boolean verifyTS = true;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
				verifyTS = false;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return verifyTS;
	}

	public static Timestamp changeStringToTS(SimpleDateFormat formatter, String value) {
		try {
			Date date = formatter.parse(value);
			Timestamp timeStampDate = new Timestamp(date.getTime());
			return timeStampDate;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}

	public static void searchOrderCode(String orderCode) {
		CommonFunctions.waitForVisiblity(search, 25);
		search.click();
		CommonFunctions.waitForVisiblity(searchOrderCode, 20);
		searchOrderCode.sendKeys(orderCode);
		searchOrderCode.sendKeys(Keys.ENTER);
	}

	public static void searchHCN(String hcn) {
		CommonFunctions.waitForVisiblity(search, 25);
		search.click();
		CommonFunctions.waitForVisiblity(searchPatHCN, 20);
		searchPatHCN.sendKeys(hcn);
		searchPatHCN.sendKeys(Keys.ENTER);
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
