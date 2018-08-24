package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT
{
    WebDriver driver;
    WebDriver driver1;


    @Test(dataProvider = "getData")
    public void loginTest(String name, String email, String password)
    {
        System.out.println("NEW RECORD: " + name + " " + email + " " + password);


        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION " + message);

        driver1.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
        driver1.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
        driver1.findElement(By.name("ctl00$MainContent$btnLogin")).click();
        //String message = driver1.findElement(By.id("conf_message")).getText();
        //System.out.println("CONFIRMATION " + message);
    }






    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        driver1 = new FirefoxDriver();
        driver1.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");


    }

    @AfterMethod
    public void tearDown()
    {
        //driver.quit();

    }


    @DataProvider
    public String[][] getData()
    {
        return utilities.Excel.get("C:\\Users\\ABC\\Documents\\Selenium\\UserLogin.xls");
    }
}

