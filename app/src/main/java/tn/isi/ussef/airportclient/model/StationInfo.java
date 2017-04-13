package tn.isi.ussef.airportclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Ussef on 3/14/2017.
 */

public class StationInfo {
    @SerializedName("datetime")
    private String datetime;
    @SerializedName("iataCode")
    private String iataCode;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDatetime() {

        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
