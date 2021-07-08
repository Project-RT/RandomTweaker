# Botania Modified

Allow hroangeas to consume other fluids (needs to be enabled in the configuration file).

```zenscript
import mods.randomtweaker.botania.Hydroangeas;
```

| Method                                                   | Return | Description |
| :----------------------------------------------------------- | :----- | ----------- |
| setFactor(factor as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/)) | void   | Set the Factor of fluid |
| setBlockBelowFactor(factor as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional(2.0d) factor as double) | void | Set the Factor of the block, when it‘s below hroangeas it will increase the 产魔量. |
| addManaRecipe(factor as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), mana as int, @Optional(2.0d) extraMana as double) | void | 添加增加产魔配方,When the factor of fluid is present, the 产魔量 of hroangeas will be multiplied by extraMana |

