package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Checkbox {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Telerik() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://demos.telerik.com/kendo-ui/checkbox/index
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");


        By dualCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By leatureCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input");
        By towbarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input");

        //Scroll the screen down
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        //Step 02 - Click vào checkbox: Dual-zone air conditioning
        if (!driver.findElement(dualCheckbox).isSelected()) {
            driver.findElement(dualCheckbox).click();
        }

        //Step 03 - Kiểm tra checkbox đó đã chọn
        //verify enable-disabled
        Assert.assertTrue(driver.findElement(dualCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(dualCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(leatureCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(leatureCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(towbarCheckbox).isEnabled());
        Assert.assertFalse(driver.findElement(towbarCheckbox).isSelected());

        //Step 04 - Sau khi checkbox đã được chọn - bỏ chọn nó và kiểm tra nó chưa được chọn
        if (driver.findElement(dualCheckbox).isSelected()) {
            driver.findElement(dualCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(dualCheckbox).isSelected());

        //Step 05 - Truy cập vào trang: https://demos.telerik.com/kendo-ui/radiobutton/index
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        //Step 06 - Click vào radio button:  2.0 Petrol, 147kW
        By i20Petrol147Radio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        Assert.assertTrue(driver.findElement(i20Petrol147Radio).isEnabled());
        driver.findElement(i20Petrol147Radio).click();

        //Step 07 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
        Assert.assertTrue(driver.findElement(i20Petrol147Radio).isSelected());

        if (driver.findElement(i20Petrol147Radio).isSelected()) {
            System.out.println("i20Petrol147Radio is selected");
        } else {
            System.out.println("i20Petrol147Radio is not selected");
            driver.findElement(i20Petrol147Radio).isSelected();
        }

        //

        //
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}