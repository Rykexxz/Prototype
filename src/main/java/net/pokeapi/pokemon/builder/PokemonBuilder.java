package net.pokeapi.pokemon.builder;

import net.pokeapi.ability.Ability;
import net.pokeapi.gender.Gender;
import net.pokeapi.pokemon.model.Pokemon;
import net.pokeapi.pokemon.model.Size;
import net.pokeapi.pokemon.species.PokemonSpeciesData;
import net.pokeapi.rng.Ratio;
import net.pokeapi.rng.Rng;
import net.pokeapi.stats.model.Nature;
import net.pokeapi.stats.value.Evs;
import net.pokeapi.stats.value.Ivs;

public class PokemonBuilder {

    private PokemonSpeciesData speciesData;
    private String nickname;
    private int level = 1;

    private Gender gender;
    private Ability ability;
    private Nature nature;
    private Boolean shiny;
    private Size size;

    private final Evs evs = new Evs();
    private final Ivs ivs = new Ivs();

    public PokemonBuilder species(PokemonSpeciesData data) {
        this.speciesData = data;
        return this;
    }

    public PokemonBuilder nickname(String name) {
        this.nickname = name;
        return this;
    }

    public PokemonBuilder level(int level) {
        this.level = level;
        return this;
    }

    public Pokemon build() {
        return new Pokemon(
                speciesData,
                nickname,
                level,
                gender != null ? gender : Ratio.generate(speciesData.genders()),
                ability != null ? ability : Ratio.generate(speciesData.abilities()),
                nature != null ? nature : Rng.randomEnum(Nature.class),
                size != null ? size : Rng.randomEnum(Size.class),
                shiny != null ? shiny : Rng.isShiny(),
                evs,
                ivs
        );
    }
}

