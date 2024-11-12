package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Frame_iFrame {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_iFrame_FormSite() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.u9d7e2n9y9ka
        //Step 01 - Truy cập vào trang: https://www.formsite.com/templates/education/campus-safety-survey/
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        sleepInSeconds(2);

        //Step 02 - Nhập dữ liệu vào 3 field: Year/ Residence/ Gender và nhấn Submit
        driver.findElement(By.cssSelector("img[title='Campus-Safety-Survey-Forms-and-Examples']")).click();
        sleepInSeconds(2);

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='frame-one85593366']")));

        Select yearDroplist = new Select(driver.findElement(By.xpath("//label[contains(text(),'Year')]/following-sibling::select")));
        Select residenceDroplist = new Select(driver.findElement(By.xpath("//label[contains(text(),'Residence')]/following-sibling::select")));
        WebElement femaleRadio = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));

        yearDroplist.selectByVisibleText("Senior");
        residenceDroplist.selectByVisibleText("Off Campus");
        femaleRadio.click();
        driver.findElement(By.cssSelector("input#FSsubmit")).sendKeys(Keys.TAB);
        driver.findElement(By.cssSelector("input#FSsubmit")).click();
        sleepInSeconds(2);

        //Step 03 - Click vào Login button
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a[title=\"Log in\"][class*=fs-btn--transparent-white]")).sendKeys(Keys.TAB);
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("a[title=\"Log in\"][class*=fs-btn--transparent-white]")).click();
        sleepInSeconds(2);

        //Step 04 - Không nhập dữ liệu click vào Login button tại form Login
        driver.findElement(By.cssSelector("button#login")).sendKeys(Keys.TAB);
        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSeconds(2);

        //Step 05 - Verify message lỗi được hiển thị
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");

        /*//Page A --> iframe B --> iframe C --> iframe D
        driver.switchTo().frame("B");//switch to B
        driver.switchTo().frame("C");//switch to C
        driver.switchTo().frame("D");//switch to D

        driver.switchTo().parentFrame();//back to C
        driver.switchTo().parentFrame();//back to B
        driver.switchTo().defaultContent();//back to A*/
    }

    @Test
    public void TC_02_iFrame_Toidicodedao() {
        driver.get("https://toidicodedao.com/");
        sleepInSeconds(2);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div[class='fb-page fb_iframe_widget'] iframe")));

        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"_1drq\"]")).getText().contains("followers"));
    }

    @Test
    public void TC_03_Frame() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.848xm5r0r4ow
        //Step 01 - Truy cập vào trang: https://netbanking.hdfcbank.com/netbanking/
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        sleepInSeconds(2);

        //Step 02 - Input vào Customer ID và click  Continue
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name=\"login_page\"]")));
        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("aaaaa");
        driver.findElement(By.cssSelector("a[class='btn btn-primary login-btn']")).click();
        sleepInSeconds(2);

        //Step 03 - Verify Password textbox hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("input#fldPasswordDispId")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}