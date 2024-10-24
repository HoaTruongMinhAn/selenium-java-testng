package javaTester;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;

public class Topic_07_Bypass_Cloudfare_Capcha {
    @Test
    public void TC_01_Bypass_Cloudfare_Capcha(){
        // Set pre-saved cookies after manually completing Cloudflare validation
        Cookie cloudflareCookie = new Cookie("cf_clearance", "HMxyz9ukaddnBgmVs5eDg3RNFdCMCw6eSMu9D1HqzbM-1729760948-1.2.1.1-Bv4.Xsed3GjCsXffvMAdG6iIp3PcdtwXj5WgRAUTBQhXOsGNuXP.XoqA6Jz0w2TLcMCLvZtAIA.XFS_vNXtVJt8tYMga2KezbKxBpJQ8wTTL15uJtfOqhT4nK4FBnSy3vdT.cPlvw3sjKYAswV9f_Z1E0Mn6WEqlImUTrpj3xWFOcZFdhjsHXmBtiib43EAsQP4pFbLJ0hcJ5cWhl7EjIG62VQB6ec9_dbsCp4.oNbfQ155X0U3Yp8Gjdx6EijyrZiJOHTY0qmoTdlxF.Uu2_tvP08NzfQnpKSgk4rdI0Z5XpKAAJpoxEmXTjMk5vjzuP32zC0sL6z8e9HDHEAGoycFc5gxeazH.mN.JeTAcKBbHIHUnjfVtLZqOqzzFAmUHhQJYOfEQhiWMGGCZXZ6XkQ");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().addCookie(cloudflareCookie);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //// Now access the site with the pre-saved cookies
        driver.navigate().refresh();
    }

}
