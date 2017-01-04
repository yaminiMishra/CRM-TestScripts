package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class AddNewTask {
	public WebDriver driver;
	
  @Test
  public void AddingNewTask() throws InterruptedException {
	  
	  driver.findElement(By.id("newTask")).click();
	  Thread.sleep(2000);
	  
	// Select Callback Task Type  
	  
	  Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='new-task']//*[@id='taskType']")));
		dropdown.selectByIndex(0);
		
	// Add notes, due date and time for the task	
		
		driver.findElement(By.id("note")).sendKeys("Test Notes");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='new-task']//*[@id='due_date']")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/a[2]")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[5]/td[4]/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='new-task']//*[@id='due_time']")).click();
	    Thread.sleep(1000);
		driver.findElement(By.linkText("09:00")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='new-task']//*[@id='add10MinsDue']")).click();
	 	
	// Select a call back type	
		Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='new-task']//*[@id='callBackType']")));
		dropdown2.selectByIndex(2);
		driver.findElement(By.id("add-new-task")).click();
		System.out.println("New Task - Callback Succeffully Added");	
		Thread.sleep(2000);
		
		
	// Select Email Task Type 
	  driver.findElement(By.id("newTask")).click();
	  Thread.sleep(2000);
	  Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id='new-task']//*[@id='taskType']")));
			dropdown3.selectByIndex(1);
			
		// Add notes, due date and time for the task	
			driver.findElement(By.id("note")).sendKeys("Test Notes");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='new-task']//*[@id='due_date']")).click();
		    driver.findElement(By.xpath("/html/body/div[3]/div/a[2]")).click();
		    driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[5]/td[4]/a")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='new-task']//*[@id='due_time']")).click();
		    Thread.sleep(1000);
			driver.findElement(By.linkText("09:00")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='new-task']//*[@id='add10MinsDue']")).click();
			
			driver.findElement(By.id("add-new-task")).click();
			System.out.println("New Task - Email Succeffully Added");	
			Thread.sleep(2000);

		// Select Quote Task Type  
	        driver.findElement(By.id("newTask")).click();
	        Thread.sleep(2000);
	        Select dropdown4 = new Select(driver.findElement(By.xpath("//*[@id='new-task']//*[@id='taskType']")));
			dropdown4.selectByIndex(2);
			
		// Add notes, due date and time for the task	
			driver.findElement(By.id("note")).sendKeys("Test Notes");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='new-task']//*[@id='due_date']")).click();
		    driver.findElement(By.xpath("/html/body/div[3]/div/a[2]")).click();
		    driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[5]/td[4]/a")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id='new-task']//*[@id='due_time']")).click();
		    Thread.sleep(1000);
			driver.findElement(By.linkText("09:00")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='new-task']//*[@id='add10MinsDue']")).click();
			
			driver.findElement(By.id("add-new-task")).click();
			
			System.out.println("New Task - Quote Succeffully Added");	
	  
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
        
        // To select "Business Name" from the DropDown under Account Search and search for a valid business account
         Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='dashboard-search']//select")));
     		dropdown.selectByIndex(0);
     	driver.findElement(By.xpath("//*[@id='dashboard-search']/div/div[2]/input")).sendKeys("Test Business");	  // Enter a business name to search inside the brackets ("") after .sendKeys
     	driver.findElement(By.id("search-button")).click();
     	Thread.sleep(2000);
     	driver.findElement(By.linkText("Test Business")).click();
     	Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
