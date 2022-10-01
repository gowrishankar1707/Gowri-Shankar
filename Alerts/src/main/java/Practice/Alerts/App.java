package Practice.Alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	final  String textToEnter="Gowri";
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#name")).sendKeys(textToEnter);
        driver.findElement(By.cssSelector("[value='Alert']")).click();
        Thread.sleep(2000);
        if(driver.switchTo().alert().getText().contains(textToEnter))
        {
        	driver.switchTo().alert().accept();
        }
        else
        {
        	Assert.assertTrue(false);
        	System.out.println("*****	Information Alert is not Displayed with the entered name	*****");
        }
        driver.findElement(By.cssSelector("#name")).sendKeys(textToEnter);
        driver.findElement(By.cssSelector("[value='Confirm']")).click();
        Thread.sleep(2000);
        if(driver.switchTo().alert().getText().contains(textToEnter))
        {
        	driver.switchTo().alert().dismiss();
        } else
        {
        	Assert.assertTrue(false);
        	System.out.println("*****	Dismiss is not Displayed with the entered name	*****");
        }
        
        
    }
}
;