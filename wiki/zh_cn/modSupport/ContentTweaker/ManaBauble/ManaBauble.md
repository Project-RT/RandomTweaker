# ManaBauble

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的饰品  
因为 `ManaBauble` 类继承 [ManaItem](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaItem/ManaItem.md) 类所以 `ManaItem` 所有可用的功能也可用于 `ManaBauble` 上

## 导包

```zenscript
import mods.randomtweaker.cote.ManaBauble;
```

| 字段 | 类型 | 描述 |
|:--- | --- | ---- |
| useMana | bool | 除 `RING` 和 `TRINKET` 类型的饰品此字段都有效果, 另外如果饰品的魔力大于 0 仍然会返回 false |
| baubleType | string | 指定饰品的类型 (必须一致, 默认为 `RING`) , 有 `AMULET`, `RING`, `BELT`, `TRINKET`, `HEAD`, `BODY`, `CHARM`|

## 热重载

请安装 `ZenUtils` Mod

更多请看 [LateSetCoTFunction](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction)

```zenscript
#loader crafttweaker reloadableevents
<cotItem:unlocalizedName>.onWornTick = function((bauble, wearer) {
    if(wearer instanceof IPlayer) {
          var player as IPlayer = wearer;
          player.sendChat("1");
      }
};
```

## Method

| 方法 | 类型 | 描述 |
|:---- |:---- |---- |
| register() | void | 注册此魔力饰品 |

## 例子

```zenscript
#loader contenttweaker
import mods.randomtweaker.BaubleRenderHelper;
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaBauble;
import crafttweaker.player.IPlayer;

var manaBauble as ManaBauble = VanillaFactory.createManaBauble("test_1", 500000, "TRINKET");
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
