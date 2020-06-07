
//Validate if relevant product are displayed when correct name entered


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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementsList.SearchElements;

public class RelevantProduct extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	SearchElements se = new SearchElements(driver);
	
	//when corrcet data entered
	@Test(dataProvider= "correctName")
	public void correctName (String correctName ) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(correctName);
		se.SubmitButton().submit();
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);     
        for (int i=0;i<productcount;i++) {
			String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
			Thread.sleep(2000);
			//System.out.println(productName);
			AssertJUnit.assertTrue(productName.contains(correctName));
		}
		
	}
	 @AfterMethod
	    public void afterEachMethod() throws InterruptedException {
	        Thread.sleep(2000);
	    }
	
	@DataProvider(name = "correctName")
    public String[][] correctName() {
        return new String[][] {
                {"Dress"},
                {"T-shirts"}
        };}
   
}