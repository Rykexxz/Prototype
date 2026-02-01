package net.pokeapi.move.effect.factory;

import net.pokeapi.move.effect.model.EffectData;
import net.pokeapi.move.effect.model.MoveEffect;

public final class MoveEffectFactory {

    private MoveEffectFactory() {}

    public static MoveEffect create(EffectData data) {
        return switch (data.getType()) {

            case BURN -> new BurnEffect(
                    (int) data.param("chance", 10)
            );

            case RECOIL -> new RecoilEffect(
                    data.param("ratio", 0.25)
            );

        };
    }
}

