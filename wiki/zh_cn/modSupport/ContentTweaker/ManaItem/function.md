# Function

## 导包 (两个参数的函数导第一个包其他导第二个)

```zenscript
import mods.randomtweaker.cote.ManaWithItem;
import mods.randomtweaker.cote.ManaWithPool;
```

## canExportManaToPool

决定魔力是否输出到魔力池上

需要返回一个 bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待输出魔力的物品

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 魔力池所在的世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 魔力池所在的坐标

```zenscript
manaItemObj.canExportManaToPool = function(stack, world, pos) {
    return true;
};
```

## canReceiveManaFromPool

决定物品是否接受魔力池的魔力

需要返回一个 bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待接受魔力的物品

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 魔力池所在的世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 魔力池所在的坐标

```zenscript
manaItemObj.canReceiveManaFromPool = function(stack, world, pos) {
    return true;
};
```

## canExportManaToItem

决定魔力是否输出到需求魔力的物品上

需要返回一个 bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待输出魔力的物品

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 需求魔力的物品

```zenscript
manaItemObj.canExportManaToItem = function(stack, otherStack) {
    return true;
};
```

## canReceiveManaFromItem

决定物品是否接受其他物品输出的魔力

需要返回一个 bool

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 待接受魔力的物品

* otherStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 输出魔力的物品

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

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 物品本身

```zenscript
manaUsingItemObj.usesMana = function(stack) {
    return true;
};
```
