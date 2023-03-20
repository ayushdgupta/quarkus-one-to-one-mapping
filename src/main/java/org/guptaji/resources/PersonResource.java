package org.guptaji.resources;

import org.guptaji.entity.Citizen;
import org.guptaji.entity.Person;
import org.guptaji.repository.PersonRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/person")
public class PersonResource {

    @Inject
    public PersonRepo personRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons(){
        return Response.ok(personRepo.listAll()).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePersonData(Person person){
        personRepo.persist(person);
        if (personRepo.isPersistent(person)){
            return Response.created(URI.create("/getPersonById/"+person.getId())).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
