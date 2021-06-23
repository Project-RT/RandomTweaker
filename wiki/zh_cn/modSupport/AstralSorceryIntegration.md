# AstralSorcery Integration

## IPlayer Expansion

导包：

~~~zenscript
import crafttweaker.player.IPlayer;
~~~

| 方法                        | 返回值   | 描述                                 |
| --------------------------- | :------- | ------------------------------------ |
| getPerkPercentToNextLevel() | float    | 获取星能力升到下一集需要多少经验     |
| getPerkLevel()              | int      | 获取星能力等级                       |
| getPerkExp()                | double   | 获取星能力经验值                     |
| modifyPerkExp()             | void     | 修改经验值（添加）                   |
| setPerkExp()                | void     | 设置经验值（不推荐）                 |
| getAttunedConstellation()   | String   | 获取星能力共鸣的星座，没有则返回Null |
| getKnownConstellations()    | String[] | 获取已学习的的星座                   |
| getSeenConstellations()     | String[] | 获取已看见的星座                     |
