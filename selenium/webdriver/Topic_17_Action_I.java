package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_I {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.vg4t8lch9n7c

    @Test
    public void TC_01_Hover_Tooltip() {
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/jquery-tooltip/
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        //Step 02 - Hover chuột vào textbox
        actions.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        sleepInSeconds(2);

        //Step 03 - Kiểm tra tooltip xuất hiện
        WebElement tooltip = driver.findElement(By.cssSelector("div.ui-tooltip-content"));
        Assert.assertTrue(tooltip.isDisplayed());
        Assert.assertEquals(tooltip.getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_Menu() {
        //Step 01 - Truy cập vào trang: http://www.myntra.com/
        driver.get("http://www.myntra.com/");

        //Step 02 - Hover chuột vào KIDS
        actions.moveToElement(driver.findElement(By.cssSelector("a[data-group='kids']"))).perform();
        sleepInSeconds(2);

        //Step 03 - Click chọn Home & Bath hoặc bất kì page nào
        actions.click(driver.findElement(By.xpath("//a[text()='Girls Clothing']/parent::li/following-sibling::li/a[text()='Value Packs']"))).perform();
        sleepInSeconds(2);

        //Step 04 - Verify đã chuyển page sau khi click thành công
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.myntra.com/kids-packs-?f=Gender%3Aboys%20girls%2Cgirls&plaEnabled=false");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Kids Packs ']")).isDisplayed());
    }

    @Test
    public void TC_03_Hover_Menu() {
        //Step 01 - Truy cập vào trang: https://www.fahasa.com/
        driver.get("https://www.fahasa.com/");

        //Step 02 - Hover chuột vào bất kì trang nào trên Menu (trái)
        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        sleepInSeconds(2);

        actions.moveToElement(driver.findElement(By.cssSelector("a[title='Sách Trong Nước']"))).perform();
        sleepInSeconds(2);

        //Step 03 - Kiểm tra các trang (sub-menu) xuất hiện khi hover thành công
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='fhs_menu_content fhs_column_left']//a[text()='Manga - Comic']")).isDisplayed());

        //Step 04 - Hover chuột vào bất kì trang nào trên Menu (trái)
        actions.moveToElement(driver.findElement(By.cssSelector("a[title='FOREIGN BOOKS']"))).perform();
        sleepInSeconds(2);

        //Step 05 - Kiểm tra các trang (sub-menu) xuất hiện khi hover thành công
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='fhs_menu_content fhs_column_left']//a[text()='Contemporary Fiction']")).isDisplayed());
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