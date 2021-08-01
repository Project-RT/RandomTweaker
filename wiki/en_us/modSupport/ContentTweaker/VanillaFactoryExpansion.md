# VanillaFactory Expansion

## Import

```zenscript
import mods.mods.contenttweaker.VanillaFactory;
```

| Methods                                                           | Reture | Description |
| :------------------------------------------------------------ | :--------- | ---- |
| createPotion(unlocalizedName as string, color as int)         | [Potion](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/Potion.md) | Create a Potion |
| createPotionType(unlocalizedName as string, potion as Potion) | [PotionType](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/PotionType.md) | Create a PotionType potion bottle belonging to this category |
| createManaItem(unlocalizedName as string, @Optional(500000) manxMana as int) | [ManaItem](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/ManaItem.md) | Create a ManaItem |
| createManaBauble(unlocalizedName as string, @Optional(500000) manxMana as int, @Optional("RING") baubleType as string) | [ManaBauble](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/ManaBauble/ManaBauble.md) | Create a ManaBauble
| createSubTileGenerating(unlocalizedName, color as int) | [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileGenerating.md) | Create a generation flower |
| createSubTileFunctional(unlocalizedName, color as int) | [SubTileFunctional](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileFunctional.md) | Create a functional flower |

~~Don't ask me why there are no examples~~

~~How do you create items with the original way (VanillaFactory), these are the same~~