# Potion

Enables ContentTweaker to create simple potion effects

## Import

```zenscrtip
import mods.randomtweaker.cote.Potion;
```

| Feild | Type| Description | | ---- | :-- | --- | | unlocalizedName | string | Unlocalized name | |
liquidColorIn | int | Color of potion | | badEffectIn | bool | Is the potion giving a debuff | |
beneficial | bool | Whether the potion is beneficial to the player or not, beneficial potions will
be placed in the first row | | instant | bool | Is the potion effective instantly or continuously? (
true for instantly, false for continuously)| | shouldRender | bool | Whether to render in the
backpack | | shouldRenderHUD | bool | Whether to render in the HUD (in the upper right corner) |

Texture location : `contenttweaker:textures/gui/unlocalizedName.png`  
**The texture must be 18 * 18 pixels size**  
~~Don't fill in unlocalizedName foolishly XD~~

## Hot reload

Please install `ZenUtils` Mod

Both [Event hot reload](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
and [ContentTweaker function hot reload](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) are provided by this mod

```zenscript
<cotPotion:unlocalizedName>.isReady = function(duration, amplifier){
	if (duration % 40 == 0){
		return true;
	}
	return false;
};
```

## Example

```zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Potion;
import mods.contenttweaker.Player;

var potion as Potion = VanillaFactory.createPotion("lhhd", 0xF7D575);
potion.isReady = function(duration, amplifier){
	if (duration % 20 == 0){
		return true;
	}
	return false;
};
potion.performEffect = function(living, amplifier){
 	if(!living.world.remote && living instanceof Player){
		var player as Player = living;
		player.sendChat("didiidid~~~");
	}
};
potion.register();
```
