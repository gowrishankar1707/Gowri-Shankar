package assignment1.CheckBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	List<WebElement> checkBoxes= driver.findElements(By.cssSelector("input[name*='checkBoxOption']"));
    	checkBoxes.get(0).click();
    	Assert.assertTrue(checkBoxes.get(0).isSelected());
    	checkBoxes.get(0).click();
    	Assert.assertFalse(checkBoxes.get(0).isSelected());
    	System.out.println("No Of CheckBoxes:"+checkBoxes.size());
    }
}
