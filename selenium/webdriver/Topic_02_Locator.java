package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Tìm khóa học
        driver.findElement(By.xpath("//input[@id='txtSearch']"));

        //Đăng ký
        driver.findElement(By.xpath("//a[@class='btn-anis-effect'][@href='https://alada.vn/tai-khoan/dang-ky.html']"));

        //Đăng nhập
        driver.findElement(By.xpath("//a[@href='https://alada.vn/tai-khoan/dang-nhap.html']"));

        //Họ và tên
        driver.findElement(By.xpath("//*[@id='txtFirstname']"));

        //Địa chỉ Email
        driver.findElement(By.xpath("//*[@id='txtEmail']"));

        //Nhập lại Email
        driver.findElement(By.xpath("//*[@id='txtCEmail']"));

        //Mật khẩu
        driver.findElement(By.xpath("//*[@id='txtPassword']"));

        //Nhập lại Mật khẩu
        driver.findElement(By.xpath("//*[@id='txtCPassword']"));

        //Điện thoại
        driver.findElement(By.xpath("//*[@id='txtPhone']"));

        //Tôi đồng ý
        driver.findElement(By.xpath("//*[@id='chkRight']"));

        //ĐĂNG KÝ
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16'][text()='ĐĂNG KÝ']"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}