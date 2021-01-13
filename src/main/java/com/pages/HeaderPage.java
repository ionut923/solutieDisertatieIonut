package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HeaderPage extends GeneralPage {
	@FindBy(css = ".logo.img-responsive")
	private WebElementFacade homeLogo;

	public void goToHomepage() {
		homeLogo.click();
	}

	public void openLoginForm() {
		getDriver().findElement(By.cssSelector(".login")).click();
	}

	public void openContactForm() {
		getDriver().findElement(By.id("contact-link")).click();
	}
	
	public void clickLoginButton() {
		getDriver().findElement(By.cssSelector(".login")).click();
	}
}
