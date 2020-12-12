package testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testsearch {

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
            driver.get("https://www.bestbuy.ca/en-ca/");
            search();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void search() {
        try {
        	driver.get("https://www.bestbuy.ca/en-ca/");
           
            driver.findElement(By.name("search")).click();
            driver.findElement(By.name("search")).sendKeys("iphone");
            driver.findElement(By.cssSelector(".searchIcon_2vafY")).click();
            {
              WebElement element = driver.findElement(By.cssSelector(".searchButton_T4-BG"));
              Actions builder = new Actions(driver);
              builder.moveToElement(element).perform();
            }
            Thread.sleep(2000);
            driver.close();



        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        testsearch test = new testsearch();
        test.startup();

    }
}