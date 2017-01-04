package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddNewBusiness {
	
	public WebDriver driver;
	@Test
	public void AddBusiness() throws Exception {   
        
			// To add a new business
			driver.findElement(By.id("new-business")).click();
			driver.findElement(By.id("business_name")).sendKeys("Test123");// insert a new business name
			Thread.sleep(2000);
			driver.findElement(By.id("phone_number")).sendKeys("0712345699"); // insert a phone number
			Thread.sleep(2000);
			Select importSource = new Select(driver.findElement(By.id("import-source")));
    		importSource.selectByIndex(0);
    	    Thread.sleep(3000);
				driver.findElement(By.id("save-lock-redirect")).click();
    	    Select industryType = new Select(driver.findElement(By.id("industry_type_id")));
    		industryType.selectByVisibleText("Hotels"); 
    		 
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
		  driver.quit();
	  }
}


