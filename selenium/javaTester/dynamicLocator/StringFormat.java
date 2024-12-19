package javaTester.dynamicLocator;

public class StringFormat {
    public static void main(String[] args) {
        System.out.println(String.format("Hello World %s", "I am newbie"));
        System.out.println(String.format("Hello World %s, how are you %s?", "I am newbie", "today"));

        String DELETE_ICON_BY_FEMALE = "start %s end";
        clickToDeleteIcon1(DELETE_ICON_BY_FEMALE, "111");
        clickToDeleteIcon1(DELETE_ICON_BY_FEMALE, "222");
        clickToDeleteIcon1(DELETE_ICON_BY_FEMALE, "hello everybody, how are you?");

        String DELETE_ICON_BY_FEMALE_YEAR = "start %s and %s end";
        clickToDeleteIcon2(DELETE_ICON_BY_FEMALE_YEAR, "111", "2000");
        clickToDeleteIcon2(DELETE_ICON_BY_FEMALE_YEAR, "Yes", "31/12/2000");

        String DELETE_ICON_BY_FEMALE_YEAR_CITY = "female %s year %s city %s end";
        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_YEAR_CITY, "Mary", "2000", "HCM");
        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_YEAR_CITY, "Mary", "2000", "HCM", "Dakao");
    }

    public static void clickToDeleteIcon1(String locator, String female) {
        System.out.println("clickToDeleteIcon1 " + String.format(locator, female));
    }

    public static void clickToDeleteIcon2(String locator, String female, String birthYear) {
        System.out.println("clickToDeleteIcon2 " + String.format(locator, female, birthYear));
    }

    public static void clickToDeleteIcon(String locator, String... params) {
        System.out.println("clickToDeleteIcon " + String.format(locator, (Object[]) params));
    }
}
