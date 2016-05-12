package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SampleTest {
	 WebDriver driver;
 
  
  @Test
	public void test() {
	  WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.in/Yahe-Womens-Casual-Leather-Wedges/dp/B019XY0TEA/ref=sr_1_1?s=shoes&ie=UTF8&qid=1462957111&sr=1-1&keywords=shoes+for+women");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
		Select selectByValue = new Select(driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']")));
		selectByValue.selectByValue("2,B019XY0TEA");
		
	 // System.out.println("Hello");
//		System.setProperty("webdriver.chrome.driver", "/Users/lakshmir/Desktop/Amazon Project/Drivers/chromedriver");
//		   driver = new ChromeDriver();
//		  System.out.println("Hello world");
	}
  
}
