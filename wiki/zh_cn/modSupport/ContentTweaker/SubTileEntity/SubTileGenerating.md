# SubTileGenerating

因为 `SubTileGenerating`
类继承 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
类所以 `SubTileEntity` 所有可用的功能 `SubTileGenerating` 类都能用

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileGenerating;
```

## ZenProperty

请看 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)

| 字段 | 类型 | 描述 |
|:---- |:--- |----- |
| PassiveFlower | bool | 是否为被动产魔花 |
| valueForPassiveGeneration | int | 每 Tick 被动产出多少魔力 (受 `canGeneratePassively` 函数影响, 此函数返回 true 时产魔花才会就根据此字段的值进行被动产魔, 多提一嘴, 植魔已经帮你把产魔轮子搓好了，完全没必要在 `onUpdate` 函数内再写一遍产魔的轮，当然 ，特殊需求不在此提醒内。 |
| delayBetweenPassiveGeneration | int | 每 Tick 被动产魔后的冷却时间 |
| shouldSyncPassiveGeneration | bool | 被动产魔时是否同步 TileEntity |

## ZenMethod

| 方法 | 类型 | 描述 |
|:---- |:--- |----- |
| register() | void | 注册此产魔花 |

## 示例

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileGenerating;

var subTileGenerating as SubTileGenerating = VanillaFactory.createSubTileGenerating("test", 0xFFFFFF);
subTileGenerating.register();
```