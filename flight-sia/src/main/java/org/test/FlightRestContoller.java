package org.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by u165091 on 15/10/2016.
 */
@RequestMapping(value = "/flights")
@RestController
public class FlightRestContoller {

    @Autowired
    FLightServiceRepo flightServiceRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Flight> getFlights() {

       // Collection<Flight> flights = restTemplate.getForObject("http://FLIGHT-SERVICE/flights",Collection.class);
        Collection<Flight> flights = flightServiceRepo.getFlights();

        Flight flight = new Flight("BA011","LHR","SYD");
        flights.add(flight);

        return flights;
    }

    @RequestMapping(value = "/{flightNumber}", method = RequestMethod.GET)
    public Flight getFlight(@PathVariable("flightNumber") String flightNumber) throws Exception {

        Flight flight = flightServiceRepo.getFlight(flightNumber);

        if (flight == null){
            throw new Exception();
        }else{
            return flight;
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public void postFlight(@RequestBody Flight flight){

    }

}
