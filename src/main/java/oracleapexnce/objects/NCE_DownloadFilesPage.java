package oracleapexnce.objects;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class NCE_DownloadFilesPage {
	WebDriver driver; 
	
	//page elements in Create NCE Section A Attachments
		 @FindBy(id="A_FILENAME")
		 WebElement fileName;
		 
		 String xp = "//td[text()='XXX']/following::a[position()=1]";
		 

   
   public NCE_DownloadFilesPage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   } 
   
   
  public void createDownloadFolder(String dir) {
		File folder = new File(".",dir);
		if(folder.exists()) {
			File[] files = folder.listFiles();
			for(File file : files) {
				file.delete();
			}
		}
		
		new File(folder.getAbsolutePath()).mkdir();
		
}


   
   public void downloadFiles(String file) throws Exception{
		if(CommonFunctions.checkElementDisplayed(fileName)) {
			CommonFunctions.waitandClick(By.xpath(xp.replace("XXX", file)), 10);
			Thread.sleep(10000);
			CommonFunctions.waitForDownload(file, 30);
			
		}else {
			System.out.println("There are no Attachments for Section A to Download");
			
		}
		
			}

	public boolean verifyDownload(String file) {
		boolean visibility = false;
		try{
			File f = new File(".",file);
		if(f.exists() && f.isFile()) { 
			visibility = true;
		    			
		}else
			System.out.println("No Files found in the Folder: Folder is empty");
		} catch (Exception e) {
			e.getMessage();
			
		}
		return visibility;
		
	}


	
	
	
	


}
