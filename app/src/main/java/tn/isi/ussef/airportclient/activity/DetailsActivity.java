package tn.isi.ussef.airportclient.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import tn.isi.ussef.airportclient.R;
import tn.isi.ussef.airportclient.model.Flight;
import tn.isi.ussef.airportclient.model.StationInfo;

public class DetailsActivity extends AppCompatActivity {

    Flight item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Gson gson = new Gson();
        item = gson.fromJson(getIntent().getStringExtra("Flight"), Flight.class);
        new ViewHolder().bind(item);
    }

    public class ViewHolder {
        TextView status;
        TextView number;
        TextView datetime_arrival;
        TextView iataCode_arrival;
        TextView city_arrival;
        TextView state_arrival;
        TextView datetime_departure;
        TextView iataCode_departure;
        TextView city_departure;
        TextView state_departure;

        public ViewHolder( ) {
            super();
            status = (TextView) findViewById(R.id.flight_status);
            number = (TextView) findViewById(R.id.flight_number);
            datetime_arrival = (TextView) findViewById(R.id.datetime_arrival_text_value);
            iataCode_arrival = (TextView) findViewById(R.id.iataCode_arrival_text_value);
            city_arrival = (TextView) findViewById(R.id.city_arrival_text_value);
            state_arrival = (TextView) findViewById(R.id.state_arrival_text_value);
            datetime_departure = (TextView) findViewById(R.id.datetime_departure_text_value);
            iataCode_departure = (TextView) findViewById(R.id.iataCode_departure_text_value);
            city_departure = (TextView) findViewById(R.id.city_departure_text_value);
            state_departure = (TextView) findViewById(R.id.state_departure_text_value);
        }

        public void bind(Flight item) {
            number.setText(item.getFlightNumber());
            status.setText(item.getStatus());
            StationInfo arrival = item.getArrival();
            StationInfo departure = item.getDeparture();
            datetime_arrival.setText(arrival.getDatetime());
            iataCode_arrival.setText(arrival.getIataCode());
            city_arrival.setText(arrival.getCity());
            state_arrival.setText(arrival.getState());
            datetime_departure.setText(departure.getDatetime());
            iataCode_departure.setText(departure.getIataCode());
            city_departure.setText(departure.getCity());
            state_departure.setText(departure.getState());
        }
    }
}
