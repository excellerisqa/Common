package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClearCache {

	public static void chromeclear() {

		ObjectHelper.driver.manage().window().maximize();

		ObjectHelper.driver.get("chrome://settings/clearBrowserData");
		
		WebElement root1 = ObjectHelper.driver.findElement(By.tagName("settings-ui"));
		WebElement shadow1 = expandRootElement(root1);

		WebElement root2 = shadow1.findElement(By.cssSelector("settings-main"));
		WebElement shadow2 = expandRootElement(root2);

		WebElement root3 = shadow2.findElement(By.cssSelector("settings-basic-page"));
		WebElement shadow3 = expandRootElement(root3);

		WebElement root4 = shadow3.findElement(By.cssSelector("settings-privacy-page"));
		WebElement shadow4 = expandRootElement(root4);

		WebElement root5 = shadow4.findElement(By.cssSelector("settings-clear-browsing-data-dialog"));
		WebElement shadow5 = expandRootElement(root5);

		WebElement root6 = shadow5.findElement(By.id("clearFromBasic"));
		WebElement shadow6 = expandRootElement(root6);

		Select element = new Select(shadow6.findElement(By.id("dropdownMenu")));

		element.selectByVisibleText("All time");

		shadow5.findElement(By.id("clearBrowsingDataConfirm")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		WebHandler.setobjects();
	}

	public static WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) ObjectHelper.driver).executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}

	public static void firefoxclear() {
		try {

			ObjectHelper.driver.get("about:preferences");

			ObjectHelper.driver.findElement(By.xpath("//*[@id='linkTargeting']")).click();
			ObjectHelper.driver.findElement(By.xpath("//*[@id='switchToNewTabs']")).click();

			ObjectHelper.driver.get("about:preferences#privacy");
			ObjectHelper.driver.findElement(By.xpath("//*[@id='clearSiteDataButton']")).click();

			WebHandler.setobjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
