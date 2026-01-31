package net.pokeapi.move.model;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.stats.model.Stat;
import net.pokeapi.types.Type;

import java.util.List;

public class SpecialMove extends DamageMove {

    public SpecialMove(MoveId id, Type type, int power,
                       int accuracy, int pp, int maxPp, int priority, List<MoveFlag> flags) {
        super(id, type, MoveCategory.SPECIAL, power, accuracy, pp, maxPp, priority, flags);
    }

    @Override
    public Stat getDefenseStat() {
        return Stat.SPD;
    }

    @Override
    public Stat getAttackStat() {
        return Stat.SPA;
    }
}
