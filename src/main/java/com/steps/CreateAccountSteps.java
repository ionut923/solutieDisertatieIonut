package com.steps;

import static org.junit.Assert.assertEquals;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.findby.By;

@SuppressWarnings("deprecation")
public class CreateAccountSteps extends GeneralSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void fillOutAccountForm() {
		getGeneralPage().selectCheckboxById("id_gender1");
		String firstName = FieldGenerators.generateRandomString(7, Mode.ALPHA);
		getGeneralPage().enterInputValue("customer_firstname", firstName);
		getGeneralPage().enterInputValue("passwd", "password");
		String lastName = FieldGenerators.generateRandomString(7, Mode.ALPHA);
		getGeneralPage().enterInputValue("customer_lastname", lastName);
		getGeneralPage().selectDropdownValue("#days", "2");
		getGeneralPage().selectDropdownValue("#months", "2");
		getGeneralPage().selectDropdownValue("#years", "2000");
		getGeneralPage().selectCheckboxById("newsletter");
		getGeneralPage().selectCheckboxById("optin");
		getGeneralPage().enterInputValue("company", "evozon");
		getGeneralPage().enterInputValue("address1", FieldGenerators.generateRandomString(10, Mode.ALPHANUMERIC));
		getGeneralPage().enterInputValue("address2", FieldGenerators.generateRandomString(10, Mode.ALPHANUMERIC));
		getGeneralPage().enterInputValue("city", "Cluj");
		getGeneralPage().selectDropdownValue("#id_state", "2");
		getGeneralPage().enterInputValue("postcode", FieldGenerators.generateRandomString(5, Mode.NUMERIC));
		getGeneralPage().selectDropdownValue("#id_country", "21");
		getGeneralPage().enterInputValue("other", FieldGenerators.generateRandomString(50, Mode.ALPHANUMERIC));
		getGeneralPage().enterInputValue("phone", FieldGenerators.generateRandomString(10, Mode.NUMERIC));
		getGeneralPage().enterInputValue("phone_mobile", FieldGenerators.generateRandomString(10, Mode.NUMERIC));
		getGeneralPage().clearInputValue("alias");
		getGeneralPage().enterInputValue("alias", FieldGenerators.generateRandomString(10, Mode.ALPHANUMERIC));
		getGeneralPage().clickButtonById("submitAccount");

		Serenity.getCurrentSession().put("firstName", firstName);
		Serenity.getCurrentSession().put("lastName", lastName);
	}

	// Aici sa se faca verificarea cu assert
	@Step
	public void verifyUserOnAccountPage() {
		String actualTitle = getDriver().getTitle();
		assertEquals("account creation failed", "My account - My Store", actualTitle);
	}

	@Step
	public void verifyCreatedUserIsSignedIn() {
		String expectedSignedInUserName = ((String) Serenity.getCurrentSession().get("firstName") + " "
				+ (String) Serenity.getCurrentSession().get("lastName"));
		String actualSignedInUserName = getDriver().findElement(By.cssSelector(".account")).getText();
		System.out.println(
				"Expected: expectedSignedInUserName " + expectedSignedInUserName + "Actual " + actualSignedInUserName);
		assertEquals("User is not signed in", expectedSignedInUserName, actualSignedInUserName);

	}
}
