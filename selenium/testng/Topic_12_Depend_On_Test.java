package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_12_Depend_On_Test {
    @Test
    public void TC_01() {
        System.out.println("\t\t\tRun TC_01 Method");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "TC_01")
    public void TC_02() {
        System.out.println("\t\t\tRun TC_02 Method");
    }

    @Test(dependsOnMethods = "TC_02")
    public void TC_03() {
        System.out.println("\t\t\tRun TC_03 Method");
    }
}
