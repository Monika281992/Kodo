

//Validate product search on base of age
//Assuming we do not have products for kids and boys
package SearchFunctionality.kodo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;
 
public class AgeValidation extends Base{
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";

	@Test(dataProvider = "age")     
	public void womenDress(String age ) throws InterruptedException {
		
		SearchElements se = new SearchElements(driver);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(age);
		se.SubmitButton().submit();
		Thread.sleep(2000);
		String expectedAlert = "No results were found for your search \"" + age + "\"";
		String actualAlert = se.AlertMessage().getText();
		Assert.assertEquals(actualAlert, expectedAlert);
		
		 }
	
	@DataProvider(name = "age")
    public String[][] age() {
        return new String[][] {
                {"toddler"},
                {"girls"},
                {"kids"}
        };}
	
}
