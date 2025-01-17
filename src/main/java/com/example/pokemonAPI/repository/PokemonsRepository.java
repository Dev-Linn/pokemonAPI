package com.example.pokemonAPI.repository;

import com.example.pokemonAPI.model.Pokemons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonsRepository extends JpaRepository<Pokemons, Long> {
}
