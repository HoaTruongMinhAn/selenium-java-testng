package webdriver;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;

public class Topic_19_Action_III {
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

    @Test
    public void TC_01_Drag_Drop_HTML4() {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.az90xdyo8cy
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/kendo-drag-drop/
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        sleepInSeconds(2);

        //Step 02 - Kéo hình tròn nhỏ vào hình tròn lớn
        WebElement smallCicle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement bigCicle = driver.findElement(By.cssSelector("div#droptarget"));
        actions.dragAndDrop(smallCicle, bigCicle).perform();
        sleepInSeconds(2);

        //Step 03 - Verify message đã thay đổi: You did great!
        Assert.assertEquals(bigCicle.getText(), "You did great!");

        //Step 04 - Verify background color của hình tròn lớn chuyển qua màu xanh da trời
        Assert.assertEquals(bigCicle.getAttribute("class"), "k-header painted");
    }

    @Test
    public void TC_02_Drag_Drop_HTML5_Using_Selenium_Not_Work() {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.vm4quyjsi4i
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/drag-drop-html5/
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        sleepInSeconds(2);

        //Step 02 - Sử dụng Javascript/ Jquery để kéo thả từ A qua B và ngược lại
        WebElement objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        WebElement objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"), "column-a");
        Assert.assertEquals(objectB.getAttribute("id"), "column-b");

        //Method 1: actions.dragAndDrop: not work
        actions.dragAndDrop(objectA, objectB).perform();
        sleepInSeconds(2);

        Assert.assertEquals(objectA.getAttribute("id"), "column-b");
        Assert.assertEquals(objectB.getAttribute("id"), "column-a");
    }

    @Test
    public void TC_03_Drag_Drop_HTML5_Using_JQuery() throws IOException {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.vm4quyjsi4i
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/drag-drop-html5/
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        sleepInSeconds(2);

        //If site not support jQuery --> inject jQuery library
//        String jQueryLibraries = getContentFile(projectPath + "\\selenium-webdriver-java-testng\\dragDrop\\jQueryLib.js");
//        jsExecutor.executeScript(jQueryLibraries);

        String jQueryDragDropContent = getContentFile(projectPath + "\\selenium-webdriver-java-testng\\dragDrop\\dragAndDrop.js");

        //Step 02 - Sử dụng Javascript/ Jquery để kéo thả từ A qua B và ngược lại
        WebElement objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        WebElement objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"), "column-a");
        Assert.assertEquals(objectB.getAttribute("id"), "column-b");

        //Method 2: jQuery
        //Drag A to B
        jsExecutor.executeScript(jQueryDragDropContent);
        sleepInSeconds(2);

        objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"), "column-b");
        Assert.assertEquals(objectB.getAttribute("id"), "column-a");

        //Drag A to B again
        jsExecutor.executeScript(jQueryDragDropContent);
        sleepInSeconds(2);

        objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        Assert.assertEquals(objectA.getAttribute("id"), "column-a");
        Assert.assertEquals(objectB.getAttribute("id"), "column-b");
    }

    @Test
    public void TC_04_Drag_Drop_HTML5_Using_Java_Robot() throws AWTException {
        //Note: this method is not stable

        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.vm4quyjsi4i
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/drag-drop-html5/
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        sleepInSeconds(2);

        WebElement objectA = driver.findElement(By.xpath("//header[text()='A']/parent::div"));
        WebElement objectB = driver.findElement(By.xpath("//header[text()='B']/parent::div"));

        //Drag A to B
        dragAndDropHTML5ByXpath("//header[text()='A']/parent::div","//header[text()='B']/parent::div");
        sleepInSeconds(2);
        Assert.assertEquals(objectA.getAttribute("id"), "column-b");
        Assert.assertEquals(objectB.getAttribute("id"), "column-a");

        //Drag A to B again
        dragAndDropHTML5ByXpath("//header[text()='B']/parent::div","//header[text()='A']/parent::div");
        sleepInSeconds(2);
        Assert.assertEquals(objectA.getAttribute("id"), "column-a");
        Assert.assertEquals(objectB.getAttribute("id"), "column-b");
    }


    @Test
    public void TC_05_Scroll_To_element() {
        //Step 01 - Truy cập vào trang: https://live.techpanda.org/index.php/about-magento-demo-store/
        driver.get("https://live.techpanda.org/index.php/about-magento-demo-store/");
        sleepInSeconds(2);

        actions.scrollToElement(driver.findElement(By.cssSelector("input#newsletter"))).perform();
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

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}