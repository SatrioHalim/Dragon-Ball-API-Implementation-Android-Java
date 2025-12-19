package com.binus.finalproject_mobileprogramming_apiimplementasion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class PlanetResultsActivity extends AppCompatActivity {

    private RecyclerView rvPlanets;
    private PlanetAdapter planetAdapter;
    private ArrayList<DragonBallPlanet> planets = new ArrayList<>();
    private Toolbar toolbar;

    private String searchName;
    private String searchStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_results);

        searchName = getIntent().getStringExtra("SEARCH_NAME");
        searchStatus = getIntent().getStringExtra("SEARCH_STATUS");
        Log.v("SEARCH_NAME",searchName);
        Log.v("SEARCH_STATUS",searchStatus);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (!searchName.isEmpty()) {
            getSupportActionBar().setTitle("Results for: " + searchName);
        }

        rvPlanets = findViewById(R.id.rvPlanets);
        rvPlanets.setLayoutManager(new LinearLayoutManager(this));
        planetAdapter = new PlanetAdapter(planets);
        rvPlanets.setAdapter(planetAdapter);

        SearchPlanetsTask task = new SearchPlanetsTask();
        task.execute();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1) {
                buffer.write(i);
                i = is.read();
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private class SearchPlanetsTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            try {
                // Build API URL dengan parameter
                StringBuilder apiUrl = new StringBuilder("https://dragonball-api.com/api/planets?");
                apiUrl.append("name=").append(URLEncoder.encode(searchName, "UTF-8"));
                apiUrl.append("&");
                if(searchStatus.equals("Destroyed")){
                    apiUrl.append("isDestroyed=true");
                } else {
                    apiUrl.append("isDestroyed=false");
                }

                Log.v("API URL", apiUrl.toString());

                URL url = new URL(apiUrl.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                result = readStream(in);
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.v("Search Results", s);

            APIParser apiParser = new APIParser();
            try {
                ArrayList<DragonBallPlanet> tempPlanets = apiParser.parseJsonArrayResponsePlanet(s);
                planets.clear();
                planets.addAll(tempPlanets);
                planetAdapter.notifyDataSetChanged();

                // Show result count
                Toast.makeText(PlanetResultsActivity.this,
                        "Found " + planets.size() + " planets",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(PlanetResultsActivity.this,
                        "No planets found",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}