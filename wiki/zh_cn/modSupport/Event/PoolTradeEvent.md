# PoolTradeEvent

每当魔力池触发合成时触发

## 导包

```zenscript
import mods.randomtweaker.botania.PoolTradeEvent;
```

## 继承 IEventCancelable

此事件继承了 [IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/), 所以他们的 `methods` `getters` `setters` 都可以被调用

## Getter

| Getter | 返回类型 | 描述 | 有无同名 Setter |
| :---- | :---- | :---- | :----- |
| mana | int | 配方消耗的 mana | ✓ |
| output | [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 待输出的物品 | ✓ |
| allowExceed | bool | 当配方需求 mana 超过魔力池所有 mana 时是否允许合成 | ✓ |
| currentMana | int | 当前魔力池的 mana | × |
| input | [IEntityItem](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityItem/) | 触发事件的物品 | × |
| world | [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) | 魔力池所在的世界 | × |
| blockPos | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | 魔力池的坐标 | × |
| alchemy | bool | 底座是否是炼金催化器 | × |
| conjuration | bool | 底座是否是炼造催化器 | × |

## Methods

| Method | 返回类型 | 描述 |
| :---- | :---- | :---- |
| setMana(mana as int) | void | 设置配方所消耗的 mana |
| setOutput(output as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 设置待输出的物品 |
| setAllowExceed(allowExceed as bool) | void | 设置当配方需求 mana 超过魔力池所有 mana 时是否允许合成 |

## 实例

```zenscript
import mods.randomtweaker.botania.PoolTradeEvent;

events.onElvenTrade(function(event as ElvenTradeEvent) {
    if(!event.input.world.remote) {
        event.cancel();
    }
});
```
