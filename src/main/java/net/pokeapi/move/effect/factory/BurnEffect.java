package net.pokeapi.move.effect.factory;

import net.pokeapi.battle.BattleContext;
import net.pokeapi.move.effect.data.EffectType;
import net.pokeapi.move.effect.model.MoveEffect;

public class BurnEffect implements MoveEffect {

    private final int chance;

    public BurnEffect(int chance) {
        this.chance = chance;
    }

    @Override
    public void apply(BattleContext ctx) {
        if (ctx.roll(chance)) {
            ctx.applyEffectTarget(EffectType.BURN);
        }
    }
}
