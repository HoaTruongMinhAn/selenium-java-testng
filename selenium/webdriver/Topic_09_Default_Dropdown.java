package webdriver;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
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
    String day = "31", month = "December", year = "2000";

    @BeforeClass
    public void beforeClass() {
        Cookie cloudflareCookie = new Cookie("cf_clearance", "RUpMI8a1HjAlWreZpxr2Xy1gCxSitnJf7VwGmpi46cc-1729816432-1.2.1.1-enqhijqpurZbJ3YK7wbX5Ml89x9b03QnOozTFolI2LXMQkEBhz17uUzS5OlCRl5.HqTPpxuJXrNU9MZf8lf7DdmSkvn4x7Hd_0c0N7i3yKoigeVNxSDBWs6azLmCGpMiPracx3uxlZCzhJUO1Uw6p26yWmjGknUeY4TjbTAW4HkfwZqRa9MQ2bxZsX3IvdpY3JFuBEW1.4uUF9NcQa9bErHNVUhdAK9VVQ5dTCB_Az72OY37fkP2FrsXxYGKyYzcEWYXBlvc_pEGFMo1UAyg4GexkTVf6JsvYBlQ9bDJ0W5WERjbeilct_P1vz3MNVAD2tiVitBWtLH4ByY_odEM5iXI6mXpPPSIwBlBH2HvDRTdVYtZUCXK6nMlMrsw.oVfdzN25IXKXg_ilG9iVn2uHA");

        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().addCookie(cloudflareCookie);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }

    @Test
    public void TC_01_Register() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.48we03cvzjbk

        //Step 01 - Truy cập vào trang: https://demo.nopcommerce.com
        driver.get("https://demo.nopcommerce.com/");

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

        dayDropList.selectByVisibleText(day);
        monthDropList.selectByVisibleText(month);
        yearDropList.selectByVisibleText(year);

        //Email
        driver.findElement(By.cssSelector("input[id='Email']")).sendKeys(email);

        //Password
        driver.findElement(By.cssSelector("input[id='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='ConfirmPassword']")).sendKeys(password);

        //Step 04 - Click REGISTER button
        driver.findElement(By.cssSelector("button[id='register-button']")).click();

        //Step 05 - Verify đã vào trang Home Page sau khi đăng kí thành công
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='result']")).isDisplayed());

        //Step 06 - Click vào trang My Account và kiểm tra ngày/ tháng/ năm nhập vào là đúng
        driver.findElement(By.cssSelector("a[class='ico-account']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='gender-male']")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id='FirstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id='LastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),year);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id='Email']")).getAttribute("value"),email);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}