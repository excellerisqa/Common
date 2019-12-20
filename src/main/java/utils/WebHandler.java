package utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

import reporting.HTMLReportFormat;
import reporting.ReportHelper;
import reporting.SendMailUsingAuthentication;

public class WebHandler {

	public static void openBrowser() throws IOException {

		if (ObjectHelper.browsertype.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", new File(".", "\\Drivers\\chromedriver.exe").getCanonicalPath());
			//System.setProperty("webdriver.chrome.driver", new File(".", "\\Drivers\\chromedriver.exe").getCanonicalPath());

			///// To set the download folder
			String downloadFilepath = new File(".", ObjectHelper.downloadsFolder).getCanonicalPath();
			HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
			chromePreferences.put("profile.default_content_settings.popups", 0);
			chromePreferences.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePreferences);
			ObjectHelper.driver = new ChromeDriver(options);
			// ClearCache.chromeclear();
			setobjects();

		} else if (ObjectHelper.browsertype.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", new File(".", "\\Drivers\\geckodriver_v_0_23.exe").getCanonicalPath());
			FirefoxOptions ffOptions = new FirefoxOptions();
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("browser.download.folderList", 2);
			ffprofile.setPreference("browser.download.dir", new File(".", ObjectHelper.downloadsFolder).getCanonicalPath());
			ffprofile.setPreference("browser.download.useDownloadDir", true);
			ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
			ffprofile.setPreference("pdfjs.disabled", true);
			ffprofile.setPreference("geo.prompt.testing", true);
			ffprofile.setPreference("geo.prompt.testing.allow", true);
			ffprofile.setPreference("geo.enabled", true);
			// ffprofile.setPreference("geo.wifi.uri", "data:application/json,{\"location\":
			// {\"lat\": 50.3475367, \"lng\": 123.3496011}, \"accuracy\": 100.0}");
			ffprofile.setPreference("geo.wifi.uri", "data:application/json,{\"location\": {\"lat\": 49.2179903, \"lng\": -123.09431180000001}, \"accuracy\": 100.0}");

			// ffOptions.addPreference("browser.link.open_newwindow", 3);
			// ffprofile.setPreference("browser.link.open_newwindow.override.external", 3);
			// ffprofile.setPreference("browser.link.open_newwindow.restriction", 0);

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("elementScrollBehavior", 1);
			dc.setCapability("FirefoxDriver.PROFILE", ffprofile);

			ffOptions.setProfile(ffprofile);

			ObjectHelper.driver = new FirefoxDriver(ffOptions);

			ClearCache.firefoxclear();
			setobjects();

		} else if (ObjectHelper.browsertype.equals("edge")) {

			System.setProperty("webdriver.edge.driver", new File(".", "\\Drivers\\MicrosoftWebDriver.exe").getCanonicalPath());
			ObjectHelper.driver = new EdgeDriver();

			setobjects();
		} else if (ObjectHelper.browsertype.equals("ie")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.introduceFlakinessByIgnoringSecurityDomains();
			options.ignoreZoomSettings();

			System.setProperty("java.net.preferIPv4Stack", "true");
			System.setProperty("webdriver.ie.driver", new File(".", "\\Drivers\\IEDriverServer_32_3_11_0.exe").getCanonicalPath());
			ObjectHelper.driver = new InternetExplorerDriver(options);

			setobjects();
		} else if (ObjectHelper.browsertype.equals("safari")) {
			ObjectHelper.driver = new SafariDriver();
			ObjectHelper.driver.manage().window().maximize();
			setobjects();
		}

		setStartEmailInfo();
		//
	}

	public static void getSessionID() {
		try {
			if (ObjectHelper.browsertype.equals("chrome")) {

				// SessionId session = ((ChromeDriver) ObjectHelper.driver).getSessionId();
				ObjectHelper.sessionid = ObjectHelper.driver.manage().getCookieNamed("ASP.NET_SessionId").toString();

			} else if (ObjectHelper.browsertype.equals("firefox")) {
				// SessionId session = ((FirefoxDriver) ObjectHelper.driver).getSessionId();
				ObjectHelper.sessionid = ObjectHelper.driver.manage().getCookieNamed("ASP.NET_SessionId").toString();

			} else if (ObjectHelper.browsertype.equals("edge")) {
				// SessionId session = ((EdgeDriver) ObjectHelper.driver).getSessionId();
				ObjectHelper.sessionid = ObjectHelper.driver.manage().getCookieNamed("ASP.NET_SessionId").toString();

			} else if (ObjectHelper.browsertype.equals("ie")) {
				// SessionId session = ((InternetExplorerDriver)
				// ObjectHelper.driver).getSessionId();
				ObjectHelper.sessionid = ObjectHelper.driver.manage().getCookieNamed("ASP.NET_SessionId").toString();
			} else if (ObjectHelper.browsertype.equals("safari")) {
				ObjectHelper.sessionid = ObjectHelper.driver.manage().getCookieNamed("ASP.NET_SessionId").toString();
			}
		} catch (NullPointerException ne) {} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setobjects() {
		ObjectHelper.driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		ObjectHelper.driver.navigate().to(ObjectHelper.placeholder_url);
		ObjectHelper.driver.manage().window().maximize();
		ObjectHelper.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ObjectHelper.wait = new WebDriverWait(ObjectHelper.driver, 10);
	}

	public static void createextentreport(String title, String reportname, String url) {
		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();

			// create ExtentReport directory
			File file = new File(new File(".", ObjectHelper.reportsFolder).getAbsolutePath());
			if (!file.exists()) {
				file.mkdir();
			}

			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(".", ObjectHelper.reportsFolder + "//" + reportname + ".html")), "utf-8"));
			writer.write("");
			writer.close();

			ObjectHelper.htmlReporter = new ExtentHtmlReporter(new File(".", ObjectHelper.reportsFolder + "//" + reportname + ".html").getAbsolutePath());
			ObjectHelper.reports = new ExtentReports();

			ObjectHelper.reports.attachReporter(ObjectHelper.htmlReporter);
			ObjectHelper.reports.setSystemInfo("Environment URL", url);
			ObjectHelper.reports.setSystemInfo("Host Name", addr.getHostName());
			ObjectHelper.reports.setSystemInfo("User Name", System.getProperty("user.name"));
			ObjectHelper.reports.setSystemInfo("OS Version", System.getProperty("os.name"));

			ObjectHelper.htmlReporter.loadConfig(new File(".", ObjectHelper.reportsFolder + "//" + reportname + ".html").getAbsolutePath()); // modifying
			// report

			ObjectHelper.htmlReporter.config().setChartVisibilityOnOpen(true);
			ObjectHelper.htmlReporter.config().setDocumentTitle(title);
			ObjectHelper.htmlReporter.config().setReportName(reportname);
			ObjectHelper.htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

			ObjectHelper.reports.flush();
			ObjectHelper.reportfilepath = ObjectHelper.reportsFolder + "//" + reportname + ".html";

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closebrowser() {
		try {
			if (ObjectHelper.driver != null) {
				try {
					ObjectHelper.driver.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ObjectHelper.reports.flush();
				if (ObjectHelper.browsertype.equals("firefox")) {
					// Runtime.getRuntime().exec("cmd /c taskkill.exe /F /IM
					// geckodriver_3_11_32bit.exe");
					Runtime.getRuntime().exec("cmd /c taskkill.exe /F /IM geckodriver_3_11.exe");
				} else if (ObjectHelper.browsertype.equals("chrome")) {
					Runtime.getRuntime().exec("cmd /c taskkill.exe /F /IM chromedriver_2_35.exe");
				}
			}
			setCloseEmailInfo();
			ReportHelper rh = new ReportHelper();
			rh.formatting();
			SendMailUsingAuthentication send = new SendMailUsingAuthentication();
			HTMLReportFormat emailreport = setReportData();
			send.postMail(ObjectHelper.testtitle, emailreport.getHtmlBuffer().toString(), ObjectHelper.testtitle + ".pdf", ObjectHelper.sendreportinemail);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setupOutputFolder(String dirName) {
		CommonFunctions.createFolder("Output");
		CommonFunctions.createFolder("Output//" + dirName);
		CommonFunctions.createFolder("Output//" + dirName + "//Screenshots");
		CommonFunctions.createFolder("Output//" + dirName + "//DownloadedFiles");
		CommonFunctions.createFolder("Output//" + dirName + "//Reports");
		ObjectHelper.screenshotsFolder = "//Output//" + dirName + "//Screenshots";
		ObjectHelper.downloadsFolder = "//Output//" + dirName + "//DownloadedFiles";
		ObjectHelper.reportsFolder = "//Output//" + dirName + "//Reports";

	}

	public static void setStartEmailInfo() {
		Date todaydate = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

		ObjectHelper.startdate = DATE_FORMAT.format(todaydate);
		ObjectHelper.starttime = TIME_FORMAT.format(todaydate);
	}

	public static void setCloseEmailInfo() {
		Date todaydate = new Date();
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

		ObjectHelper.endtime = TIME_FORMAT.format(todaydate);
	}

	public static HTMLReportFormat setReportData() {
		HTMLReportFormat reportFormat = new HTMLReportFormat(ObjectHelper.testtitle);
		reportFormat.setReportTestDate(ObjectHelper.startdate);
		reportFormat.setReportStartTime(ObjectHelper.starttime);
		reportFormat.setReportEndTime(ObjectHelper.endtime);
		reportFormat.setTestExecutedCount(ObjectHelper.totaltests);
		reportFormat.setPassedCount(ObjectHelper.totaltests - ObjectHelper.totalfailed);
		reportFormat.setFailedCount(ObjectHelper.totalfailed);

		// for (int i = 0; i < 10; i++) {
		// HTMLReportFormat.reportList.add(new ReportData("10689", "Testing", "PASS",
		// "Nothing"));
		// }

		reportFormat.regenerateHTML();

		String url = reportFormat.getHtmlBuffer().toString();
		url = url.replaceAll("&", "&amp;");

		reportFormat.generatePDF(url);

		return reportFormat;

	}

	public static void openNewTab(String url) throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		// To switch to the new tab
		Thread.sleep(5000);
		ArrayList<String> tabs = new ArrayList<String>(ObjectHelper.driver.getWindowHandles());
		ObjectHelper.driver.switchTo().window(tabs.get(1));
		ObjectHelper.driver.navigate().to(url);
	}

	public static void closeCurrentTab(int tabno) {
		List<String> browserTabs = new ArrayList<String>(ObjectHelper.driver.getWindowHandles());
		ObjectHelper.driver.close();
		ObjectHelper.driver.switchTo().window(browserTabs.get(tabno));
	}

}
