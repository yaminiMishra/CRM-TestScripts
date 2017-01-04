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

public class DelegateQuote {
	public WebDriver driver;
	
  @Test
  public void delegateQuote() throws InterruptedException {
	
		// To select "Business Name" from the DropDown under Account Search and search for a valid business account by name 
		driver.findElement(By.xpath("//*[@id='dashboard-search']//input[@name='term']")).sendKeys("Test Business");	  // Enter a business name to search inside the brackets ("") after .sendKeys
		driver.findElement(By.id("search-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Test Business")).click();
		
		// To select an existing quote
		driver.findElement(By.id("tab-quote")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("quote_94378")).click(); // Enter quote id to delegate
		Thread.sleep(2000);
		
		// To delegate the quote
		driver.findElement(By.id("delegate_quote")).click();
		Select dropdown = new Select(driver.findElement(By.id("user-to-delegate-to")));
		dropdown.selectByVisibleText("Yamini Mishra - Sales");
		Thread.sleep(1000);
		Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='quote_delegation']//select[@id='quote-note']")));
		dropdown2.selectByVisibleText("Requires Closing");
		driver.findElement(By.xpath("//*[@id='delegate-quote']")).click();
		Thread.sleep(1000);
		/*driver.findElement(By.xpath("//*[@id='user-icons']/a[4]/i")).click();
		
		// To check that the quote has been assigned correclty 
		driver.findElement(By.id("username")).sendKeys("YaminiSales"); 
		driver.findElement(By.id("password")).sendKeys("integer");     
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		*/
  }
  
  @BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options); 
		
		driver.get("http://192.168.169.11:84/");
		driver.findElement(By.id("username")).sendKeys("ymishra"); //Enter a valid Sales user name 
		driver.findElement(By.id("password")).sendKeys("Crown");     //Enter a valid password
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
