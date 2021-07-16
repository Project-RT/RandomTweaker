# Function

## onBlockAdded

当产魔花被添加到世界上时调用

### 导包

```zenscript
import mods.randomtweaker.cote.BlockAdded;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 产魔花所在世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 产魔花所在坐标

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) 产魔花的方块状态

```zenscript
subTileGeneratingObj.onBlockAdded = function(world, pos, state) {

}
```

## canSelect

森林法杖是否可以选择此产魔花并绑定到方块上

需要返回一个 bool

### 导包

```zenscript
import mods.randomtweaker.cote.CanSelect;
```

* player
  as [Player](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  玩家

* wand as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 玩家手持的法杖

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 绑定的方块的坐标

* side as [IFacing](https://docs.blamejared.com/1.12/en/Vanilla/World/IFacing/) 玩家的方向

```zenscript
subTileGeneratingObj.canSelect = function(player, wand, pos, side) {
    return true;
}
```

## onBlockPlaceBy

当产魔花被一个实体放置在世界时调用

### 导包

```zenscript
import mods.randomtweaker.cote.BlockPlacedBy;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 产魔花所在世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 产魔花的坐标

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) 产魔花的方块状态

* entity
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  放置产魔花的实体

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)

```zenscript
subTileGeneratingObj.canSelect = function(world, pos, state, entity, stack) {

}
```

## onUpdate

每 Tick 都会调用

### 导包

```zenscript
import mods.randomtweaker.cote.UpdateWithGenerating;
```
