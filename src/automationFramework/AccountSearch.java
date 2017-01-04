package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class AccountSearch {
	public WebDriver driver;

	@Test
	public void Main() throws InterruptedException {
		
		// To select "Business Name" from the DropDown under Account Search and search for a valid business account by name 

		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='dashboard-search']//select")));
		dropdown.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='dashboard-search']/div/div[2]/input")).sendKeys("hotel");	  // Please enter the business name to search inside the brackets ("") after .sendKeys below
		driver.findElement(By.id("search-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("//*[@id='dashboard-search']/div/div[2]/input")).clear();

		// To select "Phone Number" from the DropDown under Account Search and search for a business account by phone number
		dropdown.selectByIndex(1);
		driver.findElement(By.name("//*[@id='dashboard-search']/div/div[2]/input")).sendKeys("01631562341");	  // Please enter the phone number to search a business account inside the brackets ("") after .sendKeys below
		driver.findElement(By.id("search-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("//*[@id='dashboard-search']/div/div[2]/input")).clear();

		// To select "Phone Number" from the DropDown under Account Search and search for a business account by phone number
		dropdown.selectByIndex(2);
		driver.findElement(By.name("//*[@id='dashboard-search']/div/div[2]/input")).sendKeys("CB2 1AB");	  // Please enter the phone number to search a business account inside the brackets ("") after .sendKeys below
		driver.findElement(By.id("search-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("//*[@id='dashboard-search']/div/div[2]/input")).clear();

		// To select "Phone Number" from the DropDown under Account Search and search for a business account by phone number
		dropdown.selectByIndex(3);
		driver.findElement(By.name("//*[@id='dashboard-search']/div/div[2]/input")).sendKeys("8283001");	  // Please enter the phone number to search a business account inside the brackets ("") after .sendKeys below
		driver.findElement(By.id("search-button")).click();
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
		driver.quit();
	}

}
