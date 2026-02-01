package net.pokeapi.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.pokeapi.move.model.Move;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JsonDeserializer {

    private static final Gson GSON = new GsonBuilder()
            .create();

    private JsonDeserializer() {
    }

    public static <T> T read(Path path, Class<T> clazz) {
        try (Reader reader = Files.newBufferedReader(path)) {
            return GSON.fromJson(reader, clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
