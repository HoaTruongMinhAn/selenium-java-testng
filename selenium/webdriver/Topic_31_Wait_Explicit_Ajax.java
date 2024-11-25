package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_31_Wait_Explicit_Ajax {
    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFolderPath, image1, image2, image3, image1Path, image2Path, image3Path;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        uploadFolderPath = System.getProperty("user.dir") + File.separator + "selenium-webdriver-java-testng" + File.separator + "uploadFiles" + File.separator;
        uploadFolderPath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
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
    public void TC_01_Calendar() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.i9z60kgd3csa
        //Step 01 - Truy cập vào trang: https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Step 02 - Wait cho "Date Time" được hiển thị (sử dụng: visibility)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendarContainer']")));
        By messageLabel = By.xpath("//legend[text()='Selected Dates:']/parent::fieldset//span[@class='label']");

        //Step 03 - In ra ngày đã chọn (Before AJAX call) -> hiện tại chưa chọn nên in ra = "No Selected Dates to display."
        //Note: wait until textToBe is more recommended than findElement.getText
        //        Assert.assertEquals(driver.findElement(messageLabel).getText(), "No Selected Dates to display.");
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(messageLabel, "No Selected Dates to display.")));

        //Step 04 - Chọn ngày hiện tại (VD: 22/08/2019) (hoặc 1 ngày bất kì tương ứng trong tháng/ năm hiện tại)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/a[text()='1']"))).click();

        //Step 05 - Wait cho đến khi "Ajax loading icon" không còn visible (sử dụng: invisibility)
        //Xpath: //div[@class='raDiv']
        //NOTE: Tip để bắt được loading icon (dùng Debug của Dev Tool)
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'RadCalendar1')]/div[@class='raDiv']"))));

        //Step 06 - Wait cho selected date = 22 được selected (sử dụng: visibility)
        //Xpath: //*[contains(@class,'rcSelected')]//a[text()='22']
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@class,'rcSelected')]//a[text()='1']"))).isDisplayed());

        //Step 07 - Verify ngày đã chọn bằng = Thursday, August 22, 2019
        //NOTE: Fix lỗi Stale Element Reference Exception - Understanding Common Errors | Selenium
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(messageLabel,"Friday, November 1, 2024")));
    }

    //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.i9z60kgd3csa
    @Test
    public void TC_02_Calendar_New_Tab() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.i9z60kgd3csa
        //Step 01 - Truy cập vào trang: https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        //Step 02 - Wait cho "Date Time" được hiển thị (sử dụng: visibility)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendarContainer']")));
        By messageLabel = By.xpath("//legend[text()='Selected Dates:']/parent::fieldset//span[@class='label']");

        //Step 03 - In ra ngày đã chọn (Before AJAX call) -> hiện tại chưa chọn nên in ra = "No Selected Dates to display."
        //Note: wait until textToBe is more recommended than findElement.getText
        //        Assert.assertEquals(driver.findElement(messageLabel).getText(), "No Selected Dates to display.");
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(messageLabel, "No Selected Dates to display.")));

        //Step 04 - Chọn ngày hiện tại (VD: 22/08/2019) (hoặc 1 ngày bất kì tương ứng trong tháng/ năm hiện tại)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/a[text()='1']"))).click();

        //Step 05 - Wait cho đến khi "Ajax loading icon" không còn visible (sử dụng: invisibility)
        //Xpath: //div[@class='raDiv']
        //NOTE: Tip để bắt được loading icon (dùng Debug của Dev Tool)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'RadCalendar1')]/div[@class='raDiv']")));

        String currentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.close();
        driver.switchTo().window(currentWindow);

        //Step 06 - Wait cho selected date = 22 được selected (sử dụng: visibility)
        //Xpath: //*[contains(@class,'rcSelected')]//a[text()='22']
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']/a[text()='1']")));

        //Step 07 - Verify ngày đã chọn bằng = Thursday, August 22, 2019
        //NOTE: Fix lỗi Stale Element Reference Exception - Understanding Common Errors | Selenium
        explicitWait.until(ExpectedConditions.textToBe(messageLabel,"Friday, November 1, 2024"));
    }

    @Test
    public void TC_03_GoFile() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.wv3r7afluol1
        //Step 01 - Open URL: https://gofile.io/?t=uploadFiles
        driver.get("https://gofile.io/?t=uploadFiles");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Step 02 - Upload các file và verify file đã được load lên thành công
        //Verify Loading completed
//        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']"))));

        //Step 03 - Click Upload
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Upload Files']"))).click();
        //Verify Loading completed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']"))));

        //Select 3 files
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='filesUploadInput']"))).sendKeys(image1Path + "\n" + image2Path + "\n" + image3Path);

        //Verify Loading completed
//        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']/following-sibling::span[text()='Get destination folder ...']"))));

        //Verify Upload completed
        List<WebElement> progressBars = explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'progress-bar bg-primary')]"),3));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(progressBars)));
        progressBars = driver.findElements(By.xpath("//div[contains(@class,'progress-bar bg-primary')]"));

        //Step 05 - Click vào Download link
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(string()) ='Download Link']/following-sibling::div/a[@class='ajaxLink']"))).click();

        //Step 06 - Chuyển qua Tab/ Window mới - kiểm tra có icon download và play hiển thị ở từng file
        //Verify Loading completed
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']"))));

        //Verify Download and Play button for each file
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + image1 +"']/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());

        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + image1 +"']/ancestor::div[contains(@class,'contentId')]//span[text()='Play']"))).isDisplayed());

        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + image2 +"']/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());

        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + image2 +"']/ancestor::div[contains(@class,'contentId')]//span[text()='Play']"))).isDisplayed());

        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + image3 +"']/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());

        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + image3 +"']/ancestor::div[contains(@class,'contentId')]//span[text()='Play']"))).isDisplayed());
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
