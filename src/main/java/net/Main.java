package net;

import net.pokeapi.pokemon.builder.PokemonBuilder;
import net.pokeapi.pokemon.model.Pokemon;
import net.pokeapi.pokemon.registry.PokemonRegistry;
import net.pokeapi.pokemon.species.Form;
import net.pokeapi.pokemon.species.PokemonSpeciesData;
import net.pokeapi.pokemon.species.Species;

public class Main {

    public static void main(String[] args) {
        // Testando
        PokemonRegistry.init();

        PokemonSpeciesData p = PokemonRegistry.get(Species.MEW, Form.DEFAULT);
        Pokemon po = new PokemonBuilder()
                .level(100)
                .species(p)
                .build();
        po.getPokemonSize().print();
        System.out.println("Level: " + po.getLevel());
        System.out.println("Gender: " + po.getGender());
        System.out.println("Ability: " + po.getAbility());
    }
}
