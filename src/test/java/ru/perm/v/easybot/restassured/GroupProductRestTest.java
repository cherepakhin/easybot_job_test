package ru.perm.v.easybot.restassured;

import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static ru.perm.v.easybot.restassured.VARS.HOST;

@DisplayName("Tests GET GroupProductRest")
public class GroupProductRestTest {

    private final static String GROUP_PRODUCT_PATH = HOST + "/group_product";

    @DisplayName("Country GET ID Request id=1 is status=200")
    @Description(value = "Verify the HTTP answer of country id=1 is status=200")
    @Test
    public void getGrouProductId_1_and_StatusCode_200() {
        given().when().get(GROUP_PRODUCT_PATH + "/1").then().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("Country GET all country is status=200")
    @Description(value = "Verify the HTTP answer GET all products is status=200")
    @Test
    public void getGrouProductAll_and_StatusCode_200() {
        given().when().get(GROUP_PRODUCT_PATH + "/").then().statusCode(HttpStatus.SC_OK);
    }

}
