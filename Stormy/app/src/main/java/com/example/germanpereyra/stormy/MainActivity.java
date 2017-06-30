package com.example.germanpereyra.stormy;

import android.app.DialogFragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.germanpereyra.stormy.model.CurrentWeather;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CurrentWeather currentWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            if (!this.isNetworkAvailable()) {
                Toast.makeText(this, "Network not available", Toast.LENGTH_SHORT).show();
            } else {
                run();
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("https://api.darksky.net/forecast/4ce8c62723708781686b4ac1b3684ddb/37.8267,-122.4233")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                showError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                String jsonData = response.body().string();
                try {
                    currentWeather = getCurrentDetails(jsonData);
                } catch (JSONException e) {
                    showError();
                }

            }
        });
    }

    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        CurrentWeather result = new CurrentWeather();
        JSONObject currently = forecast.getJSONObject("currently");
        result.setTime(currently.getLong("time"));
        result.setHumedity(currently.getDouble("humidity"));
        result.setTemperature(currently.getDouble("temperature"));
        result.setPrecipitationChance(currently.getDouble("precipProbability"));
        result.setIcon(currently.getString("icon"));
        result.setSummary(currently.getString("summary"));
        result.setTimeZone(forecast.getString("timezone"));

        Log.v(TAG, result.getFormattedDate());
        return result;

    }

    protected void showError() {
        DialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }

    protected boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = networkInfo != null && networkInfo.isConnected();
        return isAvailable;
    }

    
}
