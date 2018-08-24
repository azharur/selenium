package fun;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Youtube {

    String gaana = "bana ja tu mere rani";

@Test

    public void hindi(){
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get("https://www.youtube.com/");

        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(gaana);
        driver.findElement(By.id("search-icon-legacy")).click();

        driver.findElement(By.xpath("//*[@id=\"video-title\"]")).click();
        //driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[21]/div[2]/div[2]/button[6]")).click();

    //driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[1]/video")).click();
    

    }


}
