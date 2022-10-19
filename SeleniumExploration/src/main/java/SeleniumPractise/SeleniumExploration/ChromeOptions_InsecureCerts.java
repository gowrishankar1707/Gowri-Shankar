package SeleniumPractise.SeleniumExploration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions_InsecureCerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> optionValue=new ArrayList<String>();
		optionValue.add("incognito");
		optionValue.add("start-maximized");
		optionValue.add("disable-infobars");
		ChromeOptions options=new ChromeOptions();
		options.addArguments(optionValue);
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
