package ru.perm.v.easybot.restassured;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.perm.v.easybot.restassured.dto.GroupProductDTO;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.perm.v.easybot.restassured.VARS.HOST;

@DisplayName("Tests GroupProductRest")
public class GroupProductRestTest {

    private final static String GROUP_PRODUCT_PATH = HOST + "/group_product";

    @DisplayName("Country GET ID Request id=1 is status=200 is OK")
    @Test
    public void getByGroupProductIdStatusCode_200() {
        given().when().get(GROUP_PRODUCT_PATH + "/1").then().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("Country GET ID Request id=1")
    @Test
    public void getByGroupProductId_1() {
        GroupProductDTO example = new GroupProductDTO(1L, "IT products",-1L, false);
        GroupProductDTO dto = given().when().get(GROUP_PRODUCT_PATH + "/1").andReturn().as(GroupProductDTO.class);
        assertEquals(example, dto);
    }

}
