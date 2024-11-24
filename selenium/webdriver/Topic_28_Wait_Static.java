package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Wait_Static {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.6h4x00fpbmz8
    @Test
    public void TC_01_Less_Than() throws InterruptedException {

        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Define a static wait (Thread.sleep)
        Thread.sleep(3000);

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_02_Equal() throws InterruptedException {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Define a static wait (Thread.sleep)
        Thread.sleep(5000);

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_03_Greater_Than() throws InterruptedException {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Click the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Step 03 - Define a static wait (Thread.sleep)
        Thread.sleep(10000);

        //Step 04 - Check result text is "Hello World!"
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}