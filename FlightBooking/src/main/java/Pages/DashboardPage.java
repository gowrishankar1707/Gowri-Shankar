package Pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardPage {
	private static final String dashboardAssertLink="div[class='middle'] a";
	private static final String currencyDropDownId="#ctl00_mainContent_DropDownListCurrency";
	private static final String passengerDropdownClass=".paxinfo";
	private static final String passengerAdultAddButtonId="#hrefIncAdt";
	private static final String depatureCityDropdownId="#ctl00_mainContent_ddl_originStation1_CTXT";
	private static final String depatureCity="(//li/a[contains(text(),\"Guwahati (GAU)\")]) [1]";
	private static final String destinationCityDropdownId="#ctl00_mainContent_ddl_destinationStation1_CTXT";
	private static final String destinationCity="(//li/a[contains(text(),\"Coimbatore\")]) [2]";
	private static  final String autoSuggesiveDropdownId="input[id='autosuggest']";
//	private static final String depatureDate="//td[@data-month='0'][@data-year='2023']/a[text()='2']";
	private static final String depatureDate=".ui-state-highlight";
	private static final String ReturnDataCalenderPicker=".picker-second";
	private static final String searchButton=".btn-find-flight-home input[type='submit']";
//	private static final String datePickerButton=".ui-state-highlight";
	
	public DashboardPage(WebDriver driver){
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertEquals(driver.findElement(By.cssSelector(dashboardAssertLink)).getText(), "Free Access to InterviewQues/ResumeAssistance/Material");
	}
	public void getStaticCurrencyDropdownElement (WebDriver driver)
	{
		System.out.println("*************************************"
				+ "\n Currency Dropdown"
				+ "\n *************************************");
		
		WebElement element=driver.findElement(By.cssSelector(currencyDropDownId));
		Select staticDropdown=new Select(element);
		staticDropdown.selectByValue("AED");
		Assert.assertEquals(staticDropdown.getFirstSelectedOption().getText(), "AED");
		
		
	}
	public void getPassengerDropDown(WebDriver driver)
	{
		System.out.println("*************************************"
				+ "\n *********** Passenger Dropdown ***********"
				+ "\n *************************************");
		int addingAdultCount=1;
		driver.findElement(By.cssSelector(passengerDropdownClass)).click();
		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.cssSelector(passengerAdultAddButtonId)).click();
			++addingAdultCount;
			}
		
		Assert.assertEquals(driver.findElement(By.cssSelector(passengerDropdownClass)).getText(), addingAdultCount+" Adult");
		driver.findElement(By.cssSelector(passengerDropdownClass)).click();
	}
	
	public void selectDepatureCity(WebDriver driver)
	{
		System.out.println("*************************************"
				+ "\n *********** Depature  city option ***********"
				+ "\n *************************************");
		driver.findElement(By.cssSelector(depatureCityDropdownId)).click();
		driver.findElement(By.xpath(depatureCity)).click();
	}
	public void selectDestinationCity(WebDriver driver)
	{
		System.out.println("*************************************"
				+ "\n ***********  Destincation city option ***********"
				+ "\n *************************************");
		driver.findElement(By.cssSelector(destinationCityDropdownId)).click();
		driver.findElement(By.xpath(destinationCity)).click();
	}
	public void typeInAutoSuggesiveDropDown(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.cssSelector(autoSuggesiveDropdownId)).click();
		driver.findElement(By.cssSelector(autoSuggesiveDropdownId)).sendKeys("papu");
		List<WebElement> autoSuggesiveList= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(2000);
		for(WebElement option:autoSuggesiveList)
		{
			String optionStr=option.getText().toLowerCase();
			if(optionStr.contains("papu"))
			{
				Actions action=new Actions(driver);
				
				action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+option.getText()+"')]/parent::li[@class='ui-menu-item']"))).click().build().perform();
				break;
			}
		}
	}
	public void selectCheckBox(WebDriver driver,String checkBoxType)
	{
		switch(checkBoxType)
		{
		case "FriendsAndFamily":
			driver.findElements(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).get(0).click();
			break;
		case "SeniorCitizen":
			driver.findElements(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).get(0).click();
			break;
		case "Student":
			driver.findElements(By.cssSelector("input[id='ctl00_mainContent_chk_StudentDiscount']")).get(0).click();
			break;
		case "Minor":
			driver.findElements(By.cssSelector("input[id='ctl00_mainContent_chk_Unmr']")).get(0).click();
			break;
		case "IndianArmy":
			driver.findElements(By.cssSelector("input[id='ctl00_mainContent_chk_IndArm']")).get(0).click();
			break;
			
		}
		
	}
	public void selectDepatureDate(WebDriver driver)
	{
//		driver.findElement(By.cssSelector(datePickerButton)).click();
		driver.findElement(By.cssSelector(depatureDate)).click();
		if(driver.findElement(By.cssSelector(ReturnDataCalenderPicker)).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("******************	Second Calender should be disabled. But it is visible ******************");
		}
	}
	public void clickSearchButton(WebDriver driver)
	{
		driver.findElement(By.cssSelector(searchButton)).click();
		System.out.println("Search Button is Clicked");
	}
	

}
