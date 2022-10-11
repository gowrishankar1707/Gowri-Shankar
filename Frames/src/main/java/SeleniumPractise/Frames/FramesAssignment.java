package SeleniumPractise.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		By topFrame=By.cssSelector("[name='frame-top']");
		By middleFrame=By.cssSelector("[name=\"frame-middle\"]");
		driver.switchTo().frame(driver.findElement(topFrame));
		driver.switchTo().frame(driver.findElement(middleFrame));
		
		By middleDivId=By.cssSelector("#content");
		System.out.println( driver.findElement(middleDivId).getText());
		
		

	}

}
