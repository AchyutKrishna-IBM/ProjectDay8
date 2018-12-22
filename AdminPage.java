package com.ibm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminPage{
	WebDriver driver;
	WebDriverWait wait;
   @FindBy(xpath="//*[@id='side-menu']/li[6]/a")
   WebElement systemEle;
   @FindBy(xpath="//*[@id='side-menu']/li[6]/ul/li[1]/a")
   WebElement settingsEle;
   @FindBy(xpath="//textarea[@id='address']")
   WebElement addressEle;
   @FindBy(xpath="//input[@id='email']")
   WebElement emailEle;
   @FindBy(xpath="//input[@id='phonenumber']")
   WebElement phoneNumberEle;
   @FindBy(xpath="//button[@title='Save']")
   WebElement saveEle;
   @FindBy(xpath="//a[@title='Logout']")
   WebElement logOutEle;
   public AdminPage(WebDriver driver,WebDriverWait wait)
   {
	   PageFactory.initElements(driver, this);
	   this.driver=driver;
	   this.wait=wait;
   }
   public void clickSystem()
   {
	   systemEle.click();
   }
  public void clickSettings()
  {
	  settingsEle.click();
  }
  public void clearAddressAndInput(String adr)
  {
	  addressEle.clear();
	  addressEle.sendKeys(adr);
  }
  public void clearEmailAndInput(String eml)
  {
	  emailEle.clear();
	  emailEle.sendKeys(eml);
  }
  public void clearPhoneNumbAndInput(String phn)
  {
	  phoneNumberEle.clear();
	  phoneNumberEle.sendKeys(phn);
  }
  public void clickOnSave()
  {
	  saveEle.click(); 
  }
  public void verifyChangedAddress(String chngaddress)
  {
	  Assert.assertTrue(addressEle.getAttribute("value").equals(chngaddress));
  }
  public void verifyChangedEmail(String chngEmail)
  {
	  Assert.assertTrue(emailEle.getAttribute("value").equals(chngEmail));
  }
  public void verifyChangedPhoneNumber(String chngPhone)
  {
	  Assert.assertTrue(phoneNumberEle.getAttribute("value").equals(chngPhone));
  }
  public void clickOnLogOut()
  {
	  logOutEle.click();
  }
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
