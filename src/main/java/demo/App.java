package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
    
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        TestCases tests = new TestCases(); // Initialize your test class

       tests.testCase01();
        Thread.sleep(3000);
       tests.testCase02();
       Thread.sleep(3000);
       tests.testCase03();
       Thread.sleep(3000);
        tests.testCase04();
        Thread.sleep(3000);
        tests.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
