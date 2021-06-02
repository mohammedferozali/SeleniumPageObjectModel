package com.vz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vz.base.TestBase;

public class ShoppingCart extends TestBase {

	// PageFactory = OR

	@FindBy(xpath = "//button[@analyticstrack='checkout-cta']")
	WebElement CheckoutBTN;

	@FindBy(xpath = "//a[@analyticstrack='checkout-as-guest-cta']")
	WebElement CheckoutAsGuest;

	// Initializing the Page Objects
	public ShoppingCart() {

		// To Initialize the @FindBy Using Below
		PageFactory.initElements(driver, this);

	}

	// In order to move next page written method name as Class Name (NextPage
	// Class) Method Name and Returning Next Page
	public Checkoutpage Cart() {

		CheckoutBTN.click();
		CheckoutAsGuest.click();

		return new Checkoutpage();

	}

}
