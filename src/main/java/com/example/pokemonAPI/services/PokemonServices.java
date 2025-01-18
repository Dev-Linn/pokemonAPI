package com.example.pokemonAPI.services;

import com.example.pokemonAPI.model.Pokemons;
import com.example.pokemonAPI.repository.PokemonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServices {
    private PokemonsRepository pokemonsRepository;

    public PokemonServices(PokemonsRepository pokemonsRepository) {
        this.pokemonsRepository = pokemonsRepository;
    }

    public List<Pokemons> getAllPokemons() {
        return pokemonsRepository.findAll();
    }

    public Pokemons getPokemonById(Long id) {
        return pokemonsRepository.findById(id).orElseThrow(()-> new RuntimeException("Pokémon não encontrado"));
    }

    public Pokemons getPokemonsByName(String name) {
        return pokemonsRepository.findByName(name).orElse(null);
    }

    public Pokemons addPokemons(Pokemons pokemons){
        return pokemonsRepository.save(pokemons);
    }

    public String deletePokemonsById(Long id){
        pokemonsRepository.deleteById(id);
        return "Pokemon deletado com sucesso! / 200";
    }

    public Pokemons updatePokemons(Long id, Pokemons pokemons){
        return pokemonsRepository.findById(id).map(updatePokemons -> {
            updatePokemons.setName(pokemons.getName());
            updatePokemons.setType(pokemons.getType());
            updatePokemons.setImageUrl(pokemons.getImageUrl());
            return pokemonsRepository.save(updatePokemons);
        })
                .orElseThrow(() -> new RuntimeException("Erro ao atualizar o pokemon"));
    }



}
