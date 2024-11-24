package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_26_Wait_FindElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        List<WebElement> elements = driver.findElements(By.xpath("//input[@id='Email']"));
        System.out.println("Size: " + elements.size());

        //Many elements found
        elements = driver.findElements(By.xpath("//input[@type='text']"));
        System.out.println("Size: " + elements.size());

        //No element found
        elements = driver.findElements(By.xpath("//button[text()='Log in']"));
        System.out.println("Size: " + elements.size());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}