package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.remote.DesiredCapabilities;

//@SuppressWarnings("ALL")
public class CreateAccount
{
    public static void main(String[] args)
    {

        String name = "minuu";
        String email = "minnu@testemail.com";
        String password = "london";
        String phoneNumber = "1234567";
        String country = "India";
        String browserType = "firefox";
        String gender = "Male";
        WebDriver driver;

        Boolean weeklyEmail = true;
        Boolean monthlyEmail = false;
        Boolean occassionalEmail = false;

        // create webdriver


        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\ABC\\Documents\\Selenium\\geckodriver.exe");
        //driver = new FirefoxDriver();

        driver =utilities.DriverFactory.open(browserType);


        // open web browser and navigate to web application
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        driver.findElement(By.linkText("CREATE ACCOUNT")).click();
        //driver.findElement(By.xpath("a[@class='btn btn-default']")).click();

        //Define Web Elements

        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id = 'MainContent_txtPassword']"));
        WebElement phoneElement = driver.findElement(By.xpath("//input[@id='MainContent_txtHomePhone']"));
        WebElement verifyPassword = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.name("ctl00$MainContent$menuCountry"));
        WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));








        //fill in the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPassword.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        //gender

        if (gender.equalsIgnoreCase("Male"))
        {
            driver.findElement(By.id("MainContent_Male")).click();
        }
        else
            {
            driver.findElement(By.id("MainContent_Female")).click();
        }

        //check box
        if (weeklyEmail)
        {
            if (!weeklyCheckbox.isSelected())
            {
                weeklyCheckbox.click();
            }
        }
        else
            if (weeklyCheckbox.isSelected())
        {
                weeklyCheckbox.click();
            }





      //  driver.findElement(By.id("MainContent_checkUpdates")).click();
        submitButton.click();

       String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
       String expected = "Customer information added successfully";
       if (conf.equals(expected)) {

           System.out.println("Confirmed " + conf);
       }
       else {
           System.out.println("TEST FAILED");
       }

        driver.close();



        // navigate to account management >> create account

       // driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // fill out the farm
        // get confirmation
        // close the browser



    }

}

