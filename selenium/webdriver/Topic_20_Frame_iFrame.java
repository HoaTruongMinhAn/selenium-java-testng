package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
        yearDroplist.selectByVisibleText("Senior");


        //Step 03 - Click vào Login button


        //Step 04 - Không nhập dữ liệu click vào Login button tại form Login


        //Step 05 - Verify message lỗi được hiển thị
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