package net.pokeapi.pokemon.registry;

import net.pokeapi.io.JsonDeserializer;
import net.pokeapi.pokemon.species.Form;
import net.pokeapi.pokemon.species.PokemonSpeciesData;
import net.pokeapi.pokemon.species.Species;
import net.pokeapi.util.key.SpeciesFormKey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public final class PokemonRegistry {

    public static boolean on = false;
    public static final Map<SpeciesFormKey, PokemonSpeciesData> DATA = new HashMap<>();

    private PokemonRegistry() { }

    public static void init() {
        if (!on) {
            loadAll(Path.of("src/main/resources/pokemon"));
            on = true;
        }
    }

    public static void loadAll(Path folder) {
        try (var paths = Files.walk(folder)) {
            paths
                    .filter(p -> p.toString().endsWith(".json"))
                    .forEach(PokemonRegistry::loadOne);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadOne(Path path) {
        PokemonSpeciesData data;
        try {
            data = JsonDeserializer.read(path, PokemonSpeciesData.class);
        } catch (Exception e) {
            System.out.println("Catch Error");
            return;
        }

        if (data == null) throw new RuntimeException("Data is null: " + path);
        SpeciesFormKey key = new SpeciesFormKey(
                data.species(),
                data.form()
        );

        DATA.put(key, data);
    }

    public static PokemonSpeciesData get(Species species, Form form) {
        SpeciesFormKey key = new SpeciesFormKey(species, form);

        PokemonSpeciesData data = DATA.get(key);
        if (data == null) {
            throw new IllegalArgumentException(
                    "Pokémon não encontrado: " + species + " / " + form
            );
        }
        return data;
    }
}
