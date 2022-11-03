package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IncludeAndExcludeMechanismInMethods {
	@Test
	public void getIncludeMethod()
	{
		System.out.println("Include Method");
	}
	@Test
	public void getExcludeMethod()
	{
		System.out.println("Exclude Method");
	}
	@BeforeMethod
	public void getBeforeMethod()
	{
		System.out.println("Before method");
	}
	@BeforeTest
	public void getBeforeTest()
	{
		System.out.println("Before Test");
	}
	

}
