# MatterOverdrive Integration

## IPlayer Expansion

导入：

```zenscript
import crafttweaker.player.IPlayer;
```

| 方法                                                               | 返回值   | 描述
| :---------------------------------------------------------------- | :------ |:----------------------------------- 
| isUnlocked(int id, int level)                                     | boolean | 获取对应id的技能是否达到等级
| getUnlockedLevel(int id)                                          | int     | 获取对应id的技能等级
| unlockSkill(int id, @Optional int level, @Optional boolean admin) | void    | 解锁对应id的技能的对应等级(默认满级),设置admin为true将无视任何限制(默认false)
| setAndroid(@Optional boolean animation)                           | void    | 设置玩家为机器人,设置animation为true将启用转变过程动画(默认false)
| removeAndroid()                                                   | void    | 移除玩家的机器人身份
| resetSkills(@Optional boolean giveBackXP)                         | void    | 重置机器人所有技能,设置giveBackXP为true将返还升级消耗的经验(默认false)
| receiveEnergy(int energy)                                         | int     | 向机器人身份的玩家充能,返回成功补充的能量值

| Getter       | 返回值    | 描述
| :----------- | :------ | :---------------------------------------------
| isAndroid    | boolean | 判断玩家是否为机器人,true为机器人
| isTurning    | boolean | 判断玩家是否正在转变为机器人,true为玩家正在播放转变动画
| getEnergy    | int     | 返回玩家当前能量
| getMaxEnergy | int     | 返回玩家能量上限

##**技能-id对照表**
| 技能名 | id | 内部名(无需使用) |
| :----- | :---- | :----
| 行走辅助 | 0  | step_assist
| 物品磁铁 | 1  | item_magnet
| 小地图 | 2  | minimap
| 无线充能 | 3  | wireless_charger
| 末影传送 | 4  | teleport
| 夜视 | 5  | nightvision
| 辟谷 | 6  | zero_calories
| 呼吸机 | 7  | oxygen
| 气囊 | 8  | floatation
| 超频 | 9  | speed
| 蓄力弹跳 | 10 | high_jump
| 凌空冲刺 | 11 | air_dash
| 惯性阻尼器 | 12 | inertial_dampers
| 时空均衡器 | 13 | equalizer
| 纳米机器人 | 14 | nanobots
| 伤害增强 | 15 | attack
| 超频冷却 | 16 | flash_cooling
| 音波震荡 | 17 | shockwave
| 纳米护甲 | 18 | nano_armor
| 粒子护盾 | 19 | shield
| 隐身斗篷 | 20 | cloak
| 紧急护盾 | 21 | auto_shield