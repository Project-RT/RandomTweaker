# JEIPanel

自定义 JEI 面板

## 导包

```zenscript
import mods.randomtweaker.jei.JEIPanel;
```

例子请参考 [Custom JEI](../JEI.md#例子)

## Getter

| ZenGetter       | 返回类型       |
| :-------------- | :------------ |
| uid             | string        |
| localizationKey | string        |
| modid           | string        |
| icon            | [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) |
| JEIBackground   | [JEIBackground](JEIBackground.md) |
| recipeCatalysts | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) |
| JEISlots        | [JEISlot[]](../JEISlot/JEISlot.md) |
| JEIRecipes      | [JEIRecipe[]](JEIRecipe.md) |
| JEIElements     | [JEIElement[]](../JEIElement/JEIElement.md) |

## Methods

| Method | 返回类型 | 备注 |
| :------------------ | :------------------ | :------------------ |
| setModID(modid as string) | void | 显示的模组名 |
| setIcon(icon as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 显示在最上面的物品 |
| setJEIBackGroup(JEIBackground as [JEIBackground](JEIBackground.md)) | void | 设置背景 (可以自定义图片) |
| setJEIBackGroup(width as int, height as int) | void | 设置背景 (基本) |
| setRecipeCatalysts(recipeCatalysts as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 设置左侧显示的全部物品 |
| setJEISlots(JEISlots as [JEISlot[]](../JEISlot/JEISlot.md)) | void | 设置槽位 |
| setJEIRecipes(JEIRecipes as [JEIRecipe[]](JEIRecipe.md)) | void | 设置配方 (必须要和配方对应, 否则出任何问题不给予修复) |
| setJEIElements(JEIElements as [JEIElement[]](../JEIElement/JEIElement.md)) | void | 设置元素 |
| addJEISlot(JEIISlot as [JEISlot](../JEISlot/JEISlot.md)) | void | 添加槽位 |
| addRecipeCatalyst(recipeCatalyst as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 添加显示在左侧的物品 |
| addJEIRecipe(JEIRecipe as [JEIRecipe](JEIRecipe.md)) | void | 添加配方 |
| addJEIElement(JEIElement as [JEIElement](../JEIElement/JEIElement.md)) | void | 添加元素 |
| register() | void | 注册 |

## Function

| 函数 | 写法 | 返回类型 | 描述 |
| :--- | :------- | :---- | :------ |
| onJEITooltip | function(mouseX as int, mouseY as int) | string[] | 为指定的地方添加新的提示 (不会覆盖 Item 和 Fluid) |
