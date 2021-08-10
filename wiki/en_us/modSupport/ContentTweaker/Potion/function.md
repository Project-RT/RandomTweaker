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

* living as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/) 具有此药水效果的有生命实体

* amplifier as int Potion's amplifier

```zenscript
potionObj.performEffect = function(living, amplifier) {
 	if(!living.world.remote && living instanceof Player) {
		var player as Player = living;
		player.sendChat("didiidid~~~");
	}
};
```