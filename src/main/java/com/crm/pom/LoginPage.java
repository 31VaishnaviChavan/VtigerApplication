package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//create constructor
	public  LoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement email;
	
	@FindBy(name ="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement login;
	
	public void username(String data) {
		email.sendKeys("admin");
	}
	
	public void pass(String data) {
		password.sendKeys("root");
	}
	public void submit() {
		login.click();
	}
}

