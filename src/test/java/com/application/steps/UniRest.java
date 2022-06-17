package com.application.steps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

public class UniRest {

    @QAFTestStep(description = "User verifies response with UniRest")
    public void verifyResponse() throws UnirestException {


        String baseUrl = "https://dog.ceo/api/breeds/list/all";
        int status = Unirest.get(baseUrl).asJson().getStatus();

        Validator.verifyTrue(status == 200,
                "Response is not 200",
                "Response is 200");

    }

    @QAFTestStep(description = "User verifies get body")
    public void verifyGetBody() throws UnirestException {

        String baseUrl = "https://catfact.ninja/breeds";

        JsonNode body = Unirest.get(baseUrl).asJson().getBody();
        System.out.println(body);
        String body1 = body.toString();

        String s1 = body1.substring(body1.indexOf("["));
        String s2 = s1.substring(s1.indexOf("["));
        System.out.println(s2);
    }

    @QAFTestStep(description = "User sends post")
    public void SetBody() throws UnirestException {

        String baseUrl = "HTTP://API.SHOUTCLOUD.IO/V1/SHOUT";

        HttpResponse<JsonNode> jsonResponse = Unirest.post(baseUrl).body("{\"INPUT\":\"hello world\"}").asJson();

        Validator.assertTrue(jsonResponse.getStatus() == 200,
                "fail",
                "pass");


    }
}
