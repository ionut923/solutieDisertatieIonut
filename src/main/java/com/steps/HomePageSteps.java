package com.steps;

import com.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps extends GeneralSteps {
	
	private static final long serialVersionUID = 1L;
	HomePage homePage = new HomePage();

	@Step
	public void selectDesiredProduct(String value) {
		getHomepage().selectDesiredProduct(value);
	}
	
	@Step
	public void navigateToHomepage() {
		getGeneralPage().clickButtonByCssSelector("#header_logo img");
	}
	
}
