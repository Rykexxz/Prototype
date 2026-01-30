package net.pokeapi.stats.calc;

import net.pokeapi.stats.model.Nature;
import net.pokeapi.stats.model.Stat;
import net.pokeapi.stats.model.Stats;
import net.pokeapi.stats.value.Evs;
import net.pokeapi.stats.value.Ivs;

public final class StatsCalculator {
    private StatsCalculator() {
    }

    private static int CalculateHP(int baseHp, int hpIv, int hpEv, int level) {
        return (((2 * baseHp + hpIv + (hpEv / 4)) * level) / 100) + level + 10;
    }

    private static int CalculateOtherStat(Stat stat, int baseStat, int statIv,
                                          int statEv, int level, Nature nature) {
        int first = (((2 * baseStat + statIv + (statEv / 4)) * level) / 100) + 5;
        return (int) (first * nature.getPercent(stat));
    }

    public static Stats calculate(
            Stats base,
            Ivs ivs,
            Evs evs,
            int level,
            Nature nature
    ) {
        Stats fStats = new Stats();
        for (Stat stat : Stat.values()) {
            int bs = base.getStat(stat);
            int iv = ivs.getStat(stat);
            int ev = evs.getStat(stat);
            int result;
            if (stat == Stat.HP) {
                result = CalculateHP(bs, iv, ev, level);
            } else {
                result = CalculateOtherStat(stat, bs, iv, ev, level, nature);
            }
            fStats.setStat(stat, result);
        }
        return fStats;
    }
}
