package webdriver;


import org.openqa.selenium.Alert;
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

public class Topic_15_JS_Alert {
    WebDriver driver;
    WebDriverWait exlicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        exlicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Accept_Alert() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.5ettdlnuwt3g
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(2);

        //Step 02 - Click vào button: Click for JS Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //Method 1: use switchTo
//        Alert alert1 = driver.switchTo().alert();

        //Method 2: use wait
        Alert alert1 = exlicitWait.until(ExpectedConditions.alertIsPresent());

        //Step 03 - Verify message hiển thị trong alert là: I am a JS Alert

        Assert.assertEquals(alert1.getText(), "I am a JS Alert");
        sleepInSeconds(2);

        //Step 04 - Accept alert và verify message hiển thị tại Result là:  You clicked an alert successfully
        alert1.accept();
        WebElement resultLabel = driver.findElement(By.cssSelector("p#result"));
        Assert.assertEquals(resultLabel.getText(), "You clicked an alert successfully");
    }


    @Test
    public void TC_02_Confirm_Alert() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.5ettdlnuwt3g
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(2);

        //Step 02 - Click vào button: Click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //Step 03 - Verify message hiển thị trong alert là: I am a JS Confirm
        Alert alert1 = exlicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert1.getText(), "I am a JS Confirm");
        sleepInSeconds(2);

        //Step 04 - Cancel alert và verify message hiển thị tại Result là:  You clicked: Cancel
        alert1.dismiss();
        WebElement resultLabel = driver.findElement(By.cssSelector("p#result"));
        Assert.assertEquals(resultLabel.getText(), "You clicked: Cancel");

        //Step 05 - Confirm alert và verify message hiển thị tại Result là:  You clicked: Cancel
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert1 = exlicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSeconds(2);
        alert1.accept();
        Assert.assertEquals(resultLabel.getText(), "You clicked: Ok");
    }

    @Test
    public void TC_03_Prompt_Alert() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.5ettdlnuwt3g
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(2);


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