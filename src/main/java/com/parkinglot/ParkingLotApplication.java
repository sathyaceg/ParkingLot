package com.parkinglot;

import com.parkinglot.configs.ParkingLotConfiguration;
import com.parkinglot.resources.SampleResource;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by sathya.ganesan on 17/12/17.
 */
public class ParkingLotApplication extends Application<ParkingLotConfiguration> {

   public static void main(String[] args) {

      try {
         if (args.length == 0) {
            args = new String[] {"server", "src/main/resources/parkinglot.yml"};
         }
         new ParkingLotApplication().run(args);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public void initialize(Bootstrap<ParkingLotConfiguration> bootstrap) {

   }

   public void run(ParkingLotConfiguration parkingLotConfiguration, Environment environment) throws Exception {

      Injector injector = createInjector(parkingLotConfiguration);
      environment.jersey().register(injector.getInstance(SampleResource.class));
   }

   private Injector createInjector(ParkingLotConfiguration parkingLotConfiguration) {

      return Guice.createInjector(new AbstractModule() {

         @Override protected void configure() {

         }
      });
   }
}
