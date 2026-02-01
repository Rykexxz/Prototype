package net.pokeapi.battle;

import net.pokeapi.move.effect.data.EffectType;
import net.pokeapi.types.Type;

import java.util.Random;

public class BattleContext {
    private static final Random rng = new Random();

    private int lastDamage = 0;

    public int getLastDamage() {
        return lastDamage;
    }

    public boolean roll(int accuracy) {
        if (accuracy >= 100) return true;
        return rng.nextInt(0, 101) <= accuracy;
    }

    public void damageTarget(int damage, Type type) {
        lastDamage = damage;
    }

    public void damageSelf(int damage) {
        lastDamage = damage;
    }

    public void applyEffectTarget(EffectType type) { }

    public void applyEffectSelf(EffectType type) { }
}
