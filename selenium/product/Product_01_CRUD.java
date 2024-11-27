package product;

import org.testng.annotations.Test;

public class Product_01_CRUD {
    @Test(groups = {"product", "regression"})
    public void TC_01() {
        System.out.println("\t\t\tRun Product_01_CRUD Method");
    }

    @Test(groups = {"regression"})
    public void TC_02() {
        System.out.println("\t\t\tRun Product_02_CRUD Method");
    }

    @Test(groups = {"regression"})
    public void TC_03() {
        System.out.println("\t\t\tRun Product_03_CRUD Method");
    }
}
