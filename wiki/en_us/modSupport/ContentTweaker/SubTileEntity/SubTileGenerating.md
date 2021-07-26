# SubTileGenerating

Because the `SubTileGenerating`
class extends [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
class, all the functions available in the `SubTileEntity` class can be used by the `SubTileGenerating` class.

## Import

```zenscript
import mods.randomtweaker.cote.SubTileGenerating;
```

## ZenProperty

See [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)

| Deild | Type | Description |
|:---- |:--- |----- |
| PassiveFlower | bool | Whether it is a passive flower |
| valueForPassiveGeneration | int | How much mana is produced per Tick when the flower is a passive flower |
| delayBetweenPassiveGeneration | int | Cooldown time after each time mana produced when the flower is a passive flower (Unit : Tick) |
| shouldSyncPassiveGeneration | bool | Whether or not to sync TileEntity when passively producing mna (only for passive flowers) |

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
