package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_07_WebElement_Commands {
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Element() {
        driver.get("https://automationfc.github.io/basic-form/");

        WebElement under18RadioButton =  driver.findElement(By.xpath("//label[text()='Under 18']"));
        List<WebElement> ageRadioButtons =  driver.findElements(By.xpath("//input[@name='user_age']"));

        //To verify element is displayed on screen
        Assert.assertTrue(under18RadioButton.isDisplayed());
//        Assert.assertFalse(under18RadioButton.isDisplayed());

        //To verify element is enabled
        Assert.assertTrue(under18RadioButton.isEnabled());
//        Assert.assertFalse(under18RadioButton.isEnabled());

        //To verify element is selected
//        Assert.assertTrue(under18RadioButton.isSelected());
        Assert.assertFalse(under18RadioButton.isSelected());

        System.out.println("--------------element property");
        System.out.println("getText: " + under18RadioButton.getText());
        System.out.println("getDomAttribute: " + under18RadioButton.getDomAttribute("class"));
        System.out.println("getTagName: " + under18RadioButton.getTagName());
        System.out.println("getAttribute: " + under18RadioButton.getAttribute("class"));
        System.out.println("getCssValue: " + under18RadioButton.getCssValue("font-family"));
        System.out.println("getLocation: " + under18RadioButton.getLocation());
        System.out.println("getRect: " + under18RadioButton.getRect());
        System.out.println("getSize: " + under18RadioButton.getSize());
        System.out.println("getAccessibleName: " + under18RadioButton.getAccessibleName());

        Assert.assertEquals(under18RadioButton.getText(),"Under 18");
        Assert.assertEquals(under18RadioButton.getDomAttribute("class"),"light");
        Assert.assertEquals(under18RadioButton.getTagName(),"label");
        Assert.assertEquals(under18RadioButton.getAttribute("class"),"light");
        Assert.assertEquals(under18RadioButton.getCssValue("font-family"),"\"Nunito\", sans-serif");
        Assert.assertEquals(under18RadioButton.getLocation(),new Point(44, 1524));
        Assert.assertEquals(under18RadioButton.getText(),"Under 18");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}