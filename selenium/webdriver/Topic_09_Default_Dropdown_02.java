package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Rode() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.85dnvumg7p9

        //Step 01 - Truy cập vào trang: https://www.rode.com/wheretobuy
        driver.get("https://rode.com/en/support/where-to-buy");

        //Step 02 - Kiểm tra dropdown không hỗ trợ thuộc tính multiple select
        Select country = new Select(driver.findElement(By.cssSelector("select[id='country']")));
        WebElement city = driver.findElement(By.cssSelector("input[id='map_search_query']"));
        Assert.assertFalse(country.isMultiple());

        //Step 03 - Chọn giá trị Vietnam trong dropdown và HO CHI MINH trong City textbox
        country.selectByVisibleText("Vietnam");
        city.sendKeys("HO CHI MINH");

        //Step 04 - Click Search button
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        //Step 05 - Verify có 16 Dealers
        List<WebElement> dealers = driver.findElements(By.cssSelector("h4[data-v-68217974][class='text-left']"));
        Assert.assertEquals(dealers.size(),16);

        //Step 06 - In ra console tất cả các Dealers name
        for (WebElement dealer : dealers) {
            System.out.println("Dealer name " + (dealers.indexOf(dealer)+1) + ": " + dealer.getText());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}