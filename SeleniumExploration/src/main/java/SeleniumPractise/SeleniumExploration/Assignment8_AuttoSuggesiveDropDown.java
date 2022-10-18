package SeleniumPractise.SeleniumExploration;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8_AuttoSuggesiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String searchCountryKeyword="india";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Ind");
		WebElement autoCompleteTextBox=driver.findElement(By.cssSelector("#autocomplete"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-1")));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-1"))));
		
		
		/********************************Solution 2 *********************/
		Actions action=new Actions(driver);
		while(true)
		{
			autoCompleteTextBox=driver.findElement(By.cssSelector("#autocomplete"));
			String ui=autoCompleteTextBox.getAttribute("value").toLowerCase();
			if(!ui.equals(searchCountryKeyword))
				
				action.moveToElement(autoCompleteTextBox).keyDown(Keys.DOWN).build().perform();
			else
				break;
		}
		System.out.println(autoCompleteTextBox.getAttribute("value"));
		
		
		/************* Solution 1*************************/
//		List<WebElement> autoSuggesiveDropdown = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
//		
//		for(WebElement list:autoSuggesiveDropdown) {
//			if(list.getText().toLowerCase().equals(searchCountryKeyword))
//			{
//				list.click();
//				break;
//			}
//		}
//		
//		String autoSuggesiveInputValue=driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value").toLowerCase();
//		if(autoSuggesiveInputValue.equals(searchCountryKeyword))
//		{
//			System.out.println("Test is passed");
//		}
//		else
//		{
//			System.out.println("Test is failed");
//		}
		
		
		
		

	

//		WebElement ui = driver.findElement(By.cssSelector("#ui-id-1"));
//		if (ui.isDisplayed()) {
//			List<WebElement> autoSuggesiveDropdown = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
//			
//			for(int i=0;i<autoSuggesiveDropdown.size();i++)
//			{
//				
//				if(autoSuggesiveDropdown.get(i).getText().toLowerCase().equals("india"))
//				{
//					System.out.println("Hello");
//					driver.findElements(By.cssSelector(".ui-menu-item")).get(i).click();
//					break;
//				}
//			}
//		}

	}

}
