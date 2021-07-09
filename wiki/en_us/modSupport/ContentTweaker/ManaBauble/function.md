# ManaBauble 具有的函数

## 导包 (返回值不为 void 的函数导第二个包, 渲染的导第三个包)

```zenscript
import mods.randomtweaker.cote.BaubleFunction;
import mods.randomtweaker.cote.BaubleFunctionWithReturn;
import mods.mods.randomtweaker.cote.PlayerBaubleRender;
```

|函数 | 写法 | 返回值 | 描述 |
|:--- |:------- |---- | ------|
| onWornTick | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | void | 佩戴后每 Tick 调用
| canEquip | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | bool | 是否可以佩戴 |
| canUnEquip | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | bool | 是否取消佩戴 |
| onEquipped | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | void | 佩戴时调用 |
| onUnequipped | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | void | 未佩戴时调用 |
| willAutoSync | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | bool | 当饰品的 NBT 或 Damage 发生了改变, 饰品是否自动同步到客户端 (10 Tick 同步一次) |
| onPlayerBaubleRender | function(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/), renderType as string, partialTicks as float) | void | 请看下述 |

## onPlayerBaubleRender

此函数用于当饰品处于玩家的饰品栏时该如何渲染

目前只可进行简单的渲染,
具体方法请看 [BaubleRenderHelper](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/ManaBauble/BaubleRenderHelper.md)

此函数包含四个值

* stack 触发函数的物品
* player 触发函数的玩家
* renderType 有两个 string 分别是 `HEAD` 和 `BODY`
* partialTicks
