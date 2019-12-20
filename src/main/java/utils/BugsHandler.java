package utils;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import beans.TestStepsBean;
import reporting.ReportHelper;

public class BugsHandler {
	public static String bugtitle = null;
	public static int stepcount = 1, attachmentcount = 0;

	public static CreateBugTFS cbtfs = new CreateBugTFS();

	static volatile XSSFWorkbook excelWorkbook;
	static XSSFSheet excelSheet;
	static XSSFCell Cell;

	static volatile File TestDatafile;

	private static File[] attachments = new File[100000];
	static String VSTSID = "";

	public static ArrayList<TestStepsBean> stepslist = new ArrayList<TestStepsBean>();

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		BugsHandler bh = new BugsHandler();
		// bh.updatebuglog("TC_ID", "Hello", 10);
		// bh.getactionstep(772, 2);
		// bh.getexpectedstep(772, 2);
		// TFSAccess tf = new TFSAccess("Enterprise");
		bh.getAllSteps(10629);

		for (int i = 0; i < stepslist.size(); i++) {
			System.out.println("Action Step :" + stepslist.get(i).getActionstep());
			System.out.println("Expected Step :" + stepslist.get(i).getExpectedstep());
		}
	}

	public BugsHandler() {
		try {
			TestDatafile = new File(new File(".", "//TestData//Buglog.xlsx").getAbsolutePath());
			FileInputStream fis = new FileInputStream(new File(".", "//TestData//Buglog.xlsx").getAbsolutePath());
			excelWorkbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void breakdownTestResult(boolean error, boolean bugflag, boolean exceptionflag, String tcid, String Assignedto, String iterationpath, String Createdby, String area, int relatedlinkid,
			String newtcid) throws Exception {
		createbug(error, bugflag, exceptionflag, tcid, Assignedto, iterationpath, Createdby, area, relatedlinkid);
		ObjectHelper.test = ObjectHelper.reports.createTest(newtcid);
	}

	public void createbug(boolean error, boolean bugflag, boolean exceptionflag, String tcid, String Assignedto, String iterationpath, String Createdby, String area, int relatedlinkid)
			throws Exception {
		ObjectHelper.totaltests++;
		ReportHelper rh = new ReportHelper();

		String tcids[] = tcid.split("_");

		String testtitle = CreateBugTFS.getTCTitle(Integer.parseInt(tcids[tcids.length - 1]));

		if (bugflag) { // true
			if (exceptionflag) { // true
				if (ObjectHelper.test.getStatus().toString() == "fail" || error) { // Test Fail=true or Exception=true
					finalbugcall(tcid, Assignedto, iterationpath, Createdby, relatedlinkid, area);
					ObjectHelper.totalfailed++;
					rh.setTestResult(tcids[tcids.length - 1], testtitle, ObjectHelper.test.getStatus().toString(), bugtitle); // set Fail data
					assertEquals(true, false);
				} else {
					rh.setTestResult(tcids[tcids.length - 1], testtitle, ObjectHelper.test.getStatus().toString(), ""); // set Pass data
					resetbugtracking();
				}
			} else {
				if (ObjectHelper.test.getStatus().toString() == "fail" && !error) { // Test Fail=true and Exception=false
					ObjectHelper.totalfailed++;
					rh.setTestResult(tcids[tcids.length - 1], testtitle, ObjectHelper.test.getStatus().toString(), bugtitle); // set Fail data
					try {
						finalbugcall(tcid, Assignedto, iterationpath, Createdby, relatedlinkid, area);
					} catch (Exception e) {
						e.printStackTrace();
					}
					assertEquals(true, false);
				} else if (ObjectHelper.test.getStatus().toString() != "fail" && !error) { // Test Pass and No Exception
					String[] bugid = findbuginlog(tcid);
					if (bugid != null && bugid.length > 0) {
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Date date = new Date();

						for (String element : bugid) {
							if (element != null) {
								String bugstate = CreateBugTFS.getBugState(Integer.parseInt(element));

								if (bugstate.equalsIgnoreCase("Resolved")) {
									CreateBugTFS.closeBugState(Integer.parseInt(element), Assignedto);
									updatebuglog(Integer.parseInt(element), "Closed", dateFormat.format(date));
								}
							}
						}
					}

					resetbugtracking();
				} else {
					resetbugtracking();
				}
			}
		} else {
			if (ObjectHelper.test.getStatus().toString().equals("fail") || error) {
				ObjectHelper.totalfailed++;
				rh.setTestResult(tcids[tcids.length - 1], testtitle, ObjectHelper.test.getStatus().toString(), bugtitle); // set Fail data
				assertEquals(true, false);
			} else {
				rh.setTestResult(tcids[tcids.length - 1], testtitle, ObjectHelper.test.getStatus().toString(), ""); // set Pass data
			}
			resetbugtracking();
		}
	}

	public void finalbugcall(String tcid, String Assignedto, String iterationpath, String Createdby, int relatedlinkid, String area) throws Exception {
		CreateBugTFS cbtfs = new CreateBugTFS();
		// If bug not found then create bug and update log
		int bugid = findbuginlog(tcid, bugtitle);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();

		if (bugid == 0) {

			int nebugid = cbtfs.createTFSBug(BugsHandler.bugtitle, Assignedto, iterationpath, Createdby, area);

			if (nebugid != 00000000) {
				uploadalltestattachments(nebugid);
				if (relatedlinkid != 0) {
					cbtfs.AddRelatedlinktoBug(nebugid, relatedlinkid);
				}
				String tcids[] = tcid.split("_");
				cbtfs.AddRelatedlinktoBug(nebugid, Integer.parseInt(tcids[tcids.length - 1]));
				cbtfs.updateTCTags(Integer.parseInt(tcids[tcids.length - 1]), "Failed");
				// cbtfs.updateTCTags(105, "Failed");

				addtobuglog(tcid, bugtitle, nebugid, CreateBugTFS.getBugState(nebugid), dateFormat.format(date));
			}

		} else {
			// Check if Bug is Closed then Reactivate else do nothing
			String bugstate = CreateBugTFS.getBugState(bugid);
			if (bugstate.equalsIgnoreCase("Closed") || bugstate.equalsIgnoreCase("Resolved")) {
				CreateBugTFS.activateBugState(bugid, Assignedto);
				updatebuglog(bugid, "Active", dateFormat.format(date));
			} else {
				updatebuglog(bugid, bugstate, dateFormat.format(date));
			}
		}
		resetbugtracking();
	}

	public void resetbugtracking() {
		// Reset if Test Passed
		CreateBugTFS.steps = new StringBuffer();
		cbtfs.count = 0;
		bugtitle = "";
		BugsHandler.stepcount = 1;
		if (BugsHandler.stepslist != null) {
			BugsHandler.stepslist.clear();
		}
	}

	public int findbuginlog(String tcid, String title) throws Exception {
		int bugid = 0;
		try {

			int maxrows = getNumberOfRows(0);

			for (int i = 1; i < maxrows; i++) {
				String[] data = XLHandler.readexcel(0, i, "Buglog.xlsx");

				// search for string in array string
				if (data[0].equalsIgnoreCase(tcid)) {
					if (data[1].replaceAll(" +", "").toLowerCase().equalsIgnoreCase(title.replaceAll(" +", "").toLowerCase())) {
						bugid = Integer.parseInt(data[2]);
						break;
					}
				}
			}
		} catch (Exception e) {
			bugid = 0;
		}

		return bugid;
	}

	public String[] findbuginlog(String tcid) {
		String[] bugid = new String[20];
		try {
			int maxrows = getNumberOfRows(0);
			int count = 0;

			for (int i = 1; i < maxrows; i++) {
				String[] data = XLHandler.readexcel(0, i, "Buglog.xlsx");

				// search for string in array string
				if (data[0].equalsIgnoreCase(tcid)) {
					if (!data[3].equals("Closed")) {
						bugid[count] = data[2];
						count++;
					}
				}
			}
		} catch (Exception e) {}
		return bugid;
	}

	public void addtobuglog(String tcid, String title, int bugid, String bugstate, String date) {
		int maxrows = getNumberOfRows(0);

		excelSheet = excelWorkbook.getSheetAt(0);
		excelSheet.createRow(maxrows);

		setDatabyCell(0, maxrows, 0, tcid);
		setDatabyCell(0, maxrows, 1, title.toLowerCase().replaceAll(" +", ""));
		setDatabyCell(0, maxrows, 2, Integer.toString(bugid));
		setDatabyCell(0, maxrows, 3, bugstate);
		setDatabyCell(0, maxrows, 4, date);
	}

	public void updatebuglog(int bugid, String newbugstate, String date) {
		int bugrowtoupdate;
		try {
			bugrowtoupdate = getrownumofvalue(Integer.toString(bugid), 0, "Buglog.xlsx");

			setDatabyCell(0, bugrowtoupdate, 3, newbugstate);
			setDatabyCell(0, bugrowtoupdate, 4, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addactionstep(String stepdata) throws Exception {
		ObjectHelper.test.pass(stepdata);

		cbtfs.addbugstep("Step " + stepcount + ": " + stepdata);
		bugtitle = stepdata;
		stepcount++;
	}

	public void addexpected(String stepdata) throws Exception {
		ObjectHelper.test.fail(stepdata);
		((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].style.border='3px solid red'", ObjectHelper.driver.switchTo().activeElement());
		cbtfs.addbugstep("Expected: " + stepdata);
		// Assert.assertTrue(false);
		bugtitle = stepdata;

		String screenshotpath = Screenshots.takeScreenshot(VSTSID + "_" + attachmentcount);
		attachments[attachmentcount] = new File(screenshotpath);
		ObjectHelper.test.addScreenCaptureFromPath(screenshotpath);
		attachmentcount++;
	}

	public void addtestresult(String stepdata) throws Exception {

		ObjectHelper.test.fail(stepdata);
		cbtfs.addbugstep("Actual Result: " + stepdata + "<br>");
		bugtitle = stepdata;

		attachments[attachmentcount] = new File(Screenshots.takeScreenshot(stepdata.replaceAll(" ", "_").substring(0, 15)));
		attachmentcount++;
	}

	public void addactionstep(int tcid, int stepno) throws Exception {
		String stepdata = getactionstep(tcid, stepno);

		ObjectHelper.test.pass(stepdata);

		cbtfs.addbugstep("Step " + stepcount + ": " + stepdata);

		stepcount++;
	}

	public void addexpected(int tcid, int stepno) throws Exception {
		String stepdata = getexpectedstep(tcid, stepno);
		VSTSID = "VSTS_ID_" + Integer.toString(tcid);

		ObjectHelper.test.fail(stepdata);
		// Assert.assertTrue(false);

		cbtfs.addbugstep("Expected Result: " + stepdata + "<br>");
		bugtitle = stepdata;

		((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].style.border='3px solid red'", ObjectHelper.driver.switchTo().activeElement());
		String screenshotpath = Screenshots.takeScreenshot(VSTSID + "_" + attachmentcount);
		attachments[attachmentcount] = new File(screenshotpath);
		ObjectHelper.test.addScreenCaptureFromPath(screenshotpath);
		attachmentcount++;
	}

	public void addtestresult(int tcid, int stepno) throws Exception {
		String stepdata = getexpectedstep(tcid, stepno);

		ObjectHelper.test.fail(stepdata);
		cbtfs.addbugstep("Actual Result: " + stepdata + "<br>");
		bugtitle = stepdata;

		attachments[attachmentcount] = new File(Screenshots.takeScreenshot(stepdata.replaceAll(" ", "_").substring(0, 15)));
		attachmentcount++;
	}

	public void addactionstep(int stepno) throws Exception {
		if (stepslist != null && stepslist.size() > 0) {
			String stepdata = null;

			for (int i = 0; i < stepslist.size(); i++) {
				if (stepslist.get(i).getStepno().equals(Integer.toString(stepno))) {
					stepdata = stepslist.get(i).getActionstep();
					break;
				}
			}

			ObjectHelper.test.pass(stepdata);

			cbtfs.addbugstep("Step " + stepcount + ": " + stepdata);

			// Thread.sleep(5000);
			// ((JavascriptExecutor)
			// ObjectHelper.driver).executeScript("arguments[0].style.border='3px solid
			// red'", ObjectHelper.driver.switchTo().activeElement());
			//
			// String screenshotpath = Screenshots.takeScreenshot(VSTSID + "_" +
			// attachmentcount);
			// attachments[attachmentcount] = new File(screenshotpath);
			// ObjectHelper.test.addScreenCaptureFromPath(screenshotpath);
			// attachmentcount++;

			stepcount++;
		}
	}

	public void addexpected(int stepno) throws Exception {

		if (stepslist != null && stepslist.size() > 0) {
			String stepdata = null;

			for (int i = 0; i < stepslist.size(); i++) {
				if (stepslist.get(i).getStepno().equals(Integer.toString(stepno))) {
					stepdata = stepslist.get(i).getExpectedstep();
					break;
				}
			}

			ObjectHelper.test.fail(stepdata);

			// Assert.assertTrue(false);

			cbtfs.addbugstep("Expected Result: " + stepdata + "<br>");
			bugtitle = stepdata;

			((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].style.border='3px solid red'", ObjectHelper.driver.switchTo().activeElement());
			// ((JavascriptExecutor)
			// ObjectHelper.driver).executeScript("arguments[0].value='" + stepdata + "'",
			// ObjectHelper.driver.switchTo().activeElement());

			String screenshotpath = Screenshots.takeScreenshot(VSTSID + "_" + attachmentcount);
			attachments[attachmentcount] = new File(screenshotpath);
			ObjectHelper.test.addScreenCaptureFromPath(screenshotpath);
			attachmentcount++;
		}
	}

	public void addexpected(int stepno, WebElement element) throws Exception {

		if (stepslist != null && stepslist.size() > 0) {
			String stepdata = null;

			for (int i = 0; i < stepslist.size(); i++) {
				if (stepslist.get(i).getStepno().equals(Integer.toString(stepno))) {
					stepdata = stepslist.get(i).getExpectedstep();
					break;
				}
			}

			ObjectHelper.test.fail(stepdata);

			cbtfs.addbugstep("Expected Result: " + stepdata + "<br>");
			bugtitle = stepdata;

			((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].style.border='3px solid red'", element);

			String screenshotpath = Screenshots.takeScreenshot(VSTSID + "_" + attachmentcount);
			attachments[attachmentcount] = new File(screenshotpath);
			ObjectHelper.test.addScreenCaptureFromPath(screenshotpath);
			attachmentcount++;
		}
	}

	public void addexpected(String stepdata, WebElement element) throws Exception {
		ObjectHelper.test.fail(stepdata);
		((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].style.border='3px solid red'", element);
		cbtfs.addbugstep("Expected: " + stepdata);
		// Assert.assertTrue(false);
		bugtitle = stepdata;
		String screenshotpath = Screenshots.takeScreenshot(VSTSID + "_" + attachmentcount);
		attachments[attachmentcount] = new File(screenshotpath);
		ObjectHelper.test.addScreenCaptureFromPath(screenshotpath);
		attachmentcount++;
	}

	public ArrayList<TestStepsBean> getAllSteps(int tcid) throws Exception {
		// ObjectHelper.test = ObjectHelper.reports.createTest("VSTS_ID_" + tcid);

		String actionsteps = "", expectedsteps = "";
		String step = CreateBugTFS.getTestStep(tcid);
		VSTSID = "VSTS_ID_" + Integer.toString(tcid);

		String[] splitintosteps = StringUtils.substringsBetween(step, "<step", "</step>");

		for (int i = 0; i < splitintosteps.length; i++) {

			String[] splitintoactionandexpected = StringUtils.substringsBetween(splitintosteps[i].toString(), "<parameterizedString", "</parameterizedString>");

			for (int j = 0; j < splitintoactionandexpected.length; j++) {

				// String[] secondlevelsplit =
				// StringUtils.substringsBetween(splitintoactionandexpected[j].toString(), ">",
				// ".&lt");
				//
				// if (j == 0) {
				// actionsteps =
				// secondlevelsplit[0].substring(secondlevelsplit[0].lastIndexOf(";") +
				// 1).trim();
				// } else if (j == 1) {
				// expectedsteps =
				// secondlevelsplit[0].substring(secondlevelsplit[0].lastIndexOf(";") +
				// 1).trim();
				// }

				if (j == 0) {
					if (splitintoactionandexpected[j].toString() != null) {
						actionsteps = htmltoxmlformatter(splitintoactionandexpected[j].toString());
					}
				} else if (j == 1) {
					if (splitintoactionandexpected[j].toString() != null) {
						expectedsteps = htmltoxmlformatter(splitintoactionandexpected[j].toString());
					}
				}
			}
			stepslist.add(new TestStepsBean(Integer.toString(i + 1), actionsteps, expectedsteps));
			actionsteps = "";
			expectedsteps = "";
		}
		return stepslist;
	}

	public String htmltoxmlformatter(String result1) {
		String result = result1;

		result = result.replaceAll("isformatted=\"true\">", "");
		result = result.replaceAll("&nbsp;", "");
		result = result.replaceAll("nbsp;", " ");
		result = result.replaceAll("&lt;", "<");
		result = result.replaceAll("&gt;", ">");
		result = result.replaceAll("&amp;", "");
		result = result.replaceAll("amp;", "&");
		result = result.replaceAll("&guot;", "\"");
		result = result.replaceAll("&apos;", "\'");

		result = result.replaceAll("<DIV>", "");
		result = result.replaceAll("</DIV>", "");

		result = result.replaceAll("<P>", "");
		result = result.replaceAll("</P>", "");

		result = result.replaceAll("<I>", "");
		result = result.replaceAll("</I>", "");

		result = result.replaceAll("<U>", "");
		result = result.replaceAll("</U>", "");

		result = result.replaceAll("<B>", "");
		result = result.replaceAll("</B>", "");

		result = result.replaceAll("<SPAN>", "");
		result = result.replaceAll("</SPAN>", "");

		result = result.replaceAll("<[^>]+>", " ");

		result = result.replaceAll("<BR/>", "\n");

		return result;
	}

	public String getactionstep(int tcid, int stepno) throws Exception {
		String actionsteps = "";
		String step = CreateBugTFS.getTestStep(tcid);

		String[] splitintosteps = StringUtils.substringsBetween(step, "<step", "</step>");

		for (int i = 0; i < splitintosteps.length; i++) {
			if (i == (stepno - 1)) {
				String[] splitintoactionandexpected = StringUtils.substringsBetween(splitintosteps[i].toString(), "<parameterizedString", "</parameterizedString>");

				for (int j = 0; j < splitintoactionandexpected.length; j++) {
					if (j == 0) {
						if (splitintoactionandexpected[j].toString() != null) {
							actionsteps = htmltoxmlformatter(splitintoactionandexpected[j].toString());
						}
						// System.out.println(actionsteps);
						break;
					}
				}
				break;
			}
		}
		return actionsteps;
	}

	public String getexpectedstep(int tcid, int stepno) throws Exception {
		String expectedsteps = "";
		String step = CreateBugTFS.getTestStep(tcid);

		String[] splitintosteps = StringUtils.substringsBetween(step, "<step", "</step>");

		for (int i = 0; i < splitintosteps.length; i++) {
			// System.out.println("Step " + i + " :" + splitintosteps[i].toString() + "\n");
			if (i == (stepno - 1)) {
				String[] splitintoactionandexpected = StringUtils.substringsBetween(splitintosteps[i].toString(), "<parameterizedString", "</parameterizedString>");

				for (int j = 0; j < splitintoactionandexpected.length; j++) {
					if (j == 1) {
						if (splitintoactionandexpected[j].toString() != null) {
							expectedsteps = htmltoxmlformatter(splitintoactionandexpected[j].toString());
						}
						break;
					}
				}
				break;
			}

		}
		return expectedsteps;
	}

	public void uploadalltestattachments(int bugid) {
		if (attachments.length > 0) {
			for (File attachment : attachments) {
				if (attachment != null) {
					CreateBugTFS cbt = new CreateBugTFS();
					cbt.addTFSattachment(attachment, bugid);
				}
			}
		}
		attachments = new File[10];
		attachmentcount = 0;
	}

	public void setDatabyCell(int sheetNumber, int row, int column, String value) {
		try {
			excelSheet = excelWorkbook.getSheetAt(sheetNumber);
			excelSheet.getRow(row).createCell(column).setCellValue(value);
			FileOutputStream fos = new FileOutputStream(TestDatafile);
			excelWorkbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getNumberOfRows(int sheetNumber) {
		excelSheet = excelWorkbook.getSheetAt(sheetNumber);
		int NumberOfRows = excelSheet.getLastRowNum() + 1;
		return NumberOfRows;
	}

	@SuppressWarnings("unused")
	public static String[] readexcel(int sheetnumber, int row1, String filename) {
		String[] value = null; // 0 = value, 1 = value, 2 = value
		try {
			Workbook workbook = WorkbookFactory.create(new File(new File(".", "//TestData//" + filename).getAbsolutePath()));
			Sheet sheet = workbook.getSheetAt(sheetnumber);
			DataFormatter dataFormatter = new DataFormatter();
			int count = 1;
			for (Cell cell : sheet.getRow(row1)) {
				count++;
			}
			value = new String[count];
			for (Cell cell : sheet.getRow(row1)) {
				value[cell.getColumnIndex()] = dataFormatter.formatCellValue(cell);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public int getrownumofvalue(String value, int sheetnumber, String filename) throws Exception {
		int values = 0;

		int maxrows = getNumberOfRows(sheetnumber);

		for (int i = 1; i < maxrows; i++) {
			String[] data = readexcel(sheetnumber, i, filename);
			// search for string in array string
			if (Arrays.asList(data).contains(value)) {
				values = i;
				break;
			}
		}
		return values;
	}

	public void addTestInfo(String message) throws Exception {
		ObjectHelper.test.log(Status.WARNING, message);
		bugtitle = message;
	}
}
