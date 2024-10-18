package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_XPath_Tech {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void TC_01_XPath_With_Text() {
        driver.get("https://automationfc.github.io/basic-form/");

        //Hello World! (Ignore Me) @04:45 PM
        driver.findElement(By.xpath("//span[text()=' (Ignore Me) ']"));
        driver.findElement(By.xpath("//span[text()=' @04:45 PM ']"));
        driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Ignore Me')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'@04:45 PM')]"));
        driver.findElement(By.xpath("//h5[contains(.,'@04:45 PM')]"));

        //Michael Jackson
        driver.findElement(By.xpath("//h5[contains(string(),'@04:45 PM')]"));
        driver.findElement(By.xpath("//h5[contains(.,'@04:45 PM')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'Michael Jackson')]"));
        driver.findElement(By.xpath("//h5[contains(.,'Michael Jackson')]"));


        //Mail Personal or Business Check, Cashier's Check or money order to:
        String xPath1 = """
                //p[contains(text(),"Mail Personal or Business Check, Cashier's Check or money order to:")]""";

        System.out.println(xPath1);
        driver.findElement(By.xpath(xPath1));

        driver.findElement(By.xpath("//p[contains(text(),'s Check or money order to:')]"));


        //Hello "John", What's happened?
        //1
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));

        //2
        String xPath2 = """         
                 //span[text()=concat('Hello "John", What',"'s happened?")]""";
        driver.findElement(By.xpath(xPath2));

        //3
        driver.findElement(By.xpath("//span[@class = 'concat' and contains(text(),'Hello')]"));

        //4
        driver.findElement(By.xpath("//span[@class = 'concat' or contains(text(),'Hello')]"));

        //5
        driver.findElement(By.xpath("//span[@class = 'concat' and not(contains(text(),'teng teng'))]"));
    }

    @Test
    public void TC_02_XPath_With_Position() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        //get a number box
        //1
        driver.findElement(By.xpath("//li[1]"));
        driver.findElement(By.xpath("//li[5]"));

        //2
        driver.findElement(By.xpath("//li[position()=10]"));

        //3
        driver.findElement(By.xpath("//li[last()]"));
        driver.findElement(By.xpath("//li[last()-1]"));

        //4
        driver.findElement(By.xpath("//li[count(//li)]"));
        driver.findElement(By.xpath("//li[count(//li)-1]"));
        driver.findElement(By.xpath("//li[count(//li[@class='ui-state-default ui-selectee'])]"));
        driver.findElement(By.xpath("//li[count(//li[@class='ui-state-default ui-selectee'])-1]"));
    }

    @Test
    public void TC_02_XPath_With_Position2() {
        driver.get("https://automationfc.github.io/basic-form/");

        //<span class="singer"></span>
        //1
        driver.findElement(By.xpath("//span[@class='singer']")); // 6 elements
        driver.findElement(By.xpath("(//span[@class='singer'])")); // 6 elements

        //2
        driver.findElement(By.xpath("//span[@class='singer'][1]")); // 1 element
        driver.findElement(By.xpath("//span[@class='singer'][2]")); // no result because each span belong to a different parent node
        driver.findElement(By.xpath("(//span[@class='singer'])[1]")); // 1 element
        driver.findElement(By.xpath("(//span[@class='singer'])[2]")); // 1 element because those elements warped in () and count as child of the root, and there are 6 of them
    }

    @Test
    public void TC_03_XPath_With_AXES_01() {
        driver.get("https://www.packtpub.com/en-us/search?query=selenium");

        //Book "Selenium Testing Tools Cookbook" --> Add to cart
        //1
        driver.findElement(By.xpath("//div[normalize-space(text()) ='Selenium Testing Tools Cookbook']//ancestor::div[@class='product-card-v2-content']//following-sibling::div//button[contains(@class,'cart-button')]"));

        //Book "Learn Automation Testing with Java and Selenium Webdriver" --> Add to cart
        //1
        driver.findElement(By.xpath("//div[normalize-space(text()) ='Learn Automation Testing with Java and Selenium Webdriver']//ancestor::div[@class='product-card-v2-content']//following-sibling::div//button[contains(@class,'cart-button')]"));
    }

    @Test
    public void TC_03_XPath_With_AXES_02() {
        driver.get("https://www.packtpub.com/en-us/search?query=selenium");

        //Book "Selenium Testing Tools Cookbook" --> Add to cart
        //1
        driver.findElement(By.xpath("//div[normalize-space(text()) ='Selenium Testing Tools Cookbook']//ancestor::div[@class='product-card-v2-content']//following-sibling::div//button[contains(@class,'cart-button')]"));

        //Book "Learn Automation Testing with Java and Selenium Webdriver" --> Add to cart
        //1
        driver.findElement(By.xpath("//div[normalize-space(text()) ='Learn Automation Testing with Java and Selenium Webdriver']//ancestor::div[@class='product-card-v2-content']//following-sibling::div//button[contains(@class,'cart-button')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}