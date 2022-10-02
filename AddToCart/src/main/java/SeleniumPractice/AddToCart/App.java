package SeleniumPractice.AddToCart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String[] itemsNeeded= {"Brinjal","Capsicum"};
    	
    	//button[text()="ADD TO CART"]
        System.setProperty("webdriver.chrome.driver", "D:\\\\ChromeDriver\\\\chromedriver.exe");
        
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> listOfproducts= driver.findElements(By.cssSelector("h4[class='product-name']"));
        int count=0;
        
       for(int i=0;i<listOfproducts.size();i++)
       {
    	   String[] productName=listOfproducts.get(i).getText().split(" - ", 2);
    	   List<String> productsNeeded=Arrays.asList(itemsNeeded);
    	   if(productsNeeded.contains(productName[0]))
    	   {
    		   System.out.println(i);
    		   driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click();
    		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'ADDED')]")));
    		   ++count;
    		   if(count == productsNeeded.size())
    			   break;
    	   }
    	   
       }
        
    }
}
