# Botania Modified

## 水绣球

允许水绣球消耗其他流体（需在配置文件开启后才可使用）

导包：

~~~zenscript
import mods.randomtweaker.Hydroangeas;
~~~

| 方法                                                         | 返回值 | 描述                                             |
| :----------------------------------------------------------- | :----- | ------------------------------------------------ |
| addManaRecipe(ILiquidStack inputFluid, int mana, @Optional(2.0d) double factor) | void   | 添加流体配方，并指定在Factor存在时的产魔增加倍数 |
| setFactor(ILiquidStack inputFluid)                           | void   | 设置Factor，存在水绣球的工作区域时则可提升产魔量 |
| setBlockBelowFactor(IItemStack block, @Optional(2.0d) double factor) | void   | 设置方块Factor，存在水绣球的下方时则可提升产魔量 |
