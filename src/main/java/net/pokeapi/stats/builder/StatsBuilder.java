package net.pokeapi.stats.builder;

import net.pokeapi.stats.model.Stat;
import net.pokeapi.stats.model.Stats;

public class StatsBuilder {

    private final Stats stats = new Stats();

    public StatsBuilder stat(Stat stat, int amount) {
        stats.setStat(stat, amount);
        return this;
    }

    public StatsBuilder all(int amount) {
        stats.setAll(amount);
        return this;
    }

    public Stats build() {
        return stats;
    }
}

