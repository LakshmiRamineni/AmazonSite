package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import locators.AmazonOrderPlace;

public class AmazonOrderPlaceTest extends BaseTest {

	AmazonOrderPlace aop;
	String valueToSearch1 = "shoes for women";
	String valueToSearch2 = "infuser water bottle";
	String expectedValueOfProceededOrder = "Proceed to checkout (1 item)";
	String expectedValueOfProceededOrderBulk = "Proceed to checkout (2 item)";
	String url = "http://www.amazon.in/";

	@Test(priority = 1)
	public void test_AddSingleItemToCart() {

		aop = new AmazonOrderPlace(driver);
		aop.goTo(url);
		aop.setSearchFieldValue(valueToSearch1);
		aop.selectItemFromTheList();
		String parentWindow = driver.getWindowHandle();
		aop.clickOnSelectedItem();
		aop.switchToNewWindow(parentWindow);
		aop.selectSize();
		aop.clickOnAddToCartButton();
		Assert.assertEquals(aop.getValueofSingleProceededOrder(), expectedValueOfProceededOrder, "Both are not equal");
	}

	@Test(priority = 2)
	public void test_AddMultipleItemsToCart() {
		aop = new AmazonOrderPlace(driver);
		aop.goTo(url);
		aop.clearValueInSearchField();
		aop.setSearchFieldValue(valueToSearch2);
		aop.selectItemFromTheList();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		String parentWindow = driver.getWindowHandle();
		aop.clickOnSelectedItem();
		aop.switchToNewWindow(parentWindow);
		aop.clickOnAddToCartButton();
		Assert.assertEquals(aop.getValueofSingleProceededOrder(), expectedValueOfProceededOrder, "Both are not equal");

	}

}
