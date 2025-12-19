package com.binus.finalproject_mobileprogramming_apiimplementasion;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class APIParser {
    public ArrayList<DragonBallCharacter> parseJsonToCharacter(JSONObject source){
        ArrayList<DragonBallCharacter> characters = new ArrayList<>();
        try{
            JSONArray jArrCharacters = source.getJSONArray("items");
            for(int i = 0; i < jArrCharacters.length(); i++){
                DragonBallCharacter character = new DragonBallCharacter();
                character.id = ((JSONObject)jArrCharacters.get(i)).getInt("id");
                character.name = ((JSONObject)jArrCharacters.get(i)).getString("name");
                character.ki = ((JSONObject)jArrCharacters.get(i)).getString("ki");
                character.maxKi = ((JSONObject)jArrCharacters.get(i)).getString("maxKi");
                character.race = ((JSONObject)jArrCharacters.get(i)).getString("race");
                character.gender = ((JSONObject)jArrCharacters.get(i)).getString("gender");
                character.description = ((JSONObject)jArrCharacters.get(i)).getString("description");
                character.imageURL = ((JSONObject)jArrCharacters.get(i)).getString("image");
                character.affiliation = ((JSONObject)jArrCharacters.get(i)).getString("affiliation");
                characters.add(character);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return characters;
    }
    public ArrayList<DragonBallPlanet> parseJsonToPlanet(JSONObject source){
        ArrayList<DragonBallPlanet> planets = new ArrayList<>();
        try{
            JSONArray jArrPlanets = source.getJSONArray("items");
            Log.v("Jumlah Item", ""+jArrPlanets.length());
            for(int i = 0; i < jArrPlanets.length(); i++){
                DragonBallPlanet planet = new DragonBallPlanet();
                planet.id = ((JSONObject)jArrPlanets.get(i)).getInt("id");
                planet.name = ((JSONObject)jArrPlanets.get(i)).getString("name");
                planet.isDestroyed = ((JSONObject)jArrPlanets.get(i)).getBoolean("isDestroyed");
                planet.description = ((JSONObject)jArrPlanets.get(i)).getString("description");
                planet.imageURL = ((JSONObject)jArrPlanets.get(i)).getString("image");
                planets.add(planet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return planets;
    }
    public ArrayList<DragonBallCharacter> parseJsonArrayResponseCharacter(String jsonResponse) {
        ArrayList<DragonBallCharacter> characters = new ArrayList<>();
        try {
            // Response langsung array, jadi langsung parse sebagai JSONArray
            JSONArray jsonArray = new JSONArray(jsonResponse);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject characterObj = jsonArray.getJSONObject(i);
                DragonBallCharacter character = new DragonBallCharacter();

                // Parse semua field dari response
                character.id = characterObj.getInt("id");
                character.name = characterObj.getString("name");
                character.ki = characterObj.getString("ki");
                character.maxKi = characterObj.getString("maxKi");
                character.race = characterObj.getString("race");
                character.gender = characterObj.getString("gender");
                character.description = characterObj.getString("description");
                character.imageURL = characterObj.getString("image");
                character.affiliation = characterObj.getString("affiliation");

                characters.add(character);

                // Debug log
                Log.v("Parsed Character", character.name + " - " + character.race);
            }

            Log.v("Parsing Result", "Successfully parsed " + characters.size() + " characters");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Parsing Error", "Failed to parse JSON array: " + e.getMessage());
        }
        return characters;
    }
    public ArrayList<DragonBallPlanet> parseJsonArrayResponsePlanet(String jsonResponse) {
        ArrayList<DragonBallPlanet> planets = new ArrayList<>();
        try {
            // Response langsung array, jadi langsung parse sebagai JSONArray
            JSONArray jsonArray = new JSONArray(jsonResponse);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject characterObj = jsonArray.getJSONObject(i);
                DragonBallPlanet planet = new DragonBallPlanet();

                // Parse semua field dari response
                planet.id = characterObj.getInt("id");
                planet.name = characterObj.getString("name");
                planet.isDestroyed = characterObj.getBoolean("isDestroyed");
                planet.description = characterObj.getString("description");
                planet.imageURL = characterObj.getString("image");

                planets.add(planet);

                // Debug log
                Log.v("Parsed Planet", planet.name + " - " + planet.isDestroyed);
            }

            Log.v("Parsing Result", "Successfully parsed " + planets.size() + " characters");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Parsing Error", "Failed to parse JSON array: " + e.getMessage());
        }
        return planets;
    }

}
