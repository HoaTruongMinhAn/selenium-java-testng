package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.List;

public class Topic_24_JavascriptExecutor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Set timeout for script. Not useful because it only applies for async script
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void TC_00_Practice_Javascript() {
        //Exercise link:
        driver.get("https://demo.nopcommerce.com/");

        //get domain
        System.out.println(jsExecutor.executeScript("return document.domain;"));

        //get web element
        WebElement searchTextBox = (WebElement) jsExecutor.executeScript("return document.querySelector('input#small-searchterms');");
        searchTextBox.sendKeys("aaaaaaaaaaa");

        //get list web element
        List<WebElement> elements = (List<WebElement>) jsExecutor.executeScript("return document.querySelectorAll('input');");
        for (WebElement element : elements) {
            System.out.println(element.getAttribute("id"));
        }
    }

    @Test
    public void TC_01_Live_TechPanda_Direct_Script() {
        //Exercise link:
        jsExecutor.executeScript("window.location='https://live.techpanda.org/';");

        explicitWait.until(ExpectedConditions.urlToBe("https://live.techpanda.org/"));

        Assert.assertEquals(jsExecutor.executeScript("return document.URL;"), "https://live.techpanda.org/");
        Assert.assertEquals(jsExecutor.executeScript("return document.domain;"), "live.techpanda.org");

        //Click on Mobile
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mobile']")));

        //Note: able to executeScript with both xpath and CSS
//        jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='Mobile']")));
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[class='level0 '][href*='mobile']")));

        //Add to cart
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']")));

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']")));
        sleepInSeconds(15);

        //Verify text
        String allText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(allText.contains("Samsung Galaxy was added to your shopping cart."));

        //Customer service
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Customer Service']")));
        sleepInSeconds(5);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@id='newsletter']")));
        jsExecutor.executeScript("arguments[0].setAttribute('value','aaaa@aaa.com');", driver.findElement(By.xpath("//input[@id='newsletter']")));

        //Subcribe
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Subscribe']")));
        sleepInSeconds(2);
        driver.switchTo().alert().accept();
        sleepInSeconds(10);
        driver.switchTo().defaultContent();

        //Verify text
        String allText2 = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(allText2.contains("Thank you for your subscription."));

    }

    @Test
    public void TC_01_Live_TechPanda_Call_Function() {
        //Exercise link:
        jsExecutor.executeScript("window.location='https://live.techpanda.org/';");

        explicitWait.until(ExpectedConditions.urlToBe("https://live.techpanda.org/"));
    }

        @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}