package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_06_WebBrowser_Commands_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_() throws MalformedURLException {
        driver.get("https://automationfc.github.io/basic-form/");

        System.out.println("--------------driver property");
        System.out.println("getCurrentUrl: " + driver.getCurrentUrl());
        System.out.println("getTitle: " + driver.getTitle());
        System.out.println("getWindowHandle: " + driver.getWindowHandle());
        System.out.println("getWindowHandles: " + driver.getWindowHandles());
        System.out.println("getClass: " + driver.getClass());
//        System.out.println("getPageSource: " + driver.getPageSource());

        Assert.assertEquals(driver.getCurrentUrl(),"https://automationfc.github.io/basic-form/");
        Assert.assertEquals(driver.getTitle(),"Selenium WebDriver");
        Assert.assertTrue(driver.getPageSource().contains("Many of the estimates are acknowledged to be rough and out of date, as follows:"));
        Assert.assertFalse(driver.getPageSource().contains("Xin chào mọi người"));

        WebElement under18RadioButton =  driver.findElement(By.xpath("//label[text()='Under 18']"));
        Assert.assertTrue(under18RadioButton.isDisplayed());
        Assert.assertTrue(under18RadioButton.isEnabled());
        Assert.assertFalse(under18RadioButton.isSelected());
        System.out.println("--------------element property");
        System.out.println("getText: " + under18RadioButton.getText());
        System.out.println("getDomAttribute: " + under18RadioButton.getDomAttribute("class"));
        System.out.println("getTagName: " + under18RadioButton.getTagName());
        System.out.println("getAttribute: " + under18RadioButton.getAttribute("class"));
        System.out.println("getCssValue: " + under18RadioButton.getCssValue("font-family"));
        System.out.println("getLocation: " + under18RadioButton.getLocation());
        System.out.println("getRect: " + under18RadioButton.getRect());
        System.out.println("getSize: " + under18RadioButton.getSize());

        Assert.assertEquals(under18RadioButton.getText(),"Under 18");
        Assert.assertEquals(under18RadioButton.getDomAttribute("class"),"light");
        Assert.assertEquals(under18RadioButton.getTagName(),"label");
        Assert.assertEquals(under18RadioButton.getAttribute("class"),"light");
        Assert.assertEquals(under18RadioButton.getCssValue("font-family"),"\"Nunito\", sans-serif");
        Assert.assertEquals(under18RadioButton.getLocation(),new Point(44, 1524));
        Assert.assertEquals(under18RadioButton.getText(),"Under 18");


        //Get log from DEV tool
//        driver.manage().logs().get(LogType.DRIVER);

        //Window size
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();

        //Test responsive with specific size and position
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setSize(new Dimension(600, 800));
        System.out.println("Driver getSize: " + driver.manage().window().getSize());
        Assert.assertEquals(driver.manage().window().getSize(),new Dimension(600, 800));

        driver.manage().window().setPosition(new Point(100,200));
        System.out.println("Driver getPosition: " + driver.manage().window().getPosition());
        Assert.assertEquals(driver.manage().window().getPosition(),new Point(100,200));


        //Navigate
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        //Often use to work with browser history
        driver.navigate().to("https://automationfc.github.io/jquery-tooltip/");
        driver.navigate().to(new URL("https://automationfc.github.io/jquery-tooltip/"));

        //Alert, window (tab), frame (iframe)
        driver.switchTo().alert();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("test");
        driver.switchTo().alert().getText();

        //Handle window, tab
        String currentWindowID = driver.getWindowHandle();
        driver.switchTo().window(currentWindowID);


        //Handle frame, iframe
        driver.switchTo().frame(1);
        driver.switchTo().frame("123456");
        driver.switchTo().frame(driver.findElement(By.id("")));

        //Switch to the previous frame
        driver.switchTo().defaultContent();

        //Switch to the previous frame
        driver.switchTo().parentFrame();

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}