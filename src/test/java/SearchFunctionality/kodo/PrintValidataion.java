// Validate result for print type

package SearchFunctionality.kodo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class PrintValidataion extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";

	
	@Test (dataProvider ="printType")
	public void validation (String printType ) throws InterruptedException {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(printType);
		se.SubmitButton().submit();
		Thread.sleep(5000);
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);    
		if (productcount>0) {
        for (int i=0;i<productcount;i++) {
			String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
			Thread.sleep(5000);
			//System.out.println(productName);
			Assert.assertTrue(productName.contains("Printed"));
		}
        } else{
        	String expectedAlert = "No results were found for your search \"" + printType +   "\"";
        	String actualAlert = se.AlertMessage().getText();
        	Assert.assertEquals(actualAlert, expectedAlert);
        }}
	
	@DataProvider(name = "printType")
    public String[][] printType() {
        return new String[][] {
                {"printed dress"},
                {"plain dress"}
        };}
}
