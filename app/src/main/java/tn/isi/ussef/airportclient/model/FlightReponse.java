package tn.isi.ussef.airportclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightReponse {

    @SerializedName("results")
    private List<Flight> results;

    public List<Flight> getResults() {
        return results;
    }

    public void setResults(List<Flight> results) {
        this.results = results;
    }

}
