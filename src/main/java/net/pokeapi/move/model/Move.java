package net.pokeapi.move.model;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.types.Type;

import java.util.List;

public abstract class Move {
    public final String name;
    public final Type type;
    public final MoveCategory category;
    public final int accuracy;
    protected int pp;
    protected int defaultPp;
    protected final int maxPp;
    public final int priority;
    public final List<MoveFlag> flags;

    public Move(String name, Type type, MoveCategory category, int accuracy, int pp,
                int maxPp, int priority, List<MoveFlag> flags) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.accuracy = accuracy;
        this.pp = pp;
        this.defaultPp = pp;
        this.maxPp = maxPp;
        this.priority = priority;
        this.flags = flags;
    }

    public boolean use() {
        if (pp <= 0) return false;
        pp--;
        return true;
    }

    public void resetPp() {
        pp = defaultPp;
    }

    public boolean ppUp() {
        if (defaultPp == maxPp) {
            return false;
        }
        defaultPp++;
        return true;
    }

    public abstract Move clone();
}
