package com.application.steps;

import com.application.pages.BasePage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.WsStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ws.WsRequestBean;
import com.qmetry.qaf.automation.ws.rest.RestTestBase;
import com.sun.jersey.api.client.ClientResponse;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

//extends RestWSTestCase just in case

public class GetRequestExample   {

	@QAFTestStep(description = "Store get request for Universities API {storeKey}")
	public void getRequest(String storeKey) {

		String strRequest = " ";

		getBundle().setProperty(storeKey,strRequest);

	}

	@QAFTestStep(description = "User send get request {requestKey} from {storeKey}")
	public static ClientResponse sendRequest(Object requestKey, String storeKey) {

		WsRequestBean requestBean = new WsRequestBean();

		//get the request payload
		String strRequest = getBundle().getPropertyValue(storeKey);

		//setting headers, request body, and method
		requestBean.fillData(requestKey);
		requestBean.resolveParameters(null);


		Reporter.log("Request is sent" + String.valueOf(requestBean.getBody()));

		//store the response value
		getBundle().setProperty(storeKey, String.valueOf(requestBean.getBody()));

		return WsStep.request(requestBean);
	}

	@QAFTestStep(description = "Response should have status code {code}")
	public static void validateResponseCode(String storeKey) {

		RestTestBase restTestBase = new RestTestBase();

		Object responseStatusCode = restTestBase.getResponse().getStatus().getStatusCode();

		System.out.println(responseStatusCode.toString());

		Validator.assertTrue(responseStatusCode.toString().equals(storeKey),
				"Status Code is not" + storeKey,
				"Status Code is" + storeKey);

	}

}
