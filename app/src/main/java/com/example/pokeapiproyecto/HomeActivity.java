package com.example.pokeapiproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.pokeapiproyecto.adapter.PokemonItemListener;
import com.example.pokeapiproyecto.data.Pokemon;
import com.example.pokeapiproyecto.data.PokemonShort;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PokemonItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    private List<PokemonShort> parsePokemonList(String jsonStr) {
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObj.getJSONArray("results");
            ArrayList<PokemonShort> pokemonShortList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                String url = jsonArray.getJSONObject(i).getString("url");
                String name = jsonArray.getJSONObject(i).getString("name");
                pokemonShortList.add(new PokemonShort(url, name));
            }
            return pokemonShortList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onPokemonClicked(int position) {

    }
}
