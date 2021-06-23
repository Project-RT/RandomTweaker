# ToughAsNails Integration

同交错纪元的支持，自行测试（

## IPlayer Expansion

导包：

```zenscript
import crafttweaker.player.IPlayer;
```

| 方法                                  | 返回值 |
| :------------------------------------ | :----- |
| setThirst(int thirst)                 | void   |
| setHydration(float hydration)         | void   |
| setExhaustion(float exhaustion)       | void   |
| addStats(int thirst, float hydration) | void   |
| getThirst()                           | int    |
| getHydration()                        | float  |
| getExhaustion()                       | float  |