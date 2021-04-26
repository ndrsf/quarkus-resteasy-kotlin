package de.apwolf.quarkus_resteasy_kotlin.restadapter

import org.apache.logging.log4j.kotlin.Logging
import java.time.LocalDate
import javax.annotation.security.RolesAllowed
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CustomerRestAdapter : Logging {

    @GET
    @Path("{customerId}")
    @RolesAllowed("read-customer", "write-customer")
    fun loadCustomer(@PathParam("customerId") customerId: Int): CustomerResponse {
        logger.info("Loading customer $customerId")
        return CustomerResponse(1, "Harrison Ford", LocalDate.now())
    }

    @PUT
    @Path("{customerId}")
    fun updateCustomer(@PathParam("customerId") customerId: Int, customer: CustomerRequest): CustomerResponse {
        logger.info("Updating customer $customer for customerId $customerId")
        return CustomerResponse(customerId, customer.name, customer.birthday)
    }

    @POST
    fun insertCustomer(customer: CustomerRequest): CustomerResponse {
        logger.info("Inserting customer $customer")
        return CustomerResponse(1, customer.name, customer.birthday)
    }

    @DELETE
    @Path("{customerId}")
    fun deleteCustomer(@PathParam("customerId") customerId: Int) {
        logger.info("Deleting customer $customerId")

    }
}