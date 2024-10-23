package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebBrowser_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //Exercise link: https://docs.google.com/document/d/1G0QsiVDI5KfhNGKxE6a03bhn6KpvgDh69BTx2ttCO94/edit?tab=t.0#heading=h.y83yxtzfkk64

    @Test
    public void TC_01_Page_URL() throws InterruptedException {
        driver.get("https://live.techpanda.org/");

//        WebElement myAccountFootLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        WebElement myAccountFootLink = driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']"));
        myAccountFootLink.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");

//        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        WebElement createAnAccountButton = driver.findElement(By.cssSelector("a[title='Create an Account']"));
        createAnAccountButton.click();
        sleepInSeconds(5);
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_Page_Title(){
        driver.get("https://live.techpanda.org/");

        WebElement myAccountFootLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountFootLink.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getTitle(),"Customer Login");

        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnAccountButton.click();
        sleepInSeconds(5);
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_03_Page_Navigation(){
        driver.get("https://live.techpanda.org/");

        WebElement myAccountFootLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountFootLink.click();
        sleepInSeconds(3);

        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnAccountButton.click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_04_Page_Source(){
        driver.get("https://live.techpanda.org/");

        WebElement myAccountFootLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountFootLink.click();
        sleepInSeconds(3);
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));


        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnAccountButton.click();
        sleepInSeconds(3);
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
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