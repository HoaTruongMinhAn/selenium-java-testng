package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_27_Wait_Implicit {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.qzir6p510t2j
    @Test
    public void TC_01_Not_Wait() {

        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 03 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_02_Less_Than() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Define an implicit wait (If you set 2 seconds, test will fail)
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4700));

        //Step 03 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_03_Equal() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Define an implicit wait (If you set 2 seconds, test will fail)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Step 03 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_04_Greater_Than() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Define an implicit wait (If you set 2 seconds, test will fail)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Step 03 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}