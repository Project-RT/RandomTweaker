## PotionType (eg : 药水瓶, 药水箭)

使 CoT 可以创建类似药水瓶的药水

## 导包

```zenscript
import mods.randomtweaker.cote.PotionType;
```

| 字段            | 类型   | 描述                          |
| --------------- | :----- | --------------------------- |
| unlocalizedName | String | 本地化键值                    |
| duration        | int    | 持续时间 （Tick，默认：3600）   |
| amplifier       | int    | 药水等级 （默认 0）            |
| potion          | Potion | 指定药水                     |

~~~zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.PotionType;

VanillaFactory.cretePotionType("lhhdOne", potion).register();

var Two as PotionType = VanillaFactory.cretePotionType("lhhdTwo", potion);
Two.setAmplifier(9600);
Two.register();

var Three as PotionType = VanillaFactory.cretePotionType("lhhdThree", potion);
Three.setDuration(1800);
Three.setAmplifier(1);
Three.register();
~~~