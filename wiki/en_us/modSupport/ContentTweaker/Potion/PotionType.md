# PotionType (e.g. : Potion Bottle, Potion Arrow)

Enables ContentTweaker to create potions like different types of potion bottles

## Import

```zenscript
import mods.randomtweaker.cote.PotionType;
```

## Feild

| Feild | Type | Description |
| :---- | :---- | :---- |
| unlocalizedName | string | Unlocalized name |
| duration | int | Duration (Unit : Tick, Default : 3600) |
| amplifier | int | Potion level (default 0) |
| potion | [Potion](Potion.md) | Specified potion |

## Methods

| Method | Description |
| :---- | :---- |
| register() | Register this potiontype |

## Example

```zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.PotionType;

VanillaFactory.createPotionType("lhhdOne", potion).register();

var Two as PotionType = VanillaFactory.createPotionType("lhhdTwo", potion);
Two.setAmplifier(9600);
Two.register();

var Three as PotionType = VanillaFactory.createPotionType("lhhdThree", potion);
Three.setDuration(1800);
Three.setAmplifier(1);
Three.register();
```
