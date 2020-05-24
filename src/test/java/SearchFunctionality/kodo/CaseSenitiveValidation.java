
//Validate that serach bar is not case sensitive

package SearchFunctionality.kodo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class CaseSenitiveValidation extends Base {
	
String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	
	    // DRESSES   (Expected to fail as we have one item as t-shirt)
		@Test
		public void dresses () throws InterruptedException {
			SearchElements se = new SearchElements(driver);
			se.SearchBar().clear();
			se.SearchBar().sendKeys("DRESSES");
			se.SubmitButton().submit();
			Thread.sleep(5000);
			int productcount = driver.findElements(By.xpath(productContainer)).size();
			//System.out.println(productcount);
			
			for (int i=0;i<productcount;i++) {
				String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
				Thread.sleep(2000);
				//System.out.println(productName);
				Assert.assertTrue(productName.contains("Dress"));
				
			}}
		
		//T-shirts(Expected to pass)
		@Test     
		public void tshirts () throws InterruptedException {
			SearchElements se = new SearchElements(driver);
			se.SearchBar().clear();
			se.SearchBar().sendKeys("t-shirts");
			se.SubmitButton().submit();
			Thread.sleep(5000);
			int productcount = driver.findElements(By.xpath(productContainer)).size();
			//System.out.println(productcount);
			
			for (int i=0;i<productcount;i++) {
				String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
				Thread.sleep(2000);
				//System.out.println(productName);
				Assert.assertTrue(productName.contains("T-shirts"));
				
			}}

}
