# TheBetweenLands Integration
这是朋友需要的一个功能，我也只是调用其提供的API，如果你想用这些方法请自行尝试或查询源API提供的JavaDoc
## CircleGem Methods

导包：

~~~zenscript
import mods.randomtweaker.BLCircleGem;
~~~

| 方法                                                      | 返回值        |
| :-------------------------------------------------------- | :------------ |
| getGem(IItemStack stack)                                  | void          |
| setGem(IItemStack stack, String gemType)                  | String        |
| addGem(IEntity entity, String gemType, String combatType) | void          |
| getCircleGemType(String gemType)                          | CircleGemType |
| getCombatType(String combatType)                          | CombatType    |

## IItemStack Expansion

导包：

```zenscript
import crafttweaker.player.IPlayer;
```

| 方法                                                         | 返回值  |
| :----------------------------------------------------------- | :------ |
| getModifier()                                                | float   |
| getDestroySpeed(float normalStrength, IBlockState blockState) | float   |
| addCorrosionTooltips(String[] lines, boolean advancedItemTooltips) | void    |
| getCoatingStage()                                            | int     |
| getCorrosionStage()                                          | int     |
| addCorrosionPropertyOverrides()                              | void    |
| Static shouldCauseBlockBreakReset(IItemStack oldStack, IItemStack newStack) | boolean |
| Static shouldCauseReequipAnimation(IItemStack oldStack, IItemStack newStack, boolean slotChanged) | boolean |
| Static areItemStackTagsEqual(IItemStack oldStack, IItemStack newStack) | boolean |

## IPlayer Expansion

导包

```zenscript
import crafttweaker.player.IPlayer;
```

| 方法                                                         | 返回值  |
| :----------------------------------------------------------- | :------ |
| isCapBeNull()                                                | boolean |
| addStats(int decay, float saturationModifier)                | void    |
| addCorrosionTooltips(String[] lines, boolean advancedItemTooltips) | void    |
| getDecayLevel()                                              | int     |
| getPrevDecayLevel()                                          | int     |
| addDecayAcceleration(float acceleration)                     | void    |
| getSaturationLevel()                                         | float   |
| getAccelerationLevel()                                       | float   |
| setDecayLevel(int decay)                                     | void    |
| setDecaySaturationLevel(float saturation)                    | void    |
