package org.guptaji.resources;

import org.guptaji.entity.Simcard;
import org.guptaji.repository.SimcardRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/simcard")
public class SimcardResource {

    @Inject
    public SimcardRepo simcardRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSimcards(){
        return Response.ok(simcardRepo.listAll()).build();
    }

    @GET
    @Path("/getSimcardById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSimcardById(@PathParam("id") int id){

        // if our repository will implement panacherepository then our primary key / id should be long but
        // if we have a requirement to create a custom primarykey then we need to implement
        // PanacheRepositoryBase instead.

        Simcard simcardData = simcardRepo.findById(id);
        if (simcardData == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(simcardData).build();
        }
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSimcardData(Simcard simcard){
        simcardRepo.persist(simcard);
        if (simcardRepo.isPersistent(simcard)){
            return Response.created(URI.create("/getSimcardById/"+simcard.getId())).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
