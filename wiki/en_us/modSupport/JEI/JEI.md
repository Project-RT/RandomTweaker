# Custom JEI

## Import

```zenscript
import mods.jei.JEI;
```

| Method                                                       | Return                                                       | Remark                                                       |
| :----------------------------------------------------------- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| createJEIPanel(uid as string, localizationKey as string)     | [JEIPanel](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIOther/JEIPanel.md) |                                                              |
| createJEIBackground(width as int, height as int)             | [JEIBackground](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIOther/JEIBackground.md) |                                                              |
| createJEIBackground(resourceName as string, u as int, v as int, width as int, height as int) | [JEIBackground](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIOther/JEIBackground.md) |                                                              |
| createLiquidSlot(isInput as bool, x as int, y as int, @Optional(valueBoolean = true) hasBase as bool) | [JEILiquidSlot](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEISlot/JEILiquidSlot.md) | hasBase is whether to render the default fluid slot (need to compare width and height)） |
| createLiquidSlot(isInput as bool, x as int, y as int, width as int, height as int, capacityMb as int, showCapacity as bool, @Optional(valueBoolean = true) hasBase as bool) | [JEILiquidSlot](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEISlot/JEILiquidSlot.md) | hasBase as above, but the fluid slot must be created with a fixed width and height (eg：16 * 16, 43 * 16, 16 * 34) |
| createItemSlot(isInput as bool, x as int, y as int, @Optional(valueBoolean = true) hasBase as bool) | [JEIItemSlot](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEISlot/JEIItemSlot.md) | hasBase is whether to render the default item slot           |
| createJEIRecipe(uid as string)                               | [JEIRecipe](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIOther/JEIRecipe.md) | Create recipe for JEI, uid is defined uid                    |
| createJEIItemInputElement(x as int, y as int)                | [JEIItemElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIElement/JEIItemElement.md) |                                                              |
| createJEIItemOutputElement(x as int, y as int)               | [JEIItemElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIElement/JEIItemElement.md) |                                                              |
| createJEIFluidElement(x as int, y as int, width as int, height as int) | [JEIFluidElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIElement/JEIFluidElement.md) |                                                              |
| createJEIFontInfoElement(x as int, y as int, info as string, color as int, @Optional width as int, @Optional height as int) | [JEIFontInfoElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIElement/JEIFontInfoElement.md) |                                                              |
| createJEIArrowElement(x as int, y as int, direction as int)  | [JEIArrowElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIElement/JEIArrowElement.md) | direction is four arrows, you can fill in 0-3                |
| createJEICustomElement(x as int, y as int, width as int, height as int, u as int, v as int, texture as string) | [JEICustomElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/JEI/JEIElement/JEICustomElement.md) | The format of the texture is modid:path                      |

## Hot reload

Please install  Mod

Both [Event hot reload](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
and [ContentTweaker fuction hot reload](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) are provided by this mod

```zenscript
#loader crafttweaker reloadableevents
<jei:uid>.getJEISlots()[0].x = 10;
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
