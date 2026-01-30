package net.pokeapi.stats.model;

import java.util.EnumMap;
import java.util.Map;

public class Stats {
    protected final EnumMap<Stat, Integer> stats;

    public Stats() {
        stats = new EnumMap<>(Stat.class);
        for (Stat s : Stat.values()) {
            stats.put(s, 0);
        }
    }

    public Stats(Map<Stat, Integer> values) {
        stats = new EnumMap<>(Stat.class);
        for (Stat s : Stat.values()) {
            stats.put(s, values.getOrDefault(s, 0));
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

    public void setAll(int n) {
        for (Stat s : Stat.values()) {
            stats.put(s, n);
        }
    }

    public void setStat(Stat stat, int amount) {
        if (amount < 0) return;
        stats.put(stat, amount);
    }
}
