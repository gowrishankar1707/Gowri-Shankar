package LinkGoogleClassTeacher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkGoogleClass {
	
	public static void LoginWithRealize(WebDriver driver) throws InterruptedException 
	{
		try
		{
		
		/**************************	Get the Savvas Website*******************/
		driver.get("https://nightly-www.savvasrealizedev.com/index.html#/");
		Thread.sleep(3000);
		/*************************** ClickLogin*****************************/
		driver.findElement(By.xpath("//a[@id=\"signIn\"]")).click();
		Thread.sleep(6000);
		/************************** Enter Username and Password ********************/
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("tch_3991272545928_realizegc");//userName
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("testing123$");//password
		/************************** Click Login And wait for dashboard ********************/
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Thread.sleep(35000);
		
		
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
        WebElement settingDropDown=(WebElement) jse.executeScript ("return document.querySelector('cel-platform-navbar').shadowRoot.querySelector('header > div > .platform__navbar--profileUtility.hydrated').shadowRoot.querySelector('div > button#usernameDropdown')");
		
		
		
		System.out.println("*****************************************"+settingDropDown.getText()+"*********************************");
		
		
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", settingDropDown);
		 
		 Thread.sleep(10000);
		
		WebElement profileButton=(WebElement) jse.executeScript("return document.querySelector('cel-platform-navbar').shadowRoot.querySelector('header > div > .platform__navbar--profileUtility.hydrated').shadowRoot.querySelector('div > .utility__item--menuRelativeContainer > ul > li > #settings')");
		
		/********************************** Clicking settings ************************************/
		
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", profileButton);
		 
		 Thread.sleep(25000);
		 /********************************** scroll down  ************************************/
		 JavascriptExecutor je = (JavascriptExecutor)driver;
		 je.executeScript("window.scrollBy(0,750)");
		 /********************************** Clicking Import Class Button ************************************/
		 driver.findElement(By.xpath("//button[@class='page-banner-button-text ng-binding kb-mode']")).click();
		 Thread.sleep(25000);
		}
		catch(Exception ex)
		{
			System.out.println("Error message: "+ex.getMessage());
			System.out.println("Error message: "+ex.getStackTrace());
			
		}
		
		
		
		
	}

}
