package testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testlogin {

    WebDriver driver;
    JavascriptExecutor jse;

    public void startup() {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("https://www.ebay.ca/");
            loginPage();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void loginPage() {
        try {
            driver.get("https://www.bestbuy.ca/en-ca/");
            {
              WebElement element = driver.findElement(By.cssSelector(".accountIcon_1BPh2"));
              Actions builder = new Actions(driver);
              builder.moveToElement(element).perform();
            }
            driver.findElement(By.cssSelector(".accountIcon_1BPh2")).click();
            driver.findElement(By.cssSelector(".create-account-link > span")).click();
            driver.findElement(By.id("firstName")).click();
            driver.findElement(By.id("firstName")).sendKeys("test");
            driver.findElement(By.id("lastName")).sendKeys("test");
            driver.findElement(By.id("email")).sendKeys("test@gmail.com");
            driver.findElement(By.id("newsletter")).click();
            
            driver.close();


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        testlogin test = new testlogin();
        test.startup();

    }
}