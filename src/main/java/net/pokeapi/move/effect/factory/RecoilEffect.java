package net.pokeapi.move.effect.factory;

import net.pokeapi.battle.BattleContext;
import net.pokeapi.move.effect.model.MoveEffect;

public class RecoilEffect implements MoveEffect {

    private final double ratio;

    public RecoilEffect(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public void apply(BattleContext ctx) {
        ctx.damageSelf((int) (ctx.getLastDamage() * ratio));
    }
}

