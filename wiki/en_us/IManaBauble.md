# IManaBauble

This class is only registered in CraftTweaker when both `Botania` and `CoT` are loaded.

Because the `IManaBauble` class extends the [IManaItem](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/IManaItem.md) class, the `IManaBauble` class can use all the functions available in the `IManaItem` class

## Import

```zenscript
import mods.randomtweaker.item.IManaBauble;
```

You can use the `isIManaBauble()` method on an instance of the [IMutableItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IMutableItemStack/)
class using the `isIManaBauble()` method to determine if it is an instance of the IManaBauble class, and if true, use the `asIManaBauble()` method to convert it.

| Getter | Return | Description |
| :----- | ---- | ----- |
| baubleType | string | Returns the typr of the bauble. |
| isUseMana | bool | Whether the baubles uses Mana (both types `RING` and `TRINKET` return false in any case)
