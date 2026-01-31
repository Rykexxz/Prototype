package net.pokeapi.move.model;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.stats.model.Stat;
import net.pokeapi.types.Type;

import java.util.List;

public class PhysicalMove extends DamageMove {

    public PhysicalMove(MoveId id, Type type, int power, int accuracy,
                        int pp, int maxPp, int priority, List<MoveFlag> flags) {
        super(id, type, MoveCategory.PHYSICAL, power, accuracy, pp, maxPp, priority, flags);
    }

    @Override
    public Stat getDefenseStat() {
        return Stat.DEF;
    }

    @Override
    public Stat getAttackStat() {
        return Stat.ATK;
    }
}
