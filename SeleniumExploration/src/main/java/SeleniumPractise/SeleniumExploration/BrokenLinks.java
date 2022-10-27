package SeleniumPractise.SeleniumExploration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SoftAssert softAssert=new SoftAssert();
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> URLs=driver.findElements(By.cssSelector("#gf-BIG .gf-t a"));
		driver.manage().co
		List<String> URLsAsString = new ArrayList<String>();
		for(WebElement URL: URLs)
		{
//			URLsAsString.add(URL.getAttribute("href").toString());
			
			softAssert.assertTrue((getStatusCode(URL.getAttribute("href").toString()) < 400), "This link    "+URL+"  is broken");
		}
		
		
		
//		for (String URL : URLsAsString) {
//			softAssert.assertTrue((getStatusCode(URL) < 400), "This link    " + URL + "  is broken");
//
////			if( getStatusCode(URL) >= 400)
////			{
////				System.out.println("This link    "+URL+"  is broken");
////			}
//		}
		
		softAssert.assertAll();

	}
	private static int getStatusCode(String URL) throws IOException
	{
		URLConnection URLconnection= new URL(URL).openConnection();
		URLconnection.connect();
		return ((HttpURLConnection) URLconnection).getResponseCode();
		
	}

}
