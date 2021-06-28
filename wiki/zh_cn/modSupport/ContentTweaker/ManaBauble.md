# ManaRing

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的饰品  
因为 `ManaRing` 类继承 `ManaItem` 类所以 `ManaItem` 对象可用的所有功能也可用于 `ManaRing` 对象上 (**但是不会创建创造型戒指, 即使
hasCreative 为 true**)

## 导包

```zenscrtpt
import mods.randomtweaker.cote.ManaRing;
```

| 函数 | 写法 | 返回值 | 描述 |
|:--- |:------- |---- | ------|
| onWornTick | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | void | 佩戴戒指之后每 Tick 调用
| canEquip | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | bool | 确认戒指是否可以佩戴 |
| canUnequip | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | bool | 确认戒指是否可以取消佩戴 |
| onEquipped | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | void | 佩戴戒指时调用 |
| onUnequipped | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | void | 未佩戴时调用 |
| willAutoSync | function(bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), wearer as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)) | bool | 返回 true 为当 NBT 或 Damage 值发生了改变, 饰品会自动同步到客户端 (10 Tick 同步一次) |

## 例子

```zenscript
import mods.contenttweaker.VanillaFactory;
import crafttweaker.player.IPlayer;
import mods.randomtweaker.cote.ManaRing;

var manaRing as ManaRing = VanillaFactory.createManaRing("test_1", 500000);
manaRing.onWornTick = function(bauble, wearer) {
   if(wearer instanceof IPlayer) {
          var player as IPlayer = wearer;
          player.sendChat("1");
      }
};
manaRing.register();
```

## 本地化

本地化和物品的本地化方法一致