package webdriver;


import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_33_Wait_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;
    //T: data type
    FluentWait<WebDriver> driverFluentWait;
    FluentWait<WebElement> elementFluentWait;
    FluentWait<String> stringFluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void TC_01_Dynamic_Loading_01() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.7x0a584f2g4u
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Click the Start button
        findElement(10, 100, By.xpath("//button[text()='Start']")).click();

        //Step 03 - Apply fluent wait để mỗi 0.1s kiểm tra 1 lần xem Hello World text đã được hiển thị hay chưa
        Assert.assertEquals(getElementText(By.xpath("//div[@id='finish']/h4")), "Hello World!");
    }

    @Test
    public void TC_01_Dynamic_Loading_02() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.7x0a584f2g4u
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/dynamic-loading/
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Step 02 - Click the Start button
        findElement(10, 100, By.xpath("//button[text()='Start']")).click();

        //Step 03 - Apply fluent wait để mỗi 0.1s kiểm tra 1 lần xem Hello World text đã được hiển thị hay chưa
        isElementDisplayed(By.xpath("//div[@id='finish']/h4[text()='Hello World!']"));
    }

    @Test
    public void TC_02_CountDown() {
        //Exercise link: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.bkfqhz7g35a2
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/fluent-wait/
        driver.get("https://automationfc.github.io/fluent-wait/");

        //Step 02 - Wait cho đến khi countdown time được visible (visibility)
        WebElement timeLabel = findElement(30,100,By.xpath("//div[@id='javascript_countdown_time']"));

        //Step 03 - Sử dụng Fluent wait để:
        //Mỗi 1/10 s kiểm tra countdount= 00 được xuất hiện trên page hay chưa (giây đếm ngược về 00)
        //Tức là trong vòng 15s (tổng thời gian) - cứ mỗi 1/10 giây kiểm tra xem nó đã đếm ngược về giây 00 hay chưa
        //Nếu như thỏa mãn điều kiện là về tới số 00 rồi thì ko cần phải chờ hết timeout (tổng time = 15s)
        Assert.assertTrue(isSecondMatching(timeLabel));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    /*Find element with specific timeout and polling
    Condition is findElement: return of Apply
    findElement requires WebDriver: parameter of Apply
     */
    public WebElement findElement(long timeout, long polling, By by) {
        driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofMillis(polling)).ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }

    /*Check element is displayed
    isDisplayed: return boolean
     */
    public boolean isElementDisplayed(By by) {
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    public boolean isElementDisplayed(WebElement element) {
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                return webElement.isDisplayed();
            }
        });
    }

    /*Get text of element
    return String
     */
    public String getElementText(By by) {
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }

    /*Verify seconds end with a specific value
    return boolean
 */
    public boolean isSecondMatching(WebElement element) {
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);
        driverFluentWait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(100));

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                System.out.println(webElement.getText());
                return webElement.getText().endsWith("00");
            }
        });
    }
}