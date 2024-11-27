package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Topic_04_Always_Run {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\tRun Before Class");
        driver = new FirefoxDriver();
        Assert.assertTrue(false);
    }

    @AfterClass(alwaysRun = true,enabled = true)
    public void afterClass() {
        System.out.println("\t\tRun After Class");
        driver.quit();
    }

    @Test
    public void TC_01() {
        System.out.println("\t\t\tRun TC_01 Method");
    }

    @Test
    public void TC_02() {
        System.out.println("\t\t\tRun TC_02 Method");
    }

    @Test
    public void TC_03() {
        System.out.println("\t\t\tRun TC_03 Method");
    }
}
