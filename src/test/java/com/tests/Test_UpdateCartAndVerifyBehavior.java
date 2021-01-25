package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.CheckoutSteps;
import com.steps.GeneralSteps;
import com.steps.LoginSteps;
import com.steps.OrderHistorySteps;
import com.steps.ProductDetailsSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_UpdateCartAndVerifyBehavior extends BaseTest {
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

	@Test
	public void test_ManipulateCart() {
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		loginSteps.login(EnvironmentConstants.USER, EnvironmentConstants.PASS);
		generalSteps.navigateTo(EnvironmentConstants.PRODUCT_DETAIL_PAGE_URL);
		productDetailsSteps.addOneMoreProduct();
		productDetailsSteps.addProductTocart();
		productDetailsSteps.verifyNumberOfProducts("2");
		productDetailsSteps.closeCartPreviewWindow();
		productDetailsSteps.removeOneProduct();
		productDetailsSteps.verifyCartIsEmpty();
		
	}
}
