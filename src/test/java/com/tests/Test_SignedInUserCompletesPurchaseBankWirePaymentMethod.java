package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.CheckoutSteps;
import com.steps.GeneralSteps;
import com.steps.HomePageSteps;
import com.steps.LoginSteps;
import com.steps.OrderHistorySteps;
import com.steps.ProductDetailsSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_SignedInUserCompletesPurchaseBankWirePaymentMethod extends BaseTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public GeneralSteps generalSteps;
	@Steps
	public ProductDetailsSteps productDetailsSteps;
	@Steps
	public CheckoutSteps checkoutSteps;
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public OrderHistorySteps orderHistorySteps;
	@Steps
	public HomePageSteps homepageSteps;

	@Test
	public void test_SignedInUserCompletesPurchaseBankWirePaymentMethod() {
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		loginSteps.login(EnvironmentConstants.USER, EnvironmentConstants.PASS);
		homepageSteps.navigateToHomepage();
		homepageSteps.selectDesiredProduct("Blouse");
		productDetailsSteps.addProductTocart();
		productDetailsSteps.proceedToCheckout();
		checkoutSteps.verifyPriceAndExpectedProductAddedtoToCart();
		checkoutSteps.completeCheckoutWithBankWire();
		checkoutSteps.verifyOrderConfirmationMessage();
		checkoutSteps.navigateToOrderHistory();
		orderHistorySteps.verifyOrderPresentInHistory();
		orderHistorySteps.verifyOrderDetailsInHistory("Bank wire");
	}
}
