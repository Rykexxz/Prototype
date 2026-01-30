package net.pokeapi.move.data;

import net.pokeapi.move.model.Move;
import net.pokeapi.move.model.PhysicalMove;
import net.pokeapi.types.Type;

import java.util.List;

public enum MovesId {
    TACKLE(new PhysicalMove("Tackle", Type.NORMAL, 40, 100,
            35, 56, 0, List.of(MoveFlag.CONTACT)));

    private final Move move;

    MovesId(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }
}
