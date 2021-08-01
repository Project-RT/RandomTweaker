# ManaBauble

When Botania and ContentTweaker are loaded at the same time, it allows ContentTweaker to create baubles with mana 
The `ManaBauble` class extends the [ManaItem](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/ManaItem/ManaItem.md) class, all available functions of `ManaItem` are also available for `ManaBauble`.

## Import

```zenscript
import mods.randomtweaker.cote.ManaBauble;
```

| Feild | Type | Description |
|:--- | --- | ---- |
| useMana | bool | This field has effect except for `RING` and `TRINKET` type bauble, also if the mana of the bauble is greater than 0 it will still return false |
| baubleType | string | Specify the type of the bauble (must be the same, default is `RING`), there are only `AMULET`, `RING`, `BELT`, `TRINKET`, `HEAD`, `BODY`, `CHARM` available.|

## Hot reload

Please install `ZenUtils` Mod

See [LateSetCoTFunction](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) for more information.

```zenscript
#loader crafttweaker reloadableevents
<cotItem:unlocalizedName>.onWornTick = function((bauble, wearer) {

};
```

## Method

| Method | Type | Description |
|:---- |:---- |---- |
| register() | void | Register this bauble|

## Example

```zenscript
#loader contenttweaker
import mods.randomtweaker.BaubleRenderHelper;
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaBauble;
import crafttweaker.player.IPlayer;

var manaBauble as ManaBauble = VanillaFactory.createManaBauble("test_1", 500000, "TRINKET");
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

item.contenttweaker.物品ID.name
