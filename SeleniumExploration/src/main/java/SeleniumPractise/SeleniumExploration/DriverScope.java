package SeleniumPractise.SeleniumExploration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println( driver.findElements(By.tagName("a")).size());
		WebElement footerDriver=driver.findElement(By.cssSelector("[id=\"gf-BIG\"]"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver=driver.findElement(By.cssSelector(".gf-t td:nth-child(2)"));
		
		
		List<WebElement> columnLinks=columnDriver.findElements(By.cssSelector("a"));
		Actions action=new Actions(driver);
		for(WebElement link : columnLinks) {
			action.moveToElement(link).keyDown(Keys.CONTROL).click().build().perform();
		}
		
		int windowsSize=driver.getWindowHandles().size();
		if(columnLinks.size() == (windowsSize-1))
			System.out.println("Links are opened correctly");
		else
			System.out.println("Links are not ");

	}

}
