package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AuthenticationSteps;
import com.steps.CreateAccountSteps;
import com.steps.GeneralSteps;
import com.steps.HeaderSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;


@RunWith(SerenityRunner.class)
public class Test_CreateAccount extends BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	@Steps
	public GeneralSteps generalSteps;
	@Steps
	public HeaderSteps headerSteps;
	@Steps
	public CreateAccountSteps createAccountSteps;
	@Steps
	public AuthenticationSteps authenticationSteps;

	@Test
	public void test_CreateAccount() {
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		headerSteps.openLoginForm();
		authenticationSteps.enterEmail();
		authenticationSteps.clickCreateAnAccountButton();
		createAccountSteps.fillOutAccountForm();
		createAccountSteps.verifyUserOnAccountPage();
		createAccountSteps.verifyCreatedUserIsSignedIn();
	}
}
