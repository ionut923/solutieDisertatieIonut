package com.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import net.thucydides.core.annotations.Step;


public class ProductDetailsSteps extends GeneralSteps {
	private static final long serialVersionUID = 1L;

	@Step
	public void addProductTocart() {
		getProductDetailPage().getInfoFromPDP();
		//getGeneralPage().clickButtonById("add_to_cart");
		getGeneralPage().clickOnButtonByName("Submit");
	}

	@Step
	public void proceedToCheckout() {
		getProductDetailPage().proceedToCheckout();
	}

	@Step
	public void removeOneProduct() {
		mouseHoverOnCart();
		getProductDetailPage().removeProductFromCart();
	}
	@Step
	public void mouseHoverOnCart() {
		 Actions builder = new Actions(getDriver());
		 WebElement element = getDriver().findElement(By.cssSelector("a[title='View my shopping cart']"));
		 builder.moveToElement(element).build().perform();
	}
	
	@Step
	public void addOneMoreProduct() {
		getProductDetailPage().addOneMoreProduct();
	}
	@Step
	public void verifyCartIsEmpty() {
		getGeneralPage().waitUntilContentLoads();
		String actualNumber = getDriver().findElement(By.cssSelector(".ajax_cart_no_product")).getText();
		Assert.assertTrue("The cart is not empty", actualNumber.contains("empty"));
		
	}

	@Step
	public void verifyNumberOfProducts(String numberOfItemsInCart) {
		getGeneralPage().waitUntilContentLoads();
		String actualNumber = getDriver().findElement(By.cssSelector(".ajax_cart_quantity")).getText();
		System.out.println("Actual number of products: "+actualNumber);
		Assert.assertTrue("The number was not refreshed", actualNumber.contains(numberOfItemsInCart));
	}
	
	@Step
	public void closeCartPreviewWindow() {
		getProductDetailPage().closeCartPreviewWindow();
	}
}
