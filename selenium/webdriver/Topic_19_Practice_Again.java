package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
//import java.time.Duration;
//
public class Topic_19_Practice_Again {
    WebDriver driver;
    Actions actions;
    Keys controlKey;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        jsExecutor = (JavascriptExecutor) driver;
    }

    //Exercise link:

    @Test
    public void TC_03_Drag_Drop_HTML5_Using_JQuery() throws IOException {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.vm4quyjsi4i
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/drag-drop-html5/
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        sleepInSeconds(2);
        String jQueryDragDropContent = getContentFile(projectPath + "\\selenium-webdriver-java-testng\\dragDrop\\dragAndDrop.js");

        //Step 02 - Sử dụng Javascript/ Jquery để kéo thả từ A qua B và ngược lại
        WebElement objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        WebElement objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"),"column-a");
        Assert.assertEquals(objectB.getAttribute("id"),"column-b");

        //Method 2: jQuery
        //Drag A to B
        jsExecutor.executeScript(jQueryDragDropContent);
        sleepInSeconds(2);

        objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"),"column-b");
        Assert.assertEquals(objectB.getAttribute("id"),"column-a");

        //Drag A to B again
        jsExecutor.executeScript(jQueryDragDropContent);
        sleepInSeconds(2);

        objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"),"column-a");
        Assert.assertEquals(objectB.getAttribute("id"),"column-b");
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

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
}