package com.example.pokemonAPI.configuration;

import com.example.pokemonAPI.model.Pokemons;
import com.example.pokemonAPI.repository.PokemonsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final PokemonsRepository pokemonsRepository;

    public Config(PokemonsRepository pokemonsRepository) {
        this.pokemonsRepository = pokemonsRepository;
    }
    @PostConstruct
    public void LoadPokemons(){
        pokemonsRepository.save(new Pokemons(null, "Pikachu", "Electric", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"));
        pokemonsRepository.save(new Pokemons(null, "Charizard", "Fire/Flying", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"));
        pokemonsRepository.save(new Pokemons(null, "Bulbasaur", "Grass/Poison", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"));
    }
}
