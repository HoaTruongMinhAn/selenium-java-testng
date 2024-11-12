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
import java.util.List;

public class Topic_21_Fixed_Popup {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Ngoaingu24h() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.cxu8yfk2vzn1
        //Step 01 - Truy cập vào trang: https://ngoaingu24h.vn/
        driver.get("https://ngoaingu24h.vn/");

        //Step 02 - Click vào Đăng nhập button
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        //Step 03 - Kiểm tra popup Đăng nhập hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div[role='dialog']")).isDisplayed());

        //Step 04 - Nhập thông tin vào username/ password = automationfc
        driver.findElement(By.cssSelector("input[autocomplete='username']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input[autocomplete='new-password']")).sendKeys("automationfc");

        //Step 05 - Click Đăng nhập button
        driver.findElement(By.xpath("//div[@class='auth-form']//button[text()='Đăng nhập']")).click();
        sleepInSeconds(1);

        //Step 06 - Verify message hiển thị: Tài khoản không tồn tại!
        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        //Step 07 - Đóng popup
        driver.findElement(By.cssSelector("svg[data-testid='CloseIcon']")).click();
        sleepInSeconds(2);

        //Step 08 - Kiểm tra popup Đăng nhập không hiển thị
        List<WebElement> popups = driver.findElements(By.cssSelector("div[role='dialog']"));
        Assert.assertEquals(popups.size(), 0);
    }

    @Test
    public void TC_02_Ngoaingu24h() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.xfcxsgv3vxfe
        //Step 01 - Truy cập vào trang: https://skills.kynaenglish.vn/dang-nhap
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        sleepInSeconds(2);

        //Step 02 - Kiểm tra popup Login hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div.k-popup-account-mb-content")).isDisplayed());

        //Step 03 - Nhập thông tin vào form
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");

        //Step 04 - Click Đăng nhập button
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSeconds(2);

        //Step 05 - Verify message hiển thị
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");
    }

    //Bai 3,4


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