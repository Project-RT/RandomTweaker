# ElvenTradeEvent

每当精灵门交易时触发此事件

取消事件会导致交易失败

## 导包

```zenscript
import mods.randomtweaker.botania.ElvenTradeEvent;
```

## 实现 IEventCancelable

此事件实现了 [IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/)
, 所以他们的 `methods` `getters` `setters` 都可以被调用

## Getter

| Getter | 返回类型 | 描述 |
| :---- | :---- | :---- |
| alfPortal | [AlfPortalTileInGame](AlfPortalTileInGame.md) | 精灵门的 TileEntity |
| input | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 触发交易的物品 |
| output | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 交易的物品 |

## Setter

| Setter | 返回类型 | 描述 |
| :---- | :---- | :---- |
| output | void | 设置交易的物品 |

## Method

| Method | 返回类型 | 描述 |
| :---- | :---- | :---- |
| setOutput([IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 设置交易的物品 |
| addOutput([IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 增加交易的物品 |

## 示例

**这只是示例, 并不是一定要写到事件上!**

```zenscript
import mods.randomtweaker.botania.ElvenTradeEvent;

events.onElvenTrade(function(event as ElvenTradeEvent) {
    event.cancel();
});
```
