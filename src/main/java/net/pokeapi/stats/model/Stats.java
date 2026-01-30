package net.pokeapi.stats.model;

import java.util.EnumMap;

public class Stats {
    protected EnumMap<Stat, Integer> stats = new EnumMap<>(Stat.class);

    public Stats() {
        for (Stat s : Stat.values()) {
            stats.put(s, 0);
        }
    }

    public Stats(EnumMap<Stat, Integer> values) {
        this.stats = new EnumMap<>(values);
    }


    public void setAll(int n) {
        for (Stat s : Stat.values()) {
            stats.put(s, n);
        }
    }

    public void setAll() {
        for (Stat s : Stat.values()) {
            stats.put(s, 0);
        }
    }

    public int sum() {
        return stats.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getStat(Stat stat) {
        return stats.getOrDefault(stat, 0);
    }

    public void setStat(Stat stat, int amount) {
        if (amount < 0) return;
        stats.put(stat, amount);
    }
}
