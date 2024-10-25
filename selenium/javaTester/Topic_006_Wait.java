package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_006_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Fluent Wait
        fluentWait = new FluentWait<WebDriver>(driver);
    }


    @Test
    public void TC_01_If_Else() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[id='speed-button']>span[class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")));
    }

}
