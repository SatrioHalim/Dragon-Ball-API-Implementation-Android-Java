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

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AllPlanetsActivity extends AppCompatActivity {

    private RecyclerView rvPlanets;
    private PlanetAdapter planetAdapter;
    private ArrayList<DragonBallPlanet> planets = new ArrayList<>();
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_planets);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Planets List");

        rvPlanets = findViewById(R.id.rvPlanets);
        rvPlanets.setLayoutManager(new LinearLayoutManager(this));
        planetAdapter = new PlanetAdapter(planets);
        rvPlanets.setAdapter(planetAdapter);

        GetAllPlanetsTask task = new GetAllPlanetsTask();
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
    private class GetAllPlanetsTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            try {
                URL url = new URL("https://dragonball-api.com/api/planets");
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
            Log.v("All Planets Response", s);

            APIParser apiParser = new APIParser();
            try {
                ArrayList<DragonBallPlanet> tempPlanets = apiParser.parseJsonToPlanet(new JSONObject(s));
                planets.clear();
                planets.addAll(tempPlanets);
                planetAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}