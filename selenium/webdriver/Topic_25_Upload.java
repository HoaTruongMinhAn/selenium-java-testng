package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_25_Upload {
    WebDriver driver;
    String uploadFolderPath, image1, image2, image3, image1Path, image2Path, image3Path;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        uploadFolderPath = System.getProperty("user.dir") + File.separator + "selenium-webdriver-java-testng" + File.separator + "uploadFiles" + File.separator;
        image1 = "111.png";
        image2 = "222.png";
        image3 = "333.png";
        image1Path = uploadFolderPath + image1;
        image2Path = uploadFolderPath + image2;
        image3Path = uploadFolderPath + image3;
        System.out.println(uploadFolderPath);
        System.out.println(image1Path);
        System.out.println(image2Path);
        System.out.println(image3Path);
    }

    @Test
    public void TC_01_Single_File() {
        //Exercise link: https://docs.google.com/document/d/1If4zUnKjRCy7L26G4mlN4YFKdOJnK71SM4JOenygXvs/edit?tab=t.0#heading=h.82u6gb6dgo9d
        //Step 01 - Truy cập vào trang: https://blueimp.github.io/jQuery-File-Upload/
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        sleepInSeconds(2);


        //Step 02 - Sử dụng phương thức sendKeys để upload file nhiều file cùng lúc chạy cho 2 trình duyệt (Firefox/ Chrome)
        //Upload 3 file:
        //Image01.png
        //Image02.png
        //Image03.png
        By uploadFileElement = By.xpath("//input[@type='file']");
        driver.findElement(uploadFileElement).sendKeys(image1Path);
        sleepInSeconds(2);

        driver.findElement(uploadFileElement).sendKeys(image2Path);
        sleepInSeconds(2);

        driver.findElement(uploadFileElement).sendKeys(image3Path);
        sleepInSeconds(2);

        //Step 03 - Kiểm tra file đã được load lên thành công
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + image3 + "']")).isDisplayed());

        //Step 04 - Click Start button để upload cho cả 3 file
        driver.findElement(By.xpath("//span[text()='Start upload']")).click();
        sleepInSeconds(3);

        //Step 05 - Sau khi upload thành công verify cả 3 file đã được upload
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + image3 + "']")).isDisplayed());
    }


    @Test
    public void TC_02_Multiple_File() {
        //Exercise link: https://docs.google.com/document/d/1If4zUnKjRCy7L26G4mlN4YFKdOJnK71SM4JOenygXvs/edit?tab=t.0#heading=h.82u6gb6dgo9d
        //Step 01 - Truy cập vào trang: https://blueimp.github.io/jQuery-File-Upload/
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        sleepInSeconds(2);


        //Step 02 - Sử dụng phương thức sendKeys để upload file nhiều file cùng lúc chạy cho 2 trình duyệt (Firefox/ Chrome)
        //Upload 3 file:
        //Image01.png
        //Image02.png
        //Image03.png
        By uploadFileElement = By.xpath("//input[@type='file']");
        driver.findElement(uploadFileElement).sendKeys(image1Path + "\n" + image2Path + "\n" + image3Path);
        sleepInSeconds(2);

        //Step 03 - Kiểm tra file đã được load lên thành công
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + image3 + "']")).isDisplayed());

        //Step 04 - Click Start button để upload cho cả 3 file
        driver.findElement(By.xpath("//span[text()='Start upload']")).click();
        sleepInSeconds(3);

        //Step 05 - Sau khi upload thành công verify cả 3 file đã được upload
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + image1 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + image2 + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + image3 + "']")).isDisplayed());
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