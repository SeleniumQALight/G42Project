package api;

import DTO.CurrencyValues;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static endpoints.EndPoints.PRIVATBANK_P24API_PUBINFO;
import static endpoints.EndPoints.RESTAPI_DEMOQA_COM_CUSTOMER_REGISTER;
import static io.restassured.RestAssured.given;
import static libs.Utils.getDateAndTimeFormated;

public class ApiTest {
    @Test
    public void privateBankTest() {
        CurrencyValues[] currencyValues =
                given()
                        .contentType(ContentType.JSON)    // Header
                        .queryParam("json")
                        .queryParam("exchange")         //adding param to URL
                        .queryParam("coursid", 5)
                        .log().all()
                .when()
                        .get(PRIVATBANK_P24API_PUBINFO)// Example GET method
                .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response().getBody().as(CurrencyValues[].class);

        for (CurrencyValues currencyElement : currencyValues) {
            System.out.println("Cur " + currencyElement.ccy + " to " + currencyElement.base_ccy + " has for buy " + currencyElement.buy + " and for sale " + currencyElement.sale);
        }

    }

    @Test
    public void demoQATest() {
        String dateTime = getDateAndTimeFormated();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender" + dateTime); // Cast
        requestParams.put("LastName", "Singh" + dateTime);
        requestParams.put("UserName", "sdimpleuser2dd20111" + dateTime);
        requestParams.put("Password", "password");
        requestParams.put("Email", "sample" + dateTime + "@gmail.com");

        ResponseBody response =
                given()
                    .contentType(ContentType.JSON)
                    .body(requestParams.toMap())
                .when()
                    .post(RESTAPI_DEMOQA_COM_CUSTOMER_REGISTER)// Example POST method
                .then()
                    .statusCode(201)
                    .log().all()
                    .extract()
                    .response().getBody();

        Assert.assertEquals("Correct Success code was returned", response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");

    }

    @Test
    public void demoQATestAlredyRegistered() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender"); // Cast
        requestParams.put("LastName", "Singh");
        requestParams.put("UserName", "sdimpleuser2dd20111");
        requestParams.put("Password", "password");
        requestParams.put("Email", "sample@gmail.com");

        ResponseBody response =
                given()
                    .contentType(ContentType.JSON)
                    .body(requestParams.toMap())
                .when()
                    .post(RESTAPI_DEMOQA_COM_CUSTOMER_REGISTER)
                .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .response().getBody();

        Assert.assertEquals("Don`t get FaultId", response.jsonPath().get("FaultId"), "User already exists");

    }
}