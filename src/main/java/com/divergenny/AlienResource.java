package com.divergenny;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AlienResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAlien() {
        System.out.println("getAlien called...");
        Alien a1 = new Alien();
        a1.setName("Navin");
        a1.setPoints(60);

        Alien a2 = new Alien();
        a2.setName("Arati");
        a2.setPoints(70);
        List<Alien> alienList = Arrays.asList(a1, a2);

        return alienList;
    }
}
