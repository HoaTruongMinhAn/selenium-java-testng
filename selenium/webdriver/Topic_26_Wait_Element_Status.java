package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Wait_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.1koycpqriocf

    @Test
    public void TC_01_Visible() {
        //Điều kiện 1 - Element hiển thị ở trên UI và có trong DOM/ cây HTML
        driver.get("https://www.facebook.com/");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
    }

    @Test
    public void TC_02_Invisible() {
        //Điều kiện 2 - Element ko hiển thị ở trên UI và có trong DOM
        //Điều kiện 3 - Element ko hiển thị trên UI và ko có trong DOM
        driver.get("https://www.facebook.com/");

        //Step 1: Click Create new account
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //Verify Email textbox displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));

        //Verify Pronoun droplist is not displayed
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        //Step 2: Select Custom gender
        driver.findElement(By.xpath("//input[@id='sex' and @value='-1']")).click();

        //Verify Pronoun droplist is displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        //Step 3: Select Female gender
        driver.findElement(By.xpath("//input[@id='sex' and @value='1']")).click();

        //Verify Pronoun droplist is not displayed
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        //Step 4: Click on Already has account link
        driver.findElement(By.xpath("//a[@aria-label='Already have an account?']")).click();

        //Verify Pronoun droplist is not displayed
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));
    }

    @Test
    public void TC_03_Presence() {
        //ĐK 01: Element hiển thị ở trên UI và có trong DOM
        //ĐK 02: Element ko hiển thị ở trên UI và có trong DOM
        driver.get("https://www.facebook.com/");

        //Step 1: Click Create new account
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //Verify Email textbox displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));

        //Verify Pronoun droplist is presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        //Step 2: Select Custom gender
        driver.findElement(By.xpath("//input[@id='sex' and @value='-1']")).click();

        //Verify Pronoun droplist is presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        //Step 4: Click on Already has account link
        driver.findElement(By.xpath("//a[@aria-label='Already have an account?']")).click();

        //Verify Pronoun droplist is not presence
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));
    }

    @Test
    public void TC_04_Staleness() {
        //ĐK 03: Element ko hiển thị trên UI và ko có trong DOM
        driver.get("https://www.facebook.com/");

        //Step 1: Click Create new account
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //Verify Email textbox displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));

        //Verify Pronoun droplist is presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        WebElement pronounDroplist = driver.findElement(By.xpath("//select[@id='preferred_pronoun']"));

        //Step 2: Select Custom gender
        driver.findElement(By.xpath("//input[@id='sex' and @value='-1']")).click();

        //Verify Pronoun droplist is presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));

        //Step 4: Click on Already has account link
        driver.findElement(By.xpath("//a[@aria-label='Already have an account?']")).click();

        //Verify Pronoun droplist is staleness
        explicitWait.until(ExpectedConditions.stalenessOf(pronounDroplist));

        //Verify Pronoun droplist is not displayed
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//select[@id='preferred_pronoun']")));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}