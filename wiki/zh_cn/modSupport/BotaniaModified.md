# Botania Modified

## 水锈球

允许水绣球消耗其他流体 (需在配置文件开启后才可使用)

```zenscript
import mods.randomtweaker.botania.Hydroangeas;
```

| 方法                                                         | 返回值 | 描述 |
| :----------------------------------------------------------- | :----- | ----------- |
| setFactor(liquid as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), catalyst as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), factor as double) | void   | 设置流体类型的 Factor，第一个参数为消耗的流体 |
| setBlockBelowFactor(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional(2.0d) factor as double) | void | 设置方块类型的 Factor, 当其在水绣球的下方则可提升水绣球的产魔量 |
| addManaRecipe(liquid as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), mana as int, catalyst as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), @Optional(2.0d) extraMana as double) | void | 添加增加产魔配方, 当流体类型的 catalyst 存在时, 水绣球的产魔量将乘以 extraMana，后两个参数可省略 |

## 凝矿兰

使得凝矿兰不仅限于石头转换 (needs to be enabled in the configuration file).

```zenscript
import mods.randomtweaker.botania.Orechid;
```

| 方法                                                         | 返回值 | 描述 |
| :----------------------------------------------------------- | :----- | ----------- |
| addOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/), weight as int) | void | 添加凝矿兰配方，第一个参数为需转换的方块，第二个参数为转换后的矿辞，第三个参数为权重 |
| addOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/), weight as int) | void | 同上 |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 删除此方块下的全部配方 |
| delOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | void | 同上 |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), string oreName) | void | 删除此方块下指定的输出物 |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | void | 同上 |
| delOreWeight(block as block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), string oreName) | void | 同上 |
| delOreWeight(block as block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | void | 同上 |
| getOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | IOreDictEntry[] | 获取此方块下的全部输出物 (不包含权重) |
| getOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | IOreDictEntry[] | 同上 |
