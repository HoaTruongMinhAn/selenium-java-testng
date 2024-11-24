package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_32_Wait_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Element_Found() {
        //Exercise link:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait using implicit
        driver.findElement(By.xpath("//input[@id='email']"));

        //Wait using explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
    }

    @Test
    public void TC_02_Element_Not_Found_Implicit() {
        //Exercise link:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Wait using implicit
        driver.findElement(By.xpath("//input[@id='xxx']"));
    }

    @Test
    public void TC_03_Element_Not_Found_Mix_Located_By() {
        //Exercise link:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println("Start on " + new Date().toString());

        //Wait using explicit
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='xxx']")));
        } catch (TimeoutException e) {
            System.out.println("Explicit Wait Timeout on " + new Date().toString());
        }

        System.out.println("End on " + new Date().toString());

        /*Result
         * Implicit 0s, Explicit 0s => total 0s
         * Implicit 0s, Explicit 10s => total 10s
         * Implicit 5s, Explicit 0s => total 5s
         * Implicit 5s, Explicit 3s => total 5s
         * Implicit 5s, Explicit 10s => total 10s
         * Implicit 5s, Explicit 12s => total 15s
         * Implicit 6s, Explicit 20s => total 26s (I expect 24s)
         * Implicit 5s, Explicit 5s => total 5s (I expect 10s)
         * Implicit 15s, Explicit 10s => total 15s
         * */

        /* Summary
         * Explicit call findElement and findElement (Implicit) run 1st
         * If findElement fail and Explicit still has time => try findElement again
         * If findElement fail and Explicit still out of time => throw exception
         */
    }

    @Test
    public void TC_04_Element_Not_Found_Mix_Located_Element() {
        //Exercise link:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println("Start on " + new Date().toString());

        //Wait using explicit
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='xxx']"))));
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Explicit Wait Timeout on " + new Date().toString());
        }

        System.out.println("End on " + new Date().toString());

        /*Result
         * Implicit 0s, Explicit 0s => total 0s
         * Implicit 0s, Explicit 10s => total 0s
         * Implicit 5s, Explicit 0s => total 5s
         * Implicit 5s, Explicit 3s => total 5s
         * Implicit 5s, Explicit 10s => total 5s
         * Implicit 5s, Explicit 12s => total 5s
         * Implicit 6s, Explicit 20s => total 6s
         * Implicit 5s, Explicit 5s => total 5s
         * Implicit 15s, Explicit 10s => total 15s
         * */

        /* Summary
         * findElement (Implicit) run 1st. After findElement successfully then run Explicit
         * If findElement fail => throw exception
         */
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}