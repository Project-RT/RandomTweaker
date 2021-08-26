# TheBetweenLands Integration

这是朋友需要的一个功能, 我也只是调用其提供的 API, 如果你想使用这些方法请自行尝试或查询源 API 提供的 JavaDoc

更多请看 [IPlayerExpansion](../IPlayerExpansion.md#thebetweenlands)

## 导包

```zenscript
import mods.randomtweaker.tbl.BLCircleGem;
```

## CircleGem Methods

### 可选 gemType

* aqua
* crimson
* green
* none

### 可选 combatType

* OFFENSIVE
* DEFENSIVE
* BOTH

### 方法

| 方法 | 返回类型 |
| :--------------- | :--------------- |
| static getGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void |
| static setGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), gemType as string) | string |
| static addGem(entity as [IEntity](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntity/), gemType as string, combatType as string) | void |

**带有 static 修饰符的需要类调用** (e.g. `BLCircleGem.getGem(<minecraft:iron_ingot>);`)
