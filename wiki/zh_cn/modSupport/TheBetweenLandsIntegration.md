# TheBetweenLands Integration

这是朋友需要的一个功能, 我也只是调用其提供的 API, 如果你想使用这些方法请自行尝试或查询源 API 提供的 JavaDoc

## CircleGem Methods

可选 gemType : `aqua`， `crimson`， `green` ，`none`

可选 combatType : `OFFENSIVE`， `DEFENSIVE`， `BOTH`

导包：

~~~zenscript
import mods.randomtweaker.BLCircleGem;
~~~

| 方法                                                      | 返回值 |
| :-------------------------------------------------------- | :----- |
| getGem(IItemStack stack)                                  | void   |
| setGem(IItemStack stack, String gemType)                  | String |
| addGem(IEntity entity, String gemType, String combatType) | void   |