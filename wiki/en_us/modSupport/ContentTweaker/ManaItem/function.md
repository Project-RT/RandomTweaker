# Function

## Import package (two parameters of the function import the first package other import the second)

```zenscript
import mods.randomtweaker.cote.ManaItemForItemFunction;
import mods.randomtweaker.cote.ManaItemForPoolFunction;
```

## canExportManaToPool

Decide whether mana is output to the Mana Pool

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

决定物品是否接受魔力池的魔力

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待接受魔力的物品

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world where the Mana Pool is

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos where the Mana Pool is

```zenscript
manaItemObj.canReceiveManaFromPool = function(stack, world, pos) {
    return true;
};
```

## canExportManaToItem

决定魔力是否输出到需求魔力的物品上

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待输出魔力的物品

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 需求魔力的物品

```zenscript
manaItemObj.canExportManaToItem = function(stack, otherStack) {
    return true;
};
```

## canReceiveManaFromItem

决定物品是否接受其他物品输出的魔力

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待接受魔力的物品

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 输出魔力的物品

```zenscript
manaItemObj.canReceiveManaFromItem = function(stack, otherStack) {
    return true;
};
```
