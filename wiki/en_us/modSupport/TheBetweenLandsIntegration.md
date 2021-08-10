# TheBetweenLands Integration

This is a function my friend needs, and I just call the API provided, if you want to use these methods please try it yourself or check the JavaDoc provided by the source API.

For more please see [IPlayerExpansion](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/en_us/IPlayerExpansion.md)

## CircleGem Methods

Optional gemType : `aqua`， `crimson`， `green` ，`none`

Optional combatType : `OFFENSIVE`， `DEFENSIVE`， `BOTH`

Import：

```zenscript
import mods.randomtweaker.tbl.BLCircleGem;
```

| Method                                                       | Return |
| :----------------------------------------------------------- | :----- |
| getGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void   |
| setGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), gemType as string) | string |
| addGem(entity as [IEntity](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntity/), gemType as string, combatType as string) | void   |
