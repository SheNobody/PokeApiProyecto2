package com.example.pokeapiproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokeapiproyecto.data.PokemonShort;

public class DetallePokemon extends AppCompatActivity {
    PokemonShort pokemonShort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);
        Parcelable extra = getIntent().getParcelableExtra(HomeActivity.EXTRA_DATA);
        if (extra instanceof PokemonShort) {
            pokemonShort = (PokemonShort) extra;
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            finish();
        }
        TextView textView = findViewById(R.id.pokemonInfo);
        String info =
                "ID: " + pokemonShort.getId() + "\n"
                        + "NAME: " + pokemonShort.getName() + "\n"
                        + "URL: " + pokemonShort.getUrl();
        textView.setText(info);
    }

}