# Botania Modified

## Hydroangeas

Allow Hydroangeas to consume other fluids (needs to be enabled in the configuration file).

```zenscript
import mods.randomtweaker.botania.Hydroangeas;
```

| Method                                                   | Return | Description |
| :----------------------------------------------------------- | :----- | ----------- |
| setFactor(factor as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/)) | void   | Set the Factor of fluid |
| setBlockBelowFactor(factor as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional(2.0d) factor as double) | void | Set the Factor of the block, when it‘s below Hydroangeas it will increase the amount of mana it produces it produced. |
| addManaRecipe(factor as [ILiquidStack](https://docs.blamejared.com/1.12/en/Vanilla/Liquids/ILiquidStack/), mana as int, @Optional(2.0d) extraMana as double) | void | Added recipes that produce extra mana, When the factor of fluid is present, the amount of mana it  produced by Hydroangeas will be multiplied by extraMana |

## Orechid

Making Orechid more blocks than just convert Stone (needs to be enabled in the configuration file).

```zenscript
import mods.randomtweaker.botania.Orechid;
```

| Methods                                                         | Return | Description |
| :----------------------------------------------------------- | :----- | ----------- |
| addOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/), weight as int) | void | Add the Orechid recipe, the first parameter is the block to be converted, the second parameter is the converted OreDict, and the third parameter is the weight |
| addOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/), weight as int) | void | same as above |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | Delete the recipes of this block |
| delOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | void | same as above |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), string oreName) | void | Delete the specified output of this block |
| delOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | void | same as above |
| delOreWeight(block as block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), string oreName) | void | same as above |
| delOreWeight(block as block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/), ore as [IOreDictEntry](https://docs.blamejared.com/1.12/en/Vanilla/OreDict/IOreDictEntry/)) | void | same as above |
| getOreWeight(block as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | IOreDictEntry[] | Get all outputs of this block (without weights) |
| getOreWeight(block as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | IOreDictEntry[] | same as above |