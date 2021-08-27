# SubTileFunctional

The `SubTileFunctional` class extends [SubTileEntity](SubTileEntity.md) class, that means all the
functions available in the `SubTileEntity` class can be used by the `SubTileFunctional` class.

If there is a mini functional flower, remember to put a separate texture for the small functional
flower in the `resources contenttweaker/textures/blocks` directory (texture name : `unlocalizedName`
+ _chibi.png)

## Import

```zenscript
import mods.randomtweaker.cote.SubTileFunctional;
```

## ZenProperty

See [SubTileEntity](SubTileEntity.md)

| Feild | Type | Description |
| :---- | :---- | :---- |
| hasMini | bool | Whether to create mini functional flowers |
| miniRange | int | Radius of work for mini functional flowers |

## ZenMethod

| Method | Description |
| :----- | :----- |
| register() | Register this flower |

## Example

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileFunctional;

var subTileFunctional as SubTileFunctional = VanillaFactory.createSubTileFunctional("test_1", 0xFFFFFF);
subTileFunctional.register();
```
