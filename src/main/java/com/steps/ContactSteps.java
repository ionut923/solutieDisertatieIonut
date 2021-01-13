package com.steps;

import com.pages.ContactPage;

import net.thucydides.core.annotations.Step;

public class ContactSteps {

	ContactPage contactPage;
	
	@Step
	public void clickSelectDropdown() {
		contactPage.clickSelectDropdown();
	}

	@Step
	public void selectMessageTarget() {
		contactPage.selectMessageTarget(2);
	}
	
	@Step
	public void enterEmailAdress() {
		contactPage.enterEmailAdress("example@gmail.com");
	}
	
	@Step
	public void enterOrderRefference() {
		contactPage.enterOrderRefference();
	}
	@Step
	public void enterMesage() {
		contactPage.enterMesage();
	}
	@Step
	public void clickSendButton() {
		contactPage.clickSubmitButton();
	}
	@Step
	public void verifySuccessMessage() {
		contactPage.verifySuccessMessage();
	}
}