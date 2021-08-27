# Function

## Import package (two parameters of the function import the first package other import the second)

```zenscript
import mods.randomtweaker.cote.ManaItemForItemFunction;
import mods.randomtweaker.cote.ManaItemForPoolFunction;
```

## canExportManaToPool

Decide whether mana can be exported to the Mana Pool

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Items to be output Mana

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world where the Mana Pool is

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos where the Mana Pool is

```zenscript
manaItemObj.canExportManaToPool = function(stack, world, pos) {
    return true;
};
```

## canReceiveManaFromPool

Decide whether the item receives mana from the Mana Pool

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Items to be input Mana

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world where the Mana Pool is

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos where the Mana Pool is

```zenscript
manaItemObj.canReceiveManaFromPool = function(stack, world, pos) {
    return true;
};
```

## canExportManaToItem

Decide whether mana is output to items that require mana

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Items to be output Mana

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Item that needs Mana

```zenscript
manaItemObj.canExportManaToItem = function(stack, otherStack) {
    return true;
};
```

## canReceiveManaFromItem

Decide whether the item accepts mana output from other items

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Items to be
  output Mana

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Item
  that outputs Mana

```zenscript
manaItemObj.canReceiveManaFromItem = function(stack, otherStack) {
    return true;
};
```

## usesMana

### 导包

```zenscript
import mods.randomtweaker.cote.IsUsesMana;
```

决定物品是否使用背包或者饰品里储存的魔力 (仅 [ManaUsingItem](ManaUsingItem.md) 有此函数)

需要返回一个 bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) The item
  itself

```zenscript
manaUsingItemObj.usesMana = function(stack) {
    return true;
};
```
