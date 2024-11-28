package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Topic_10_Loop {
    WebDriver driver;
    Random rand;
    String firstName, lastName, email, password;
    Properties props = new Properties();
    ;
    String projectPath = System.getProperty("user.dir");
    FileOutputStream outputStream;

    @BeforeClass
    public void beforeClass() throws FileNotFoundException {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        String path = projectPath + "\\dataTest\\user.properties";
        outputStream = new FileOutputStream(path);
    }


    @Test(invocationCount = 3)
    public void TC_01_Textbox_Textarea() throws IOException {
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

//        props.put("firstName",firstName);
//        props.put("lastName",lastName);
//        props.put("email",email);
//        props.put("password",password);

        props.setProperty("firstName", firstName);
        props.setProperty("lastName", lastName);
        props.setProperty("email", email);
        props.setProperty("password", password);
        props.store(outputStream, null);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
