package javaTester;

public class Topic_011_Try_Catch {
    public static void main(String[] args) throws InterruptedException {
        String text = null;
        try {
            System.out.println(text.toString());
        } catch (Exception e) {
            System.out.println("Error bro: " + e.getMessage());
        } finally //run no matter try or catch
        {
            System.out.println("Finally bro");
        }
    }


}
