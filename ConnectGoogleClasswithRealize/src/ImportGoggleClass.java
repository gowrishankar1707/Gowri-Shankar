import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import LinkGoogleClassTeacher.LinkGoogleClass;


public class ImportGoggleClass {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		LinkGoogleClass.LoginWithRealize(driver);
		
		
	
		
		
		
		

	}

}
