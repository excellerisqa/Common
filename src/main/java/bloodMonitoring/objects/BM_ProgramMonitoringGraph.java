package bloodMonitoring.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BM_ProgramMonitoringGraph {
	public WebDriver driver;
	@FindBy(css = "#chartTemplate0 > div.chartContainer.k-chart > svg > g > g:nth-child(3) > g:nth-child(4) > g > image:nth-child(2)")
	public static WebElement criticalResultgraph;
	@FindBy(css = "#chartTemplate2 > div.chartContainer.k-chart > svg > g > g:nth-child(3) > g:nth-child(4) > g > image:nth-child(2)")
	public static WebElement abnormalResultgraph;
	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[2]/div[3]/button")
	public static WebElement miniDialogReportButton;
	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[2]/div[4]/button")
	public static WebElement miniDialogCloseButton;

	public BM_ProgramMonitoringGraph(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
