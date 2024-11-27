package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    @Test(enabled = false)
    public void TC_01_shouldBeCreate() {
        System.out.println("\t\t\tshouldBeCreate");
    }

    @Test
    public void TC_02_shouldBeView() {
        System.out.println("\t\t\tshouldBeView");
    }

    @Test(enabled = false)
    public void TC_03_shouldBeEdit() {
        System.out.println("\t\t\tshouldBeEdit");
    }

    @Test
    public void TC_04_shouldBeDelete() {
        System.out.println("\t\t\tshouldBeDelete");
    }
}
