package CommonUtilis;

import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class webdriver {
	public WebDriver driver;
	public  WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\ChromeDriver\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
		
		}
	

}
