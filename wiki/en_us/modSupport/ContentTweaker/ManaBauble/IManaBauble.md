# IManaBauble

This class is only registered in CraftTweaker when both `Botania` and `CoT` are loaded.

The `IManaBauble` class extends the [IManaItem](../ManaItem/IManaItem.md) class, that means
the `IManaBauble` class can use all the functions available in the `IManaItem` class

## Import

```zenscript
import mods.randomtweaker.item.IManaBauble;
```

## Transform

You can use the `isIManaBauble()` method on an instance of
the [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) to determine if it
is an instance of the IManaBauble class, and if true, use the `asIManaBauble()` method to convert
it.

## Getter

| Getter | Return Type | Description |
| :----- | ---- | ----- |
| baubleType | string | Returns the typr of the bauble. |
