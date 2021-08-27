# ManaBauble

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的饰品, 因为 `ManaBauble`
类继承 [ManaItem](../ManaItem/ManaItem.md) 类所以 `ManaItem` 所有可用的功能也可用于 `ManaBauble` 上

## 导包

```zenscript
import mods.randomtweaker.cote.ManaBauble;
```

## 字段

| 字段 | 类型 | 描述 |
| :---- | :---- | :---- |
| baubleType | string | 指定饰品的类型 (必须一致, 默认为 `TRINKET`) , 有 `AMULET`, `RING`, `BELT`, `TRINKET`, `HEAD`, `BODY`, `CHARM` |

## 方法

| 方法 | 描述 |
| :---- | :---- |
| register() | 注册此魔力饰品 |

## 热重载

请安装 `ZenUtils` Mod

更多请看 [LateSetCoTFunction](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction)

```zenscript
#loader crafttweaker reloadableevents
import crafttweaker.player.IPlayer;

<cotItem:unlocalizedName>.onWornTick = function(bauble, wearer) {
   if(wearer instanceof IPlayer) {
        var player as IPlayer = wearer;
        player.sendChat("1");
    }
};
```

## 例子

```zenscript
#loader contenttweaker
import mods.randomtweaker.BaubleRenderHelper;
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaBauble;
import crafttweaker.player.IPlayer;

var manaBauble as ManaBauble = VanillaFactory.createManaBauble("test", "TRINKET", 500000);
manaBauble.onWornTick = function(bauble, wearer) {
   if(wearer instanceof IPlayer) {
        var player as IPlayer = wearer;
        player.sendChat("1");
    }
};
manaBauble.onPlayerBaubleRender = function(stack, player, renderType, partialTicks) {
    BaubleRenderHelper.bindTexture();
    if(renderType == "HEAD") {
        BaubleRenderHelper.translateToHeadLevel(player);
        BaubleRenderHelper.translateToFace();
        BaubleRenderHelper.defaultTransforms();
        BaubleRenderHelper.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        BaubleRenderHelper.scale(1.5, 1.5, 1);
        BaubleRenderHelper.translate(0, -0.05, 0);
        BaubleRenderHelper.renderItem(stack);
    }
};
manaBauble.register();
```

## 本地化

item.contenttweaker.物品ID.name
