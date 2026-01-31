package net.pokeapi.move.model;

import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.types.Type;

import java.util.List;

public class StatusMove extends Move {

    public StatusMove(MoveId id, Type type, int accuracy,
                      int pp, int maxPp, int priority, List<MoveFlag> flags) {
        super(id, type, MoveCategory.STATUS, accuracy, pp, maxPp, priority, flags);
    }
}
