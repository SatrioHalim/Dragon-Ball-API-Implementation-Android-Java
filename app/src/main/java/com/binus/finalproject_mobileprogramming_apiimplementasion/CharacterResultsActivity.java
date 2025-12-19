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

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class CharacterResultsActivity extends AppCompatActivity {

    private RecyclerView rvCharacters;
    private CharacterAdapter characterAdapter;
    private ArrayList<DragonBallCharacter> characters = new ArrayList<>();
    private Toolbar toolbar;

    private String searchName;
    private String searchGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_results);

        searchName = getIntent().getStringExtra("SEARCH_NAME");
        searchGender = getIntent().getStringExtra("SEARCH_GENDER");
        Log.v("SEARCH_NAME",searchName);
        Log.v("SEARCH_GENDER",searchGender);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (!searchName.isEmpty()) {
            getSupportActionBar().setTitle("Results for: " + searchName);
        } else if (!searchGender.equals("Male")) {
            getSupportActionBar().setTitle(searchGender + " Characters");
        }

        rvCharacters = findViewById(R.id.rvCharacters);
        rvCharacters.setLayoutManager(new LinearLayoutManager(this));
        characterAdapter = new CharacterAdapter(characters);
        rvCharacters.setAdapter(characterAdapter);

        SearchCharactersTask task = new SearchCharactersTask();
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
    private class SearchCharactersTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            try {
                // Build API URL dengan parameter
                StringBuilder apiUrl = new StringBuilder("https://dragonball-api.com/api/characters?");
                apiUrl.append("name=").append(URLEncoder.encode(searchName, "UTF-8"));
                apiUrl.append("&");
                apiUrl.append("gender=").append(URLEncoder.encode(searchGender, "UTF-8"));

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
                ArrayList<DragonBallCharacter> tempCharacters = apiParser.parseJsonArrayResponseCharacter(s);
                characters.clear();
                characters.addAll(tempCharacters);
                characterAdapter.notifyDataSetChanged();

                // Show result count
                Toast.makeText(CharacterResultsActivity.this,
                        "Found " + characters.size() + " characters",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(CharacterResultsActivity.this,
                        "No characters found",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}