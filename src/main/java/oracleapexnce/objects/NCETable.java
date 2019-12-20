package oracleapexnce.objects;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class NCETable {	
	WebElement	table;	
	String xpTable;
	
	//id is the id of a title header
	public NCETable(String id) {
		xpTable = "//th[@id='XXX']//ancestor::table[position()=1]".replace("XXX", id);		
		
	}
	
	public void filterColumn(String columnName, String value) throws Exception {
		table = ObjectHelper.driver.findElement(By.xpath(xpTable));
		//click at the column
		String xpCol = "//div[text()='XXX']".replace("XXX", columnName);
		CommonFunctions.waitandClick(By.xpath(xpCol), 40);
		
		//Enter the text to filter
		String xpInput = "//input[@title='Search']";
		CommonFunctions.waitForVisiblity(By.xpath(xpInput), 40);
		ObjectHelper.driver.findElement(By.xpath(xpInput)).sendKeys(value);
		Thread.sleep(4000);
		
		//Clik the link
		String xpLink = "//div[@id='apexir_rollover_content']/a[text()='XXX']".replace("XXX", value);
		CommonFunctions.waitandClick(By.xpath(xpLink), 40);
		
	}
	
	public boolean find(Hashtable<String, String> data)  {

		WebDriverWait wait = new WebDriverWait(ObjectHelper.driver, 100);
		table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpTable)));
//				ObjectHelper.driver.findElement(By.xpath(xpTable));		
		boolean found = false;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> rows = getRows();
		System.out.println("Got rows from table");
		for(WebElement row:rows) {
			boolean rowMatch = true;
			Set<String> keys = data.keySet();
			Iterator<String> itr = keys.iterator();
			while (itr.hasNext()) {
				String key = itr.next();
				String expValue = data.get(key);
				String xpCol = ".//td[@headers='XXX']".replace("XXX", key);	
				
				WebElement col = null;
				try {
					col = row.findElement(By.xpath(xpCol));
				}catch(Exception e) {
					e.printStackTrace();
				}
				String cellVal = col.getText().trim();
				if(!expValue.equalsIgnoreCase(cellVal)) {
					rowMatch = false;
					break;
				}				
			}
			if(rowMatch) {
				found = true;
				break;
			}			
		}
		System.out.println("Table search result : "+ found);
		return found;
	}

	private List<WebElement> getColumns(WebElement row) {
		return row.findElements(By.xpath(".//td"));
	}
	private List<WebElement> getRows() {
		table = ObjectHelper.driver.findElement(By.xpath(xpTable));			
		List<WebElement> rows =  table.findElements(By.xpath(".//tr"));
		rows.remove(0); //Remove title row
		return rows;
	}
	

}
