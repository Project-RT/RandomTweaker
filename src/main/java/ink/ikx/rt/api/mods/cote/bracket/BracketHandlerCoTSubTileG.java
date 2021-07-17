package ink.ikx.rt.api.mods.cote.bracket;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.BracketHandler;
import crafttweaker.annotations.ModOnly;
import crafttweaker.zenscript.IBracketHandler;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.util.List;
import stanhebben.zenscript.compiler.IEnvironmentGlobal;
import stanhebben.zenscript.expression.ExpressionCallStatic;
import stanhebben.zenscript.expression.ExpressionString;
import stanhebben.zenscript.parser.Token;
import stanhebben.zenscript.symbols.IZenSymbol;
import stanhebben.zenscript.type.natives.IJavaMethod;

@RTRegisterClass({"botania", "contenttweaker"})
@SuppressWarnings("ALL")
@ModOnly("contenttweaker")
@BracketHandler(priority = 100)
public class BracketHandlerCoTSubTileG implements IBracketHandler {

    public static SubTileGeneratingRepresentation getSubTileG(String name) {
        return RandomTweaker.subTileGeneratingMap.get(name);
    }

    @Override
    public IZenSymbol resolve(IEnvironmentGlobal environment, List<Token> tokens) {
        if (tokens.size() > 2) {
            if (tokens.get(0).getValue().equals("cotSubTileG") && tokens.get(1).getValue().equals(":")) {
                return find(environment, tokens);
            }
        }
        return null;
    }

    @Override
    public String getRegexMatchingString() {
        return "cotSubTileG:.*";
    }

    @Override
    public Class<?> getReturnedClass() {
        return SubTileGeneratingRepresentation.class;
    }

    private IZenSymbol find(IEnvironmentGlobal environment, List<Token> tokens) {
        String name = tokens.get(2).getValue();
        IJavaMethod method;
        if (getSubTileG(name) instanceof SubTileGeneratingRepresentation) {
            method = CraftTweakerAPI.getJavaMethod(BracketHandlerCoTSubTileG.class, "getSubTileG", String.class);
        } else {
            method = null;
        }
        return position -> new ExpressionCallStatic(position, environment, method, new ExpressionString(position, name));
    }
}
