package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    WebDriver driver;

    @Test
    public void TC_01() {
        //AssertTrue
        Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());

        //AssertFalse
        Assert.assertFalse(driver.findElement(By.xpath("")).isEnabled());

        //AssertEqual
        Assert.assertEquals(driver.findElement(By.xpath("")).getText(),"Hello world!");
    }


}
