package com.example.pokemonAPI.controller;

import com.example.pokemonAPI.model.Pokemons;
import com.example.pokemonAPI.services.PokemonServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonsController {


    private final PokemonServices pokemonServices;

    public PokemonsController(PokemonServices pokemonServices) {
        this.pokemonServices = pokemonServices;
    }

    @GetMapping
    public List<Pokemons> getAllPokemons() {
        return pokemonServices.getAllPokemons();
    }
    @GetMapping("{id}")
    public Pokemons getPokemonById(@PathVariable Long id) {
        return pokemonServices.getPokemonById(id);
    }

    @GetMapping("/search")
    public Pokemons getPokemonByName(@RequestParam String name) {
        return pokemonServices.getPokemonsByName(name);
    }

    @PostMapping
    public Pokemons savePokemon(@RequestBody Pokemons pokemon) {
        return pokemonServices.addPokemons(pokemon);
    }

    @DeleteMapping("{id}")
    public String deletePokemonById(@PathVariable Long id) {
         pokemonServices.deletePokemonsById(id);
         return "Pokemon deletado com sucesso!";
    }

    @PutMapping("{id}")
    public Pokemons updatePokemonById(@PathVariable Long id, @RequestBody Pokemons pokemon) {
        return pokemonServices.updatePokemons(id, pokemon);
    }



}
