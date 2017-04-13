package tn.isi.ussef.airportclient.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tn.isi.ussef.airportclient.R;
import tn.isi.ussef.airportclient.adapter.FlightsAdapter;
import tn.isi.ussef.airportclient.model.Flight;
import tn.isi.ussef.airportclient.model.StationInfo;
import tn.isi.ussef.airportclient.model.FlightReponse;
import tn.isi.ussef.airportclient.rest.ApiClient;
import tn.isi.ussef.airportclient.rest.ApiInterface;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "tn.isi.ussef.airportclient.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.flights_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> includes = new ArrayList<>();
        includes.add("arrival,departure");

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<FlightReponse> call = apiService.getFlights(includes);
        call.enqueue(new Callback<FlightReponse>() {
            @Override
            public void onResponse(Call<FlightReponse> call, Response<FlightReponse> response) {
                final List<Flight>flights = response.body().getResults() ;
                recyclerView.setAdapter(new FlightsAdapter(flights, R.layout.flight_item, getApplicationContext(), new FlightsAdapter.OnItemClickListener(){
                        @Override public void onItemClick(Flight item) {
                            Toast.makeText(getApplicationContext(), (item.getDeparture() != null) ? item.getDeparture().getCity() : item.toString(), Toast.LENGTH_LONG).show();
                            goToDetails(item);
                        }
                    }));
                Toast.makeText(MainActivity.this, flights.size()+"", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Number of movie Received: " + flights.size());
            }

            @Override
            public void onFailure(Call<FlightReponse> call, Throwable t) {

                Log.d(TAG,  "Number of movie Received: " +t.toString());
                Toast.makeText(MainActivity.this, "Can't access" +t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        // new  LongOperation().execute("");
            Toast.makeText(this, call.toString(), Toast.LENGTH_SHORT).show();
    }

    void  goToDetails(Flight flight){
        Intent intent = new Intent(this, DetailsActivity.class);
        Gson gson = new Gson();
        String myJson = gson.toJson(flight);
        intent.putExtra("Flight", myJson);
        startActivity(intent);
    }

}
