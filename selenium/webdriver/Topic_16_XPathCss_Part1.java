package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_XPathCss_Part1 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConfig.timeoutBySecond));
    }


    @Test
    public void TC_01_getXpath() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //GenderMaleRadioButton
        driver.findElement(By.xpath("//input[@id='gender-male']"));

        //GenderFemaleRadioButton
        driver.findElement(By.xpath("//input[@id='gender-female']"));

        //FirstNameTextBox
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //LastNameTextBox
        driver.findElement(By.xpath("//input[@id='LastName']"));

        //DOBDayDropList
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        //DOBMonthDropList
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));

        //DOBYearDropList
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        //EmailTextBox
        driver.findElement(By.xpath("//input[@id='Email']"));

        //CompanyNameTextBox
        driver.findElement(By.xpath("//input[@id='Company']"));

        //NewsletterCheckBox
        driver.findElement(By.xpath("//input[@id='Newsletter']"));

        //PasswordTextBox
        driver.findElement(By.xpath("//input[@id='Password']"));

        //ConfirmPasswordTextBox
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));

        //RegisterButton
        driver.findElement(By.xpath("//button[@id='register-button']"));
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}