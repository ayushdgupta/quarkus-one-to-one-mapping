package org.guptaji.resources;

import org.guptaji.entity.Citizen2;
import org.guptaji.repository.Citizen2Repo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/citizen2")
public class Citizen2Resource {

    @Inject
    public Citizen2Repo citizen2Repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCitizens2(){
        return Response.ok(citizen2Repo.listAll()).build();
    }

    @GET
    @Path("/getCitizenById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitizens2ById(@PathParam("id") int id){

        // if our repository will implement panacherepository then our primary key / id should be long but
        // if we have a requirement to create a custom primarykey then we need to implement
        // PanacheRepositoryBase instead.

        Citizen2 citizenData = citizen2Repo.findById(id);
        if (citizenData == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(citizenData).build();
        }
    }

    @POST
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCitizen2Data(Citizen2 citizen){
        citizen2Repo.persist(citizen);
        if (citizen2Repo.isPersistent(citizen)){
            return Response.created(URI.create("/getCitizenById/"+citizen.getId())).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
