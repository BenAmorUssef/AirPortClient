package tn.isi.ussef.airportclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ussef on 3/10/2017.
 */

public class Flight {
    @SerializedName("flightNumber")
    private String flightNumber;
    @SerializedName("status")
    private String status;
    @SerializedName("href")
    private String link;
    @SerializedName("departure")
    private StationInfo arrival;
    @SerializedName("arrival")
    private StationInfo departure;

    public Flight(String flightNumber, String status, String link) {
        this.flightNumber = flightNumber;
        this.status = status;
        this.link = link;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public StationInfo getDeparture() {
        return departure;
    }

    public void setDeparture(StationInfo departure) {
        this.departure = departure;
    }

    public StationInfo getArrival() {
        return arrival;
    }

    public void setArrival(StationInfo arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", status='" + status + '\'' +
                ", link='" + link + '\'' +
                ", arrival=" + arrival +
                ", departure=" + departure +
                '}';
    }
}
