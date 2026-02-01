package net.pokeapi.move.effect.model;

import net.pokeapi.battle.BattleContext;

public interface MoveEffect {
    void apply(BattleContext ctx);
}
