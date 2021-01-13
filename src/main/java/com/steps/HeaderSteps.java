package com.steps;

import com.pages.HeaderPage;

import net.thucydides.core.annotations.Step;

public class HeaderSteps extends GeneralSteps{
	private static final long serialVersionUID = 1L;
	
	HeaderPage headerPage;
	

	@Step
	public void goToHomepage() {
		headerPage.goToHomepage();
	}
	
	@Step
	public void openLoginForm() {
		headerPage.openLoginForm();
	}
	
	@Step
	public void openContactForm() {
		headerPage.openContactForm();
	}
}
