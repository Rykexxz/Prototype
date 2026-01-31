package net.pokeapi.move.model;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.stats.model.Stat;
import net.pokeapi.types.Type;

import java.util.List;

public abstract class DamageMove extends Move {
    public final int power;

    public DamageMove(MoveId id, Type type, MoveCategory category, int power,
                      int accuracy, int pp, int maxPp, int priority, List<MoveFlag> flags) {
        super(id, type, category, accuracy, pp, maxPp, priority, flags);
        this.power = power;
    }

    public abstract Stat getDefenseStat();

    public abstract Stat getAttackStat();
}
