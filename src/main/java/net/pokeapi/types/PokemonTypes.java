package net.pokeapi.types;

import java.util.List;
import java.util.Objects;

public class PokemonTypes {
    private final Type primary;
    private Type secondary;
    private Type tera;

    public PokemonTypes(Type primary) {
        this.primary = primary;
    }

    public PokemonTypes(Type primary, Type secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    public List<Type> getAsList() {
        if (tera != null) {
            return List.of(tera);
        }
        List<Type> list = List.of(primary, secondary);
        return list.stream()
                .filter(Objects::nonNull)
                .toList();
    }

    public void setTeraType(Type type) {
        tera = type;
    }
}
