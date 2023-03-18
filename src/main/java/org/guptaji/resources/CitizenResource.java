package org.guptaji.resources;

import org.guptaji.entity.Citizen;
import org.guptaji.repository.CitizenRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/citizen")
public class CitizenResource {

    @Inject
    public CitizenRepo citizenRepo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCitizens(){
        return Response.ok(citizenRepo.listAll()).build();
    }

    @GET
    @Path("/getCitizenById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitizensById(@PathParam("id") long id){
        
        // if our repository will implement panacherepository then our primary key / id should be long but
        // if we have a requirement to create a custom primarykey then we need to implement
        // PanacheRepositoryBase instead.
        
        Citizen citizenData = citizenRepo.findById(id);
        if (citizenData == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(citizenData).build();
        }
    }

    /*
    Input we need to pass to save citizen and aadhar data
    {
  "name": "Ayush",
  "city": "Agra",
  "gender": "M",
  "aadhar": {
    "aadharNo": 12345678,
    "company": "TCS"
  }
}
     */
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCitizenData(Citizen citizen){
        citizenRepo.persist(citizen);
        if (citizenRepo.isPersistent(citizen)){
            return Response.created(URI.create("/getCitizenById/"+citizen.getId())).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
