package de.bafin;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class EAMResourceTest {
    @Test
    void testProduktEndpoint() {
        given()
          .when().get("/eam/api/produkte")
          .then()
             .statusCode(200);
    }

}