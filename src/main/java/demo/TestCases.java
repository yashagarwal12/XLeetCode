package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    String two_sum_url;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
       
        driver.get("https://www.leetcode.com");
        try{
            wait.until(ExpectedConditions.urlContains("leetcode"));
            System.out.println(" Test case 01:Passed-URL contains leetcode.");
        } catch(Exception E) {
            System.out.println("Test case 01:Failed-URL contains leetcode.");
        }
        System.out.println("END Test case: testCase01");
        System.out.println("---------------------------------------------------");
    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.leetcode.com");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='product']/div/div/div[1]/div/a"))).click().build().perform();

    try{
        wait.until(ExpectedConditions.urlContains("problemset"));
        System.out.println(" Test case 02: Passed--URL contains problemset.");
    } catch(Exception E) {
        System.out.println("Test case 02: Failed--URL contains problemset.");
    }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']")));
        action.moveToElement(driver.findElement(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']//div[@role='rowgroup']/div[@role='row'][6]"))).build().perform();


        List<WebElement> list=driver.findElements(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']//div[@role='rowgroup']/div[@role='row']/div[@role='cell'][2]//a"));
         List<String> expected=new ArrayList<>();
        expected.add("Two Sum");
        expected.add("Add Two Numbers");
        expected.add("Longest Substring Without Repeating Characters");
        expected.add("Median of Two Sorted Arrays");
        expected.add("Longest Palindromic Substring");
try{
        try{
        for(int i=1; i<=5; i++){
            System.out.println(list.get(i).getText());
            Thread.sleep(1000);
        }
    }catch(Exception E){
        System.out.println("Failed:Test case 02: Failed to print first 5 problem details");
    }

            for(int i=1; i<=5; i++){
                if(list.get(i).getText().contains(expected.get(i-1))){

                continue;
                }
        else{
            System.out.println("Failed:Test case 02: Problem Title Not Matched");
            break;
        }
    }
    System.out.println("Passed:Test case 02: Problem Title Matched");
}
    catch(Exception E){
        System.out.println("Failed:Test case 02: Problem Title Not Matched");
    }
     System.out.println("End Test case: testCase02");
     System.out.println("---------------------------------------------------");

    }
    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.leetcode.com");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='product']/div/div/div[1]/div/a"))).click().build()
                .perform();
       
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']")));
        action.moveToElement(driver.findElement(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']//div[@role='rowgroup']/div[@role='row'][3]"))).build().perform();

        List<WebElement> list=driver.findElements(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']//div[@role='rowgroup']/div[@role='row']/div[@role='cell'][2]//a"));

        for(WebElement ele:list){
            if(ele.getText().contains("Two Sum")){
                ele.click();
                break;
            }
        }

        boolean status=driver.getCurrentUrl().contains("two-sum");
        if(status){
            System.out.println("Passed:Test case 03: Problem URL is correct");
        }
        else{
            System.out.println("Failed:Test case 03: Problem URL Not correct");
        }
        System.out.println("End Test case: testCase03");
        System.out.println("---------------------------------------------------");
    }

    public void testCase04() throws InterruptedException {

        System.out.println("Start Test case: testCase04");
        driver.get("https://www.leetcode.com");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='product']/div/div/div[1]/div/a"))).click().build().perform();
       
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']")));
        action.moveToElement(driver.findElement(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']//div[@role='rowgroup']/div[@role='row'][3]"))).build().perform();

        List<WebElement> list2=driver.findElements(By.xpath("//div[@class='-mx-4 transition-opacity md:mx-0']/div[@role='table']//div[@role='rowgroup']/div[@role='row']/div[@role='cell'][2]//a"));
        Thread.sleep(2000);
        for(WebElement ele:list2){
            if(ele.getText().contains("Two Sum")){
                ele.click();
                break;
            }
        }
       
      
        try{
            wait.until(ExpectedConditions.urlContains("two-sum"));
            System.out.println("Passed:Test case 04: URL contain two_sum");
            }
            catch(Exception E){
                System.out.println("Failed:Test case 04: URL don't contain two_sum");
            }

        action.click(driver.findElement(By.xpath("//div[@id='submissions_tab']//div[text()='Submissions'][1]"))).build().perform();
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Register or Sign In']")));
        if(driver.findElement(By.xpath("//a[text()='Register or Sign In']")).getText().contains("Register or Sign In"))
        System.out.println("Passed:Test case 04: Register or Login Button present");
        }
        catch(Exception E){
            System.out.println("Failed:Test case 04: Register or Login Button Not present");
        }
        System.out.println("End Test case: testCase04");
    }
    



}
