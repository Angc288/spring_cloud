package org.test;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by u165091 on 15/10/2016.
 */
@RequestMapping(value = "/flights")
@RestController
public class FlightRestContoller {

    private static Map<String,Flight> mockDB = new HashMap();

    static {
        mockDB.put("BA001", new Flight("BA001", "LCY", "JFK"));
        mockDB.put("BA009", new Flight("BA009", "LHR", "BKK"));
        mockDB.put("BA175", new Flight("BA175", "LHR", "JFK"));
        mockDB.put("BA010", new Flight("BA010", "SYD", "LHR"));
        mockDB.put("BA127", new Flight("BA127", "LHR", "JFK"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Flight> getFlights() {

        return mockDB.values();
//        Table table = FlightHandler.getTable("Flights");
//
//        Collection<Flight> flights = new ArrayList<>();
//
//
//        for (Item item : table.scan()){
//
//            flights.add(new Flight(item.get("FlightNumber").toString(),item.get("ArrivalLocation").toString(),item.get("DepartureLocation").toString()));
//
//        }

 //       return flights;
    }

    @RequestMapping(value = "/{flightNumber}", method = RequestMethod.GET)
    public Flight getFlight(@PathVariable("flightNumber") String flightNumber) {

//        Table table = FlightHandler.getTable("Flights");
//
//        Item item = table.getItem("FlightNumber", flightNumber);
//
//        return new Flight(item.get("FlightNumber").toString(),item.get("ArrivalLocation").toString(),item.get("DepartureLocation").toString());

        return mockDB.get(flightNumber);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postFlight(@RequestBody Flight flight){

        mockDB.put(flight.getFlightNumber(),flight);

//        Table table = FlightHandler.getTable("Flights");
//
//        Item item = new Item()
//                .withPrimaryKey("FlightNumber", flight.getFlightNumber())
//                .with("ArrivalLocation", flight.getArrLocation())
//                .with("DepartureLocation", flight.getDepLocation());
//
//        table.putItem(item);

    }

}
