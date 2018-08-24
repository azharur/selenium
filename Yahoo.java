package fun;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Yahoo
{
    @Test
    public void LoginTest() throws InterruptedException
    {
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get("https://www.mylocalpitch.com/london");

        driver.manage().window().maximize();















    }
}
