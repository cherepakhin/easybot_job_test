package ru.perm.v.easybot.restassured;

import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static ru.perm.v.easybot.restassured.VARS.HOST;

@DisplayName("Tests EchoRestTest")
public class EchoRestTest {

    private final static String GROUP_PRODUCT_PATH = HOST + "/group_product";

    @DisplayName("Get echo is status=200")
    @Test
    public void getEcho_and_StatusCode_200() {
        given().when().get(GROUP_PRODUCT_PATH + "/echo").then().statusCode(HttpStatus.SC_OK);
    }

}
