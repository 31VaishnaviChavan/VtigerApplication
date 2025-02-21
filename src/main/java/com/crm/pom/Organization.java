package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {

	public Organization(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement Plus_Org;
		
		@FindBy(xpath = "//input[@name='accountname']")
		private WebElement accountname;
		
		@FindBy(xpath="//input[@class='crmbutton small save']")
		private WebElement save;
		
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement header;
		
		public void plusOrg() {
			Plus_Org.click();
		}
		
        public void accountNAme (String data) {
        	accountname.sendKeys(data);
		}

        public void save() {
	        save.click();
        }
         public WebElement header() {
			return header;
		}
	
}
