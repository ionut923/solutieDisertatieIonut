package com.tests;




import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
		  
	
		generalSteps.navigateTo("https://www.google.com"); 
		generalSteps.navigateTo(EnvironmentConstants.BASE_URL);
		loginSteps.login(EnvironmentConstants.USER, EnvironmentConstants.PASS);
		createAccountSteps.verifyUserOnAccountPage();
	}
}

