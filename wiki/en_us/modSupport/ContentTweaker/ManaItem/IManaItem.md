# IManaItem

This class is only registered in CraftTweaker when both `Botania` and `CoT` are loaded.

## Import

```zenscript
import mods.randomtweaker.item.IManaItem;
```

You can use the `isIManaItem()` method on an instance of the [IMutableItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IMutableItemStack/)
class using the `isIManaItem()` method to determine if it is an instance of the IManaItem class, and if so, use the `asIManaItem()` method to convert it

| Getter | Return | Description |
| :----- | ---- | ----- |
| mana | int | Current Mana Value|
| maxMana | int | Maximum Mana value |
| noExport | bool | Whether the item exports Mana |
| hasFull | bool | Whether the item has a item with full Mana |
| hasCreative | bool | Whether the item has a creative item |
| creative | bool | Whether the item is a creative item |
| full | bool | Whether the item is full of Mana |

| Method | Return | Description |
| :----- | ---- | ----- |
| updateMana(mana as int) | int | Increases or decreases Mana , returns the actual increase or decrease value |
| canExportManaToPool(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | bool | Whether to export Mana to Mana Pool ([Parameter Analysis](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaItem/function.md#canexportmanatopool)) |
| canExportManaToItem(otherStack as [IItemStack](https://docs.blamejared.)) | bool | Whether to export Mana to items that using Mana ([Parameter Analysis](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaItem/function.md#canexportmanatoitem)) |
| canReceiveManaFromPool(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | bool | Whether to accept the Mana from Mana Pool ([Parameter Analysis](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaItem/function.md#canreceivemanafrompool)) |
| canReceiveManaFromItem(otherStack as [IItemStack](https://docs.blamejared.)) | bool | Whether to accept the Mana from item ([Parameter Analysis](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaItem/function.md#canreceivemanafromitem)) |
