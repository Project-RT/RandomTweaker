# Custom JEI

## Import

```zenscript
import mods.jei.JEI;
```

## Methods

| Method | Return Type | Remark |
| :----------------------- | :----------------------- | :----------------------- |
| createJEIPanel(uid as string, localizationKey as string) | [JEIPanel](JEIOther/JEIPanel.md) |  |
| createJEIBackground(width as int, height as int) | [JEIBackground](JEIOther/JEIBackground.md) |  |
| createJEIBackground(resourceName as string, u as int, v as int, width as int, height as int) | [JEIBackground](JEIOther/JEIBackground.md) |  |
| createLiquidSlot(isInput as bool, x as int, y as int, @Optional(true) hasBase as bool) | [JEILiquidSlot](JEISlot/JEILiquidSlot.md) | hasBase is whether to render the default fluid slot (need to compare width and height) |
| createLiquidSlot(isInput as bool, x as int, y as int, width as int, height as int, capacityMb as int, showCapacity as bool, @Optional(true) hasBase as bool) | [JEILiquidSlot](JEISlot/JEILiquidSlot.md) | hasBase as above, but the fluid slot must be created with a fixed width and height (eg：16 * 16, 43 * 16, 16 * 34) |
| createItemSlot(isInput as bool, x as int, y as int, @Optional(true) hasBase as bool) | [JEIItemSlot](JEISlot/JEIItemSlot.md) | hasBase is whether to render the default item slot |
| createJEIRecipe(uid as string) | [JEIRecipe](JEIOther/JEIRecipe.md) | Create recipe for JEI, uid is defined uid |
| createJEIItemInputElement(x as int, y as int) | [JEIItemElement](JEIElement/JEIItemElement.md) |  |
| createJEIItemOutputElement(x as int, y as int) | [JEIItemElement](JEIElement/JEIItemElement.md) |  |
| createJEIFluidElement(x as int, y as int, width as int, height as int) | [JEIFluidElement](JEIElement/JEIFluidElement.md) |  |
| createJEIFontInfoElement(x as int, y as int, info as string, color as int, @Optional width as int, @Optional height as int) | [JEIFontInfoElement](JEIElement/JEIFontInfoElement.md) |  |
| createJEIArrowElement(x as int, y as int, direction as int) | [JEIArrowElement](JEIElement/JEIArrowElement.md) | direction is four arrows, you can fill 0 or 1 or 2 or 3 |
| createJEICustomElement(x as int, y as int, width as int, height as int, u as int, v as int, texture as string) | [JEICustomElement](JEIElement/JEICustomElement.md) | The format of the texture is modid:path |
| createJEIManaBarElement(x as int, y as int, mana as int) | [JEIManaBarElement](JEIElement/JEIManaBarElement.md) | |
## Hot reload

Please install Mod

Both [Event hot reload](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
and [ContentTweaker fuction hot reload](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction)
are provided by this mod

```zenscript
#loader crafttweaker reloadableevents

<jei:uid>.JEISlots[0].x = 10;
<jei:uid>.JEISlots[0].y = 20;

<jei:uid>.JEIElements[0].x = 30;
```

## Example

```zenscript
import mods.jei.JEI;
import mods.randomtweaker.jei.JEIPanel;

var keyJEI as JEIPanel = JEI.createJEIPanel("keys", "key");
keyJEI.setJEIBackGroup(JEI.createJEIBackground(150, 50));
keyJEI.addRecipeCatalyst(<minecraft:stone:3>);
keyJEI.addRecipeCatalyst(<minecraft:stone:1>);
keyJEI.addJEISlot(JEI.createItemSlot(true, 16, 18));
keyJEI.addJEISlot(JEI.createItemSlot(false, 80, 18));
keyJEI.addJEIElement(JEI.createJEIFontInfoElement(50, 18,  "font", 0x000000));
keyJEI.addJEIElement(JEI.createJEIFontInfoElement(100, 18, "fontInfo", 0x52575B));
keyJEI.register();

var keyJEI1 as JEIPanel = JEI.createJEIPanel("keys1", "key1");
keyJEI1.setJEIBackGroup(JEI.createJEIBackground(150, 50));
keyJEI1.addRecipeCatalyst(<minecraft:apple>);
keyJEI1.addRecipeCatalyst(<minecraft:stick>);
keyJEI1.addJEISlot(JEI.createItemSlot(true, 16, 18));
keyJEI1.addJEISlot(JEI.createItemSlot(false, 50, 18));
keyJEI1.addJEISlot(JEI.createLiquidSlot(true, 100, 18, 16, 34, 1000, false));
keyJEI1.onJEITooltip = function(mouseX, mouseY){
    var arr as string[] = ["test"];
    if (mouseX == 50 && mouseY == 50){
        return arr;
    }
};
keyJEI1.register();
```
