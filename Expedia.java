package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType ="chrome";
    String city ="London, England, United Kingdom";
    String checkIn = "09/09/2018";
    String checkOut = "09/10/2018";
    String starRating = "star4";
    String searchResult ="3";
    //String noofGuests = "2";


    @Test

    public void hotelReservation(){
        //search
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
        driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button")).click();
        /* driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div/div[2]/div[4" +
         "]/button/span[1]/svg")).click(); */
        //driver.findElement(By.id("search-button-hp-package")).click();

       // String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
        //System.out.println("CITY : " +actualCity);

        //modify the search result
       // driver.findElement(By.cssSelector("input[name='star'][id='" + starRating + "']")).click();
        //anaylise the search
        //driver.findElement(By.xpath("//*[@id=\"3113039\"]/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
        //switch the window to pop
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        //print hotel name

        String hotelName = driver.findElement(By.id("hotel-name")).getText();
        String hotelRating = driver.findElement(By.cssSelector("span[class='rating-scale']")).getText();
        System.out.println("RATINGS" +hotelRating);
        System.out.println("HOTEL" +hotelName);
        //book reservation
        //fill out contact
        //get confirmation


    }

    @BeforeMethod
    public void setUp(){
        driver = utilities.DriverFactory.open(browserType);
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
    }
    @AfterMethod
    public void tearDown(){
       // driver.quit();

    }
}
