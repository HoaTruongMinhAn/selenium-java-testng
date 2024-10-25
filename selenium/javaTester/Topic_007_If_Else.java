package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_007_If_Else {
    @Test
    public void TC_01_If_Else() {
        String osName = System.getProperty("os.name");
        String browserName = "Chrome";

        System.out.println(osName);

        //IF
        if (browserName.equals("IE")) {
            System.out.println("Browser is Internet Exporer");
        }

        //IF-ELSE
        if (osName.startsWith("Windows")) {
            System.out.println("Windows OS");
        }
        if (osName.startsWith("Mac")) {
            System.out.println("Mac OS");
        } else {
            System.out.println("Not Windows or Mac OS");
        }

        //SWITCH CASE
        WebDriver driver;
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }
    }

}
