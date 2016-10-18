package org.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class FlightSiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSiaApplication.class, args);
	}


}

@FeignClient("FLIGHT-SERVICE")
interface FLightServiceRepo {
	@RequestMapping(method = RequestMethod.GET, value = "/flights")
	Collection<Flight> getFlights();

	@RequestMapping(method = RequestMethod.GET, value = "/flights/{flightNumber}")
	Flight getFlight(@PathVariable("flightNumber") String flightNumber);

}
