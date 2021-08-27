# PotionType (eg : 药水瓶, 药水箭)

使 CoT 可以创建类似药水瓶的药水

## 导包

```zenscript
import mods.randomtweaker.cote.PotionType;
```

| 字段 | 类型 | 描述 |
| :---- | :---- | :---- |
| unlocalizedName | string | 本地化键值 |
| duration | int | 持续时间 (单位 : Tick, 默认 3600 Tick) |
| amplifier | int | 药水等级 (默认 0) |
| potion | [Potion](Potion.md) | 指定药水 |

## 方法

| 方法 | 描述 |
| :---- | :---- |
| register() | 注册此 PotionType |

## 例子

```zenscript
#loader contenttweaker

import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.PotionType;

VanillaFactory.createPotionType("lhhdOne", potion).register();

var Two as PotionType = VanillaFactory.createPotionType("lhhdTwo", potion);
Two.setAmplifier(9600);
Two.register();

var Three as PotionType = VanillaFactory.createPotionType("lhhdThree", potion);
Three.setDuration(1800);
Three.setAmplifier(1);
Three.register();
```
