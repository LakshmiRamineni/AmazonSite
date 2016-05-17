package locators;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonPageMethods extends AmazonOrderPlace {
	
	public AmazonPageMethods(WebDriver driver) {
		super(driver);
	}

	public void setSearchFieldValue(String searchValue) {
			driver.findElement(searchField).sendKeys(searchValue);
		}
	
		public void clickOnSearch() {
			driver.findElement(button_Search).click();
		}
	
		public void clickOnSelectedItem() {
			driver.findElement(selectItem).click();
		}
	
		public void selecteItem() {
			driver.findElement(selectbottleItem).click();
		}
	
		public void selectSize() {
			// driver.findElement(sizeOfItem).click();
			// Select selectByValue = new
			// Select(driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']/option[contains(text(),4)]")));
			Select selectByValue = new Select(
					driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']")));
			selectByValue.selectByValue("0,B01FD7CEW6");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		public void selectQuantity() {
			driver.findElement(selectQuantity).click();
			Select selectByValue = new Select(driver.findElement(By.id("quantity")));
			selectByValue.selectByValue("4");
		}
	
		public void clickOnAddToCartButton() {
			driver.findElement(button_addToCard).click();
		}
	
		public String getValueofSingleProceededOrder() {
			String valueOfProceededOrder = driver.findElement(getvalueofsingleorder).getText();
			return valueOfProceededOrder;
	
		}
	
		public void buttonCart() {
			driver.findElement(button_Cart).click();
		}
	
		public void deleteCart() {
			driver.findElement(button_Delete).click();
		}
	
		public void clearValueInSearchField() {
			driver.findElement(searchField).clear();
		}
	
		public void selectItemFromTheList() {
			List<WebElement> suggestions = driver
					.findElements(By.xpath("//div[@id='suggestions']/div[@class='s-suggestion']"));
	
			for (WebElement we : suggestions) {
				we.click();
				break;
			}
		}
	
		public void switchToNewWindow(String window) {
			Set<String> handles = driver.getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(window)) {
					driver.switchTo().window(windowHandle);
				}
			}
	
		}
		
		public void bulkOrderPlacement(String[] items){
			//String[] items = {item1, item2, item3};
			int length = items.length;
					for (int i=0;i<length;i++)
					{   
						clearValueInSearchField();
						setSearchFieldValue(items[i]);
						selectItemFromTheList();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
						String parentWindow = driver.getWindowHandle();
						clickOnSelectedItem();
						switchToNewWindow(parentWindow);
						clickOnAddToCartButton();
					}
			
		}
}

