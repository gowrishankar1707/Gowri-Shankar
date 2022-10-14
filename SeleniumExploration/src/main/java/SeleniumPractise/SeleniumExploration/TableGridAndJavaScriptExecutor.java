package SeleniumPractise.SeleniumExploration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableGridAndJavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement tableDiv=driver.findElement(By.cssSelector(".tableFixHead"));
		js.executeScript("arguments[0].scrollIntoView();",tableDiv);
		
		List<WebElement> amounts=tableDiv.findElements(By.cssSelector("td:nth-child(4)"));
		
		int total = 0;
		
		for(WebElement amount:amounts)
		{
			total=total+Integer.parseInt(amount.getText());
		}
		
		int sumValue=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		if(total == sumValue)
		{
			System.out.println("Total is matching");
		}
		else
		{
			System.out.println("Total is not matching");
		}
		
		

	}

}
