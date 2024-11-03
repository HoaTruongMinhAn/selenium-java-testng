package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_II {
    WebDriver driver;
    Actions actions;
    Keys controlKey;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        //Windows uses CONTROL key, Mac uses COMMAND key
        String osName = System.getProperty("os.name");
/*        if (osName.contains("Windows")) {
            controlKey = Keys.CONTROL;
        }
        else{
            controlKey = Keys.COMMAND;
        }*/

        //Ternary Operator
        controlKey = (osName.startsWith("Windows")) ? Keys.CONTROL : Keys.COMMAND;
        System.out.println("beforeClass controlKey is: " + controlKey.name());

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    public void TC_01_Click_And_Hold_Block() {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.bkl0f42t149z
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/jquery-selectable/
        driver.get("https://automationfc.github.io/jquery-selectable/");
        sleepInSeconds(2);

        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(numbers.size(), 20);

        //Step 02 - Click and hold từ 1-> 4
        actions.clickAndHold(driver.findElement(By.xpath("//li[text()='1']"))).perform();
        actions.release(driver.findElement(By.xpath("//li[text()='4']"))).perform();
        sleepInSeconds(2);

        //Step 03 - Sau khi chọn - kiểm tra có đúng 4 phần tử đã được chọn thành công
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='1']")).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='2']")).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='3']")).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='4']")).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(driver.findElement(By.xpath("//li[text()='5']")).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(driver.findElement(By.xpath("//li[text()='6']")).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(driver.findElement(By.xpath("//li[text()='7']")).getAttribute("class").contains("ui-selected"));
        Assert.assertFalse(driver.findElement(By.xpath("//li[text()='8']")).getAttribute("class").contains("ui-selected"));

        List<WebElement> selectedNumbers = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(selectedNumbers.size(), 4);

        List<WebElement> unselectedNumbers = driver.findElements(By.cssSelector("ol#selectable>li:not([class*=selected])"));
        Assert.assertEquals(unselectedNumbers.size(), 16);
    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.pl005x2u0ucf
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/jquery-selectable/
        driver.get("https://automationfc.github.io/jquery-selectable/");
        sleepInSeconds(2);


        //Step 02 - Click and select random item: 1 - 3 - 6 - 11
        System.out.println("TC_02_Click_And_Hold_Random controlKey is: " + controlKey.name());
        actions.keyDown(controlKey).perform();
        actions.click(driver.findElement(By.xpath("//li[text()='1']"))).perform();
        actions.click(driver.findElement(By.xpath("//li[text()='3']"))).perform();
        actions.click(driver.findElement(By.xpath("//li[text()='6']"))).perform();
        actions.click(driver.findElement(By.xpath("//li[text()='11']"))).perform();
        actions.keyUp(controlKey).perform();
        sleepInSeconds(2);

        //Step 03 - Sau khi chọn kiểm tra rằng có đúng 4 phần tử đã được chọn thành công với xpath:
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='1']")).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='3']")).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='6']")).getAttribute("class").contains("ui-selected"));
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='11']")).getAttribute("class").contains("ui-selected"));

        List<WebElement> selectedNumbers = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(selectedNumbers.size(), 4);

        List<WebElement> unselectedNumbers = driver.findElements(By.cssSelector("ol#selectable>li:not([class*=selected])"));
        Assert.assertEquals(unselectedNumbers.size(), 16);
    }

    @Test
    public void TC_03_Double_Click_With_Scroll_By_Sendkey() {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.70rryflvu52b
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(2);

        //Scroll the screen down
        //Move method 1: sendkey: work
        WebElement doubleClickButton = driver.findElement(By.cssSelector("button[ondblclick=\"doubleClickMe()\"]"));
        doubleClickButton.sendKeys("aaa");
        sleepInSeconds(2);

        //Step 02 - Double click vào button: Double click me
        actions.doubleClick(doubleClickButton).perform();
        sleepInSeconds(2);

        //Step 03 - Verify text trong được hiển thị bên dưới: Hello Automation Guys!
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }


    @Test
    public void TC_04_Double_Click_With_Scroll_By_Javascript() {
        //Exercise link: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.70rryflvu52b
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(2);

        //Scroll the screen down
        //Move method 2: javascript: work
        WebElement doubleClickButton = driver.findElement(By.cssSelector("button[ondblclick=\"doubleClickMe()\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", doubleClickButton);
        sleepInSeconds(2);

        //Step 02 - Double click vào button: Double click me
        actions.doubleClick(doubleClickButton).perform();
        sleepInSeconds(2);

        //Step 03 - Verify text trong được hiển thị bên dưới: Hello Automation Guys!
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
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