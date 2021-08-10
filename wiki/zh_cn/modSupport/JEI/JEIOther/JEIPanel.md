# JEIPanel

自定义 JEI 面板

## 导包

~~~zenscript
import mods.randomtweaker.jei.JEIPanel;
~~~

例子请参考 [Custom JEI](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEI.md)

| ZenGetter       | 返回值        |
| :-------------- | :------------ |
| uid             | string        |
| localizationKey | string        |
| modid           | string        |
| icon            | [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)    |
| JEIBackground   | [JEIBackground](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIOther/JEIBackground.md) |
| recipeCatalysts | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)  |
| JEISlots        | [JEISlot[]](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEISlot/JEISlot.md)     |
| JEIRecipes      | [JEIRecipe[]](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIOther/JEIRecipe.md)   |
| JEIElements     | [JEIElement[]](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIElement/JEIElement.md)  |

| 方法                                             | 返回值 | 备注                                                   |
| :----------------------------------------------- | :----- | ------------------------------------------------------ |
| setModID(modid as string)                           | void   | 显示的模组名                                           |
| setIcon(icon as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/))                         | void   | 显示在最上面的物品                                     |
| setJEIBackGroup(JEIBackground as [JEIBackground](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIOther/JEIBackground.md))     | void   | 设置背景 (可以自定义图片)                             |
| setJEIBackGroup(width as int, height as int)            | void   | 设置背景 (基本)                                       |
| setRecipeCatalysts(recipeCatalysts as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void   | 设置左侧显示的全部物品                                 |
| setJEISlots(JEISlots as [JEISlot[]](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEISlot/JEISlot.md))                  | void   | 设置槽位                                               |
| setJEIRecipes(JEIRecipes as [JEIRecipe[]](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIOther/JEIRecipe.md))            | void   | 设置配方 (必须要和配方对应，否则出任何问题不给予修复) |
| setJEIElements(JEIElements as [JEIElement[]](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIElement/JEIElement.md))         | void   | 设置元素                                               |
| addJEISlot(JEIISlot as [JEISlot](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEISlot/JEISlot.md))                     | void   | 添加槽位                                               |
| addRecipeCatalyst(recipeCatalyst as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/))     | void   | 添加显示在左侧的物品                                   |
| addJEIRecipe(JEIRecipe as [JEIRecipe](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIOther/JEIRecipe.md))                | void   | 添加配方                                               |
| addJEIElement(JEIElement as [JEIElement](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/JEI/JEIElement/JEIElement.md))             | void   | 添加元素                                               |
| register()                                       | void   | 注册                                                   |

| 函数 | 写法 | 返回值 | 描述 |
|:--- |:------- |---- | ------|
| onJEITooltip | function(mouseX as int, mouseY as int) | string[] | 为指定的地方添加新的提示 (不会覆盖Item和Fluid) |