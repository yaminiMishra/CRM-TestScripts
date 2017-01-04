package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);              
        driver.get("http://192.168.169.11:84"); //Enter a valid site URL
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	     // To Login
	        driver.findElement(By.id("username")).sendKeys("ymishra"); //Enter a valid Sales user name 
	        driver.findElement(By.id("password")).sendKeys("cheesetoastie");     //Enter a valid password
	        Thread.sleep(1000);
	        driver.findElement(By.id("submit")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);
			driver.close();
}
}