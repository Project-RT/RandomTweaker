# IItemStack Expansion

Extending the `IItemStack` class so that the `IItemStack` object can use the following methods

| Method                                                       | Return |
| :----------------------------------------------------------- | :----- |
| getModifier()                                                | float  |
| getDestroySpeed(normalStrength as float, blockState as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | float  |
| addCorrosionTooltips(lines as string[], advancedItemTooltips as bool) | void   |
| getCoatingStage()                                            | int    |
| getCorrosionStage()                                          | int    |
| addCorrosionPropertyOverrides()                              | void   |
| static shouldCauseBlockBreakReset(oldStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), newStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | bool   |
| static shouldCauseReequipAnimation(oldStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), newStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), slotChanged as bool) | bool   |
| static areItemStackTagsEqual(oldStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), newStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | bool   |

**with static requires class call** (e.g. `IItemStack.shouldCauseBlockBreakReset(itemOne, itemTwo);`)

