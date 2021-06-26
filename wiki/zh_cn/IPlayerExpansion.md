# IPlayer Expansion

扩展 `IPlayer` 类所以 `IPlayer` 对象可以使用以下字段或者 `Getter` 或者 `Setter` 或者 `Method`

## AstralSorcery

| 方法                        | 返回值   | 描述                                 |
| --------------------------- | :------- | ------------------------------------ |
| getPerkPercentToNextLevel() | float    | 获取星能力升到下一集需要多少经验     |
| getPerkLevel()              | int      | 获取星能力等级                       |
| getPerkExp()                | double   | 获取星能力经验值                     |
| modifyPerkExp()             | void     | 修改经验值（添加）                   |
| setPerkExp()                | void     | 设置经验值（不推荐）                 |
| getAttunedConstellation()   | string   | 获取星能力共鸣的星座，没有则返回Null |
| getKnownConstellations()    | string[] | 获取已学习的的星座                   |
| getSeenConstellations()     | string[] | 获取已看见的星座                     |

## FTBUltimine

| 方法                                | 返回值 |
| :---------------------------------- | :----- |
| isAllowFTBUltimine(isAllow as bool) | void   |

## MatterOverdrive

| 方法                                                               | 返回值   | 描述 |
| :---------------------------------------------------------------- | :------ |:----------------------------------- |
| isUnlocked(id as int, level as int) | bool | 获取对应id的技能是否达到等级 |
| getUnlockedLevel(id as int) | int | 获取对应id的技能等级 | 
| unlockSkill(id as int, @Optional level as int, @Optional admin as bool) | void    | 解锁对应id的技能的对应等级 (默认满级) , 设置admin为true将无视任何限制 (默认 false) |
| setAndroid(@Optional animation as bool) | void | 设置玩家为机器人, 设置animation为true将启用转变过程动画 (默认 false) |
| removeAndroid() | void | 移除玩家的机器人身份 |
| resetSkills(@Optional giveBackXP as bool) | void | 重置机器人所有技能,设置giveBackXP为true将返还升级消耗的经验 (默认 false) |
| receiveEnergy(energy as int) | int | 向机器人身份的玩家充能, 返回成功补充的能量值 |

| Getter       | 返回值    | 描述 |
| :----------- | :------ | :--------------------------------------------- |
| isAndroid    | bool | 判断玩家是否为机器人, true 为机器人 |
| isTurning    | bool | 判断玩家是否正在转变为机器人, true 为玩家正在播放转变动画 |
| energy       | int     | 返回玩家当前能量 |
| maxEnergy    | int     | 返回玩家能量上限 |

## TheBetweenLands

| 方法                                                         | 返回值  |
| :----------------------------------------------------------- | :------ |
| isCapBeNull()                                                | bool |
| addStats(decay as int, saturationModifier as float)                | void    |
| addCorrosionTooltips(lines as string[], advancedItemTooltips as bool) | void    |
| getDecayLevel()                                              | int     |
| getPrevDecayLevel()                                          | int     |
| addDecayAcceleration(acceleration as float)                     | void    |
| getSaturationLevel()                                         | float   |
| getAccelerationLevel()                                       | float   |
| setDecayLevel(decay as int)                                     | void    |
| setDecaySaturationLevel(saturation as float)                    | void    |

## ToughAsNails

方法                                   | 返回值  | 描述
| :------------------------------------ | :----- |:----------------------------------- 
| setThirst(thirst as int)                 | void   | 设置玩家的饮水值
| setHydration(hydration as float)         | void   | 设置玩家的饮水饱和度
| setExhaustion(exhaustion as float)       | void   | 设置玩家的疲惫值 (每 4.0F 减少一点饮水值)
| setTemperature(temp as int)              | void   | 设置玩家当前的温度值 (默认温度平衡数值为14)
| addStats(thirst as int, hydration as float) | void   | 增加玩家的饮水值和饮水饱和度
| addTemperature(temp as int)              | void   | 增加玩家的温度
| getThirst()                           | int    | 获取玩家当前饮水值
| getPlayerTarget()                     | int    | 获取玩家所处坐标的温度
| getTemperature()                      | int    | 获取玩家的温度
| getHydration()                        | float  | 获取玩家当前饮水饱和度
| getExhaustion()                       | float  | 获取玩家当前疲惫值

## Sanity

| 方法                                          | 返回值 | 描述                 |
| :-------------------------------------------- | :----- | -------------------- |
| getOriginalSanity()                           | int    | 获取原始理智值       |
| setOriginalSanity(originalSanity as int)         | void   | 修改玩家的原始理智值 |
| getSanity()                                   | float  | 获取现存理智值       |
| setSanity(sanity as float, playSound as bool)    | void   | 修改理智值           |
| updateSanity(sanity as float, playSound as bool) | void   | 更新理智值 (添加)   |
