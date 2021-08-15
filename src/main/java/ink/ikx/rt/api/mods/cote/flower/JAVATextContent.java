package ink.ikx.rt.api.mods.cote.flower;

public class JAVATextContent {

    public static String FLOWER_BLOCKSTATE = "{\n"
        + "  \"forge_marker\": 1,\n"
        + "  \"variants\": {\n"
        + "    \"normal\": [{\n"
        + "      \"model\": \"botania:shapes/cross_tinted\",\n"
        + "      \"textures\": {\n"
        + "        \"cross\": \"contenttweaker:blocks/${name}\"\n"
        + "      }\n"
        + "    }],\n"
        + "    \"inventory\": [{\n"
        + "      \"model\": \"builtin/generated\",\n"
        + "      \"transform\": \"forge:default-item\",\n"
        + "      \"textures\": {\n"
        + "        \"layer0\": \"contenttweaker:blocks/${name}\"\n"
        + "      }\n"
        + "    }]\n"
        + "  }\n"
        + "}";
    
}