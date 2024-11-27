package testng;

import org.testng.annotations.Test;

public class Topic_05_Priority {
    @Test(priority = 1)
    public void shouldBeCreate() {
        System.out.println("\t\t\tshouldBeCreate");
    }

    @Test(priority = 2)
    public void shouldBeView() {
        System.out.println("\t\t\tshouldBeView");
    }

    @Test(priority = 3)
    public void shouldBeEdit() {
        System.out.println("\t\t\tshouldBeEdit");
    }

    @Test(priority = 4)
    public void shouldBeDelete() {
        System.out.println("\t\t\tshouldBeDelete");
    }
}
