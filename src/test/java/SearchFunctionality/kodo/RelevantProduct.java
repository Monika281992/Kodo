
//Validate if relevant product are displayed when correct name entered


package SearchFunctionality.kodo;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class RelevantProduct extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	
	//when corrcet data entered
	@Test(dataProvider= "correctName")
	public void correctName (String correctName ) throws InterruptedException {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(correctName);
		se.SubmitButton().submit();
		Thread.sleep(5000);
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);     
        for (int i=0;i<productcount;i++) {
			String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
			Thread.sleep(2000);
			//System.out.println(productName);
			Assert.assertTrue(productName.contains(correctName));
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