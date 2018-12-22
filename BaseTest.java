package com.ibm.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ibm.initialization.WebDriverLaunch;
import com.ibm.pages.AdminPage;
import com.ibm.pages.Login;
import com.ibm.pages.UserPage;
import com.sun.java.swing.plaf.windows.resources.windows;


public class BaseTest extends WebDriverLaunch {
	
	
	   @Test(priority=0)
        public void adminCredentials() throws FileNotFoundException, IOException, InterruptedException
        {
		String url = p.getProperty("url");
		String UserName = p.getProperty("user");
		String Password = p.getProperty("password");
        driver.get(url);
		Login login = new Login(driver,wait);
		login.enterEmailAddress(UserName);
		login.enterPassword(Password);
		login.clickOnLogin();
Thread.sleep(3000);
        }
	   
	   
	  @Test(priority=1)
	    public void changePhoneAddressEmailAndVerifyOnUserPage() throws InterruptedException
	    {
	    	String Address=p.getProperty("address");
	    	String Email=p.getProperty("email");
	    	String Phone=p.getProperty("phone");
	    	
		   AdminPage adm=new AdminPage(driver,wait);
		   adm.clickSystem();
		   adm.clickSettings();
		   adm.clearAddressAndInput(Address);
		   adm.clearEmailAndInput(Email);
		   adm.clearPhoneNumbAndInput(Phone);
		   Thread.sleep(3000);
		   JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("scroll(250, 0)");
		   adm.clickOnSave();
		   Thread.sleep(3000);
		   adm.verifyChangedAddress(Address);
		   adm.verifyChangedEmail(Email);
		   adm.verifyChangedPhoneNumber(Phone);
		   Thread.sleep(3000);
		   adm.clickOnLogOut();
		   String urluser=p.getProperty("url_user");
		   driver.get(urluser);
		   UserPage upge=new UserPage(driver,wait);
		   upge.phoneAndEmailVerificationOnTop(Phone, Email);
		   upge.clickOnContactUsTop();
		   upge.verifyPhoneEmailAddressOfContactUsTop(Phone, Email, Address);
		   upge.FooterAddPhoneEmailVerification(Address, Phone, Email);
		   upge.clickOnContactUsBottom();
		   upge.BottomPhoneEmailAddressVerification(Phone, Email, Address);
		   
				   
		   
	    	
	    	
	    }
}
