package net.pokeapi.stats.model;

public enum Stat {
    HP,
    ATK,
    DEF,
    SPA,
    SPD,
    SPE;

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
