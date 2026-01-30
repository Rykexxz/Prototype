package net.pokeapi.rng;

import java.util.Map;

public final class Ratio {

    private Ratio() { }

    public static <T> T generate(Map<T, Double> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        double totalWeight = 0.0;
        for (double w : map.values()) {
            if (w > 0) {
                totalWeight += w;
            }
        }

        if (totalWeight <= 0) {
            return null;
        }

        double random = Rng.RNG.nextDouble() * totalWeight;

        double accumulated = 0.0;
        for (Map.Entry<T, Double> entry : map.entrySet()) {
            double weight = entry.getValue();
            if (weight <= 0) continue;

            accumulated += weight;
            if (random < accumulated) {
                return entry.getKey();
            }
        }

        return null;
    }

}
