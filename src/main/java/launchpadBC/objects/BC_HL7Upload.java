package launchpadBC.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BC_HL7Upload {

	static String uploadstatus;
	public static By chooseFileLink = By.xpath("//input[@id='FileUpload']");
	public static By chooseFile = By.id("FileUpload");
	public static By uploadFileBtn = By.id("UploadButton");
	public static By uploadResults = By.id("UploadResults");
	public static By messageTypeDD = By.id("MessageTypeDropDown");

	/*
	 * This function polls and waits for the uploadResults element to be visible
	 * upto a max of 40sec
	 */
	public static boolean waitForHL7Upload() {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(ObjectHelper.driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(2));
			fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(uploadResults));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Create a folder named 'HL7' inside 'TestData' and place the HL7 master file
	 * that you need there. Also create another folder called 'New HL7' inside
	 * 'HL7'. The newly generated HL7 file will automatically be copied into this
	 * folder. Please check 'ID_826_LifelabsRegistration' in UPP as example.
	 */
	public static boolean generateLabHL7(String reportNameWithExtn, String PHNnum, String lastName, String accessionNum, String doc, String date) {
		boolean err = false;
		if (CommonFunctions.copyFile("\\TestData\\HL7\\", reportNameWithExtn, "\\TestData\\HL7\\New HL7\\")) {
			System.out.println("begin replacement");
			File file1 = new File(".", "\\TestData\\HL7\\New HL7\\" + reportNameWithExtn);
			String searchPHN = "#HealthNum", searchAccession = "#ACCESSION", searchDoc = "#dr", searchDate = "#time", searchLastName = "#LastName";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(searchPHN, PHNnum);
				newContent = newContent.replaceAll(searchLastName, lastName);
				newContent = newContent.replaceAll(searchAccession, accessionNum);
				newContent = newContent.replaceAll(searchDoc, doc);
				newContent = newContent.replaceAll(searchDate, date);
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
				err = true;
			}
		}
		return err;
	}
/*--- adding DOB field as parameter---*/
	public static boolean generateLabHL7(String reportNameWithExtn, String PHNnum, String lastName, String accessionNum, String doc, String date, String birthdate) {
		boolean err = false;
		if (CommonFunctions.copyFile("\\TestData\\HL7\\", reportNameWithExtn, "\\TestData\\HL7\\New HL7\\")) {
			System.out.println("begin replacement");
			File file1 = new File(".", "\\TestData\\HL7\\New HL7\\" + reportNameWithExtn);
			String searchPHN = "#HealthNum", searchAccession = "#ACCESSION", searchDoc = "#dr", searchDate = "#time", searchLastName = "#LastName", searchdob = "#Birthdate";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(searchPHN, PHNnum);
				newContent = newContent.replaceAll(searchLastName, lastName);
				newContent = newContent.replaceAll(searchAccession, accessionNum);
				newContent = newContent.replaceAll(searchDoc, doc);
				newContent = newContent.replaceAll(searchDate, date);
				newContent = newContent.replaceAll(searchdob, birthdate);
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
				err = true;
			}
		}
		return err;
	}

	/*
	 * /--above method has been copied and two new variables have been added #DOB
	 * and #Gender---Please remember to add these two variables in PID segment in
	 * your HL7 text file also
	 */
	public static boolean generateLabHL7(String reportNameWithExtn, String newFileName, String PHNnum, String lastName, String accessionNum, String doc, String date, String dob, String gender) {
		boolean err = false;
		if (CommonFunctions.copyFileNewName("\\TestData\\HL7\\", reportNameWithExtn, "\\TestData\\HL7\\New HL7\\", newFileName)) {
			System.out.println("replacement begins");
			File file1 = new File(".", "\\TestData\\HL7\\New HL7\\" + newFileName);
			String searchPHN = "#HealthNum", searchAccession = "#ACCESSION", searchDoc = "#dr", searchDate = "#time", searchLastName = "#LastName", searchDOB = "#DOB", searchGender = "#GENDER";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(searchPHN, PHNnum);
				newContent = newContent.replaceAll(searchLastName, lastName);
				newContent = newContent.replaceAll(searchAccession, accessionNum);
				newContent = newContent.replaceAll(searchDoc, doc);
				newContent = newContent.replaceAll(searchDate, date);
				newContent = newContent.replaceAll(searchDOB, dob);
				newContent = newContent.replaceAll(searchGender, gender);
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
				System.out.println("replacement finished");
			} catch (Exception e) {
				e.printStackTrace();
				err = true;
			}
		}
		return err;
	}

	/*
	 * additional variable- Observation Time
	 */
	public static boolean generateLabHL7(String reportNameWithExtn, String newFileName, String PHNnum, String lastName, String accessionNum, String doc, String date, String obvTime, String dob,
			String gender) {
		boolean err = false;
		if (CommonFunctions.copyFileNewName("\\TestData\\HL7\\", reportNameWithExtn, "\\TestData\\HL7\\New HL7\\", newFileName)) {
			System.out.println("replacement begins");
			File file1 = new File(".", "\\TestData\\HL7\\New HL7\\" + newFileName);
			String searchPHN = "#HealthNum", searchAccession = "#ACCESSION", searchDoc = "#dr", searchDate = "#time", searchObvTime = "#obvtime", searchLastName = "#LastName", searchDOB = "#DOB",
					searchGender = "#GENDER";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(searchPHN, PHNnum);
				newContent = newContent.replaceAll(searchLastName, lastName);
				newContent = newContent.replaceAll(searchAccession, accessionNum);
				newContent = newContent.replaceAll(searchDoc, doc);
				newContent = newContent.replaceAll(searchDate, date);
				newContent = newContent.replaceAll(searchObvTime, obvTime);
				newContent = newContent.replaceAll(searchDOB, dob);
				newContent = newContent.replaceAll(searchGender, gender);
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
				System.out.println("replacement finished");
			} catch (Exception e) {
				e.printStackTrace();
				err = true;
			}
		}
		return err;
	}

	/*
	 * additional variables- Patient Address (Street, City, Province, PostalCode)
	 * and Patient's phone number
	 */
	public static boolean generateLabHL7(String reportNameWithExtn, String newFileName, String PHNnum, String lastName, String firstName, String accessionNum, String doc, String date, String obvTime,
			String dob, String gender, String street, String city, String province, String postal, String phone) {
		boolean err = false;
		if (CommonFunctions.copyFileNewName("\\TestData\\HL7\\", reportNameWithExtn, "\\TestData\\HL7\\New HL7\\", newFileName)) {
			System.out.println("replacement begins");
			File file1 = new File(".", "\\TestData\\HL7\\New HL7\\" + newFileName);
			String searchPHN = "#HealthNum", searchAccession = "#ACCESSION", searchDoc = "#dr", searchDate = "#time", searchObvTime = "#obvtime", searchLastName = "#LastName",
					searchFirstName = "#FirstName", searchDOB = "#DOB", searchGender = "#GENDER", searchStreet = "#PAStreet", searchCity = "#PACity", searchProvince = "#PAProvince",
					searchPostal = "#PAPostal", searchPhone = "#PAPhone";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(searchPHN, PHNnum);
				newContent = newContent.replaceAll(searchLastName, lastName);
				newContent = newContent.replaceAll(searchFirstName, firstName);
				newContent = newContent.replaceAll(searchAccession, accessionNum);
				newContent = newContent.replaceAll(searchDoc, doc);
				newContent = newContent.replaceAll(searchDate, date);
				newContent = newContent.replaceAll(searchObvTime, obvTime);
				newContent = newContent.replaceAll(searchDOB, dob);
				newContent = newContent.replaceAll(searchGender, gender);
				newContent = newContent.replaceAll(searchStreet, street);
				newContent = newContent.replaceAll(searchCity, city);
				newContent = newContent.replaceAll(searchProvince, province);
				newContent = newContent.replaceAll(searchPostal, postal);
				newContent = newContent.replaceAll(searchPhone, phone);
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
				System.out.println("replacement finished");
			} catch (Exception e) {
				e.printStackTrace();
				err = true;
			}
		}
		return err;
	}

	public static String incrementPHN(String healthNum) {
		return Long.toString(Long.parseLong(healthNum) + 1);
	}

	public static String incrementAccessionNum(String currentAccession, String reportName) {
		String newAccession = "";
		if (reportName.equals("Lifelabs")) {
			if(ObjectHelper.state.equals("BC"))
				newAccession = currentAccession.substring(0, 3) + (Integer.parseInt(currentAccession.split("18-")[1]) + 1);
			else
				newAccession = Long.toString(Long.parseLong(currentAccession) + 1);
		}
			
		else if (reportName.equals("NV"))
			newAccession = currentAccession.substring(0, 1) + (Integer.parseInt(currentAccession.split("N")[1]) + 1);
		else if (reportName.equals("FHAM"))
			newAccession = Long.toString(Long.parseLong(currentAccession) + 1);
		else if (reportName.equals("CW"))
			newAccession = currentAccession.substring(0, 1) + (Integer.parseInt(currentAccession.split("F")[1]) + 1);
		else if (reportName.equals("PHC"))
			newAccession = currentAccession.substring(0, 1) + (Integer.parseInt(currentAccession.split("P")[1]) + 1);
		else if (reportName.equals("VCH"))
			newAccession = currentAccession.substring(0, 1) + (Integer.parseInt(currentAccession.split("W")[1]) + 1);
		else if (reportName.equals("VML"))
			newAccession = Long.toString(Long.parseLong(currentAccession) + 1);
		else if (reportName.equals("VMLmicro")) {
			newAccession = currentAccession.substring(0, 1) + (Integer.parseInt(currentAccession.split("M")[1]) + 1);
			//newAccession = currentAccession.substring(0, 1) + (Integer.parseInt(currentAccession.split("-18")[0].split("M")[1]) + 1);
			//newAccession = newAccession + "-18";
		}
		else if (reportName.equals("PLISPUSH")) {
			newAccession = currentAccession.substring(0, 7) + (Integer.parseInt(currentAccession.split("17-EMR0")[1]) + 1);
		}
		return newAccession;
	}

	public static void selectMessageType(String messageType) {
		Select messageDD = new Select(ObjectHelper.driver.findElement(messageTypeDD));
		switch (messageType) {
		case "HL7":
			messageDD.selectByValue("HL723");
			break;
		case "XML":
			messageDD.selectByValue("XML");
			break;
		case "CDALEVEL1":
			messageDD.selectByValue("CDALEVEL1");
			break;
		case "CDALEVEL3":
			messageDD.selectByValue("CDALEVEL3");
			break;
		}
	}
	
	/*
	 * /--above method has been copied and two new variables have been added #DOB
	 * and #Gender---Please remember to add these two variables in PID segment in
	 * your HL7 text file also
	 */
	public static boolean generateLabHL7PLISsenderSrv(String reportNameWithExtn, String newFileName, String accessionNum) {
		boolean err = false;
		if (CommonFunctions.copyFileNewName("\\TestData\\HL7\\", reportNameWithExtn, "\\TestData\\HL7\\New HL7\\", newFileName)) {
			System.out.println("replacement begins");
			File file1 = new File(".", "\\TestData\\HL7\\New HL7\\" + newFileName);
			String searchAccession = "#ACCESSION";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(searchAccession, accessionNum);
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
				System.out.println("replacement finished");
			} catch (Exception e) {
				e.printStackTrace();
				err = true;
			}
		}
		return err;
	}
}
