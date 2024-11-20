package webdriver;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_24_JavascriptExecutor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void TC_01_() {
        //Exercise link:
        driver.get("https://demo.nopcommerce.com/");

        //get domain
        System.out.println(jsExecutor.executeScript("return document.domain;"));

        //get web element
        WebElement searchTextBox = (WebElement) jsExecutor.executeScript("return document.querySelector('input#small-searchterms');");
        searchTextBox.sendKeys("aaaaaaaaaaa");

        //get list web element
        List<WebElement> elements = (List<WebElement>) jsExecutor.executeScript("return document.querySelectorAll('input');");
        for(WebElement element : elements) {
            System.out.println(element.getAttribute("id"));
        }

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}