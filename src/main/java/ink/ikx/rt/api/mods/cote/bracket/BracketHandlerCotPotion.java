package ink.ikx.rt.api.mods.cote.bracket;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.BracketHandler;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.zenscript.IBracketHandler;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.potion.PotionRepresentation;
import java.util.List;
import stanhebben.zenscript.compiler.IEnvironmentGlobal;
import stanhebben.zenscript.expression.ExpressionCallStatic;
import stanhebben.zenscript.expression.ExpressionString;
import stanhebben.zenscript.parser.Token;
import stanhebben.zenscript.symbols.IZenSymbol;
import stanhebben.zenscript.type.natives.IJavaMethod;

@SuppressWarnings("ALL")
@BracketHandler(priority = 100)
@ModOnly("contenttweaker")
@ZenRegister
public class BracketHandlerCotPotion implements IBracketHandler {

    @Override
    public String getRegexMatchingString() {
        return "cotPotion:.*";
    }

    @Override
    public Class<?> getReturnedClass() {
        return PotionRepresentation.class;
    }

    @Override
    public IZenSymbol resolve(IEnvironmentGlobal environment, List<Token> tokens) {
        if (tokens.size() > 2) {
            if (tokens.get(0).getValue().equals("cotPotion") && tokens.get(1).getValue().equals(":")) {
                return find(environment, tokens);
            }
        }
        return null;
    }

    public static PotionRepresentation getPotion(String name) {
        if (RandomTweaker.potionRegMap.containsKey(name)) {
            return RandomTweaker.potionRegMap.get(name).getRepresentation();
        }
        return null;
    }

    private IZenSymbol find(IEnvironmentGlobal environment, List<Token> tokens) {
        String name = tokens.get(2).getValue();
        IJavaMethod method;
        if (getPotion(name) != null) {
            return position -> new ExpressionCallStatic(position, environment, CraftTweakerAPI.getJavaMethod(BracketHandlerCotPotion.class, "getPotion", String.class), new ExpressionString(position, name));
        }
        return null;
    }
}
