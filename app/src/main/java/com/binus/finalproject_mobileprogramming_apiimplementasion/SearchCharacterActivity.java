package com.binus.finalproject_mobileprogramming_apiimplementasion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SearchCharacterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText etCharacterName;
    private RadioGroup rgRace;
    private Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_character);

        // Setup Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize views
        etCharacterName = findViewById(R.id.etCharacterName);
        rgRace = findViewById(R.id.rgRace);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void performSearch() {
        String name = etCharacterName.getText().toString().trim();
        String race = getSelectedRace();

        // Validasi
        if (name.isEmpty() && race.equals("All Races")) {
            Toast.makeText(this, "Please enter search criteria", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kirim data ke CharacterResultsActivity
        Intent intent = new Intent(this, CharacterResultsActivity.class);
        intent.putExtra("SEARCH_NAME", name);
        intent.putExtra("SEARCH_RACE", race);
        startActivity(intent);
    }
    private String getSelectedRace() {
        int selectedId = rgRace.getCheckedRadioButtonId();

        if (selectedId == R.id.rbAllRace) {
            return "All Races";
        } else if (selectedId == R.id.rbSaiyan) {
            return "Saiyan";
        } else if (selectedId == R.id.rbHuman) {
            return "Human";
        } else if (selectedId == R.id.rbNamekian) {
            return "Namekian";
        }
        return "All Races";
    }
}