# SubTileFunctional

Because the `SubTileFunctional`
class extends [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
class, all the functions available in the `SubTileEntity` class can be used by the `SubTileFunctional` class.

If you have a mini functional flower, remember to store a separate texture for the small functional flower in the `resources/contenttweaker/textures/blocks` directory (texture name : unlocalizedName + chibi.png)

## Import

```zenscript
import mods.randomtweaker.cote.SubTileFunctional;
```

## ZenProperty

See [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)

| Feild | Type | Description |
|:---- |:--- |----- |
| hasMini | bool | Whether to create mini functional flowers |
| miniRange | int | Range of work for mini functional flowers |

## ZenMethod

| Method | Type | Description |
|:---- |:--- |----- |
| register() | void | Register this flower |

## Example

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileFunctional;

var subTileFunctional as SubTileFunctional = VanillaFactory.createSubTileFunctional("test_1", 0xFFFFFF);
subTileFunctional.register();
```
