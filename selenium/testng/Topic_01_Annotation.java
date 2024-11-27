package testng;

import org.testng.annotations.*;

public class Topic_01_Annotation {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Run Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Run After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\tRun Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\tRun After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\tRun Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\tRun After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\tRun Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\tRun After Method");
    }

    @Test
    public void TC_01() {
        System.out.println("\t\t\tRun TC_01 Method");
    }

    @Test
    public void TC_02() {
        System.out.println("\t\t\tRun TC_02 Method");
    }

    @Test
    public void TC_03() {
        System.out.println("\t\t\tRun TC_03 Method");
    }
}
