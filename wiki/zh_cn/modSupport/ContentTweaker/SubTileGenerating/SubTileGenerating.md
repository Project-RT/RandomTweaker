# SubTileGenerating

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileGenerating;
```

## ZenProperty

| 字段 | 类型 | 描述 |
|:---- |:--- |----- |
| unlocalizedName | string | 未本地化名 |
| range | int | 产魔范围 |
| color | int | 产魔花的颜色 |
| maxMana | int | 最大魔力容量 |
| PassiveFlower | bool | 是否为被动产能花 |
| acceptsRedstone | bool | 是否接受红石信号 |
| valueForPassiveGeneration | int | 为被动产能花时每 Tick 产出多少魔力 |
| overgrowthAffected | bool | 是否受蕴魔土的影响 |
| delayBetweenPassiveGeneration | int | 为被动产魔花时每次工作的冷却 Tick |
| shouldSyncPassiveGeneration | bool | 被动产魔时是否同步 TileEntity (为被动产魔花才生效) |

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
