package com.binus.finalproject_mobileprogramming_apiimplementasion;

import androidx.annotation.ReturnThis;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    TextView tvName, tvRace;
//    ImageView ivImage;
//    Button btnAll;
//    RecyclerView rvCharacters;
//    CharacterAdapter characterAdapter;
//    ArrayList<DragonBallCharacter> characters = new ArrayList<>();
    private Button btnAllCharacters, btnSearchCharacter, btnAllPlanets, btnSearchPlanet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tvName = findViewById(R.id.tvNameTesting);
//        tvRace = findViewById(R.id.tvRaceTesting);
//        ivImage = findViewById(R.id.ivImageTesting);

//        rvCharacters = findViewById(R.id.rvMainCharacter);
//        rvCharacters.setLayoutManager(new LinearLayoutManager(this));
//
//        GetAllCharactersTask task1 = new GetAllCharactersTask();
//        task1.execute();
//    btnAll = findViewById(R.id.btnAllChar);
//    btnAll.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(MainActivity.this,AllCharactersActivityTesting.class);
//            startActivity(intent);
//        }
//    });
        btnAllCharacters = findViewById(R.id.btnAllCharacters);
        btnSearchCharacter = findViewById(R.id.btnSearchCharacter);
        btnAllPlanets = findViewById(R.id.btnAllPlanets);
        btnSearchPlanet = findViewById(R.id.btnSearchPlanet);

        btnAllCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllCharactersActivity.class);
                startActivity(intent);
            }
        });

        btnSearchCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchCharacterActivity.class);
                startActivity(intent);
            }
        });

        btnAllPlanets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllPlanetsActivity.class);
                startActivity(intent);
            }
        });

        btnSearchPlanet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchPlanetActivity.class);
                startActivity(intent);
            }
        });

    }

//    private String readStream(InputStream is){
//        try {
//            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//            int i = is.read();
//            while (i != -1){
//                buffer.write(i);
//                i = is.read();
//            }
//            return buffer.toString();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "";
//    }
//    private class GetAllCharactersTask extends AsyncTask<Void, Void, String>{
//
//        @Override
//        protected String doInBackground(Void... voids) {
//            String result = "";
//            try {
//                URL url = new URL("https://dragonball-api.com/api/characters");
//                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                result = readStream(in);
//                urlConnection.disconnect();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            Log.v("response",s);
//
//            APIParser apiParser = new APIParser();
//            ArrayList<DragonBallCharacter> tempCharacters = new ArrayList<>();
//            try {
//                tempCharacters = apiParser.parseJsonToCharacter(new JSONObject(s));
//                Log.v("Nama character", tempCharacters.get(1).name);
//            }catch (Exception e){
//                e.printStackTrace();
//                Log.v("Error","Error");
//            };
//            characters.addAll(tempCharacters);
//            Log.v("Testing", "" + characters.get(8).name);
//            characterAdapter = new CharacterAdapter(characters);
//            rvCharacters.setAdapter(characterAdapter);
//        }
//    }

}