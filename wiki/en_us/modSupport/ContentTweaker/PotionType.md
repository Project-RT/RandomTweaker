# PotionType (e.g. : Potion Bottle, Potion Arrow)

Enables ContentTweaker to create potions like different potion bottles

## Import

```zenscript
import mods.randomtweaker.cote.PotionType;
```

| Feild | Type| Description |
| ---- | :----- | ---- |
| unlocalizedName | string | Unlocalized name |
| duration | int | Duration (Unit : Tick, Default : 3600) |
| amplifier | int | Potion level (default 0) |
| potion | [Potion](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/Potion.md) | Specified potion |

## Example

~~~zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.PotionType;

VanillaFactory.cretePotionType("lhhdOne", potion).register();

var Two as PotionType = VanillaFactory.cretePotionType("lhhdTwo", potion);
Two.setAmplifier(9600);
Two.register();

var Three as PotionType = VanillaFactory.cretePotionType("lhhdThree", potion);
Three.setDuration(1800);
Three.setAmplifier(1);
Three.register();
~~~
