package net.pokeapi.pokemon.species;

public enum PokemonFlag {
    UNKNOWN,
    NORMAL,
    BABY,
    LEGENDARY,
    MYTHICAL,
    ULTRA_BEAST;

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
