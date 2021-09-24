# ElvenTradeEvent

每当精灵门交易时触发此事件

取消事件会导致交易失败

## Import

```zenscript
import mods.randomtweaker.botania.ElvenTradeEvent;
```

## Implementing IEventCancelable

此事件实现了 [IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/)
, 所以他们的 `methods` `getters` `setters` 都可以被调用

## Getter

| Getter | Return Type | Description |
| :---- | :---- | :---- |
| alfPortal | [AlfPortalTileInGame](AlfPortalTileInGame.md) | 精灵门的 TileEntity |
| input | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 触发交易的物品 |
| output | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 交易的物品 |

## Setter

| Setter | Return Type | Description |
| :---- | :---- | :---- |
| output | void | 设置交易的物品 |

## Methods

| Method | Return Type | Description |
| :---- | :---- | :---- |
| setOutput([IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 设置交易的物品 |
| addOutput([IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 增加交易的物品 |

## Example

**这只是示例, 并不是一定要写到事件上!**

```zenscript
import mods.randomtweaker.botania.ElvenTradeEvent;

events.onElvenTrade(function(event as ElvenTradeEvent) {
    if(!event.alfPortal.world.remote) {
        event.cancel();
    }
});
```
