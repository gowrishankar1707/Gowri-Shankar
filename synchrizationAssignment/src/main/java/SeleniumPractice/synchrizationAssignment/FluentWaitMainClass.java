package SeleniumPractice.synchrizationAssignment;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitMainClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		By startButton=By.cssSelector("[id='start'] button");
		driver.findElement(startButton).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
		
		WebElement e=wait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement hw=driver.findElement(By.cssSelector("[id='finish'] h4"));
//				String hwStyle=hw.getCssValue("display");
//				System.out.println(hwStyle);
				if(hw.isDisplayed())
					return hw;
				else
					return null;
				
			}

		});
		
		System.out.println(e.getText());

	}

}
