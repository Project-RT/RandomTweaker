# Sanity

一个理智值的检测，会在副手的左侧显示理智值的图片，分为四个等级去检测玩家的理智值并显现出不同的图片，同时也添加了一个检测理智值的水晶物品，配合CrT的事件功能，你完全可以自定义各种想要的实现。（需要在配置文件开启）

## IPlayer Expansion

导包 ： 

~~~zenscript	
import crafttweaker.player.IPlayer;
~~~

| 方法                                          | 返回值 | 描述                 |
| :-------------------------------------------- | :----- | -------------------- |
| getOriginalSanity()                           | int    | 获取原始理智值       |
| setOriginalSanity(int originalSanity)         | void   | 修改玩家的原始理智值 |
| getSanity()                                   | float  | 获取现存理智值       |
| setSanity(float sanity, boolean playSound)    | void   | 修改理智值           |
| updateSanity(float sanity, boolean playSound) | void   | 更新理智值（添加）   |

## IEventManager Expansion

你可以使用`event`关键字来访问这个方法：

| 方法                                                         | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| onPlayerSanityChange(mods.randomtweaker.PlayerSanityChangeEvent) | 当玩家的理智值被修改的时候触发（原始理智值被修改不会被触发！！！） |

## PlayerSanityChangeEvent

`PlayerSanityChangeEvent` 事件实现了以下接口，所以他们的`methods` `getters` `setters`都可以被使用:

[IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/)

导包：

~~~zenscript
import mods.randomtweaker.PlayerSanityChangeEvent;
~~~

| **ZenGetter**  | 类型    |
| :------------- | :------ |
| player         | IPlayer |
| sanity         | float   |
| originalSanity | int     |
