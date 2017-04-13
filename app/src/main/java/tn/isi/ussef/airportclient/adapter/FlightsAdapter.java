package tn.isi.ussef.airportclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import tn.isi.ussef.airportclient.R;
import tn.isi.ussef.airportclient.model.Flight;

/**
 * Created by Ussef on 3/10/2017.
 */
public class FlightsAdapter extends
        RecyclerView.Adapter<FlightsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Flight item);
    }
    private static final String TAG = FlightsAdapter.class.getSimpleName();

    private Context context;
    private List<Flight> list;
    private int rowLayout;
    private final OnItemClickListener listener;



    public  class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout flightLayout;
        TextView number;
        TextView status;

        public ViewHolder(View itemView) {
            super(itemView);

            flightLayout = (LinearLayout) itemView.findViewById(R.id.flight_layout);
            number = (TextView) itemView.findViewById(R.id.flight_number);
            status = (TextView) itemView.findViewById(R.id.flight_status);
        }
        public void bind(final Flight item, final OnItemClickListener listener) {
            number.setText(item.getFlightNumber());
            status.setText(item.getStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }

    public FlightsAdapter(List<Flight> list, int rowLayout, Context context, OnItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.rowLayout = rowLayout;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flight item = list.get(position);
        holder.bind(item, listener);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}

