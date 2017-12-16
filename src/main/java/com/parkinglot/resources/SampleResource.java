package com.parkinglot.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by sathya.ganesan on 17/12/17.
 */

@Path("/sample")
public class SampleResource {

   @GET
   public String sample() {

      return "hello";
   }
}
