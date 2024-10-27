package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Topic_14_Checkbox {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Telerik() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://demos.telerik.com/kendo-ui/checkbox/index
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");


        By dualCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By leatureCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input");
        By towbarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input");

        //Scroll the screen down
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        //Step 02 - Click vào checkbox: Dual-zone air conditioning
        if (!driver.findElement(dualCheckbox).isSelected()) {
            driver.findElement(dualCheckbox).click();
        }

        //Step 03 - Kiểm tra checkbox đó đã chọn
        //verify enable-disabled
        Assert.assertTrue(driver.findElement(dualCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(dualCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(leatureCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(leatureCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(towbarCheckbox).isEnabled());
        Assert.assertFalse(driver.findElement(towbarCheckbox).isSelected());

        //Step 04 - Sau khi checkbox đã được chọn - bỏ chọn nó và kiểm tra nó chưa được chọn
        if (driver.findElement(dualCheckbox).isSelected()) {
            driver.findElement(dualCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(dualCheckbox).isSelected());

        //Step 05 - Truy cập vào trang: https://demos.telerik.com/kendo-ui/radiobutton/index
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        //Step 06 - Click vào radio button:  2.0 Petrol, 147kW
        By i20Petrol147Radio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        Assert.assertTrue(driver.findElement(i20Petrol147Radio).isEnabled());
        driver.findElement(i20Petrol147Radio).click();

        //Step 07 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
        Assert.assertTrue(driver.findElement(i20Petrol147Radio).isSelected());

        if (driver.findElement(i20Petrol147Radio).isSelected()) {
            System.out.println("i20Petrol147Radio is selected");
        } else {
            System.out.println("i20Petrol147Radio is not selected");
            driver.findElement(i20Petrol147Radio).isSelected();
        }
    }

    @Test
    public void TC_02_Angular() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://material.angular.io/components/radio/examples
        driver.get("https://material.angular.io/components/radio/examples");

        //Step 02 - Click vào radio button:  Summer
        //Step 03 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
        By summerCheckbox = By.cssSelector("input[value='Summer']");

        if (!driver.findElement(summerCheckbox).isSelected()) {
            driver.findElement(summerCheckbox).click();
        }

        Assert.assertTrue(driver.findElement(summerCheckbox).isSelected());

        //Step 04 - Truy cập vào trang: https://material.angular.io/components/checkbox/examples
        driver.get("https://material.angular.io/components/checkbox/examples");

        //Step 06 - Click vào checkbox: Checked, Indeterminate
        By checkedCheckbox = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminateCheckbox = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        if (!driver.findElement(checkedCheckbox).isSelected()) {
            driver.findElement(checkedCheckbox).click();
        }
        if (!driver.findElement(indeterminateCheckbox).isSelected()) {
            driver.findElement(indeterminateCheckbox).click();
        }

        //Step 07 - Kiểm tra checkbox đó đã chọn
        Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(indeterminateCheckbox).isSelected());

        //Step 08 - Sau khi checkbox đã được chọn - bỏ chọn nó và kiểm tra nó chưa được chọn
        if (driver.findElement(checkedCheckbox).isSelected()) {
            driver.findElement(checkedCheckbox).click();
        }
        if (driver.findElement(indeterminateCheckbox).isSelected()) {
            driver.findElement(indeterminateCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(checkedCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(indeterminateCheckbox).isSelected());
    }

    @Test
    public void TC_03_Select_All() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/multiple-fields/
        driver.get("https://automationfc.github.io/multiple-fields/");

        //Step 02 - Chọn hết tất cả các checkbox ở màn hình này
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("div[data-component='checkbox'] input"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        //Step 03 - Kiểm tra tất cả các checkbox đó đã chọn
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        //Deselect
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

        //Step 04 - Chỉ chọn 1 checkbox là “Heart Attack” trong tất cả các checkbox
//        WebElement checkbox1 = driver.findElement(By.cssSelector("input[value='Emotional Disorder']"));
//        WebElement checkbox2 = driver.findElement(By.cssSelector("input[value='Emphysema']"));

        List<String> expectedCheckboxes = new ArrayList<String>();
        expectedCheckboxes.add("Emotional Disorder");
        expectedCheckboxes.add("Emphysema");

        for (WebElement checkbox : checkboxes) {
            if (expectedCheckboxes.contains(checkbox.getAttribute("value")) && !checkbox.isSelected()) {
                checkbox.click();
                Assert.assertTrue(checkbox.isSelected());
            }
        }
    }

    @Test
    public void TC_04_Select_Random_Checkbox() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://automationfc.github.io/multiple-fields/
        driver.get("https://automationfc.github.io/multiple-fields/");

        //select random checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("div[data-component='checkbox'] input"));
        int randomNum = new Random().nextInt(1,checkboxes.size()+1);
        WebElement randomCheckbox = driver.findElement(By.xpath("(//div[@data-component='checkbox']//input)[" + randomNum + "]"));

        if(!randomCheckbox.isSelected()){
            randomCheckbox.click();
        }
        Assert.assertTrue(randomCheckbox.isSelected());
    }

    @Test
    public void TC_05_Ubuntu_Normal_Click() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://login.ubuntu.com/
        driver.get("https://login.ubuntu.com/");

        //Step 02 - Click vào radio button:  I don’t have an Ubuntu One account
        WebElement haveAccountRadioButton = driver.findElement(By.cssSelector("input#id_new_user"));
        WebElement haveAccountLabel = driver.findElement(By.cssSelector("label[for='id_new_user']"));

        //Method 1: click and verify the overlapped element
/*        haveAccountRadioButton.click();
        Assert.assertTrue(haveAccountRadioButton.isSelected());*/

        //Method 2: click and verify the obscure element
/*        haveAccountLabel.click();
        Assert.assertTrue(haveAccountLabel.isSelected());*/

        //Method 3: click the obscure element, and verify the overlapped element
        haveAccountLabel.click();
        Assert.assertTrue(haveAccountRadioButton.isSelected());


        //Step 03 - Click vào checkbox: I have read and accept the Ubuntu One terms of service, data privacy policy and Canonical's SSO privacy notice.
        WebElement termCheckbox = driver.findElement(By.cssSelector("input#id_accept_tos"));
        WebElement termLabel = driver.findElement(By.cssSelector("label[for='id_accept_tos']"));

        termLabel.click();
        Assert.assertTrue(termCheckbox.isSelected());
    }

    @Test
    public void TC_06_Ubuntu_Javascript_Click() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://login.ubuntu.com/
        driver.get("https://login.ubuntu.com/");

        //Step 02 - Click vào radio button:  I don’t have an Ubuntu One account
        WebElement haveAccountRadioButton = driver.findElement(By.cssSelector("input#id_new_user"));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", haveAccountRadioButton);
        Assert.assertTrue(haveAccountRadioButton.isSelected());

        //Step 03 - Click vào checkbox: I have read and accept the Ubuntu One terms of service, data privacy policy and Canonical's SSO privacy notice.
        WebElement termCheckbox = driver.findElement(By.cssSelector("input#id_accept_tos"));
        jsExecutor.executeScript("arguments[0].click();", termCheckbox);
        Assert.assertTrue(haveAccountRadioButton.isSelected());
    }

    @Test
    public void TC_07_Google_Doc() {
        //Exercise link: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0#heading=h.81yhken0zt0d
        //Step 01 - Truy cập vào trang: https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        //Step 02 - Kiểm tra ‘Cần Thơ’ radio button là chưa được chọn (dùng hàm isDisplayed)
        //Step 03 - Click chọn ‘Cần Thơ’ radio button
        //Step 04 - Kiểm tra ‘Cần Thơ’ radio button là đã được chọn (dùng hàm isDisplayed)
        sleepInSeconds(2);
        WebElement canthoRadioButton = driver.findElement(By.xpath("//div[@aria-label='Cần Thơ']"));
        Assert.assertEquals(canthoRadioButton.getAttribute("aria-checked"),"false");
        canthoRadioButton.click();
        Assert.assertEquals(canthoRadioButton.getAttribute("aria-checked"),"true");

        //Second click
        canthoRadioButton.click();
        Assert.assertEquals(canthoRadioButton.getAttribute("aria-checked"),"true");

        //Step 05 - Quảng Tri checkbox
        WebElement quangTriCheckbox = driver.findElement(By.cssSelector("div[aria-label=\"Quảng Trị\"]"));
        Assert.assertEquals(quangTriCheckbox.getAttribute("aria-checked"),"false");
        quangTriCheckbox.click();
        Assert.assertEquals(quangTriCheckbox.getAttribute("aria-checked"),"true");

        //Second click
        quangTriCheckbox.click();
        Assert.assertEquals(quangTriCheckbox.getAttribute("aria-checked"),"false");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}