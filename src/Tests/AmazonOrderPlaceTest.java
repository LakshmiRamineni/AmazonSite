package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import locators.AmazonPageMethods;

public class AmazonOrderPlaceTest extends BaseTest {

	// AmazonOrderPlace apm;
	AmazonPageMethods apm;
	String valueToSearch1 = "Pens";
	String valueToSearch2 = "watches for women";
	String valueToSearch3 = "mobile phones";
	String valueToSearch4 = "washing machine";
	String expectedValueOfProceededOrder = "Proceed to checkout (1 item)";
	String expectedValueOfProceededOrderBulk = "Proceed to checkout (4 item)";
	String url = "http://www.amazon.in/";

	@Test(priority = 1)
	public void test_AddSingleItemToCart() {
		apm = new AmazonPageMethods(driver);
		apm.goTo(url);
		apm.bulkOrderPlacement(new String[] { valueToSearch1});
		Assert.assertEquals(apm.getValueofSingleProceededOrder(), expectedValueOfProceededOrder, "Both are not equal");
	}

	@Test(priority = 2)
	public void test_AddMultipleItemsToCart() {
		apm = new AmazonPageMethods(driver);
		apm.goTo(url);
		// apm.bulkOrderPlacement(valueToSearch2, valueToSearch3,
		// valueToSearch4);
		apm.bulkOrderPlacement(new String[] { valueToSearch2, valueToSearch3, valueToSearch4 });
		Assert.assertEquals(apm.getValueofSingleProceededOrder(), expectedValueOfProceededOrder, "Both are not equal");

	}

}
