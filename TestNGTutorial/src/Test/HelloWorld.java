package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HelloWorld {
	
	@Test
	public void GetFirstFunction() {
		System.out.println("Hello World");
	}
	@BeforeSuite
	public void getBeforeSuite() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void getAfterSuite() {
		System.out.println("After suite");
	}

}
