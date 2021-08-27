# ManaBauble

When Botania and ContentTweaker are loaded at the same time, it allows ContentTweaker to create
baubles with mana. The `ManaBauble` class extends the [ManaItem](../ManaItem/ManaItem.md) class, so
all available functions of `ManaItem` are also available for `ManaBauble`.

## Import

```zenscript
import mods.randomtweaker.cote.ManaBauble;
```

## Feild

| Feild | Type | Description |
| :---- | :---- | :---- |
| baubleType | string | Specify the type of the bauble (must be the same, default is `TRINKET`), there are only `AMULET`, `RING`, `BELT`, `TRINKET`, `HEAD`, `BODY`, `CHARM` available. |

## Methods

| Method | Description |
| :---- | :---- |
| register() | Register this Mana Bauble |

## Hot reload

Please install `ZenUtils` Mod

See [LateSetCoTFunction](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) for more information.

```zenscript
#loader crafttweaker reloadableevents
import crafttweaker.player.IPlayer;

<cotItem:unlocalizedName>.onWornTick = function(bauble, wearer) {
   if(wearer instanceof IPlayer) {
        var player as IPlayer = wearer;
        player.sendChat("1");
    }
};
```

## Example

```zenscript
#loader contenttweaker
import mods.randomtweaker.BaubleRenderHelper;
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaBauble;
import crafttweaker.player.IPlayer;

var manaBauble as ManaBauble = VanillaFactory.createManaBauble("test", "TRINKET", 500000);
manaBauble.onWornTick = function(bauble, wearer) {
   if(wearer instanceof IPlayer) {
        var player as IPlayer = wearer;
        player.sendChat("1");
    }
};
manaBauble.onPlayerBaubleRender = function(stack, player, renderType, partialTicks) {
    BaubleRenderHelper.bindTexture();
    if(renderType == "HEAD") {
        BaubleRenderHelper.translateToHeadLevel(player);
        BaubleRenderHelper.translateToFace();
        BaubleRenderHelper.defaultTransforms();
        BaubleRenderHelper.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        BaubleRenderHelper.scale(1.5, 1.5, 1);
        BaubleRenderHelper.translate(0, -0.05, 0);
        BaubleRenderHelper.renderItem(stack);
    }
};
manaBauble.register();
```

## 本地化

item.contenttweaker.itemID.name
