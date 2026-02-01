package net.pokeapi.move.registry;

import net.pokeapi.io.JsonDeserializer;
import net.pokeapi.move.data.MoveData;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.move.model.Move;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;

public final class MoveRegistry {
    private MoveRegistry() { }

    private static final Map<MoveId, Move> DATA = new EnumMap<>(MoveId.class);

    public static Move get(MoveId id) {
        Move move = DATA.get(id);
        if (move == null) {
            throw new IllegalArgumentException("Move not registered: " + id);
        }
        return move;
    }

    public static void register(MoveId id, Move move) {
        if (DATA.containsKey(id)) return;
        DATA.put(id, move);
    }

    public static void loadMoves(Path folder) {
        try (var paths = Files.walk(folder)) {
            paths
                    .filter(p -> p.toString().endsWith(".json"))
                    .forEach(MoveRegistry::loadOne);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadOne(Path path) {
        MoveData moveData;
        try {
            moveData = JsonDeserializer.read(path, MoveData.class);
        } catch (Exception e) {
            throw new RuntimeException("Move not read correctly");
        }

        assert moveData != null;
        assert moveData.id() != null;
        MoveRegistry.register(moveData.id(), new Move(moveData));
    }
}
