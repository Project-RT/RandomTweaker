# Potion

使 CoT 可以创建简单的药水效果

## 导包

```zenscript
import mods.randomtweaker.cote.Potion;
```

| 字段 | 类型 | 描述 |
| ---- | :-- | --- |
| unlocalizedName | string | 注册名 |
| liquidColorIn | int | 药水颜色 |
| badEffectIn | bool | 药水给予的是否是坏的效果 |
| beneficial | bool | 药水对玩家是否有益，有益的药水会放在第一格 |
| instant | bool | 药水是即刻生效的还是持续生效的 (true 为即刻, false 为持续) |
| shouldRender | bool | 是否在背包栏渲染 |
| shouldRenderHUD | bool | 是否在 HUD (在右上角) 渲染 |

贴图位置 : `"contenttweaker:textures/gui/unlocalizedName.png"`  
**贴图必须是 18 * 18 大小**  
~~不要傻傻填 unlocalizedName~~

## 热重载

请安装 `ZenUtils` Mod

[事件热重载](https://github.com/friendlyhj/ZenUtils/wiki/ReloadEvents)
和 [CoT 函数热重载](https://github.com/friendlyhj/ZenUtils/wiki/LateSetCoTFunction) 都是此 Mod 提供的

```zenscript
#loader crafttweaker reloadableevents
<cotPotion:unlocalizedName>.isReady = function(duration, amplifier) {
	if (duration % 40 == 0) {
		return true;
	}
	return false;
};
```

## 例子

```zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Potion;
import mods.contenttweaker.Player;

var potion as Potion = VanillaFactory.createPotion("lhhd", 0xF7D575);
potion.isReady = function(duration, amplifier) {
	if (duration % 20 == 0) {
		return true;
	}
	return false;
};
potion.performEffect = function(living, amplifier) {
 	if(!living.world.remote && living instanceof Player) {
		var player as Player = living;
		player.sendChat("didiidid~~~");
	}
};
potion.register();
```
