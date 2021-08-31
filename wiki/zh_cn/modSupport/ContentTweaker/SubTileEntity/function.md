# Function

## onBlockAdded

当自定义花被添加到世界上时调用

### 导包

```zenscript
import mods.randomtweaker.cote.BlockAdded;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 自定义花所在世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花所在坐标

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) 自定义花的方块状态

```zenscript
subTileEntityObj.onBlockAdded = function(world, pos, state) {

};
```

## canSelect

森林法杖是否可以选择此自定义花并绑定到方块上

需要返回一个 bool

### 导包

```zenscript
import mods.randomtweaker.cote.CanSelect;
```

* player
  as [ICTPlayer](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  玩家

* wand as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 玩家手持的法杖

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花的坐标

* side as [IFacing](https://docs.blamejared.com/1.12/en/Vanilla/World/IFacing/) 自定义花面对你的方向

```zenscript
subTileEntityObj.canSelect = function(player, wand, pos, side) {
    return true;
};
```

## onBlockPlaceBy

当自定义花被一个实体放置在世界时调用

### 导包

```zenscript
import mods.randomtweaker.cote.BlockPlacedBy;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 自定义花所在世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花的坐标

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) 自定义花的方块状态

* entity
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  放置自定义花的实体

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 手上的物品 (
  也就是你放下的那朵自定义花)

```zenscript
subTileEntityObj.onBlockPlaceBy = function(world, pos, state, entity, stack) {

};
```

## onUpdate

每 Tick 都会调用

### 导包

```zenscript
import mods.randomtweaker.cote.Update;
```

* subtile as [SubTileEntityInGame](SubTileEntityInGame.md) 自定义花的 TileEntity

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 自定义花所在的世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花的坐标

```zenscript
subTileEntityObj.onUpdate = function(subtile, world, pos) {

};
```

## onBlockHarvested

当自定义花被挖掘完时调用

### 导包

```zenscript
import mods.randomtweaker.cote.BlockHarvested;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 自定义花所在的世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花的坐标

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) 自定义花的方块状态

* player
  as [ICTPlayer](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  挖掘自定义花的玩家

```zenscript
subTileEntityObj.onBlockHarvested = function(world, pos, state, player) {

};
```

## onBlockActivated

当玩家右键自定义花时调用

需要返回一个 bool

### 导包

```zenscript
import mods.randomtweaker.cote.BlockActivated;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 自定义花所在的世界

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花的坐标

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) 自定义花的方块状态

* player
  as [ICTPlayer](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  右键自定义花的玩家

* hand as [Hand](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/Hand/)
  右键自定义花的玩家的手

* side as [IFacing](https://docs.blamejared.com/1.12/en/Vanilla/World/IFacing/) 玩家的方向

* hitX as float 玩家跟自定义花的相对坐标

* hitY as float 玩家跟自定义花的相对坐标

* hitZ as float 玩家跟自定义花的相对坐标

```zenscript
subTileEntityObj.onBlockActivated = function(world, pos, state, player, hand, side, hitX, hitY, hitZ) {
    if(<botania:twigwand>.matches(player.getHeldItem(hand))) {
        return false;
    }
    return true;
};
```

## canGeneratePassively

自定义花是否被动产能 (仅 [SubTileGenerating](SubTileGenerating.md) 类具有此函数)

### 导包

```zenscript
import mods.randomtweaker.cote.CanGeneratePassively;
```

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) 自定义花的坐标

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) 自定义花所在的世界

```zenscript
subTileGeneratingObj.canGeneratePassively = function(pos, world) {

};
```

## populateDropStackNBTs

决定挖掘完自定义花的掉落物 (仅 [SubTileGenerating](SubTileGenerating.md)) 类具有此函数)

### 导包

```zenscript
import mods.randomtweaker.cote.PopulateDropStackNBTs;
```

* drops as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 掉落物列表

```zenscript
subTileGeneratingObj.populateDropStackNBTs = function(drops) {

};
```
