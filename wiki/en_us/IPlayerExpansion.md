# IPlayer Expansion

Extend `IPlayer` so that the `IPlayer` object can use the following `Getter` or `Setter` or `Method`
.

## AstralSorcery

| Method | Return Type| Description |
| --------------------------- | :------- | :---------------- |
| getPerkPercentToNextLevel() | float    | How much experience is needed to get perk up to the next leve |
| getPerkLevel()              | int      | Get perk level |
| getPerkExp()                | double   | Get perk exp |
| modifyPerkExp()             | void     | Modify exp (add) |
| setPerkExp()                | void     | Set exp (not recommended) |
| getAttunedConstellation()   | string   | Get the constellations that have been attuned, or Return Type Null if there is none |
| getKnownConstellations()    | string[] | Get the constellations that have been known |
| getSeenConstellations()     | string[] | Get seen constellations |

## FTBUltimine

### Need to be enabled in the configuration file

| Method | Return Type | Description |
| :-------------------- | :-------------------- | :-------------------- |
| isAllowFTBUltimine(isAllow as bool) | void | Whether to allow players to use FTB Ultimine |

## MatterOverdrive

| Getter | Return Type | Description |
| :----------- | :--- | :---------------- |
| energy       | int  | Return the player's current energy |
| maxEnergy    | int  | Return the player's energy limit |
| isAndroid    | bool | Check if the player is Android |
| isTurning    | bool | Check if the player is turning into Android |

| Method | Return Type | Description |
| :----------------- | :----------------- | :----------------- |
| isUnlocked(id as int, level as int) | bool | Get whether the skill with the corresponding id has reached that level |
| getUnlockedLevel(id as int) | int | Get the skill level of the corresponding id |
| unlockSkill(id as int, @Optional level as int, @Optional admin as bool) | void| Unlock the skill corresponding to the id (default full level), set admin to true to ignore any restrictions (default false). |
| setAndroid(@Optional animation as bool) | void | 设置玩家为机器人, set animation to true 将启用转变过程动画 (default false) |
| removeAndroid() | void | Remove the player's Android status |
| resetSkills(@Optional giveBackXP as bool) | void | Reset all skills of the Android, set giveBackXP to true to Return the exp used for the upgrade (default false) |
| receiveEnergy(energy as int) | int | 向机器人身份的玩家充能, 返回成功补充的能量值 |

## TheBetweenLands

| Getter                                                       | Return Type |
| :----------------------------------------------------------- | :----- |
| isCapBeNull()                                                | bool   |
| addStats(decay as int, saturationModifier as float)          | void   |
| getDecayLevel()                                              | int    |
| getPrevDecayLevel()                                          | int    |
| addDecayAcceleration(acceleration as float)                  | void   |
| getSaturationLevel()                                         | float  |
| getAccelerationLevel()                                       | float  |
| setDecayLevel(decay as int)                                  | void   |
| setDecaySaturationLevel(saturation as float)                 | void   |
| addCorrosionTooltips(lines as string[], advancedItemTooltips as bool) | void |

## ToughAsNails

|Method                                    | Return Type | Description |
| :--------------------------------------- | :----- |:----------------------------------- |
| setThirst(thirst as int)                 | void   | 设置玩家的饮水值 |
| setHydration(hydration as float)         | void   | 设置玩家的饮水饱和度 |
| setExhaustion(exhaustion as float)       | void   | Set exhaustion value |
| setTemperature(temp as int)              | void   | Set temperature value (default is 14) |
| addTemperature(temp as int)              | void   | Add temperature |
| getThirst()                              | int    | 获取玩家当前饮水值 |
| getPlayerTarget()                        | int    | Get the temperature of the coordinates the player is at |
| getTemperature()                         | int    | Get temperature |
| getHydration()                           | float  | 获取玩家当前饮水饱和度 |
| getExhaustion()                          | float  | Get exhaustion value |
| addStats(thirst as int, hydration as float) | void | 增加玩家的饮水值和饮水饱和度 |

## Sanity

| Method                                        | Return Type | Description |
| :-------------------------------------------- | :----- | -------------------- |
| getOriginalSanity()                           | int    | Get original sanity value |
| setOriginalSanity(originalSanity as int)      | void   | Set original sanity value |
| getSanity()                                   | float  | Get sanity |
| setSanity(sanity as float, playSound as bool)    | void   | Set sanity |
| updateSanity(sanity as float, playSound as bool) | void   | Update sanity |

## Thaumcraft

| Method | Return Type | Description | Remark |
| :------------- | :------------- | :------------- | :------------- |
| giverDreamJournl() | void | Give player a DreamJournl | A new mysterious opening can be achieved by modifying the configuration file and overwriting the langkey |

## TheTwilightForest

| Method | Return Type | Description |
| :------------- | :------------- | :------------- |
| teleportPlayer() | void | Teleport player to Twilight |
