package net.pokeapi.types;

public enum Type {
    NORMAL,
    WATER,
    FIRE,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    PSYCHIC,
    FLYING,
    POISON,
    ROCK,
    GROUND,
    BUG,
    DARK,
    GHOST,
    STEEL,
    FAIRY,
    DRAGON;

    @Override
    public String toString() {
        String[] parts = name().toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();

        for (String p : parts) {
            sb.append(Character.toUpperCase(p.charAt(0)))
                    .append(p.substring(1))
                    .append(' ');
        }

        return sb.toString().trim();
    }
}
