package testcases;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class teststores {

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
            stores();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void stores() {
        try {
        
        	    jse = (JavascriptExecutor) driver;
        	    driver.get("https://stores.bestbuy.ca/en-ca/search");
        	    driver.findElement(By.id("q")).click();
        	    driver.findElement(By.id("q")).sendKeys("montreal");
        	    driver.findElement(By.cssSelector(".icon-search")).click();
        	    {
        	      WebElement element = driver.findElement(By.cssSelector(".icon-search"));
        	      Actions builder = new Actions(driver);
        	      builder.moveToElement(element).perform();
        	    }
        	    {
        	      WebElement element = driver.findElement(By.tagName("body"));
        	      Actions builder = new Actions(driver);
        	      builder.moveToElement(element, 0, 0).perform();
        	    }
        	    driver.close();

    
         
        	  } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        teststores test = new teststores();
        test.startup();

    }
}
