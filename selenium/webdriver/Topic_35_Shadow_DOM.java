package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_35_Shadow_DOM {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Automationfc() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.htj7hp41i68z
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/shadow-dom
        driver.get("https://automationfc.github.io/shadow-dom");
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='scroll.html']"))).isDisplayed());

        //Step 02 - Verify các text được hiển thị và checkbox chưa được select
        //some text
        WebElement shadowHost = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        Assert.assertEquals(shadowRoot.findElement(By.cssSelector("span.info")).getText(), "some text");

        //nested text
        WebElement shadowHost2 = shadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
        Assert.assertEquals(shadowRoot2.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(), "nested text");

        //nested scroll.html
        Assert.assertEquals(shadowRoot.findElement(By.cssSelector("a[href='scroll.html']")).getText(), "nested scroll.html");
        Assert.assertTrue(shadowRoot.findElement(By.cssSelector("input[type='text']")).isDisplayed());
        Assert.assertTrue(shadowRoot.findElement(By.cssSelector("input[type='checkbox']")).isDisplayed());
        Assert.assertFalse(shadowRoot.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
        Assert.assertTrue(shadowRoot.findElement(By.cssSelector("input[type='file']")).isDisplayed());

        //scroll.html
        Assert.assertEquals(driver.findElement(By.xpath("//a[@href='scroll.html']")).getText(), "scroll.html");

        //While in a child shadow root, we can find element of parent shadow root and parent DOM normally, not need to switch
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='scroll.html']"))).isDisplayed());
        Assert.assertEquals(shadowRoot.findElement(By.cssSelector("span.info")).getText(), "some text");
    }

    @Test
    public void TC_02_Books_Pwakit() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.u6kg46gmbr14
        //Step 01 - Truy cập vào trang: https://books-pwakit.appspot.com/
        driver.get("https://books-pwakit.appspot.com/");
        sleepInSeconds(2);

        //Step 02 - Nhập dữ liệu vào Search textbox: Harry Potter
        SearchContext shadowRoot1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        shadowRoot1.findElement(By.cssSelector("book-input-decorator>input[aria-label='Search Books']")).sendKeys("Harry Potter");

        //Step 03 - Click Search icon
        shadowRoot1.findElement(By.cssSelector("book-input-decorator>input[aria-label='Search Books']")).sendKeys(Keys.ENTER);
        sleepInSeconds(2);

        //Step 04 - Verify sản phẩm đầu tiên với title được hiển thị
        shadowRoot1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        SearchContext shadowRoot2 = shadowRoot1.findElement(By.cssSelector("book-explore")).getShadowRoot();
        SearchContext shadowRoot3 = shadowRoot2.findElement(By.cssSelector("book-item")).getShadowRoot();
        Assert.assertEquals(shadowRoot3.findElement(By.cssSelector("h2.title")).getText(), "The Psychology of Harry Potter");
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