package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.GeneralSteps;
import com.steps.SignUpSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_SignUpForNewsletter extends BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public GeneralSteps generalSteps;
	@Steps
	public SignUpSteps signUpSteps;

	@Test
	public void test_SignUpForNewsletter() {
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		signUpSteps.signUpFornewsletter();
		signUpSteps.verifyNeswlaterSignUpSuccess();
	}
}
