package launchpadBC.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.net.ftp.FTPClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import utils.CommonFunctions;
import utils.ObjectHelper;



import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;



public class BC_FTPUpload {

	static String uploadstatus;
	public static By chooseFileLink = By.xpath("//input[@id='FileUpload']");
	public static By chooseFile = By.id("FileUpload");
	public static By uploadFileBtn = By.id("UploadButton");
	public static By uploadResults = By.id("UploadResults");
	public static By messageTypeDD = By.id("MessageTypeDropDown");

	FTPClient ftp = null;
	
	/*
	 * This function polls and waits for the uploadResults element to be visible
	 * upto a max of 40sec
	 */
	public static boolean waitForFTPUpload() {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(ObjectHelper.driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(2));
			fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(uploadResults));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
	
	
	
	
/*
	 * /--above method has been copied and two new variables have been added #DOB
	 * and #Gender---Please remember to add these two variables in PID segment in
	 * your HL7 text file also
	 */
	public static boolean generateLabFilesFTP(String reportNameWithExtn, String newFileName, String aDoctorID, String aAddress, String aAccession) {
		boolean result = true;
		if (CommonFunctions.copyFileNewName("\\TestData\\FTP\\", reportNameWithExtn, "\\TestData\\FTP\\New FTP\\", newFileName)) {
			System.out.println("replacement begins");
			File file1 = new File(".", "\\TestData\\FTP\\New FTP\\" + newFileName);
			String doctorID = "#DOCTORID", address = "#ADDRESS", accession = "#ACCESSION";
			try {
				FileReader fr = new FileReader(file1);
				String line;
				BufferedReader br = new BufferedReader(fr);
				String oldContent = "", newContent = "";
				while ((line = br.readLine()) != null) {
					oldContent = oldContent + line + System.lineSeparator();
				}
				newContent = oldContent.replaceAll(doctorID, aDoctorID);
				newContent = newContent.replaceAll(address, aAddress);
				newContent = newContent.replaceAll(accession, aAccession);
				
				FileWriter fw = new FileWriter(file1);
				fw.write(newContent);
				fw.close();
				fr.close();
				System.out.println("replacement finished");
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
		}
		return result;
	}

public static String incrementAccession(String aAccession) {
		return Long.toString(Long.parseLong(aAccession) + 1);
	}

	public static String incrementAccessionNum(String currentAccession, String reportName) {
		String newAccession = "";
		if (reportName.equals("Lifelabs"))
			newAccession = currentAccession.substring(0, 3) + (Integer.parseInt(currentAccession.split("18-")[1]) + 1);
		else if (reportName.equals("FTP"))
			newAccession = currentAccession.substring(0, 8) + (Integer.parseInt(currentAccession.split("2017-EMR")[1]) + 1);
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
	
    // Constructor to connect to the FTP Server
    public BC_FTPUpload(String host, String username, String password) throws Exception{
        
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        //ftp.connect(host,port);
        ftp.connect(host);
        
        System.out.println("FTP URL is:"+ftp.getDefaultPort());
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(username, password);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();        
    }    

    public BC_FTPUpload() throws Exception{
        
        ftp = new FTPClient();
                
    }    
    
    
    // Method to upload the File on the FTP Server
    public void uploadFTPFile_bk(String localFileFullName, String fileName, String hostDir)
            throws Exception
            {
                try {
                	
                	
                	InputStream input = new FileInputStream(new File(localFileFullName));

                this.ftp.storeFile(hostDir + fileName, input);
                }
                catch(Exception e){

                }
            }
   
 // Method to upload the File on the FTP Server
    public void uploadFTPFile(String fileName, String hostDir)
            throws Exception
            {
                // String localFileFullName = "";
                String fileDirectory = "\\TestData\\FTP\\New FTP";
                
    			try {
                	File uploadFileFullName = new File(new File(".", fileDirectory + "//" + fileName).getAbsolutePath());
                	
                	InputStream input = new FileInputStream(uploadFileFullName);

                	this.ftp.storeFile(hostDir + fileName, input);
                }
                catch(Exception e){

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

    
    
    // Download the FTP File from the FTP Server
    public void downloadFTPFile(String source, String destination) {
        try (FileOutputStream fos = new FileOutputStream(destination)) {
            this.ftp.retrieveFile(source, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // list the files in a specified directory on the FTP
    public boolean listFTPFiles(String directory, String fileName) throws IOException {
        // lists files and directories in the current working directory
        boolean verificationFilename = false;        
        FTPFile[] files = ftp.listFiles(directory);
        for (FTPFile file : files) {
            String details = file.getName();                
            System.out.println(details);            
            if(details.equals(fileName))
            {
                System.out.println("Correct Filename");
                verificationFilename=details.equals(fileName);
  //              assertTrue("Verification Failed: The filename is not updated at the CDN end.",details.equals(fileName));                
            }
        }  
        
         return verificationFilename;
    }
    
    // Disconnect the connection to FTP
    public void disconnect(){
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }
}
