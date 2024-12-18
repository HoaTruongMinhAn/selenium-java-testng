package javaInheritance;

public class LoginPage extends BasePage implements Interface1, Interface2 {
    public static void main(String[] args) {
        basePageFunc1();
        Interface1.interfaceFunc1();
        Interface2.interfaceFunc2();
    }

    @Override
    public void interfaceFunc2() {

    }

    @Override
    public void interfaceFunc3() {

    }
}
