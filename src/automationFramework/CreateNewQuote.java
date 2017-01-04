package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewQuote {
	public WebDriver driver;

	@Test
	public void newQuote() throws InterruptedException {             

		// To select "Business Name" from the DropDown under Account Search and search for a valid business account
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='dashboard-search']//select")));
		dropdown.selectByIndex(0);
		driver.findElement(By.xpath("//*[@id='dashboard-search']/div/div[2]/input")).sendKeys("Test Business");	  // Enter a business name to search inside the brackets ("") after .sendKeys
		driver.findElement(By.id("search-button")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Test Business")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tab-invoice")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mprn']/div/form[3]/div/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("confirm-meter")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("contract_end_date")).click();
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[4]/a")).click();
		Thread.sleep(2000);
		Select Region = new Select(driver.findElement(By.xpath("//*[@id='region-holder']/select[@name='gas_region']")));
		Region.selectByValue("SW");
		Thread.sleep(2000);
		Select ExitZone = new Select(driver.findElement(By.xpath("//*[@id='region-holder']/select[@name='gas_exit_zone']")));
		ExitZone.selectByValue("SW2");
		Thread.sleep(2000);
		Select Supplier = new Select(driver.findElement(By.xpath("//*[@id='meter-usage']/div[1]/div[3]/div//*[@id='supplier_id']")));
		Supplier.selectByIndex(3);
		Thread.sleep(2000);

		// Calculating usage
		driver.findElement(By.xpath("//*[@id='calculate-aq-form']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("History")).click();
		Select quoteDate = new Select(driver.findElement(By.xpath("//*[@id='history-quote-select']")));
		quoteDate.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Calculate")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("standard_unitrate")).sendKeys("3.6");
		driver.findElement(By.id("standing_charge_value")).sendKeys("50");
		Thread.sleep(2000);
		Select period = new Select(driver.findElement(By.xpath("//*[@id='standing_charge_period']")));
		period.selectByIndex(1);
		Select startMonth = new Select(driver.findElement(By.xpath("//*[@id='bill_start_month']")));
		startMonth.selectByIndex(7);
		Select profile = new Select(driver.findElement(By.xpath("//*[@id='profile']")));
		profile.selectByIndex(2);
		driver.findElement(By.xpath("//*[@id='usage']")).sendKeys("24567");
		Select Recurrence = new Select(driver.findElement(By.xpath("//*[@id='bill_recurrence']")));
		Recurrence.selectByIndex(1);
		driver.findElement(By.id("usage-calc-close")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("price-comparison")).click();
		Thread.sleep(2000);

		// Price Comparison 
		driver.findElement(By.xpath("//*[@id='prices-tabs']/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='prices-tabs']/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='prices-tab-24']/table/tbody/tr[1]/th[4]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='prices-tab-24']/table/tbody/tr[1]/th[2]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='prices-tabs']/li[1]/a")).click();

		//To move the price comparison slider
		WebElement dragElementFrom = driver.findElement(By.xpath("//*[@id='prices-tab-12']/table/tbody/tr[1]/th[3]/div/span"));  
		//To Move jQuery slider by 20 pixel offset using dragAndDropBy method of Actions class.
		new Actions(driver).dragAndDropBy(dragElementFrom, 20, 0).build().perform();
		Thread.sleep(5000);
		//After 5 seconds, This will Move jQuery slider by 10 pixel offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
		new Actions(driver).clickAndHold(dragElementFrom).moveByOffset(10,0).release().perform();

		driver.findElement(By.xpath("//*[@id='prices-tab-12']/table/tbody/tr[4]/td[13]/div/input")).click();		
		driver.findElement(By.id("quote-save")).click();
		Thread.sleep(2000);
		
	}

	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
	      driver = new ChromeDriver(options);   
	      driver.get("http://192.168.169.11:84/");
	      
	      // To login with a valid user id and password
	       driver.findElement(By.id("username")).sendKeys("ymishra"); 
	       driver.findElement(By.id("password")).sendKeys("Crown");     
	       driver.findElement(By.id("submit")).click();
	       Thread.sleep(2000); 
	}

	@AfterTest
	public void afterTest() {

	}

}
