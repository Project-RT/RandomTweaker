# Botania Modified

允许水绣球消耗其他流体 (需在配置文件开启后才可使用)

```zenscript
import mods.randomtweaker.Hydroangeas;
```

| 方法                                                         | 返回值 | 描述 |
| :----------------------------------------------------------- | :----- | ----------- |
| setFactor(factor as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/)) | void   | 设置流体类型的 Factor |
| setBlockBelowFactor(factor as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional(2.0d) factor as double) | void | 设置方块类型的 Factor, 当其在水绣球的下方则可提升水绣球的产魔量 |
| addManaRecipe(factor as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), mana as int, @Optional(2.0d) extraMana as double) | void | 添加增加产魔配方, 当流体类型的 Factor 存在时, 水绣球的产魔量将乘于 extraMana |
