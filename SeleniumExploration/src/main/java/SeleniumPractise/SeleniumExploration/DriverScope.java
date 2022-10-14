package SeleniumPractise.SeleniumExploration;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		
		String keys= Keys.chord(Keys.CONTROL,Keys.ENTER);
		Actions action=new Actions(driver);
		for(WebElement link : columnLinks) {
//			action.moveToElement(link).keyDown(Keys.CONTROL).click().build().perform();
			link.sendKeys(keys);
		}
		
		int windowsSize=driver.getWindowHandles().size();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> windowsIterator=windows.iterator();
		if(columnLinks.size() == (windowsSize-1))
			System.out.println("Links are opened correctly");
		else
			System.out.println("Links are not ");
		
		String parentTitle=driver.getTitle();
		
		int count=0;
		
		while(windowsIterator.hasNext())
		{ 
			count++;
			driver.switchTo().window(windowsIterator.next());
			if(count>1)
				System.out.println(driver.getTitle());
		}

	}

}
