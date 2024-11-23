package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Wait_FindElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_FindElement() {
        //Exercise link:
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //1 element found
        driver.findElement(By.xpath("//input[@id='Email']"));

        //Many elements found
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("aaaaaa");

        //No element found
        driver.findElement(By.xpath("//button[text()='Log in']"));
    }

    @Test
    public void TC_02_FindElements() {
        //Exercise link:
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //1 element found


        //Many elements found


        //No element found

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}