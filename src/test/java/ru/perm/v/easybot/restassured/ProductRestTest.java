package ru.perm.v.easybot.restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.perm.v.easybot.restassured.dto.ProductDTO;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.perm.v.easybot.restassured.VARS.HOST;

@DisplayName("Tests ProductRest")
public class ProductRestTest {

    private final static String PRODUCT_PATH = HOST + "/product";

    @DisplayName("GET Product by ID Request id=31 is status=200 is OK")
    @Test
    public void getProductById_31_StatusCode_200() {
        given().when().get(PRODUCT_PATH + "/31").then().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("Check DTO by GET Product with ID=31")
    @Test
    public void getProductById_31_checkDTO() {
        ProductDTO example = new ProductDTO(31L, "Desktop1", 3L);
        ProductDTO dto = given().when().get(PRODUCT_PATH + "/31").andReturn().as(ProductDTO.class);
        assertEquals(example, dto);
    }

    @DisplayName("GET by GROUP_ID=3")
    @Test
    public void getProductsByGroupId_3() {
        Long GROUP_ID = 3L;

        ProductDTO[] dtos = given().when().get(PRODUCT_PATH + "/groupId/" + GROUP_ID).as(ProductDTO[].class);

        assertEquals(3, dtos.length);
        assertEquals(new ProductDTO(31L, "Desktop1", GROUP_ID), dtos[0]);
        assertEquals(new ProductDTO(32L, "Desktop2", GROUP_ID), dtos[1]);
        assertEquals(new ProductDTO(33L, "Desktop3", GROUP_ID), dtos[2]);
    }

    @DisplayName("PUT Product")
    @Test
    public void putProduct() throws JsonProcessingException {
        Long GROUP_ID = 3L;
        ProductDTO dto = new ProductDTO();
        dto.setName("NAME_101");
        dto.setGroupProductId(GROUP_ID);
        RequestSpecification httpRequest = given()
                .header("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        httpRequest.body(json);

        ProductDTO recievedDto = httpRequest.put(PRODUCT_PATH + "/").as(ProductDTO.class);

        assertEquals(dto.getName(), recievedDto.getName());
        assertEquals(dto.getGroupProductId(), recievedDto.getGroupProductId());
        assertTrue(recievedDto.getId().compareTo(0L) > 0);
    }
}
