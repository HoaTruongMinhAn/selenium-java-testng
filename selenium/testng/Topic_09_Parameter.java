package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_09_Parameter {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");
    String userName = "selenium_11_01@gmail.com";
    String password = "111111";
    String domainURL;

    @BeforeClass
    @Parameters({"server", "browser"})
    public void beforeClass(String serverName, @Optional("Firefox") String browserName) {
        System.out.println("server " + serverName);
        System.out.println("browser " + browserName);

        //Prepare environment
        if (serverName.equalsIgnoreCase("Dev")) {
            domainURL = "http://dev.techpanda.org";
        } else if (serverName.equalsIgnoreCase("Test")) {
            domainURL = "http://test.techpanda.org";
        } else if (serverName.equalsIgnoreCase("Staging")) {
            domainURL = "http://staging.techpanda.org";
        } else if (serverName.equalsIgnoreCase("Live")) {
            domainURL = "http://live.techpanda.org";
        } else {
            throw new RuntimeException("Environment is invalid");
        }

        //Prepare browser
        //If else
/*        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new RuntimeException("Browser name is invalid");
        }*/

        //Switch case
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Login_Multiple_Browsers() {
        driver.get(domainURL + "/index.php/customer/account/login/");
        System.out.println(domainURL + "/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys(userName);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(userName));

        // ....

//        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
//        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
