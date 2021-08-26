# IItemStack Expansion

扩展 `IItemStack` 类所以 `IItemStack` 对象可以使用以下方法

| 方法 | 返回类型 |
| :---------------- | :---------------- |
| getTagSize() | int |
| static addItemDs(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), damagesource as [IDamageSource](https://docs.blamejared.com/1.12/en/Vanilla/Damage/IDamageSource/)) | bool |
| static removeItemDs(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), damagesource as [IDamageSource](https://docs.blamejared.com/1.12/en/Vanilla/Damage/IDamageSource/)) | bool |

ItemDs 允许你操控设定的物品为物品实体时是否允许被特定的伤害摧毁

## TheBetweenLands

当加载了 `TheBetweenLands`  Mod 时

| 方法 | 返回类型 |
| :---------------- | :---------------- |
| getModifier() | float |
| getCoatingStage() | int |
| getCorrosionStage() | int |
| addCorrosionPropertyOverrides() | void |
| getDestroySpeed(normalStrength as float, blockState as [IBlockState](https://docs.blamejared.com/1.12/en/Vanilla/Blocks/IBlockState/)) | float |
| addCorrosionTooltips(lines as string[], advancedItemTooltips as bool) | void |
| static shouldCauseBlockBreakReset(oldStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), newStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | bool |
| static shouldCauseReequipAnimation(oldStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), newStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), slotChanged as bool) | bool |
| static areItemStackTagsEqual(oldStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), newStack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | bool |

**带有 static 修饰符的需要类调用** (e.g. `IItemStack.shouldCauseBlockBreakReset(itemOne, itemTwo);`)
