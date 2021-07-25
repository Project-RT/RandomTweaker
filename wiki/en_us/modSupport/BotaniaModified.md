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

## 凝矿兰

使得凝矿兰不仅限于石头转换 (needs to be enabled in the configuration file).

```zenscript
import mods.randomtweaker.botania.Orechid;
```

| 方法                                                         | 返回值 | 描述 |
| :----------------------------------------------------------- | :----- | ----------- |
| addOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/), weight as int) | void | 添加凝矿兰配方，第一个参数为需转换的方块，第二个参数为转换后的矿辞，第三个参数为权重 |
| addOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/), weight as int) | void | 同上 |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | boolean | 删除此方块下的全部配方 |
| delOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | boolean | 同上 |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), string oreName) | boolean | 删除此方块下指定的输出物 |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | boolean | 同上 |
| delOreWeight(block as block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | boolean | 同上 |
| delOreWeight(block as block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | boolean | 同上 |
| getOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | IOreDictEntry[] | 获取此方块下的全部输出物 (不包含权重) |
| getOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | IOreDictEntry[] | 同上 |