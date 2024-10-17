package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_XPath_Tech {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_XPath_With_Text() {
        driver.get("https://automationfc.github.io/basic-form/");

        //Hello World! (Ignore Me) @04:45 PM
        driver.findElement(By.xpath("//span[text()=' (Ignore Me) ']"));
        driver.findElement(By.xpath("//span[text()=' @04:45 PM ']"));
        driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Ignore Me')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'@04:45 PM')]"));
        driver.findElement(By.xpath("//h5[contains(.,'@04:45 PM')]"));

        //Michael Jackson
        driver.findElement(By.xpath("//h5[contains(.,'@04:45 PM')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Michael Jackson')]"));
        driver.findElement(By.xpath("//h5[contains(.,'Michael Jackson')]"));


        //Mail Personal or Business Check, Cashier's Check or money order to:
        String xPath1 = """
                //p[contains(text(),"Mail Personal or Business Check, Cashier's Check or money order to:")]""";

        System.out.println(xPath1);
        driver.findElement(By.xpath(xPath1));

        driver.findElement(By.xpath("//p[contains(text(),'s Check or money order to:')]"));
//        driver.findElement(By.xpath("p[text()=concat(\"Mail Personal or Business Check, Cashier'\",\"s Check or money order to:\")]"));


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}