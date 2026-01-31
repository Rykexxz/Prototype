package net;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.move.model.DamageMove;
import net.pokeapi.move.model.Move;
import net.pokeapi.move.model.PhysicalMove;
import net.pokeapi.move.registry.MoveRegistry;
import net.pokeapi.pokemon.builder.PokemonBuilder;
import net.pokeapi.pokemon.model.Pokemon;
import net.pokeapi.pokemon.registry.PokemonRegistry;
import net.pokeapi.pokemon.species.Form;
import net.pokeapi.pokemon.species.PokemonSpeciesData;
import net.pokeapi.pokemon.species.Species;

public class Main {

    public static void main(String[] args) {
        // Testando

        /*Move move = MoveRegistry.get(MoveId.TACKLE);
        if (move instanceof PhysicalMove physical) {
            System.out.println("Poder: " + physical.power);
            System.out.println("Stat de ataque: " + physical.getAttackStat());
        }*/

    }
}
