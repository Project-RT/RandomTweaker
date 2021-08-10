# SubTileGenerating

The `SubTileGenerating`
<<<<<<< HEAD
class extends [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
=======
class extends [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
>>>>>>> master
class, that means all the functions available in the `SubTileEntity` class can be used by the `SubTileGenerating` class.

## Import

```zenscript
import mods.randomtweaker.cote.SubTileGenerating;
```

## ZenProperty

<<<<<<< HEAD
See [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
=======
See [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
>>>>>>> master

| Deild | Type | Description |
|:---- |:--- |----- |
| PassiveFlower | bool | Whether it is a passive generation flower |
<<<<<<< HEAD
| valueForPassiveGeneration | int | How many amount of mana each time the mana produced|
=======
| valueForPassiveGeneration | int | 阿巴阿巴 |

Translated with www.DeepL.com/Translator (free version) |
>>>>>>> master
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
