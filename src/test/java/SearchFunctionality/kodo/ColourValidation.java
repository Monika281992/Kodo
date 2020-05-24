
//Validate product search on base of product colour 

package SearchFunctionality.kodo;




import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class ColourValidation extends Base {
	
	@Test(dataProvider = "colours")     //expected to pass
	public void colour ( String colours) throws InterruptedException {
		 String expectedalert = "No results were found for your search \"" + colours + "\"" ;
			SearchElements se = new SearchElements(driver);
			se.SearchBar().clear();
			se.SearchBar().sendKeys(colours);
			se.SubmitButton().submit();
			int productcount = driver.findElements(By.xpath("//div[@class='product-container']//div[2]//h5//a")).size();
			System.out.println(productcount);
			if (productcount > 0) {
			if (se.blackColour().isDisplayed()) {
				Assert.assertTrue(se.blackColour().isDisplayed());
			} else if (se.yellowColour().isDisplayed()) {
				Assert.assertTrue(se.yellowColour().isDisplayed());
			  
			}
			}else {
				Thread.sleep(2000);
				String actualalert = se.AlertMessage().getText();
				Assert.assertEquals(actualalert, expectedalert);
			}
			
			
	   }
	
	@DataProvider(name = "colours")
    public String[][] colours() {
        return new String[][] {
                {"Yellow Dress"},
                {"Black Blouse"},
                {"Red Dress"}
        };}
	
}
