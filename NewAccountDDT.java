package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static org.junit.runners.Parameterized.*;

@RunWith(value = Parameterized.class)
public class NewAccountDDT
{
    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occasionalEmail;
    WebElement nameElement, emailElement, passwordElement, phoneElement, verifyPassword, countryElement,
            weeklyCheckbox, monthlyCheckbox, submitButton;
    WebDriver driver;

    //this is our test method
    @Test
    public void newAccountTest()
    {
        System.out.println("NEW RECORD: " + name + "  " + email + "  " + phone + "  " + gender + "  " + password + " " +
                "" + "" + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);

        //if(phone.equals("4567891230")){
        //Assert.fail();

        //Define Web Elements
        defineWebelements();

        //fill in the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phone);
        passwordElement.sendKeys(password);
        verifyPassword.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        //gender
        if (gender.equalsIgnoreCase("Male"))
        {
            driver.findElement(By.id("MainContent_Male")).click();
        } else
            {
            driver.findElement(By.id("MainContent_Female")).click();
        }

        //check box
        if (weeklyEmail) {
            if (!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        } else if (weeklyCheckbox.isSelected()) {
            weeklyCheckbox.click();
        }


        //  driver.findElement(By.id("MainContent_checkUpdates")).click();
        //submitButton.click();

        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";

        if (conf.equals(expected)) {

            System.out.println("Confirmed " + conf);
        } else {
            System.out.println("TEST FAILED");
        }


    }

    @Before
    public void setUp()
    {
        driver = utilities.DriverFactory.open("chrome");
        // open web browser and navigate to web application
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.linkText("CREATE ACCOUNT")).click();
        //driver.findElement(By.xpath("a[@class='btn btn-default']")).click();

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    public void defineWebelements()
    {
        //Define Web Elements
        nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        passwordElement = driver.findElement(By.cssSelector("input[id = 'MainContent_txtPassword']"));
        phoneElement = driver.findElement(By.xpath("//input[@id='MainContent_txtHomePhone']"));
        verifyPassword = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        countryElement = driver.findElement(By.name("ctl00$MainContent$menuCountry"));
        weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
    }

    //This annotated method is designed to pass parameters into the class via constructor
    @Parameters
    public static List<String[]> getData()
    {
        return utilities.CSV.get("C:\\Users\\ABC\\Documents\\Selenium\\UserAccounts.csv");
    }

    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
                         String weeklyEmail, String monthlyEmail, String occasionalEmail)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;
        if (weeklyEmail.equals("TRUE"))
        {
            this.weeklyEmail = true;
        } else
            {
            this.weeklyEmail = false;
        }

        if (monthlyEmail.equals("TRUE")) {
            this.monthlyEmail = true;
        } else {
            this.monthlyEmail = false;
        }

        if (occasionalEmail.equals("TRUE")) {
            this.occasionalEmail = true;
        } else {
            this.occasionalEmail = false;
        }


    }


}
