package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Topic_013_Driver_Info {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        System.out.println("driver info: " + driver.toString());
        System.out.println("session info: " + ((RemoteWebDriver) driver).getSessionId());

        //driver info: FirefoxDriver: firefox on windows (ccd514a1-844e-4e9c-9e0b-76eabd4b2664)
        //session info: ccd514a1-844e-4e9c-9e0b-76eabd4b2664

        driver.quit();
    }
}
