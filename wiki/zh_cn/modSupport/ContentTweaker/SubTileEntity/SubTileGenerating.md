# SubTileGenerating

因为 `SubTileGenerating`
类继承 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
类所以 `SubTileEntity` 所有可用的功能 `SubTileGenerating` 类都能用

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileGenerating;
```

## ZenProperty

| 字段 | 类型 | 描述 |
|:---- |:--- |----- |
| PassiveFlower | bool | 是否为被动产魔花 |
| valueForPassiveGeneration | int | 为被动产魔花时每 Tick 产出多少魔力 |
| delayBetweenPassiveGeneration | int | 为被动产魔花时每次产魔后的冷却时间 (单位 : Tick) |
| shouldSyncPassiveGeneration | bool | 被动产魔时是否同步 TileEntity (为被动产魔花才生效) |

## ZenMethod

| 方法 | 类型 | 描述 |
|:---- |:--- |----- |
| register() | void | 注册此产魔花 |

## 本地化

`tile.botania:flower.产魔花的名字.name` 本地化产魔花的名字

`tile.botania:flower.产魔花的名字.reference` 本地化产魔花的 tooltip

## 示例

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileGenerating;

var subTileGenerating as SubTileGenerating = VanillaFactory.createSubTileGenerating("test", 0xFFFFFF);
subTileGenerating.register();
```
