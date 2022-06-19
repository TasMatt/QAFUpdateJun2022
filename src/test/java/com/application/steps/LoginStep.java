package com.application.steps;

import com.application.pages.BasePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class LoginStep extends WebDriverTestCase {

	@QAFTestStep(description = "Navigate to Google")
	public void LoginToApplication() {

		BasePage basePage = new BasePage();

		basePage.openWebsite();
		basePage.waitForPageToLoad();

		Validator.assertTrue(basePage.imageGoogle.isPresent(),
				"Google.com is not invoked.",
				"Google.com is invoked successfully.");

	}

	@QAFTestStep(description = "User Verifies DataSheet value {value}")
	public void verifyDataSheet(String strValue) {

		Validator.verifyTrue(strValue.equals("chrome"),
				"Datasheet does not work successfully",
				"Datasheet works successfully");

	}
}
