package com.example.yifu.earthquakesdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.yifu.earthquakesdemo.R;
import com.example.yifu.earthquakesdemo.model.EarthquakesResponse;
import com.example.yifu.earthquakesdemo.network.APIService;
import com.example.yifu.earthquakesdemo.network.ApiClient;
import com.example.yifu.earthquakesdemo.utility.EarthquakesListAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverviewActivity extends AppCompatActivity {
    private static final String TAG = OverviewActivity.class.getName();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        listView = findViewById(R.id.listview);
        getEarthquakes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summary_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_refresh) {
            getEarthquakes();
        }
        return super.onOptionsItemSelected(item);
    }

    // making the earthquakes summary call
    private void getEarthquakes() {
        APIService APIService = ApiClient.getClient().create(APIService.class);
        Call<EarthquakesResponse> earthQuakesResponseCall = APIService.getEarthQuakes();
        earthQuakesResponseCall.enqueue(new Callback<EarthquakesResponse>() {
            @Override
            public void onResponse(Call<EarthquakesResponse> call, Response<EarthquakesResponse> response) {
                Log.i(TAG, response.body().toString());
                EarthquakesListAdapter adapter = new EarthquakesListAdapter(OverviewActivity.this,
                        R.layout.earthquake_list_item, response.body().getFeatures());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<EarthquakesResponse> call, Throwable t) {
                Log.d(TAG, "failed to load earthquakes summary. ");
            }
        });
    }
}
