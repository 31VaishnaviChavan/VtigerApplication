package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.ReadFromProperties;
import com.crm.fileUtility.ReadFromPropertyFile;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

public class preCondition {

	public static WebDriver driver = null;
	@BeforeClass
	public void preCondition() throws IOException {
		String browser = ReadFromProperties.getData("browser");
		String url = ReadFromProperties.getData("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		
	}
	@BeforeMethod
	public void login() throws IOException {
		String username =ReadFromPropertyFile.propertyData("username");
		String password = ReadFromPropertyFile.propertyData("password");
		//com.crm.pom
		LoginPage lgn = new LoginPage(driver);
		lgn.username(username);
		lgn.pass(password);
		lgn.submit();
		
	}
	
	@AfterMethod
	public void logout() {
	
		HomePage hp= new HomePage(driver);
		hp.profile1();
		hp.out(null);
		
	}
	
	public void postCondition() {
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}
