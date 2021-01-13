package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.ContactSteps;
import com.steps.GeneralSteps;
import com.steps.HeaderSteps;
import com.steps.LoginSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_ContactSupportTeam extends BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public GeneralSteps generalSteps;
	@Steps
	public HeaderSteps headerSteps;
	@Steps
	public ContactSteps contactSteps;
	

	@Test
	public void test_ContactSupportTeam(){
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		headerSteps.openContactForm();
		//TODO create stepgroup "complete contact message" unde paelezi direct completarea de inpututi din page
		contactSteps.selectMessageTarget();
		contactSteps.enterEmailAdress();
		contactSteps.enterOrderRefference();
		contactSteps.enterMesage();
		contactSteps.clickSendButton();
		contactSteps.verifySuccessMessage();
	}
}
