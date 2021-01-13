package com.steps;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

import net.thucydides.core.annotations.Step;

public class AuthenticationSteps extends GeneralSteps {
	private static final long serialVersionUID = 1L;

	@Step
	public void enterEmail() {
		getGeneralPage().enterInputValue("email_create",
				FieldGenerators.generateRandomString(5, Mode.ALPHANUMERIC) + "@gmail.com");
	}

	@Step
	public void clickCreateAnAccountButton() {
		getGeneralPage().clickButtonById("SubmitCreate");
	}
}
