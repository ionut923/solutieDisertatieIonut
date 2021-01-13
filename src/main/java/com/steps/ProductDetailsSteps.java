package com.steps;

import org.openqa.selenium.By;

import junit.framework.Assert;
import net.thucydides.core.annotations.Step;

@SuppressWarnings("deprecation")
public class ProductDetailsSteps extends GeneralSteps {
	private static final long serialVersionUID = 1L;

	@Step
	public void addProductTocart() {
		getProductDetailPage().getInfoFromPDP();
		getGeneralPage().clickButtonById("add_to_cart");
	}

	@Step
	public void proceedToCheckout() {
		getProductDetailPage().proceedToCheckout();
	}

	@Step
	public void removeOneProduct() {
		getProductDetailPage().removeOneProduct();
	}
	
	@Step
	public void addOneMoreProduct() {
		getProductDetailPage().addOneMoreProduct();
	}

	@Step
	public void verifyNumberOfProducts(String numberOfItemsInCart) {
		getGeneralPage().waitUntilContentLoads();
		String actualNumber = getDriver().findElement(By.cssSelector(".layer_cart_cart span")).getText();
		System.out.println("Actual number of products"+actualNumber);
		Assert.assertTrue("The number was not refreshed", actualNumber.contains(numberOfItemsInCart));
	}
	
	@Step
	public void closeCartPreviewWindow() {
		getProductDetailPage().closeCartPreviewWindow();
	}
}
