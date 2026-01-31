package net.pokeapi.move.registry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.move.io.MoveAdapter;
import net.pokeapi.move.model.Move;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public final class MoveRegistry {

    public static final Map<MoveId, Move> DATA = new HashMap<>();

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Move.class, new MoveAdapter())
            .create();

    private MoveRegistry() { }

    static {
        loadAll(Path.of("src/main/resources/moves"));
    }

    public static void loadAll(Path folder) {
        try (var paths = Files.walk(folder)) {
            paths
                    .filter(p -> p.toString().endsWith(".json"))
                    .forEach(MoveRegistry::loadOne);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadOne(Path path) {
        Move data;
        try {
            String json = Files.readString(path);
            data = GSON.fromJson(json, Move.class);
        } catch (Exception e) {
            System.err.println("Erro ao carregar movimento: " + path);
            e.printStackTrace();
            return;
        }

        if (data == null) throw new RuntimeException("Data is null: " + path);

        DATA.put(data.id, data);
    }

    public static Move get(MoveId id) {
        Move data = DATA.get(id);
        if (data == null) {
            throw new IllegalArgumentException(
                    "Movimento não encontrado: " + id
            );
        }
        return data;
    }

    public static Map<MoveId, Move> getAll() {
        return Map.copyOf(DATA);
    }
}