package webdriver;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Random;

public class Topic_08_Textbox_Textarea {
    WebDriver driver;
    Random rand;
    String firstName, lastName, email, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Textbox_Textarea() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.kahqnrvcqvkn

        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("https://live.techpanda.org/");

        //Step 02 - Click vào link "My Account" để tới trang đăng nhập
        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        //Step 03 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInSeconds(2);

        //Step 04 - Nhập thông tin hợp lệ vào tất cả các field: First Name/ Last Name/ Email Address/ Password/ Confirm Password

        //Random method 1, works well
        /*rand = new Random();
        int randomNumber = rand.nextInt(999999);
        firstName = "testFN" + randomNumber;
        lastName = "testLN" + randomNumber;
        email = "testEmail" + randomNumber + "@aaa.com";
        password = "testPassword@" + randomNumber;*/

        //Random method 2, works well
        long currentTime = new Timestamp(System.currentTimeMillis()).getTime();

        firstName = "testFN" + currentTime;
        lastName = "testLN" + currentTime;
        email = "testEmail" + currentTime + "@aaa.com";
        password = "testPassword@" + currentTime;

        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[id='email_address']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='confirmation']")).sendKeys(password);

        //Step 05 - Click REGISTER button
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        sleepInSeconds(2);

        //Handle browser alert: click Continue
        Alert alert = driver.switchTo().alert();
        alert.accept();
        sleepInSeconds(5);

        //Step 06 - Verify message xuất hiện khi đăng kí thành công: Thank you for registering with Main Website Store.
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());

        //Step 07 - Verify User được tạo mới với thông tin: Firstname/ Lastname/ Email hiển thị ở trang My Dashboard
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(string(),'" + firstName + "') and contains(string(),'" + lastName + "') and contains(string(),'" + email +"')]")).isDisplayed());
        System.out.println("//p[contains(string(),'" + firstName + "') and contains(string(),'" + lastName + "') and contains(string(),'" + email +"')]");


        //Step 08 - Chuyển qua tab Mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();


        //Step 09 - Bấm chọn sản phẩm Samsung Galaxy
        driver.findElement(By.cssSelector("a[class='product-image'][title='Samsung Galaxy']")).click();

        //Step 10 - Chọn Add Your Review
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        //Step 11 - Điền thông tin hợp lệ vào các field và Submit
        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea[id='review_field']")).sendKeys("Review aaa\n111\n222\n333");
        driver.findElement(By.cssSelector("input[id='summary_field']")).sendKeys("Summary bbb");
//        driver.findElement(By.cssSelector("input[id='nickname_field']")).sendKeys("Nickname ccc");
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        //Handle browser alert: click Continue
        alert = driver.switchTo().alert();
        alert.accept();
        sleepInSeconds(5);

        //Step 11 - Verify message xuất hiện Your review has been accepted for moderation.
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Your review has been accepted for moderation.']")).isDisplayed());

        //Step 12 - Logout khỏi hệ thống
        driver.findElement(By.cssSelector("a[data-target-element='#header-account']")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSeconds(10);


        //Step 13 - Kiểm tra hệ thống navigate về Home page sau khi logout thành công
        driver.findElement(By.cssSelector("a[data-target-element='#header-account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/");
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log In']")).isDisplayed());

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}