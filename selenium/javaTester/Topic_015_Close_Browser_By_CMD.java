package javaTester;

public class Topic_015_Close_Browser_By_CMD {
    public static void main(String[] args) throws Exception {
        String cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
        Process process = Runtime.getRuntime().exec(cmd);
    }
}
