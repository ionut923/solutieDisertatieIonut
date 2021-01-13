package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.By;

public class HomePage extends GeneralPage {

	public void selectDesiredProduct(String value) {
		waitUntilContentLoads();
		List<WebElement> products = getDriver().findElements(By.cssSelector("li .product-container"));
		for (WebElement itemNow : products) {
			if (itemNow.getText().contains(value)) {
				Actions action = new Actions(getDriver());
				action.moveToElement(itemNow).click().build().perform();
				break;
			}
		}
	}
}
