package SeleniumPractise.SeleniumExploration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#checkBoxOption3")).click();
		String optionText = driver.findElement(By.xpath("//input[@id='checkBoxOption3']/parent::label")).getText();

		Select select = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		select.selectByVisibleText(optionText);

		driver.findElement(By.cssSelector("#name")).sendKeys(optionText);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains(optionText)) {
			System.out.println(optionText);
			driver.switchTo().alert().accept();
		} else
			System.out.println(false);

	}

}
