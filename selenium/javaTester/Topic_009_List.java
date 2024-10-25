package javaTester;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_009_List {
    List<String> cities = new ArrayList<>();

    @Test
    //For (classic, iterator)
    public void TC_01_List_Print_All() {
        cities.add("HCM");
        cities.add("Ha Noi");
        cities.add("Thanh Hoa");
        cities.add("Vung Tau");
        cities.add("Dong Nai");
        cities.add("An Giang");

        System.out.println(cities.get(2));

        //print all
        for (String city : cities) {
            System.out.println(city);
        }
    }

    @Test
    public void TC_02_List_Print_With_Condition() {
        List<String> cities = new ArrayList<>();
        cities.add("HCM");
        cities.add("Ha Noi");
        cities.add("Thanh Hoa");
        cities.add("Vung Tau");
        cities.add("Dong Nai");
        cities.add("An Giang");

        //print until condition match
        for (String city : cities) {
            System.out.println(city);
            if (city == "Vung Tau") {
                System.out.println("We come to Vung Tau. This is the end");
                break;
            }
        }
    }

}
