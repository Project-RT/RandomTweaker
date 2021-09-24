# ManaItemHandler

提供一些提取背包中魔力, 提供魔力的方法

## Import

```zenscript
import mods.randomtweaker.botania.ManaItemHandler;
```

## Methods

### 都是静态方法, 意味着可以类调用

#### e.g ManaItemHandler.getManaItems(playerObj);

| Method | Return Type | Description |
| :---- | :---- | :---- |
| getManaItems(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 获取玩家背包中所有的魔力物品 (实现植魔 `IManaItem` 接口的物品) |
| getManaBaubles(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)[int] | 获取玩家饰品栏内的所有的魔力饰品 (实现植魔 `IManaItem` 接口的饰品, int 的值为饰品所在的格子数) |
| getFullDiscountForTools(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), tool as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | float | 返回魔力减免程度, tool 可以为 null |
| requestMana(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), manaToGet as int, remove as bool) | int | 提取玩家背包或饰品栏内可以提供魔力的物品的魔力, `stack` 为提取魔力的物品, `player` 为提取魔力的玩家, `manaToGet` 为提取魔力的数量, remove 为是否模拟提取 |
| requestManaForTool(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), manaToGet as int, remove as bool) | int | 参数功能上同, 但是会 `manaToGet` 的值计算魔力减免 |
| requestManaExact(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), manaToGet as int, remove as bool) | bool | 功能参数与 `requestMana` 方法相同, 但需要提供魔力的物品所具有的魔力大于 `manaToGet` 的值, 返回是否提取成功 |
| requestManaExactForTool(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), manaToGet as int, remove as bool) | bool | 功能参数与 `requestManaForTool` 方法相同, 但需要提供魔力的物品所具有的魔力大于 `manaToGet` 计算魔力减免后的值, 返回是否提取成功 |
| dispatchMana(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), manaToSend as int, add as bool) | int | 功能与 `requestMana` 相反, add 为是否模拟输出魔力 |
| dispatchManaExact(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), manaToSend as int, add as bool) | bool | 功能参数与 `dispatchMana` 方法相同, 但需要可容纳魔力的物品大于 `manaToSend` 的值, 返回是否输出成功 |
