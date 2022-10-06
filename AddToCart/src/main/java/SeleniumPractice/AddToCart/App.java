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
    	if(args.length > 0)
    	{
    		System.out.println(args[0]+"....."+args[1]);
    	}
//    	String[] itemsNeeded= {"Brinjal","Capsicum"};
//    	
//    	//button[text()="ADD TO CART"]
//        System.setProperty("webdriver.chrome.driver", "D:\\\\ChromeDriver\\\\chromedriver.exe");
//        
//        WebDriver driver= new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//        List<WebElement> listOfproducts= driver.findElements(By.cssSelector("h4[class='product-name']"));
//        int count=0;
//        
//       for(int i=0;i<listOfproducts.size();i++)
//       {
//    	   String[] productName=listOfproducts.get(i).getText().split(" - ", 2);
//    	   List<String> productsNeeded=Arrays.asList(itemsNeeded);
//    	   if(productsNeeded.contains(productName[0]))
//    	   {
//    		   System.out.println(i);
//   		   driver.findElements(By.cssSelector(".product-action button[type='button']")).get(i).click();
////  not suggested    		   driver.findElement(By.xpath("//div[@class='product']/h4[contains(text(),"+listOfproducts.get(i).getText()+")]/parent::div/div[@class='product-action']/button")).click();
////  not suggested  		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'ADDED')]")));
//    		   ++count;
//    		   if(count == productsNeeded.size())
//    			   break;
//    	   }
//    	   
//       }
        
    }
}
