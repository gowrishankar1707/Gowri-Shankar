package SeleniumPractise.SeleniumWindowHandles;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			String child=it.next();
			if(!parentWindow.equals(child)) {
				driver.switchTo().window(child);
				break;
			}
		}
		String heading=driver.findElement(By.cssSelector(".im-para.red strong")).getText();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector("#username")).sendKeys(heading.trim());
    }
}
