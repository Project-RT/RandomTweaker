# ToughAsNails Integration

## IPlayer Expansion

导入：

```zenscript
import crafttweaker.player.IPlayer;
```

| 方法                                   | 返回值  | 描述                             
| :------------------------------------ | :----- |:----------------------------------- 
| setThirst(int thirst)                 | void   | 设置玩家的饮水值                        
| setHydration(float hydration)         | void   | 设置玩家的饮水饱和度                     
| setExhaustion(float exhaustion)       | void   | 设置玩家的疲惫值 (每4.0F减少一点饮水值)    
| setTemperature(int temp)              | void   | 设置玩家当前的温度值 (默认温度平衡数值为14) 
| addStats(int thirst, float hydration) | void   | 增加玩家的饮水值和饮水饱和度               
| addTemperature(int temp)              | void   | 增加玩家的温度                          
| getThirst()                           | int    | 获取玩家当前饮水值                       
| getPlayerTarget()                     | int    | 获取玩家所处坐标的温度                    
| getTemperature()                      | int    | 获取玩家的温度                          
| getHydration()                        | float  | 获取玩家当前饮水饱和度                   
| getExhaustion()                       | float  | 获取玩家当前疲惫值

## Config

### 你可以在config中设置的选项

* 当玩家变为机器人时,是否直接取消饮水值/温度值
* 检测机器人技能是否开启,若开启则取消饮水值/温度值