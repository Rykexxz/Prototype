package net.pokeapi.util.key;

import net.pokeapi.pokemon.species.Form;
import net.pokeapi.pokemon.species.Species;

public record SpeciesFormKey(Species species, Form form) {
}
