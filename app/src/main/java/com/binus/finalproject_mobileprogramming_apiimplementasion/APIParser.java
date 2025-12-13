package com.binus.finalproject_mobileprogramming_apiimplementasion;

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

}
