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
    public void TC_01_Find_Locator() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Tìm khóa học

        //non-XPath
        driver.findElement(By.id("txtFirstname"));

        //driver.findElement(By.className("btn_pink_sm fs16")); //not work because Selenium not support class name with space
        //driver.findElement(By.className("text form-control")); //not work because Selenium not support class name with space
        driver.findElement(By.className("btn_face")); //work

        driver.findElement(By.name("txtFirstname"));

//        driver.findElement(By.linkText("https://alada.vn/chinh-sach-bao-mat.html")); //not work because it get the visual text, not URL. link text as you see it with your eyes on the website (after all CSS is applied).
        driver.findElement(By.linkText("chính sách")); //work
        driver.findElement(By.partialLinkText("chính"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.cssSelector("input[id='txtFirstname']"));

        //XPath
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