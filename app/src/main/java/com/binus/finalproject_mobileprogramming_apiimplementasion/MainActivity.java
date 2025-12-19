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
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnAllCharacters, btnSearchCharacter, btnAllPlanets, btnSearchPlanet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}