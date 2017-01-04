package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BespokeQuote {
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
	}

	@Test
	public void NewBespokeQuote() throws InterruptedException { 
		driver.get("http://192.168.169.11:84/");
		
		driver.findElement(By.id("username")).sendKeys("ymishra"); //Enter a valid Sales user name 
		driver.findElement(By.id("password")).sendKeys("Crown");     //Enter a valid password
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
	
		// To select "Business Name" from the DropDown under Account Search and search for a valid business account by name 
		driver.findElement(By.xpath("//*[@id='dashboard-search']//input[@name='term']")).sendKeys("Test Business");	  // Enter a business name to search inside the brackets ("") after .sendKeys
		driver.findElement(By.id("search-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Test Business")).click();
		
		// To select a meter
		driver.findElement(By.id("tab-quote")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='quote_94536']/div[2]")).click();
		Thread.sleep(2000);
		
		// To create a bespoke quote
		driver.findElement(By.xpath("//*[@id='meter-usage']//*[@id='bespoke-price']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='bespoke-form-container']//*[@id='contract_end_date']")).click();
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("gas_region")).clear();
		driver.findElement(By.id("gas_region")).sendKeys("SW");
		driver.findElement(By.id("bespoke-update-alert")).isDisplayed();
		driver.findElement(By.id("gas_exit_zone")).clear();
		driver.findElement(By.id("gas_exit_zone")).sendKeys("SW2");
		Thread.sleep(1000);
		Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id='supplier_id']")));
		dropdown3.selectByIndex(5);
		Thread.sleep(2000);
		driver.findElement(By.id("bespoke-quote-continue")).click();
		driver.findElement(By.id("contract_length")).clear();
		driver.findElement(By.id("contract_length")).sendKeys("36");
		

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
