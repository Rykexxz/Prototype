package net.pokeapi.move.model;

import com.google.gson.annotations.SerializedName;
import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.types.Type;

import java.util.List;

public abstract class Move {
    @SerializedName("id")
    public final MoveId id;

    @SerializedName("type")
    public final Type type;

    @SerializedName("category")
    public final MoveCategory category;

    @SerializedName("accuracy")
    public final int accuracy;

    @SerializedName("pp")
    public int pp;

    @SerializedName("defaultPp")
    public int defaultPp;

    @SerializedName("maxPp")
    public final int maxPp;

    @SerializedName("priority")
    public final int priority;

    @SerializedName("flags")
    public final List<MoveFlag> flags;

    public Move(MoveId id, Type type, MoveCategory category, int accuracy, int pp,
                int maxPp, int priority, List<MoveFlag> flags) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.accuracy = accuracy;
        this.pp = pp;
        this.defaultPp = pp;
        this.maxPp = maxPp;
        this.priority = priority;
        this.flags = flags;
    }

    // Getters e outros métodos permanecem
}