
//Validate product search on base of gender

package SearchFunctionality.kodo;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class GenderValidation extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	
	@Test()     //expected to fail as count is different
	public void womenDress() throws InterruptedException {
		
		SearchElements se = new SearchElements(driver);
		Thread.sleep(2000);
		se.Dresses().click();
		Thread.sleep(5000);
		int itemcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(itemcount);
		se.SearchBar().sendKeys("women dress");
		se.SubmitButton().submit();
		Thread.sleep(5000);
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);
		Assert.assertEquals(productcount, itemcount);
		 }
	
}
