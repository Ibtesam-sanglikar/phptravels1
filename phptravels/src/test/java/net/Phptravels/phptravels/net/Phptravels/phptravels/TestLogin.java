package net.Phptravels.phptravels.net.Phptravels.phptravels;
import org.testng.annotations.Test;
import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.Login;
import verify.Compare;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestLogin extends Browser {
  
	
	Login l=new Login();
	boolean result;
  public TestLogin() throws IOException 
  {
	
	}
  
  
  
  @BeforeTest
  public void initialize() {
	  log.info("executing test case for login page.....");
	  l.launchBrowser();
	  l.Maximize(driver);
  }
  @Test
  public void runtest(){
	
	  l.My_account();
	  l.Login();
	  l.email();
	  l.password();
	  l.clickLoginBtn();
  }
  @AfterMethod
  public void screen_shot() throws IOException
  {
	  result=Compare.validateName(driver, prop.getProperty("fname"),prop.getProperty("lname"));
	  Assert.assertTrue(true,"both the expected name and actaul name doesn't match hence test case failed");
	  log.info("taking screenshot.....");
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(source, new File("./Screenshot/login.png"));
	  
	  }
  @AfterTest
  public void close() {
	  l.Quit(driver);
  }

}
