package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DelegateTask {
	public WebDriver driver;

	@Test
	public void DelegatingTask () throws InterruptedException {

		driver.findElement(By.id("delegate")).click();
		Thread.sleep(1000);

		// Select User from dropdown
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='user']")));
		dropdown.selectByVisibleText("Yamini Mishra - Sales");
		Thread.sleep(1000);

		// Select Task Type from dropdown
		Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='type']")));
		dropdown2.selectByIndex(0);
		Thread.sleep(1000);

		// Select Callback Type from dropdown	
		Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='callBackType']")));
		dropdown3.selectByIndex(2);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='due_date']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[3]/td[4]/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='due_time']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='delegate-task']/div/div[9]/div/div/ul/li[5]/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='search_businesses']")).sendKeys("Test Business");
		Thread.sleep(4000);
		Select dropdown4 = new Select(driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='business']")));
		dropdown4.selectByVisibleText("Test Business");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='delegate-task']//*[@id='task_note']")).sendKeys("Test Delegate Task");
		Thread.sleep(2000);
		driver.findElement(By.id("save-delegated-task")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='user-icons']/a[4]/i")).click();

		// login to the assigned user's dashboard to check the task has been successfully delegated
		driver.findElement(By.id("username")).sendKeys("YaminiSales"); 
		driver.findElement(By.id("password")).sendKeys("integer");     
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("future-tasks")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Test Business")).isDisplayed();

		System.out.println("Delegate Task Test Successful");
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
