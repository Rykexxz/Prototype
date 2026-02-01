package net.pokeapi.move.effect.model;

import net.pokeapi.move.effect.data.EffectType;

import java.util.Map;

public class EffectData {

    private EffectType type;
    private Map<String, Double> params;

    public EffectType getType() {
        return type;
    }

    public Map<String, Double> getParams() {
        return params;
    }

    public double param(String key, double defaultValue) {
        return params != null && params.containsKey(key)
                ? params.get(key)
                : defaultValue;
    }
    // Adicione construtores para Gson
    public EffectData() {}

    public void setType(EffectType type) { this.type = type; }
    public void setParams(Map<String, Double> params) { this.params = params; }
}

