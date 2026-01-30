package net.pokeapi.stats.value;

import net.pokeapi.rng.Rng;
import net.pokeapi.stats.model.Stat;
import net.pokeapi.stats.model.Stats;

public class Ivs extends Stats {
    private static final int MAX_IV = 31;

    public Ivs() {
        generateRandomIvs();
    }

    private void generateRandomIvs() {
        for (Stat stat : Stat.values()) {
            int r = Rng.RNG.nextInt(MAX_IV + 1);
            stats.put(stat, r);
        }
    }

    @Override
    public void setAll(int n) {
        if (n > MAX_IV) n = MAX_IV;
        else if (n < 0) n = 0;
        super.setAll(n);
    }

    @Override
    public void setStat(Stat stat, int amount) {
        if (amount < 0 || amount > MAX_IV) return;
        stats.put(stat, amount);
    }
}
