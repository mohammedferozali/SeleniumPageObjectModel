package com.vz.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.vz.base.TestBase;
import com.vz.pages.AccessoryPage;
import com.vz.pages.Checkoutpage;
import com.vz.pages.Homepage;
import com.vz.pages.ShoppingCart;
import com.vz.util.TestUtil;

public class AccessoryBatteriesChargers extends TestBase {

	Homepage Home;
	AccessoryPage Access;
	TestUtil Test;
	String SheetName = "ShippingInformation";
	
	//What is Log? - Capturing Info/Activities at the time of program execution/
	//Types of Logs :
	  //1. info
	  //2. warn
	  //3. debug
	  //4. fatal
	
	//how to generate the logs? : use Apache log4j API (log4j.jar)
	//how it works? : It reads log4j configuration from log4j.properties file
	//where to create: create inside resources folder
	
	//log4j initialization
    Logger log = Logger.getLogger(AccessoryBatteriesChargers.class);
	
	
	// Super Keyword will call Super Class Constructor Method
	public AccessoryBatteriesChargers() {

		super();
	}

	// Testcases should be separated
	// Before each testcase -- Launch Browser and Perform step 1 to specific step
	// @Test - Execute Testcase
	// After each Testcase -- Close the browser

	@BeforeMethod
	public void setup() {

		Initialization();
		Home = new Homepage();
		Test = new TestUtil();

	}

	@DataProvider
	public Object[][] getShippingInformationTestData() {
		// 2 Dimentional Array
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}

	@Test(priority = 1)
	public void HomeTitle() {
		
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** HomeTitle *****************************************");

		log.info("Checking HomeTitle is Available or Not");
		
		String title = Home.HomeTitle();
		// Using Assert to Validate the Title
		Assert.assertEquals(title, "Verizon: Wireless, Internet, TV and Phone Services | Official Site");
			
		log.warn("Hey this just a warning message");
		log.fatal("Hey this is just fatal error message");
		log.debug("This is debug message");
		
		log.info("****************************** Ending test case *****************************************");
		log.info("****************************** HomeTitle *****************************************");

	}

	@Test(priority = 2)
	public void VzLogoTest() {

		boolean flag = Home.VzImageTest();
		// Another Type of Assert which will show True or False
		Assert.assertTrue(flag);
	}

	@Test(priority = 3, dataProvider = "getShippingInformationTestData", retryAnalyzer = com.vz.util.MyRetry.class)
	public void ShopBattery(String CompanyName, String FirstName, String LastName, String Address, String Apartment,
			String Zipcode, String EmailID, String Phonenumber) {

		Access = Home.NavigationPower();
		Access.BatterySection();
		ShoppingCart Shop = new ShoppingCart();
		Shop.Cart();
		Checkoutpage Check = new Checkoutpage();
		Check.ShippingInformation(CompanyName, FirstName, LastName, Address, Apartment, Zipcode, EmailID, Phonenumber);
		Test.ScrollDown();
		Check.ShippingMethod();
		Check.BillingAddress();
		Test.ScrollUp();
		Check.Editcart();

	}

	@Test(priority = 4)
	public void ShopChargers() {

		Access = Home.NavigationPower();
		Access.ChargersSection();
		ShoppingCart Shop = new ShoppingCart();
		Shop.Cart();

	}

	@Test(priority = 5)
	public void ShopAdapters() {

		Access = Home.NavigationPower();
		Access.AdaptersSection();
		ShoppingCart Shop = new ShoppingCart();
		Shop.Cart();

	}

	@Test(priority = 6)
	public void ShopCarChargers() {

		Access = Home.NavigationPower();
		Access.CarChargerSection();
		ShoppingCart Shop = new ShoppingCart();
		Shop.Cart();

	}

	@Test(priority = 7)
	public void PDPCheckoutTest() {

		Access = Home.NavigationPower();
		Assert.assertTrue(Access.PDPCheckOutTest());
		System.out.println("Checkout is Available on PDP");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
		
		log.info("****************************** Browser is closed *****************************************");

	}

}
