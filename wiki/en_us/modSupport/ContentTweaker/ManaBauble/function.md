# Function

## 导包 (返回值不为 void 的函数导第二个包, 渲染的导第三个包)

```zenscript
import mods.randomtweaker.cote.BaubleFunction;
import mods.randomtweaker.cote.BaubleFunctionWithReturn;
import mods.randomtweaker.cote.PlayerBaubleRender;
```

## onWornTick

佩戴饰品后每 Tick 都调用

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 当前饰品

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  穿戴者

```zenscript
manaBaubleObj.onWornTick = function((bauble, wearer) {

};
```

## canEquip

决定饰品是否可以穿戴上

需要返回一个 bool

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 当前饰品

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  穿戴者

```zenscript
manaBaubleObj.canEquip = function((bauble, wearer) {
    return true;
};
```

## canUnEquip

决定饰品饰品是否可以取消穿戴

需要返回一个 bool

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 当前饰品

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  穿戴者

```zenscript
manaBaubleObj.canUnEquip = function((bauble, wearer) {
    return true;
};
```

## onEquipped

当玩家佩戴饰品时调用

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 当前饰品

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  穿戴者

```zenscript
manaBaubleObj.onEquipped = function((bauble, wearer) {
    
};
```

## onUnequipped

当玩家未佩戴饰品时调用

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 当前饰品

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  穿戴者

```zenscript
manaBaubleObj.onUnequipped = function((bauble, wearer) {
    
};
```

## willAutoSync

当饰品的 NBT 或 Damage 发生了改变, 饰品是否自动同步到客户端 (10 Tick 同步一次)

需要返回一个 bool

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 当前饰品

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  穿戴者

```zenscript
manaBaubleObj.willAutoSync = function((bauble, wearer) {
    return false;
};
```

## onPlayerBaubleRender

此函数用于当饰品处于玩家的饰品栏时该如何渲染

目前只可进行简单的渲染,
具体的渲染方法请看 [BaubleRenderHelper](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/BaubleRenderHelper.md)

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) 饰品
* player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/) 佩戴饰品的玩家
* renderType as string 分别是 `HEAD` 和 `BODY`
* partialTicks as float

```zenscript
manaBaubleObj.onPlayerBaubleRender = function((stack, player, renderType, partialTicks) {
    
};
```
