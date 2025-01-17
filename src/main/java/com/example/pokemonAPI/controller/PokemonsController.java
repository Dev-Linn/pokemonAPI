package com.example.pokemonAPI.controller;

import com.example.pokemonAPI.model.Pokemons;
import com.example.pokemonAPI.repository.PokemonsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonsController {

    private final PokemonsRepository pokemonsRepository;
    public PokemonsController(PokemonsRepository pokemonsRepository) {
        this.pokemonsRepository = pokemonsRepository;
    }

    @GetMapping
    public List<Pokemons> getAllPokemons() {
        return pokemonsRepository.findAll();
    }

    @GetMapping("{id}")
    public Pokemons getPokemonsById(@PathVariable Long id){
        return pokemonsRepository.findById(id).orElseThrow(()-> new RuntimeException("Pokémon não encontrado"));

    }

    @PostMapping
    public Pokemons savePokemon(@RequestBody Pokemons pokemon){
        return pokemonsRepository.save(pokemon);
    }


    @PutMapping("{id}")
    public Pokemons updatePokemon(@PathVariable Long id,@RequestBody Pokemons updatePokemon ){
        return pokemonsRepository.findById(id).map(pokemon -> {
            pokemon.setName(updatePokemon.getName());
            pokemon.setType(updatePokemon.getType());
            pokemon.setImageUrl(updatePokemon.getImageUrl());
            return pokemonsRepository.save(pokemon);
        })
                .orElseThrow(() -> new RuntimeException("Pokemon não encontrado"));
    }

    @DeleteMapping("{id}")
    public String deletePokemon(@PathVariable Long id){
        pokemonsRepository.deleteById(id);
        return "Pokemon deletado com sucesso";
    }

}
