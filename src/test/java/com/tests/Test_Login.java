package com.tests;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.CreateAccountSteps;
import com.steps.GeneralSteps;
import com.steps.LoginSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_Login extends BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LoginSteps loginSteps;
	@Steps
	public GeneralSteps generalSteps;
	@Steps
	public CreateAccountSteps createAccountSteps;


		  
	
	
	
	@Test
	public void loginTest() {
		   
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		loginSteps.login(EnvironmentConstants.USER, EnvironmentConstants.PASS);
		createAccountSteps.verifyUserOnAccountPage();
	}
}

