package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ObjectHelper {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String browsertype = null;

	public static String screenshotsFolder;
	public static String downloadsFolder;
	public static String reportsFolder;

	/******* Email Report Info *******/
	public static String testtitle = "";
	public static String startdate = "";
	public static String starttime = "";
	public static String endtime = "";
	public static int totaltests = 0;
	public static int totalfailed = 0;
	public static String reportfilepath = "";
	/***********************************/

	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;

	public static String placeholder_url = "https://google.com";
	public static String enviURL;
	public static String enviURL2;
	public static String enviURL3;
	public static String enviURL4;
	public static String dburl;
	public static String sessionid;
	public static boolean sendreportinemail = false;
	public static String dbname;
	public static String dbprefix;
	public static String state;
}
