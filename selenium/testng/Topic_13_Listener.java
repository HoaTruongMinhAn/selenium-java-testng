package testng;

import listener.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

@Listeners(ScreenshotListener.class)
public class Topic_13_Listener {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws FileNotFoundException {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Textbox_Textarea() throws IOException {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.kahqnrvcqvkn
        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("https://live.techpanda.org/");

        //Step 02 - Click vào link "My Account" để tới trang đăng nhập
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        //Step 03 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInSeconds(2);
        Assert.assertTrue(false);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
