# IItemStack Expansion

扩展 `IItemStack` 类所以 `IItemStack` 对象可以使用以下方法

| 方法                                                         | 返回值  |
| :----------------------------------------------------------- | :------ |
| getModifier()                                                | float   |
| getDestroySpeed(normalStrength as float, blockState as IBlockState) | float   |
| addCorrosionTooltips(String[] lines, boolean advancedItemTooltips) | void    |
| getCoatingStage()                                            | int     |
| getCorrosionStage()                                          | int     |
| addCorrosionPropertyOverrides()                              | void    |
| static shouldCauseBlockBreakReset(oldStack as IItemStack, newStack as IItemStack) | bool |
| static shouldCauseReequipAnimation(oldStack as IItemStack, newStack as IItemStack, slotChanged as bool) | bool |
| static areItemStackTagsEqual(oldStack as IItemStack, newStack as IItemStack) | bool |

**带有 static 修饰符的需要类调用** (e.g. `IItemStack.shouldCauseBlockBreakReset(itemOne, itemTwo);`)