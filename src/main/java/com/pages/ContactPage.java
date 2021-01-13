package com.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.Select;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

import net.serenitybdd.core.annotations.findby.By;


public class ContactPage extends GeneralPage {
	
	public void clickSelectDropdown() {
		getDriver().findElement(By.id("id_contact")).click();
	}
	
	
	public void selectMessageTarget(int value) {
		waitUntilContentLoads();
		getDriver().findElement(By.id("id_contact")).click();
		Select dropdown = new Select(getDriver().findElement(By.id("id_contact")));
		dropdown.selectByIndex(value);
	}

	public void enterEmailAdress(String emailAdress) {
		waitUntilContentLoads();
		getDriver().findElement(By.id("email")).sendKeys(emailAdress);
	}
	
	public void enterOrderRefference() {
		getDriver().findElement(By.id("id_order")).sendKeys(FieldGenerators.generateRandomString(5, Mode.NUMERIC));
	}
	
	public void enterMesage() {
		getDriver().findElement(By.id("message")).sendKeys(FieldGenerators.generateRandomString(50, Mode.ALPHANUMERIC));
	}
	
	public void clickSubmitButton() {
		getDriver().findElement(By.id("submitMessage")).click();
	}
	
	public void verifySuccessMessage() {
		String successText = getDriver().findElement(By.cssSelector("#center_column .alert")).getText();
		assertEquals("Mesajul nu a fost trimis", "Your message has been successfully sent to our team.", successText);
	}
}
