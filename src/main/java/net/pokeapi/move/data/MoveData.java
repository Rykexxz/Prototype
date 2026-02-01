package net.pokeapi.move.data;

import net.pokeapi.types.Type;
import net.pokeapi.move.effect.model.EffectData;

import java.util.EnumSet;
import java.util.List;

public record MoveData(
        MoveId id,
        Type type,
        MoveCategory category,
        int power,
        int accuracy,
        int pp,
        int maxPp,
        int priority,
        EnumSet<MoveFlag> flags,
        List<EffectData> effects
) {
}
