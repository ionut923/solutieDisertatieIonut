package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends GeneralPage {

	@FindBy(css = "#email")
	private WebElementFacade usernameInput;

	@FindBy(css = "#passwd")
	private WebElementFacade passwordInput;
	
	@FindBy(css = ".lost_password.form-group")
	private WebElementFacade forgotPWLink;
	

	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickSubmitLoginButton() {
		clickButtonById("SubmitLogin");
	}
	
	public void clickOnForgetPasswordLink() {
		forgotPWLink.click();
	}
}

