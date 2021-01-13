package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.By;

public class GeneralPage extends AbstractPage {

	public void waitUntilContentLoads() {
		withTimeoutOf(120, TimeUnit.SECONDS)
				.waitFor(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.dimmed")));
	}

	public void selectCheckboxById(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void enterInputValue(String id, String value) {
		getDriver().findElement(By.id(id)).sendKeys(value);
	}

	public void clearInputValue(String id) {
		getDriver().findElement(By.id(id)).clear();
	}

	public void selectDropdownValue(String id, String value) {
		WebElement elem = getDriver().findElement(By.cssSelector(id));
		element(elem).selectByValue(value);
	}

	public void clickButtonById(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickButtonByCssSelector(String selector) {
		getDriver().findElement(By.cssSelector(selector)).click();
	}

	public void verifyTitle(String title) {
		verifyTitle(title);
	}

	public void clickOnButtonByName(String name) {
		waitUntilContentLoads();
		getDriver().findElement(By.cssSelector("button[name='" + name + "']")).click();
	}
}
