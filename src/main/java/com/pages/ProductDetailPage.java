package com.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;

public class ProductDetailPage extends GeneralPage {

	public void proceedToCheckout() {
		getDriver().findElement(By.cssSelector("a[title=\"Proceed to checkout\"]")).click();
	}

	public void addOneMoreProduct() {
		waitUntilContentLoads();
		getDriver().findElement(By.cssSelector(".button-plus")).click();
	}

	public void removeOneProduct() {
		waitUntilContentLoads();
		getDriver().findElement(By.cssSelector(".button-minus")).click();
	}

	public void closeCartPreviewWindow() {
		clickButtonByCssSelector(".cross");
	}

	public void getInfoFromPDP() {
		String productName = getDriver().findElement(By.cssSelector("#product_reference span")).getText();
		String price = getDriver().findElement(By.cssSelector("#our_price_display")).getText();

		Serenity.getCurrentSession().put("productName", productName);
		Serenity.getCurrentSession().put("price", price);
	}
}
