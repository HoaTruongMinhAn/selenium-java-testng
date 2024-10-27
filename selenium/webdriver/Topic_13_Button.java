package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_13_Button {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }



    @Test
    public void TC_01_Fahasa() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.zg8vyw1whenb

        //Step 01 - Truy cập vào trang: https://www.fahasa.com/customer/account/create
        driver.get("https://www.fahasa.com/customer/account/create");

        //Step 02 - Navigate qua tab Đăng nhập
        driver.findElement(By.cssSelector("li[class*='popup-login-tab-login']")).click();

        //Step 03 - Verify “Đăng nhập” button là disabled
        By loginButton = By.className("fhs-btn-login");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        //Step 04 - Verify “Đăng nhập” button có background color là màu xám
        String loginButtonColor = driver.findElement(loginButton).getCssValue("background-color");
        Color colorValue = Color.fromString(loginButtonColor);
        System.out.println(colorValue);
        Assert.assertEquals(colorValue.asHex().toUpperCase(),"#000000");

        //Step 05 - Input dữ liệu hợp lệ vào Email/ Mật khẩu textbox
        driver.findElement(By.cssSelector("input[id='login_username']")).sendKeys("aaa@aaa.com");
        driver.findElement(By.cssSelector("input[id='login_password']")).sendKeys("123456");

        //Step 06 - Verify “Đăng nhập” button là enabled
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        //Step 07 - Verify “Đăng nhập” button có background color là màu đỏ
        loginButtonColor = driver.findElement(loginButton).getCssValue("background-color");
        colorValue = Color.fromString(loginButtonColor);
        System.out.println(colorValue);
        Assert.assertEquals(colorValue.asHex().toUpperCase(),"#C92127");

    }

    @Test
    public void TC_02_Goco() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.zg8vyw1whenb

        //Step 01 - Truy cập vào trang: https://play.goconsensus.com/u5d5156df
        driver.get("https://play.goconsensus.com/u5d5156df");

        //Accept cookie
        driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();

        //Step 03 - Verify Continue button là disabled
        By continueButton = By.cssSelector("button[data-testid='lead form continue']");
        Assert.assertFalse(driver.findElement(continueButton).isEnabled());

        //Step 04 - Verify Continue button có background color là màu xám
        //--outlined-button-hover-text-color
        String loginButtonColor = driver.findElement(continueButton).getCssValue("background-color");
        Color colorValue = Color.fromString(loginButtonColor);
        System.out.println(colorValue);
        Assert.assertEquals(colorValue.asHex().toUpperCase(),"#673AB7");

        //Step 05 - Input dữ liệu hợp lệ vào Email/ Mật khẩu textbox
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("aaa");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("bbb");
        driver.findElement(By.cssSelector("input#email")).sendKeys("aaa@aaa.com");
        driver.findElement(By.cssSelector("input#confirmEmail")).sendKeys("aaa@aaa.com");
        driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input#organization")).sendKeys("ccc");

        enterItemInCustomDropdown("label[for='country']+div input","div[class*=src-shared-ui-dropdown-select-ui-menu-menu--bottom]>div","KW");
        enterItemInCustomDropdown("label[for='state']+div input","div[class*=src-shared-ui-dropdown-select-ui-menu-menu--bottom]>div","HA");


        //Step 06 - Verify Continue button là enabled
        Assert.assertTrue(driver.findElement(continueButton).isEnabled());

        //Step 07 - Verify Continue button có background color là màu đỏ
        loginButtonColor = driver.findElement(continueButton).getCssValue("background-color");
        colorValue = Color.fromString(loginButtonColor);
        System.out.println(colorValue);
        Assert.assertEquals(colorValue.asHex().toUpperCase(),"#673AB7");
    }

    @Test
    public void TC_03_Huawei() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.zg8vyw1whenb

        //Step 01 - Truy cập vào trang: https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html
        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");

        //Step 03 - Verify Register button là disabled
        By continueButton = By.cssSelector("div[ht='click_register_mailSubmit']>div");
//        Assert.assertFalse(driver.findElement(continueButton).isEnabled());

        Assert.assertTrue(driver.findElement(continueButton).getAttribute("class").contains("hwid-disabled"));

        //Step 04 - Verify Register button có background color là màu xám
        //--outlined-button-hover-text-color
        String loginButtonColor = driver.findElement(continueButton).getCssValue("background-color");
        Color colorValue = Color.fromString(loginButtonColor);
        System.out.println(colorValue);
        Assert.assertEquals(colorValue.asHex().toUpperCase(),"#CA141D");

        //Step 05 - Input dữ liệu hợp lệ vào Email/ Mật khẩu textbox
        driver.findElement(By.cssSelector("input[ht='input_enter_email']")).sendKeys("aaa@aaa.com");
        driver.findElement(By.cssSelector("input[ht='input_enter_password1']")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[ht='input_enter_confirmpassword2']")).sendKeys("Abc12345");

        //Stuck on enter email code
        driver.findElement(By.cssSelector("input[ht='input_register_EmailCode']")).sendKeys("111111");

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

    private void selectItemInCustomDropdown(String parentCss, String childCss, String item) {
        //Step to click on a custom dropdown
        //1. Wait for dropdown to be clickable
        //2. Click on an element to expand dropdown
        explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(parentCss)))).click();
        sleepInSeconds(2);

        //3. Wait for presence of all items
        List<WebElement> speedItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        //4. Wait for the expected item
        //5. Click on the expected item
        /*
        Why don't we click directly on the element instead of a loop?
        Reason 1: On a long dropdown, users don't know where the expected item is so they cannot click directly on it, they need to manual check each item and keep scrolling down until they find the expected one.
        Reason 2: A loop will increase success rate of click behavior
        */
        for (WebElement speedItem : speedItems) {
            if (speedItem.getText().equals(item)) {
                speedItem.click();
                break;
            }
        }
    }

    private void enterItemInCustomDropdown(String parentCss, String childCss, String item) {
        //1. Wait for dropdown to be inputable (visible)
        //2. Enter text into dropdown
        WebElement parentNode = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(parentCss))));
        parentNode.click();
        parentNode.clear();
        parentNode.sendKeys(item);
        sleepInSeconds(2);

        //3. Wait for presence of all items
        List<WebElement> speedItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        //4. Wait for the expected item
        //5. Click on the expected item
        /*
        Why don't we click directly on the element instead of a loop?
        Reason 1: On a long dropdown, users don't know where the expected item is so they cannot click directly on it, they need to manual check each item and keep scrolling down until they find the expected one.
        Reason 2: A loop will increase success rate of click behavior
        */
        for (WebElement speedItem : speedItems) {
            if (speedItem.getText().equals(item)) {
                speedItem.click();
                break;
            }
        }
    }
}