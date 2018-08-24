package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver open(String browserType) {
        if (browserType.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\ABC\\Documents\\Selenium\\IEDriverServer.exe");
            return new InternetExplorerDriver();

        }
        else if (browserType.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ABC\\Documents\\Selenium\\geckodriver.exe");
            return new FirefoxDriver();

        }
        else
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Documents\\Selenium\\chromedriver.exe");
            return new ChromeDriver();


        }

    }
}
