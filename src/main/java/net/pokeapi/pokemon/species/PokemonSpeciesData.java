package net.pokeapi.pokemon.species;

import net.pokeapi.ability.Ability;
import net.pokeapi.category.Category;
import net.pokeapi.gender.Gender;
import net.pokeapi.stats.model.Stat;
import net.pokeapi.types.Type;

import java.util.List;
import java.util.Map;

public record PokemonSpeciesData(
        Species species,
        Form form,
        Category category,
        int dexNumber,
        int catchRate,
        int baseExp,
        int baseFriendship,
        Generation generation,
        List<Type> types,
        Map<Stat, Integer> baseStats,
        PokemonFlag pokemonFlag,
        Map<Ability, Double> abilities,
        Map<Gender, Double> genders
) {
    public void print() {
        System.out.println("Species: " + species);
        System.out.println("Form: " + form);
        System.out.println("Category: " + category);
        System.out.println("DexNumber: " + dexNumber);
        System.out.println("CatchRate: " + catchRate);
        System.out.println("BaseExp: " + baseExp);
        System.out.println("BaseFriendship: " + baseFriendship);
        System.out.println("Generation: " + generation);
        System.out.println("Types: " + types);
        System.out.println("BaseStats: " + baseStats);
        System.out.println("PokemonFlag: " + pokemonFlag);
        System.out.println("Abilities: " + abilities);
        System.out.println("Genders: " + genders);
    }
}
