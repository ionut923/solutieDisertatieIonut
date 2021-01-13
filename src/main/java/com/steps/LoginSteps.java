package com.steps;

import com.pages.LoginPage;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends GeneralSteps {

	private static final long serialVersionUID = 1L;
	LoginPage loginPage = new LoginPage();

	@Step
	public void login(String username, String password) {
		getHeaderPage().clickLoginButton();
		getLoginPage().enterUsername(username);
		getLoginPage().enterPassword(password);
		getLoginPage().clickSubmitLoginButton();
	}
}
