# TheBetweenLands Integration

这是朋友需要的一个功能, 我也只是调用其提供的 API, 如果你想使用这些方法请自行尝试或查询源 API 提供的 JavaDoc

更多请看 [IPlayerExpansion](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/IPlayerExpansion.md)

## CircleGem Methods

可选 gemType : `aqua`， `crimson`， `green` ，`none`

可选 combatType : `OFFENSIVE`， `DEFENSIVE`， `BOTH`

导包：

~~~zenscript
import mods.randomtweaker.BLCircleGem;
~~~

| 方法                                                      | 返回值 |
| :-------------------------------------------------------- | :----- |
| getGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/))                                  | void   |
| setGem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), gemType as string)                  | string |
| addGem(entity as [IEntity](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntity/), gemType as string, combatType as string) | void   |