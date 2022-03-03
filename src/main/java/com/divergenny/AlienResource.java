package com.divergenny;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * POST is for creating resource
 * GET is for fetching resource
 * PUT is for updating resource
 * DELETE is for deleting resource
 */
@Path("aliens")
public class AlienResource {

    AlienRepository repo = new AlienRepository();

    /**
     * @return All aliens
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Alien> getAliens() {
        System.out.println("getAliens called...");
        return repo.getAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alien getAlien(@PathParam("id") int id) {
        return repo.getAlien(id);
    }

    /**
     * When we send data or whenever you create a new resource on the server,
     * we always use POST request .
     * POST - for creating resource
     *
     * @param a1 empty alien object
     * @return alien with data
     */
    @POST
    @Path("alien")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alien createAlien(Alien a1) {
        System.out.println(a1);
        repo.create(a1);
        return a1;
    }
}
