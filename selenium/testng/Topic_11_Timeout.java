package testng;

import org.testng.annotations.*;

public class Topic_11_Timeout {
    @Test(timeOut = 5000)
    public void TC_01() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("sleep 3s");
        Thread.sleep(3000);
        System.out.println("sleep 3s");
    }

}
