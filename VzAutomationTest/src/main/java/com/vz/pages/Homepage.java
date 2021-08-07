/*Author - Mohammed Feroz Ali*/

package com.vz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vz.base.TestBase;

public class Homepage extends TestBase {

	// PageFactory = OR

	@FindBy(xpath = "//button[@id ='gnav20-Shop-L1']")
	@CacheLookup
	WebElement Shop;

	/*
	 * //CacheLookup - It will store in a particular memory, every time whenever we
	 * are interacting with this element instead of from the page it will get the
	 * particular element from the cache. 
	 * Pros - Improve the Speed of the framework and
	 * performance of the script will be improved 
	 * Cons - If the page got refreshed
	 * then the cache memory will get corrupted, in that cases it will give stale element
	 * exception.
	 */

	@FindBy(xpath = "//*[@id='gnav20-Shop-L2-4']")
	WebElement AccessoryBTN;

	@FindBy(xpath = "//*[@id='gnav20-Shop-L3-52']")
	WebElement CategoryPower;

	@FindBy(xpath = "//a[@id='gnav20-Shop-L3-44']")
	WebElement CasesAndProtection;

	@FindBy(xpath = "//img[@alt='Verizon Logo']")
	WebElement Logo;

	// Initializing the Page Objects
	public Homepage() {

		// To Initialize the @FindBy Using Below
		PageFactory.initElements(driver, this);

	}

	public String HomeTitle() {
		return driver.getTitle();

	}

	public boolean VzImageTest() {
		return Logo.isDisplayed();

	}

	// In order to move next page written method name as AccessoryPage (NextPage
	// Class) and Method Name Navigation and Returning Next Page AccessoryPage
	public AccessoryPage NavigationPower() {

		Shop.click();
		AccessoryBTN.click();
		CategoryPower.click();

		return new AccessoryPage();

	}

	public AccessoryPage NavigationCases() {

		Shop.click();
		AccessoryBTN.click();
		CasesAndProtection.click();

		return new AccessoryPage();
	}

}
