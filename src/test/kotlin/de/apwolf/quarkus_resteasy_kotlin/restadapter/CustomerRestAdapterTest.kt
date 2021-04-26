package de.apwolf.quarkus_resteasy_kotlin.restadapter

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import java.time.LocalDate

@QuarkusTest
internal class CustomerRestAdapterTest {

    @Test
    fun testHelloEndpoint() {
        RestAssured.given()
            .`when`().get("/customer/1")
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`(CustomerResponse(1, "jo", LocalDate.now())))
    }

}