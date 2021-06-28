# Sanity

一个理智值的检测, 会在副手的左侧显示理智值的图片, 分为四个等级去检测玩家的理智值并显现出不同的图片, 同时也添加了一个检测理智值的水晶物品, 配合 CrT 的事件功能,
你完全可以自定义各种想要的实现 (需要在配置文件开启)

更多请看 [IPlayerExpansion](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/IPlayerExpansion.md)

## 导包

~~~zenscript
import mods.randomtweaker.PlayerSanityChangeEvent;
~~~

## PlayerSanityChangeEvent

`PlayerSanityChangeEvent` 事件实现了以下接口, 所以他们的 `methods` `getters` `setters` 都可以被调用

[IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/)

| Getter  | 类型    |
| :------------- | :------ |
| player         | [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/) |
| sanity         | float   |
| originalSanity | int     |

你可以使用`events`关键字来访问这个事件

| 事件                                                         | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| onPlayerSanityChange(function(event as PlayerSanityChangeEvent) {}) | 当玩家的理智值被修改的时候触发 (原始理智值被修改不会被触发 ! ! !) |
