package javaTester;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Topic_008_Loop {
    @Test
    //For (classic, iterator)
    public void TC_01_For() {

        int number = 10;
        for (int i = 0; i < number; i++) {
            System.out.println(i);
        }
    }

    //For each
    @Test
    public void TC_02_For_Each() {

        List<String> names = new ArrayList<String>();
        names.add("An");
        names.add("Binh Duong");
        names.add("Tien Huyen");
        names.add("Dai Bang");

        for (String name : names) {
            System.out.println(name);
        }

        names.sort(Comparator.naturalOrder());
        for (String name : names) {
            System.out.println(name);
        }
    }

    //While
    @Test
    public void TC_03_While() {
        int number = 10;
        int i = 1;
        while (i <= number) {
            System.out.println(i);
            i++;
        }
    }

    //While
    @Test
    public void TC_03_Do_While() {
        int number = 10;
        int i = 1000;

        do {
            System.out.println(i);
            i++;
        }
        while (i <= number);
    }
}
