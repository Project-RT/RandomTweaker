# TheBetweenLands Integration

This is a function my friend needs, and I just call the API provided, if you want to use these
methods please try it yourself or check the JavaDoc provided by the source API.

For more please see [IPlayerExpansion](../IPlayerExpansion.md#thebetweenlands)

## Import

```zenscript
import mods.randomtweaker.tbl.BLCircleGem;
```

## CircleGem Methods

### Optional gemType

* aqua
* crimson
* green
* none

### Optional combatType

* OFFENSIVE
* DEFENSIVE
* BOTH

### Methods

| Method | Return Type |
| :--------------- | :--------------- |
| static getGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void |
| static setGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), gemType as string) | string |
| static addGem(entity as [IEntity](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntity/), gemType as string, combatType as string) | void |

**with static requires class call** (e.g. `BLCircleGem.getGem(<minecraft:iron_ingot>);`)
