package testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcart {

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
            cart();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void cart() {
        try {
        	driver.get("https://www.bestbuy.ca/en-ca");
            
            driver.findElement(By.name("search")).click();
            driver.findElement(By.name("search")).sendKeys("cart");
            driver.findElement(By.linkText("Cart")).click();
            driver.close();


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void thread(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {

        testcart test = new testcart();
        test.startup();

    }
}