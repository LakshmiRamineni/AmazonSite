package Tests;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import locators.AmazonOrderPlace;

public class AmazonOrderPlaceTest {
	WebDriver driver;
	AmazonOrderPlace aop;
	String valueToSearch1 = "shoes for women";
	String valueToSearch2 = "infuser water bottle";
	String expectedValueOfProceededOrder = "Proceed to checkout (1 item)";
	String expectedValueOfProceededOrderBulk = "Proceed to checkout (2 item)";

	@BeforeTest
	public void goToAmazonPage() {
		driver = new FirefoxDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}

	@Test(priority = 1)
	public void test_AddSingleItemToCart() {
		aop = new AmazonOrderPlace(driver);
		aop.setSearchFieldValue(valueToSearch1);
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//div[@id='suggestions']/div[@class='s-suggestion']"));

		for (WebElement we : suggestions) {
			we.click();
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		String parentWindow = driver.getWindowHandle();
		aop.clickOnSelectedItem();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);

				aop.selectSize();

				aop.clickOnAddToCartButton();
				Assert.assertEquals(aop.getValueofSingleProceededOrder(), expectedValueOfProceededOrder,
						"Both are not equal");
				driver.close();
			}
		}
		
		// aop.buttonCart();
		// aop.deleteCart();
	}

	@Test(priority = 2)
	public void test_AddMultipleItemsToCart() {
		aop = new AmazonOrderPlace(driver);
		aop.clearValueInSearchField();
		aop.setSearchFieldValue(valueToSearch2);
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//div[@id='suggestions']/div[@class='s-suggestion']"));

		for (WebElement we : suggestions) {
			we.click();
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		String parentWindow = driver.getWindowHandle();
		aop.clickOnSelectedItem();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle1 : handles) {
			if (!windowHandle1.equals(parentWindow)) {
				driver.switchTo().window(windowHandle1);
				aop.clickOnAddToCartButton();
				Assert.assertEquals(aop.getValueofSingleProceededOrder(), expectedValueOfProceededOrder,
						"Both are not equal");
			}
		}
		driver.close();

	}

}
