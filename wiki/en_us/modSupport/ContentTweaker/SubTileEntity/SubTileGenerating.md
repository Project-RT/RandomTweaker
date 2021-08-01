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
| valueForPassiveGeneration | int | How much mana is passively produced per Tick (affected by the `canGeneratePassively` function, this function returns true before the flower will passively produce mana based on the value of this field, just to mention one more thing, Botania has already rubbed the mana wheel for you, there is no need to write the mana wheel again in the `onUpdate` function, of course, special needs are not included.

Translated with www.DeepL.com/Translator (free version) |
| delayBetweenPassiveGeneration | int | Cooldown time after each time mana produced (Unit : Tick) |
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
