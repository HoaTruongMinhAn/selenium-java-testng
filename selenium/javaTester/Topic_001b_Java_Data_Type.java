package javaTester;

public class Topic_001b_Java_Data_Type {
    int amount;

    //test ssss
    public static void main (String[] args) {
        //part 1
        byte byteNum = 127;
        short shortNum = 32767;
        int intNum = 2147483647;
        long longNum = 9223372036854775807L;
        float floatNum = 3.123456789f;
        double doubleNum = 3.123456789012345678901234567890d;
        boolean boolVar = true;
        char charVar = 'Z';
        System.out.println("-------------part 1");
        System.out.println("byteNum: " + byteNum);
        System.out.println("shortNum: " + shortNum);
        System.out.println("intNum: " + intNum);
        System.out.println("longNum: " + longNum);
        System.out.println("floatNum: " + floatNum);
        System.out.println("doubleNum: " + doubleNum);
        System.out.println("boolVar: " + boolVar);
        System.out.println("charVar: " + charVar);


        //part 2
        int testNum1 = 10;
        int testNum2 = testNum1;
        System.out.println("-------------part 2");
        System.out.println("testNum1: " + testNum1);
        System.out.println("testNum2: " + testNum2);

        testNum1 = 15;
        System.out.println("testNum1: " + testNum1);
        System.out.println("testNum2: " + testNum2);

        //part 3
        Topic_001b_Java_Data_Type t1 = new Topic_001b_Java_Data_Type();
        t1.amount = 20;

        Topic_001b_Java_Data_Type t2 = new Topic_001b_Java_Data_Type();

        System.out.println("-------------part 3");
        System.out.println("t1: " + t1.amount);
        System.out.println("t2: " + t2.amount);

        t1.amount = 25;
        t2 = t1;
        System.out.println("t1: " + t1.amount);
        System.out.println("t2: " + t2.amount);

        t1.amount = 30;
        System.out.println("t1: " + t1.amount);
        System.out.println("t2: " + t2.amount);
    }


}
