package net.Phptravels.phptravels.net.Phptravels.phptravels;

import org.testng.annotations.Test;

import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.SignUp;
import verify.Compare;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TesSignUp extends Browser{
	SignUp s=new SignUp();
	boolean result;
	public TesSignUp() throws IOException {}

	
	@BeforeTest
	public void initialize() throws IOException
	{
		log.info("executing test case for signup page.....");
		s.launchBrowser();
		s.Maximize(driver);
	}
	
	@Test
	public void runtest() throws IOException
	{
		
		s.My_account();
		s.SignUp();
		s.firstname();
		s.lastname();
		s.mobileNumber();
		s.email();
		s.password();
		s.confirmPassword();
		s.gotIt();
		s.submit();
	}
	@AfterMethod
	  public void screen_shot() throws IOException
	  {
		  //validate
		  Compare.validateForErrors(driver);
		  
		  
		  //taking screenshot
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(source, new File("./Screenshot/signup.png"));
		  log.info("taking screenshot");
	  }
	
	@AfterTest
	public void close() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		s.Quit(driver);
	}
   
}
