package net.Phptravels.phptravels.net.Phptravels.phptravels;
import org.testng.annotations.Test;
import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.Hotels;
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

public class TestHotel extends Browser{
  
	
	
	public TestHotel() throws IOException {
		
	}
	Hotels h=new Hotels();
	boolean result;

@BeforeTest
public void initialize() {
	  log.info("executing hotels page....");
	  h.launchBrowser();
	  h.Maximize(driver);
}
@Test
public void runtest() throws InterruptedException{
	h.by_city_name();
	h.pick_checkIn();
	h.pick_checkOut();
	h.pick_guests();
	 
}
@AfterMethod
public void screen_shot() throws IOException
{
	  result=Compare.validateResultPage(driver);
	  Assert.assertTrue(true,"this page is not the results page");
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(source, new File("./Screenshot/hotels.png"));
	  log.info("taking screensht");
}

@AfterTest
public void close() {
	  h.Quit(driver);
      }
}
