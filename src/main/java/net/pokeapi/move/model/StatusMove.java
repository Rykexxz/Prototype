package net.pokeapi.move.model;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.types.Type;

import java.util.List;

public class StatusMove extends Move {

    public StatusMove(String name, Type type, int accuracy,
                      int pp, int maxPp, int priority, List<MoveFlag> flags) {
        super(name, type, MoveCategory.STATUS, accuracy, pp, maxPp, priority, flags);
    }

    @Override
    public Move clone() {
        return new StatusMove(name, type, accuracy, pp, maxPp, priority, flags);
    }
}
