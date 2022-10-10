package SeleniumPractise.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
        System.out.println( driver.findElement(By.cssSelector("#draggable")).getText());
        Actions action=new Actions(driver);
        WebElement source=driver.findElement(By.cssSelector("#draggable"));
        WebElement target=driver.findElement(By.cssSelector("#droppable"));
        action.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();
        String mainPageHeading=driver.findElement(By.cssSelector("h1")).getText();
        if(mainPageHeading.equals("Droppable"))
        	System.out.print(true);
        else
        	System.out.println(false);
        
        
    }
}
