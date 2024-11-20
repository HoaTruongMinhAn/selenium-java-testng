package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Github() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.srfbst1tqv4y
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(2);
        String parentWindowID = driver.getWindowHandle();

        //Step 02 - Click "GOOGLE" link -> Switch qua tab mới
        driver.findElement(By.cssSelector("a[href='https://google.com.vn']")).click();
        sleepInSeconds(2);

        switchToNewWindow(parentWindowID);
        sleepInSeconds(2);
        String googleWindowID = driver.getWindowHandle();

        //Step 03 - Kiểm tra title của window mới = Google
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertTrue(driver.findElement(By.cssSelector("textarea[name='q']")).isDisplayed());
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("test a little");

        //Step 04 - Switch về parent window
        switchToNewWindow(googleWindowID);
        sleepInSeconds(2);
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");

        //Step 05 - Click "FACEBOOK" link -> Switch qua tab mới
        driver.findElement(By.cssSelector("a[href='https://facebook.com']")).click();
        sleepInSeconds(2);
        switchtoWindowByTitle("Facebook – log in or sign up");
        sleepInSeconds(2);

        //Step 06 - Kiểm tra title của window mới = Facebook - Đăng nhập hoặc đăng ký
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

        //Step 07 - Switch về parent window
        switchtoWindowByTitle("Selenium WebDriver");
        sleepInSeconds(2);

        //Step 08 - Click "TIKI" link -> Switch qua tab mới
        driver.findElement(By.cssSelector("a[href='https://tiki.vn']")).click();
        sleepInSeconds(2);
        switchtoWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
        sleepInSeconds(2);

        //Step 09 - Kiểm tra title của window mới = Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn
        Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");

        //Step 10 - Close tất cả cửa sổ/ tab ngoại trừ parent window
        closeTabExcept(parentWindowID);

        //Step 11 - Kiểm tra đã quay về parent window thành công (title/ url)
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");
    }

    @Test
    public void TC_02_Live_TechPanda() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.sls9dyusqa9s
        //Step 01 - Truy cập vào trang: http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");
        sleepInSeconds(2);
        String parentWindowID = driver.getWindowHandle();

        //Step 02 - Click vào Mobile tab
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(2);

        //Step 03 - Add sản phẩm Sony Xperia vào để Compare (Add to Compare)
        //Verify text hiển thị: The product Sony Xperia has been added to comparison list.
        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Sony Xperia has been added to comparison list.");

        //Step 04 - Add sản phẩm Samsung Galaxy vào để Compare (Add to Compare)
        //Verify text hiển thị: The product Samsung Galaxy has been added to comparison list.
        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        //Step 05 - Click to Compare button
        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSeconds(2);

        //Step 06 - Switch qa cửa sổ mới (chứa 2 sản phẩm đã được Add vào để Compare)
        switchToNewWindow(parentWindowID);
        sleepInSeconds(2);

        //Step 07 - Verify title của cửa sổ bằng: Products Comparison List - Magento Commerce
        Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");

        //Step 08 - Close tab và chuyển về Parent Window
        driver.close();
        sleepInSeconds(2);
        driver.switchTo().window(parentWindowID);
        sleepInSeconds(2);

        //Step 09 - Click ‘Clear All’ link và accept alert
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        sleepInSeconds(2);

        driver.switchTo().alert().accept();
        sleepInSeconds(5);

        //Step 10 - Verify message xuất hiện: The comparison list was cleared.
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The comparison list was cleared.");
    }

    @Test
    public void TC_03_Cambridge() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.1fnpoxpc63zo
        //Step 01 - Truy cập vào trang: https://dictionary.cambridge.org/vi/
        driver.get("https://dictionary.cambridge.org/vi/");
        sleepInSeconds(2);
        String parentWindowID = driver.getWindowHandle();

        //Step 02 - Click vào Đăng nhập link
        driver.findElement(By.xpath("//span[@on='tap:amp-access.login-sign-in']//span[text()='Đăng nhập']")).click();
        sleepInSeconds(2);

        //Step 03 - Switch qa cửa sổ mới
        switchToNewWindow(parentWindowID);
        sleepInSeconds(2);

        //Step 04 - Click Log in button
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        sleepInSeconds(2);

        //Step 05 - Verify message This field is required xuất hiện tại 2 field Email và Password
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(@class,'gigya-error-msg-active') and @data-bound-to='loginID']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(@class,'gigya-error-msg-active') and @data-bound-to='password']")).getText(),"This field is required");

        //Step 06 - Close cửa sổ Login đi và switch về trang trước đó
        driver.close();
        driver.switchTo().window(parentWindowID);
        sleepInSeconds(2);

        //Step 07 - Nhập từ khóa bất kì vào ô Search rồi click Search
        driver.findElement(By.xpath("//input[@id='searchword']")).sendKeys("learn");
        driver.findElement(By.xpath("//button[contains(@class,'search')]")).click();
        sleepInSeconds(2);

        //Step 08 - Verify trang Search chứa từ khóa mới tìm kiếm
        Assert.assertTrue(driver.findElement(By.xpath("//h2/b[@class='tb ttn']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//h2/b[@class='tb ttn']")).getText(),"learn");
    }

    @Test
    public void TC_04_Selenium_4x_Harvard() {
        //Exercise link: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.sik19sfcyku5
        //Step 01 - Truy cập vào trang: https://courses.dce.harvard.edu/
        driver.get("https://courses.dce.harvard.edu/");
        sleepInSeconds(2);
        String parentWindowID = driver.getWindowHandle();

        //Step 02 - Click vào Student Login
        driver.findElement(By.xpath("//a[@data-action='login']")).click();
        sleepInSeconds(2);

        //Step 03 - Switch qa cửa sổ mới
        switchToNewWindow(parentWindowID);
        sleepInSeconds(2);

        //Step 04 - Verify màn hình Login Portal hiển thị
        Assert.assertEquals(driver.getTitle(),"Harvard Division of Continuing Education Login Portal");

        //Step 05 - Close cửa sổ Login đi và switch về trang trước đó
        driver.close();
        driver.switchTo().window(parentWindowID);
        sleepInSeconds(2);

        //Step 06 - Verify màn hình "Authentication was not successful." hiển thị
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='sam-wait__message']")).getText(),"Authentication was not successful. Please try again.");

        //Step 07 - Close popup Authentication Login và nhập các thông tin hợp lệ vào ô Search Courses
        driver.findElement(By.xpath("//button[@class='fa fa-times sam-wait__close']")).click();
        driver.findElement(By.xpath("//input[@id='crit-keyword']")).sendKeys("vietnam");
        driver.findElement(By.xpath("//button[@id='search-button']")).click();
        sleepInSeconds(2);

        //Step 08 - Verify thông tin Course được hiển thị
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='panel__info-bar-text']")).getText(),"Found 1 course");
    }

    @Test
    public void TC_05_Selenium_4x_Live_Techpanda() {
        //Exercise link:
        //Step 01 - Truy cập vào trang: https://live.techpanda.org/
        driver.get("https://live.techpanda.org/");
        sleepInSeconds(2);
        String parentWindowID = driver.getWindowHandle();

        //New tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://live.techpanda.org/index.php/customer/account/login/");
        Assert.assertTrue(driver.findElement(By.xpath("//button[@title='Login']")).isDisplayed());

        //New window
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://live.techpanda.org/index.php/sales/guest/form/");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='oar_order_id']")).isDisplayed());

        //Close all except parent window
        closeTabExcept(parentWindowID);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/h2")).getText(),"THIS IS DEMO SITE FOR   ");
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

    //Only use for 2 windows/tabs
    //NOte: must use equal. If use != then this function fail
    public void switchToNewWindow(String currentWindowID) {
        Set<String> windowIDs = driver.getWindowHandles();
        for (String windowID : windowIDs) {
            if (!windowID.equals(currentWindowID)) {
                driver.switchTo().window(windowID);
            }
        }
    }

    //Able to use with any number of windows/tabs
    public void switchtoWindowByTitle(String expectedPageTitle) {
        Set<String> windowIDs = driver.getWindowHandles();
        for (String windowID : windowIDs) {
            driver.switchTo().window(windowID);
            sleepInSeconds(2);
            if (driver.getTitle().equals(expectedPageTitle)) {
                break;
            }
        }
    }

    public void closeTabExcept(String exceptWindowID) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(exceptWindowID)) {
                driver.switchTo().window(window).close();
            }
            driver.switchTo().window(exceptWindowID);
        }
    }

}