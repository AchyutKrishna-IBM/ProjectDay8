package com.ibm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserPage 
{
	
WebDriver driver;
WebDriverWait wait;
@FindBy(xpath="/html/body/header/div[1]/div/div[2]/div[1]/a")
WebElement phoneNumberTop;
@FindBy(xpath="/html/body/header/div[1]/div/div[2]/div[2]/a[1]")
WebElement emailTop;
@FindBy(xpath="(//a[text()='Contact Us'])[2]")
WebElement contactUsEleTop;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/div[1]/div[2]")
WebElement phoneNumberMiddle;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div[2]")
WebElement emailMiddle;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/div[3]/div[2]")
WebElement addressMiddle;
@FindBy(xpath="//*[@id='mm-0']/div[6]/div/div/div/div/div[1]/div/div[1]/div[2]/p[1]")
WebElement addressFooter;
@FindBy(xpath="//*[@id='mm-0']/div[6]/div/div/div/div/div[1]/div/div[1]/div[2]/p[2]")
WebElement phoneFooter;
@FindBy(xpath="//*[@id='mm-0']/div[6]/div/div/div/div/div[1]/div/div[1]/div[2]/p[3]/a")
WebElement emailFooter;
@FindBy(xpath="//*[@id='mm-0']/div[6]/div/div/div/div/div[1]/div/div[2]/ul/li[4]")
WebElement contactUsBottom;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]")
WebElement chngedDetailsEle;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/div[1]/div[2]")
WebElement phoneBottom;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div[2]")
WebElement emailBottom;
@FindBy(xpath="//*[@id='mm-0']/div[5]/div/div[2]/div/div[1]/div/div/div/div[1]/div[3]/div[2]")
WebElement addBottom;
public UserPage(WebDriver driver,WebDriverWait wait)
{
	PageFactory.initElements(driver, this);
	this.driver=driver;
	this.wait=wait;
}
public void phoneAndEmailVerificationOnTop(String phne,String email)
{
	Assert.assertTrue(phoneNumberTop.getText().contains(phne));
	Assert.assertTrue(emailTop.getText().contains(email));
	
}
public void clickOnContactUsTop()
{
	contactUsEleTop.click();
}
public void verifyPhoneEmailAddressOfContactUsTop(String phone,String email,String address)
{
	Assert.assertTrue(phoneNumberMiddle.getText().trim().equals(phone));
	Assert.assertTrue(emailMiddle.getText().trim().equals(email));
	Assert.assertTrue(addressMiddle.getText().trim().equals(address));
}
public void FooterAddPhoneEmailVerification(String add,String phon,String eml)
{
	Assert.assertTrue(addressFooter.getText().contains(add));
	Assert.assertTrue(phoneFooter.getText().contains(phon));
	Assert.assertTrue(emailFooter.getText().trim().equals(eml));
}
public void clickOnContactUsBottom()
{
	contactUsBottom.click();
}
public void BottomPhoneEmailAddressVerification(String phneb,String emailB,String addB)
{
	Assert.assertTrue(phoneBottom.getText().trim().equals(phneb));
	Assert.assertTrue(emailBottom.getText().trim().equals(emailB));
	Assert.assertTrue(addBottom.getText().trim().equals(addB));
}








}
