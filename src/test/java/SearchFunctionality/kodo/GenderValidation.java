
//Validate product search on base of gender

package SearchFunctionality.kodo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementsList.SearchElements;

public class GenderValidation extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	SearchElements se = new SearchElements(driver);
	
	@Test()     //expected to fail as count is different
	public void womenDress() throws InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.Dresses().click();
		int itemcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(itemcount);
		se.SearchBar().sendKeys("women dress");
		se.SubmitButton().submit();
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);
		AssertJUnit.assertEquals(productcount, itemcount);
		 }
	
}
