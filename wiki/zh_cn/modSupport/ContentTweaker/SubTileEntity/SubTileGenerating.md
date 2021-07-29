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
| valueForPassiveGeneration | int | 每 Tick 被动产出多少魔力 (受 `canGeneratePassively` 函数影响, 主动产魔花是此函数返回 true 时就根据这个字段的值被动产魔, 而不是通过 `onUpdate` 函数产魔) |
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
