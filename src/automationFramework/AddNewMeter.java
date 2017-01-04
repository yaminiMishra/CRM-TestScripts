package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddNewMeter {
	public WebDriver driver;

	@Test
	public void newMeter() throws InterruptedException {
     
     // To login with a valid user id and password
        driver.findElement(By.id("username")).sendKeys("ymishra"); 
        driver.findElement(By.id("password")).sendKeys("Crown");     
        Thread.sleep(2000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
       
     // To select "Business Name" from the DropDown under Account Search and search for a valid business account by name 
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='dashboard-search']//select")));
    		dropdown.selectByIndex(0);
    	driver.findElement(By.name("terms")).sendKeys("Test123");	  // Enter a business name to search inside the brackets ("") after .sendKeys
    	driver.findElement(By.id("search-button")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.linkText("Test123")).click();
    	driver.findElement(By.id("tab-invoice")).click();
    	Thread.sleep(2000);
    	
    // To add a new gas meter
    	 Select meterType = new Select(driver.findElement(By.xpath("//*[@id='add-meter-form']/select[1]")));
 		meterType.selectByIndex(1);
 		driver.findElement(By.xpath("//*[@id='add-meter-form']/input[@id='manual_entry']")).sendKeys("m305jj");
 		driver.findElement(By.id("add-new-meter")).click();
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("//*[@id='mprn']/div/form[1]//*[@id='mprn']")).sendKeys("3451278912");
 		driver.findElement(By.xpath("//*[@id='mprn']/div/form[1]/div/button[3]")).click();
 		Thread.sleep(2000);
 		
 	// To edit meter
 		driver.findElement(By.xpath("//*[@id='mprn']/div/form[1]/div/button[2]")).click();
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*[@id='contract_end_date']")).sendKeys("08/06/2017");
 		Select editPostcodeType = new Select(driver.findElement(By.xpath("//*[@id='meter-postcode']")));
 		editPostcodeType.selectByVisibleText("Manual Entry");
 		driver.findElement(By.xpath("//*[@id='meter-edit-form']//input[@id='pmanual_entry']")).clear();
 		driver.findElement(By.xpath("//*[@id='meter-edit-form']//input[@id='pmanual_entry']")).sendKeys("m305kj");
 		Select currentSupplier = new Select(driver.findElement(By.xpath("//*[@id='current_supplier']")));
 		currentSupplier.selectByVisibleText("EON");
		driver.findElement(By.id("save-meter-changes")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mprn']/div/form[1]/div/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='confirm-meter']")).isDisplayed();
		Thread.sleep(2000);
		
	// To add a new electric meter
		driver.findElement(By.id("tab-invoice")).click();
    	Thread.sleep(2000);
		Select meterType2 = new Select(driver.findElement(By.xpath("//*[@id='add-meter-form']/select[1]")));
		meterType2.selectByIndex(0);
		driver.findElement(By.xpath("//*[@id='add-meter-form']/input[@id='manual_entry']")).sendKeys("m305jj");
 		driver.findElement(By.id("add-new-meter")).click();
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form//*[@id='profile_class']")).sendKeys("03");
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form//*[@id='meter_timeswitch_code']")).sendKeys("801");
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form//*[@id='line_loss_factor']")).sendKeys("127");
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form//*[@id='distributor_id']")).sendKeys("20");
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form//*[@id='unique_identifier']")).sendKeys("00003647");
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form//*[@id='check_digit']")).sendKeys("060");
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form/div[2]/button")).click();
 		Thread.sleep(3000);
 		
 	// To edit meter
 		driver.findElement(By.xpath("//*[@id='mpan']/div/form/div[3]/button[2]")).click();
 		Thread.sleep(1000);
 		driver.findElement(By.xpath("//*[@id='contract_end_date']")).sendKeys("08/06/2017");
 		Select editPostcode = new Select(driver.findElement(By.xpath("//*[@id='meter-postcode']")));
 		editPostcode.selectByVisibleText("Manual Entry");
 		Thread.sleep(1000);
 		driver.findElement(By.xpath("//*[@id='meter-edit-form']//input[@id='pmanual_entry']")).clear();
 		driver.findElement(By.xpath("//*[@id='meter-edit-form']//input[@id='pmanual_entry']")).sendKeys("m305jy");
 		Select currentSupplier2 = new Select(driver.findElement(By.xpath("//*[@id='current_supplier']")));
 		currentSupplier2.selectByVisibleText("EON");
		driver.findElement(By.id("save-meter-changes")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mpan']/div/form[1]/div[3]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='confirm-meter']")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		
		System.out.println("Adding New Meter Test successfuly completed");
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
