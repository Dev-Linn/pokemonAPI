package com.example.pokemonAPI.repository;

import com.example.pokemonAPI.model.Pokemons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonsRepository extends JpaRepository<Pokemons, Long> {

    Optional<Pokemons> findByName(String name);
}
