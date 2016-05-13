package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest
	public void setup(){
	driver =new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	driver.manage().window().maximize();
	}
	
	@AfterTest
	public void End(){
		driver.quit();
	}

}
