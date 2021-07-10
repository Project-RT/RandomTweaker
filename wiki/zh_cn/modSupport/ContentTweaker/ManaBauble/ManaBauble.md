# ManaBauble

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的饰品  
因为 `ManaBauble` 类继承 `ManaItem` 类所以 `ManaItem` 可用的所有功能也可用于 `ManaBauble` 对象上

## 导包

```zenscript
import mods.randomtweaker.cote.ManaBauble;
```

| 字段 | 类型 | 描述 |
|:--- | --- | ---- |
| useMana | bool | 除 `RING` 和 `TRINKET` 类型的饰品此字段都有效果, 另外如果饰品的魔力大于 0 仍然会返回 false |
| baubleType | string | 指定饰品的类型 (必须一致, 默认为 `RING`) , 有 `AMULET`, `RING`, `BELT`, `TRINKET`, `HEAD`, `BODY`, `CHARM`|

## 例子

```zenscript
import mods.randomtweaker.RenderHelper;
import mods.mods.contenttweaker.VanillaFactory;
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
    RenderHelper.bindTexture();
    if(renderType == "HEAD") {
        RenderHelper.translateToHeadLevel(player);
        RenderHelper.translateToFace();
        RenderHelper.defaultTransforms();
        RenderHelper.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.scale(1.5, 1.5, 1);
        RenderHelper.translate(0, -0.05, 0);
        RenderHelper.renderItem(stack);
    }
};
manaBauble.register();
```

## 本地化

本地化和 CoT 创建的物品的本地化方法一致
