package com.vz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vz.base.TestBase;

public class Checkoutpage extends TestBase {

	// PageFactory = OR

	@FindBy(xpath = "//input[@id='businessName']")
	WebElement CompanyNameTextBox;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement FirstNameTextBox;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement LastNameTextBox;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement AddressTextBox;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement ApartmentTextBox;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement ZipcodeTextBox;

	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailIDTextBox;

	@FindBy(xpath = "//input[@id='phoneNumber']")
	WebElement PhoneNumberTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement UpdateBtn;

	@FindBy(xpath = "//a[contains(text(),'Edit cart')]")
	WebElement EditcartBtn;

	@FindBy(xpath = "//a[contains(text(),'Clear cart')]")
	WebElement ClearcartBtn;

	@FindBy(xpath = "//button[contains(text(),'Remove Cart Item')]")
	WebElement RemovecartItemBtn;

	// Initializing the Page Objects
	public Checkoutpage() {

		// To Initialize the @FindBy Using Below
		PageFactory.initElements(driver, this);

	}

	// In order to move next page written method name as Class Name (NextPage
	// Class) Method Name and Returning Next Page
	public void ShippingInformation(String CompanyName, String FirstName, String LastName, String Address,
			String Apartment, String Zipcode, String EmailID, String Phonenumber) {

		CompanyNameTextBox.sendKeys(CompanyName);
		FirstNameTextBox.sendKeys(FirstName);
		LastNameTextBox.sendKeys(LastName);
		AddressTextBox.sendKeys(Address);
		ApartmentTextBox.sendKeys(Apartment);
		ZipcodeTextBox.sendKeys(Zipcode);
		EmailIDTextBox.sendKeys(EmailID);
		PhoneNumberTextBox.sendKeys(Phonenumber);
		UpdateBtn.click();

	}

	public void ShippingMethod() {
		UpdateBtn.click();
	}

	public void BillingAddress() {
		UpdateBtn.click();
	}

	public void Editcart() {
		EditcartBtn.click();
		ClearcartBtn.click();
		RemovecartItemBtn.click();
	}

}
