/**
 * 
 */
package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesCallingTest {
	public WebDriver driver;

	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
	      driver = new ChromeDriver(options);   
	      driver.get("http://192.168.169.11:84/");
	      
	      // To login with a valid user id and password
	       driver.findElement(By.id("username")).sendKeys("YaminiSales"); 
	       driver.findElement(By.id("password")).sendKeys("integer");     
	       driver.findElement(By.id("submit")).click();
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);

	}

	@Test
	public void callingAccountLead() throws Exception {             
		
		//	To select a campaign and call a lead
		driver.findElement(By.xpath("//*[@id='dashboard-user-campaigns']/a[2]/div/div/div")).click(); //selecting a campaign
		driver.findElement(By.id("page-header")).getText().contentEquals("Account Lead");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='call_initiation_button']")).click();
		Thread.sleep(16000);
		driver.findElement(By.linkText("Connected")).click();
		System.out.println("Calling Test Sucessful");
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}


}
