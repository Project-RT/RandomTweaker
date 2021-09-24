# AlfPortalDroppedEvent

每当物品掉落进精灵门时触发

取消此事件会重新生成进入精灵门的物品 (前提 output 返回为 null, 否则重新生成 output 里的内容), 同时也不会进行植魔原有的合成判定

## 导包

```zenscript
import mods.randomtweaker.botania.AlfPortalDroppedEvent;
```

## 实现 IEventCancelable

此事件实现了 [IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/)
, 所以他们的 `methods` `getters` `setters` 都可以被调用

## Getter

| Getter | 返回类型 | 描述 |
| :------- | :------- | :------- |
| alfPortal | [AlfPortalTileInGame](AlfPortalTileInGame.md) | 精灵门核心的 TileEntity |
| input | [IEntityItem](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityItem/) | 进入精灵门的物品 |
| output | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) |  获取事件取消后的输出物 (如果没有设置则返回 null) |
| isDead | bool | 进入精灵门的物品是否消失 |

## Setter

| Setter | 描述 |
| :------- | :------- |
| isDead | 设置进入精灵门的物品是否消失 |

## Method

| Method | 描述 |
| :------- | :------- |
| setOutput(output as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | 设置取消事件后的输出物 |
| setDead(dead as bool) | 设置进入精灵门的物品是否消失 |

## 示例

**这只是示例, 并不是一定要写到事件上!**

```zenscript
import crafttweaker.item.IItemStack;
import mods.randomtweaker.botania.AlfPortalDroppedEvent;

events.onAlfPortalDropped(function(event as AlfPortalDroppedEvent) {
    if(!event.alfPortal.world.remote) {
        event.setOutput([<minecraft:iron_ingot>] as IItemStack[]);
    }
    event.cancel();
});
```
