package net.pokeapi.move.io;

import com.google.gson.*;
import net.pokeapi.move.data.MoveCategory;
import net.pokeapi.move.data.MoveFlag;
import net.pokeapi.move.data.MoveId;
import net.pokeapi.move.model.*;
import net.pokeapi.types.Type;

import java.util.List;

public class MoveAdapter implements JsonDeserializer<Move>, JsonSerializer<Move> {

    private static final String CATEGORY_FIELD = "category";

    @Override
    public Move deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Extrair campos comuns
        MoveId id = context.deserialize(jsonObject.get("id"), MoveId.class);
        Type moveType = context.deserialize(jsonObject.get("type"), net.pokeapi.types.Type.class);
        MoveCategory category = context.deserialize(jsonObject.get("category"), MoveCategory.class);
        int accuracy = jsonObject.get("accuracy").getAsInt();
        int pp = jsonObject.get("pp").getAsInt();
        int maxPp = jsonObject.get("maxPp").getAsInt();
        int priority = jsonObject.get("priority").getAsInt();

        List<MoveFlag> flags = context.deserialize(
                jsonObject.get("flags"),
                new com.google.gson.reflect.TypeToken<List<MoveFlag>>(){}.getType()
        );

        // Criar instância baseada na categoria
        return switch (category) {
            case PHYSICAL -> {
                int power = jsonObject.get("power").getAsInt();
                yield new PhysicalMove(id, moveType, power, accuracy, pp, maxPp, priority, flags);
            }
            case SPECIAL -> {
                int power = jsonObject.get("power").getAsInt();
                yield new SpecialMove(id, moveType, power, accuracy, pp, maxPp, priority, flags);
            }
            case STATUS -> new StatusMove(id, moveType, accuracy, pp, maxPp, priority, flags);
        };
    }

    @Override
    public JsonElement serialize(Move src, java.lang.reflect.Type typeOfSrc,
                                 JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        // Serializar campos comuns
        jsonObject.add("id", context.serialize(src.id));
        jsonObject.add("type", context.serialize(src.type));
        jsonObject.add("category", context.serialize(src.category));
        jsonObject.addProperty("accuracy", src.accuracy);
        jsonObject.addProperty("pp", src.pp);
        jsonObject.addProperty("defaultPp", src.defaultPp);
        jsonObject.addProperty("maxPp", src.maxPp);
        jsonObject.addProperty("priority", src.priority);
        jsonObject.add("flags", context.serialize(src.flags));

        // Serializar campos específicos
        if (src instanceof DamageMove) {
            DamageMove damageMove = (DamageMove) src;
            jsonObject.addProperty("power", damageMove.power);
        }

        return jsonObject;
    }
}
