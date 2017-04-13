package tn.isi.ussef.airportclient.rest;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;
import tn.isi.ussef.airportclient.model.FlightReponse;

/**
 * Created by Ussef on 3/10/2017.
 */

public interface ApiInterface {

    @GET("flights/")
    Call<FlightReponse> getFlights(@Query("include") List<String> include);

    @GET("flights/")
    Call<FlightReponse> getFlights();

}

