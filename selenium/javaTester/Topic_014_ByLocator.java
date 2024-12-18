package javaTester;

import org.openqa.selenium.By;

public class Topic_014_ByLocator {

    public static void main(String[] args) {
        By by1 = getByLocator("id=username");
        System.out.println(by1.toString());

        By by2 = getByLocator("class=username");
        System.out.println(by2.toString());

        By by3 = getByLocator("name=username");
        System.out.println(by3.toString());

        By by4 = getByLocator("tagname=username");
        System.out.println(by4.toString());

        By by5 = getByLocator("linktext=username");
        System.out.println(by5.toString());

        By by6 = getByLocator("partiallinktext=username");
        System.out.println(by6.toString());

        By by7 = getByLocator("css=username");
        System.out.println(by7.toString());

        By by8 = getByLocator("xpath=//input[@id='gender-male']");
        System.out.println(by8.toString());

        by8 = getByLocator("xPath=//input[@id='gender-male']");
        System.out.println(by8.toString());

        by8 = getByLocator("XPATH=//input[@id='gender-male']");
        System.out.println(by8.toString());

        by8 = getByLocator("Xpath=//input[@id='gender-male']");
        System.out.println(by8);
    }

    public static By getByLocator(String prefixLocator) {
        By.partialLinkText(prefixLocator);
        By by = null;
        if (prefixLocator.startsWith("id") || prefixLocator.startsWith("ID") || prefixLocator.startsWith("Id")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.startsWith("class") || prefixLocator.startsWith("CLASS") || prefixLocator.startsWith("Class")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("name") || prefixLocator.startsWith("NAME") || prefixLocator.startsWith("Name")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.startsWith("tagname") || prefixLocator.startsWith("TAGNAME") || prefixLocator.startsWith("TagName") || prefixLocator.startsWith("Tagname") || prefixLocator.startsWith("tagName")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.startsWith("linktext") || prefixLocator.startsWith("LINKTEXT") || prefixLocator.startsWith("LinkText") || prefixLocator.startsWith("Linktext") || prefixLocator.startsWith("linkText") || prefixLocator.startsWith("link")) {
            by = By.linkText(prefixLocator.substring(9));
        } else if (prefixLocator.startsWith("partiallinktext") || prefixLocator.startsWith("PARTIALLINKTEXT") || prefixLocator.startsWith("PartialLinkText") || prefixLocator.startsWith("Partiallinklext") || prefixLocator.startsWith("partialLinkText")) {
            by = By.partialLinkText(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("css") || prefixLocator.startsWith("CSS") || prefixLocator.startsWith("Css")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.startsWith("xpath") || prefixLocator.startsWith("XPATH") || prefixLocator.startsWith("XPath") || prefixLocator.startsWith("Xpath") || prefixLocator.startsWith("xPath")) {
            by = By.xpath(prefixLocator.substring(6));
        }
        return by;
    }
}
