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

Determines whether the item receives mana from the Mana Pool

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

Determines whether mana is output to items that require mana

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Items to be output Mana

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Item that needs Mana

```zenscript
manaItemObj.canExportManaToItem = function(stack, otherStack) {
    return true;
};
```

## canReceiveManaFromItem

Determines whether the item accepts mana output from other items

Need to return a bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Items to be output Mana 

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Item that outputs Mana

```zenscript
manaItemObj.canReceiveManaFromItem = function(stack, otherStack) {
    return true;
};
```
