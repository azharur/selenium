package smokeTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestng {

    @Test

    public void loginTest()
    {
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        boolean loginEmail = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
        boolean password = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();

        Assert.assertTrue(loginEmail);
        Assert.assertTrue(password);




    }

}
