package javaTester;

import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Random;
import java.util.UUID;

public class Topic_006_Random_String {
    @Test
    public void TC_01_Random_Using_Number(){
        //Random using number
        Random rand = new Random();
        int randomNumber = rand.nextInt(999999);
        String firstName = "testFN" + randomNumber;
        String lastName = "testLN" + randomNumber;
        String email = "testEmail" + randomNumber + "@aaa.com";
        String password = "testPassword@" + randomNumber;

        System.out.println("random token: " + randomNumber);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
    }

    @Test
    public void TC_02_Random_Using_Timestamp(){
        //Random using timestamp
        long currentTime = new Timestamp(System.currentTimeMillis()).getTime();

        String firstName = "testFN" + currentTime;
        String lastName = "testLN" + currentTime;
        String email = "testEmail" + currentTime + "@aaa.com";
        String password = "testPassword@" + currentTime;

        System.out.println("random token: " + currentTime);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
    }

    @Test
    public void TC_03_Random_Using_UUID(){
        //Random using UUID
        UUID uuid = UUID.randomUUID();

        String firstName = "testFN" + uuid;
        String lastName = "testLN" + uuid;
        String email = "testEmail" + uuid + "@aaa.com";
        String password = "testPassword@" + uuid;

        System.out.println("random token: " + uuid);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
    }
}
