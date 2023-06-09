package ru.perm.v.easybot.restassured;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.perm.v.easybot.restassured.dto.GroupProductDTO;
import ru.perm.v.easybot.restassured.dto.ProductDTO;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.perm.v.easybot.restassured.VARS.HOST;

@DisplayName("Tests ProductRest")
public class ProductRestTest {

    private final static String PRODUCT_PATH = HOST + "/product";

    @DisplayName("GET Product by ID Request id=31 is status=200 is OK")
    @Test
    public void getByProductById_31_StatusCode_200() {
        given().when().get(PRODUCT_PATH + "/1").then().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("Check DTO by GET Product with ID=31")
    @Test
    public void getByProductId_31_checkDTO() {
        ProductDTO example = new ProductDTO(31L, "Desktop1", 3L);
        ProductDTO dto = given().when().get(PRODUCT_PATH + "/31").andReturn().as(ProductDTO.class);
        assertEquals(example, dto);
    }

}
