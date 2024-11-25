package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_34_Wait_Page_Ready {
    WebDriver driver;
    WebDriverWait explicitWait;
    Cookie cloudflareCookie;

    @BeforeClass
    public void beforeClass() {
        cloudflareCookie = new Cookie("cf_clearance", "InWzDFwb_PBjO1gNkBdUj0qJi_dTvLkjupVPp3xFvLo-1732528192-1.2.1.1-OcrWkltone01H8FQ7sG9dBjlJaB3N.iq5x7HSRRiy3OxH9LTLkg8G3iYFYyZZ12UeiVJyJN49IHc64cb5YGHKxRlwlYtb832SXS5pCJ_k1YFV878t9xocInDkrS79W4eajA9z5x2u4XtTv.c6HDfWFyFO25l4QNpgEWWns4Qa_LxbCgqMV2EiEWG1_TDcsIK2baLJMUf3IdBIQZaGJ6LGlQ7VCokHjOr8FtD_Y5oWWVE6BpVOly7MU0GBhw0Gy9ec9sL8sodpmropRxt3NnnfMeYAxJNqjHM.busa8qlIrbevyzf7czd4PEWoNRjUig7deYukYf_ntgWtYsHmfhJfg");
    }

    @Test
    public void TC_01_Page_Ready_01() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.xoe64s2flshl
        //Step 01 - Truy cập vào trang: https://admin-demo.nopcommerce.com
        // Set pre-saved cookies after manually completing Cloudflare validation
        driver = new FirefoxDriver();
        driver.get("https://admin-demo.nopcommerce.com");
        driver.manage().addCookie(cloudflareCookie);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().refresh();

        //Step 02 - Login với dữ liệu hợp lệ sau đó click vào button Login
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']"))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']"))).sendKeys("admin@yourstore.com");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']"))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']"))).sendKeys("admin");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'login-button')]"))).click();

        //Step 03 - Wait cho page được load success - có thể dùng 2 cách
        //1 - Wait cho page load complete/ page ready
        Assert.assertTrue(isPageLoadedSuccess());

        //2 - Wait cho ajax busy icon loading invisible


        //Step 04 - Click vào button Logout
//        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();

        //Step 05 - Verify chuyển về trang Login thành công
//        explicitWait.until(ExpectedConditions.titleIs("Your store. Login"));
    }

    @Test
    public void TC_01_Page_Ready_02() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.xoe64s2flshl
        //Step 01 - Truy cập vào trang: https://admin-demo.nopcommerce.com
        // Set pre-saved cookies after manually completing Cloudflare validation
        driver = new FirefoxDriver();
        driver.get("https://admin-demo.nopcommerce.com");
        driver.manage().addCookie(cloudflareCookie);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().refresh();

        //Step 02 - Login với dữ liệu hợp lệ sau đó click vào button Login
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']"))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']"))).sendKeys("admin@yourstore.com");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']"))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']"))).sendKeys("admin");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'login-button')]"))).click();

        //Step 03 - Wait cho page được load success - có thể dùng 2 cách
        //1 - Wait cho page load complete/ page ready
        //2 - Wait cho ajax busy icon loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxBusy']/span"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='ajaxBusy']/span"))));

        //Step 04 - Click vào button Logout
//        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();

        //Step 05 - Verify chuyển về trang Login thành công
//        explicitWait.until(ExpectedConditions.titleIs("Your store. Login"));
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }
}