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
| isBadEffectIn   | Boolean | 药水给予的是否是坏的效果    |
| isInstant       | Boolean | 药水是即刻生效的还是持续生效的 |
| shouldRender    | Boolean | 是否在背包栏渲染 |
| shouldRenderHUD | Boolean | 是否在HUD (在右上角) 渲染 |

贴图位置：`"contenttweaker:textures/gui/unlocalizedName.png"`  
**贴图必须是 18 * 18 大小**  
~~不要傻傻填 unlocalizedName~~

例子：

~~~zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Potion;

var potion as Potion = VanillaFactory.createPotion("lhhd", 0xF7D575);
potion.register();

~~~
