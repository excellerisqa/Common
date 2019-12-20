package bloodMonitoring.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.ObjectHelper;

public class BM_LoginPage {
	public WebDriver driver;

	public BM_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginPage(String userId, String password) throws InterruptedException {
		ObjectHelper.driver.findElement(By.id("ctl00_mainContent_UserIDTextBox")).click();
		ObjectHelper.driver.findElement(By.id("ctl00_mainContent_UserIDTextBox")).sendKeys(userId);
		ObjectHelper.driver.findElement(By.id("ctl00_mainContent_PasswordTextBox")).click();
		ObjectHelper.driver.findElement(By.id("ctl00_mainContent_PasswordTextBox")).sendKeys(password);
		ObjectHelper.driver.findElement(By.id("ctl00_mainContent_OKButton")).click();
	}

}
