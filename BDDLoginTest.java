package stepImplementation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDLoginTest {
    WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page()
    {
        System.out.println("User is on login page");
        driver = utilities.DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

    }


    @When("^user enter the correct username and correct password$")
    public void user_enter_the_correct_username_and_correct_password()
    {
        System.out.println("user enterss username and password");
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys("time@testemail.com");
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trspa11");
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @Then("^user gets the confirmation$")
    public void user_gets_the_confirmation()
    {
        System.out.println("user get confirmation");
        Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
    }
}
