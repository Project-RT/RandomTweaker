# BotaniaFXHelper

允许CrT调用植魔库的粒子 (本章节内容十分推荐玩家自己上手测试一下)

[具体实现](https://github.com/Vazkii/Botania/tree/1.12-final) ->
vazkii.botania.client.core.proxy.ClientProxy

```zenscript
import mods.randomtweaker.botania.BotaniaFXHelper;
```

set 开头的方法貌似没有具体效果 (源码是有关联的但是实际游戏没看出效果)

| 方法 | 返回值 | 描述 |
|:---- | :--- | :---- |
| setWispFXDistanceLimit(limit as bool) | void | ? |
| setWispFXDepthTest(depth as bool) | void | ? |
| setSparkleFXNoClip(noclip as bool) | void | 粒子是否可以碰撞 (默认 true) |
| setSparkleFXCorrupt(corrupt as bool) | void | ? |
| sparkleFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, m as int) | void | 参数解析见下 |
| sparkleFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, m as int, fake as bool) | void | `xyz` 为粒子初始坐标, `rgb` 为粒子颜色 (RGB 格式), `size` 为粒子大小, `m` 为粒子持续时间 (会被乘于 3), `fake` 为粒子会不会立刻消失 |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float) | void | 参数解析见下 |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, gravity as float) | void | 参数解析见下 |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, gravity as float, maxAgeMul as float) | void | `gravity` 为粒子沿 y 轴下降的速度, 其余参数解析见下 |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, motionX as float, motionY as float, motionZ as float) | void | 参数解析见下 |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, motionX as float, motionY as float, motionZ as float, maxAgeMul as float) | void | `xyz` 为粒子初始坐标, `rgb` 为颜色 (RGB 格式), `size` 为粒子大小, `motionX` 为粒子往 `x` 轴偏移, `motionY` 为粒子往 `y` 轴偏移, `motionZ` 为粒子往 `z` 轴偏移, `maxAgeMul` 为粒子的持续时间 (实际粒子的持续时间为 (28 / (Math.random() * 0.3 + 0.7) * maxAgeMul) 再取整) |
