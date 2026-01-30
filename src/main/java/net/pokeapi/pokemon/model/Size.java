package net.pokeapi.pokemon.model;

public enum Size {
    VERY_SMALL(0.6),
    SMALL(0.8),
    NORMAL(1),
    LARGE(1.2),
    VERY_LARGE(1.4);

    private final double scale;

    Size(double scale) {
        this.scale = scale;
    }

    public double getScale() {
        return scale;
    }
}
