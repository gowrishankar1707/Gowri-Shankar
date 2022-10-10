package SeleniumPractise.SeleniumWindowHandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		String parentWindow=driver.getWindowHandle();
		
		driver.findElement(By.cssSelector(".example a")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itrWindow=windows.iterator();
		while(itrWindow.hasNext())
		{
			String childwindow=itrWindow.next();
			if(!parentWindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				break;
			}
		}
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		

	}

}
