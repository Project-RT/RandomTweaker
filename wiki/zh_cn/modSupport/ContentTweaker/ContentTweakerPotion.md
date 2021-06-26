# ContentTweaker Expansion

使CoT可以创建简单的药水

## Potion

导包：

```zenscrtip
import mods.randomtweaker.cote.Potion;
```

| 字段            | 类型    | 描述                           |
| --------------- | :------ | ------------------------------ |
| liquidColorIn   | int     | 药水颜色                       |
| unlocalizedName | String  | 本地化键值                     |
| isBadEffectIn   | Boolean | 药水给予的是否是坏的效果       |
| isInstant       | Boolean | 药水是即刻生效的还是持续生效的 |
| shouldRender    | Boolean | 是否在背包栏渲染               |
| shouldRenderHUD | Boolean | 是否在HUD（右上角）渲染        |

贴图位置：`"contenttweaker:textures/gui/" + unlocalizedName + ".png"`

## PotionType (eg : 药水瓶， 药水箭)

导包：

```zenscript
import mods.randomtweaker.cote.PotionType;
```

| 字段            | 类型   | 描述                          |
| --------------- | :----- | ----------------------------- |
| unlocalizedName | String | 本地化键值                    |
| duration        | int    | 持续时间 （Tick，默认：3600） |
| amplifier       | int    | 药水等级 （默认 0）           |
| potion          | Potion | 指定药水                      |

---

例子：

~~~zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Potion;
import mods.randomtweaker.cote.PotionType;

var potion as Potion = VanillaFactory.createPotion("lhhd", 0xF7D575);
potion.register();

VanillaFactory.cretePotionType("lhhdOne", potion).register();

var Two as PotionType = VanillaFactory.cretePotionType("lhhdTwo", potion);
Two.setAmplifier(9600);
Two.register();

var Three as PotionType = VanillaFactory.cretePotionType("lhhdThree", potion);
Three.setDuration(1800);
Three.setAmplifier(1);
Three.register();
~~~
