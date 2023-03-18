package org.guptaji.resources;

import org.guptaji.entity.Aadhar;
import org.guptaji.repository.AadharRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/aadhar")
public class AadharResource {

    @Inject
    public AadharRepo aadharRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAadharData(){
        return Response.ok(aadharRepo.listAll()).build();
    }

    @GET
    @Path("/getAadharById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAadharById(@PathParam("id") long id){

        // if our repository will implement panacherepository then our primary key / id should be long but
        // if we have a requirement to create a custom primarykey then we need to implement
        // PanacheRepositoryBase instead.

        Aadhar aadharData = aadharRepo.findById(id);
        if (aadharData == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(aadharData).build();
        }
    }

    @POST
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveAadharData(Aadhar aadhar){
        aadharRepo.persist(aadhar);
        if (aadharRepo.isPersistent(aadhar)){
            return Response.created(URI.create("/getAadharById/"+aadhar.getId())).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
