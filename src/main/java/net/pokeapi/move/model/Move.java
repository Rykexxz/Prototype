package net.pokeapi.move.model;

import net.pokeapi.battle.BattleContext;
import net.pokeapi.move.data.MoveData;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.move.effect.model.EffectData;
import net.pokeapi.move.effect.model.MoveEffect;
import net.pokeapi.move.effect.factory.MoveEffectFactory;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private final MoveData data;
    private final List<MoveEffect> effects;

    public Move(MoveData data) {
        this.data = data;

        this.effects = new ArrayList<>();

        if (data.effects() != null) {
            for (EffectData effectData : data.effects()) {
                effects.add(MoveEffectFactory.create(effectData));
            }
        }
    }

    public void apply(BattleContext ctx) {
        if (data.power() > 0) {
            if (ctx.roll(data.accuracy())) {
                ctx.damageTarget(data.power(), data.type());
            }
        }

        for (MoveEffect effect : effects) {
            effect.apply(ctx);
        }
    }

    public int getPower() {
        return data.power();
    }

    public MoveId getId() { return data.id(); }
}
