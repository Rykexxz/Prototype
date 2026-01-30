package net.pokeapi.stats.value;

import net.pokeapi.stats.model.Stat;
import net.pokeapi.stats.model.Stats;

public class Evs extends Stats {
    private static final int MAX_EV = 252;
    private static final int MAX_EVS = 508;

    public Evs() {
        super();
    }

    @Override
    public void setAll(int n) {
        if (n * 6 > MAX_EVS) n = 0;
        super.setAll(n);
    }

    @Override
    public void setStat(Stat stat, int amount) {
        if (amount < 0 || amount > MAX_EV || sum() + amount > MAX_EVS) return;
        stats.put(stat, amount);
    }
}

