import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Hello {

	public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");

			WebDriver driver=new ChromeDriver();
			driver.get("https://www.google.com/");
			WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
			searchBox.sendKeys("Aspire");
			searchBox.submit();
			
			System.out.println("Title:"+driver.getTitle());
	}

}
