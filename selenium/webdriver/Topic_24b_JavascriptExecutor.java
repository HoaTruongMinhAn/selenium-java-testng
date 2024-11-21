package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24b_JavascriptExecutor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Live_TechPanda_Call_Function() {
        //Exercise link:
        navigateToUrlByJS("https://live.techpanda.org/");

        explicitWait.until(ExpectedConditions.urlToBe("https://live.techpanda.org/"));

        Assert.assertEquals(getURL(), "https://live.techpanda.org/");
        Assert.assertEquals(getDomain(), "live.techpanda.org");

        //Click on Mobile
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mobile']")));
        clickToElementByJS("//a[text()='Mobile']");

        //Add to cart
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']")));

        clickToElementByJS("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']");
        sleepInSeconds(15);

        //Verify text
        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        //Customer service
        clickToElementByJS("//a[text()='Customer Service']");
        sleepInSeconds(5);

        scrollToElementOnDown("//input[@id='newsletter']");
        setAttributeInDOM("//input[@id='newsletter']", "value", "aaaa@aaa.com");

        //Subcribe
        clickToElementByJS("//span[text()='Subscribe']");
        sleepInSeconds(2);
        driver.switchTo().alert().accept();
        sleepInSeconds(10);
        driver.switchTo().defaultContent();

        //Verify text
        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
    }

    @Test
    public void TC_03_Rode() {
        //Exercise link:
        //
        driver.get("https://warranty.rode.com/login");
        sleepInSeconds(2);

        //Empty email
        WebElement loginButton = driver.findElement(By.xpath("//button[text()=' Log in ']"));
        loginButton.click();
        sleepInSeconds(2);

        String emailLocator = "//input[@id='email']";
        String passwordLocator = "//input[@id='password']";
        String emailMessage = getElementValidationMessage(emailLocator);
        Assert.assertEquals(emailMessage, "Please fill out this field.");

        //Invalid email 1
        String invalidEmail = "aaa";
        WebElement emailTextbox = driver.findElement(By.xpath(emailLocator));
        emailTextbox.sendKeys(invalidEmail);

        loginButton.click();
        sleepInSeconds(2);

        String driverName = driver.toString();
        emailMessage = getElementValidationMessage(emailLocator);

        if (driverName.contains("Chrome")) {
            Assert.assertEquals(emailMessage, "Please include an '@' in the email address. '" + invalidEmail + "' is missing an '@'.");
        } else {
            Assert.assertEquals(emailMessage, "Please enter an email address.");
        }

        //Invalid email 2
        String invalidEmail2 = "aaa@";
        emailTextbox.clear();
        emailTextbox.sendKeys(invalidEmail2);
        loginButton.click();
        sleepInSeconds(2);

        emailMessage = getElementValidationMessage(emailLocator);

        if (driverName.contains("Chrome")) {
            Assert.assertEquals(emailMessage, "Please enter a part following '@'. '" + invalidEmail2 + "' is incomplete.");
        } else {
            Assert.assertEquals(emailMessage, "Please enter an email address.");
        }

        //Invalid email 3
        String invalidEmail3 = "aaa@aaa.";
        emailTextbox.clear();
        emailTextbox.sendKeys(invalidEmail3);
        loginButton.click();
        sleepInSeconds(2);

        emailMessage = getElementValidationMessage(emailLocator);

        if (driverName.contains("Chrome")) {
            Assert.assertEquals(emailMessage, "'.' is used at a wrong position in '" + invalidEmail3.split("@")[1] +"'.");
        } else {
            Assert.assertEquals(emailMessage, "Please enter an email address.");
        }

        //Valid email
        String validEmail = "aaa@aaa.aaa";
        emailTextbox.clear();
        emailTextbox.sendKeys(validEmail);
        loginButton.click();
        sleepInSeconds(2);

        emailMessage = getElementValidationMessage(emailLocator);
        String passwordMessage = getElementValidationMessage(passwordLocator);

        Assert.assertEquals(emailMessage, "");
        Assert.assertEquals(passwordMessage, "Please fill out this field.");
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

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getURL() {
        return (String) jsExecutor.executeScript("return document.URL;");
    }

    public String getDomain() {
        return (String) jsExecutor.executeScript("return document.domain;");
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }


}