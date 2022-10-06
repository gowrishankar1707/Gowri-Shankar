package SeleniumPractice.synchrizationAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Hello world!
 *
 */
public class App {
	static WebDriverWait webDriverWait;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> credentials = driver.findElements(By.cssSelector(".form-group p b i"));
		String userName = credentials.get(0).getText();
		String password = credentials.get(1).getText();
		driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(userName);
		driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()=' User']/following-sibling::span[@class='checkmark']")).click();

		waitFunc(webDriverWait, By.cssSelector("#okayBtn")).click();
		Select userRole=new Select(driver.findElement(By.cssSelector(".form-group select")));
		userRole.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		String productLandingPageAssertion=waitFunc(webDriverWait,By.cssSelector("h1")).getText();
		Assert.assertEquals(productLandingPageAssertion, "Shop Name");
		int size=returnNoOfElements(driver,By.cssSelector("app-card-list app-card"));
		for(int i=0;i<size;i++) {
			driver.findElements(By.cssSelector("app-card-list app-card button")).get(i).click();
		}
//		String[] cartSize=driver.findElement(By.cssSelector("ul[class='navbar-nav ml-auto'] li a")).getText().trim().split("\\s+)(");
//				
//		System.out.println(cartSize[2]);
//		Assert.assertEquals("Checkout ( "+size, cartSize[0]);
		
		driver.findElement(By.cssSelector("ul[class='navbar-nav ml-auto'] li a")).click();
		//btn btn-success
		waitFunc(webDriverWait,By.cssSelector(".btn.btn-success"));

	}

	public static WebElement waitFunc(WebDriverWait wait, By by) {

		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}
	public static int returnNoOfElements(WebDriver driver,By locator) {
		List<WebElement> elements=driver.findElements(locator);
		return elements.size();
		
	}
}
