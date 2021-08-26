# JEIPanel

Custom JEI Panel

## Import

```zenscript
import mods.randomtweaker.jei.JEIPanel;
```

For examples, please refer to [Custom JEI](../JEI.md#example)

## Getter

| ZenGetter       | Return Type   |
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

| Method | Return Type | Remark |
| :------------------ | :------------------ | :------------------ |
| setModID(modid as string) | void | As the name implies |
| setIcon(icon as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | void | As the name implies |
| setJEIBackGroup(JEIBackground as [JEIBackground](JEIBackground.md) | void | As the name implies (Customizable image) |
| setJEIBackGroup(width as int, height as int) | void | As the name implies(Height and width only) |
| setRecipeCatalysts(recipeCatalysts as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | void | Set all items displayed on the left |
| setJEISlots(JEISlots as [JEISlot[]](../JEISlot/JEISlot.md) | void | As the name implies |
| setJEIRecipes(JEIRecipes as [JEIRecipe[]](JEIRecipe.md) | void | As the name implies (Must correspond with the recipe, otherwise any problems will not be given to repair) |
| setJEIElements(JEIElements as [JEIElement[]](../JEIElement/JEIElement.md) | void | As the name implies |
| addJEISlot(JEIISlot as [JEISlot](../JEISlot/JEISlot.md) | void | As the name implies |
| addRecipeCatalyst(recipeCatalyst as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | void | Add items displayed on the left |
| addJEIRecipe(JEIRecipe as [JEIRecipe](JEIRecipe.md) | void | As the name implies |
| addJEIElement(JEIElement as [JEIElement](../JEIElement/JEIElement.md) | void | As the name implies |
| register() | void   | As the name implies |

| function | Use | Retrun | Description |
| :--- | :------- | :---- | :------ |
| onJEITooltip | function(mouseX as int, mouseY as int) | string[] | Add a new tip for the specified place |
