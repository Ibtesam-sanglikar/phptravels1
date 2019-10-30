package net.Phptravels.phptravels.net.Phptravels.phptravels;
import org.testng.annotations.Test;
import net.Phptravels.phptravels.Browser;
import net.Phptravels.phptravels.Tours;
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

public class TestTour extends Browser {
    public TestTour() throws IOException {}

	Tours t=new Tours();
	boolean result;
	@BeforeTest
	public void initialize() throws IOException 
	{
	  log.info("executing tours page");
	  launchBrowser();
	  Maximize(driver);
	 }
	@Test
	public void runtest() throws InterruptedException, IOException{
	
		t.tours();
		t.by_city_name();
		t.select_tourtype();
		t.pick_checkIn();
		t.select_guest();
		t.click_search();
		}
	  
	@AfterMethod
	  public void screen_shot() throws IOException
	  { 
		  result=Compare.validateBookingOption(driver);
	      Assert.assertTrue(true,"this page is not the tour results page");
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(source, new File("./Screenshot/tours.png"));
		  log.info("taking screenshot");
	  }
	
	@AfterTest
	  public void close() {
		  Quit(driver);
	  }
	}
