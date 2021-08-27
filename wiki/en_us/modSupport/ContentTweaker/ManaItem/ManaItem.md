# ManaItem

Enables ContentTweaker to create items with Mana when Botania and ContentTweaker are loaded at the
same time, The `ManaItem` class extends
the [Item](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Creatable_Content/Item/)
class, that means all the functions available in the `Item` class can also be be used on
the `ManaItem` class

## Import

```zenscrtpt
import mods.randomtweaker.cote.ManaItem;
```

## Feild

| Feild | Type | Description |
| :--------- | :--------- | :--------- |
| unlocalizedName | string | Unlocalized name |
| maxMana | int (Default: 5w) | Max mana capacity |
| isNoExport | bool (Default: false) | Does it really output mana |
| hasFull | bool (Default: false) | Whether to create mana items full with mana |
| hasCreative | bool (Default: false) | Whether to create Creative item(similar to Creative Mana Tablets) |

## Methods

| Method | Description |
| :------ | :------ |
| register() | Register this item |

## Hot reload

Please install `ZenUtils` Mod

See [LateSetCoTFunction](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) for more information.

```zenscript
#loader crafttweaker reloadableevents
<cotItem:unlocalizedName>.canExportManaToItem = function(stack, otherStack) {
    return true;
};
```

## Example

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaItem;

var manaItem as ManaItem = VanillaFactory.createManaItem("mana_item", 50000);
manaItem.register();
```

## Localization

item.contenttweaker.ItemID.name
