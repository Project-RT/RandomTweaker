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
| inputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 这个配方的全部输入 |
| outputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 这个配方的全部输出 |

| 方法 | 返回值 | 描述 | 
|:---- | ---- | -----|
|setUid | string | 修改创建时候的UID(但我想你基本用不到这个功能)|
|setInputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 设置配方的全部输入|
|setOutputs | [IIngredient[]](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 设置配方的全部输出|
|addInput | [IIngredient](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 添加输入配方|
|addOutput | [IIngredient](https://docs.blamejared.com/1.12/en/Vanilla/Variable_Types/IIngredient/) | 添加输出配方|

| 函数 | 写法 | 返回值 | 描述 |
|:--- |:------- |---- | ------|
| onJEITooltip | function(mouseX as int, mouseY as int)) | string[] | 为指定的地方添加新的提示, 此函数仅在当前配方被调用 (不会覆盖Item和Fluid)

## 例子

```zenscript
import mods.jei.JEI;
import mods.randomtweaker.jei.JEIRecipe;

JEI.createJEIRecipe("keys1")
    .addInput(<minecraft:apple>)
    .addInput(<liquid:lava> * 1000)
    .addOutput(<minecraft:diamond>)
    .build();

// ZenSetter的返回值必须为void，用链式调用会很难看，所以我建议如下
var recipe as JEIRecipe = JEI.createJEIRecipe("keys1");
recipe.addInput(<ore:oreIron>)
recipe.addInput(<liquid:water> * 1000)
recipe.addOutput(<minecraft:stick>);
recipe.onJEITooltip = function(mouseX, mouseY){
   var arr as string[] = ["test"];
   return arr;
};
recipe.build();
```