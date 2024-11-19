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

public class Topic_22_Random_Popup {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Javacodegeeks() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.5sdo9ld5o5gm
        //Step 01 - Truy cập vào trang:  https://www.javacodegeeks.com/
        driver.get("https://www.javacodegeeks.com/");
        sleepInSeconds(2);

        //Step 02 - Kiểm tra popup trong 2 trường hợp
        //Có xuất hiện
        //Close popup đi
        //Không xuất hiện - chuyển qua step 03 (Element của popup không còn trong DOM)
        List<WebElement> popups = driver.findElements(By.cssSelector("div.lepopup-popup-container>div:not([style*='display:none'])"));

        if (popups.size() > 0 && popups.get(0).isDisplayed()) {
            System.out.println("----------RUN THE IF------------");
            driver.findElement(By.cssSelector("a[onclick*='lepopup_close()']")).click();
            sleepInSeconds(2);
        }

        //Step 03 - Nhập dữ liệu vào Search textbox với từ khóa Agile Testing Explained
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSeconds(2);

        //Step 04 - Kiểm tra bài viết đầu tiên xuất hiện chứa từ khóa Agile Testing Explained
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }

    @Test
    public void TC_02_VNK() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.ycdwtgz2ixyz
        //Step 01 - Truy cập vào trang:  https://vnk.edu.vn/
        driver.get("https://vnk.edu.vn/");
        sleepInSeconds(2);

        //Step 02 - Kiểm tra popup trong 2 trường hợp
        //Có xuất hiện - đóng popup đi - chuyển qua step 03
        //Không xuất hiện - chuyển qua step 03 (Element của popup vẫn còn trong DOM)
        List<WebElement> popups = driver.findElements(By.cssSelector("div.pum-container"));

        if(popups.size()>0 && popups.get(0).isDisplayed()){
            System.out.println("----------RUN THE IF------------");
            driver.findElement(By.cssSelector("button.pum-close")).click();
            sleepInSeconds(2);
        }

        //Step 03: Action
        driver.findElement(By.xpath("//a[@class='mega-menu-link' and text()='Liên hệ']")).click();
        sleepInSeconds(5);
        Assert.assertTrue(driver.findElement(By.cssSelector("span#Co_so_3")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("span#Co_so_3")).isDisplayed());
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