package com.steps;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class CheckoutSteps extends GeneralSteps{
	
	private static final long serialVersionUID = 1L;

	@Step
	public void completeCheckoutWithBankWire() {
		getCheckoutPage().proceedToCheckout();
		getCheckoutPage().processAddress();
		getCheckoutPage().agreeeToTerms();
		getCheckoutPage().processCarrier();
		getCheckoutPage().selectBankWirePaymentMethod();
		getCheckoutPage().confirmOrder();
	}
	@Step
	public void completeCheckoutWithCheque() {
		getCheckoutPage().proceedToCheckout();
		getCheckoutPage().processAddress();
		getCheckoutPage().agreeeToTerms();
		getCheckoutPage().processCarrier();
		getCheckoutPage().selectCheckPaymentMethod();
		getCheckoutPage().confirmOrder();
	}
	
	public void verifyOrderConfirmationMessage() {
		String actualMessage = getDriver().findElement(By.cssSelector("#center_column h1")).getText();
		assertEquals("Checkout failed", "ORDER CONFIRMATION", actualMessage);
		
		String message = getDriver().findElement(By.cssSelector(".box ")).getText();
		Serenity.getCurrentSession().put("orderConfirmationMessage", message);
	}
	
	@Step
	public void navigateToOrderHistory() {
		getCheckoutPage().navigateToOrderHistory();
	}
	
	@Step
	public void verifyPriceAndExpectedProductAddedtoToCart() {
		String expectedProductName = (String) Serenity.getCurrentSession().get("productName");
		String expectedProductPrice = (String) Serenity.getCurrentSession().get("price");
		String actualProductName = getDriver().findElement(By.cssSelector(".cart_ref")).getText();
		String[] actualProductNameList = actualProductName.split(" ");
		actualProductName = actualProductNameList[2];
		String actualProductPrice = getDriver().findElement(By.cssSelector("#total_product_price_2_7_63712")).getText();
		assertEquals("Wrong product added to cart", expectedProductName, actualProductName);
		assertEquals("Wrong price is displayed in cart", expectedProductPrice, actualProductPrice);
		
		String totalProductPrice = getDriver().findElement(By.cssSelector("#total_price_container #total_price")).getText();
		Serenity.getCurrentSession().put("totalProductPrice", totalProductPrice);
	}
	
}
