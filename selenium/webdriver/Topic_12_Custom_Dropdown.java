package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Jquery() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.usacy04kvf8d

        //Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/selectmenu/default.html
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropdown("span[id='speed-button']", "ul[id='speed-menu'] div", "Medium");

        //Step 02 - Chọn là Medium trong dropdown "Select a speed"
        WebElement selectedSpeedItem = driver.findElement(By.cssSelector("span[id='speed-button']>span[class='ui-selectmenu-text']"));

        //Step 03 - Kiểm tra item đã được chọn thành công
        Assert.assertEquals(selectedSpeedItem.getText(), "Medium");

        //Step 04 - Chọn và kiểm tra cho các item khác: Fast
        selectItemInCustomDropdown("span[id='speed-button']", "ul[id='speed-menu'] div", "Fast");

        selectedSpeedItem = driver.findElement(By.cssSelector("span[id='speed-button']>span[class='ui-selectmenu-text']"));
        Assert.assertEquals(selectedSpeedItem.getText(), "Fast");

        //Step 05 - Chọn và kiểm tra cho các item khác: Slower
        selectItemInCustomDropdown("span[id='speed-button']", "ul[id='speed-menu'] div", "Slower");

        selectedSpeedItem = driver.findElement(By.cssSelector("span[id='speed-button']>span[class='ui-selectmenu-text']"));
        Assert.assertEquals(selectedSpeedItem.getText(), "Slower");

        //Step 06 - Chọn và kiểm tra file
        selectItemInCustomDropdown("span[id='files-button']", "ul[id='files-menu'] div", "Some other file with a very long option text");

        WebElement selectedFileItem = driver.findElement(By.cssSelector("span[id='files-button']>span[class='ui-selectmenu-text']"));
        Assert.assertEquals(selectedFileItem.getText(), "Some other file with a very long option text");

        //Step 07 - Chọn và kiểm tra number
        selectItemInCustomDropdown("span[id='number-button']", "ul[id='number-menu'] div", "19");

        WebElement selectedNumberItem = driver.findElement(By.cssSelector("span[id='number-button']>span[class='ui-selectmenu-text']"));
        Assert.assertEquals(selectedNumberItem.getText(), "19");

        //Step 08 - Chọn và kiểm tra title
        selectItemInCustomDropdown("span[id='salutation-button']", "ul[id='salutation-menu'] div", "Other");

        WebElement selectedTitleItem = driver.findElement(By.cssSelector("span[id='salutation-button']>span[class='ui-selectmenu-text']"));
        Assert.assertEquals(selectedTitleItem.getText(), "Other");
    }

    @Test
    public void TC_02_React() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.usacy04kvf8d

        //Step 01 - Truy cập vào trang: https://react.semantic-ui.com/maximize/dropdown-example-selection/
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        //Step 02 - Chọn item
        selectItemInCustomDropdown("div[id='root']", "div[class='visible menu transition'] span", "Justen Kitsune");

        //Step 03 - Kiểm tra item đã được chọn thành công
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='ui fluid selection dropdown']>div[class='divider text']")).getText(), "Justen Kitsune");
    }

    @Test
    public void TC_03_VueJS() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.usacy04kvf8d

        //Step 01 - Truy cập vào trang: https://mikerodham.github.io/vue-dropdowns/
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        //Step 02 - Chọn item
        selectItemInCustomDropdown("li[class='dropdown-toggle']", "ul[class='dropdown-menu'] a", "Third Option");

        //Step 03 - Kiểm tra item đã được chọn thành công
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='dropdown-toggle']")).getText(), "Third Option");
    }

    @Test
    public void TC_04_Editable() {
        //Exercise link: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.usacy04kvf8d

        //Step 01 - Truy cập vào trang: https://react.semantic-ui.com/maximize/dropdown-example-search-selection/
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/ ");

        //Step 02 - Chọn item
        enterItemInCustomDropdown("input[class='search']", "div[role='listbox'] span", "American Samoa");

        //Step 03 - Kiểm tra item đã được chọn thành công
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='divider text']")).getText(), "American Samoa");

        //Step 04 - Chọn item
        enterItemInCustomDropdown("input[class='search']", "div[role='listbox'] span", "Benin");

        //Step 05 - Kiểm tra item đã được chọn thành công
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='divider text']")).getText(), "Benin");

        //The Select function also works, but that is not the best solution for an editable dropdown. We should apply Enter function instead
        selectItemInCustomDropdown("input[class='search']", "div[role='listbox'] span", "Belarus");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='divider text']")).getText(), "Belarus");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void selectItemInCustomDropdown(String parentCss, String childCss, String item) {
        //Step to click on a custom dropdown
        //1. Wait for dropdown to be clickable
        //2. Click on an element to expand dropdown
        explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(parentCss)))).click();
        sleepInSeconds(2);

        //3. Wait for presence of all items
        List<WebElement> speedItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        //4. Wait for the expected item
        //5. Click on the expected item
        /*
        Why don't we click directly on the element instead of a loop?
        Reason 1: On a long dropdown, users don't know where the expected item is so they cannot click directly on it, they need to manual check each item and keep scrolling down until they find the expected one.
        Reason 2: A loop will increase success rate of click behavior
        */
        for (WebElement speedItem : speedItems) {
            if (speedItem.getText().equals(item)) {
                speedItem.click();
                break;
            }
        }
    }

    private void enterItemInCustomDropdown(String parentCss, String childCss, String item) {
        //1. Wait for dropdown to be inputable (visible)
        //2. Enter text into dropdown
        WebElement parentNode = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(parentCss))));
        parentNode.clear();
        parentNode.sendKeys(item);
        sleepInSeconds(2);

        //3. Wait for presence of all items
        List<WebElement> speedItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        //4. Wait for the expected item
        //5. Click on the expected item
        /*
        Why don't we click directly on the element instead of a loop?
        Reason 1: On a long dropdown, users don't know where the expected item is so they cannot click directly on it, they need to manual check each item and keep scrolling down until they find the expected one.
        Reason 2: A loop will increase success rate of click behavior
        */
        for (WebElement speedItem : speedItems) {
            if (speedItem.getText().equals(item)) {
                speedItem.click();
                break;
            }
        }
    }
}