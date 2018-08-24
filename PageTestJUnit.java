package smokeTest;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTestJUnit {
    String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    WebDriver driver = utilities.DriverFactory.open("chrome");

    @Test
    public void PageTitleTest() {
        System.out.println("Running the test");



        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Before
    public void setUp()
    {
        driver.get(webURL);
        System.out.println("Setting up the test");
        System.out.println("Intialzing the test");
    }

    @After
    public void tearDown()
    {
        System.out.println("Closing the test");
        System.out.println("Closing the driver");
        driver.close();
    }
}
