package webdriver;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;
    Random rand;
    String firstName, lastName, email, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Register() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.48we03cvzjbk

        //Step 01 - Truy cập vào trang: https://demo.nopcommerce.com
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //Step 02 - Click Register link trên Header
        driver.findElement(By.cssSelector("a[class='ico-register']")).click();

        //Step 03 -  Input các thông tin hợp lệ vào form
        //Random using timestamp
        long currentTime = new Timestamp(System.currentTimeMillis()).getTime();

        String firstName = "testFN" + currentTime;
        String lastName = "testLN" + currentTime;
        String email = "testEmail" + currentTime + "@aaa.com";
        String password = "testPassword@" + currentTime;

        driver.findElement(By.cssSelector("input[id='gender-male']")).click();

        //First name
        driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys(firstName);

        //Last name
        driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys(lastName);

        //DOB
        Select dayDropList = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        Select monthDropList = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        Select yearDropList = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));


        Assert.assertFalse(dayDropList.isMultiple());
        Assert.assertFalse(monthDropList.isMultiple());
        Assert.assertFalse(yearDropList.isMultiple());

        Assert.assertEquals(dayDropList.getOptions().size(),32);
        Assert.assertEquals(monthDropList.getOptions().size(),13);
        Assert.assertEquals(yearDropList.getOptions().size(),112);

        dayDropList.selectByVisibleText("31");
        monthDropList.selectByVisibleText("December");
        yearDropList.selectByVisibleText("2000");



        //Email
        driver.findElement(By.cssSelector("input[id='Email']")).sendKeys(email);

        //Password
        driver.findElement(By.cssSelector("input[id='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='ConfirmPassword']")).sendKeys(password);

        //Step 04 - Click REGISTER button
        driver.findElement(By.cssSelector("button[id='register-button']")).click();

        //Step 05 - Verify đã vào trang Home Page sau khi đăng kí thành công

        //Step 06 - Click vào trang My Account và kiểm tra ngày/ tháng/ năm nhập vào là đúng

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

    public void acceptAlert(){
        //Handle browser alert: click Continue
        Alert alert = driver.switchTo().alert();
        alert.accept();
        sleepInSeconds(5);
    }
}