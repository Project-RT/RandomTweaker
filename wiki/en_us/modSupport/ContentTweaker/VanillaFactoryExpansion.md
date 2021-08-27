# VanillaFactory Expansion

## Import

```zenscript
import mods.mods.contenttweaker.VanillaFactory;
```

| Methods | Reture Type | Description |
| :------------------ | :------------------ | :------------------ |
| createPotion(unlocalizedName as string, color as int) | [Potion](Potion/Potion.md) | Create a Potion |
| createPotionType(unlocalizedName as string, potion as Potion) | [PotionType](Potion/PotionType.md) | Create a PotionType potion bottle belonging to this category |
| createManaItem(unlocalizedName as string, @Optional(500000) manxMana as int) | [ManaItem](ManaItem/ManaItem.md) | Create a ManaItem |
| createManaBauble(unlocalizedName as string, baubleType as string, @Optional(500000) manxMana as int) | [ManaBauble](ManaBauble/ManaBauble.md) | Create a ManaBauble |
| createManaUsingItem(unlocalizedName as string, @Optional(500000) manxMana as int) | [ManaUsingItem](ManaItem/ManaUsingItem.md) | Create a mana tool (An item that implements IManaUsingItem) |
| createSubTileGenerating(unlocalizedName, color as int) | [SubTileGenerating](SubTileEntity/SubTileGenerating.md) | Create a generation flower |
| createSubTileFunctional(unlocalizedName, color as int) | [SubTileFunctional](SubTileEntity/SubTileFunctional.md) | Create a functional flower |

~~Don't ask me why there are no examples~~

~~How do you create items with the original way (VanillaFactory), these are the same~~
