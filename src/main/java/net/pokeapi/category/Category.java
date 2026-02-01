package net.pokeapi.category;

public enum Category {
    UNKNOWN,
    SEED,
    LIZARD,
    FLAME,
    TINY_TURTLE,
    TURTLE,
    SHELLFISH,
    WORM,
    COCOON,
    BUTTERFLY,
    HAIRY_BUG,
    POISON_BEE,
    TINY_BIRD,
    BIRD,
    MOUSE,
    BEAK,
    SNAKE,
    COBRA
    ;

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
