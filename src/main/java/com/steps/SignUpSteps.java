package com.steps;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("deprecation")
public class SignUpSteps extends GeneralSteps {
	private static final long serialVersionUID = 1L;

	public void signUpFornewsletter() {
		getGeneralPage().enterInputValue("newsletter-input",
				FieldGenerators.generateRandomString(5, Mode.ALPHANUMERIC) + "@gmail.om");
		getGeneralPage().clickOnButtonByName("submitNewsletter");
	}

	public void verifyNeswlaterSignUpSuccess() {
		String actualSuccessMessage = getDriver().findElement(By.cssSelector(".alert.alert-success")).getText();
		Assert.assertTrue("The sign up was not successfull",
				actualSuccessMessage.equals("Newsletter : You have successfully subscribed to this newsletter."));
	}
}