package Sridevi.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class training {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
	            "D:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://chromedriver.chromium.org/downloads");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	driver.close();

	}

}
