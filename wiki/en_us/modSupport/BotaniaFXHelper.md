# BotaniaFXHelper

允许CrT调用植魔库的粒子 (本章节内容十分推荐玩家自己上手测试一下)<br />
[具体实现](https://github.com/Vazkii/Botania/tree/1.12-final) ->
vazkii.botania.client.core.proxy.ClientProxy

```zenscript
import mods.randomtweaker.botania.BotaniaFXHelper;
```

| 方法 | 返回值 |
|:------ | :---- |
| sparkleFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, m as int) | void |
| sparkleFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, m as int, fake as bool) | void |
| setWispFXDistanceLimit(limit as bool) | void |
| setWispFXDepthTest(depth as bool) | void |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float) | void |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, gravity as float) | void |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, gravity as float, maxAgeMul as float) | void |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, motionX as float, motionY as float, motionZ as float) | void |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, motionX as float, motionY as float, motionZ as float, maxAgeMul as float) | void |