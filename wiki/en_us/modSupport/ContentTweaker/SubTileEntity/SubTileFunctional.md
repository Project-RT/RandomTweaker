# SubTileFunctional

因为 `SubTileFunctional`
类继承 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
类所以 `SubTileEntity` 所有可用的功能 `SubTileFunctional` 类都能用

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileFunctional;
```

## ZenProperty

请看 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)

## ZenMethod

| 方法 | 类型 | 描述 |
|:---- |:--- |----- |
| register() | void | 注册此功能花 |

## 本地化

`tile.botania:flower.产魔花的名字.name` 本地化产魔花的名字

`tile.botania:flower.产魔花的名字.reference` 本地化产魔花的 tooltip

## 示例

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileFunctional;

var subTileFunctional as SubTileFunctional = VanillaFactory.createSubTileFunctional("test_1", 0xFFFFFF);
subTileFunctional.register();
```
