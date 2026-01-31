package net.pokeapi.pokemon.model;

import net.pokeapi.ability.Ability;
import net.pokeapi.gender.Gender;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.move.model.Move;
import net.pokeapi.pokemon.species.PokemonFlag;
import net.pokeapi.pokemon.species.PhysicalSize;
import net.pokeapi.pokemon.species.PokemonSpeciesData;
import net.pokeapi.stats.calc.StatsCalculator;
import net.pokeapi.stats.model.Nature;
import net.pokeapi.stats.model.Stats;
import net.pokeapi.stats.value.Evs;
import net.pokeapi.stats.value.Ivs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Pokemon {

    private final PokemonSpeciesData speciesData;

    private final String nickname;
    private final Gender gender;
    private final Ability ability;
    private final Nature nature;
    private final boolean shiny;
    public final Size size;

    private final List<Move> moveset = new ArrayList<>();

    private final int level;
    private final Evs evs;
    private final Ivs ivs;
    private Stats finalStats;

    public Pokemon(
            PokemonSpeciesData speciesData,
            String nickname,
            int level,
            Gender gender,
            Ability ability,
            Nature nature,
            Size size,
            boolean shiny,
            Evs evs,
            Ivs ivs
    ) {
        this.speciesData = speciesData;
        this.nickname = nickname;
        this.level = level;
        this.gender = gender;
        this.ability = ability;
        this.nature = nature;
        this.size = size;
        speciesData.size().setSize(size.getScale());
        this.shiny = shiny;
        this.evs = evs;
        this.ivs = ivs;

        setFinalStats();
    }

    public void setFinalStats() {
        this.finalStats = StatsCalculator.calculate(
                new Stats(speciesData.baseStats()),
                ivs,
                evs,
                level,
                nature
        );
    }

    public Stats getStats() {
        return finalStats;
    }

    public int getCatchRate() {
        return speciesData.catchRate();
    }

    public int getBaseExp() {
        return speciesData.baseExp();
    }

    public boolean isShiny() {
        return shiny;
    }

    public int getLevel() {
        return level;
    }

    public Evs getEvs() {
        return evs;
    }

    public Ivs getIvs() {
        return ivs;
    }

    public Nature getNature() {
        return nature;
    }

    public Size getSize() {
        return size;
    }

    public Gender getGender() {
        return gender;
    }

    public Ability getAbility() {
        return ability;
    }

    public String getNickname() {
        return nickname;
    }

    public PokemonFlag getPokemonFlag() {
        return speciesData.flag();
    }

    public PhysicalSize getPokemonSize() {
        return speciesData.size();
    }

    public double getHeight() {
        return getPokemonSize().height() * size.getScale();
    }

    public double getWeight() {
        return getPokemonSize().weight() * size.getScale();
    }

    // Moveset
    public boolean canRemoveMove(MoveId id) {
        if (moveset.size() <= 1) return false;
        return haveMove(id);
    }

    public void removeMove(MoveId id) {
        moveset.removeIf(move -> move.id == id);
    }

    public Move getMove(MoveId id) {
        return moveset.stream()
                .filter(move -> move.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean haveMove(MoveId id) {
        return moveset.stream().anyMatch(move -> move.id == id);
    }

    public boolean canAddMove(Move move) {
        if (moveset.size() == 4) return false;
        return !haveMove(move.id);
    }

    public void addMove(Move move) {
        if(!canAddMove(move)) return;

        moveset.add(move);
    }

    public List<Move> getMoveset() {
        return moveset;
    }
}
