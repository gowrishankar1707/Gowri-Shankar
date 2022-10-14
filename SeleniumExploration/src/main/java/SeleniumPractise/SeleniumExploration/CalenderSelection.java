package SeleniumPractise.SeleniumExploration;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.path2usa.com/travel-companions");
//		Actions action=new Actions(driver);
//		action.moveToElement(driver.findElement(By.cssSelector(".elementor-field-group button[type='submit']")) ).build().perform();
		WebElement datePicker=driver.findElement(By.cssSelector("#form-field-travel_comp_date"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", datePicker);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datePicker.click();
		
		WebElement monthElement=driver.findElement(By.cssSelector(".cur-month"));
		String month=monthElement.getText();
		month=month+" "+driver.findElement(By.cssSelector(".numInput.cur-year")).getAttribute("value");
		String userMonthYear="November 2023";
		String userDate="7";
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		while(!userMonthYear.equals(month))
		{
//			try {
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			monthElement=driver.findElement(By.cssSelector(".cur-month"));
			month=monthElement.getText();
			month=month+" "+driver.findElement(By.cssSelector(".numInput.cur-year")).getAttribute("value");
//			}catch(Exception Ex)
//			{
//				monthElement=driver.findElement(By.cssSelector(".cur-month"));
//				month=monthElement.getText();
//				month=month+" "+driver.findElement(By.cssSelector(".numInput.cur-year")).getAttribute("value");
//				
//			}
			
		}
		
		List<WebElement> dates=driver.findElements(By.cssSelector(".flatpickr-day"));
		for(WebElement date: dates)
		{
			if(userDate.equals(date.getText()))
			{
				date.click();
				break;
			}
		}
		
		

	}

}
