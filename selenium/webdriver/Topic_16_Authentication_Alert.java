package webdriver;


import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_16_Authentication_Alert {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    //Use this case when you need to open a website that needs authentication
    @Test
    public void TC_01_Authentication_Alert() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.lbp0v7vq2921
        //Step 01 - Truy cập vào trang: http://the-internet.herokuapp.com/basic_auth
        //http https:// + username:password + @URL
        String username = "admin";
        String password = "admin";
        System.out.println("http://" + username + ":" +password + "@the-internet.herokuapp.com/basic_auth");

        //Step 02 - Handle authentication alert vs user/pass: admin/ admin
        driver.get("http://" + username + ":" +password + "@the-internet.herokuapp.com/basic_auth");

        //Step 03 - Verify message hiển thị sau khi login thành công:
        Assert.assertEquals(driver.findElement(By.cssSelector("div#content p")).getText(),"Congratulations! You must have the proper credentials.");
    }

    //Use this case when you are already in a website and click on a link that needs authentication
    @Test
    public void TC_02_Authentication_Navigate() {
        String username = "admin";
        String password = "admin";
        driver.get("http://the-internet.herokuapp.com");
        String url = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        System.out.println(url);

        String newURL = getAuthenticationURL(url,username,password);
        System.out.println(newURL);

        //Instead of clicking on the link that needs authentication, we go directly to its URL with authentication
        driver.get(newURL);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#content p")).getText(),"Congratulations! You must have the proper credentials.");
    }

    @Test
    public void TC_03_Authentication_CDP() {
        String username = "admin";
        String password = "admin";

        driver = new ChromeDriver();
        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
//        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", username, password).getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#content p")).getText(),"Congratulations! You must have the proper credentials.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getAuthenticationURL(String url, String username, String password) {
        String[] strings = url.split("//");
        String newURL = strings[0] + username + ":" + password + "@" + strings[1];
        return newURL;
    }
}