# JEIRecipe

自定义 JEI 显示配方

## 导包

```zenscript
import mods.randomtweaker.jei.JEIRecipe
```

设置JEI配方，请务必确保添加的配方对应于设置的槽位，否则出现各种问题不予修复

| Getter | 返回值 | 描述 | 
|:---- | ---- | -----|
| uid | string | 创建JEI时填的UID|
| inputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 获取当前配方的全部输入 |
| outputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 获取当前配方的全部输出 |
| JEIElements | [JEIElement[]](https://github.com/ikexing-cn/RandomTweaker/tree/master/wiki/zh_cn/modSupport/JEIELement/JEIELement.md) | 获取当前配方的渲染元素 |

| 方法 | 形参 | 返回值| 描述 | 
|:---- | ---- | -----| -----|
|setUid | string | ``this`` | 修改创建时候的UID (但我想你基本用不到这个功能)|
|setInputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | ``this`` | 设置配方的全部输入|
|setOutputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | ``this`` | 设置配方的全部输出|
|addInput | [IIngredient](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | ``this`` | 添加输入配方|
|addOutput | [IIngredient](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/)  | ``this``| 添加输出配方|
|addJEIElement | [JEIElement](https://github.com/ikexing-cn/RandomTweaker/tree/master/wiki/zh_cn/modSupport/JEIELement/JEIELement.md) | ``this`` | 添加渲染元素 |
|setJEIElements | [JEIElement[]](https://github.com/ikexing-cn/RandomTweaker/tree/master/wiki/zh_cn/modSupport/JEIELement/JEIELement.md) | ``this`` | 直接修改当前配方的渲染元素 |
|onJEITooltip | function(mouseX as int, mouseY as int) | string[] | 为指定的地方添加新的提示, 此函数仅在当前配方被调用 (不会覆盖Item和Fluid) |

## 例子

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