# Custom JEI

## 导包

~~~zenscript
import mods.jei.JEI;
~~~

| 方法                                                         | 返回值             | 备注                                                         |
| :----------------------------------------------------------- | :----------------- | ------------------------------------------------------------ |
| createJEIPanel(uid as string, localizationKey as string) | [JEIPanel](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIPanel.md) | |
| createJEIBackground(width as int, height as int) | [JEIBackground](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIBackground.md) | |
| createJEIBackground(resourceName as string, u as int, v as int, width as int, height as int) | [JEIBackground](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIBackground.md) |                                                              |
| createLiquidSlot(isInput as bool, x as int, y as int, @Optional(valueBoolean = true) hasBase as bool) | [JEILiquidSlot](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEISlot/JEILiquidSlot.md) | hasBase 为是否创建那个固定的流体槽 |
| createLiquidSlot(isInput as bool, x as int, y as int, width as int, height as int, capacityMb as int, showCapacity as bool, @Optional(valueBoolean = true) hasBase as bool) | [JEILiquidSlot](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEISlot/JEILiquidSlot.md)  | hasBase 同上, 但流体槽必须要根据固定的宽高创建 (eg：16 * 16，43 * 16， 16 * 34) |
| createItemSlot(isInput as bool, x as int, y as int, @Optional(valueBoolean = true) hasBase as bool) | [JEIItemSlot](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEISlot/JEIItemSlot.md) | hasBase 为是否创建那个固定的物品槽 |
| createJEIRecipe(uid as string) | [JEIRecipe](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIRecipe.md) | 创建JEI的配方，uid为定义JEI的uid |
| createJEIItemInputElement(x as int, y as int) | [JEIItemElement](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIElement/JEIItemElement.md) | |
| createJEIItemOutputElement(x as int, y as int) | [JEIItemElement](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIElement/JEIItemElement.md) | |
| createJEIFluidElement(x as int, y as int, width as int, height as int) | [JEIFluidElement](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIElement/JEIFluidElement.md) | |
| createJEIFontInfoElement(x as int, y as int, info as string, color as int) | [JEIFontInfoElement](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIElement/JEIFontInfoElement.md) | |
| createJEIArrowElement(x as int, y as int, direction as int) | [JEIArrowElement](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIElement/JEIArrowElement.md) | direction 参数为四个箭头，可填 0-3 |
| createJEICustomElement(x as int, y as int, width as int, height as int, u as int, v as int, texture as string) | [JEICustomElement](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/JEI/JEIElement/JEICustomElement.md) | texture 的格式为 modid:路径 |

## 例子

```zenscript
import mods.jei.JEI;
import mods.randomtweaker.JEIPanel;

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
