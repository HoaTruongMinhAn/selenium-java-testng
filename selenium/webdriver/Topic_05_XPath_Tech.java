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

public class Topic_05_XPath_Tech {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_Register_With_Empty_Data() {
        driver.get("https://automationfc.github.io/basic-form/");

        //Hello World! (Ignore Me) @04:45 PM
        driver.findElement(By.xpath("//span[text()=' (Ignore Me) ']"));
        driver.findElement(By.xpath("//span[text()=' @04:45 PM ']"));
        driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Ignore Me')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'@04:45 PM')]"));
        driver.findElement(By.xpath("//h5[contains(.,'@04:45 PM')]"));



    }

    @Test
    public void TC_02_Register_With_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hoa test001");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("123...456");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("123...456");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");

        //RegisterButton
        WebElement regisTerButton = driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']"));
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
    }

    @Test
    public void TC_03_Register_With_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hoa test001");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc1@abc.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");

        //RegisterButton
        WebElement regisTerButton = driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']"));
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");

    }

    @Test
    public void TC_04_Register_With_Password_Less_Than_6_Characters() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hoa test001");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");

        //RegisterButton
        WebElement regisTerButton = driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']"));
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_Register_With_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hoa test001");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123457");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");

        //RegisterButton
        WebElement regisTerButton = driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']"));
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_06_Register_With_Invalid_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");


        //Case 1: Phone less than 10 numbers
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hoa test001");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("012345678");

        //RegisterButton
        WebElement regisTerButton = driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']"));
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");

        //Case 2: Phone more than 11 numbers
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("012345678912");
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");

        //Case 3: Phone contain text
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0a23456789");
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập con số");

        //Case 4: Phone not start with valid number
        driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("11234567891");
        regisTerButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}