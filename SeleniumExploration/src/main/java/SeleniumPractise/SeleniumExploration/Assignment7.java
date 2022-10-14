package SeleniumPractise.SeleniumExploration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		/********	 IMPORTANT NOTE **************
		 * 
		 * HERE INSIDE THE DIV FIELD SET ELEMENT IS THERE
		 * SO SELENIUM CANT ABLE TO SEARCH THE TR INSIDE DIV DIRECTLY BECAUSE OF FIELD SET RESIDE BETWEEN DIV AND TABLE
		 * SO WE HAVE TO CALL THE HIERARCHY FROM DIV->FIELDSET->TABLE->TR
		 * OR
		 * TABLE->TR
		 * */
//		List<WebElement> tableId=driver.findElements(By.cssSelector(".left-align"));
		WebElement tableId=driver.findElement(By.cssSelector("#product"));
		
//		js.executeScript("arguments[0].scrollIntoView();", tableId);
		js.executeScript("window.scroll(0,500);");
		
		List<WebElement> table=tableId.findElements(By.cssSelector("tr"));
		
		System.out.println("No.of.Rows"+table.size());
		System.out.println("No.of.Columns"+driver.findElements(By.cssSelector(".left-align th")).size());
		System.out.println("Second Row:"+table.get(1).getText());
		

	}

}
