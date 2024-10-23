package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //Exercise link: https://docs.google.com/document/d/1G0QsiVDI5KfhNGKxE6a03bhn6KpvgDh69BTx2ttCO94/edit?tab=t.0#heading=h.phyjeo40g0dl

    @Test
    public void TC_01_Displayed() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
        WebElement under18RadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
        WebElement educationTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));
        WebElement user5Label = driver.findElement(By.xpath("//h5[text()='Name: User5']"));

        Assert.assertTrue(emailTextBox.isDisplayed());
        Assert.assertTrue(under18RadioButton.isDisplayed());
        Assert.assertTrue(educationTextArea.isDisplayed());
        Assert.assertFalse(user5Label.isDisplayed());

        //Action for Email text box
        if (emailTextBox.isDisplayed()) {
            emailTextBox.sendKeys("Automation testing");
            System.out.println("Email text box is displayed");
        }
        else {
            System.out.println("Email text box is not displayed");
        }

        //Action for under18 Radio Button
        if (under18RadioButton.isDisplayed()){
            under18RadioButton.click();
            System.out.println("under18 Radio Button is displayed");
        }
        else {
            System.out.println("under18 Radio Button is not displayed");
        }

        //Action for Education Text Area
        if (educationTextArea.isDisplayed()){
            educationTextArea.sendKeys("Automation testing");
            System.out.println("Education Text Area is displayed");
        }
        else {
            System.out.println("Education Text Area is not displayed");
        }

        //Action for User5 label
        if (user5Label.isDisplayed()){
            System.out.println("User5 label is displayed");
        }
        else {
            System.out.println("User5 label is not displayed");
        }
    }

    @Test
    public void TC_02_Enabled(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
        WebElement ageUnder18RadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
        WebElement educationTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));
        WebElement jobRole1Droplist = driver.findElement(By.cssSelector("select[id=job1]"));
        WebElement jobRole2Droplist = driver.findElement(By.cssSelector("select[id=job2]"));
        WebElement jobRole3Droplist = driver.findElement(By.cssSelector("select[id=job3]"));

        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[id='disable_password']"));
        WebElement ageDisabledRadioButton = driver.findElement(By.cssSelector("input[id='radio-disabled']"));
        WebElement bioTextArea = driver.findElement(By.cssSelector("textarea[id='bio']"));
        WebElement developmentCheckBox = driver.findElement(By.cssSelector("input[id='development']"));
        WebElement interestDisabledCheckBox = driver.findElement(By.cssSelector("input[id='check-disbaled']"));
        WebElement slider1 = driver.findElement(By.cssSelector("input[id='slider-1']"));
        WebElement slider2 = driver.findElement(By.cssSelector("input[id='slider-2']"));

        Assert.assertTrue(emailTextBox.isEnabled());
        Assert.assertTrue(ageUnder18RadioButton.isEnabled());
        Assert.assertTrue(educationTextArea.isEnabled());
        Assert.assertTrue(jobRole1Droplist.isEnabled());
        Assert.assertTrue(developmentCheckBox.isEnabled());
        Assert.assertTrue(slider1.isEnabled());

        Assert.assertFalse(passwordTextBox.isEnabled());
        Assert.assertFalse(ageDisabledRadioButton.isEnabled());
        Assert.assertFalse(bioTextArea.isEnabled());
        Assert.assertFalse(jobRole3Droplist.isEnabled());
        Assert.assertFalse(interestDisabledCheckBox.isEnabled());
        Assert.assertFalse(slider2.isEnabled());

        //Action for Email text box
        System.out.println("email Text Box enabled status is :" + emailTextBox.isEnabled());
    }

    @Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSeconds(3);

        WebElement ageUnder18RadioButton = driver.findElement(By.cssSelector("input[id='under_18']"));
        WebElement languageJavaCheckBox = driver.findElement(By.cssSelector("input[id='java']"));

        System.out.println("ageUnder18RadioButton selected status is: " + ageUnder18RadioButton.isSelected());
        System.out.println("languageJavaCheckBox selected status is: " + languageJavaCheckBox.isSelected());

        //Select
        System.out.println("Select item");
        ageUnder18RadioButton.click();
        languageJavaCheckBox.click();
        sleepInSeconds(3);

        System.out.println("ageUnder18RadioButton selected status is: " + ageUnder18RadioButton.isSelected());
        System.out.println("languageJavaCheckBox selected status is: " + languageJavaCheckBox.isSelected());

        Assert.assertTrue(ageUnder18RadioButton.isSelected());
        Assert.assertTrue(languageJavaCheckBox.isSelected());

        //De-select
        System.out.println("Deselect item");
        ageUnder18RadioButton.click();
        languageJavaCheckBox.click();
        sleepInSeconds(3);

        System.out.println("ageUnder18RadioButton selected status is: " + ageUnder18RadioButton.isSelected());
        System.out.println("languageJavaCheckBox selected status is: " + languageJavaCheckBox.isSelected());

        Assert.assertTrue(ageUnder18RadioButton.isSelected());
        Assert.assertFalse(languageJavaCheckBox.isSelected());
    }

    @Test
    public void TC_04_MailChimp(){
        driver.get("https://login.mailchimp.com/signup/");
        sleepInSeconds(3);

        WebElement emailTextBox = driver.findElement(By.cssSelector("input[id='email']"));
        WebElement usernameTextBox = driver.findElement(By.cssSelector("input[id='new_username']"));
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[id='new_password']"));
        WebElement OneLowercaseCharacterLabel = driver.findElement(By.xpath("//span[text()='One lowercase character']/parent::li"));
        WebElement OneUppercaseCharacterLabel = driver.findElement(By.xpath("//span[text()='One uppercase character']/parent::li"));
        WebElement OneNumerLabel = driver.findElement(By.xpath("//span[text()='One number']/parent::li"));
        WebElement OneSpecialCharacterLabel = driver.findElement(By.xpath("//span[text()='One special character']/parent::li"));
        WebElement EightCharactersMinimumLabel = driver.findElement(By.xpath("//span[text()='8 characters minimum']/parent::li"));
        WebElement MustNotContainUsernameLabel = driver.findElement(By.xpath("//span[text()='Must not contain username']/parent::li"));

        emailTextBox.sendKeys("AutomationTest001@aaa.com");
        usernameTextBox.click();
        sleepInSeconds(3);

        Assert.assertEquals(OneLowercaseCharacterLabel.getAttribute("class"),"lowercase-char not-completed");
        Assert.assertEquals(OneUppercaseCharacterLabel.getAttribute("class"),"uppercase-char not-completed");
        Assert.assertEquals(OneNumerLabel.getAttribute("class"),"number-char not-completed");
        Assert.assertEquals(OneSpecialCharacterLabel.getAttribute("class"),"special-char not-completed");
        Assert.assertEquals(EightCharactersMinimumLabel.getAttribute("class"),"8-char not-completed");
        Assert.assertEquals(MustNotContainUsernameLabel.getAttribute("class"),"username-check not-completed");

        //Password = 1
        passwordTextBox.sendKeys("1");
        sleepInSeconds(3);
        Assert.assertEquals(OneLowercaseCharacterLabel.getAttribute("class"),"lowercase-char not-completed");
        Assert.assertEquals(OneUppercaseCharacterLabel.getAttribute("class"),"uppercase-char not-completed");
        Assert.assertEquals(OneNumerLabel.getAttribute("class"),"number-char completed");
        Assert.assertEquals(OneSpecialCharacterLabel.getAttribute("class"),"special-char not-completed");
        Assert.assertEquals(EightCharactersMinimumLabel.getAttribute("class"),"8-char not-completed");
        Assert.assertEquals(MustNotContainUsernameLabel.getAttribute("class"),"username-check not-completed");

        Assert.assertTrue(OneLowercaseCharacterLabel.isDisplayed());
        Assert.assertTrue(OneUppercaseCharacterLabel.isDisplayed());
        Assert.assertTrue(OneNumerLabel.isDisplayed());
        Assert.assertTrue(OneSpecialCharacterLabel.isDisplayed());
        Assert.assertTrue(EightCharactersMinimumLabel.isDisplayed());
        Assert.assertTrue(MustNotContainUsernameLabel.isDisplayed());

        //Password = aA123456!@ (match all requirements)
        passwordTextBox.clear();
        passwordTextBox.sendKeys("aA123456!@");
        sleepInSeconds(3);
        Assert.assertEquals(OneLowercaseCharacterLabel.getAttribute("class"),"lowercase-char completed");
        Assert.assertEquals(OneUppercaseCharacterLabel.getAttribute("class"),"uppercase-char completed");
        Assert.assertEquals(OneNumerLabel.getAttribute("class"),"number-char completed");
        Assert.assertEquals(OneSpecialCharacterLabel.getAttribute("class"),"special-char completed");
        Assert.assertEquals(EightCharactersMinimumLabel.getAttribute("class"),"8-char completed");
        Assert.assertEquals(MustNotContainUsernameLabel.getAttribute("class"),"username-check completed");

        Assert.assertFalse(OneLowercaseCharacterLabel.isDisplayed());
        Assert.assertFalse(OneUppercaseCharacterLabel.isDisplayed());
        Assert.assertFalse(OneNumerLabel.isDisplayed());
        Assert.assertFalse(OneSpecialCharacterLabel.isDisplayed());
        Assert.assertFalse(EightCharactersMinimumLabel.isDisplayed());
        Assert.assertFalse(MustNotContainUsernameLabel.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}