
package practice.FlightBooking;
import org.openqa.selenium.*;
import Pages.DashboardPage;
import CommonUtilis.webdriver;



/**
 * Hello world!
 *
 */
public class App 
{
	 
    public static void main( String[] args )
    {
    	try {
    	WebDriver driver;
       webdriver webDriver=new webdriver();
       driver=webDriver.getDriver();
       DashboardPage dashboardPage=new DashboardPage(driver);
       dashboardPage.getStaticCurrencyDropdownElement(driver);
       dashboardPage.getPassengerDropDown(driver);
       dashboardPage.selectDepatureCity(driver);
       dashboardPage.selectDestinationCity(driver);
       dashboardPage.selectDepatureDate(driver);
       //dashboardPage.typeInAutoSuggesiveDropDown(driver);
       dashboardPage.selectCheckBox(driver, "FriendsAndFamily");
       dashboardPage.clickSearchButton(driver);
       driver.findElement(By.cssSelector("")).is
    	}
    	catch(Exception ex)
    	{
    		System.out.println("********************************************\n"+ex.getMessage()+"\n********************************************");
    	}
       
    }
}
