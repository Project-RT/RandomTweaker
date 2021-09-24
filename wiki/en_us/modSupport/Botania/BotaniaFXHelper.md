# BotaniaFXHelper

Allow CraftTweaker to call the particles of the Botania library (This section is highly recommended
for players to test it by themselves)

[Specific implementation](https://github.com/Vazkii/Botania/tree/1.12-final) ->
vazkii.botania.client.core.proxy.ClientProxy

## Import

```zenscript
import mods.randomtweaker.botania.BotaniaFXHelper;
```

| Methods | Return Type | Description |
|:---- | :--- | :---- |
| setWispFXDistanceLimit(limit as bool) | void | ? |
| setWispFXDepthTest(depth as bool) | void | ? |
| setSparkleFXNoClip(noclip as bool) | void | Whether the particles can collide or not (default true) |
| setSparkleFXCorrupt(corrupt as bool) | void | ? |
| sparkleFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, m as int) | void | The parameters are explained below |
| sparkleFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, m as int, fake as bool) | void | `xyz` is the initial coordinate of the particle, `rgb` is the particle color (RGB format), `size` is the particle size, `m` is the particle duration (will be multiplied by 3), `fake` is whether the particle will disappear immediately |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float) | void | The parameters are explained below |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, gravity as float) | void | The parameters are explained below |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, gravity as float, maxAgeMul as float) | void | `gravity` is the velocity of the particle falling along the y-axis, the rest of the parameters are explained below |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, motionX as float, motionY as float, motionZ as float) | void | The parameters are explained below |
| wispFX(x as double, y as double, z as double, r as float, g as float, b as float, size as float, motionX as float, motionY as float, motionZ as float, maxAgeMul as float) | void | `xyz` is the initial particle coordinate, `rgb` is the color (RGB format), `size` is the particle size, `motionX` is the particle offset to the `x`-axis, `motionY` is the particle offset to the `y`-axis, `motionZ` is the particle offset to the `z`-axis, `maxAgeMul` is the particle duration (the actual particle duration is (28 / (Math.random() * 0.3 + 0.7) * maxAgeMul) rounded up) |
