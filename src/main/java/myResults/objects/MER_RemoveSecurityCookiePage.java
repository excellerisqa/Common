package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;



public class MER_RemoveSecurityCookiePage {
	public static By removeButton = By.xpath("//div[@id='removesecurityquestioncookie']//button[text()='REMOVE']");
	public static By cancelButton = By.xpath("//div[@id='removesecurityquestioncookie']//a[text()='CANCEL']");
	public static By changeSuccessOKButton = By.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");

	public void removeCookieFunc() {
		ObjectHelper.driver.findElement(removeButton).click();
		try {
			CommonFunctions.clickonmodalpopup(changeSuccessOKButton);
			if(!ObjectHelper.driver.findElement(MER_AccountSettingsPage.removeCookieLink).isDisplayed())
				ObjectHelper.test.pass("Verify remove security cookie: Pass");
			else
				ObjectHelper.test.fail("Verify remove security cookie: Fail\n");
			
		}catch(Exception e) {
			ObjectHelper.test.fail("Verify remove security cookie: Fail\n"+e);
		
		}
	}
}
