# SubTileEntity

When both `BoT` and `CoT` are installed, `CoT` can be used to create custom Generating/Functional Flowers.

CraftTweaker can't get this class, only its subclasses

Remember to put the custom flower texture in the `resources/contenttweaker/textures/blocks` directory (Texture name : unlocalizedName.png)

This class mainly makes the code easy to maintain

To create generation flowers, please see [SubTileGenerating](SubTileGenerating.md)

To create functional flowers, please see [SubTileFunctional](SubTileFunctional.md)

## Import

```zenscript
import mods.randomtweaker.cote.SubTileEntity;
```

## ZenProperty

| Feild | Type | Description |
| :----- | :----- | :----- |
| unlocalizedName | string | Unlocalized name |
| range | int | Radius of work of the flower |
| color | int | Customize the color of flower's Mana bar |
| maxMana | int | Maximum Mana Capacity |
| acceptsRedstone | bool | Whether to accept the redstone signal |
| overgrowthAffected | bool | Whether it is influenced by the Enchanted Soil |

## Localization

`tile.botania:flower.Unlocalized name of custom flower.name` = Localization of custom flower

`tile.botania:flower.Unlocalized name of custom flower.reference` = Localization of custom flower's tooltip

## Hot reload

Please install `ZenUtils` Mod

Both [Event hot reload](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
and [ContentTweaker fuction hot reload](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction)
are provided by this mod

In the ContentTweaker script

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileGenerating;
import mods.randomtweaker.cote.SubTileFunctional;

var subTileGenerating as SubTileGenerating = VanillaFactory.createSubTileGenerating("test", 0xFFFFFF);
subTileGenerating.register();

// Even if it is not the same type of custom flower, the registration name cannot be the same!
// Nor can it be the same as the registration name of a custom flower that already exists in Botania or its extensions

var subTileFunctional as SubTileFunctional = VanillaFactory.createSubTileFunctional("test_1", 0xFFFFFF);
subTileFunctional.register();
```

In the CraftTweaker script

```zenscript
#loader crafttweaker reloadableevents
<cotSubTile:test>.onUpdate = function(subtile, world, pos) {
    if(!world.remote) {
        if(isNull(subtile.data.time))
            subtile.updateCustomData({time : 0});
        
        if(!isNull(subtile.data.time)) {
            subtile.updateCustomData({time : subtile.data.time.asInt() + 1});
        }
    }
};

<cotSubTile:test_1>.onUpdate = function(subtile, world, pos) {
    if(!world.remote) {
        if(isNull(subtile.data.time))
            subtile.updateCustomData({time : 0});
        
        if(!isNull(subtile.data.time)) {
            subtile.updateCustomData({time : subtile.data.time.asInt() + 1});
        }
    }
};
```
