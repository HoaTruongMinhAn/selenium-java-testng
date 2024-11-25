package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_010_Bypass_Cloudfare_Profile {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        /*Step to create profile
        1 - Tạo 1 profile mới ở Chrome/ Edge Chromium

        2 - Mở app lên và accept CloudFlare

        3 - Lấy đường dẫn của profile
        chrome://version/
        edge://version/

        C:\Users\daomi\AppData\Local\Google\Chrome\User Data\Profile 4
        C:\Users\daomi\AppData\Local\Microsoft\Edge\User Data\Profile 1

        4 - Code để init Browser

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:/Users/daomi/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("--profile-directory=Profile 4");
        driver = new ChromeDriver(chromeOptions);

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/daomi/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 1");
        driver = new EdgeDriver(edgeOptions);

        5 - Error
        SessionNotCreatedException: Could not start a new session. Response code 500.
        Message: session not created: Chrome failed to start: exited normally.
        Solution: close all windows of that browser before running
        */

        // Prepare profile
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:\\Users\\anhoa\\AppData\\Local\\Microsoft\\Edge\\User Data\\");
        edgeOptions.addArguments("--profile-directory=Profile 1");
        driver = new EdgeDriver(edgeOptions);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Bypass_Cloudfare_Capcha() {
        //Step 01: Open URL
        driver.get("https://admin-demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Step 02 - Login với dữ liệu hợp lệ sau đó click vào button Login
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']"))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']"))).sendKeys("admin@yourstore.com");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']"))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']"))).sendKeys("admin");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'login-button')]"))).click();

        //Step 03 - Wait cho page được load success - có thể dùng 2 cách
        //1 - Wait cho page load complete/ page ready
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxBusy']/span"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='ajaxBusy']/span"))));

        //Step 04 - Click vào button Logout
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();

        //Step 05 - Verify chuyển về trang Login thành công
        explicitWait.until(ExpectedConditions.titleIs("Your store. Login"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
