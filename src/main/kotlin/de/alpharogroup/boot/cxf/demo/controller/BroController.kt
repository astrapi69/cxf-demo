package de.alpharogroup.boot.cxf.demo.controller

import de.alpharogroup.boot.cxf.demo.entity.Bro
import de.alpharogroup.boot.cxf.demo.service.BroService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Component
@Path("/bros")
@Api(value = "/bros")
@Produces(MediaType.APPLICATION_JSON)
class BroController @Autowired constructor(val broService: BroService) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun save(bro: Bro): Bro {
        return broService.save(bro).get()
    }

    @GET
    @ApiOperation(value = "Find all bros")
    fun findAll(): List<Bro> {
        return broService.findAll()
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Find an existing bro with the given id")
    fun findById(@PathParam("id") id: Long): Bro {
        return broService.findById(id).get()
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value = "Updates an existing bro with the given id and bro to update")
    fun update(@PathParam("id") id: Long, bro: Bro): Bro{
        return broService.update(id, bro).get()
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Delete an existing bro with the given id that is no bro anymore")
    fun deleteById(@PathParam("id") id: Long) {
        broService.deleteById(id)
    }

}