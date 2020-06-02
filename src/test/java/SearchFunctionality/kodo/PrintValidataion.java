// Validate result for print type

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementsList.SearchElements;

public class PrintValidataion extends Base {
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";

	
	@Test (dataProvider ="printType")
	public void validation (String printType ) throws InterruptedException {
		SearchElements se = new SearchElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(printType);
		se.SubmitButton().submit();
		int productcount = driver.findElements(By.xpath(productContainer)).size();
		//System.out.println(productcount);    
		if (productcount>0) {
        for (int i=0;i<productcount;i++) {
			String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
			Thread.sleep(5000);
			//System.out.println(productName);
			AssertJUnit.assertTrue(productName.contains("Printed"));
		}
        } else{
        	String expectedAlert = "No results were found for your search \"" + printType +   "\"";
        	String actualAlert = se.AlertMessage().getText();
        	AssertJUnit.assertEquals(actualAlert, expectedAlert);
        }}
	
	@DataProvider(name = "printType")
    public String[][] printType() {
        return new String[][] {
                {"printed dress"},
                {"plain dress"}
        };}
}
