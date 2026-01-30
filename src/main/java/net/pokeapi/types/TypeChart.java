package net.pokeapi.types;

import java.util.EnumMap;
import java.util.Map;

public final class TypeChart {

    private static final Map<Type, Map<Type, Float>> map =
            new EnumMap<>(Type.class);

    static {
        for (Type atk : Type.values()) {
            Map<Type, Float> defMap = new EnumMap<>(Type.class);
            for (Type def : Type.values()) {
                defMap.put(def, 1f); // neutro por padrão
            }
            map.put(atk, defMap);
        }

        // NORMAL
        set(Type.NORMAL, Type.ROCK, 0.5f);
        set(Type.NORMAL, Type.STEEL, 0.5f);
        set(Type.NORMAL, Type.GHOST, 0f);

        // FIRE
        set(Type.FIRE, Type.GRASS, 2f);
        set(Type.FIRE, Type.ICE, 2f);
        set(Type.FIRE, Type.BUG, 2f);
        set(Type.FIRE, Type.STEEL, 2f);
        set(Type.FIRE, Type.FIRE, 0.5f);
        set(Type.FIRE, Type.WATER, 0.5f);
        set(Type.FIRE, Type.ROCK, 0.5f);
        set(Type.FIRE, Type.DRAGON, 0.5f);

        // WATER
        set(Type.WATER, Type.FIRE, 2f);
        set(Type.WATER, Type.GROUND, 2f);
        set(Type.WATER, Type.ROCK, 2f);
        set(Type.WATER, Type.WATER, 0.5f);
        set(Type.WATER, Type.GRASS, 0.5f);
        set(Type.WATER, Type.DRAGON, 0.5f);

        // ELECTRIC
        set(Type.ELECTRIC, Type.WATER, 2f);
        set(Type.ELECTRIC, Type.FLYING, 2f);
        set(Type.ELECTRIC, Type.ELECTRIC, 0.5f);
        set(Type.ELECTRIC, Type.GRASS, 0.5f);
        set(Type.ELECTRIC, Type.DRAGON, 0.5f);
        set(Type.ELECTRIC, Type.GROUND, 0f);

        // GRASS
        set(Type.GRASS, Type.WATER, 2f);
        set(Type.GRASS, Type.GROUND, 2f);
        set(Type.GRASS, Type.ROCK, 2f);
        set(Type.GRASS, Type.FIRE, 0.5f);
        set(Type.GRASS, Type.GRASS, 0.5f);
        set(Type.GRASS, Type.POISON, 0.5f);
        set(Type.GRASS, Type.FLYING, 0.5f);
        set(Type.GRASS, Type.BUG, 0.5f);
        set(Type.GRASS, Type.DRAGON, 0.5f);
        set(Type.GRASS, Type.STEEL, 0.5f);

        // ICE
        set(Type.ICE, Type.GRASS, 2f);
        set(Type.ICE, Type.GROUND, 2f);
        set(Type.ICE, Type.FLYING, 2f);
        set(Type.ICE, Type.DRAGON, 2f);
        set(Type.ICE, Type.FIRE, 0.5f);
        set(Type.ICE, Type.WATER, 0.5f);
        set(Type.ICE, Type.ICE, 0.5f);
        set(Type.ICE, Type.STEEL, 0.5f);

        // FIGHTING
        set(Type.FIGHTING, Type.NORMAL, 2f);
        set(Type.FIGHTING, Type.ICE, 2f);
        set(Type.FIGHTING, Type.ROCK, 2f);
        set(Type.FIGHTING, Type.DARK, 2f);
        set(Type.FIGHTING, Type.STEEL, 2f);
        set(Type.FIGHTING, Type.POISON, 0.5f);
        set(Type.FIGHTING, Type.FLYING, 0.5f);
        set(Type.FIGHTING, Type.PSYCHIC, 0.5f);
        set(Type.FIGHTING, Type.BUG, 0.5f);
        set(Type.FIGHTING, Type.FAIRY, 0.5f);
        set(Type.FIGHTING, Type.GHOST, 0f);

        // POISON
        set(Type.POISON, Type.GRASS, 2f);
        set(Type.POISON, Type.FAIRY, 2f);
        set(Type.POISON, Type.POISON, 0.5f);
        set(Type.POISON, Type.GROUND, 0.5f);
        set(Type.POISON, Type.ROCK, 0.5f);
        set(Type.POISON, Type.GHOST, 0.5f);
        set(Type.POISON, Type.STEEL, 0f);

        // GROUND
        set(Type.GROUND, Type.FIRE, 2f);
        set(Type.GROUND, Type.ELECTRIC, 2f);
        set(Type.GROUND, Type.POISON, 2f);
        set(Type.GROUND, Type.ROCK, 2f);
        set(Type.GROUND, Type.STEEL, 2f);
        set(Type.GROUND, Type.GRASS, 0.5f);
        set(Type.GROUND, Type.BUG, 0.5f);
        set(Type.GROUND, Type.FLYING, 0f);

        // FLYING
        set(Type.FLYING, Type.GRASS, 2f);
        set(Type.FLYING, Type.FIGHTING, 2f);
        set(Type.FLYING, Type.BUG, 2f);
        set(Type.FLYING, Type.ELECTRIC, 0.5f);
        set(Type.FLYING, Type.ROCK, 0.5f);
        set(Type.FLYING, Type.STEEL, 0.5f);

        // PSYCHIC
        set(Type.PSYCHIC, Type.FIGHTING, 2f);
        set(Type.PSYCHIC, Type.POISON, 2f);
        set(Type.PSYCHIC, Type.PSYCHIC, 0.5f);
        set(Type.PSYCHIC, Type.STEEL, 0.5f);
        set(Type.PSYCHIC, Type.DARK, 0f);

        // BUG
        set(Type.BUG, Type.GRASS, 2f);
        set(Type.BUG, Type.PSYCHIC, 2f);
        set(Type.BUG, Type.DARK, 2f);
        set(Type.BUG, Type.FIRE, 0.5f);
        set(Type.BUG, Type.FIGHTING, 0.5f);
        set(Type.BUG, Type.POISON, 0.5f);
        set(Type.BUG, Type.FLYING, 0.5f);
        set(Type.BUG, Type.GHOST, 0.5f);
        set(Type.BUG, Type.STEEL, 0.5f);
        set(Type.BUG, Type.FAIRY, 0.5f);

        // ROCK
        set(Type.ROCK, Type.FIRE, 2f);
        set(Type.ROCK, Type.ICE, 2f);
        set(Type.ROCK, Type.FLYING, 2f);
        set(Type.ROCK, Type.BUG, 2f);
        set(Type.ROCK, Type.FIGHTING, 0.5f);
        set(Type.ROCK, Type.GROUND, 0.5f);
        set(Type.ROCK, Type.STEEL, 0.5f);

        // GHOST
        set(Type.GHOST, Type.PSYCHIC, 2f);
        set(Type.GHOST, Type.GHOST, 2f);
        set(Type.GHOST, Type.DARK, 0.5f);
        set(Type.GHOST, Type.NORMAL, 0f);

        // DRAGON
        set(Type.DRAGON, Type.DRAGON, 2f);
        set(Type.DRAGON, Type.STEEL, 0.5f);
        set(Type.DRAGON, Type.FAIRY, 0f);

        // DARK
        set(Type.DARK, Type.PSYCHIC, 2f);
        set(Type.DARK, Type.GHOST, 2f);
        set(Type.DARK, Type.FIGHTING, 0.5f);
        set(Type.DARK, Type.DARK, 0.5f);
        set(Type.DARK, Type.FAIRY, 0.5f);

        // STEEL
        set(Type.STEEL, Type.ICE, 2f);
        set(Type.STEEL, Type.ROCK, 2f);
        set(Type.STEEL, Type.FAIRY, 2f);
        set(Type.STEEL, Type.FIRE, 0.5f);
        set(Type.STEEL, Type.WATER, 0.5f);
        set(Type.STEEL, Type.ELECTRIC, 0.5f);
        set(Type.STEEL, Type.STEEL, 0.5f);

        // FAIRY
        set(Type.FAIRY, Type.FIGHTING, 2f);
        set(Type.FAIRY, Type.DRAGON, 2f);
        set(Type.FAIRY, Type.DARK, 2f);
        set(Type.FAIRY, Type.FIRE, 0.5f);
        set(Type.FAIRY, Type.POISON, 0.5f);
        set(Type.FAIRY, Type.STEEL, 0.5f);
    }

    private static void set(Type atk, Type def, float value) {
        map.get(atk).put(def, value);
    }

    public static float getMultiplier(Type attack, Type defense) {
        return map.get(attack).get(defense);
    }

    private TypeChart() {
    }
}


