## Potion

使 CoT 可以创建简单的药水效果

## 导包

```zenscrtip
import mods.randomtweaker.cote.Potion;
```

| 字段            | 类型    | 描述                     |
| --------------- | :------ | ---------------------- |
| unlocalizedName | String | 本地化键值 |
| liquidColorIn   | int | 药水颜色 |
| badEffectIn   | Boolean | 药水给予的是否是坏的效果       |
| beneficial     | Boolean | 药水对玩家是否有益，有益的药水会放在第一格 |
| instant       | Boolean | 药水是即刻生效的还是持续生效的 |
| shouldRender    | Boolean | 是否在背包栏渲染 |
| shouldRenderHUD | Boolean | 是否在HUD (在右上角) 渲染 |

贴图位置：`"contenttweaker:textures/gui/unlocalizedName.png"`  
**贴图必须是 18 * 18 大小**  
~~不要傻傻填 unlocalizedName~~



| 函数          | 写法                                                    | 返回值  | 描述                                                      |
| ------------- | :------------------------------------------------------ | ------- | --------------------------------------------------------- |
| isReady       | function(duration as int, amplifier as int)             | void    | 配合参数运算可以决定在当前tick是否触发`performEffect`函数 |
| performEffect | function(living as IEntityLivingBase, amplifier as int) | Boolean | 药水每Tick都会执行此事件                                  |


~~~zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Potion;
import mods.contenttweaker.Player;

var potion as Potion = VanillaFactory.createPotion("lhhd", 0xF7D575);
potion.isReady = function(duration, amplifier){
	if (duration % 20 == 0){
		return true;
	}
	return false;
};
potion.performEffect = function(living, amplifier){
	if(!living.world.remote && living instanceof Player){
		var player as Player = living;
		player.sendChat("didiidid~~~");
	}
};
potion.register();
~~~

