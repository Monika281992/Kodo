//Validate product search on base of Sessions

// not valid code

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

public class SessionValidation extends Base{
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	
	@Test    //expected o fail
	public void SummerDress () throws InterruptedException {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys("Summer dress");
		se.SubmitButton().submit();
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);    
		if (productcount>0) {
        for (int i=0;i<productcount;i++) {
			String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
			Thread.sleep(5000);
			//System.out.println(productName);
			AssertJUnit.assertTrue(productName.contains("Dress"));
		}
        for (int i=0;i<productcount;i++) {
			String link = driver.findElements(By.xpath(productContainer)).get(i).getAttribute("href");
			Thread.sleep(2000);
			//System.out.println(link);
			AssertJUnit.assertTrue(link.contains("Summer+dress"));
		}
        } else{
        	se.AlertMessage().getText();
        }}
        
	@Test
	public void winterDress () throws InterruptedException {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys("Winter dress");
		se.SubmitButton().submit();
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);    
		
        for (int i=0;i<productcount;i++) {
			String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
			Thread.sleep(2000);
			//System.out.println(productName);
			AssertJUnit.assertTrue(productName.contains("dress"));
		}
        for (int i=0;i<productcount;i++) {
			String link = driver.findElements(By.xpath(productContainer)).get(i).getAttribute("href");
			Thread.sleep(2000);
			//System.out.println(link);
			AssertJUnit.assertTrue(link.contains("Winter+Dress"));
		}
        }

}
