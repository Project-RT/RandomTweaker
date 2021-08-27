# Function

## isReady

Determines whether the current Tick triggers the `performEffect` function

### Import

```zenscript
import mods.randomtweaker.cotx.PotionIsReady;
```

* duration as int Potion's duration

* amplifier as int Potion's amplifier

```zenscript
potionObj.isReady = function(duration, amplifier) {
	if (duration % 20 == 0) {
		return true;
	}
	return false;
};
```

## performEffect

This function is called every Tick

### Import

```zenscript
import mods.randomtweaker.cotx.PotionPerformEffect;
```

* living as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/) IEntityLivingBase with this potion's effect

* amplifier as int Potion's amplifier

```zenscript
potionObj.performEffect = function(living, amplifier) {
 	if(!living.world.remote && living instanceof Player) {
		var player as Player = living;
		player.sendChat("didiidid~~~");
	}
};
```
## affectEntity

The function is triggered only when the `instant` of `potion` is `true`

### 导包

```zenscript
// This is not a error.
import mods.randomtweaker.cotx.PotionPerformEffect; 
```

* living as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/) IEntityLivingBase with this potion's effect

* amplifier as int Potion's amplifier

```zenscript
potionObj.affectEntity = function(living, amplifier) {
 	if(!living.world.remote && living instanceof Player) {
		var player as Player = living;
		player.sendChat("didiidid~~~");
	}
};
```