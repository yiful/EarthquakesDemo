package com.example.yifu.earthquakesdemo.utility;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.yifu.earthquakesdemo.R;
import com.example.yifu.earthquakesdemo.view.MapsActivity;
import com.example.yifu.earthquakesdemo.model.Constants;
import com.example.yifu.earthquakesdemo.model.Earthquake;
import com.example.yifu.earthquakesdemo.model.FeaturesItem;

import java.util.List;

public class EarthquakesListAdapter extends ArrayAdapter<FeaturesItem> {
    private List<FeaturesItem> list;
    private Context context;

    public EarthquakesListAdapter(@NonNull Context context, int resource, @NonNull List<FeaturesItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.earthquake_list_item, parent, false);
        TextView tvMag = rowView.findViewById(R.id.tvMagnitude);
        TextView tvPlace = rowView.findViewById(R.id.tvPlace);
        tvMag.setText(list.get(position).getProperties().getMag()+"");
        tvPlace.setText(list.get(position).getProperties().getPlace());

        // set background color
        double mag = list.get(position).getProperties().getMag();
        if (mag >=0 && mag < 0.9) {
            rowView.setBackgroundColor(context.getResources().getColor(R.color.green));
        } else if (mag >= 9){
            rowView.setBackgroundColor(context.getResources().getColor(R.color.darkRed));
        } else {
            rowView.setBackgroundColor(context.getResources().getColor(R.color.orange));
        }

        // go to details screen onclicked
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                Earthquake earthquake = new Earthquake(
                        list.get(position).getProperties().getMag(),
                        list.get(position).getProperties().getTime(),
                        list.get(position).getProperties().getPlace(),
                        list.get(position).getGeometry().getCoordinates().toString());
                intent.putExtra(Constants.PARCELABLE_KEY, earthquake);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
