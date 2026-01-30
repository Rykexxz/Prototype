package net.pokeapi.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JsonSerializer {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private JsonSerializer() {
    }

    public static void write(Path path, Object obj) throws Exception {
        Files.createDirectories(path.getParent());

        try (Writer writer = Files.newBufferedWriter(path)) {
            GSON.toJson(obj, writer);
        }
    }
}

