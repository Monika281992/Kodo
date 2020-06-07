// Validation of product on the basis of synonyms
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

public class SynonymsValidation extends Base{
	
String URL = "http://automationpractice.com/index.php"; 
SearchElements se = new SearchElements(driver);
	@Test(dataProvider= "synonyms")
	public void validation (String synonyms) throws InterruptedException {
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(synonyms);
		se.SubmitButton().submit();
		AssertJUnit.assertTrue(se.ProductName().isDisplayed());  
		
		//check if correct product is displayed
	    int productcount = driver.findElements(By.xpath("//div[@class='product-container']//div[2]//h5//a")).size();
		for (int i=0;i < productcount;i++) {
			String productName = driver.findElements(By.xpath("//div[@class='product-container']//div[2]//h5//a")).get(i).getText();
			Thread.sleep(5000);
			//System.out.println(productName);
			AssertJUnit.assertTrue(productName.contains("Blouse"));
		}}
		
	 @AfterMethod
	    public void afterEachMethod() throws InterruptedException {
	        Thread.sleep(2000);
	    }
	@DataProvider(name = "synonyms")
    public String[][] synonyms() {
        return new String[][] {
                {"tops"},               
                {"blouse"},
                {"short tops"}
        };}
}
