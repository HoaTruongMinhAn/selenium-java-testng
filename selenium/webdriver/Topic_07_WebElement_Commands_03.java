package webdriver;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_03 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //Exercise link: https://docs.google.com/document/d/1G0QsiVDI5KfhNGKxE6a03bhn6KpvgDh69BTx2ttCO94/edit?tab=t.0#heading=h.rxsoxciaatu0

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("button[id='send2']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='advice-required-entry-email']")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='advice-required-entry-pass']")).getText(),"This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("123123123@123123123");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[id='send2']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void Login_03_Password_Less_Than_6() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("123123123@aaa.com");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("123");
        driver.findElement(By.cssSelector("button[id='send2']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Login_04_Invalid_Email_And_Password() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("automation111@gmail.com");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("button[id='send2']")).click();
        sleepInSeconds(2);


        Alert alert = driver.switchTo().alert();
        //Press the OK button
        alert.accept();
        sleepInSeconds(5);

        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='error-msg'] span")).getText(),"Invalid login or password.");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}