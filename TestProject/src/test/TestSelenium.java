package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSelenium {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/eclipse-java-kepler-SR1-win32-x86_64/WebDriver/chromedriver.exe");
		
		DBConnect connect = new DBConnect();
		connect.getData();
		 
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
			
		String getUrl = connect.getUrl();
		System.out.println(getUrl);
		
		String test = connect.getData();
		
		WebElement searchField;
		searchField = driver.findElement(By.className("gsfi"));
		searchField.sendKeys(test);
		Thread.sleep(5000);
		
		WebElement button;
		button = driver.findElement(By.name("q"));
		button.submit();
		
		driver.quit();
	}
}
