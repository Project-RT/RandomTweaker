# SubTileGenerating

The `SubTileGenerating` class extends [SubTileEntity](SubTileEntity.md) class, that means all the
functions available in the `SubTileEntity` class can be used by the `SubTileGenerating` class.

## Import

```zenscript
import mods.randomtweaker.cote.SubTileGenerating;
```

## ZenProperty

See [SubTileEntity](SubTileEntity.md)

| Feild | Type | Description |
| :---- | :--- | :----- |
| PassiveFlower | bool | Whether it is a passive generation flower |
| valueForPassiveGeneration | int | How many amount of mana each time the mana produced|
| delayBetweenPassiveGeneration | int | Cooldown time after each time the mana produced (Unit : Tick) |
| shouldSyncPassiveGeneration | bool | Whether or not to sync TileEntity when passively producing mana |

## ZenMethod

| Method | Type | Description |
|:---- |:--- |----- |
| register() | void | Register this flower |

## Example

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileGenerating;

var subTileGenerating as SubTileGenerating = VanillaFactory.createSubTileGenerating("test", 0xFFFFFF);
subTileGenerating.register();
```
