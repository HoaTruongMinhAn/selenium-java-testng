package javaTester;

public class Topic_001_Keywords {
    //Access control modifier
    //Scope is visible to world (public)
    public String publicString = "111111111";

    //Scope of the package and all subclasses (protected)
    protected String protectedString = "222222222";

    //Scope only within the classes only (private)
    private String privateString = "33333333333";

    //Scope only inside the same package (default)
    String defaultString = "4444444444";

    //Non-Access Modifiers
    public static final String finalString = "5555555555";

    public void functionOne(){

    }

    public static void main(String[] args) throws InterruptedException {
//        finalString = "666";
    }
}
