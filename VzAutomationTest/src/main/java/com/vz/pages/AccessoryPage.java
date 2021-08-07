package com.vz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vz.base.TestBase;

public class AccessoryPage extends TestBase {

	// PageFactory = OR

	@FindBy(xpath = "//a[@sitecat-cta='Batteries']")
	WebElement BatteryLabel;

	@FindBy(xpath = "//a[@sitecat-cta='Chargers']")
	WebElement ChargersLabel;

	@FindBy(xpath = "//a[@sitecat-cta='Adapters & cables']")
	WebElement AdaptersLabel;

	@FindBy(xpath = "//a[@sitecat-cta='Car chargers']")
	WebElement CarsChargerLabel;

	@FindBy(xpath = "//div[@class='Tile__TileContent-sc-kxwdnj-17 fIVXmU']")
	WebElement RandomAccessorySelection;

	@FindBy(xpath = "//div[@class='ContinueCTAComponent__BtnText-sc-142ig1c-9 hPGshB']")
	WebElement AddToCartBTN;

	@FindBy(xpath = "//button[@analyticstrack='offer-not-req-link']")
	WebElement PopUpNotNowLink;

	@FindBy(xpath = "//span[text()='Check out']")
	WebElement PDPCheckout;

	@FindBy(id = "//input[@id='ispu']")
	WebElement ISPUBTN;

	// Initializing the Page Objects
	public AccessoryPage() {

		// To Initialize the @FindBy Using Below
		PageFactory.initElements(driver, this);

	}

	public boolean PDPCheckOutTest() {

		BatteryLabel.click();
		RandomAccessorySelection.click();
		return PDPCheckout.isDisplayed();

	}

	// In order to move next page written method name as Class Name (NextPage
	// Class) Method Name and Returning Next Page
	public ShoppingCart BatterySection() {

		BatteryLabel.click();
		RandomAccessorySelection.click();
		AddToCartBTN.click();

//		if (ISPUBTN.isDisplayed()) {
//			System.out.println("CheckBox is Available");
//			ISPUBTN.click();
//			System.out.println("CheckBox is Clicked");
//		} else {
//			AddToCartBTN.click();
//		}

		return new ShoppingCart();

	}

	public ShoppingCart ChargersSection() {

		ChargersLabel.click();
		RandomAccessorySelection.click();
		AddToCartBTN.click();
		return new ShoppingCart();
	}

	public ShoppingCart AdaptersSection() {

		AdaptersLabel.click();
		RandomAccessorySelection.click();
		AddToCartBTN.click();
		return new ShoppingCart();
	}

	public ShoppingCart CarChargerSection() {

		CarsChargerLabel.click();
		RandomAccessorySelection.click();
		AddToCartBTN.click();
		return new ShoppingCart();
	}

}
