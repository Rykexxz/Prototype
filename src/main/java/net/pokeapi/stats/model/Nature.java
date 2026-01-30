package net.pokeapi.stats.model;

public enum Nature {

    HARDY(null, null),
    LONELY(Stat.ATK, Stat.DEF),
    BRAVE(Stat.ATK, Stat.SPE),
    ADAMANT(Stat.ATK, Stat.SPA),
    NAUGHTY(Stat.ATK, Stat.SPD),

    BOLD(Stat.DEF, Stat.ATK),
    DOCILE(null, null),
    RELAXED(Stat.DEF, Stat.SPE),
    IMPISH(Stat.DEF, Stat.SPA),
    LAX(Stat.DEF, Stat.SPD),

    TIMID(Stat.SPE, Stat.ATK),
    HASTY(Stat.SPE, Stat.DEF),
    SERIOUS(null, null),
    JOLLY(Stat.SPE, Stat.SPA),
    NAIVE(Stat.SPE, Stat.SPD),

    MODEST(Stat.SPA, Stat.ATK),
    MILD(Stat.SPA, Stat.DEF),
    QUIET(Stat.SPA, Stat.SPE),
    BASHFUL(null, null),
    RASH(Stat.SPA, Stat.SPD),

    CALM(Stat.SPD, Stat.ATK),
    GENTLE(Stat.SPD, Stat.DEF),
    SASSY(Stat.SPD, Stat.SPE),
    CAREFUL(Stat.SPD, Stat.SPA),
    QUIRKY(null, null);

    private final Stat increased;
    private final Stat decreased;

    Nature(Stat increased, Stat decreased) {
        this.increased = increased;
        this.decreased = decreased;
    }

    public float getPercent(Stat stat) {
        float p = 1f;

        if (stat == increased) p = 1.1f;
        else if (stat == decreased) p = 0.9f;

        return p;
    }

    public boolean isNeutral() {
        return increased == null && decreased == null;
    }
}

