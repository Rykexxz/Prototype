package net.pokeapi.ability;

public enum Ability {
    STATIC,
    LIGHTING_ROD,
    SURGE_SURFER,
    OVERGROW,
    CHLOROPHYLL,
    THICK_FAT,
    TORRENT,
    RAIN_DISH,
    BLAZE,
    SOLAR_POWER,
    MEGA_LAUNCHER,
    TOUGH_CLAWS,
    DROUGHT,
    UNKNOWN;

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
