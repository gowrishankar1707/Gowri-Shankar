package Sridevi.Selenium;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://demo.guru99.com/test/guru99home/");
    	System.out.println(driver.getTitle());
    	System.out.println(driver.geturl());
    }
}
