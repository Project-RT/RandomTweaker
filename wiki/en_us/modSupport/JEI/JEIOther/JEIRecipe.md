# JEIRecipe

Custom JEI Display RecipeMust correspond with the recipe, otherwise any problems will not be given to repair

## Import

```zenscript
import mods.randomtweaker.jei.JEIRecipe
```

Must correspond with the recipe, otherwise any problems will not be given to repair

| Getter | Return | Description |
|:---- | ---- | -----|
| uid | string | UID filled in when creating |
| inputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | Get all inputs for the current recipe |
| outputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | Get all outputs for the current recipe |
| JEIElements | [JEIElement[]](https://github.com/ikexing-cn/RandomTweaker/tree/master/wiki/en_us/modSupport/JEIELement/JEIELement.md) | Get the elements of the current recipe |

| Method | Parameter | Return | Description |
|:---- | ---- | -----| -----|
|setUid | string | ``this`` | Set  the UID at the time of creation |
|setInputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | ``this`` | Set all inputs for the recipe |
|setOutputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | ``this`` | Set all outputs for the recipe |
|addInput | [IIngredient](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | ``this`` | Add input recipe |
|addOutput | [IIngredient](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/)  | ``this``| Add output recipe |
|addJEIElement | [JEIElement](https://github.com/ikexing-cn/RandomTweaker/tree/master/wiki/en_us/modSupport/JEIELement/JEIELement.md) | ``this`` | Add elements |
|setJEIElements | [JEIElement[]](https://github.com/ikexing-cn/RandomTweaker/tree/master/wiki/en_us/modSupport/JEIELement/JEIELement.md) | ``this`` | Set the elements of the current recipe |
|onJEITooltip | function(mouseX as int, mouseY as int) | string[] | Add new tip to the specified place, this function is called only for the current recipe |

## Example

```zenscript
import mods.jei.JEI;
import mods.randomtweaker.jei.JEIRecipe;

JEI.createJEIRecipe("keys1")
    .addInput(<minecraft:apple>)
    .addInput(<liquid:lava> * 1000)
    .addOutput(<minecraft:diamond>)
    .addJEIElement(JEI.createJEIFontInfoElement(100, 8, "fontInfo", 0x52575B))
    .build();

JEI.createJEIRecipe("keys1")
    .addInput(<ore:oreIron>)
    .addInput(<liquid:water> * 1000)
    .addOutput(<minecraft:stick>)
    .onJEITooltip(function(mouseX, mouseY){
       var arr as string[] = ["test"];
       return arr;
    })
    .build();
```
