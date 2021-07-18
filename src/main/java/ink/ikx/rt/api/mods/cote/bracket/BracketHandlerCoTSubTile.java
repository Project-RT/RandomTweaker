package ink.ikx.rt.api.mods.cote.bracket;

import cn.hutool.core.lang.Pair;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.BracketHandler;
import crafttweaker.annotations.ModOnly;
import crafttweaker.zenscript.IBracketHandler;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalRepresentation;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.util.List;
import stanhebben.zenscript.compiler.IEnvironmentGlobal;
import stanhebben.zenscript.expression.ExpressionCallStatic;
import stanhebben.zenscript.expression.ExpressionString;
import stanhebben.zenscript.parser.Token;
import stanhebben.zenscript.symbols.IZenSymbol;
import stanhebben.zenscript.type.natives.IJavaMethod;

@SuppressWarnings("ALL")
@ModOnly("contenttweaker")
@BracketHandler(priority = 100)
@RTRegisterClass({"botania", "contenttweaker"})
public class BracketHandlerCoTSubTile implements IBracketHandler {

    public static SubTileRepresentation getSubTile(String name) {
        if (RandomTweaker.subTileGeneratingMap.containsKey(name)) {
            Pair<String, SubTileRepresentation> subtilePair = RandomTweaker.subTileGeneratingMap.get(name);
            return subtilePair.getValue();
        }
        return null;
    }

    public static SubTileFunctionalRepresentation getSubTileF(String name) {
        Pair<String, SubTileRepresentation> subtilePair = RandomTweaker.subTileGeneratingMap.get(name);
        return (SubTileFunctionalRepresentation) subtilePair.getValue();
    }

    public static SubTileGeneratingRepresentation getSubTileG(String name) {
        Pair<String, SubTileRepresentation> subtilePair = RandomTweaker.subTileGeneratingMap.get(name);
        return (SubTileGeneratingRepresentation) subtilePair.getValue();
    }

    @Override
    public IZenSymbol resolve(IEnvironmentGlobal environment, List<Token> tokens) {
        if (tokens.size() > 2) {
            if (tokens.get(0).getValue().equals("cotSubTile") && tokens.get(1).getValue().equals(":")) {
                return find(environment, tokens);
            }
        }
        return null;
    }

    @Override
    public String getRegexMatchingString() {
        return "cotSubTile:.*";
    }

    @Override
    public Class<?> getReturnedClass() {
        return SubTileRepresentation.class;
    }

    private IZenSymbol find(IEnvironmentGlobal environment, List<Token> tokens) {
        String name = tokens.get(2).getValue();
        IJavaMethod method;
        if (getSubTile(name) instanceof SubTileGeneratingRepresentation) {
            method = CraftTweakerAPI.getJavaMethod(BracketHandlerCoTSubTile.class, "getSubTileG", String.class);
        } else if (getSubTile(name) instanceof SubTileFunctionalRepresentation) {
            method = CraftTweakerAPI.getJavaMethod(BracketHandlerCoTSubTile.class, "getSubTileF", String.class);
        } else {
            method = null;
        }
        return position -> new ExpressionCallStatic(position, environment, method, new ExpressionString(position, name));
    }
}
