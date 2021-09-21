# IManaItem

This class is only registered in CraftTweaker when both `Botania` and `CoT` are loaded.

## Import

```zenscript
import mods.randomtweaker.item.IManaItem;
```

## Transform

You can use the `isIManaItem()` method on an instance of
the [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) to determine if it
is an instance of the IManaItem class, and if so, use the `asIManaItem()` method to convert it

## Getter

| Getter | Return Type | Description |
| :----- | ---- | ----- |
| mana | int | Current Mana Value|
| maxMana | int | Maximum Mana value |
| noExport | bool | Whether the item exports Mana |
| hasFull | bool | Whether the item has a item with full Mana |
| hasCreative | bool | Whether the item has a creative item |
| creative | bool | Whether the item is a creative item |
| full | bool | Whether the item is full of Mana |

## Methods

| Method | Return Type | Description |
| :----- | ---- | ----- |
| updateMana(mana as int) | int | Increases or decreases Mana , returns the actual increase or decrease value |
| canExportManaToPool(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | bool | Whether to export Mana to Mana Pool ([Parameter Analysis](function.md#canexportmanatopool)) |
| canExportManaToItem(otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | bool | Whether to export Mana to items that using Mana ([Parameter Analysis](function.md#canexportmanatoitem)) |
| canReceiveManaFromPool(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | bool | Whether to accept the Mana from Mana Pool ([Parameter Analysis](function.md#canreceivemanafrompool)) |
| canReceiveManaFromItem(otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | bool | Whether to accept the Mana from item ([Parameter Analysis](function.md#canreceivemanafromitem)) |
| getUseMana() | bool | 如果此物品是 [ManaUsingItem](ManaUsingItem.md) 类实例, 则返回能否使用魔力 |