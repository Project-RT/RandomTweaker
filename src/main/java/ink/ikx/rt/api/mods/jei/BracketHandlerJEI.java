package ink.ikx.rt.api.mods.jei;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.BracketHandler;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.zenscript.IBracketHandler;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import java.util.List;
import stanhebben.zenscript.compiler.IEnvironmentGlobal;
import stanhebben.zenscript.expression.ExpressionCallStatic;
import stanhebben.zenscript.expression.ExpressionString;
import stanhebben.zenscript.parser.Token;
import stanhebben.zenscript.symbols.IZenSymbol;
import stanhebben.zenscript.type.natives.IJavaMethod;

@ZenRegister
@BracketHandler(priority = 100)
public class BracketHandlerJEI implements IBracketHandler {

    @Override
    public IZenSymbol resolve(IEnvironmentGlobal environment, List<Token> tokens) {
        if (tokens.size() > 2) {
            if (tokens.get(0).getValue().equals("jei") && tokens.get(1).getValue().equals(":")) {
                return find(environment, tokens);
            }
        }
        return null;
    }

    @Override
    public String getRegexMatchingString() {
        return "jei:.*";
    }

    @Override
    public Class<?> getReturnedClass() {
        return JEIPanel.class;
    }

    public static JEIPanel getJEIPanel(String name) {
        return RandomTweaker.JEIPanelList.stream().filter(jeiPanel -> jeiPanel.getUid().equals(name)).findFirst().orElse(null);
    }

    private IZenSymbol find(IEnvironmentGlobal environment, List<Token> tokens) {
        String name = tokens.get(2).getValue();
        if (getJEIPanel(name) != null) {
            IJavaMethod method = CraftTweakerAPI.getJavaMethod(BracketHandlerJEI.class, "getJEIPanel", String.class);
            return position -> new ExpressionCallStatic(position, environment, method, new ExpressionString(position, name));
        }
        return null;
    }
}
