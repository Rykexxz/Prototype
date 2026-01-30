package net.pokeapi.pokemon.species;

public enum Form {
    DEFAULT,
    ALOLAN,
    GALARIAN,
    PALDEAN,
    HISUIAN,
    MEGA,
    MEGA_X,
    MEGA_Y,
    MEGA_Z,
    DYNAMAX,
    GIGANTAMAX;

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
