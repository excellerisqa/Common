package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Function;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	public static void waitandClick(By locator, int waitTime) throws Exception {
		WebElement element;

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);

		scrolltoElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		clickUsingJavaExecutor(element);

	}

	public static void waitandClear(By locator, int waitTime) throws Exception {
		WebElement element;

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);

		scrolltoElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		clearUsingJavaExecutor(element);

	}

	public static boolean waitForVisiblity(By locator, int waitTime) {
		@SuppressWarnings("unused")
		WebElement element;
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);

			scrolltoElement(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			result = true;
		} catch (Exception e) {

		}
		return result;
	}

	public static void waitandClick(WebElement element, int waitTime) throws Exception {
		ObjectHelper.driver.switchTo().activeElement();
		scrolltoElement(element);

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		clickUsingJavaExecutor(element);
	}

	public static void waitandClear(WebElement element, int waitTime) throws Exception {
		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		clearUsingJavaExecutor(element);
	}

	public static boolean waitForVisiblity(WebElement element, int waitTime) {
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();

			scrolltoElement(element);

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			// element = wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
			result = true;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return result;
	}

	public static void clickonmodalpopup(WebElement element) throws Exception {

		ObjectHelper.driver.switchTo().activeElement();

		Thread.sleep(2000);

		waitandClick(element, 30);

		ObjectHelper.driver.switchTo().activeElement();
	}

	public static void clickonmodalpopup(String pathstring) throws Exception {

		ObjectHelper.driver.switchTo().activeElement();

		Thread.sleep(2000);

		waitandClick(By.xpath(pathstring), 30);

		ObjectHelper.driver.switchTo().activeElement();
	}

	public static boolean clickonmodalpopup(String pathstring, String messagepath) throws Exception {
		boolean result = false;

		ObjectHelper.driver.switchTo().activeElement();

		Thread.sleep(2000);

		if (waitForVisiblity(By.xpath(messagepath), 10)) {
			result = true;
		}

		waitandClick(By.xpath(pathstring), 30);

		ObjectHelper.driver.switchTo().activeElement();

		return result;
	}

	public static void chainclicksonpopupOK() throws Exception {
		try {
			while (waitForVisiblity(By.xpath("//button[text()='OK']"), 3)) {
				// waitandClick(By.xpath("//button[text()='OK']"), 5);
				ObjectHelper.driver.switchTo().activeElement();

				WebElement element = ObjectHelper.driver.findElement(By.xpath("//button[text()='OK']"));
				JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
				js.executeScript("arguments[0].click();", element);

				ObjectHelper.driver.switchTo().activeElement();
			}
		} catch (NoSuchElementException ne) {} catch (TimeoutException te) {}

	}

	public static void chainclicksonpopupOKAndClose() throws Exception {
		try {
			while (waitForVisiblity(By.xpath("//button[text()='OK']"), 10)) {

				// waitandClick(By.xpath("//button[text()='OK']"), 5);
				ObjectHelper.driver.switchTo().activeElement();

				WebElement element = ObjectHelper.driver.findElement(By.xpath("//button[text()='OK']"));
				JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
				js.executeScript("arguments[0].click();", element);

				waitForVisiblity(By.xpath("//button[@ng-click='closeDeleted()']"), 3);
				ObjectHelper.driver.switchTo().activeElement();

				WebElement element1 = ObjectHelper.driver.findElement(By.xpath("//button[@ng-click='closeDeleted()']"));
				JavascriptExecutor js1 = (JavascriptExecutor) ObjectHelper.driver;
				js1.executeScript("arguments[0].click();", element1);

				ObjectHelper.driver.switchTo().activeElement();
			}

		} catch (NoSuchElementException ne) {} catch (TimeoutException te) {}

	}

	public static void chainclicksonpopup(WebElement element) throws Exception {
		try {
			while (waitForVisiblity(element, 10)) {

				// waitandClick(By.xpath("//button[text()='OK']"), 5);
				ObjectHelper.driver.switchTo().activeElement();

				JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
				js.executeScript("arguments[0].click();", element);
			}
		} catch (NoSuchElementException ne) {} catch (TimeoutException te) {}

	}

	public static String getcomboboxselectedvalue(WebElement element) throws Exception {
		String value = null;

		Select combolist = new Select(element);
		value = combolist.getFirstSelectedOption().getText();

		return value;
	}

	public static String getexception(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

	public static void clickUsingJavaExecutor(String xpath) {
		WebElement element = ObjectHelper.driver.findElement(By.xpath(xpath));

		scrolltoElement(element);

		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void clickUsingJavaExecutor(WebElement element) {
		try {
			scrolltoElement(element);

			JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearUsingJavaExecutor(String xpath) {
		WebElement element = ObjectHelper.driver.findElement(By.xpath(xpath));
		scrolltoElement(element);
		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].value=''", element);
	}

	public static void clearUsingJavaExecutor(WebElement element) {
		scrolltoElement(element);
		JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
		js.executeScript("arguments[0].value=''", element);
	}

	public static void scrolltoElement(WebElement element) {
		try {
			((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].scrollIntoView(false);", element);
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickonmodalpopup(By locator) throws Exception {

		ObjectHelper.driver.switchTo().activeElement();

		Thread.sleep(2000);

		waitandClick(locator, 30);

		ObjectHelper.driver.switchTo().activeElement();
	}

	public static boolean moveFile(String currentFileDirectory, String fileName, String newFileDirectory) {
		File file1 = new File(new File(".", currentFileDirectory + "//" + fileName).getAbsolutePath());
		File file2 = new File(new File(".", newFileDirectory + "//" + fileName).getAbsolutePath());
		String fName[] = fileName.split("\\.");
		String name;
		int i = 0;
		while (file2.exists()) {
			i++;
			name = fName[0] + i + "." + fName[1];
			file2 = new File(new File(".", newFileDirectory + "//" + name).getAbsolutePath());
		}
		if (file1.renameTo(file2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean copyFile(String sourceFileDirectory, String fileNameWithExtn, String newFileDirectory) {
		try {
			File srcFile = new File(new File(".", sourceFileDirectory + "//" + fileNameWithExtn).getAbsolutePath());
			File destFile = new File(new File(".", newFileDirectory + "//" + fileNameWithExtn).getAbsolutePath());
			FileUtils.copyFile(srcFile, destFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean copyFileNewName(String sourceFileDirectory, String fileNameWithExtn, String newFileDirectory, String newFileNameWithExtn) {
		try {
			File srcFile = new File(new File(".", sourceFileDirectory + "//" + fileNameWithExtn).getAbsolutePath());
			File destFile = new File(new File(".", newFileDirectory + "//" + newFileNameWithExtn).getAbsolutePath());
			FileUtils.copyFile(srcFile, destFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean waitForDownload(String fileName) {
		boolean err = false;
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(ObjectHelper.driver).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofSeconds(2));
			final File file1 = new File(new File(".", ObjectHelper.downloadsFolder + "//" + fileName).getAbsolutePath());
			Function<WebDriver, Boolean> func1 = new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver arg0) {
					return file1.exists();
				}
			};
			fluentWait1.until(func1);
		} catch (Exception e) {
			err = true;
		}
		return err;
	}

	public static boolean archiveFile(String currentFileDirectory, String fileName) {
		File file1 = new File(new File(".", currentFileDirectory + "//" + fileName).getAbsolutePath());
		File file = new File(new File(".", currentFileDirectory + "//Archive").getAbsolutePath());
		if (!file.exists()) {
			file.mkdir();
		}
		File file2 = new File(new File(".", currentFileDirectory + "//Archive" + "//" + fileName).getAbsolutePath());
		String fName[] = fileName.split("\\.");
		String name;
		int i = 0;
		while (file2.exists()) {
			i++;
			name = fName[0] + i + "." + fName[1];
			file2 = new File(new File(".", currentFileDirectory + "//Archive" + "//" + name).getAbsolutePath());
		}
		if (file1.renameTo(file2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void waitForVisiblityWithException(By locator, int waitTime) {
		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void createFolder(String folderName) {
		File folder = new File(new File(".", "//" + folderName).getAbsolutePath());

		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	/*
	 * if oriFullString = "Password1" then onlyStringPart should be "Password"
	 * Function would return Password2
	 */
	public static String incrementStringValue(String oriFullString, String onlyStringPart) {
		int oriNumPart = Integer.parseInt(oriFullString.substring(onlyStringPart.length()));
		String newNumPart = String.valueOf(oriNumPart + 1);
		return onlyStringPart + newNumPart;
	}

	/*
	 * parameters - could be dd or mm or yyyy or dd/mm etc
	 */
	public static String getToday(String formatddmm) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatddmm);
		Date date = new Date();
		return formatter.format(date);
	}

	public static String getDayName(int adddays) {
		String dayname = null;

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, adddays);

		Date date = calendar.getTime();

		dayname = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());

		return dayname;
	}

	public static String getDayNamefromDate(String stringdate) throws ParseException {
		String dayname = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

		Date date = formatter.parse(stringdate);

		dayname = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());

		return dayname;
	}

	public static String getDate(int adddays) {
		String dayname = null;

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, adddays);

		Date date = calendar.getTime();

		dayname = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date.getTime());

		return dayname;
	}

	public static String getDate(int adddays, String format) {
		String dayname = null;

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, adddays);

		Date date = calendar.getTime();

		dayname = new SimpleDateFormat(format, Locale.ENGLISH).format(date.getTime());

		return dayname;
	}

	public static String getDateNoname(int adddays) {
		String dayname = null;

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, adddays);

		Date date = calendar.getTime();

		dayname = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date.getTime());

		return dayname;
	}

	public static void main(String[] args) {
		try {
			ObjectHelper.sessionid = "ASP.NET_SessionId=lhya4minphp5g1akh0q0a1zc";
			// JSONArray jsonarray = new JSONArray();
			// jsonarray = CommonFunctions.getJsonResponse("GET",
			// "http://10.1.1.139/Location/GetSites?address=vancouver&openEarly=false&openSundays=false&wheelChairAccessible=false&doesECG=false&holterMonitoring=false&bloodPressureMonitoring=false&serveAutism=false&getCheckedOnline=false&openSaturdays=false");
			//
			// for (int k = 0; k < jsonarray.length(); k++) {
			// JSONObject objectname = new JSONObject(jsonarray.get(k).toString());
			//
			// System.out.println("Site ID : " + objectname.getInt("SiteID"));
			// }

			@SuppressWarnings("unused")
			ArrayList<String> availabledatelist = new ArrayList<>();

			String location = URLEncoder.encode("Current Location:49.134186899999996|-122.8604531", "UTF-8");

			JSONArray availabeldatesarray = CommonFunctions.getJsonResponse("GET", "http://10.1.1.115:44319/Location/GetSites?address=" + location + "&openEarly=false" + "&openSundays=false&wheelChairAccessible=false&doesECG=false&holterMonitoring=false&bloodPressureMonitoring=false&serveAutism=false&getCheckedOnline=false&openSaturdays=false");

			for (int k = 0; k < availabeldatesarray.length(); k++) {

				System.out.println(availabeldatesarray.getString(k).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JSONArray getJsonResponse(String requesttype, String url) throws Exception {
		// JSONObject jsonresult = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		WebHandler.getSessionID();

		try {
			HttpResponse response;
			if (requesttype.equals("POST")) {
				HttpPost request = new HttpPost(url.replace(" ", "+"));
				request.addHeader("content-type", "application/json");
				request.setHeader("Cookie", ObjectHelper.sessionid);

				SSLTrustStore.ssltrustinstall();

				response = httpClient.execute(request);

				HttpEntity entity = response.getEntity();

				if (entity != null) {
					InputStream instream = entity.getContent();
					String result = convertStreamToString(instream);

					// jsonresult = new JSONObject(result);
					jsonarray = new JSONArray(result);

					instream.close();
				}
			} else if (requesttype.equals("GET")) {
				HttpGet request = new HttpGet(url.replace(" ", "+"));
				request.addHeader("content-type", "application/json");
				request.setHeader("Cookie", ObjectHelper.sessionid);

				SSLTrustStore.ssltrustinstall();

				response = httpClient.execute(request);

				HttpEntity entity = response.getEntity();

				if (entity != null) {
					InputStream instream = entity.getContent();
					String result = convertStreamToString(instream);

					// jsonresult = new JSONObject(result);
					jsonarray = new JSONArray(result);

					instream.close();
				}
			}
		} catch (SSLHandshakeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw ex;
		} finally {
			httpClient.close();
		}
		return jsonarray;
	}

	public static JSONArray getJsonResponses(String requesttype, String url) throws Exception {
		// JSONObject jsonresult = new JSONObject();
		JSONArray jsonarray = new JSONArray();

		WebHandler.getSessionID();

		try {
			if (requesttype.equals("POST")) {
				SSLTrustStore.ssltrustinstall();
				URL urlForGetRequest = new URL(url.replace(" ", "+"));
				String readLine = null;
				HttpsURLConnection conection = (HttpsURLConnection) urlForGetRequest.openConnection();
				conection.setRequestMethod("POST");
				conection.setRequestProperty("content-type", "application/json");
				conection.setRequestProperty("Cookie", ObjectHelper.sessionid);

				int responseCode = conection.getResponseCode();

				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
					StringBuffer response = new StringBuffer();
					while ((readLine = in.readLine()) != null) {
						response.append(readLine);
					}
					in.close();

					// jsonresult = new JSONObject(result);
					jsonarray = new JSONArray(response.toString());

				}
			} else if (requesttype.equals("GET")) {
				SSLTrustStore.ssltrustinstall();
				URL urlForGetRequest = new URL(url.replace(" ", "+"));
				String readLine = null;
				HttpsURLConnection conection = (HttpsURLConnection) urlForGetRequest.openConnection();
				conection.setRequestMethod("GET");
				conection.setRequestProperty("content-type", "application/json");
				conection.setRequestProperty("Cookie", ObjectHelper.sessionid);

				int responseCode = conection.getResponseCode();

				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
					StringBuffer response = new StringBuffer();
					while ((readLine = in.readLine()) != null) {
						response.append(readLine);
					}
					in.close();

					// jsonresult = new JSONObject(result);
					jsonarray = new JSONArray(response.toString());
				}
			}
		} catch (SSLHandshakeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw ex;
		}
		return jsonarray;
	}

	private static String convertStreamToString(InputStream is) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/*
	 * DESCRIPTION: Gets message on modal pop up and closes it (created for BCLIS)
	 * PARAMETER: WebElement for message and WebElement for the close button on
	 * modal RETURNS : Message on modal Author: Bhavna Karanjekar Modified By:
	 */
	public static String getMessageOnModalPopupAndClose(WebElement messageElement, WebElement closeElement) throws Exception {

		String messageOnModal = "";
		ObjectHelper.driver.switchTo().activeElement();

		Thread.sleep(2000);
		if (waitForVisiblity(messageElement, 10)) {
			messageOnModal = messageElement.getText();
		}
		waitandClick(closeElement, 30);
		ObjectHelper.driver.switchTo().activeElement();
		return messageOnModal;
	}

	/*
	 * DESCRIPTION: wait for alert and accept (created for BCLIS) PARAMETER: wait
	 * time RETURNS : true of false Author: Bhavna Karanjekar Modified By:
	 */
	public static boolean waitForAlertAndAccept(int waitTime) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			wait.until(ExpectedConditions.alertIsPresent());

			ObjectHelper.driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * DESCRIPTION: wait for alert and get message on alert (created for BCLIS)
	 * PARAMETER: waitTime RETURNS : Message on alert Author: Bhavna Karanjekar
	 * Modified By:
	 */
	public static String waitForAlertAndGetMessage(int waitTime) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			wait.until(ExpectedConditions.alertIsPresent());

			return ObjectHelper.driver.switchTo().alert().getText();

		} catch (Exception e) {
			return "error";
		}

	}

	/*
	 * DESCRIPTION: wait for Tab to Open, waits till the expected number of windows
	 * (created for BCLIS) PARAMETER: expected number of windows and wait time
	 * RETURNS : True or false Author: Bhavna Karanjekar Modified By:
	 */
	public static boolean waitForNewTabToOpen(int numberOfWindowsExpected, int waitTime) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindowsExpected));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean isElementClickable(WebElement webe) {

		try {
			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void ClearAndSetText(WebElement element, String text) {
		Actions navigator = new Actions(ObjectHelper.driver);
		navigator.click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).sendKeys(text).perform();
	}

	public static void sendKeysUsingJavaExecutor(WebElement element, String value) {
		((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].value='" + value + "'", element);
	}

	/* incrementing number of days to a date, also can pass required format */
	public static String incrementDate(String date, String format, int incrementDays) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat(format).parse(date));
		cal.add(Calendar.DATE, incrementDays);
		date = new SimpleDateFormat(format).format(cal.getTime());
		return date;
	}

	public static boolean checkElementDisplayed(WebElement element) {
		boolean result = false;
		try {

			if (element.isDisplayed()) {
				result = true;
			}

		} catch (Exception e) {}
		return result;
	}

	/* generate the random alphanumeric string by given length */
	public static String getSaltString(int aKeyLength) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < aKeyLength) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	/*
	 * generate the random alphanumeric string by given length and value which
	 * doesn't match
	 */
	public static String getSaltStringOnlyInt(int aKeyLength) {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < aKeyLength) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	/* generate the random number by putting min and max value */
	/*
	 * make sure the min should be small than max. e.g 10000,99999 as there is no
	 * checking for own use
	 */
	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static String changeDateFormat(String currentDate, String currentDateFormat, String newDateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(currentDateFormat);
		Date d = sdf.parse(currentDate);
		sdf.applyPattern(newDateFormat);
		String newDate = sdf.format(d);
		return newDate;
	}

	public static boolean isAlertPresent() {
		try {
			ObjectHelper.driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean waitForDownload(String fileName, int time) {
		boolean err = false;
		try {
			Thread.sleep(time);
			final File file1 = new File(new File(".", ObjectHelper.downloadsFolder + "//" + fileName).getAbsolutePath());

			if (file1.exists()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			err = true;
		}
		return err;
	}

	/* generate the random alphanumeric string by given length */
	public static String getSaltStringCaseSensitve(int aKeyLength) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijlmnopqrstuvwxyz@!#$%^&*";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < aKeyLength) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static void doubleClick(WebElement element) throws Exception {
		Actions action = new Actions(ObjectHelper.driver);
		// Double click
		action.doubleClick(element).perform();
	}

	public static boolean waitForInVisiblity(WebElement element, int waitTime) {
		boolean result = false;
		try {
			ObjectHelper.driver.switchTo().activeElement();

			scrolltoElement(element);

			WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
			// element = wait.until(ExpectedConditions.elementToBeClickable(element));
			result = wait.until(ExpectedConditions.invisibilityOf(element));
			// result = true;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return result;
	}

	public static String getDecimalvalue(double value) throws Exception {
		// This is to show symbol . instead of ,
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		// Define the maximum number of decimals (number of symbols #)
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		return df.format(value);
	}

	public static String getNcharactersfromString(int length, String value) throws Exception {
		return value.substring(0, Math.min(value.length(), length));
	}

	public static int getMonthNumberfromName(String monthname) throws ParseException {
		Date date = new SimpleDateFormat("MMMM").parse(monthname);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static boolean waitForVisiblityList(List<WebElement> aWebElementList, int waitTime, int aNumberOfOption) {
		boolean result = false;
		int counter = 0;
		try {

			for (WebElement aWebElement : aWebElementList) {

				ObjectHelper.driver.switchTo().activeElement();

				scrolltoElement(aWebElement);

				WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, waitTime);
				// element = wait.until(ExpectedConditions.elementToBeClickable(element));
				aWebElement = wait.until(ExpectedConditions.visibilityOf(aWebElement));
				counter++;
			}
			if (counter == aNumberOfOption) {
				result = true;
			}
			System.out.println("Number of webelment found: " + counter + " " + aNumberOfOption + " expected");

		} catch (Exception e) {
			// e.printStackTrace();
		}
		return result;
	}

	public static String getNofromDate(String sourceformat, String stringdate, String targetformat) throws ParseException {
		String day = null;
		SimpleDateFormat formatter = new SimpleDateFormat(sourceformat);

		Date date = formatter.parse(stringdate);

		day = new SimpleDateFormat(targetformat, Locale.ENGLISH).format(date.getTime());

		return day;
	}
}
