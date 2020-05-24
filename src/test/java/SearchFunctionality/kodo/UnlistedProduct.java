//Validate result for unlisted products



package SearchFunctionality.kodo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class UnlistedProduct extends Base {

	
	@Test (dataProvider= "unlistedproduct")
	public void unlistedproduct (String unlistedproduct ) throws IOException, InterruptedException {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(unlistedproduct);
		se.SubmitButton().submit();
		Thread.sleep(2000);
		String Text = se.AlertMessage().getText();
		//System.out.println(Text);
		String alert = "No results were found for your search \"" + unlistedproduct + "\"" ;
		Assert.assertEquals(alert, Text);
	}
	@AfterMethod
    public void afterEachMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
	@DataProvider(name = "unlistedproduct")
    public String[][] unlistedproduct() {
        return new String[][] {
                {"bedsheets"},
                {"Pillow cover"},
                {"utensils"}
        };}
}