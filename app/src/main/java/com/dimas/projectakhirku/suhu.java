package com.dimas.projectakhirku;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class suhu extends AppCompatActivity {
    String API = "8118ed6ee68db2debfaaa5a44c832918";
    TextView alamat, tanggal, suhu, kelembapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suhu);
        alamat = findViewById(R.id.alamat);
        tanggal = findViewById(R.id.tanggal);
        suhu = findViewById(R.id.suhu);
        kelembapan = findViewById(R.id.kelembapan);
        new weatherTask().execute();

    }
    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /* Showing the ProgressBar, Making the main design GONE */
            findViewById(R.id.loader).setVisibility(View.VISIBLE);
            findViewById(R.id.mainContainer).setVisibility(View.GONE);
            findViewById(R.id.errorText).setVisibility(View.GONE);
        }

        protected String doInBackground(String... args) {
            String temp_lat1 = "-8.0328999";
            String temp_lon1 = "112.6338516";
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?lat=" + temp_lat1 + "&lon=" + temp_lon1 + "&appid=" + API);

            return response;
        }

        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String temp = main.getString("temp");
                DecimalFormat df = new DecimalFormat("#.#");
                double temp_C = Double.parseDouble(temp) - 273;
                double temp_S = Double.parseDouble(df.format(temp_C));
                String temp_F = String.valueOf(temp_S) + "°C";
                String humidity = main.getString("humidity");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");


                /* Populating extracted data into our views */
                alamat.setText(address);
                tanggal.setText(updatedAtText);
                suhu.setText(temp_F);
                kelembapan.setText(humidity);

                /* Views populated, Hiding the loader, Showing the main design */
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.mainContainer).setVisibility(View.VISIBLE);


            } catch (JSONException e) {
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.errorText).setVisibility(View.VISIBLE);
            }

        }
    }
}