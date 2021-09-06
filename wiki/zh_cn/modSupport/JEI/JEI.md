# Custom JEI

## 导包

```zenscript
import mods.jei.JEI;
```

## Methods

| 方法 | 返回类型 | 备注 |
| :----------------------- | :----------------------- | :----------------------- |
| createJEIPanel(uid as string, localizationKey as string) | [JEIPanel](JEIOther/JEIPanel.md)|  |
| createJEIBackground(width as int, height as int) | [JEIBackground](JEIOther/JEIBackground.md) |  |
| createJEIBackground(resourceName as string, u as int, v as int, width as int, height as int) | [JEIBackground](JEIOther/JEIBackground.md) |  |
| createLiquidSlot(isInput as bool, x as int, y as int, @Optional(true) hasBase as bool) | [JEILiquidSlot](JEISlot/JEILiquidSlot.md) | isInput 为是否是输入流体, hasBase 为是否渲染默认的流体槽 (需对比宽高) |
| createLiquidSlot(isInput as bool, x as int, y as int, width as int, height as int, capacityMb as int, showCapacity as bool, @Optional(true) hasBase as bool) | [JEILiquidSlot](JEISlot/JEILiquidSlot.md) | isInput/hasBase 同上, 但流体槽必须要根据固定的宽高创建 (eg：16 * 16, 43 * 16, 16 * 34) |
| createItemSlot(isInput as bool, x as int, y as int, @Optional(true) hasBase as bool) | [JEIItemSlot](JEISlot/JEIItemSlot.md) | isInput 为是否是输入物品, hasBase 为是否渲染固定的物品槽 |
| createJEIRecipe(uid as string) | [JEIRecipe](JEIOther/JEIRecipe.md) | 创建JEI的配方, uid 为定义 JEI 的 uid |
| createJEIItemInputElement(x as int, y as int) | [JEIItemElement](JEIElement/JEIItemElement.md) |  |
| createJEIItemOutputElement(x as int, y as int) | [JEIItemElement](JEIElement/JEIItemElement.md) |  |
| createJEIFluidElement(x as int, y as int, width as int, height as int) | [JEIFluidElement](JEIElement/JEIFluidElement.md) |  |
| createJEIFontInfoElement(x as int, y as int, info as string, color as int, @Optional width as int, @Optional height as int) | [JEIFontInfoElement](JEIElement/JEIFontInfoElement.md) |  |
| createJEIArrowElement(x as int, y as int, direction as int) | [JEIArrowElement](JEIElement/JEIArrowElement.md) | direction 参数为四个箭头, 可填 0, 1, 2, 3 |
| createJEICustomElement(x as int, y as int, width as int, height as int, u as int, v as int, texture as string) | [JEICustomElement](JEIElement/JEICustomElement.md) | texture 的格式为 modid:path |
| createJEIManaBarElement(x as int, y as int, mana as int) | [JEICustomElement](JEIElement/JEIManaBarElement.md) | mana 为植物魔法魔力值 |
## 热重载

请安装 `ZenUtils` Mod

[事件热重载](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
和 [CoT 函数热重载](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) 都是此 Mod 提供的

```zenscript
#loader crafttweaker reloadableevents

<jei:uid>.JEISlots[0].x = 10;
<jei:uid>.JEISlots[0].y = 20;

<jei:uid>.JEIElements[0].x = 30;
```

## 例子

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
