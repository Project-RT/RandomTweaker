# Function

## onBlockAdded

Called when the generation flowers are added to the world

### Import

```zenscript
import mods.randomtweaker.cote.BlockAdded;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world of the flower

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) The blockstate of the flower

```zenscript
subTileEntityObj.onBlockAdded = function(world, pos, state) {

};
```

## canSelect

Can the Wand of the Forest select this flower and bind it to a block

Need to return a bool

### Import

```zenscript
import mods.randomtweaker.cote.CanSelect;
```

* player
  as [ICTPlayer](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  Player

* wand as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Wand held by the player

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

* side as [IFacing](https://docs.blamejared.com/1.12/en/Vanilla/World/IFacing/) The direction the flower faces you

```zenscript
subTileEntityObj.canSelect = function(player, wand, pos, side) {
    return true;
};
```

## onBlockPlaceBy

Called when the generation flowers are placed to the world

### Import

```zenscript
import mods.randomtweaker.cote.BlockPlacedBy;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world of the flower

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) The blockstate of the flower

* entity
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  The entity who placed the flower

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Item on hand (
  the placed flower)

```zenscript
subTileEntityObj.onBlockPlaceBy = function(world, pos, state, entity, stack) {

};
```

## onUpdate

Called every tick

### Import

```zenscript
import mods.randomtweaker.cote.Update;
```

* subtile
<<<<<<< HEAD
  as [SubTileEntityInGame](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/ContentTweaker/SubTileGenerating/SubTileEntityInGame.md)
=======
  as [SubTileEntityInGame](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileGenerating/SubTileEntityInGame.md)
>>>>>>> master
  The TileEntity of the flower

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world of the flower

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

```zenscript
subTileEntityObj.onUpdate = function(subtile, world, pos) {

};
```

## onBlockHarvested

Called when the generation flowers are harvested

### Import

```zenscript
import mods.randomtweaker.cote.BlockHarvested;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world of the flower

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) The blockstate of the flower

* player
  as [ICTPlayer](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  The player harvesting the flower

```zenscript
subTileEntityObj.onBlockHarvested = function(world, pos, state, player) {

};
```

## onBlockActivated

Called when a player right-clicks a mana-producing flower

Need to return a bool

### Import

```zenscript
import mods.randomtweaker.cote.BlockActivated;
```

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world of the flower

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

* state as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockState/) The blockstate of the flower

* player
  as [ICTPlayer](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/ICTPlayer/)
  The player who right clicks flower

* hand as [Hand](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Player/Hand/)
  Which hand the player uses when clicking the flower

* side as [IFacing](https://docs.blamejared.com/1.12/en/Vanilla/World/IFacing/) Direction of the player

* hitX as float Relative coordinates of the player and the flower

* hitY as float Relative coordinates of the player and the flower

* hitZ as float Relative coordinates of the player and the flower

```zenscript
subTileEntityObj.onBlockActivated = function(world, pos, state, player, hand, side, hitX, hitY, hitZ) {
    return true;
};
```

## canGeneratePassively

<<<<<<< HEAD
Is the flower a passive generation flower ((Only the [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileGenerating.md)
=======
Is the flower a passive generation flower ((Only the [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileGenerating.md)
>>>>>>> master
object has this function)

### Import

```zenscript
import mods.randomtweaker.cote.CanGeneratePassively;
```

* pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) The pos of the flower

* world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) The world of the flower

```zenscript
subTileGeneratingObj.canGeneratePassively = function(pos, world) {

};
```

## populateDropStackNBTs

<<<<<<< HEAD
Decide the drop after harvested flowers (Only the [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileGenerating.md)
=======
Decide the drop after harvested flowers (Only the [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileGenerating.md)
>>>>>>> master
class has this function)

### Import

```zenscript
import mods.randomtweaker.cote.PopulateDropStackNBTs;
```

* drops as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) List of drops
```zenscript
subTileGeneratingObj.populateDropStackNBTs = function(drops) {

};
```
