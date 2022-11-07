package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="firstName";
		data[0][1]="firstAge";
		
		data[1][0]="SecondName";
		data[1][1]="secondAge";
		
		data[2][0]="ThirdName";
		data[2][1]="ThirdAge";
		
		return data;
	}
	
	@Test(dataProvider="getData",enabled=false)
	public void printData(String name,String age)
	{
		System.out.println(name);
		
	}
	

}
