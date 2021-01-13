package com.steps;

import static org.junit.Assert.assertEquals;

import junit.framework.Assert;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("deprecation")
public class OrderHistorySteps extends GeneralSteps {
	private static final long serialVersionUID = 1L;

	public void verifyOrderPresentInHistory() {
		String orderID = getDriver()
				.findElement(By.cssSelector("#order-list .first_item .history_link.bold.footable-first-column"))
				.getText();
		String orderConfirmationMesage = (String) Serenity.getCurrentSession().get("orderConfirmationMessage");
		Assert.assertTrue(orderConfirmationMesage.contains(orderID));
	}

	public void verifyOrderDetailsInHistory(String paymentMethod) {
		String actualTotalPrice = getDriver().findElement(By.cssSelector(".first_item  .history_price")).getText();
		String expectedtotalPrice = (String) Serenity.getCurrentSession().get("totalProductPrice");
		String actualPaymentMethod = getDriver().findElement(By.cssSelector(".first_item .history_method")).getText();

		assertEquals("Wrong price is displayed in purchase history", actualTotalPrice, expectedtotalPrice);
		assertEquals("Wrong payment method is displayed in purchase history", actualPaymentMethod, paymentMethod);
	}
}
