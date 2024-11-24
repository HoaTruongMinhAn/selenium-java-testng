package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_30_Wait_Explicit_Practice2 {
    WebDriver driver;
    WebDriverWait explicitWait;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }


    //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.sbf6pmem687z
    @Test
    public void TC_01_Less_Than() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Wait Hello World visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_02_Equal() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Wait Hello World visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_03_Greater_Than() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Wait Hello World visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_04_Greater_Than_Another_Way() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Wait Hello World visible
        WebElement messageLabel = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4"))); //Work well, recommend to use visibility
//        explicitWait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']/h4"), "Hello World!")); //Work well, but textToBe not highly recommend as visibility

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(messageLabel.getText(),"Hello World!");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
