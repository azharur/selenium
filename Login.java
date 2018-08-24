package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.server.handler.MaximizeWindow;

public class Login {
    public static void main(String[] args)
    {

        // define the web driver

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Documents\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // open web browser and navigate to web application
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // Find the element, locate the element, determine the action, pass the parameters.


        // enter email address

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        // enter password

        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        // click login

        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
        // get confirmation

        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION " + message);

        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: " + pageTitle);
        // close browser

        driver.close();



    }
}
