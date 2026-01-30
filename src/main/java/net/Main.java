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
        // Muitos erros :[

        PokemonSpeciesData p = PokemonRegistry.get(Species.CHARIZARD, Form.DEFAULT);
        Pokemon po = new PokemonBuilder()
                .level(100)
                .species(p)
                .build();
        p.print();
        System.out.println();
        System.out.println("Gender: " + po.getGender());
        System.out.println("Ability: " + po.getAbility());
    }
}
