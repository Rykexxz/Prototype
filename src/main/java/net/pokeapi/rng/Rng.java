package net.pokeapi.rng;

import net.pokeapi.stats.model.Nature;

import java.util.Random;

public final class Rng {
    private static final Nature[] list = Nature.values();

    private record Seed(long seed) {
    }

    public static final Random RNG = new Random();

    private Rng() {
    }

    public static <E extends Enum<E>> E randomEnum(Class<E> enumClass) {
        E[] values = enumClass.getEnumConstants();
        return values[RNG.nextInt(values.length)];
    }

    public static boolean isShiny() {
        return RNG.nextInt(4096) == 1;
    }
}
