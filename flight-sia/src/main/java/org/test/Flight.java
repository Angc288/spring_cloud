package org.test;

/**
 * Created by u165091 on 15/10/2016.
 */

public class Flight {

    private String flightNumber;
    private String depLocation;
    private String arrLocation;

    public Flight() {
    }

    public Flight(String flightNumber, String depLocation, String arrLocation) {
        this.flightNumber = flightNumber;
        this.depLocation = depLocation;
        this.arrLocation = arrLocation;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepLocation() {
        return depLocation;
    }

    public void setDepLocation(String depLocation) {
        this.depLocation = depLocation;
    }

    public String getArrLocation() {
        return arrLocation;
    }

    public void setArrLocation(String arrLocation) {
        this.arrLocation = arrLocation;
    }
}
