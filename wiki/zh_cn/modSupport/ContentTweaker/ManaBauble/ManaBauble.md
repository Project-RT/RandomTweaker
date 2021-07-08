# ManaBauble

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的饰品  
因为 `ManaBauble` 类继承 `ManaItem` 类所以 `ManaItem` 可用的所有功能也可用于 `ManaBauble` 对象上 (**但是不会创建创造型饰品, 即使
hasCreative 为 true**)

## 导包

```zenscript
import mods.randomtweaker.cote.ManaBauble;
```

| 字段 | 类型 | 描述 |
|:--- | --- | ---- |
| useMana | bool | 除去 `RING` 和 `TRINKET` 类型的饰品此字段都有效果 |
| baubleType | string | 指定饰品的类型 (必须跟 WiKi 所写一致) , 有 `AMULET`, `RING`, `BELT`, `TRINKET`, `HEAD`, `BODY`, `CHARM`|

## 例子

```zenscript
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaBauble;
import crafttweaker.player.IPlayer;

var manaBauble as ManaBauble = VanillaFactory.createManaBauble("test_1", 500000);
manaBauble.onWornTick = function(bauble, wearer) {
   if(wearer instanceof IPlayer) {
          var player as IPlayer = wearer;
          player.sendChat("1");
      }
};
manaBauble.register();
```

## 本地化

本地化和 CoT 创建的物品的本地化方法一致